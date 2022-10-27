/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltm.filmdetail;

import javax.swing.ImageIcon;

/**
 *
 * @author phuon
 */
public class DetailFilm extends javax.swing.JFrame {

    /**
     * Creates new form DetailFilm
     */
    public DetailFilm() {
        initComponents();
        imgBackground.setIcon(new ImageIcon("C:\\Users\\phuon\\Downloads\\backgroundAvatar.jpg"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlGlobal = new javax.swing.JPanel();
        imgBackground = new javax.swing.JLabel();
        lblFilmCategorys = new javax.swing.JLabel();
        lblFilmName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaFilmContent = new javax.swing.JTextArea();
        lblIMDBText = new javax.swing.JLabel();
        lblIMDBValue = new javax.swing.JLabel();
        lblRottenTomatoesText = new javax.swing.JLabel();
        lblRottenTomatoesValue = new javax.swing.JLabel();
        lblMetacriticText = new javax.swing.JLabel();
        lblMetacriticValue = new javax.swing.JLabel();
        lblFilmActors = new javax.swing.JLabel();
        lblActorsName = new javax.swing.JLabel();
        lblReview = new javax.swing.JLabel();
        lblReviewTitle = new javax.swing.JLabel();
        lblReviewLink = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(1400, 2000));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1400, 1000));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1400, 1000));

        pnlGlobal.setBackground(new java.awt.Color(32, 32, 32));
        pnlGlobal.setMaximumSize(new java.awt.Dimension(1400, 1000));
        pnlGlobal.setPreferredSize(new java.awt.Dimension(1400, 1000));

        lblFilmCategorys.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblFilmCategorys.setForeground(new java.awt.Color(182, 182, 182));
        lblFilmCategorys.setText("Khoa học viễn tưởng, Phiêu lưu, Hành động, Viễn tưởng");

        lblFilmName.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblFilmName.setForeground(new java.awt.Color(255, 255, 255));
        lblFilmName.setText("Avatar");

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

        lblIMDBText.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblIMDBText.setForeground(new java.awt.Color(255, 255, 255));
        lblIMDBText.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblIMDBText.setText("IMDB : ");
        lblIMDBText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        lblFilmActors.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblFilmActors.setForeground(new java.awt.Color(255, 255, 255));
        lblFilmActors.setText("Diễn viên");

        lblActorsName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblActorsName.setForeground(new java.awt.Color(240, 240, 240));
        lblActorsName.setText("Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Long, Michelle Rodriguez, Giovanni Ribisi, ...");

        lblReview.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblReview.setForeground(new java.awt.Color(255, 255, 255));
        lblReview.setText("Review");

        lblReviewTitle.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblReviewTitle.setForeground(new java.awt.Color(240, 240, 240));
        lblReviewTitle.setText("Review phim Mười - Lời Nguyền Trở Lại: Hồi 3 bẻ cua khét lẹt, Chi Pu - Hồng Ánh tỏa sáng");

        lblReviewLink.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        lblReviewLink.setForeground(new java.awt.Color(0, 153, 255));
        lblReviewLink.setText("https://ww.yan.vn/review-phim-muoi-loi-nguyen-tro-lai-hoi-3-be-cua-khet-let-chi-pu-hong-anh-toa-sang-3140109.html");

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFilmActors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addComponent(lblReviewLink, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFilmName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFilmCategorys, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGlobalLayout.createSequentialGroup()
                        .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblActorsName, javax.swing.GroupLayout.PREFERRED_SIZE, 1311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReviewTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlGlobalLayout.createSequentialGroup()
                                .addComponent(lblIMDBText, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIMDBValue, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRottenTomatoesText, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRottenTomatoesValue, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(lblMetacriticText, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMetacriticValue, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(imgBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblFilmName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFilmCategorys, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIMDBText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIMDBValue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRottenTomatoesText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRottenTomatoesValue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMetacriticText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMetacriticValue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(lblFilmActors, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblActorsName)
                .addGap(42, 42, 42)
                .addComponent(lblReview, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReviewTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReviewLink)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pnlGlobal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetailFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailFilm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgBackground;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblActorsName;
    private javax.swing.JLabel lblFilmActors;
    private javax.swing.JLabel lblFilmCategorys;
    private javax.swing.JLabel lblFilmName;
    private javax.swing.JLabel lblIMDBText;
    private javax.swing.JLabel lblIMDBValue;
    private javax.swing.JLabel lblMetacriticText;
    private javax.swing.JLabel lblMetacriticValue;
    private javax.swing.JLabel lblReview;
    private javax.swing.JLabel lblReviewLink;
    private javax.swing.JLabel lblReviewTitle;
    private javax.swing.JLabel lblRottenTomatoesText;
    private javax.swing.JLabel lblRottenTomatoesValue;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JTextArea txtAreaFilmContent;
    // End of variables declaration//GEN-END:variables
}