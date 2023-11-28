/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import BUS.ChiTietQuyenBUS;
import DTO.ChiTietQuyenDTO;
import DTO.NguoiDungDTO;
import DTO.NhaCungCapDTO;
import BUS.SearchNhaCungCap;
import DAO.NhaCungCapDAO;
import java.awt.Desktop;
import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import BUS.NhaCungCapBUS;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Tran Nhat Sinh
 */
public class NhaCungCapForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form NhaCungCapForm
     */
    private DefaultTableModel tblModel;
    private final ChiTietQuyenBUS ctqBUS = new ChiTietQuyenBUS();
    NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    public NhaCungCapForm(NguoiDungDTO user) {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        tblNCC.setDefaultEditor(Object.class, null);
        initTable();
        
        // Authorization
        javax.swing.JButton[] buttons = {btnAdd, btnDelete, btnEdit};
        disableAllButtons(buttons);
        authorizeAction(user);
        
        loadDataToTable();
    }

    public NhaCungCapForm() {
        initComponents();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        tblNCC.setDefaultEditor(Object.class, null);
        initTable();
        loadDataToTable();
    }
    
    private void disableAllButtons(javax.swing.JButton[] buttons) {
        for (javax.swing.JButton btn : buttons) {
            btn.setEnabled(false);
        }
    }
    
    private void authorizeAction(NguoiDungDTO user) {
        // Get all allowed actions in this functionality
        List<ChiTietQuyenDTO> allowedActions = new ArrayList<>();
        try {
            allowedActions = ctqBUS.getAllowedActions(user.getMaNhomQuyen(), "nhacungcap");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(NhaCungCapForm.this, "Lỗi kết nối cơ sở dữ liệu", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(NhaCungCapForm.this, "Lỗi không xác định", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        
        for (ChiTietQuyenDTO ctq : allowedActions) {
            if (ctq.getHanhDong().equals("create")) {
                btnAdd.setEnabled(true);
                continue;
            }
            if (ctq.getHanhDong().equals("update")) {
                btnEdit.setEnabled(true);
                continue;
            }
            if (ctq.getHanhDong().equals("delete")) {
                btnDelete.setEnabled(true);
                continue;
            }
        }
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã NCC", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblNCC.setModel(tblModel);
        tblNCC.getColumnModel().getColumn(0).setPreferredWidth(1);
        tblNCC.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblNCC.getColumnModel().getColumn(2).setPreferredWidth(2);
        tblNCC.getColumnModel().getColumn(3).setPreferredWidth(350);
    }

    public void loadDataToTable() {
        try {
            ArrayList<NhaCungCapDTO> ncc = new ArrayList<NhaCungCapDTO>();
            ncc = nccBUS.selectAll();
            tblModel.setRowCount(0);
            for (NhaCungCapDTO i : ncc) {
                tblModel.addRow(new Object[]{
                    i.getMaNhaCungCap(), i.getTenNhaCungCap(), i.getSdt(), i.getDiaChi()
                });
            }
        } catch (Exception e) {
        }
    }

    public NhaCungCapDTO getNhaCungCapSelect() {
        int i_row = tblNCC.getSelectedRow();
        NhaCungCapDTO ncc = NhaCungCapDAO.getInstance().selectAll().get(i_row);
        return ncc;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbxlLuaChon = new javax.swing.JComboBox<>();
        txtSearchForm = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNCC = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÊM TÀI KHOẢN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ và tên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên đăng nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Vai trò");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Thêm tài khoản");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, 269, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnAdd.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_40px.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnDelete.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_40px.png"))); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setFocusable(false);
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);

        btnEdit.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_40px.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);

        jPanel2.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxlLuaChon.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        cbxlLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ" }));
        jPanel3.add(cbxlLuaChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 40));

        txtSearchForm.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        txtSearchForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchFormActionPerformed(evt);
            }
        });
        txtSearchForm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchFormKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchFormKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearchForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 400, 40));

        btnReset.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel3.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 120, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 760, 90));

        jScrollPane1.setBorder(null);

        tblNCC.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NCC", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"
            }
        ));
        tblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNCCMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblNCC);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1160, 620));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddNhaCungCap a = new AddNhaCungCap(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tblNCC.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp muốn sửa");
        } else {
            UpdateNhaCungCap up = new UpdateNhaCungCap(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            up.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (tblNCC.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá nhà cung cấp", "Xác nhận xoá nhà cung cấp", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, nccBUS.deleteNhaCungCap(getNhaCungCapSelect()));
                loadDataToTable();
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtSearchForm.setText("");
        cbxlLuaChon.setSelectedIndex(0);
        loadDataToTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSearchFormKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchFormKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFormKeyPressed

    private void txtSearchFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchFormActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFormActionPerformed

    private void txtSearchFormKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchFormKeyReleased
        // TODO add your handling code here:
        String luachon = (String) cbxlLuaChon.getSelectedItem();
        String searchContent = txtSearchForm.getText();
        ArrayList<NhaCungCapDTO> result = new ArrayList<NhaCungCapDTO>();
        switch (luachon) {
            case "Tất cả":
                result = SearchNhaCungCap.getInstance().searchTatCa(searchContent);
                break;
            case "Mã nhà cung cấp":
                result = SearchNhaCungCap.getInstance().searchMaNCC(searchContent);
                break;
            case "Tên nhà cung cấp":
                result = SearchNhaCungCap.getInstance().searchTenNCC(searchContent);
                break;
            case "Địa chỉ":
                result = SearchNhaCungCap.getInstance().searchDiaChi(searchContent);
                break;
            case "Số điện thoại":
                result = SearchNhaCungCap.getInstance().searchSdt(searchContent);
                break;
        }
        loadDataToTableSearch(result);
    }//GEN-LAST:event_txtSearchFormKeyReleased

    private void tblNCCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNCCMousePressed
        // TODO add your handling code here:
        JTable table = (JTable) evt.getSource();
                Point point = evt.getPoint();
                int row = table.rowAtPoint(point);
                int row_i = table.getSelectedRow();
                
                NhaCungCapDTO ncc = getNhaCungCapSelect();
                if(evt.getClickCount() == 2 && table.getSelectedRow() != -1 ){
                          ChiTietCungCap ql = new ChiTietCungCap(ncc );
                          ql.setVisible(true);
                }
    }//GEN-LAST:event_tblNCCMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxlLuaChon;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTextField txtSearchForm;
    // End of variables declaration//GEN-END:variables

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void loadDataToTableSearch(ArrayList<NhaCungCapDTO> result) {
        try {
           
            tblModel.setRowCount(0);
            for (NhaCungCapDTO i : result) {
                tblModel.addRow(new Object[]{
                    i.getMaNhaCungCap(), i.getTenNhaCungCap(), i.getSdt(), i.getDiaChi()
                });
            }
        } catch (Exception e) {
        }
    }

}
