/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.SanPhamDAO;
import DAO.khoDAO;
import DAO.tonKhoDAO;
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
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import view.DetailTonKho;


public class TonKhoGUI extends javax.swing.JInternalFrame  {


    DefaultTableCellRenderer renderer;
    
    public TonKhoGUI() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        initComponents();
        loadComboboxTenKho();

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
        btnKhoInf = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnXuatExcel = new javax.swing.JButton();
        btnNhapExcel = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbTenKho = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMaKho = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTonKho = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1180, 774));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnKhoInf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/warehouse.png"))); // NOI18N
        btnKhoInf.setText("Thông tin kho");
        btnKhoInf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhoInf.setFocusable(false);
        btnKhoInf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoInf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoInfActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKhoInf);
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
        btnNhapExcel.setFocusable(false);
        btnNhapExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNhapExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapExcelActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNhapExcel);

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

        txtMaKho.setText(" ");
        txtMaKho.setEnabled(false);

        jLabel3.setText("Địa chỉ: ");

        txtDiaChi.setText(" ");
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
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbTenKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng"
            }
        ));
        tbTonKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTonKhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTonKho);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhoInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoInfActionPerformed
        khoGUI kho = new khoGUI();
        kho.setVisible(true);
    }//GEN-LAST:event_btnKhoInfActionPerformed

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
            DetailTonKho a = new DetailTonKho(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled, sanpham.getMaSanPham(), makho);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnDetailActionPerformed


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
            stt ++;
            SanPhamDTO sp = SanPhamDAO.getInstance().selectProductByID(tkDTO.getMaSanPham());
            Object [] row = {stt, sp.getTenSanPham(), tkDTO.getSoLuong()  };
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
    private javax.swing.JButton btnKhoInf;
    private javax.swing.JButton btnNhapExcel;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cbbTenKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbTonKho;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKho;
    // End of variables declaration//GEN-END:variables
}
