/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DataBase.Auto;
import DataBase.DBHelper;
import java.sql.*;
import java.awt.*;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ihdov
 */
public class GUI extends javax.swing.JFrame {
    String filterStatus = "None";
    int filterRating = 0;
    String filterProgress = "None";
    DefaultTableModel model;
    TableRowSorter<DefaultTableModel> trs;
    final String standartQ = "select * from Database.Series order by Rating asc limit 99999";
    public String q = standartQ;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        lblImage.setText("");
        model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
               return false;
            }
        };
        model.addColumn("Title");
        lstTitles.setModel(model);
        trs = new TableRowSorter<DefaultTableModel>(model);
        lstTitles.setRowSorter(trs);
        renewList();
        new Auto(this).start();
    }
    public void renewList(){
        model.setRowCount(0);
        ResultSet rs;
        Statement st = null;
        DBHelper help = new DBHelper();
        Connection c;
        try{
            c = help.getConnection();
            st = c.createStatement();
            rs = st.executeQuery(q);
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("Title")});
            }
            c.close();
            st.close();
            rs.close();
        }catch(Exception e){System.out.println("renewList: " + e.getLocalizedMessage());}
        try{
            if(! lblID.getText().substring(4).equals("")){
                c = help.getConnection();
                st = c.createStatement();
                rs = st.executeQuery("select * from Database.Series where ID = " + lblID.getText().substring(4));
                rs.next();
                String t = rs.getString("Title");
                c.close();
                st.close();
                rs.close();
                showSelected(t);
            }
        }catch(Exception e){}
    }
    public javax.swing.JTable getLstTitles(){
        return lstTitles;
    }
    public void showSelected(String title){
        ResultSet rs;
        Statement st = null;
        DBHelper help = new DBHelper();
        Boolean b = null;
        Connection c;
        try{
            if(title != null){
                c = help.getConnection();
                st = c.createStatement();
                rs = st.executeQuery("select * from Database.Series where Title='" + title + "'");
                rs.next();

                if(rs.getString("Progressivity").equals("0")){b = false;}
                else if(rs.getString("Progressivity").equals("1")){b = true;}

                lblID.setText("ID: " + String.valueOf(rs.getInt("ID")));
                lblYear.setText("Year: " + String.valueOf(rs.getInt("Year")));
                lblMyRating.setText("My Rating: " + rs.getString("Rating"));
                lblWatchStatus.setText("Watch Status: " + rs.getString("WatchStatus"));
                lblEpisode.setText("Number of Episodes: " + String.valueOf(rs.getInt("Episodes")));
                lblSeason.setText("Number of Seasons: " + String.valueOf(rs.getInt("Seasons")));
                lblProgressivity.setText("Progressivity: " + String.valueOf(b));
                txtDescription.setText(rs.getString("Description"));
                txtMyDesc.setText(rs.getString("MyDescription"));

                lblImage.setIcon(new javax.swing.JLabel() {
                    public javax.swing.Icon getIcon() {
                        try {
                            return new javax.swing.ImageIcon(
                                new java.net.URL(rs.getString("PosterPath"))
                            );
                        } catch (Exception e) {}
                        return null;
                    }
                }.getIcon());

                c.close();
                st.close();
                rs.close();
            }
        }catch(Exception e){}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        tabProperties = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        panel5 = new java.awt.Panel();
        lblMyRating = new javax.swing.JLabel();
        lblWatchStatus = new javax.swing.JLabel();
        lblEpisode = new javax.swing.JLabel();
        lblSeason = new javax.swing.JLabel();
        lblProgressivity = new javax.swing.JLabel();
        panel3 = new java.awt.Panel();
        lblDescription = new javax.swing.JLabel();
        lblMyDescription = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMyDesc = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTitles = new javax.swing.JTable();
        label1 = new java.awt.Label();
        txtSearch = new java.awt.TextField();
        btnFilter1 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Series");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/play.png"))
        );
        setResizable(false);
        setSize(new java.awt.Dimension(432, 243));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAdd.setToolTipText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        btnEdit.setToolTipText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update.png"))); // NOI18N
        btnUpdate.setToolTipText("Renew");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rnw(evt);
            }
        });

        btnFilter.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/filter.png"))); // NOI18N
        btnFilter.setToolTipText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter(evt);
            }
        });

        tabProperties.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblID.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblID.setText("ID: ");

        lblYear.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblYear.setText("Year: ");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("lblImage");
        lblImage.setMaximumSize(new java.awt.Dimension(505, 513));
        lblImage.setMinimumSize(new java.awt.Dimension(505, 513));
        lblImage.setPreferredSize(new java.awt.Dimension(505, 513));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblID)
                .addContainerGap())
        );

        tabProperties.addTab("Main", jPanel1);

        lblMyRating.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMyRating.setText("My Rating: ");

        lblWatchStatus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblWatchStatus.setText("Watch Status: ");

        lblEpisode.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblEpisode.setText("Number of Episodes: ");

        lblSeason.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSeason.setText("Number of Seasons: ");

        lblProgressivity.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblProgressivity.setText("Progressivity: ");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMyRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblWatchStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(lblEpisode, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(lblSeason, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(lblProgressivity, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMyRating)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWatchStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEpisode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSeason)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProgressivity)
                .addContainerGap(452, Short.MAX_VALUE))
        );

        tabProperties.addTab("Status", panel5);

        lblDescription.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDescription.setText("Description: ");

        lblMyDescription.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMyDescription.setText("My Description: ");

        txtDescription.setEditable(false);
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDescriptionMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(txtDescription);

        txtMyDesc.setEditable(false);
        txtMyDesc.setColumns(20);
        txtMyDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMyDesc.setLineWrap(true);
        txtMyDesc.setRows(5);
        txtMyDesc.setWrapStyleWord(true);
        txtMyDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMyDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMyDescMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txtMyDesc);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(lblMyDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMyDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabProperties.addTab("About", panel3);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDelete.setToolTipText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete(evt);
            }
        });

        btnSelect.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/select.png"))); // NOI18N
        btnSelect.setToolTipText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select(evt);
            }
        });

        lstTitles.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        lstTitles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lstTitles.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(lstTitles);

        label1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        label1.setText("Search:");

        txtSearch.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        txtSearch.addTextListener(new java.awt.event.TextListener() {
            public void textValueChanged(java.awt.event.TextEvent evt) {
                search(evt);
            }
        });

        btnFilter1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFilter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/database.png"))); // NOI18N
        btnFilter1.setToolTipText("Show Full Database");
        btnFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                database(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabProperties, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabProperties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void rnw(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rnw
        renewList();
    }//GEN-LAST:event_rnw
    private void filter(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter
        Filter.main(new String[]{""}, this);
    }//GEN-LAST:event_filter
    private void delete(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete
        DBHelper help = new DBHelper();
        try{
            Connection c = help.getConnection();
            Statement st = c.createStatement();
            st.executeUpdate("delete from Database.Series where Title = \"" + lstTitles.getValueAt(lstTitles.getSelectedRow(), 0) + "\"");
            st.close();
            c.close();
            renewList();
        }catch(Exception e){}
    }//GEN-LAST:event_delete
    private void edit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit
        String s = null;
        try{s = String.valueOf(lstTitles.getValueAt(lstTitles.getSelectedRow(), 0));}catch(Exception e){System.out.println("btnEdit: " + e.getClass() + ": " + e.getLocalizedMessage());}
        if(s == null){Edit.main(new String[]{""}, this);}
        else{Edit.main(new String[]{""}, this, s);}
    }//GEN-LAST:event_edit
    private void add(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add
        Add.main(new String[]{""}, this);
    }//GEN-LAST:event_add
    private void select(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select
        try{showSelected(String.valueOf(lstTitles.getValueAt(lstTitles.getSelectedRow(), 0)));}catch(Exception e){}
    }//GEN-LAST:event_select
    private void search(java.awt.event.TextEvent evt) {//GEN-FIRST:event_search
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText()));
    }//GEN-LAST:event_search
    private void database(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_database
        Database.main(new String[]{""}, this);
    }//GEN-LAST:event_database
    private void txtDescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescriptionMouseClicked
        PopUp pop = new PopUp(txtDescription.getSelectedText());
        if(evt.getButton() == 3 && txtDescription.getSelectedText() != null){pop.show(evt.getComponent(), evt.getX(), evt.getY());}
    }//GEN-LAST:event_txtDescriptionMouseClicked
    private void txtMyDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMyDescMouseClicked
        PopUp pop = new PopUp(txtMyDesc.getSelectedText());
        if(evt.getButton() == 3 && txtMyDesc.getSelectedText() != null){pop.show(evt.getComponent(), evt.getX(), evt.getY());}
    }//GEN-LAST:event_txtMyDescMouseClicked

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnFilter1;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.Label label1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblEpisode;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblMyDescription;
    private javax.swing.JLabel lblMyRating;
    private javax.swing.JLabel lblProgressivity;
    private javax.swing.JLabel lblSeason;
    private javax.swing.JLabel lblWatchStatus;
    private javax.swing.JLabel lblYear;
    private javax.swing.JTable lstTitles;
    private java.awt.Panel panel3;
    private java.awt.Panel panel5;
    private javax.swing.JTabbedPane tabProperties;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtMyDesc;
    private java.awt.TextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
