/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Film;
import Socket.ClientThread;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author huunh
 */
public class MovieScheduleJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MovieScheduleJPanel
     */
    
    private int col = 6;
    private ArrayList<String> dayWeek;
   
    private static List<Film> listFilm = new ArrayList<>();
    
    public static void setListFilm(List<Film> listFilm){
        MovieScheduleJPanel.listFilm = listFilm;
    }
    public MovieScheduleJPanel() throws IOException {
        initComponents();
        pnlListMovie.setLayout(new GridLayout(0,col,10,5));
        lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
             
        // render list movie playing
        listFilm.forEach(item ->{
            try {
                JPanel pnl = new JPanel();
                pnl.add(new GUI.PanelMovie(item.getApiFilmId(),item.getGraphicUrl(),item.getTitle(),item.getDuration(),item.getApiRatingFormat()));
                pnl.setBackground(Color.getColor("#202020"));
                pnl.setMinimumSize(new Dimension(200,300));
                pnl.setSize(new Dimension(200,300));
                pnl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                pnlListMovie.add(pnl);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        
        dayWeek = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM");
        Date date = new Date();
        String today = dateFormat.format(date);
        dayWeek.add(today);
        Calendar cal = Calendar.getInstance();
        
        for(int i=1;i<7;i++){
            cal.add(Calendar.DATE, 1);
            Date todate = cal.getTime();  
            dayWeek.add(dateFormat.format(todate));
        }
        
        JLabel[] labels = {lblDate1,lblDate2,lblDate3,lblDate4,lblDate5,lblDate6,lblDate7};
        JPanel[] panels = {pnlDate1,pnlDate2,pnlDate3,pnlDate4,pnlDate5,pnlDate6,pnlDate7};
        for(int i=0;i<dayWeek.size();i++){
            labels[i].setText(dayWeek.get(i));
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panels[i].setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff"),1));
        }
        setScreen(pnlDate1, lblDate1);
    }
    public void setScreen(JPanel pnlItem,JLabel lblItem){
        lblItem.setForeground(Color.decode("#202020"));
        pnlItem.setBackground(Color.decode("#ffffff"));
    }
    public void setDefault(){
        JLabel[] labels = {lblDate1,lblDate2,lblDate3,lblDate4,lblDate5,lblDate6,lblDate7};
        JPanel[] panels = {pnlDate1,pnlDate2,pnlDate3,pnlDate4,pnlDate5,pnlDate6,pnlDate7};
        for(int i=0;i<labels.length;i++){
            labels[i].setForeground(Color.decode("#ffffff"));
            panels[i].setBackground(Color.decode("#202020"));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlListMoviePlaying = new javax.swing.JPanel();
        lblMoviePlaying = new javax.swing.JLabel();
        pnlListMovie = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();
        pnlListScheduleMovie = new javax.swing.JPanel();
        lblScheduleMovie = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        pnlCbxArea = new javax.swing.JPanel();
        pnlCbxTheater = new javax.swing.JPanel();
        lblTheater = new javax.swing.JLabel();
        lblCinema = new javax.swing.JLabel();
        pnlCbxCinema = new javax.swing.JPanel();
        pnlListDate = new javax.swing.JPanel();
        pnlDate1 = new javax.swing.JPanel();
        lblDate1 = new javax.swing.JLabel();
        pnlDate4 = new javax.swing.JPanel();
        lblDate4 = new javax.swing.JLabel();
        pnlDate5 = new javax.swing.JPanel();
        lblDate5 = new javax.swing.JLabel();
        pnlDate6 = new javax.swing.JPanel();
        lblDate6 = new javax.swing.JLabel();
        pnlDate7 = new javax.swing.JPanel();
        lblDate7 = new javax.swing.JLabel();
        pnlDate2 = new javax.swing.JPanel();
        lblDate2 = new javax.swing.JLabel();
        pnlDate3 = new javax.swing.JPanel();
        lblDate3 = new javax.swing.JLabel();
        pnlListDateSchedule = new javax.swing.JPanel();

        setBackground(new java.awt.Color(32, 32, 32));

        pnlMain.setBackground(new java.awt.Color(32, 32, 32));

        pnlListMoviePlaying.setBackground(new java.awt.Color(32, 32, 32));
        pnlListMoviePlaying.setPreferredSize(new java.awt.Dimension(1380, 400));

        lblMoviePlaying.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblMoviePlaying.setForeground(new java.awt.Color(255, 255, 255));
        lblMoviePlaying.setText("PHIM ??ANG CHI???U");

        pnlListMovie.setBackground(new java.awt.Color(32, 32, 32));
        pnlListMovie.setPreferredSize(new java.awt.Dimension(1380, 443));

        javax.swing.GroupLayout pnlListMovieLayout = new javax.swing.GroupLayout(pnlListMovie);
        pnlListMovie.setLayout(pnlListMovieLayout);
        pnlListMovieLayout.setHorizontalGroup(
            pnlListMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
        );
        pnlListMovieLayout.setVerticalGroup(
            pnlListMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );

        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlListMoviePlayingLayout = new javax.swing.GroupLayout(pnlListMoviePlaying);
        pnlListMoviePlaying.setLayout(pnlListMoviePlayingLayout);
        pnlListMoviePlayingLayout.setHorizontalGroup(
            pnlListMoviePlayingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListMoviePlayingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListMoviePlayingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListMoviePlayingLayout.createSequentialGroup()
                        .addComponent(pnlListMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(pnlListMoviePlayingLayout.createSequentialGroup()
                        .addComponent(lblMoviePlaying)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        pnlListMoviePlayingLayout.setVerticalGroup(
            pnlListMoviePlayingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListMoviePlayingLayout.createSequentialGroup()
                .addGroup(pnlListMoviePlayingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMoviePlaying, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlListMovie, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
        );

        pnlListScheduleMovie.setBackground(new java.awt.Color(32, 32, 32));
        pnlListScheduleMovie.setMaximumSize(new java.awt.Dimension(1380, 32767));
        pnlListScheduleMovie.setPreferredSize(new java.awt.Dimension(1380, 244));

        lblScheduleMovie.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblScheduleMovie.setForeground(new java.awt.Color(255, 255, 255));
        lblScheduleMovie.setText("L???CH CHI???U");

        lblArea.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblArea.setForeground(new java.awt.Color(255, 255, 255));
        lblArea.setText("?????a ??i???m : ");

        pnlCbxArea.setBackground(new java.awt.Color(32, 32, 32));
        pnlCbxArea.setMaximumSize(new java.awt.Dimension(1225, 32767));
        pnlCbxArea.setPreferredSize(new java.awt.Dimension(1225, 50));

        javax.swing.GroupLayout pnlCbxAreaLayout = new javax.swing.GroupLayout(pnlCbxArea);
        pnlCbxArea.setLayout(pnlCbxAreaLayout);
        pnlCbxAreaLayout.setHorizontalGroup(
            pnlCbxAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlCbxAreaLayout.setVerticalGroup(
            pnlCbxAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlCbxTheater.setBackground(new java.awt.Color(32, 32, 32));
        pnlCbxTheater.setMaximumSize(new java.awt.Dimension(1225, 32767));
        pnlCbxTheater.setPreferredSize(new java.awt.Dimension(1225, 50));

        javax.swing.GroupLayout pnlCbxTheaterLayout = new javax.swing.GroupLayout(pnlCbxTheater);
        pnlCbxTheater.setLayout(pnlCbxTheaterLayout);
        pnlCbxTheaterLayout.setHorizontalGroup(
            pnlCbxTheaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlCbxTheaterLayout.setVerticalGroup(
            pnlCbxTheaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblTheater.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTheater.setForeground(new java.awt.Color(255, 255, 255));
        lblTheater.setText("H??? th???ng r???p :");

        lblCinema.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCinema.setForeground(new java.awt.Color(255, 255, 255));
        lblCinema.setText("R???p :");

        pnlCbxCinema.setBackground(new java.awt.Color(32, 32, 32));
        pnlCbxCinema.setMaximumSize(new java.awt.Dimension(1225, 32767));
        pnlCbxCinema.setPreferredSize(new java.awt.Dimension(1225, 50));

        javax.swing.GroupLayout pnlCbxCinemaLayout = new javax.swing.GroupLayout(pnlCbxCinema);
        pnlCbxCinema.setLayout(pnlCbxCinemaLayout);
        pnlCbxCinemaLayout.setHorizontalGroup(
            pnlCbxCinemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        pnlCbxCinemaLayout.setVerticalGroup(
            pnlCbxCinemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlListDate.setBackground(new java.awt.Color(32, 32, 32));

        pnlDate1.setBackground(new java.awt.Color(32, 32, 32));
        pnlDate1.setMaximumSize(new java.awt.Dimension(120, 40));
        pnlDate1.setMinimumSize(new java.awt.Dimension(120, 40));

        lblDate1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDate1.setForeground(new java.awt.Color(255, 255, 255));
        lblDate1.setText("jLabel4");
        lblDate1.setMaximumSize(new java.awt.Dimension(120, 40));
        lblDate1.setMinimumSize(new java.awt.Dimension(120, 40));
        lblDate1.setPreferredSize(new java.awt.Dimension(120, 40));
        lblDate1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDate1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDate1Layout = new javax.swing.GroupLayout(pnlDate1);
        pnlDate1.setLayout(pnlDate1Layout);
        pnlDate1Layout.setHorizontalGroup(
            pnlDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDate1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlDate1Layout.setVerticalGroup(
            pnlDate1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlDate4.setBackground(new java.awt.Color(32, 32, 32));
        pnlDate4.setMaximumSize(new java.awt.Dimension(120, 40));
        pnlDate4.setMinimumSize(new java.awt.Dimension(120, 40));

        lblDate4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDate4.setForeground(new java.awt.Color(255, 255, 255));
        lblDate4.setText("jLabel3");
        lblDate4.setMaximumSize(new java.awt.Dimension(120, 40));
        lblDate4.setMinimumSize(new java.awt.Dimension(120, 40));
        lblDate4.setPreferredSize(new java.awt.Dimension(120, 40));
        lblDate4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDate4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDate4Layout = new javax.swing.GroupLayout(pnlDate4);
        pnlDate4.setLayout(pnlDate4Layout);
        pnlDate4Layout.setHorizontalGroup(
            pnlDate4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDate4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblDate4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlDate4Layout.setVerticalGroup(
            pnlDate4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDate4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlDate5.setBackground(new java.awt.Color(32, 32, 32));
        pnlDate5.setMaximumSize(new java.awt.Dimension(120, 40));
        pnlDate5.setMinimumSize(new java.awt.Dimension(120, 40));

        lblDate5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDate5.setForeground(new java.awt.Color(255, 255, 255));
        lblDate5.setText("jLabel6");
        lblDate5.setMaximumSize(new java.awt.Dimension(120, 40));
        lblDate5.setMinimumSize(new java.awt.Dimension(120, 40));
        lblDate5.setPreferredSize(new java.awt.Dimension(120, 40));
        lblDate5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDate5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDate5Layout = new javax.swing.GroupLayout(pnlDate5);
        pnlDate5.setLayout(pnlDate5Layout);
        pnlDate5Layout.setHorizontalGroup(
            pnlDate5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDate5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblDate5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlDate5Layout.setVerticalGroup(
            pnlDate5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDate5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlDate6.setBackground(new java.awt.Color(32, 32, 32));
        pnlDate6.setMaximumSize(new java.awt.Dimension(120, 40));
        pnlDate6.setMinimumSize(new java.awt.Dimension(120, 40));

        lblDate6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDate6.setForeground(new java.awt.Color(255, 255, 255));
        lblDate6.setText("jLabel7");
        lblDate6.setMaximumSize(new java.awt.Dimension(120, 40));
        lblDate6.setMinimumSize(new java.awt.Dimension(120, 40));
        lblDate6.setPreferredSize(new java.awt.Dimension(120, 40));
        lblDate6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDate6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDate6Layout = new javax.swing.GroupLayout(pnlDate6);
        pnlDate6.setLayout(pnlDate6Layout);
        pnlDate6Layout.setHorizontalGroup(
            pnlDate6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDate6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblDate6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlDate6Layout.setVerticalGroup(
            pnlDate6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDate6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlDate7.setBackground(new java.awt.Color(32, 32, 32));
        pnlDate7.setMaximumSize(new java.awt.Dimension(120, 40));
        pnlDate7.setMinimumSize(new java.awt.Dimension(120, 40));

        lblDate7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDate7.setForeground(new java.awt.Color(255, 255, 255));
        lblDate7.setText("jLabel5");
        lblDate7.setMaximumSize(new java.awt.Dimension(120, 40));
        lblDate7.setMinimumSize(new java.awt.Dimension(120, 40));
        lblDate7.setPreferredSize(new java.awt.Dimension(120, 40));
        lblDate7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDate7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDate7Layout = new javax.swing.GroupLayout(pnlDate7);
        pnlDate7.setLayout(pnlDate7Layout);
        pnlDate7Layout.setHorizontalGroup(
            pnlDate7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDate7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblDate7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlDate7Layout.setVerticalGroup(
            pnlDate7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDate7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlDate2.setBackground(new java.awt.Color(32, 32, 32));
        pnlDate2.setMaximumSize(new java.awt.Dimension(120, 40));
        pnlDate2.setMinimumSize(new java.awt.Dimension(120, 40));

        lblDate2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDate2.setForeground(new java.awt.Color(255, 255, 255));
        lblDate2.setText("jLabel1");
        lblDate2.setMaximumSize(new java.awt.Dimension(120, 40));
        lblDate2.setMinimumSize(new java.awt.Dimension(120, 40));
        lblDate2.setPreferredSize(new java.awt.Dimension(120, 40));
        lblDate2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDate2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDate2Layout = new javax.swing.GroupLayout(pnlDate2);
        pnlDate2.setLayout(pnlDate2Layout);
        pnlDate2Layout.setHorizontalGroup(
            pnlDate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDate2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlDate2Layout.setVerticalGroup(
            pnlDate2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlDate3.setBackground(new java.awt.Color(32, 32, 32));
        pnlDate3.setAlignmentX(0.0F);
        pnlDate3.setAlignmentY(0.0F);
        pnlDate3.setMaximumSize(new java.awt.Dimension(120, 40));
        pnlDate3.setMinimumSize(new java.awt.Dimension(120, 40));

        lblDate3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDate3.setForeground(new java.awt.Color(255, 255, 255));
        lblDate3.setText("jLabel2");
        lblDate3.setMaximumSize(new java.awt.Dimension(120, 40));
        lblDate3.setMinimumSize(new java.awt.Dimension(120, 40));
        lblDate3.setPreferredSize(new java.awt.Dimension(120, 40));
        lblDate3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDate3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDate3Layout = new javax.swing.GroupLayout(pnlDate3);
        pnlDate3.setLayout(pnlDate3Layout);
        pnlDate3Layout.setHorizontalGroup(
            pnlDate3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDate3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblDate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlDate3Layout.setVerticalGroup(
            pnlDate3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlListDateLayout = new javax.swing.GroupLayout(pnlListDate);
        pnlListDate.setLayout(pnlListDateLayout);
        pnlListDateLayout.setHorizontalGroup(
            pnlListDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListDateLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(pnlDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlDate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlDate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlDate5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlDate6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlDate7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        pnlListDateLayout.setVerticalGroup(
            pnlListDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListDateLayout.createSequentialGroup()
                .addGroup(pnlListDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDate7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDate6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDate5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pnlListDateSchedule.setBackground(new java.awt.Color(32, 32, 32));

        javax.swing.GroupLayout pnlListDateScheduleLayout = new javax.swing.GroupLayout(pnlListDateSchedule);
        pnlListDateSchedule.setLayout(pnlListDateScheduleLayout);
        pnlListDateScheduleLayout.setHorizontalGroup(
            pnlListDateScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlListDateScheduleLayout.setVerticalGroup(
            pnlListDateScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlListScheduleMovieLayout = new javax.swing.GroupLayout(pnlListScheduleMovie);
        pnlListScheduleMovie.setLayout(pnlListScheduleMovieLayout);
        pnlListScheduleMovieLayout.setHorizontalGroup(
            pnlListScheduleMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListScheduleMovieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListScheduleMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlListDateSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlListScheduleMovieLayout.createSequentialGroup()
                        .addGroup(pnlListScheduleMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblScheduleMovie)
                            .addGroup(pnlListScheduleMovieLayout.createSequentialGroup()
                                .addComponent(lblCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlCbxCinema, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE))
                            .addGroup(pnlListScheduleMovieLayout.createSequentialGroup()
                                .addComponent(lblTheater, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlCbxTheater, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE))
                            .addGroup(pnlListScheduleMovieLayout.createSequentialGroup()
                                .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(pnlCbxArea, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListScheduleMovieLayout.createSequentialGroup()
                        .addComponent(pnlListDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(73, 73, 73))))
        );
        pnlListScheduleMovieLayout.setVerticalGroup(
            pnlListScheduleMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListScheduleMovieLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScheduleMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlListScheduleMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCbxArea, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlListScheduleMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCbxTheater, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(lblTheater, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlListScheduleMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCbxCinema, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(lblCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlListDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlListDateSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlListMoviePlaying, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlListScheduleMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 1358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlListMoviePlaying, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlListScheduleMovie, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1427, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1182, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 18, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 18, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblDate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate1MouseClicked
        setDefault();
        setScreen(pnlDate1, lblDate1);
    }//GEN-LAST:event_lblDate1MouseClicked

    private void lblDate4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate4MouseClicked
        setDefault();
        setScreen(pnlDate4, lblDate4);
    }//GEN-LAST:event_lblDate4MouseClicked

    private void lblDate5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate5MouseClicked
        setDefault();
        setScreen(pnlDate5, lblDate5);
    }//GEN-LAST:event_lblDate5MouseClicked

    private void lblDate6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate6MouseClicked
        setDefault();
        setScreen(pnlDate6, lblDate6);
    }//GEN-LAST:event_lblDate6MouseClicked

    private void lblDate7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate7MouseClicked
        setDefault();
        setScreen(pnlDate7, lblDate7);
    }//GEN-LAST:event_lblDate7MouseClicked

    private void lblDate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate2MouseClicked
        setDefault();
        setScreen(pnlDate2, lblDate2);
    }//GEN-LAST:event_lblDate2MouseClicked

    private void lblDate3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate3MouseClicked
        setDefault();
        setScreen(pnlDate3, lblDate3);
    }//GEN-LAST:event_lblDate3MouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
            ClientThread.message = "close";
            System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCinema;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblDate2;
    private javax.swing.JLabel lblDate3;
    private javax.swing.JLabel lblDate4;
    private javax.swing.JLabel lblDate5;
    private javax.swing.JLabel lblDate6;
    private javax.swing.JLabel lblDate7;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMoviePlaying;
    private javax.swing.JLabel lblScheduleMovie;
    private javax.swing.JLabel lblTheater;
    private javax.swing.JPanel pnlCbxArea;
    private javax.swing.JPanel pnlCbxCinema;
    private javax.swing.JPanel pnlCbxTheater;
    private javax.swing.JPanel pnlDate1;
    private javax.swing.JPanel pnlDate2;
    private javax.swing.JPanel pnlDate3;
    private javax.swing.JPanel pnlDate4;
    private javax.swing.JPanel pnlDate5;
    private javax.swing.JPanel pnlDate6;
    private javax.swing.JPanel pnlDate7;
    private javax.swing.JPanel pnlListDate;
    private javax.swing.JPanel pnlListDateSchedule;
    private javax.swing.JPanel pnlListMovie;
    private javax.swing.JPanel pnlListMoviePlaying;
    private javax.swing.JPanel pnlListScheduleMovie;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}