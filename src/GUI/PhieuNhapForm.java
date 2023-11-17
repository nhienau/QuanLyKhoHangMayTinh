/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package GUI;

import DAO.PhieuNhapDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NguoiDungDTO;
import DTO.PhieuNhapDTO;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author DELL
 */
public class PhieuNhapForm extends javax.swing.JInternalFrame {

    private Date dateStart;
    private Date dateEnd;

    /**
     * Creates new form LichSuPhieuNhap
     */
    public PhieuNhapForm(NguoiDungDTO user) {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        TitledBorder titledBorderNgay = BorderFactory.createTitledBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK),
            "Lọc theo ngày",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.PLAIN, 14)
        );
        TitledBorder titledBorderGia = BorderFactory.createTitledBorder(
            BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK),
            "Lọc theo Giá",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.PLAIN, 14)
        );
        pnLocTheoNgay.setBorder(titledBorderNgay);
        pnLocTheoGia.setBorder(titledBorderGia);
        
        PhieuNhapDAO phieuNhapDao = new PhieuNhapDAO();
        ArrayList<PhieuNhapDTO> listPhieuNhap = phieuNhapDao.danhSachPhieuNhapTheoTrangThai(4);
        loadDanhSachPhieuNhap(listPhieuNhap);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnLocTheoGia = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtGiaMin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGiaMax = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        pnLocTheoNgay = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dateChooserStart = new com.toedter.calendar.JDateChooser();
        dateChooserEnd = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1180, 750));

        jPanel2.setBackground(new java.awt.Color(89, 168, 105));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DANH SÁCH PHIẾU NHẬP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pnLocTheoGia.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo giá"));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Từ");

        txtGiaMin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Đến");

        txtGiaMax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Tìm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLocTheoGiaLayout = new javax.swing.GroupLayout(pnLocTheoGia);
        pnLocTheoGia.setLayout(pnLocTheoGiaLayout);
        pnLocTheoGiaLayout.setHorizontalGroup(
            pnLocTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocTheoGiaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaMin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        pnLocTheoGiaLayout.setVerticalGroup(
            pnLocTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocTheoGiaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnLocTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiaMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(pnLocTheoGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(pnLocTheoGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phiếu nhập", "Thời gian tạo", "Mã kho", "Người tạo", "Tổng tiền", "Trạng thái"
            }
        ));
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieuNhap);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );

        pnLocTheoNgay.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo ngày"));
        pnLocTheoNgay.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Từ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Đến");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLocTheoNgayLayout = new javax.swing.GroupLayout(pnLocTheoNgay);
        pnLocTheoNgay.setLayout(pnLocTheoNgayLayout);
        pnLocTheoNgayLayout.setHorizontalGroup(
            pnLocTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocTheoNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pnLocTheoNgayLayout.setVerticalGroup(
            pnLocTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocTheoNgayLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnLocTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(pnLocTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(dateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnLocTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnLocTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(dateStart == null || dateEnd == null) {
            JOptionPane.showMessageDialog(this, "Chưa chọn ngày !");
            return;
        }
        PhieuNhapDAO phieuNhapDao = new PhieuNhapDAO();
        ArrayList<PhieuNhapDTO> listPhieuNhap = phieuNhapDao.layDanhSachPNTheoNgay(this.dateStart, this.dateEnd);
        if(listPhieuNhap.size() > 0) {
            loadDanhSachPhieuNhap(listPhieuNhap);
        }
        else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
            loadDanhSachPhieuNhap(listPhieuNhap);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dateChooserStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserStartPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            java.util.Date utilDate = dateChooserStart.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            dateStart = new java.sql.Date(utilDate.getTime());
        }
    }//GEN-LAST:event_dateChooserStartPropertyChange

    private void dateChooserEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserEndPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            java.util.Date utilDate = dateChooserEnd.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            dateEnd = new java.sql.Date(utilDate.getTime());
        }
    }//GEN-LAST:event_dateChooserEndPropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int giaMin = Integer.parseInt(txtGiaMin.getText());
            int giaMax = Integer.parseInt(txtGiaMax.getText());
            PhieuNhapDAO phieuNhapDao = new PhieuNhapDAO();
            ArrayList<PhieuNhapDTO> listPhieuNhap = phieuNhapDao.layDanhSachPNTheoGia(giaMin, giaMax);
            if(listPhieuNhap.size() > 0) {
                loadDanhSachPhieuNhap(listPhieuNhap);
            }
            else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
                loadDanhSachPhieuNhap(listPhieuNhap);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Kiểm tra lại giá nhập vào");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        
        int row = tblPhieuNhap.getSelectedRow();
        int maPhieuNhapSelected = Integer.parseInt(tblPhieuNhap.getValueAt(row, 1).toString());
        
        String[] columnNames = {"Column 1", "Column 2", "Column 3", "Column 4", "Column 5"};
        // Create a JTable
        JTable table = new JTable();
        
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã NCC", "Mã SP", "Số lượng"
            }
        ));

        PhieuNhapDAO phieuNhapDao = new PhieuNhapDAO();
        
        // Create a JPanel to hold the JTable and other components
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(600, 300));
        
        JPanel pnNorth = new JPanel(new BorderLayout());
        PhieuNhapDTO phieuNhap = phieuNhapDao.layPhieuNhapTheoMa(maPhieuNhapSelected);
        
        JPanel pnTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitle = new JLabel("Chi tiết phiếu nhập");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLUE);
        pnTitle.add(lblTitle);
        pnNorth.add(pnTitle, BorderLayout.NORTH);
        
        JPanel pnThongTinPhieuNhap = new JPanel(new FlowLayout());
        
        JPanel pnMaPhieu = new JPanel(new FlowLayout());
        JLabel lblMaPhieu = new JLabel("Mã phiếu:");
        JLabel txtMaPhieu = new JLabel(phieuNhap.getMaPhieuNhap() + "");
        pnMaPhieu.add(lblMaPhieu);
        pnMaPhieu.add(txtMaPhieu);
        pnThongTinPhieuNhap.add(pnMaPhieu);
        
        JPanel pnMaKho = new JPanel(new FlowLayout());
        JLabel lblMaKho = new JLabel("Mã Kho:");
        JLabel txtMaKho = new JLabel(phieuNhap.getMaKho() + "");
        pnMaKho.add(lblMaKho);
        pnMaKho.add(txtMaKho);
        pnThongTinPhieuNhap.add(pnMaKho);
        
        JPanel pnThoiGianTao = new JPanel(new FlowLayout());
        JLabel lblThoiGianTao = new JLabel("Thời gian:");
        JLabel txtThoiGianTao = new JLabel(phieuNhap.getThoiGianTao() + "");
        pnThoiGianTao.add(lblThoiGianTao);
        pnThoiGianTao.add(txtThoiGianTao);
        pnThongTinPhieuNhap.add(pnThoiGianTao);
        
        lblMaPhieu.setFont(new Font("Serif", Font.BOLD, 14));
        lblMaKho.setFont(new Font("Serif", Font.BOLD, 14));
        lblThoiGianTao.setFont(new Font("Serif", Font.BOLD, 14));
        txtMaPhieu.setFont(new Font("Serif", Font.BOLD, 14));
        txtMaKho.setFont(new Font("Serif", Font.BOLD, 14));
        txtThoiGianTao.setFont(new Font("Serif", Font.BOLD, 14));
        
        pnNorth.add(pnThongTinPhieuNhap, BorderLayout.SOUTH);
        
        panel.add(pnNorth, BorderLayout.NORTH);
        
        JPanel pnSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JPanel pnTongTien = new JPanel(new FlowLayout());
        JLabel lblTongTien = new JLabel("Tổng tiền: ");
        JLabel txtTongTien = new JLabel(phieuNhap.getTongTien() + " VNĐ");
        lblTongTien.setFont(new Font("Serif", Font.BOLD, 18));
        txtTongTien.setFont(new Font("Serif", Font.BOLD, 18));
        pnTongTien.add(lblTongTien);
        pnTongTien.add(txtTongTien);
        
        pnSouth.add(pnTongTien);
        
        panel.add(pnSouth, BorderLayout.SOUTH);
        
        ArrayList<ChiTietPhieuNhapDTO> dsChiTietPhieuNhap =phieuNhapDao.danhSachCTPNTheoMaPhieuNhap(maPhieuNhapSelected);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (int i = 0; i < dsChiTietPhieuNhap.size(); i++) {
            ChiTietPhieuNhapDTO ctpn = dsChiTietPhieuNhap.get(i);
            Object[] rowCTPN = {i+1, ctpn.getMaNhaCungCap(), ctpn.getMaSanPham(), ctpn.getSoLuongNhap()};
            model.addRow(rowCTPN);
        }

        // Display the dialog box using JOptionPane
        JOptionPane.showMessageDialog(this, panel, "Chi tiết phiếu nhập", JOptionPane.PLAIN_MESSAGE);
        
        
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    
    
    private void loadDanhSachPhieuNhap(ArrayList<PhieuNhapDTO> listPhieuNhap) {
        if(listPhieuNhap != null) {
            DefaultTableModel model = (DefaultTableModel) tblPhieuNhap.getModel();
            model.setRowCount(0);
            for (int i = 0; i < listPhieuNhap.size(); i++) {
                PhieuNhapDTO phieuNhap = listPhieuNhap.get(i);
                Object[] row = {i+1, phieuNhap.getMaPhieuNhap(), 
                    phieuNhap.getThoiGianTao(), phieuNhap.getMaKho(), 
                    phieuNhap.getNguoiTao(), phieuNhap.getTongTien(), 
                    "Đã giao hàng"};
                model.addRow(row);
            }
        }
        else {
           return;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new PhieuNhapForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooserEnd;
    private com.toedter.calendar.JDateChooser dateChooserStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnLocTheoGia;
    private javax.swing.JPanel pnLocTheoNgay;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTextField txtGiaMax;
    private javax.swing.JTextField txtGiaMin;
    // End of variables declaration//GEN-END:variables

}
