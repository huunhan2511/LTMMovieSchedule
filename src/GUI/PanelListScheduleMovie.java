/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.FilmsShowTime;
import Models.ShowTimeCinema;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author huunh
 */
public class PanelListScheduleMovie extends javax.swing.JPanel {

    /**
     * Creates new form PanelDateSchedule
     */
    public PanelListScheduleMovie(FilmsShowTime filmsShowTime) throws IOException {
        initComponents();
        pnlMovie.setLayout(new BorderLayout());
        JPanel pnl = new JPanel();
        //String filmId, String graphicUrl, String title,String duration,String ratingFormat
        pnl.add(new GUI.PanelMovie(
                filmsShowTime.getApiFilmId(),
                filmsShowTime.getGraphicUrl(),
                filmsShowTime.getTitle(),
                filmsShowTime.getDuration(),
                filmsShowTime.getApiRatingFormat()));
        pnl.setBackground(Color.decode("#202020"));
        pnl.setPreferredSize(new Dimension(200,300));
        pnlMovie.add(pnl);
        
        pnlListHourSchedule.setLayout(new GridLayout(0,1,5,5));
        List<ShowTimeCinema> showTime = filmsShowTime.getShowTime();
        
        showTime.forEach(item-> {
            pnlListHourSchedule.add(new PanelListHourSchedule(item));
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMovie = new javax.swing.JPanel();
        pnlListHourSchedule = new javax.swing.JPanel();

        setBackground(new java.awt.Color(32, 32, 32));

        pnlMovie.setBackground(new java.awt.Color(32, 32, 32));
        pnlMovie.setPreferredSize(new java.awt.Dimension(200, 300));

        javax.swing.GroupLayout pnlMovieLayout = new javax.swing.GroupLayout(pnlMovie);
        pnlMovie.setLayout(pnlMovieLayout);
        pnlMovieLayout.setHorizontalGroup(
            pnlMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        pnlMovieLayout.setVerticalGroup(
            pnlMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        pnlListHourSchedule.setBackground(new java.awt.Color(32, 32, 32));
        pnlListHourSchedule.setAutoscrolls(true);
        pnlListHourSchedule.setPreferredSize(new java.awt.Dimension(1133, 100));

        javax.swing.GroupLayout pnlListHourScheduleLayout = new javax.swing.GroupLayout(pnlListHourSchedule);
        pnlListHourSchedule.setLayout(pnlListHourScheduleLayout);
        pnlListHourScheduleLayout.setHorizontalGroup(
            pnlListHourScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1133, Short.MAX_VALUE)
        );
        pnlListHourScheduleLayout.setVerticalGroup(
            pnlListHourScheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlListHourSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMovie, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlListHourSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlListHourSchedule;
    private javax.swing.JPanel pnlMovie;
    // End of variables declaration//GEN-END:variables
}
