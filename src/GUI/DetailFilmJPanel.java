/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Custom.SweetComboBox;
import Models.Cinema;
import Models.Cineplex;
import Models.Citi;
import Models.Film;
import Models.Review;
import Models.ShowTimeCinema;
import Socket.ClientThread;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import ltmmovieschedule.MovieSchedule;

/**
 *
 * @author huunh
 */
public class DetailFilmJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DetailFilmJPanel
     * @param pnlItem
     * @param lblItem
     */
    private ArrayList<String> dayWeek;
    private ArrayList<String> dayWeekFormatYYYYMMDD;
    private List<Object> listCineplex,listCinema,listCiti;
    private SweetComboBox cbxCineplex,cbxCiti,cbxCinema;
    private Film detailFilm;
    private String selectedDate;
    private int locationDate;
    public static JPanel pnlSchedule;
    public static Boolean waiting = false;
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
    public void setBanner(String link) throws MalformedURLException, IOException{
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(link);
                    BufferedImage c = ImageIO.read(url);
                    ImageIcon image = new ImageIcon(c);
                    Image fixImage = image.getImage().getScaledInstance(1315,470,java.awt.Image.SCALE_SMOOTH);
                    image = new ImageIcon(fixImage);
                    lblBanner.setIcon(image);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(DetailFilmJPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DetailFilmJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start();
        
    }
    public void setCursorAll(){
        lblTrailerLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblIMDBLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblRottenTomatoesLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    public void setDataComboboxCiti() throws FileNotFoundException, IOException{
        String urlCiti = "\\src\\Data\\citi.txt";
        String currentDirectory = System.getProperty("user.dir");
        String file = currentDirectory+urlCiti;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        listCiti = new ArrayList<>();
        while ((st = br.readLine()) != null){
            String[] line = st.split(";");
            if(line.length>1){
                Citi citi = new Citi(line[0],line[1]);
                listCiti.add(citi);
            }
        }
        cbxCiti = new SweetComboBox("#202020","#FFFFFF",0,0,1172,30,listCiti);   
        pnlCbxCiti.add(cbxCiti);
    }
    public void setDataComboboxCineplex() throws FileNotFoundException, IOException{
        String urlCiti = "\\src\\Data\\cineplex.txt";
        String currentDirectory = System.getProperty("user.dir");
        String file = currentDirectory+urlCiti;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        listCineplex = new ArrayList<>();
        while ((st = br.readLine()) != null){
            String[] line = st.split(";");
            if(line.length>1){
                Cineplex cineplex = new Cineplex(line[0],line[1]);
                listCineplex.add(cineplex);
            }
        }
        cbxCineplex = new SweetComboBox("#202020","#FFFFFF",0,0,1172,30,listCineplex);   
        pnlCbxTheater.add(cbxCineplex);
    }
    public void setDataComboboxCinema() throws FileNotFoundException, IOException{
        String urlCiti = "\\src\\Data\\cinema.txt";
        String currentDirectory = System.getProperty("user.dir");
        String file = currentDirectory+urlCiti;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        listCinema = new ArrayList<>();
        while ((st = br.readLine()) != null){
            String[] line = st.split(";");
            if(line.length>1){
                Cinema cinema = new Cinema(line[0],line[1],line[2],line[3]);
                listCinema.add(cinema);
            }
        }

    }
    public void sortComboboxCinema(String apiCityId, String cineplex){
        List<Object> listSortCinema = new ArrayList<>();
        for(int i = 0;i<listCinema.size();i++){
            Cinema cinema = (Cinema) listCinema.get(i);
            if(cinema.getApiCityId().equals(apiCityId) && cinema.getCineplex().equals(cineplex)){
                listSortCinema.add(cinema);
            }
        }
        cbxCinema = new SweetComboBox("#202020","#FFFFFF",0,0,1172,30,listSortCinema); 
        pnlCbxCinema1.removeAll();
        pnlCbxCinema1.add(cbxCinema);
        
    }
    public void setData(Film film){
        lblFilmName.setText(film.getTitle());
        lblFilmCategorys.setText(film.getApiGenreName());
        txtAreaFilmContent.setText(film.getSynopsisEn());
        String imdbValue = film.getApiImdb();
        if(imdbValue.equals("null")){
            lblIMDBValue.setText("---");
        }else{
            lblIMDBValue.setText(imdbValue);
        }
        String romatoesValue = film.getApiRottenTomatoes();
        if(romatoesValue.equals("null")){
            lblRottenTomatoesValue.setText("---");
        }else{
            lblRottenTomatoesValue.setText(romatoesValue);
        }
        String metacriticValue = film.getApiMetacritic();
        if(metacriticValue.equals("null")){
            lblMetacriticValue.setText("---");
        }else{
            lblMetacriticValue.setText(metacriticValue);
        }
        String director = film.getDirector();
        if(director.equals("null")){
            lblDirectorName.setText("");
        }else{
            lblDirectorName.setText(director);
        }
        lblActorsName.setText(film.getCasts());
        lblTrailerLink.setText(film.getTrailerUrl());
        lblIMDBLink.setText(film.getImdbLink());
        lblRottenTomatoesLink.setText(film.getRottenTomatoesLink());
        List<Review> listReview = film.getReviews();
        for(int i=0;i<listReview.size();i++){
            JPanel pnl = new JPanel();
            pnl.add(new GUI.PanelReview(listReview.get(i)));
            pnl.setBackground(Color.getColor("#202020"));
            pnl.setMinimumSize(new Dimension(1320,80));
            pnl.setSize(new Dimension(1320,80));
            pnlListReview.setLayout(new GridLayout(listReview.size(), 1,5,0));
            pnlListReview.add(pnl);
        }
    }
    public String setShowTime(Film film){
        //Idfilm?cineplex?idCinema?date
        String idFilm = film.getApiFilmId();
        Cineplex cineplex = (Cineplex) cbxCineplex.getSelectedItem();
        String idCineplex = cineplex.getId();
        Cinema cinema = (Cinema) cbxCinema.getSelectedItem();
        String idCinema = cinema.getApiCinemaId();
        return idFilm+"?"+idCineplex+"?"+idCinema+"?"+selectedDate;
    }
    public void setDateFormarYYYYMMDD(){
        dayWeekFormatYYYYMMDD = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        dayWeekFormatYYYYMMDD.add(today);
        Calendar cal = Calendar.getInstance();
        
        for(int i=1;i<7;i++){
            cal.add(Calendar.DATE, 1);
            Date todate = cal.getTime();  
            dayWeekFormatYYYYMMDD.add(dateFormat.format(todate));
        }
    }
    public void setLableDate(){
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
        setDateFormarYYYYMMDD();
        selectedDate = dayWeekFormatYYYYMMDD.get(dayWeek.indexOf(lblDate1.getText()));
        setScreen(pnlDate1, lblDate1);
    }
    
    public DetailFilmJPanel(Film detailFilm) throws IOException, InterruptedException {
        initComponents();
        pnlSchedule = pnlListDateSchedule;
        ClientThread.message="";
        this.detailFilm = detailFilm;
        
        setCursorAll();
        setBanner(detailFilm.getBannerUrl());
        setDataComboboxCiti();
        setDataComboboxCineplex();
        setDataComboboxCinema();
        setLableDate();
        Citi citi = (Citi) listCiti.get(0);
        Cineplex cineplex = (Cineplex) listCineplex.get(0);
        sortComboboxCinema(citi.getApiId(),cineplex.getId());
        setData(detailFilm);
        cbxCiti.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                Citi citi = (Citi) cbxCiti.getSelectedItem();
                Cineplex cineplex = (Cineplex) cbxCineplex.getSelectedItem();
                sortComboboxCinema(citi.getApiId(), cineplex.getId());
            }
        });
       
        cbxCineplex.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                Citi citi = (Citi) cbxCiti.getSelectedItem();
                Cineplex cineplex = (Cineplex) cbxCineplex.getSelectedItem();
                sortComboboxCinema(citi.getApiId(), cineplex.getId());
            }
        });
        JLabel lblFirst = new JLabel("Nhấn tìm kiếm tìm lịch chiếu phim");
        lblFirst.setForeground(Color.decode("#f1f1f1"));
        lblFirst.setFont(new Font("SansSerif", Font.PLAIN, 24));
        lblFirst.setHorizontalAlignment(JLabel.CENTER);
        pnlListDateSchedule.setLayout(new BorderLayout());
        pnlListDateSchedule.add(lblFirst);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGlobal = new javax.swing.JPanel();
        pnlBanner = new javax.swing.JPanel();
        lblBanner = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        pnlFilmInfomations = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaFilmContent = new javax.swing.JTextArea();
        lblFilmName = new javax.swing.JLabel();
        lblFilmCategorys = new javax.swing.JLabel();
        pnlFilmScores = new javax.swing.JPanel();
        lblIMDBValue = new javax.swing.JLabel();
        lblRottenTomatoesText = new javax.swing.JLabel();
        lblRottenTomatoesValue = new javax.swing.JLabel();
        lblMetacriticText = new javax.swing.JLabel();
        lblMetacriticValue = new javax.swing.JLabel();
        lblIMDBText = new javax.swing.JLabel();
        pnlFillmDirector = new javax.swing.JPanel();
        lblFilmDirector = new javax.swing.JLabel();
        lblDirectorName = new javax.swing.JLabel();
        pnlFilmTrailer = new javax.swing.JPanel();
        lblTrailer = new javax.swing.JLabel();
        lblTrailerLink = new javax.swing.JLabel();
        pnlFilmIMDB = new javax.swing.JPanel();
        lblIMDB = new javax.swing.JLabel();
        lblIMDBLink = new javax.swing.JLabel();
        pnlFilmRottenTomatoes = new javax.swing.JPanel();
        lblRottenTomatoes = new javax.swing.JLabel();
        lblRottenTomatoesLink = new javax.swing.JLabel();
        pnlFillmActors = new javax.swing.JPanel();
        lblFilmActors = new javax.swing.JLabel();
        lblActorsName = new javax.swing.JLabel();
        lblScheduleMovie = new javax.swing.JLabel();
        lblCinema = new javax.swing.JLabel();
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
        lblArea = new javax.swing.JLabel();
        pnlCbxCiti = new javax.swing.JPanel();
        lblTheater = new javax.swing.JLabel();
        pnlCbxTheater = new javax.swing.JPanel();
        pnlListDateSchedule = new javax.swing.JPanel();
        pnlCbxCinema1 = new javax.swing.JPanel();
        pnlSearch = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        pnlFilmReview = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlListReview = new javax.swing.JPanel();

        setBackground(new java.awt.Color(32, 32, 32));

        pnlGlobal.setBackground(new java.awt.Color(32, 32, 32));
        pnlGlobal.setMaximumSize(new java.awt.Dimension(1400, 1000));
        pnlGlobal.setPreferredSize(new java.awt.Dimension(1400, 1000));

        pnlBanner.setBackground(new java.awt.Color(32, 32, 32));

        javax.swing.GroupLayout pnlBannerLayout = new javax.swing.GroupLayout(pnlBanner);
        pnlBanner.setLayout(pnlBannerLayout);
        pnlBannerLayout.setHorizontalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBannerLayout.setVerticalGroup(
            pnlBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBanner, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );

        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        lblBack.setForeground(new java.awt.Color(255, 255, 255));
        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        pnlFilmInfomations.setBackground(new java.awt.Color(32, 32, 32));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        txtAreaFilmContent.setEditable(false);
        txtAreaFilmContent.setBackground(new java.awt.Color(32, 32, 32));
        txtAreaFilmContent.setColumns(20);
        txtAreaFilmContent.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAreaFilmContent.setForeground(new java.awt.Color(240, 240, 240));
        txtAreaFilmContent.setLineWrap(true);
        txtAreaFilmContent.setRows(5);
        txtAreaFilmContent.setText("Bộ phim Avatar là câu chuyện về người anh hùng \"bất đắc dĩ\" Jake Sully - một cựu sĩ quan thủy quân lục chiến bị liệt nửa thân. Anh được chọn để tham gia vào chương trình cấy gien với người ngoài hành tinh Na'vi nhằm tạo ra một giống loài mới có thể hít thở không khí tại hành tin Pandora. Giống người mới này được gọi là Avatar. Trong phim, sau khi đã trở thành mọt Avatar, Jake có nhiệm vụ đi tìm hiểu và nghiên cứu hành tinh Pandora. Những thông tin mà anh thu thập được rất có giá trị cho chiến dịch xâm chiếm hành tinh xanh thứ hai này của con người.\n\n");
        txtAreaFilmContent.setToolTipText("");
        txtAreaFilmContent.setWrapStyleWord(true);
        txtAreaFilmContent.setAutoscrolls(false);
        txtAreaFilmContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        txtAreaFilmContent.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtAreaFilmContent.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        txtAreaFilmContent.setFocusable(false);
        txtAreaFilmContent.setHighlighter(null);
        txtAreaFilmContent.setKeymap(null);
        txtAreaFilmContent.setMargin(new java.awt.Insets(20, 20, 20, 20));
        txtAreaFilmContent.setMaximumSize(new java.awt.Dimension(1200, 100));
        txtAreaFilmContent.setSelectionColor(new java.awt.Color(240, 240, 240));
        txtAreaFilmContent.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(txtAreaFilmContent);

        lblFilmName.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblFilmName.setForeground(new java.awt.Color(255, 255, 255));
        lblFilmName.setText("Avatar");

        lblFilmCategorys.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblFilmCategorys.setForeground(new java.awt.Color(182, 182, 182));
        lblFilmCategorys.setText("Khoa học viễn tưởng, Phiêu lưu, Hành động, Viễn tưởng");

        pnlFilmScores.setBackground(new java.awt.Color(32, 32, 32));

        lblIMDBValue.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblIMDBValue.setForeground(new java.awt.Color(255, 255, 255));
        lblIMDBValue.setText("7.8");
        lblIMDBValue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblRottenTomatoesText.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblRottenTomatoesText.setForeground(new java.awt.Color(255, 255, 255));
        lblRottenTomatoesText.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblRottenTomatoesText.setText("Rotten Tomatoes : ");
        lblRottenTomatoesText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblRottenTomatoesValue.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblRottenTomatoesValue.setForeground(new java.awt.Color(255, 255, 255));
        lblRottenTomatoesValue.setText("82%");
        lblRottenTomatoesValue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblMetacriticText.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblMetacriticText.setForeground(new java.awt.Color(255, 255, 255));
        lblMetacriticText.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblMetacriticText.setText("Metacritic : ");
        lblMetacriticText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblMetacriticValue.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblMetacriticValue.setForeground(new java.awt.Color(255, 255, 255));
        lblMetacriticValue.setText("83");
        lblMetacriticValue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblIMDBText.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblIMDBText.setForeground(new java.awt.Color(255, 255, 255));
        lblIMDBText.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblIMDBText.setText("IMDB : ");
        lblIMDBText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlFilmScoresLayout = new javax.swing.GroupLayout(pnlFilmScores);
        pnlFilmScores.setLayout(pnlFilmScoresLayout);
        pnlFilmScoresLayout.setHorizontalGroup(
            pnlFilmScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFilmScoresLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(lblIMDBText, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIMDBValue, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRottenTomatoesText, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRottenTomatoesValue, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblMetacriticText, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMetacriticValue, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        pnlFilmScoresLayout.setVerticalGroup(
            pnlFilmScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmScoresLayout.createSequentialGroup()
                .addGroup(pnlFilmScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIMDBValue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRottenTomatoesText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRottenTomatoesValue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMetacriticText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMetacriticValue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIMDBText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFillmDirector.setBackground(new java.awt.Color(32, 32, 32));
        pnlFillmDirector.setMaximumSize(new java.awt.Dimension(1320, 164));
        pnlFillmDirector.setPreferredSize(new java.awt.Dimension(1310, 164));

        lblFilmDirector.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblFilmDirector.setForeground(new java.awt.Color(255, 255, 255));
        lblFilmDirector.setText("Đạo diễn");

        lblDirectorName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblDirectorName.setForeground(new java.awt.Color(240, 240, 240));
        lblDirectorName.setText("Haozacstic");

        javax.swing.GroupLayout pnlFillmDirectorLayout = new javax.swing.GroupLayout(pnlFillmDirector);
        pnlFillmDirector.setLayout(pnlFillmDirectorLayout);
        pnlFillmDirectorLayout.setHorizontalGroup(
            pnlFillmDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFillmDirectorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFillmDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFilmDirector, javax.swing.GroupLayout.DEFAULT_SIZE, 1297, Short.MAX_VALUE)
                    .addComponent(lblDirectorName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFillmDirectorLayout.setVerticalGroup(
            pnlFillmDirectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFillmDirectorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblFilmDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDirectorName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFilmTrailer.setBackground(new java.awt.Color(32, 32, 32));

        lblTrailer.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTrailer.setForeground(new java.awt.Color(255, 255, 255));
        lblTrailer.setText("Trailer");

        lblTrailerLink.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblTrailerLink.setForeground(new java.awt.Color(0, 153, 255));
        lblTrailerLink.setText("https://ww.yan.vn/review-phim-muoi-loi-nguyen-tro-lai-hoi-3-be-cua-khet-let-chi-pu-hong-anh-toa-sang-3140109.html");
        lblTrailerLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTrailerLinkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlFilmTrailerLayout = new javax.swing.GroupLayout(pnlFilmTrailer);
        pnlFilmTrailer.setLayout(pnlFilmTrailerLayout);
        pnlFilmTrailerLayout.setHorizontalGroup(
            pnlFilmTrailerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmTrailerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFilmTrailerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTrailerLink, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlFilmTrailerLayout.setVerticalGroup(
            pnlFilmTrailerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmTrailerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrailerLink)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFilmIMDB.setBackground(new java.awt.Color(32, 32, 32));

        lblIMDB.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblIMDB.setForeground(new java.awt.Color(255, 255, 255));
        lblIMDB.setText("IMDB");

        lblIMDBLink.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblIMDBLink.setForeground(new java.awt.Color(0, 153, 255));
        lblIMDBLink.setText("https://ww.yan.vn/review-phim-muoi-loi-nguyen-tro-lai-hoi-3-be-cua-khet-let-chi-pu-hong-anh-toa-sang-3140109.html");
        lblIMDBLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIMDBLinkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlFilmIMDBLayout = new javax.swing.GroupLayout(pnlFilmIMDB);
        pnlFilmIMDB.setLayout(pnlFilmIMDBLayout);
        pnlFilmIMDBLayout.setHorizontalGroup(
            pnlFilmIMDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmIMDBLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFilmIMDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIMDB, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIMDBLink, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlFilmIMDBLayout.setVerticalGroup(
            pnlFilmIMDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmIMDBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIMDB, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIMDBLink)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFilmRottenTomatoes.setBackground(new java.awt.Color(32, 32, 32));

        lblRottenTomatoes.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblRottenTomatoes.setForeground(new java.awt.Color(255, 255, 255));
        lblRottenTomatoes.setText("Rotten Tomatoes");

        lblRottenTomatoesLink.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblRottenTomatoesLink.setForeground(new java.awt.Color(0, 153, 255));
        lblRottenTomatoesLink.setText("https://ww.yan.vn/review-phim-muoi-loi-nguyen-tro-lai-hoi-3-be-cua-khet-let-chi-pu-hong-anh-toa-sang-3140109.html");
        lblRottenTomatoesLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRottenTomatoesLinkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlFilmRottenTomatoesLayout = new javax.swing.GroupLayout(pnlFilmRottenTomatoes);
        pnlFilmRottenTomatoes.setLayout(pnlFilmRottenTomatoesLayout);
        pnlFilmRottenTomatoesLayout.setHorizontalGroup(
            pnlFilmRottenTomatoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmRottenTomatoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlFilmRottenTomatoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRottenTomatoes, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRottenTomatoesLink, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlFilmRottenTomatoesLayout.setVerticalGroup(
            pnlFilmRottenTomatoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmRottenTomatoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRottenTomatoes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRottenTomatoesLink)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFillmActors.setBackground(new java.awt.Color(32, 32, 32));
        pnlFillmActors.setMaximumSize(new java.awt.Dimension(1320, 164));
        pnlFillmActors.setPreferredSize(new java.awt.Dimension(1310, 164));

        lblFilmActors.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblFilmActors.setForeground(new java.awt.Color(255, 255, 255));
        lblFilmActors.setText("Diễn viên");

        lblActorsName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblActorsName.setForeground(new java.awt.Color(240, 240, 240));
        lblActorsName.setText("Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Long, Michelle Rodriguez, Giovanni Ribisi, ...");

        javax.swing.GroupLayout pnlFillmActorsLayout = new javax.swing.GroupLayout(pnlFillmActors);
        pnlFillmActors.setLayout(pnlFillmActorsLayout);
        pnlFillmActorsLayout.setHorizontalGroup(
            pnlFillmActorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFillmActorsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFillmActorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFilmActors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblActorsName, javax.swing.GroupLayout.DEFAULT_SIZE, 1297, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFillmActorsLayout.setVerticalGroup(
            pnlFillmActorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFillmActorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFilmActors, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblActorsName))
        );

        javax.swing.GroupLayout pnlFilmInfomationsLayout = new javax.swing.GroupLayout(pnlFilmInfomations);
        pnlFilmInfomations.setLayout(pnlFilmInfomationsLayout);
        pnlFilmInfomationsLayout.setHorizontalGroup(
            pnlFilmInfomationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmInfomationsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilmInfomationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFilmInfomationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblFilmCategorys, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
                        .addComponent(lblFilmName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlFilmInfomationsLayout.createSequentialGroup()
                .addGroup(pnlFilmInfomationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFilmScores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFillmDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 1317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFillmActors, javax.swing.GroupLayout.PREFERRED_SIZE, 1317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFilmTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFilmIMDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlFilmRottenTomatoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlFilmInfomationsLayout.setVerticalGroup(
            pnlFilmInfomationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmInfomationsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblFilmName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblFilmCategorys, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlFilmScores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFillmDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFillmActors, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlFilmTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFilmIMDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFilmRottenTomatoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblScheduleMovie.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblScheduleMovie.setForeground(new java.awt.Color(255, 255, 255));
        lblScheduleMovie.setText("LỊCH CHIẾU");

        lblCinema.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCinema.setForeground(new java.awt.Color(255, 255, 255));
        lblCinema.setText("Rạp :");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(pnlDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(pnlDate3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(pnlDate4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(pnlDate5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(pnlDate6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
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

        lblArea.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblArea.setForeground(new java.awt.Color(255, 255, 255));
        lblArea.setText("Địa điểm : ");

        pnlCbxCiti.setBackground(new java.awt.Color(32, 32, 32));
        pnlCbxCiti.setMaximumSize(new java.awt.Dimension(1225, 32767));
        pnlCbxCiti.setPreferredSize(new java.awt.Dimension(1225, 50));

        javax.swing.GroupLayout pnlCbxCitiLayout = new javax.swing.GroupLayout(pnlCbxCiti);
        pnlCbxCiti.setLayout(pnlCbxCitiLayout);
        pnlCbxCitiLayout.setHorizontalGroup(
            pnlCbxCitiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        pnlCbxCitiLayout.setVerticalGroup(
            pnlCbxCitiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        lblTheater.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTheater.setForeground(new java.awt.Color(255, 255, 255));
        lblTheater.setText("Hệ thống rạp :");

        pnlCbxTheater.setBackground(new java.awt.Color(32, 32, 32));
        pnlCbxTheater.setMaximumSize(new java.awt.Dimension(1225, 32767));
        pnlCbxTheater.setPreferredSize(new java.awt.Dimension(1225, 50));

        javax.swing.GroupLayout pnlCbxTheaterLayout = new javax.swing.GroupLayout(pnlCbxTheater);
        pnlCbxTheater.setLayout(pnlCbxTheaterLayout);
        pnlCbxTheaterLayout.setHorizontalGroup(
            pnlCbxTheaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        pnlCbxTheaterLayout.setVerticalGroup(
            pnlCbxTheaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        pnlListDateSchedule.setBackground(new java.awt.Color(32, 32, 32));
        pnlListDateSchedule.setPreferredSize(new java.awt.Dimension(1340, 420));

        javax.swing.GroupLayout pnlListDateScheduleLayout = new javax.swing.GroupLayout(pnlListDateSchedule);
        pnlListDateSchedule.setLayout(pnlListDateScheduleLayout);
        pnlListDateScheduleLayout.setHorizontalGroup(
            pnlListDateScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
        );
        pnlListDateScheduleLayout.setVerticalGroup(
            pnlListDateScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        pnlCbxCinema1.setBackground(new java.awt.Color(32, 32, 32));
        pnlCbxCinema1.setMaximumSize(new java.awt.Dimension(1225, 32767));
        pnlCbxCinema1.setPreferredSize(new java.awt.Dimension(1225, 50));

        javax.swing.GroupLayout pnlCbxCinema1Layout = new javax.swing.GroupLayout(pnlCbxCinema1);
        pnlCbxCinema1.setLayout(pnlCbxCinema1Layout);
        pnlCbxCinema1Layout.setHorizontalGroup(
            pnlCbxCinema1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        pnlCbxCinema1Layout.setVerticalGroup(
            pnlCbxCinema1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlSearch.setBackground(new java.awt.Color(32, 32, 32));
        pnlSearch.setMaximumSize(new java.awt.Dimension(120, 40));
        pnlSearch.setMinimumSize(new java.awt.Dimension(120, 40));

        lblSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setText("Tìm kiếm");
        lblSearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSearch.setMaximumSize(new java.awt.Dimension(120, 40));
        lblSearch.setMinimumSize(new java.awt.Dimension(120, 40));
        lblSearch.setPreferredSize(new java.awt.Dimension(120, 40));
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSearchMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1292, Short.MAX_VALUE)
            .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSearchLayout.createSequentialGroup()
                    .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 1282, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
            .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pnlBanner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlGlobalLayout.createSequentialGroup()
                                    .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1225, 1225, 1225)
                                    .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlGlobalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(pnlFilmInfomations, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlGlobalLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lblScheduleMovie))
                            .addGroup(pnlGlobalLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                                        .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblArea)
                                            .addComponent(lblTheater)
                                            .addComponent(lblCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pnlCbxTheater, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pnlCbxCiti, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pnlCbxCinema1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(pnlListDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlobalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlListDateSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addComponent(pnlBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFilmInfomations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(lblScheduleMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlListDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlCbxCiti, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlCbxTheater, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlGlobalLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblTheater, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlCbxCinema1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addGap(64, 64, 64))
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlListDateSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addGap(87, 87, 87))
        );

        pnlFilmReview.setBackground(new java.awt.Color(32, 32, 32));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Review");

        pnlListReview.setBackground(new java.awt.Color(32, 32, 32));

        javax.swing.GroupLayout pnlListReviewLayout = new javax.swing.GroupLayout(pnlListReview);
        pnlListReview.setLayout(pnlListReviewLayout);
        pnlListReviewLayout.setHorizontalGroup(
            pnlListReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlListReviewLayout.setVerticalGroup(
            pnlListReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFilmReviewLayout = new javax.swing.GroupLayout(pnlFilmReview);
        pnlFilmReview.setLayout(pnlFilmReviewLayout);
        pnlFilmReviewLayout.setHorizontalGroup(
            pnlFilmReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmReviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFilmReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1361, Short.MAX_VALUE)
                    .addComponent(pnlListReview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFilmReviewLayout.setVerticalGroup(
            pnlFilmReviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFilmReviewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlListReview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGlobal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1410, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlFilmReview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, 1986, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFilmReview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
            ClientThread.message = "close";
            System.exit(0);
        
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblDate1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate1MouseClicked
        setDefault();
        setScreen(pnlDate1, lblDate1);
        selectedDate = dayWeekFormatYYYYMMDD.get(dayWeek.indexOf(lblDate1.getText()));
    }//GEN-LAST:event_lblDate1MouseClicked

    private void lblDate4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate4MouseClicked
        setDefault();
        setScreen(pnlDate4, lblDate4);
        selectedDate = dayWeekFormatYYYYMMDD.get(dayWeek.indexOf(lblDate4.getText()));
    }//GEN-LAST:event_lblDate4MouseClicked

    private void lblDate5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate5MouseClicked
        setDefault();
        setScreen(pnlDate5, lblDate5);
        selectedDate = dayWeekFormatYYYYMMDD.get(dayWeek.indexOf(lblDate5.getText()));
    }//GEN-LAST:event_lblDate5MouseClicked

    private void lblDate6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate6MouseClicked
        setDefault();
        setScreen(pnlDate6, lblDate6);
        selectedDate = dayWeekFormatYYYYMMDD.get(dayWeek.indexOf(lblDate6.getText()));
    }//GEN-LAST:event_lblDate6MouseClicked

    private void lblDate7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate7MouseClicked
        setDefault();
        setScreen(pnlDate7, lblDate7);
        selectedDate = dayWeekFormatYYYYMMDD.get(dayWeek.indexOf(lblDate7.getText()));
    }//GEN-LAST:event_lblDate7MouseClicked

    private void lblDate2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate2MouseClicked
        setDefault();
        setScreen(pnlDate2, lblDate2);
        selectedDate = dayWeekFormatYYYYMMDD.get(dayWeek.indexOf(lblDate2.getText()));
    }//GEN-LAST:event_lblDate2MouseClicked

    private void lblDate3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDate3MouseClicked
        setDefault();
        setScreen(pnlDate3, lblDate3);
        selectedDate = dayWeekFormatYYYYMMDD.get(dayWeek.indexOf(lblDate3.getText()));
    }//GEN-LAST:event_lblDate3MouseClicked

    private void lblSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMousePressed
        lblSearch.setForeground(Color.decode("#ffffff"));
         pnlSearch.setBackground(Color.decode("#202020"));
    }//GEN-LAST:event_lblSearchMousePressed

    private void lblTrailerLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrailerLinkMouseClicked
        //clickLink("https://google.com", lblTrailerLink);
        if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI(detailFilm.getTrailerUrl());
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
        }
    }//GEN-LAST:event_lblTrailerLinkMouseClicked

    private void lblIMDBLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIMDBLinkMouseClicked
        if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI(detailFilm.getImdbLink());
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
        }
    }//GEN-LAST:event_lblIMDBLinkMouseClicked

    private void lblRottenTomatoesLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRottenTomatoesLinkMouseClicked
        if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    URI uri = new URI(detailFilm.getRottenTomatoesLink());
                    desktop.browse(uri);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
        }
    }//GEN-LAST:event_lblRottenTomatoesLinkMouseClicked

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        if(!waiting){  
            waiting = true;
            pnlSchedule.removeAll();
            JPanel FixedPanel = new JPanel(new GridBagLayout());
            FixedPanel.setPreferredSize(pnlSchedule.getSize());
            FixedPanel.setBackground(Color.decode("#202020"));
            FixedPanel.removeAll();
            JPanel pnl = new GUI.Custom.Loading();
            pnl.setPreferredSize(new Dimension(200,200));
            FixedPanel.add(pnl);
            pnlSchedule.add(FixedPanel);
            pnlSchedule.revalidate();
            pnlSchedule.repaint();
            ClientThread.message = setShowTime(detailFilm);
        }
    }//GEN-LAST:event_lblSearchMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        try {
            MovieSchedule.controller.setScreenMovieSchedule();
        } catch (IOException ex) {
            Logger.getLogger(DetailFilmJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblBackMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblActorsName;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBanner;
    private javax.swing.JLabel lblCinema;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblDate2;
    private javax.swing.JLabel lblDate3;
    private javax.swing.JLabel lblDate4;
    private javax.swing.JLabel lblDate5;
    private javax.swing.JLabel lblDate6;
    private javax.swing.JLabel lblDate7;
    private javax.swing.JLabel lblDirectorName;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblFilmActors;
    private javax.swing.JLabel lblFilmCategorys;
    private javax.swing.JLabel lblFilmDirector;
    private javax.swing.JLabel lblFilmName;
    private javax.swing.JLabel lblIMDB;
    private javax.swing.JLabel lblIMDBLink;
    private javax.swing.JLabel lblIMDBText;
    private javax.swing.JLabel lblIMDBValue;
    private javax.swing.JLabel lblMetacriticText;
    private javax.swing.JLabel lblMetacriticValue;
    private javax.swing.JLabel lblRottenTomatoes;
    private javax.swing.JLabel lblRottenTomatoesLink;
    private javax.swing.JLabel lblRottenTomatoesText;
    private javax.swing.JLabel lblRottenTomatoesValue;
    private javax.swing.JLabel lblScheduleMovie;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTheater;
    private javax.swing.JLabel lblTrailer;
    private javax.swing.JLabel lblTrailerLink;
    private javax.swing.JPanel pnlBanner;
    private javax.swing.JPanel pnlCbxCinema1;
    private javax.swing.JPanel pnlCbxCiti;
    private javax.swing.JPanel pnlCbxTheater;
    private javax.swing.JPanel pnlDate1;
    private javax.swing.JPanel pnlDate2;
    private javax.swing.JPanel pnlDate3;
    private javax.swing.JPanel pnlDate4;
    private javax.swing.JPanel pnlDate5;
    private javax.swing.JPanel pnlDate6;
    private javax.swing.JPanel pnlDate7;
    private javax.swing.JPanel pnlFillmActors;
    private javax.swing.JPanel pnlFillmDirector;
    private javax.swing.JPanel pnlFilmIMDB;
    private javax.swing.JPanel pnlFilmInfomations;
    private javax.swing.JPanel pnlFilmReview;
    private javax.swing.JPanel pnlFilmRottenTomatoes;
    private javax.swing.JPanel pnlFilmScores;
    private javax.swing.JPanel pnlFilmTrailer;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JPanel pnlListDate;
    private javax.swing.JPanel pnlListDateSchedule;
    private javax.swing.JPanel pnlListReview;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTextArea txtAreaFilmContent;
    // End of variables declaration//GEN-END:variables
}
