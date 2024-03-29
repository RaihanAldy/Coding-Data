/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package penjualan;
import java.io.File;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author USER
 */
public class frmBarang extends javax.swing.JFrame {
    Connection Con;
    ResultSet RsBrg;
    Statement stm;
    PreparedStatement pstat;

    Boolean ada = false;
    String sSatuan;
    Boolean edit=false;

    private Object[][] dataTable = null;
    private String[] header = {"Kode","Nama Barang","Satuan","Harga","Stok","Stok Min"};

    public frmBarang() {
        initComponents();
        open_db();
        baca_data();
        aktif(false);
        setTombol(true);
    }
    private void setField()
    {
        int row=tblBrg.getSelectedRow();
        txtKode.setText((String)tblBrg.getValueAt(row,0));
        txtNama.setText((String)tblBrg.getValueAt(row,1)); 
        cmbSatuan.setSelectedItem((String)tblBrg.getValueAt(row,2)); 
        String harga = Double.toString((Double)tblBrg.getValueAt(row,3));
        txtHarga.setText(harga);
        String stok=Integer.toString((Integer)tblBrg.getValueAt(row,4));
        txtStok.setText(stok);
        String stokmin=Integer.toString((Integer)tblBrg.getValueAt(row,5));
        txtStokMin.setText(stokmin);
    }

