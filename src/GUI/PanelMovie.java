/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Film;
import Socket.ClientThread;
import controller.changeScreenController;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import ltmmovieschedule.MovieSchedule;

/**
 *
 * @author huunh
 */
public class PanelMovie extends javax.swing.JPanel {

    /**
     * Creates new form PanelMovie
     */
    private Film film;
    public PanelMovie(Film film) throws IOException {
        initComponents();
        this.film = film;
        setData();
    }
    public void setData() throws MalformedURLException, IOException{
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(film.getGraphicUrl());
                    BufferedImage c = ImageIO.read(url);
                    ImageIcon image = new ImageIcon(c);
                    Image fixImage = image.getImage().getScaledInstance(200, 225, java.awt.Image.SCALE_SMOOTH);
                    image = new ImageIcon(fixImage);
                    lblImage.setIcon(image);
                } catch (MalformedURLException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        thread.start();
        
        lblNameMovie.setText(film.getTitle());
        lblDescription.setText(film.getDuration() + " - " + film.getApiRatingFormat());
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        lblNameMovie = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();

        setBackground(new java.awt.Color(32, 32, 32));
        setMaximumSize(new java.awt.Dimension(200, 300));
        setMinimumSize(new java.awt.Dimension(200, 300));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(200, 300));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblImage.setMaximumSize(new java.awt.Dimension(170, 190));
        lblImage.setMinimumSize(new java.awt.Dimension(170, 190));
        lblImage.setPreferredSize(new java.awt.Dimension(170, 190));

        lblNameMovie.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNameMovie.setForeground(new java.awt.Color(255, 255, 255));
        lblNameMovie.setText("jLabel3");

        lblDescription.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(182, 182, 182));
        lblDescription.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription)
                    .addComponent(lblNameMovie))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblDescription)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//        try {
//            MovieSchedule.controller.setScreenDetailFilm(film);
//        } catch (IOException ex) {
//            Logger.getLogger(PanelMovie.class.getName()).log(Level.SEVERE, null, ex);
//        }
        ClientThread.message = film.getApiFilmId();
        MovieSchedule.controller.setLoading();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNameMovie;
    // End of variables declaration//GEN-END:variables
}
