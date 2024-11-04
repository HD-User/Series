package Main;

import java.awt.Toolkit;

public class Filter extends javax.swing.JFrame {
    GUI gui;
    public Filter(GUI gui) {
        initComponents();
        this.gui = gui;
        cmbProgress.setSelectedItem(gui.filterProgress);
        cmbStatus.setSelectedItem(gui.filterStatus);
        scrollbar1.setValue(gui.filterRating);
        if(scrollbar1.getValue() == 0){jLabel1.setText("None");}
        else{jLabel1.setText(String.valueOf(scrollbar1.getValue() - 1));}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbStatus = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        scrollbar1 = new java.awt.Scrollbar();
        label3 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        cmbProgress = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setTitle("Filter");
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/filter.png")));
        setMaximumSize(new java.awt.Dimension(450, 250));
        setMinimumSize(new java.awt.Dimension(450, 250));
        setPreferredSize(new java.awt.Dimension(450, 250));
        setResizable(false);

        cmbStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Watched", "Planning to Watch", "Watching", "To be Continued", "Leave in Half", "Watch Later", "Can't Watch" }));

        label1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label1.setText("Rating:");

        label2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label2.setText("Watch Status:");

        scrollbar1.setMaximum(12);
        scrollbar1.setOrientation(0);
        scrollbar1.setVisibleAmount(1);
        scrollbar1.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                ratingShow(evt);
            }
        });

        label3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label3.setText("Progressivity:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("None");

        cmbProgress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbProgress.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "true", "false" }));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProgress, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbStatus)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbProgress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void ratingShow(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_ratingShow
        if(scrollbar1.getValue() == 0){jLabel1.setText("None");}
        else{jLabel1.setText(String.valueOf(scrollbar1.getValue() - 1));}
    }//GEN-LAST:event_ratingShow
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String q = "select * from Database.Series where ";
        if(! cmbProgress.getSelectedItem().equals("None")){q += "Progressivity = " + (String)cmbProgress.getSelectedItem();}
        if(! cmbStatus.getSelectedItem().equals("None")){
            if(! q.equals("select * from Database.Series where ")){q += " and ";}
            q += "WatchStatus = \"" + (String)cmbStatus.getSelectedItem() + "\"";
        }
        if(scrollbar1.getValue() != 0){
            if(! q.equals("select * from Database.Series where ")){q += " and ";}
            q += "Rating = " + String.valueOf(scrollbar1.getValue() - 1);
        }
        q += " order by Rating asc limit 99999";
        if(scrollbar1.getValue() == 0  &&
                cmbStatus.getSelectedItem().equals("None") &&
                cmbProgress.getSelectedItem().equals("None")){
            q = gui.standartQ;
        }
        gui.q = q;
        gui.filterProgress = (String)cmbProgress.getSelectedItem();
        gui.filterStatus = (String)cmbStatus.getSelectedItem();
        gui.filterRating = scrollbar1.getValue();
        gui.renewList();
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[], GUI gui) {
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
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filter(gui).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbProgress;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Scrollbar scrollbar1;
    // End of variables declaration//GEN-END:variables
}
