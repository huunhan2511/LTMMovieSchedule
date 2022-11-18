/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import GUI.DetailFilmJPanel;
import GUI.LoadingJPanel;
import GUI.MovieScheduleJPanel;
import GUI.PanelListHourSchedule;
import GUI.PanelListScheduleMovie;
import Models.Film;
import Models.FilmsShowTime;
import Models.ShowTimeCinema;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import ltmmovieschedule.MovieSchedule;

/**
 *
 * @author huunh
 */
public class ClientThread extends Thread{
    private List<Film> listFilm;
    public static Socket socket;
    public static String message = "";

    public List<Film> getListFilm() {
        return listFilm;
    }
    private String publicKeyString = "";
    protected PublicKey publicKeyServer;
    private String keyAES = "";
    Scanner s = new Scanner(System.in);
    public ClientThread(Socket serverSocket){
        this.socket = serverSocket;
    }
    private String input(String title){
        System.out.println(title);
        return s.nextLine();
    }
    
    
    public void run() {
        boolean close = false;
        CipherInputStream cipherInp = null;
        
        //Start khai báo gửi chuỗi mã hóa cho server
        PrintWriter writer = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        //End khai báo gửi chuỗi mã hóa cho server
        
        //start khai báo gửi dữ liệu mã hóa server
        ObjectOutputStream objectOutputStream = null;
        CipherOutputStream cipherOutput = null;
        OutputStream out = null;
        // end khai báo gửi dữ liệu mã hóa cho server
        
        
        ObjectInputStream objectInputStream =null;
        
        InputStream input =null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferWriter =null;
        //Start random chuỗi mã khóa AES
        Random rnum = new Random();
        for(int i=0;i<16;i++){
            int random_int = (int) rnum.nextInt(9);
            keyAES += Integer.toString(random_int);
        }
        //End random chuỗi mã hóa AES
        
        //Start nhận public key từ server
        while(publicKeyString.equals("")){
            try{
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(inputStreamReader);
                publicKeyString = reader.readLine();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //End nhận public key từ server
        
        
            try{
                //Start gửi chuỗi mã hóa AES đã mã hóa bằng RSA cho server
                RSA rsa = new RSA();
                publicKeyServer = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(rsa.decode(publicKeyString)));
                rsa = new RSA(publicKeyServer);
                String encMessage = rsa.encrypt(keyAES);
                writer = new PrintWriter(socket.getOutputStream());
                writer.println(encMessage);
                writer.flush();
                //End gửi chuỗi mã hóa AES đã mã hóa bằng RSA cho server
                
                
                //Start đọc dữ liệu (list film) từ server gửi
                byte[] keyBytes = keyAES.getBytes(); 
                final byte[] ivBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 
                     0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f }; 

                final SecretKey key = new SecretKeySpec(keyBytes, "AES");
                final IvParameterSpec IV = new IvParameterSpec(ivBytes);
                final Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
                cipher.init(Cipher.DECRYPT_MODE, key, IV);
                input = socket.getInputStream();
                cipherInp = new CipherInputStream(input, cipher);
                objectInputStream = new ObjectInputStream(cipherInp);
                
                listFilm = new ArrayList<>();
                listFilm = (List<Film>) objectInputStream.readObject();
                
                System.out.println(listFilm.size()+"client thread");
                MovieScheduleJPanel.setListFilm(listFilm);
                new ltmmovieschedule.MovieSchedule().setVisible(true);
                //End đọc dữ liệu (list film) từ server gửi
                
                
                //Start vòng lặp gửi dữ liệu (tìm kiếm) cho server
                do{
                    out = socket.getOutputStream();
                    final Cipher cipherOut = Cipher.getInstance("AES/CFB8/NoPadding");
                    cipherOut.init(Cipher.ENCRYPT_MODE, key, IV);
                    cipherOutput = new CipherOutputStream(out, cipherOut);
                    
                    
                    while(!message.equals("")){
                        
                        outputStreamWriter = new OutputStreamWriter(cipherOutput);
                        bufferWriter = new BufferedWriter(outputStreamWriter);
                        System.out.println(message);
                        bufferWriter.write(message);
                        bufferWriter.newLine();
                        bufferWriter.flush();
                        if(message.equals("close")){
                            socket.close();
                            close = true;
                            break;
                        }
                        if(message.contains("?")){
                            objectInputStream = new ObjectInputStream(cipherInp);
                           
                            List<ShowTimeCinema> listShowTime = (List<ShowTimeCinema>) objectInputStream.readObject();
                            if(listShowTime.size()>=1){
                                DetailFilmJPanel.pnlSchedule.removeAll();
                                //DetailFilmJPanel.pnlSchedule.setLayout(new GridLayout(0, 1, 5, 5));
                                DetailFilmJPanel.pnlSchedule.setLayout(new BoxLayout(DetailFilmJPanel.pnlSchedule, BoxLayout.Y_AXIS));
                                listShowTime.forEach(item->{
                                    System.out.println(item);
                                    DetailFilmJPanel.pnlSchedule.add(new PanelListHourSchedule(item));
                                });
                                
                                DetailFilmJPanel.pnlSchedule.revalidate();
                                DetailFilmJPanel.pnlSchedule.repaint();
                            }else{
                                DetailFilmJPanel.pnlSchedule.removeAll();
                                DetailFilmJPanel.pnlSchedule.setLayout(new BorderLayout());
                                JLabel lblScheduel = new JLabel("Không có lịch chiếu");
                                lblScheduel.setForeground(Color.decode("#f1f1f1"));
                                lblScheduel.setFont(new Font("SansSerif", Font.PLAIN, 24));
                                lblScheduel.setHorizontalAlignment(JLabel.CENTER);
                                DetailFilmJPanel.pnlSchedule.add(lblScheduel);
                                DetailFilmJPanel.pnlSchedule.revalidate();
                                DetailFilmJPanel.pnlSchedule.repaint();
                            }
                            DetailFilmJPanel.waiting = false;
                            message = "";
                        } else if(message.contains(";")){
                            objectInputStream = new ObjectInputStream(cipherInp);
                           
                            List<FilmsShowTime> listFilmsShowTime = (List<FilmsShowTime>) objectInputStream.readObject();
                            if(listFilmsShowTime.size()>=1){
                                MovieScheduleJPanel.pnlListDateAdd.removeAll();
                                MovieScheduleJPanel.pnlListDateAdd.setLayout(new BoxLayout(MovieScheduleJPanel.pnlListDateAdd, BoxLayout.Y_AXIS));
                                
                                listFilmsShowTime.forEach(item->{
                                    try {
                                        System.out.println(item);
                                        MovieScheduleJPanel.pnlListDateAdd.add(new PanelListScheduleMovie(item));
                                    } catch (IOException ex) {
                                        Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                                
                                MovieScheduleJPanel.pnlListDateAdd.revalidate();
                                MovieScheduleJPanel.pnlListDateAdd.repaint();
                            }else{
                                MovieScheduleJPanel.pnlListDateAdd.removeAll();
                                MovieScheduleJPanel.pnlListDateAdd.setLayout(new BorderLayout());
                                JLabel lblScheduel = new JLabel("Không có lịch chiếu");
                                lblScheduel.setForeground(Color.decode("#f1f1f1"));
                                lblScheduel.setFont(new Font("SansSerif", Font.PLAIN, 24));
                                lblScheduel.setHorizontalAlignment(JLabel.CENTER);
                                MovieScheduleJPanel.pnlListDateAdd.add(lblScheduel);
                                MovieScheduleJPanel.pnlListDateAdd.revalidate();
                                MovieScheduleJPanel.pnlListDateAdd.repaint();
                            }
                            
                            MovieScheduleJPanel.waitingHome = false;
                            message = "";
                        } else {
                            objectInputStream = new ObjectInputStream(cipherInp);
                            Film detailFilm = (Film) objectInputStream.readObject();
                            try {
                                MovieSchedule.controller.setScreenDetailFilm(detailFilm);
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                }while(!close);
                //End vòng lặp gửi dữ liệu (tìm kiếm) cho server
            }catch(Exception e){
                System.out.println("Lỗi");
                System.out.println(e);
            }
        
    }
}
