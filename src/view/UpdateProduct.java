/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import DAO.SanPhamDAO;
import DAO.loaiSanPhamDAO;
import DTO.SanPhamDTO;
import DTO.loaiSanPhamDTO;
import OldDAO.LaptopDAO;
import OldDAO.PCDAO;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Laptop;
import model.PC;

/**
 *
 * @author Tran Nhat Sinh
 */
public class UpdateProduct extends javax.swing.JDialog {

    /**
     * Creates new form ThemSP
     */
    
    private ProductForm owner;
    DecimalFormat formatterE = new DecimalFormat("0");
    int idProduct;
    
    public UpdateProduct(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.owner = (ProductForm) parent;
        initComponents();
        setLocationRelativeTo(null);
        addCbbThuonghieu();
        
            SanPhamDTO sp = this.owner.getDetailSanPham();
            idProduct = sp.getMaSanPham();
            txtTenSanPham.setText(sp.getTenSanPham());
            txtOcung.setText(formatterE.format(sp.getGiaXuat()));
            txtCPU.setText(sp.getCpu());
            txtDonGia.setText(String.valueOf(sp.getGiaXuat()));
            txtRAM.setText(sp.getRam());
            txtTrongLuong.setText(String.valueOf(sp.getTrongLuong()));
            txtMauSac.setText(sp.getMauSac());
            txtOS.setText(sp.getOs());
            cbxloaisp.setSelectedIndex(0);
            txtKichThuocMan.setText(String.valueOf(sp.getManHinh()));
            txtDungLuongPin.setText(sp.getPin());
            txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
        
    }
    
