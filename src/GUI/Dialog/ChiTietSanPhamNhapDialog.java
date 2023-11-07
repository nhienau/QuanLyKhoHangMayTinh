package GUI.Dialog;

import BUS.ThongKeBUS;
import DTO.DateRangeDTO;
import DTO.ThongKe.ChiTietSanPhamNhapDTO;
import DTO.ThongKe.ThongKeSanPhamDTO;
import GUI.Chart.PieChart.ModelPieChart;
import GUI.ThongKeGUI;
import com.formdev.flatlaf.FlatLightLaf;
import helper.ChartColor;
import helper.CustomTableCellRenderer;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class ChiTietSanPhamNhapDialog extends StatDetailDialog {
    private final ThongKeBUS tkBUS = new ThongKeBUS();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ArrayList<ChiTietSanPhamNhapDTO> arr;
    private ThongKeSanPhamDTO product;
    private DateRangeDTO dateRange;

    public ArrayList<ChiTietSanPhamNhapDTO> getArr() {
        return arr;
    }

    public void setArr(ArrayList<ChiTietSanPhamNhapDTO> arr) {
        this.arr = arr;
    }

    public ThongKeSanPhamDTO getProduct() {
        return product;
    }

    public void setProduct(ThongKeSanPhamDTO product) {
        this.product = product;
    }

    public DateRangeDTO getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRangeDTO dateRange) {
        this.dateRange = dateRange;
    }
    
    public ChiTietSanPhamNhapDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }
    
    public ChiTietSanPhamNhapDialog(JInternalFrame parent, javax.swing.JFrame owner, boolean modal, DateRangeDTO dateRange, ThongKeSanPhamDTO product) {
        super(owner, modal);
        this.product = product;
        this.dateRange = dateRange;
        initTable();
        displayInfo(product, dateRange);
        this.arr = thongKeChiTietSanPhamNhap(dateRange, product.getMaSanPham());
    }
    
    private void displayInfo(ThongKeSanPhamDTO product, DateRangeDTO dateRange) {
        super.setTitle("Chi tiết sản phẩm");
        getLblPrimary().setText("Tên sản phẩm: " + product.getTenSanPham());
        getLblSecondary().setText("Loại sản phẩm: " + product.getTenLoaiSanPham());
        if (dateRange.getFromDate() == null && dateRange.getToDate() == null) {
            getLblTime().setText(ThongKeGUI.CB_VALUE_LIFETIME);
        } else {
            getLblTime().setText("Thời gian: " + dateRange.getFromDate().format(formatter) + " - " + dateRange.getToDate().format(formatter));
        }
        getLblAmount().setText("Tổng số lượng nhập: " + product.getSoLuongNhap());
    }
    
    private void addDataToChart(ArrayList<ChiTietSanPhamNhapDTO> arr) {
        boolean paintAll = arr.size() <= 7;
        int valueOther = 0;
        for (int i = 0; i < arr.size(); ++i) {
            if (paintAll || i < 6) {
                getPieChart().addData(new ModelPieChart(arr.get(i).getTenNhaCungCap(), arr.get(i).getTongSoLuongNhap(), ChartColor.chartColor[i]));
            } else {
                valueOther += arr.get(i).getTongSoLuongNhap();
            }
        }
        if (!paintAll) {
            getPieChart().addData(new ModelPieChart("Khác", valueOther, ChartColor.chartColor[ChartColor.chartColor.length - 1]));
        }
    }
    
    private ArrayList<ChiTietSanPhamNhapDTO> thongKeChiTietSanPhamNhap(DateRangeDTO dateRange, int productId) {
        ArrayList<ChiTietSanPhamNhapDTO> arr = new ArrayList<>();
        try {
            arr = tkBUS.thongKeChiTietSanPhamNhap(dateRange, productId);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ChiTietSanPhamNhapDialog.this, "Lỗi kết nối cơ sở dữ liệu", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return arr;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ChiTietSanPhamNhapDialog.this, "Lỗi không xác định", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return arr;
        }
        DefaultTableModel model = (DefaultTableModel) getTable().getModel();
        model.setRowCount(0);
        if (arr.isEmpty()) return arr;
        setArr(arr);
        for (int i = 0; i < arr.size(); ++i) {
            ChiTietSanPhamNhapDTO ctspnDTO = arr.get(i);
            int maNhaCungCap = ctspnDTO.getMaNhaCungCap();
            String tenNhaCungCap = ctspnDTO.getTenNhaCungCap();
            int tongSoLuongNhap = ctspnDTO.getTongSoLuongNhap();
            Object [] row = {maNhaCungCap, tenNhaCungCap, tongSoLuongNhap};
            model.addRow(row);
        }
        getTable().getColumnModel().getColumn(0).setCellRenderer(CustomTableCellRenderer.LEFT);
        getTable().getColumnModel().getColumn(1).setCellRenderer(CustomTableCellRenderer.RIGHT);
        addDataToChart(arr);
        return arr;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết nhập hàng");
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void handleViewGiaNhap(int row) {
        ChiTietSanPhamNhapDTO provider = arr.get(row);
        ChiTietGiaNhapNCCDialog chiTietGiaNhap = new ChiTietGiaNhapNCCDialog(this, true, this.product, provider, this.dateRange);
        chiTietGiaNhap.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
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
            java.util.logging.Logger.getLogger(ChiTietSanPhamNhapDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamNhapDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamNhapDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamNhapDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        UIManager.setLookAndFeel(new FlatLightLaf());
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiTietSanPhamNhapDialog dialog = new ChiTietSanPhamNhapDialog(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void initTable() {
        getTable().setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Nhà cung cấp", "Số lượng nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        getTable().getColumnModel().getColumn(1).setPreferredWidth(400);
        getTable().getColumnModel().removeColumn(getTable().getColumnModel().getColumn(0));
    }
    
    @Override
    public void onClickTable(MouseEvent evt) {
        if(evt.getClickCount() == 2 && getTable().getSelectedRow() != -1) {
            int row = getTable().getSelectedRow();
            handleViewGiaNhap(row);
        }
    }
}