    //method membuka database server, user, pass, database disesuaikan
    private void open_db()
    { 
        try{
            KoneksiMysql kon = new KoneksiMysql ("localhost","root","","penjualan");
            Con = kon.getConnection();
            System.out.println("Berhasil ");
        }catch (Exception e) {
            System.out.println("Error : "+e);
        }
    }
        private void baca_data()
    {
        try{
           stm = Con.createStatement(); 
           
           pstat = Con.prepareStatement("select * from barang",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           RsBrg = pstat.executeQuery();

           ResultSetMetaData meta = RsBrg.getMetaData();
           int col = meta.getColumnCount();
           int baris = 0;

           while(RsBrg.next()) {
               baris = RsBrg.getRow();
           }

           dataTable = new Object[baris][col];
           int x = 0;
           RsBrg.beforeFirst();

           while(RsBrg.next()) {
               dataTable[x][0] = RsBrg.getString("kd_brg");
               dataTable[x][1] = RsBrg.getString("nm_brg"); 
               dataTable[x][2] = RsBrg.getString("satuan");
               dataTable[x][3] = RsBrg.getDouble("harga");
               dataTable[x][4] = RsBrg.getInt("stok");
               dataTable[x][5] = RsBrg.getInt("stok_min"); 
              x++;
           }
           tblBrg.setModel(new DefaultTableModel(dataTable,header));
        }
        catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null, e);
        }
    }

    private void kosong()
    {
        txtKode.setText("");
        txtNama.setText(""); 
        txtHarga.setText("");
        txtStok.setText("");
        txtStokMin.setText("");
    }
    
    private void aktif(boolean x)
    {
        txtKode.setEditable(x);
        txtNama.setEditable(x); 
        cmbSatuan.setEnabled(x);
        txtHarga.setEditable(x);
        txtStok.setEditable(x);
        txtStokMin.setEditable(x);
    }

    //mengset tombol on/off
    private void setTombol(boolean t)
    {
        cmdTambah.setEnabled(t);
        cmdKoreksi.setEnabled(t);
        cmdHapus.setEnabled(t);
        cmdSimpan.setEnabled(!t);
        cmdBatal.setEnabled(!t);
        cmdKeluar.setEnabled(t); 
    }



    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtKode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbSatuan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtStokMin = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrg = new javax.swing.JTable();
        cmdTambah = new javax.swing.JButton();
        cmdSimpan = new javax.swing.JButton();
        cmdKoreksi = new javax.swing.JButton();
        cmdHapus = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdKeluar = new javax.swing.JButton();
        cmdExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeActionPerformed(evt);
            }
        });

        jLabel1.setText("DATA BARANG");

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Harga");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Stok");

        jLabel6.setText("Satuan");

        cmbSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buah", "Lembar" }));
        cmbSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSatuanActionPerformed(evt);
            }
        });

        jLabel7.setText("Stok Minimal");

        tblBrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama Barang", "Satuan", "Harga", "Stok", "Stok minimal"
            }
        ));
        tblBrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBrgMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBrg);

        cmdTambah.setText("Tambah");
        cmdTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTambahActionPerformed(evt);
            }
        });

        cmdSimpan.setText("Simpan");
        cmdSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdSimpanMouseClicked(evt);
            }
        });
        cmdSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSimpanActionPerformed(evt);
            }
        });

        cmdKoreksi.setText("Koreksi");
        cmdKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKoreksiActionPerformed(evt);
            }
        });

        cmdHapus.setText("Hapus");
        cmdHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdKeluar.setText("Keluar");
        cmdKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeluarActionPerformed(evt);
            }
        });

        cmdExport.setText("Export");
        cmdExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 562, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNama)
                                    .addComponent(cmbSatuan, 0, 150, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStokMin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cmdTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(cmdKoreksi)
                        .addGap(18, 18, 18)
                        .addComponent(cmdHapus)
                        .addGap(18, 18, 18)
                        .addComponent(cmdBatal)
                        .addGap(18, 18, 18)
                        .addComponent(cmdKeluar)
                        .addGap(18, 18, 18)
                        .addComponent(cmdExport)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStokMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdTambah)
                    .addComponent(cmdSimpan)
                    .addComponent(cmdKoreksi)
                    .addComponent(cmdHapus)
                    .addComponent(cmdBatal)
                    .addComponent(cmdKeluar)
                    .addComponent(cmdExport))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeActionPerformed

    private void cmbSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSatuanActionPerformed
        // TODO add your handling code here:
        JComboBox cSatuan = (javax.swing.JComboBox)evt.getSource();
        //Membaca Item Yang Terpilih — > String
        sSatuan = (String)cSatuan.getSelectedItem();
    }//GEN-LAST:event_cmbSatuanActionPerformed

    private void tblBrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBrgMouseClicked
        // TODO add your handling code here:
        setField();
    }//GEN-LAST:event_tblBrgMouseClicked

    private void cmdTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdTambahActionPerformed
        // TODO add your handling code here:
        aktif(true);
        setTombol(false);
        kosong();
    }//GEN-LAST:event_cmdTambahActionPerformed

    private void cmdSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSimpanActionPerformed

    }//GEN-LAST:event_cmdSimpanActionPerformed

    private void cmdSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdSimpanMouseClicked
        // TODO add your handling code here:
        String tKode=txtKode.getText();
        String tNama=txtNama.getText();

        double hrg=Double.parseDouble(txtHarga.getText());
        int stk=Integer.parseInt(txtStok.getText());
        int stkMin=Integer.parseInt(txtStokMin.getText());
        try{
            if (edit==true){
                stm.executeUpdate("update barang set nm_brg='"+tNama
                        +"',satuan='"+sSatuan+"',harga="+hrg+",stok="+stk+",stok_min="
                        +stkMin+" where kd_brg='" + tKode + "'");
            }else{
                stm.executeUpdate("INSERT into barang VALUES('"+tKode+"','"+tNama+"','"+sSatuan+"',"+hrg+","+stk+","+stkMin+")");
            }
            tblBrg.setModel(new DefaultTableModel(dataTable,header));
            baca_data();
            aktif(false);
            setTombol(true);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmdSimpanMouseClicked

    private void cmdKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKoreksiActionPerformed
        // TODO add your handling code here:
        edit=true;
        aktif(true);
        setTombol(false);
        txtKode.setEditable(false);
    }//GEN-LAST:event_cmdKoreksiActionPerformed

    private void cmdHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusActionPerformed
        // TODO add your handling code here:
         try{
           String sql="delete from barang where kd_brg='" + txtKode.getText() + "'";
           stm.executeUpdate(sql);
           baca_data();
        }
        catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_cmdHapusActionPerformed

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
        // TODO add your handling code here:
        aktif(false);
        setTombol(true);
        kosong();

    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cmdKeluarActionPerformed

    private void cmdExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExportActionPerformed
        // TODO add your handling code here:
        try{
            ExportToExcel ex = new ExportToExcel(tblBrg,new File("Data Barang.xls"));
            JOptionPane.showMessageDialog(null, "Sukses Export Data...");                  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_cmdExportActionPerformed

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
            java.util.logging.Logger.getLogger(frmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbSatuan;
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdExport;
    private javax.swing.JButton cmdHapus;
    private javax.swing.JButton cmdKeluar;
    private javax.swing.JButton cmdKoreksi;
    private javax.swing.JButton cmdSimpan;
    private javax.swing.JButton cmdTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBrg;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtStokMin;
    // End of variables declaration//GEN-END:variables

}
