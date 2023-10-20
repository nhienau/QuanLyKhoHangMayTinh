/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DAO.SanPhamDAO;
import DAO.khoDAO;
import DAO.tonKhoDAO;
import DTO.SanPhamDTO;
import DTO.khoDTO;
import DTO.tonKhoDTO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trant
 */
public class TonKhoGUI extends javax.swing.JFrame {
    
     DecimalFormat formatter = new DecimalFormat("###, ###, ###");
    public TonKhoGUI() {
        initComponents();
        addComboboxWareHouse();
        //loadDataOfWareHouse();
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        labelKho = new javax.swing.JLabel();
        jScrollPaneTbKho = new javax.swing.JScrollPane();
        tbTonKho = new javax.swing.JTable();
        cbbKho = new javax.swing.JComboBox<>();
        
        
        KhoCBBScrollPane = new JScrollPane(cbbKho);
        
        btnQuery = new JButton("Truy xuất");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        lbMaKho = new JLabel();
        lbMaKho.setText("Mã kho: ");
        lbDiaDiem = new JLabel();
        lbDiaDiem.setText("Địa điểm");
        
        txtMaKho = new JTextField();
        txtMaKho.setEditable(false);
        txtDiaDiem = new JTextField();
        txtDiaDiem.setEditable(false);

        labelKho.setText("Kho");
        
        modelKho = new DefaultTableModel(){
             @Override
           public boolean isCellEditable(int row, int column){
               return false;
           }
        };
        
        modelKho.addColumn("STT");
        modelKho.addColumn("Mã sản phẩm");
        modelKho.addColumn("Tên sản phẩm");
        modelKho.addColumn("Giá nhập");
        modelKho.addColumn("Số lượng");
        modelKho.addColumn("Nhà cung cấp");
        
        
        tbTonKho.setModel(modelKho);
        
        tbTonKho.getColumnModel().getColumn(0).setPreferredWidth(5);
        tbTonKho.getColumnModel().getColumn(1).setPreferredWidth(17);
        tbTonKho.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbTonKho.getColumnModel().getColumn(3).setPreferredWidth(30);
        
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        tbTonKho.setDefaultRenderer(String.class, renderer);
        tbTonKho.getTableHeader().setDefaultRenderer(renderer);
        

        MatteBorder border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
        tbTonKho.setBorder(border);
       
  
        cbbKho.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                ArrayList<khoDTO> kho = khoDAO.getInstance().getListWareHouse();
                int index = cbbKho.getSelectedIndex();
                if(index != -1 ){
                   khoDTO item = kho.get(index); 
                   txtMaKho.setText(String.valueOf(item.getMaKho()));
                   txtDiaDiem.setText(item.getDiaDiem());
                }
                loadDataOfWareHouse();
            }
        });
        
        btnInforKho = new JButton("Thông tin kho");
        btnInforKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInforKhoActionPerformed();
            }
        });
        
        jScrollPaneTbKho.setViewportView(tbTonKho);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.white);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInforKho))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneTbKho, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelKho, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(KhoCBBScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10,Short.MAX_VALUE)
                        .addComponent(btnQuery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,  15, Short.MAX_VALUE)
                        .addComponent(lbMaKho,javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,  5, Short.MAX_VALUE)
                        .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 100, Short.MAX_VALUE)
                        .addComponent(lbDiaDiem,javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE )
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addComponent(txtDiaDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE )
                        
                    ))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInforKho))
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKho)
                    .addComponent(KhoCBBScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuery)
                    .addComponent(lbMaKho )
                    .addComponent(txtMaKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDiaDiem)
                    .addComponent(txtDiaDiem,javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneTbKho, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>    
    
    public void addComboboxWareHouse(){
        
        ArrayList<khoDTO> listKho = khoDAO.getInstance().getListWareHouse();
        DefaultComboBoxModel modalCbbKho = new DefaultComboBoxModel();
        for( khoDTO i : listKho){
           String name = i.getTenKho();
           modalCbbKho.addElement(name);
           
        }
        cbbKho.setModel(modalCbbKho);
    }
    
    
    public void loadDataOfWareHouse(){
        int makho = Integer.parseInt( txtMaKho.getText());
        int stt =0;
        modelKho.setRowCount(0);

        ArrayList<tonKhoDTO> tonkhoList = tonKhoDAO.getInstance().getTonKho(makho);
        for(int i = 0 ; i< tonkhoList.size() ; i++){
            tonKhoDTO tkDTO =  tonkhoList.get(i);
            stt += 1;
            int maSanPham = tkDTO.getMaSanPham();
            SanPhamDTO  sanpham = SanPhamDAO.getInstance().selectProductByID(tkDTO.getMaSanPham());
            String tenSanPham = sanpham.getTenSanPham();
            int soLuong = tkDTO.getSoLuong();
            int giaNhap = tkDTO.getGiaNhap();
            int maNhaCungCap = tkDTO.getMaNhaCungCap();
           Object row[] = {stt, maSanPham, tenSanPham, formatter.format(giaNhap) + "đ", soLuong, maNhaCungCap};
           modelKho.addRow(row);

        }
        
        for(int i = 0; i < tbTonKho.getColumnCount(); i++){
            tbTonKho.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        
    }
    public void btnInforKhoActionPerformed(){
        khoGUI kho = new khoGUI();
        kho.setVisible(true);
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
            java.util.logging.Logger.getLogger(TonKhoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TonKhoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TonKhoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TonKhoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TonKhoGUI().setVisible(true);
            }
        });
    }
        
    private javax.swing.JComboBox<String> cbbKho;
    private javax.swing.JScrollPane jScrollPaneTbKho;
    private javax.swing.JLabel labelKho;
    private javax.swing.JTable tbTonKho;
    private JScrollPane KhoCBBScrollPane;
    private JLabel lbMaKho, lbDiaDiem ;
    private JTextField txtMaKho ,txtDiaDiem;
    private JButton btnQuery , btnInforKho;
    private DefaultTableModel modelKho ;
    private DefaultTableCellRenderer renderer;
    
}