    private UpdateProduct(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        jLabel3 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOcung = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCPU = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRAM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTrongLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMauSac = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxloaisp = new javax.swing.JComboBox<>();
        btnSaveChanged = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        laptop = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtKichThuocMan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDungLuongPin = new javax.swing.JTextField();
        pc = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtMainBoard = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCongsuatNguon = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtOS = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chỉnh sửa sản phẩm");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel3.setText("Tên sản phẩm");

        txtTenSanPham.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel4.setText("Số lượng");

        txtOcung.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel6.setText("CPU");

        txtCPU.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel7.setText("RAM");

        txtRAM.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel8.setText("Trọng lượng");

        txtTrongLuong.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        txtTrongLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrongLuongActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel9.setText("Màu sắc");

        txtMauSac.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel10.setText("Loại sản phẩm");

        cbxloaisp.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        cbxloaisp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxloaispItemStateChanged(evt);
            }
        });
        cbxloaisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxloaispActionPerformed(evt);
            }
        });

        btnSaveChanged.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnSaveChanged.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        btnSaveChanged.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveChanged.setText("Lưu thay đổi");
        btnSaveChanged.setBorder(null);
        btnSaveChanged.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveChanged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangedActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Huỷ bỏ");
        btnCancel.setBorder(null);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jPanel3.setLayout(new java.awt.CardLayout());

        laptop.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel11.setText("Kích thước màn");

        txtKichThuocMan.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel12.setText("Dung lượng PIN");

        txtDungLuongPin.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        javax.swing.GroupLayout laptopLayout = new javax.swing.GroupLayout(laptop);
        laptop.setLayout(laptopLayout);
        laptopLayout.setHorizontalGroup(
            laptopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laptopLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(laptopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKichThuocMan, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(laptopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laptopLayout.createSequentialGroup()
                            .addGroup(laptopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addGap(165, 165, 165))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laptopLayout.createSequentialGroup()
                            .addComponent(txtDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)))))
        );
        laptopLayout.setVerticalGroup(
            laptopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laptopLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKichThuocMan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtDungLuongPin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(laptop, "card2");

        pc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel13.setText("MainBoard");

        jLabel14.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel14.setText("Công suất nguồn");

        javax.swing.GroupLayout pcLayout = new javax.swing.GroupLayout(pc);
        pc.setLayout(pcLayout);
        pcLayout.setHorizontalGroup(
            pcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMainBoard)
            .addComponent(txtCongsuatNguon)
            .addGroup(pcLayout.createSequentialGroup()
                .addGroup(pcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 271, Short.MAX_VALUE))
        );
        pcLayout.setVerticalGroup(
            pcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pcLayout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMainBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCongsuatNguon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(pc, "card2");

        jLabel15.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel15.setText("OS");

        txtOS.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel16.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel16.setText("Đơn giá");

        txtDonGia.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N

        jLabel17.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel17.setText("Ổ cứng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                        .addComponent(txtSoLuong)
                                        .addComponent(txtDonGia)
                                        .addComponent(txtOcung))))
                            .addGap(106, 106, 106)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCPU, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(txtTrongLuong)
                                .addComponent(txtMauSac)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSaveChanged, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(cbxloaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxloaisp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveChanged, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTrongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOcung, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1110, 450));

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CẬP NHẬT THÔNG TIN SẢN PHẨM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(372, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(364, 364, 364))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveChangedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangedActionPerformed
        // TODO add your handling code here:
        String tenMay = txtTenSanPham.getText();
        int dongia = 0;

        try {
            dongia = Integer.parseInt(txtDonGia.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đơn giá ở dạng số !");
        }
        String manhinh = txtOcung.getText();
        String cpu = txtCPU.getText();
        String ram = txtRAM.getText();
        String vga = txtOS.getText();
        float trongluong = Float.parseFloat(txtTrongLuong.getText());
        String mausac = txtMauSac.getText();
        String os = txtOS.getText();
        String ocung = txtOcung.getText();
        String dungluongpin = txtDungLuongPin.getText();
        if ( tenMay.equals("") && cpu.equals("") && ram.equals("") && vga.equals("") && mausac.equals("") && ocung.equals("") && dungluongpin.equals("") && os.equals("") && manhinh.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin !");
        } else {
            SanPhamDTO spDTO = new SanPhamDTO();
            spDTO.setMaSanPham(idProduct);
            spDTO.setTenSanPham(tenMay);
            int maSo = loaiSanPhamDAO.getInstance().getIDOfType(cbxloaisp.getSelectedItem().toString());
            spDTO.setLoaiSanPham(maSo);
            spDTO.setGiaXuat(dongia);
            spDTO.setSoLuong(0);
            spDTO.setManHinh(manhinh);
            spDTO.setOs(os);
            spDTO.setPin(dungluongpin);
            spDTO.setoCung(ocung);
            spDTO.setMauSac(mausac);
            spDTO.setRam(ram);
            spDTO.setVga(vga);
            spDTO.setTrongLuong(trongluong);

            try {
                SanPhamDAO.getInstance().updateProduct(spDTO);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Sửa sản phẩm thành công !");
                owner.loadDataToTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Sửa sản phẩm thất bại !");
            }
        }

    }//GEN-LAST:event_btnSaveChangedActionPerformed

    private void cbxloaispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxloaispActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxloaispActionPerformed

    private void cbxloaispItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxloaispItemStateChanged

    }//GEN-LAST:event_cbxloaispItemStateChanged

    private void txtTrongLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrongLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrongLuongActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void addCbbThuonghieu(){
        modalCbb = (DefaultComboBoxModel) cbxloaisp.getModel();
        ArrayList<loaiSanPhamDTO> lsp = loaiSanPhamDAO.getInstance().getTypeOfProduct();
        for(int i = 0; i < lsp.size() ; i++){
            loaiSanPhamDTO item = lsp.get(i);
            modalCbb.addElement(item.getTenLoaiSanPham());
        }
        
        
    }
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
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateProduct dialog = new UpdateProduct(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private DefaultComboBoxModel modalCbb ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSaveChanged;
    private javax.swing.JComboBox<String> cbxloaisp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel laptop;
    private javax.swing.JPanel pc;
    private javax.swing.JTextField txtCPU;
    private javax.swing.JTextField txtCongsuatNguon;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDungLuongPin;
    private javax.swing.JTextField txtKichThuocMan;
    private javax.swing.JTextField txtMainBoard;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtOS;
    private javax.swing.JTextField txtOcung;
    private javax.swing.JTextField txtRAM;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTrongLuong;
    // End of variables declaration//GEN-END:variables
}
