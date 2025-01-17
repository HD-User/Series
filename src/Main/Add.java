/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import DataBase.*;
import java.awt.Toolkit;
import java.sql.*;
import java.util.Objects;
import org.json.simple.*;
import org.jsoup.Jsoup;

/**
 *
 * @author ihdov
 */
public class Add extends javax.swing.JFrame {

    /**
     * Creates new form Add
     */
    GUI gui;
    public Add(GUI gui) {
        initComponents();
        this.gui = gui;
        txtDescription.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl2 = new java.awt.Label();
        txtID = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        scrRating = new javax.swing.JScrollBar();
        lblRatingValue = new java.awt.Label();
        label1 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        lblAddMessage = new java.awt.Label();
        cmbStatus = new javax.swing.JComboBox<>();
        label3 = new java.awt.Label();
        lblDescription = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMyDesc = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        setTitle("Add");
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/add.png")));
        setPreferredSize(new java.awt.Dimension(440, 500));
        setResizable(false);

        lbl2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl2.setText("Rating:");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        label2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        label2.setText("ID:");

        scrRating.setMaximum(11);
        scrRating.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        scrRating.setVisibleAmount(1);
        scrRating.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                valueChanged(evt);
            }
        });

        lblRatingValue.setAlignment(1);
        lblRatingValue.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblRatingValue.setText("0");

        label1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        label1.setMaximumSize(new java.awt.Dimension(53, 23));
        label1.setMinimumSize(new java.awt.Dimension(53, 23));
        label1.setText("My Description:");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOK(evt);
            }
        });

        lblAddMessage.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N

        cmbStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Watched", "Planning to Watch", "Watching", "To be Continued", "Leave in Half", "Watch Later", "Can't Watch" }));

        label3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        label3.setText("Status:");

        lblDescription.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblDescription.setPreferredSize(new java.awt.Dimension(38, 26));
        lblDescription.setText("Description:");

        txtMyDesc.setColumns(20);
        txtMyDesc.setLineWrap(true);
        txtMyDesc.setRows(5);
        txtMyDesc.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtMyDesc);

        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAddMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(310, 310, 310)
                                        .addComponent(lblRatingValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(scrRating, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRatingValue, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(lblAddMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl2.getAccessibleContext().setAccessibleName("ID:");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_valueChanged
        lblRatingValue.setText(String.valueOf(scrRating.getValue()));
    }//GEN-LAST:event_valueChanged
    private void addOK(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOK
        try{
        String json = Jsoup.connect("https://api.tmdb.org/3/tv/" + txtID.getText() + "?api_key=4169c18556ebe6ana480a5d10e861831").ignoreContentType(true).execute().body();
        JSONObject jo = (JSONObject) JSONValue.parse(json);
        if(Objects.isNull(jo.get("success"))){
            DBHelper help = new DBHelper();
            Connection c = help.getConnection();
            Statement stm = c.createStatement();
            String dsc = (String)((JSONObject) (JSONValue.parse(Jsoup.connect("https://api.tmdb.org/3/tv/" + txtID.getText() + "?api_key=4169c18556ebe6ana480a5d10e861831&language=tr-TR&region=TR").ignoreContentType(true).execute().body()))).get("overview");
            if(dsc.length() == 0){
                lblAddMessage.setText("Please enter the description manually");
                txtDescription.setVisible(true);
                dsc = txtDescription.getText();
            }if(dsc.length() > 0){
                if(dsc.contains("\"")){
                    dsc = dsc.replaceAll("\"", "'");
                }
                stm.executeUpdate("insert into Database.Series (ID, Title, Year, Rating, WatchStatus, Description, MyDescription, Progressivity, Seasons, Episodes, PosterPath) values (" + txtID.getText() + ", \"" + jo.get("name") + "\", " + String.valueOf(jo.get("first_air_date")).substring(0,4) + ", " + String.valueOf(scrRating.getValue()) + ", \"" + cmbStatus.getSelectedItem().toString() + "\", \"" + dsc + "\", \"" + txtMyDesc.getText() + "\", " + jo.get("in_production") + ", " + jo.get("number_of_seasons") + ", " + jo.get("number_of_episodes") + ", " + "\"http://images.tmdb.org/t/p/w342" + (String)jo.get("poster_path") + "\")");
                stm.close();
                c.close();
                gui.renewList();
                setVisible(false);
            }
            
        }else{
            lblAddMessage.setText("ID is invalid");
        }
        }catch(Exception e){
            lblAddMessage.setText("An error occured");
            System.out.println("hata: " + e.getClass().toString() + "\n" + e.getMessage());
        }
    }//GEN-LAST:event_addOK

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
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add(gui).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label lbl2;
    private java.awt.Label lblAddMessage;
    private java.awt.Label lblDescription;
    private java.awt.Label lblRatingValue;
    private javax.swing.JScrollBar scrRating;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtMyDesc;
    // End of variables declaration//GEN-END:variables
}
