/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.loaiSanPhamDAO;
import DTO.loaiSanPhamDTO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import view.updateLoaiSanPham;
import view.addLoaiSanPham;

/**
 *
 * @author trant
 */
public class loaiSanPhamGUI extends javax.swing.JFrame{

    /**
     * Creates new form LoaiSanPhamGUI
     */
    public loaiSanPhamGUI() {
        initComponents();
        tbLoaiSanPham.setDefaultEditor(Object.class, null);
        modelLoaiSanPham = (DefaultTableModel) tbLoaiSanPham.getModel();
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        loadDataToTable();
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
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnXuatExcel = new javax.swing.JButton();
        btnNhapExcel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxLuaChon = new javax.swing.JComboBox<>();
        jTextFieldSearch = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLoaiSanPham = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

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

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_40px.png"))); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);

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
        jToolBar1.add(jSeparator1);

        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_spreadsheet_file_40px.png"))); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXuatExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });
        jToolBar1.add(btnXuatExcel);

        btnNhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_xls_40px.png"))); // NOI18N
        btnNhapExcel.setText("Nhập Excel");
        btnNhapExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNhapExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapExcelActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNhapExcel);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên thương hiệu" }));
        jComboBoxLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLuaChonActionPerformed(evt);
            }
        });
        jComboBoxLuaChon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxLuaChonPropertyChange(evt);
            }
        });
        jPanel3.add(jComboBoxLuaChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 140, 40));

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });
        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 260, 40));

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel3.add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 120, 40));

        tbLoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Tên thương hiệu"
            }
        ));
        jScrollPane1.setViewportView(tbLoaiSanPham);
        if (tbLoaiSanPham.getColumnModel().getColumnCount() > 0) {
            tbLoaiSanPham.getColumnModel().getColumn(0).setResizable(false);
            tbLoaiSanPham.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        addLoaiSanPham a = new addLoaiSanPham();
        a.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        int row = tbLoaiSanPham.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thương hiệu cần xóa");
            return;
        } 
        String tenLoaiSanPham = tbLoaiSanPham.getValueAt(row, 1).toString();
        int maLoaiSP = loaiSanPhamDAO.getInstance().getIDOfType(tenLoaiSanPham);
        if(loaiSanPhamDAO.getInstance().hasProduct(maLoaiSP) == true){
            JOptionPane.showMessageDialog(this, "Thương hiệu này vẫn còn sản phẩm, vui lòng không xóa!");
            return;
        } 
        if(loaiSanPhamDAO.getInstance().deleteTypeOfProduct(maLoaiSP)){
            
            JOptionPane.showMessageDialog(this, "Xóa thương hiệu thành công!");
            loadDataToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thương hiệu thất bại!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (tbLoaiSanPham.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thương hiệu cần sửa");
        } else {
            int row = tbLoaiSanPham.getSelectedRow();
            String name = tbLoaiSanPham.getValueAt(row, 1).toString();
            int id = loaiSanPhamDAO.getInstance().getIDOfType(name);
            updateLoaiSanPham a = new updateLoaiSanPham(id, name );
            a.setVisible(true);
            loadDataToTable();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        // TODO add your handling code here:
//        try {
//            JFileChooser jFileChooser = new JFileChooser();
//            jFileChooser.showSaveDialog(this);
//            File saveFile = jFileChooser.getSelectedFile();
//            if (saveFile != null) {
//                saveFile = new File(saveFile.toString() + ".xlsx");
//                Workbook wb = new XSSFWorkbook();
//                Sheet sheet = wb.createSheet("Product");
//
//                Row rowCol = sheet.createRow(0);
//                for (int i = 0; i < tblSanPham.getColumnCount(); i++) {
//                    Cell cell = rowCol.createCell(i);
//                    cell.setCellValue(tblSanPham.getColumnName(i));
//                }
//
//                for (int j = 0; j < tblSanPham.getRowCount(); j++) {
//                    Row row = sheet.createRow(j + 1);
//                    for (int k = 0; k < tblSanPham.getColumnCount(); k++) {
//                        Cell cell = row.createCell(k);
//                        if (tblSanPham.getValueAt(j, k) != null) {
//                            cell.setCellValue(tblSanPham.getValueAt(j, k).toString());
//                        }
//
//                    }
//                }
//                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
//                wb.write(out);
//                wb.close();
//                out.close();
//                openFile(saveFile.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void btnNhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapExcelActionPerformed
        // TODO add your handling code here:
        //        File excelFile;
        //        FileInputStream excelFIS = null;
        //        BufferedInputStream excelBIS = null;
        //        XSSFWorkbook excelJTableImport = null;
        //        ArrayList<SanPhamDTO> listAccExcel = new ArrayList<SanPhamDTO>();
        //        JFileChooser jf = new JFileChooser();
        //        int result = jf.showOpenDialog(null);
        //        jf.setDialogTitle("Open file");
        //        Workbook workbook = null;
        //        if (result == JFileChooser.APPROVE_OPTION) {
            //            try {
                //                excelFile = jf.getSelectedFile();
                //                excelFIS = new FileInputStream(excelFile);
                //                excelBIS = new BufferedInputStream(excelFIS);
                //                excelJTableImport = new XSSFWorkbook(excelBIS);
                //                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                //                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    //                    XSSFRow excelRow = excelSheet.getRow(row);
                    //                    String maMay = excelRow.getCell(0).getStringCellValue();
                    //                    String tenMay = excelRow.getCell(1).getStringCellValue();
                    //                    int soLuong = (int) excelRow.getCell(2).getNumericCellValue();
                    //                    String giaFomat = excelRow.getCell(3).getStringCellValue().replaceAll(",", "");
                    //                    int viTri = giaFomat.length() - 1;
                    //                    String giaoke = giaFomat.substring(0, viTri) + giaFomat.substring(viTri + 1);
                    //                    double donGia = Double.parseDouble(giaoke);
                    //                    String boXuLi = excelRow.getCell(4).getStringCellValue();
                    //                    String ram = excelRow.getCell(5).getStringCellValue();
                    //                    String boNho = excelRow.getCell(6).getStringCellValue();
                    //                    MayTinh mt = new MayTinh(maMay, tenMay, soLuong, donGia, boXuLi, ram, "", "", boNho, 1);
                    //                    listAccExcel.add(mt);
                    //                    DefaultTableModel table_acc = (DefaultTableModel) tblSanPham.getModel();
                    //                    table_acc.setRowCount(0);
                    //                    loadDataToTableSearch(listAccExcel);
                    //                }
                //            } catch (FileNotFoundException ex) {
                //                Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
                //            } catch (IOException ex) {
                //                Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
                //            }
            //        }
        //        for (int i = 0; i < listAccExcel.size(); i++) {
            //            SanPhamDTO spDTO = listAccExcel.get(i);
            //            if (mayTinh.getMaMay().contains("LP")) {
                //                Laptop lapNew = new Laptop(0, "", mayTinh.getMaMay(),
                    //                        mayTinh.getTenMay(), mayTinh.getSoLuong(), mayTinh.getGia(), mayTinh.getTenCpu(),
                    //                        mayTinh.getRam(), mayTinh.getXuatXu(), mayTinh.getCardManHinh(), mayTinh.getRom(), 1);
                //                LaptopDAO.getInstance().insert(lapNew);
                //            } else if (mayTinh.getMaMay().contains("PC")) {
                //                PC pcNew = new PC("", 0, mayTinh.getMaMay(), mayTinh.getTenMay(), mayTinh.getSoLuong(),
                    //                        mayTinh.getGia(), mayTinh.getTenCpu(), mayTinh.getRam(), mayTinh.getXuatXu(), mayTinh.getCardManHinh(),
                    //                        mayTinh.getRom(), mayTinh.getTrangThai());
                //                PCDAO.getInstance().insert(pcNew);
                //            } else {
                //                JOptionPane.showMessageDialog(this, "Mã máy " + mayTinh.getMaMay() + " không phù hợp !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                //            }
            //        }
    }//GEN-LAST:event_btnNhapExcelActionPerformed

    private void jComboBoxLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<loaiSanPhamDTO> result = searchLoaiSanPham(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jComboBoxLuaChonActionPerformed

    private void jComboBoxLuaChonPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonPropertyChange
        // TODO add your handling code here:
        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<loaiSanPhamDTO> result = searchLoaiSanPham(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jComboBoxLuaChonPropertyChange

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:
        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<loaiSanPhamDTO> result =  searchLoaiSanPham(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        jComboBoxLuaChon.setSelectedIndex(0);
        loadDataToTable();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    
    
    public ArrayList<loaiSanPhamDTO> searchLoaiSanPham(String luaChon, String content) {
        ArrayList<loaiSanPhamDTO> result = new ArrayList<>();
        loaiSanPhamDAO search = new loaiSanPhamDAO();
        switch (luaChon) {
            case "Tên thương hiệu":
                result = search.searchTenLoaiSanPham(content);
                break;
           
        }
        return result;
    }

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
            java.util.logging.Logger.getLogger(loaiSanPhamGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loaiSanPhamGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loaiSanPhamGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loaiSanPhamGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loaiSanPhamGUI().setVisible(true);
            }
        });
    }
    
    
    
    public void loadDataToTable() {
        ArrayList<loaiSanPhamDTO> arr = loaiSanPhamDAO.getInstance().getTypeOfProduct();
        modelLoaiSanPham.setRowCount(0);
        int stt = 0;
        for(int i = 0; i< arr.size() ; i++){
            loaiSanPhamDTO lspDTO = arr.get(i);
            stt ++;
            Object [] row = {stt, lspDTO.getTenLoaiSanPham()  };
            modelLoaiSanPham.addRow(row);
        }
        
        for(int i = 0; i < tbLoaiSanPham.getColumnCount(); i++){
            tbLoaiSanPham.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    
    public void loadDataToTableSearch(ArrayList<loaiSanPhamDTO> result) {
        try {
            modelLoaiSanPham.setRowCount(0);
            int stt = 0;
            for (loaiSanPhamDTO i : result) {
                stt ++;
                modelLoaiSanPham.addRow(new Object[]{
                    stt, i.getTenLoaiSanPham()
                });
            }
        } catch (Exception e) {
        }
    }
    
    
    private DefaultTableCellRenderer renderer;
    private DefaultTableModel modelLoaiSanPham ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNhapExcel;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> jComboBoxLuaChon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbLoaiSanPham;
    // End of variables declaration//GEN-END:variables
}