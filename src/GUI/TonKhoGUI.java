/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.ChiTietQuyenBUS;
import DAO.SanPhamDAO;
import DAO.khoDAO;
import DAO.tonKhoDAO;
import DTO.ChiTietQuyenDTO;
import DTO.NguoiDungDTO;
import DTO.SanPhamDTO;
import DTO.khoDTO;
import DTO.tonKhoDTO;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import GUI.Dialog.DetailTonKho;
import GUI.Dialog.XuatKhoDialog;
import java.util.List;


public class TonKhoGUI extends javax.swing.JDialog  {
    private NguoiDungDTO user;
    private List<ChiTietQuyenDTO> allowedActions;
    
    DefaultTableCellRenderer renderer;
    
    public TonKhoGUI(NguoiDungDTO user, List<ChiTietQuyenDTO> allowedActions) {
        
        
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        initComponents();
        loadComboboxTenKho();
        this.user = user;
        this.allowedActions = allowedActions;
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
        jToolBar1 = new javax.swing.JToolBar();
        btnDetail = new javax.swing.JButton();
        btnXuatKho = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbTenKho = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMaKho = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTonKho = new javax.swing.JTable();

        setTitle("Tồn kho");

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_40px.png"))); // NOI18N
        btnDetail.setText("Xem chi tiết");
        btnDetail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetail.setFocusable(false);
        btnDetail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDetail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDetail);

        btnXuatKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/warehouse.png"))); // NOI18N
        btnXuatKho.setText("Xuất kho");
        btnXuatKho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatKho.setFocusable(false);
        btnXuatKho.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXuatKho.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXuatKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatKhoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnXuatKho);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("KHO:");

        cbbTenKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenKhoActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã kho: ");

        txtMaKho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaKho.setText(" ");
        txtMaKho.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMaKho.setEnabled(false);

        jLabel3.setText("Địa chỉ: ");

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiaChi.setText(" ");
        txtDiaChi.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDiaChi.setEnabled(false);
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTenKho, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbTenKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTonKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTonKhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTonKho);
        if (tbTonKho.getColumnModel().getColumnCount() > 0) {
            tbTonKho.getColumnModel().getColumn(0).setResizable(false);
            tbTonKho.getColumnModel().getColumn(0).setPreferredWidth(1);
            tbTonKho.getColumnModel().getColumn(1).setResizable(false);
            tbTonKho.getColumnModel().getColumn(2).setResizable(false);
            tbTonKho.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void cbbTenKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenKhoActionPerformed
        // TODO add your handling code here:
        String name = (String) modalCbbTenkho.getSelectedItem();
        khoDTO kho = khoDAO.getInstance().getWareHouseByName(name);
        txtMaKho.setText(String.valueOf(kho.getMaKho()));
        txtDiaChi.setText(kho.getDiaChi());
        int makho = Integer.parseInt(txtMaKho.getText());
        loadDataTotable(makho);
    }//GEN-LAST:event_cbbTenKhoActionPerformed

    private void tbTonKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTonKhoMouseClicked
        // TODO add your handling code here:
        ActionEvent act = null ;
        JTable table = (JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if(evt.getClickCount() == 2 && table.getSelectedRow() != -1 ){
            btnDetailActionPerformed(act); 
        }
    }//GEN-LAST:event_tbTonKhoMouseClicked

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        int row = tbTonKho.getSelectedRow() ;
        if ( row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm !");
        } else {
            String tensanpham = tbTonKho.getValueAt(row, 1).toString().trim();
            SanPhamDTO sanpham = SanPhamDAO.getInstance().selectProductByName(tensanpham);
            int makho = Integer.parseInt(txtMaKho.getText());
            DetailTonKho a = new DetailTonKho(sanpham.getMaSanPham(), makho, allowedActions);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnXuatKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatKhoActionPerformed
        XuatKhoDialog dialog = new XuatKhoDialog(this, true, allowedActions);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnXuatKhoActionPerformed


//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TonKhoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TonKhoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TonKhoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TonKhoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//////        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TonKhoGUI().setVisible(true);
//            }
//        });
//    }
    
    public void loadDataTotable(int makho){
        modelTonKho = (DefaultTableModel) tbTonKho.getModel();
        tbTonKho.setDefaultEditor(Object.class, null);
        ArrayList<tonKhoDTO> arr = tonKhoDAO.getInstance().getTonKho(makho);
        modelTonKho.setRowCount(0);
        int stt = 0;
        
        for(int i = 0; i< arr.size() ; i++){
            tonKhoDTO tkDTO = arr.get(i);
//            stt ++;
//            SanPhamDTO sp = SanPhamDAO.getInstance().selectProductByID(tkDTO.getMaSanPham());
//            int soLuong = 0;
//            ArrayList<tonKhoDTO> arrDetail = tonKhoDAO.getInstance().getDetailTonKho(tkDTO.getMaSanPham(), makho, true);
//            for(int j = 0; j< arrDetail.size() ; j++){
//                tonKhoDTO tonkho = arrDetail.get(j);
//                soLuong += tonkho.getSoLuong()  ;
//            }
            Object [] row = {tkDTO.getMaSanPham(), tkDTO.getTenSanPham(), tkDTO.getSoLuong() };
            modelTonKho.addRow(row);
        }
        
        for(int i = 0; i < tbTonKho.getColumnCount(); i++){
            tbTonKho.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    
    private void loadComboboxTenKho(){
        modalCbbTenkho = (DefaultComboBoxModel) cbbTenKho.getModel();
        ArrayList<khoDTO> khoList= khoDAO.getInstance().getListWareHouse();
        for(int i = 0; i < khoList.size() ; i++){
            khoDTO kho = khoList.get(i);
            String name = kho.getTenKho();
            modalCbbTenkho.addElement(name);
        }

    }



    private DefaultComboBoxModel modalCbbTenkho ;
    private DefaultTableModel modelTonKho ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnXuatKho;
    private javax.swing.JComboBox<String> cbbTenKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbTonKho;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKho;
    // End of variables declaration//GEN-END:variables
}
