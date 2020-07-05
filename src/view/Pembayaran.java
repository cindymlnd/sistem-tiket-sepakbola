package view;

import model.*;
import controller.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Pembayaran extends javax.swing.JFrame {

    private Controller_Pembayaran transaksi;
    private Controller_Pembeli pembeli;
    private Controller_Tiket tiket;
    private ArrayList<tiket> arrpembayaran;
    private Integer hargatotal;

    public Pembayaran() throws SQLException {
        initComponents();
        this.arrpembayaran = new ArrayList<>();
        this.transaksi = new Controller_Pembayaran();
        this.pembeli = new Controller_Pembeli();
        this.tiket = new Controller_Tiket();
        this.showComboBoxPembeli();
        this.showComboBoxTiket();
        this.hargatotal = 0;
        this.ShowTablePembayaran();
        this.showHargaTotal();

    }

    private void showComboBoxPembeli() throws SQLException {
        DefaultComboBoxModel dcbmPembeli = new DefaultComboBoxModel();

        for (datapembeli p : this.pembeli.getDataPembeli()) {
            dcbmPembeli.addElement(p.getNama_pembeli());
        }
        this.cbPembeli.setModel(dcbmPembeli);
    }

    private void showComboBoxTiket() throws SQLException {
        DefaultComboBoxModel dcbmTiket = new DefaultComboBoxModel();

        for (datatiket t : this.tiket.getDataTiket()) {
            dcbmTiket.addElement(t.getVarian_tiket());
        }
        this.cbTiket.setModel(dcbmTiket);
    }

    private void ShowTablePembayaran() throws SQLException {
        DefaultTableModel dtmpembayaran = new DefaultTableModel(new String[]{"ID Pembayaran", "Pembeli", "Jumlah Tiket", "Harga Total"}, 0);
        dtmpembayaran.setRowCount(0);

        for (tiket dp : this.transaksi.getDataPembayaran()) {
            dtmpembayaran.addRow(new String[]{dp.getId_pembayaran().toString(), dp.getPembeli().getNama_pembeli(),
                dp.getJumlah_tiket().toString(), dp.getHarga_total().toString()});
        }
        this.tblPembayaran.setModel(dtmpembayaran);
    }

    public void showHargaTotal() {
        this.tfHarga.setText(this.hargatotal.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPembayaran = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        taDetail = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cbPembeli = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbTiket = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfJumlah = new javax.swing.JTextField();
        btnTotal = new javax.swing.JButton();
        tfHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(102, 0, 204)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("PEMBAYARAN");

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        tblPembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPembayaranMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPembayaran);

        taDetail.setColumns(20);
        taDetail.setRows(5);
        jScrollPane4.setViewportView(taDetail);

        jLabel7.setText("Nama Pembeli");

        cbPembeli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Jenis Tiket");

        cbTiket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Jumlah Tiket");

        btnTotal.setText("TOTAL");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        tfHarga.setEditable(false);

        jLabel8.setText("Harga Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTotal)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbPembeli, 0, 130, Short.MAX_VALUE)
                                    .addComponent(cbTiket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfJumlah)))))
                    .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrint)
                        .addGap(162, 162, 162))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrint)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnTotal)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnInsert)
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        tiket pembayaran = new tiket();

        try {
            pembayaran.setPembeli(this.pembeli.getDataPembeli().get(this.cbPembeli.getSelectedIndex()));
            pembayaran.setTiket(this.tiket.getDataTiket().get(this.cbTiket.getSelectedIndex()));
            pembayaran.setJumlah_tiket(Integer.parseInt(this.tfJumlah.getText()));
            pembayaran.setHarga_total(this.hargatotal);

            this.transaksi.insertPembayaran(pembayaran);
            this.ShowTablePembayaran();
            this.hargatotal = 0;
            this.showComboBoxPembeli();
            this.showComboBoxTiket();
        } catch (SQLException err) {
            System.out.println(err);
        }


    }//GEN-LAST:event_btnInsertActionPerformed

    private void tblPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPembayaranMouseClicked
//        int baris = tblPembayaran.getSelectedRow();
//        this.tfJumlah.setText(tblPembayaran.getValueAt(baris, 0).toString());
//        this.tfHarga.setText(tblPembayaran.getValueAt(baris, 1).toString());
//        this.jTextField3.setText(tblPembayaran.getValueAt(baris, 2).toString());
//        this.jTextPane2.setText(tblPembayaran.getValueAt(baris, 3).toString());
//        this.jTextPane1.setText(tblPembayaran.getValueAt(baris, 4).toString());
//        

    }//GEN-LAST:event_tblPembayaranMouseClicked

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        // TODO add your handling code here:
        tiket t = new tiket();

        try {
            this.hargatotal += this.tiket.getDataTiket().get(cbTiket.getSelectedIndex()).getHarga_tiket()
                    * Integer.parseInt(tfJumlah.getText());

            this.showHargaTotal();

        } catch (SQLException ex) {
            Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try {
            tiket rin = this.transaksi.getDataPembayaran().get(this.tblPembayaran.getSelectedRow());
            String teks = " " + "================== STADION KANJURUHAN ==================" + "\n"
                    + "ID Pembayaran : " + rin.getId_pembayaran() + "\n\n"
                    + "Nama Pembeli : " + rin.getPembeli().getId_pembeli() + "\n"
                    + "Jenis Kelamin : " + rin.getPembeli().getGender() + "\n"
                    + "Kode Tiket : " + rin.getTiket().getId_tiket() + "\n"
                    + "Jumlah Tiket : " + rin.getJumlah_tiket() + "\n"
                    + "Harga Total : " + rin.getHarga_total() + "\n";
            this.taDetail.setText(teks);

        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pembayaran().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Pembayaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTotal;
    private javax.swing.JComboBox<String> cbPembeli;
    private javax.swing.JComboBox<String> cbTiket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea taDetail;
    private javax.swing.JTable tblPembayaran;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfJumlah;
    // End of variables declaration//GEN-END:variables
}
