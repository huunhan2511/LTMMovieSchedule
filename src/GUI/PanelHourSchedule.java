/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

/**
 *
 * @author huunh
 */
public class PanelHourSchedule extends javax.swing.JPanel {

    /**
     * Creates new form pnlHourSchedule
     */
    public PanelHourSchedule() {
        initComponents();
        setBorder(BorderFactory.createLineBorder(Color.decode("#ffffff")));
        lblHourSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHourSchedule = new javax.swing.JLabel();

        setBackground(new java.awt.Color(32, 32, 32));
        setMaximumSize(new java.awt.Dimension(120, 50));
        setMinimumSize(new java.awt.Dimension(120, 50));
        setPreferredSize(new java.awt.Dimension(120, 50));

        lblHourSchedule.setForeground(new java.awt.Color(255, 255, 255));
        lblHourSchedule.setText("10:30 - 12:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHourSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHourSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHourSchedule;
    // End of variables declaration//GEN-END:variables
}
