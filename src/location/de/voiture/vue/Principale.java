/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package location.de.voiture.vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saad EL MATBAI
 */
public class Principale extends javax.swing.JFrame {

    // importation des biblio importantes
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public Principale() {
        initComponents();
        TableEnregitrer();
        TableVoitureDispo();
        voitureItem();
        TableLouer();
    }

    //methode pour se connecter à la base de donnée db_location
    
    private void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db_location","root","");
            System.out.println("connection réussite");
            
        } catch (Exception e) {
            // en cas d'erreur
            System.out.println("erreur");
        }
    }
    
    // methode d'affichage de table
    private void TableEnregitrer(){
        String[] voiture = {"Matricule", "Nom voiture", "Prix voiture"};
        String[] vue = new String[4];
        DefaultTableModel model = new DefaultTableModel(null, voiture);
        String sql = "select * from voiture_enregistrer";
        try {
            Connect();
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            //la condition pour afficher les données
            while(rs.next()){
                vue[0] = rs.getString("matricule");
                vue[1] = rs.getString("nom");
                vue[2] = rs.getString("prix");
                model.addRow(vue);
            }
            
            //afficher dans la table
            jTable1.setModel(model);
            // à la fin toujours fermer la base de donnée
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     private void TableLouer(){
        String[] voiture = {"Matricule", "Prix" ,"Nom Client", "Nombre de jours","Date","Tel","Etat"};
        String[] vue = new String[8];
        DefaultTableModel model = new DefaultTableModel(null, voiture);
        String sql = "select * from louer";
        try {
            Connect();
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            //la condition pour afficher les données
            while(rs.next()){
                vue[0] = rs.getString("matricule");
                vue[1] = rs.getString("prix");
                vue[2] = rs.getString("nom");
                vue[3] = rs.getString("jour");
                vue[4] = rs.getString("dat");
                vue[5] = rs.getString("tel");
                vue[6] = rs.getString("etat");

                model.addRow(vue);
            }
            
            //afficher dans la table
            jTable3.setModel(model);
            // à la fin toujours fermer la base de donnée
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //afficher les voitures disponible
     private void TableVoitureDispo(){
        String[] voiture = {"Matricule", "Nom voiture", "Prix voiture/jour"};
        String[] vue = new String[4];
        DefaultTableModel model = new DefaultTableModel(null, voiture);
        String sql = "select * from voiture_enregistrer";
        try {
            Connect();
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            //la condition pour afficher les données
            while(rs.next()){
                vue[0] = rs.getString("matricule");
                vue[1] = rs.getString("nom");
                vue[2] = rs.getString("prix");
                model.addRow(vue);
            }
            
            //afficher dans la table
            jTable2.setModel(model);
            // à la fin toujours fermer la base de donnée
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // methode pour afficher les voitures sous forme d'item
     private void voitureItem(){
         try {
             Connect();
             String sql = "select matricule from voiture_enregistrer";
             pst = conn.prepareStatement(sql);
             rs = pst.executeQuery();
             while(rs.next()){
                 boxvoiture.addItem(rs.getString("matricule"));
             }
             conn.close();
             
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
    //methode pour afficher prix quand on appui sur item
      private void prixItem(){
         try {
             Connect();
             String sql = "select prix from voiture_enregistrer where matricule=?";
             pst = conn.prepareStatement(sql);
             pst.setString(1, boxvoiture.getSelectedItem().toString());
             rs = pst.executeQuery();
             while(rs.next()){
                 prixitem.setText(rs.getString("prix"));
             }
             conn.close();
             
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
    
    public void vider(){
        txtmatricule.setText("");
        txtnom.setText("");
        txtprix.setText("");


    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtmatricule = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        labelnom = new javax.swing.JLabel();
        txtprix = new javax.swing.JTextField();
        labelprix = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelnom1 = new javax.swing.JLabel();
        nomc = new javax.swing.JTextField();
        labelprix1 = new javax.swing.JLabel();
        tel = new javax.swing.JTextField();
        selectionner = new javax.swing.JButton();
        boxvoiture = new javax.swing.JComboBox<>();
        prixitem = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        labelnom2 = new javax.swing.JLabel();
        duree = new javax.swing.JTextField();
        labelprix2 = new javax.swing.JLabel();
        date = new javax.swing.JFormattedTextField();
        selectionner1 = new javax.swing.JButton();
        selectionner2 = new javax.swing.JButton();
        selectionner3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agence de Location Saad");

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Matricule");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        txtmatricule.setBackground(new java.awt.Color(153, 153, 153));
        txtmatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmatriculeActionPerformed(evt);
            }
        });

        txtnom.setBackground(new java.awt.Color(153, 153, 153));

        labelnom.setBackground(new java.awt.Color(153, 153, 153));
        labelnom.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelnom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnom.setText("Nom de Voiture");
        labelnom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        txtprix.setBackground(new java.awt.Color(153, 153, 153));

        labelprix.setBackground(new java.awt.Color(153, 153, 153));
        labelprix.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelprix.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelprix.setText("Prix");
        labelprix.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Supprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Enregister");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnom, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtprix, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelprix, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelnom, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelnom, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelprix, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtprix, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Enregistrement des voitures", jPanel2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Les voitures disponibles", jPanel3);

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Matricule");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        labelnom1.setBackground(new java.awt.Color(153, 153, 153));
        labelnom1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelnom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnom1.setText("Nom de client");
        labelnom1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        nomc.setBackground(new java.awt.Color(153, 153, 153));
        nomc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomcActionPerformed(evt);
            }
        });

        labelprix1.setBackground(new java.awt.Color(153, 153, 153));
        labelprix1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelprix1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelprix1.setText("Num de telephone");
        labelprix1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        tel.setBackground(new java.awt.Color(153, 153, 153));

        selectionner.setBackground(new java.awt.Color(51, 51, 51));
        selectionner.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        selectionner.setForeground(new java.awt.Color(255, 255, 255));
        selectionner.setText("Selectionner");
        selectionner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionnerActionPerformed(evt);
            }
        });

        boxvoiture.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        prixitem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prixitem.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prixitem.setText("0");
        prixitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prixitemActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        labelnom2.setBackground(new java.awt.Color(153, 153, 153));
        labelnom2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelnom2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelnom2.setText("Duree Prévue");
        labelnom2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        duree.setBackground(new java.awt.Color(153, 153, 153));
        duree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dureeActionPerformed(evt);
            }
        });

        labelprix2.setBackground(new java.awt.Color(153, 153, 153));
        labelprix2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelprix2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelprix2.setText("Date");
        labelprix2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        try {
            date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        selectionner1.setBackground(new java.awt.Color(51, 51, 51));
        selectionner1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        selectionner1.setForeground(new java.awt.Color(255, 255, 255));
        selectionner1.setText("Modifier");
        selectionner1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionner1ActionPerformed(evt);
            }
        });

        selectionner2.setBackground(new java.awt.Color(51, 51, 51));
        selectionner2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        selectionner2.setForeground(new java.awt.Color(255, 255, 255));
        selectionner2.setText("Enregister");
        selectionner2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionner2ActionPerformed(evt);
            }
        });

        selectionner3.setBackground(new java.awt.Color(51, 51, 51));
        selectionner3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        selectionner3.setForeground(new java.awt.Color(255, 255, 255));
        selectionner3.setText("Annuler/Tr");
        selectionner3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionner3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxvoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prixitem, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionner, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelprix1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomc, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelnom1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelprix2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duree, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelnom2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectionner2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionner3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionner1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelnom1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelnom2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boxvoiture, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(duree, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelprix1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectionner, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prixitem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(labelprix2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectionner2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionner1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionner3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Louer une voiture", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(901, 556));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Connect();
            pst = conn.prepareStatement("delete from voiture_enregistrer where matricule=?");
            int id = jTable1.getSelectedRow();
            String select = (String) jTable1.getValueAt(id, 0);
            pst.setString(1, select);
            pst.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, txtmatricule.getText()+" supprimé");
            TableEnregitrer();
            TableVoitureDispo();
            vider();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Connect();
            pst = conn.prepareStatement("insert into voiture_enregistrer(matricule,nom,prix) "
                    + "values(?,?,?)");
            pst.setString(1, txtmatricule.getText());
            pst.setString(2, txtnom.getText());
            pst.setString(3, txtprix.getText());
            pst.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Voiture "+txtmatricule.getText()+" ajoutée");
            TableEnregitrer();
            TableVoitureDispo();
            vider();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        int selectionner = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        txtmatricule.setText(model.getValueAt(selectionner, 0).toString());
        txtnom.setText(model.getValueAt(selectionner, 1).toString());
        txtprix.setText(model.getValueAt(selectionner, 2).toString());

    }//GEN-LAST:event_jTable1MouseReleased

    private void prixitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prixitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prixitemActionPerformed

    private void nomcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomcActionPerformed

    private void selectionnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionnerActionPerformed
        prixItem();
    }//GEN-LAST:event_selectionnerActionPerformed

    private void dureeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dureeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dureeActionPerformed

    private void selectionner1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionner1ActionPerformed
          try {
            String etat = "En cours";
            Connect();
            pst = conn.prepareStatement("update louer set prix=?,nom=?,jour=?,dat=?,tel=?,etat=?"
                    + "where matricule=?");
            pst.setString(7, boxvoiture.getSelectedItem().toString());
            pst.setString(1, prixitem.getText());
            pst.setString(2, nomc.getText());
            pst.setString(3, duree.getText());
            pst.setString(4, date.getText());
            pst.setString(5, tel.getText());
            pst.setString(6, etat);
            pst.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Voiture "+txtmatricule.getText()+" ajoutée");
            TableEnregitrer();
            TableLouer();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Voiture deja louer");
        }
    }//GEN-LAST:event_selectionner1ActionPerformed

    private void selectionner2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionner2ActionPerformed
        try {
            String etat = "En cours";
            Connect();
            pst = conn.prepareStatement("insert into louer(matricule,prix,nom,jour,dat,tel,etat) "
                    + "values(?,?,?,?,?,?,?)");
            pst.setString(1, boxvoiture.getSelectedItem().toString());
            pst.setString(2, prixitem.getText());
            pst.setString(3, nomc.getText());
            pst.setString(4, duree.getText());
            pst.setString(5, date.getText());
            pst.setString(6, tel.getText());
            pst.setString(7, etat);
            pst.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Voiture "+txtmatricule.getText()+" ajoutée");
            TableEnregitrer();
            TableLouer();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Voiture deja louer");
        }
    }//GEN-LAST:event_selectionner2ActionPerformed

    private void selectionner3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionner3ActionPerformed
          try {
            String etat = "Au garage";
            Connect();
            pst = conn.prepareStatement("update louer set etat=?"
                    + "where matricule=?");
            pst.setString(2, boxvoiture.getSelectedItem().toString());
            pst.setString(1, etat);
            pst.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "Voiture "+txtmatricule.getText()+" au garage");
            TableEnregitrer();
            TableLouer();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Voiture deja louer");
        }
    }//GEN-LAST:event_selectionner3ActionPerformed

    private void txtmatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmatriculeActionPerformed

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
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxvoiture;
    private javax.swing.JFormattedTextField date;
    private javax.swing.JTextField duree;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel labelnom;
    private javax.swing.JLabel labelnom1;
    private javax.swing.JLabel labelnom2;
    private javax.swing.JLabel labelprix;
    private javax.swing.JLabel labelprix1;
    private javax.swing.JLabel labelprix2;
    private javax.swing.JTextField nomc;
    private javax.swing.JTextField prixitem;
    private javax.swing.JButton selectionner;
    private javax.swing.JButton selectionner1;
    private javax.swing.JButton selectionner2;
    private javax.swing.JButton selectionner3;
    private javax.swing.JTextField tel;
    private javax.swing.JTextField txtmatricule;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtprix;
    // End of variables declaration//GEN-END:variables
}
