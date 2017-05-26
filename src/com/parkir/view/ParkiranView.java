/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkir.view;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import com.parkir.dao.ParkiranDao;
import com.parkir.entity.Parkiran;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ASUS
 */
public class ParkiranView extends javax.swing.JFrame {

    /**
     * Creates new form ParkiranView
     */
    private ParkiranDao parkiranDao=new ParkiranDao();
    
    public ParkiranView() {
        initComponents();
        setLocationRelativeTo(null);
        setId();
        txt_no.setDocument(new PlainDocument(){
            private static final long serialVersionUID = 1L;

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                str = str.toUpperCase();
                    if (str.matches("[A-Z]*[0-9]*")) {
                        super.insertString(offs, str, a);
                    } else {
                        // data ditolak
                    }
            }
        });
        
        txt_no_polis.setDocument(new PlainDocument(){
            private static final long serialVersionUID = 1L;

            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                str = str.toUpperCase();
                    if (str.matches("[A-Z]*[0-9]*")) {
                        super.insertString(offs, str, a);
                    } else {
                        // data ditolak
                    }
            }
        });
    }

    private void durasi(){
        String id_parkir = txt_idambil.getText();
        Parkiran durasiParkir = parkiranDao.getDurasiParkir(id_parkir);
        txt_tglkeluar.setText(String.valueOf(durasiParkir.getTgl_keluar()));
        txt_jamkeluar.setText(durasiParkir.getJam_keluar());
        txt_selisih.setText(durasiParkir.getDurasi());
    }
    
    private void setId(){
        String setId = parkiranDao.setId();
        txt_id.setText(setId);
    }
    
    private void ambilKeseluruhan(){
        String no_polisi=txt_no_polis.getText();
        Parkiran parkirans = parkiranDao.getParkirans(no_polisi);
        
        if(no_polisi.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No polisi tidak boleh kosong");
        }else if(parkirans==null){
            JOptionPane.showMessageDialog(null, "No Polisi tidak ditemukan");
        }else{
            txt_idambil.setText(parkirans.getId_parkiran());
            txt_jammasuk.setText(parkirans.getJam_masuk());
            txt_tglmasuk.setText(String.valueOf(parkirans.getTgl_masuk()));
            txt_jenis.setText(parkirans.getJenis_kendaraan());
            txt_tglkeluar.setText(String.valueOf(parkirans.getTgl_keluar()));
            txt_jamkeluar.setText(parkirans.getJam_keluar());
            switch (txt_jenis.getText()) {
                case "Motor":
                    txt_bayar.setText("2000");
                    break;
                case "Mobil":
                    txt_bayar.setText("3000");
                    break;
            }
            btn_cari.setEnabled(false);
            btn_keluar.setEnabled(true);
        }
    }
    
    private void resetForm(){
        txt_no.setText("");
        txt_no_polis.setText("");
        cbo_jenis.setSelectedIndex(0);
        txt_jenis.setText("");
        txt_tglmasuk.setText("");
        txt_tglkeluar.setText("");
        txt_jammasuk.setText("");
        txt_jamkeluar.setText("");
        txt_total.setText("");
        txt_idambil.setText("");
        txt_selisih.setText("");
        txt_bayar.setText("");
        btn_cari.setEnabled(true);
        btn_keluar.setEnabled(false);
        btn_simpan.setEnabled(false);
    }
    
    public void akumulasiWaktu(){
        int vdurasi;
        double vbj, vbiaya;
        
        vdurasi=Integer.parseInt(txt_selisih.getText());
        vbj=Double.parseDouble(txt_bayar.getText());
        
        if(vdurasi<=1){
            vbiaya=vbj;
        }else{
            vbiaya=(vbj*vdurasi);
        }
        txt_total.setText(""+vbiaya);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_no = new javax.swing.JTextField();
        cbo_jenis = new javax.swing.JComboBox();
        btn_masuk = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_no_polis = new javax.swing.JTextField();
        txt_tglmasuk = new javax.swing.JTextField();
        txt_jammasuk = new javax.swing.JTextField();
        txt_tglkeluar = new javax.swing.JTextField();
        txt_jamkeluar = new javax.swing.JTextField();
        txt_selisih = new javax.swing.JTextField();
        txt_bayar = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        btn_keluar = new javax.swing.JButton();
        txt_jenis = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_idambil = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(101, 159, 144));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(226, 226, 226));
        jLabel1.setText("PARKIRAN KU");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(110, 20, 390, 40);

        jPanel2.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("No Polisi :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 80, 86, 14);

        jLabel3.setText("Jenis Kendaraan :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 150, 86, 14);

        txt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_noActionPerformed(evt);
            }
        });
        jPanel2.add(txt_no);
        txt_no.setBounds(110, 70, 230, 40);

        cbo_jenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih -", "Motor", "Mobil" }));
        jPanel2.add(cbo_jenis);
        cbo_jenis.setBounds(110, 140, 170, 40);

        btn_masuk.setBackground(new java.awt.Color(209, 255, 172));
        btn_masuk.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_masuk.setText("Masuk");
        btn_masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_masukActionPerformed(evt);
            }
        });
        jPanel2.add(btn_masuk);
        btn_masuk.setBounds(380, 20, 160, 200);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("No Parkir :");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(0, 20, 86, 14);

        txt_id.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_id.setEnabled(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        jPanel2.add(txt_id);
        txt_id.setBounds(110, 10, 140, 40);

        jTabbedPane1.addTab("Parkir Masuk", jPanel2);

        jPanel3.setLayout(null);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("No Polisi :");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 15, 83, 14);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Jenis Kendaraan:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 70, 90, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Tgl Masuk :");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(0, 110, 90, 30);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Jam Masuk :");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(210, 110, 80, 30);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tgl Keluar :");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(0, 150, 90, 30);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Jam Keluar :");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(210, 150, 80, 30);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Selisih Jam :");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(0, 190, 90, 30);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Bayar Uang:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(210, 190, 80, 30);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Total Bayar :");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(210, 230, 80, 30);

        txt_no_polis.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel3.add(txt_no_polis);
        txt_no_polis.setBounds(103, 12, 140, 30);

        txt_tglmasuk.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txt_tglmasuk.setEnabled(false);
        jPanel3.add(txt_tglmasuk);
        txt_tglmasuk.setBounds(90, 110, 130, 30);

        txt_jammasuk.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txt_jammasuk.setEnabled(false);
        jPanel3.add(txt_jammasuk);
        txt_jammasuk.setBounds(298, 110, 120, 30);

        txt_tglkeluar.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txt_tglkeluar.setEnabled(false);
        jPanel3.add(txt_tglkeluar);
        txt_tglkeluar.setBounds(90, 150, 130, 30);

        txt_jamkeluar.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txt_jamkeluar.setEnabled(false);
        jPanel3.add(txt_jamkeluar);
        txt_jamkeluar.setBounds(298, 150, 120, 30);

        txt_selisih.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        txt_selisih.setEnabled(false);
        jPanel3.add(txt_selisih);
        txt_selisih.setBounds(90, 190, 130, 30);

        txt_bayar.setBackground(new java.awt.Color(255, 255, 51));
        txt_bayar.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel3.add(txt_bayar);
        txt_bayar.setBounds(298, 190, 120, 30);

        txt_total.setBackground(new java.awt.Color(255, 255, 0));
        txt_total.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jPanel3.add(txt_total);
        txt_total.setBounds(298, 230, 120, 30);

        btn_keluar.setBackground(new java.awt.Color(255, 204, 204));
        btn_keluar.setText("Keluar");
        btn_keluar.setEnabled(false);
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_keluar);
        btn_keluar.setBounds(440, 40, 144, 110);

        txt_jenis.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_jenis.setEnabled(false);
        txt_jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jenisActionPerformed(evt);
            }
        });
        jPanel3.add(txt_jenis);
        txt_jenis.setBounds(90, 70, 130, 30);

        btn_cari.setText("Cari Kendaraan");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cari);
        btn_cari.setBounds(257, 11, 130, 30);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("No Parkir :");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(210, 70, 80, 30);

        txt_idambil.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        txt_idambil.setEnabled(false);
        jPanel3.add(txt_idambil);
        txt_idambil.setBounds(300, 70, 120, 30);

        btn_simpan.setText("Siimpan");
        btn_simpan.setEnabled(false);
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        jPanel3.add(btn_simpan);
        btn_simpan.setBounds(440, 220, 140, 40);

        jTabbedPane1.addTab("Parkir Keluar", jPanel3);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 80, 600, 310);

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reset);
        btn_reset.setBounds(290, 410, 61, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 450);

        setBounds(0, 0, 643, 482);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_masukActionPerformed
        // TODO add your handling code here:
        if(txt_no.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No Polisi Harus Diisi");
        }else if(cbo_jenis.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Anda belu memilih jenis kendaraan");
        }else{
            String id_parkir = txt_id.getText();
            String no_polisi=txt_no.getText();
            String jenis_kendaraan=(String) cbo_jenis.getSelectedItem();

            Parkiran p=new Parkiran();
            p.setId_parkiran(id_parkir);
            p.setNo_polisi(no_polisi);
            p.setJenis_kendaraan(jenis_kendaraan);
            parkiranDao.insert(p);
            resetForm();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            setId();
        }
    }//GEN-LAST:event_btn_masukActionPerformed

    private void txt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_noActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        if(txt_no_polis.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No Polisi Masih Kosong");
        }else{
            String id_parkir= txt_idambil.getText();

            Parkiran p=new Parkiran();
            p.setId_parkiran(id_parkir);

            parkiranDao.update(p);
            btn_keluar.setEnabled(false);
            btn_simpan.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dirubah");
        }
        ambilKeseluruhan();
        durasi();
        akumulasiWaktu();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        ambilKeseluruhan();
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        String id_parkir= txt_idambil.getText();
        double total = Double.valueOf(txt_total.getText());

        Parkiran p=new Parkiran();
        p.setId_parkiran(id_parkir);
        p.setTotal(total);

        parkiranDao.simpanparkir(p);
        resetForm();
        btn_simpan.setEnabled(false);
        btn_cari.setEnabled(true);
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void txt_jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jenisActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        resetForm();
        setId();
    }//GEN-LAST:event_btn_resetActionPerformed

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
            java.util.logging.Logger.getLogger(ParkiranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParkiranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParkiranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParkiranView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParkiranView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_masuk;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox cbo_jenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_idambil;
    private javax.swing.JTextField txt_jamkeluar;
    private javax.swing.JTextField txt_jammasuk;
    private javax.swing.JTextField txt_jenis;
    private javax.swing.JTextField txt_no;
    private javax.swing.JTextField txt_no_polis;
    private javax.swing.JTextField txt_selisih;
    private javax.swing.JTextField txt_tglkeluar;
    private javax.swing.JTextField txt_tglmasuk;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}