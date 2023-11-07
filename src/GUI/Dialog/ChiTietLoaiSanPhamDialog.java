package GUI.Dialog;

import BUS.ThongKeBUS;
import DTO.DateRangeDTO;
import DTO.ThongKe.ChiTietLoaiSanPhamDTO;
import DTO.ThongKe.ThongKeLoaiSanPhamDTO;
import GUI.Chart.PieChart.ModelPieChart;
import GUI.ThongKeGUI;
import com.formdev.flatlaf.FlatLightLaf;
import helper.ChartColor;
import helper.CustomTableCellRenderer;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class ChiTietLoaiSanPhamDialog extends StatDetailDialog {
    private final ThongKeBUS tkBUS = new ThongKeBUS();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ArrayList<ChiTietLoaiSanPhamDTO> arr;
    private DateRangeDTO dateRange;
    
    public ChiTietLoaiSanPhamDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public ChiTietLoaiSanPhamDialog(JInternalFrame parent, javax.swing.JFrame owner, boolean modal, DateRangeDTO dateRange, ThongKeLoaiSanPhamDTO productType) {
        super(owner, modal);
        this.dateRange = dateRange;
        initTable();
        displayInfo(productType, dateRange);
        getChiTietLoaiSanPham(productType, dateRange);
    }

    public ArrayList<ChiTietLoaiSanPhamDTO> getArr() {
        return arr;
    }

    public void setArr(ArrayList<ChiTietLoaiSanPhamDTO> arr) {
        this.arr = arr;
    }

    public DateRangeDTO getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRangeDTO dateRange) {
        this.dateRange = dateRange;
    }

    private void displayInfo(ThongKeLoaiSanPhamDTO productType, DateRangeDTO dateRange) {
        super.setTitle("Chi tiết loại sản phẩm");
        getLblPrimary().setText("Loại sản phẩm: " + productType.getTenLoaiSanPham());
        getLblSecondary().setVisible(false);
        if (dateRange.getFromDate() == null && dateRange.getToDate() == null) {
            getLblTime().setText(ThongKeGUI.CB_VALUE_LIFETIME);
        } else {
            getLblTime().setText("Thời gian: " + dateRange.getFromDate().format(formatter) + " - " + dateRange.getToDate().format(formatter));         
        }
        getLblAmount().setText("Số lượng xuất: " + productType.getSoLuong());
    }
    
    private void addDataToChart(ArrayList<ChiTietLoaiSanPhamDTO> arr) {
        boolean paintAll = arr.size() <= 7;
        int valueOther = 0;
        for (int i = 0; i < arr.size(); ++i) {
            if (paintAll || i < 6) {
                getPieChart().addData(new ModelPieChart(arr.get(i).getTenSanPham(), arr.get(i).getSoLuong(), ChartColor.chartColor[i]));
            } else {
                valueOther += arr.get(i).getSoLuong();
            }
        }
        if (!paintAll) {
            getPieChart().addData(new ModelPieChart("Khác", valueOther, ChartColor.chartColor[ChartColor.chartColor.length - 1]));
        }
    }

    private void getChiTietLoaiSanPham(ThongKeLoaiSanPhamDTO productType, DateRangeDTO dateRange) {
        ArrayList<ChiTietLoaiSanPhamDTO> arr = new ArrayList<>();
        try {
            arr = tkBUS.chiTietLoaiSanPham(dateRange, productType.getMaLoaiSanPham());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ChiTietLoaiSanPhamDialog.this, "Lỗi kết nối cơ sở dữ liệu", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ChiTietLoaiSanPhamDialog.this, "Lỗi không xác định", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        DefaultTableModel model = (DefaultTableModel) getTable().getModel();
        model.setRowCount(0);
        if (arr.isEmpty()) return;
        setArr(arr);
        for (int i = 0; i < arr.size(); ++i) {
            ChiTietLoaiSanPhamDTO ctlsp = arr.get(i);
            int maSanPham = ctlsp.getMaSanPham();
            String tenSanPham = ctlsp.getTenSanPham();
            int soLuong = ctlsp.getSoLuong();
            Object [] row = {maSanPham, tenSanPham, soLuong};
            model.addRow(row);
        }
        getTable().getColumnModel().getColumn(0).setCellRenderer(CustomTableCellRenderer.LEFT);
        getTable().getColumnModel().getColumn(1).setCellRenderer(CustomTableCellRenderer.RIGHT);
        addDataToChart(arr);
    }
    
    private void handleViewGiaXuat(int row) {
        ChiTietLoaiSanPhamDTO product = arr.get(row);
        ChiTietGiaXuatSPDialog chiTietGiaXuat = new ChiTietGiaXuatSPDialog(this, true, product, this.dateRange);
        chiTietGiaXuat.setVisible(true);
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
            java.util.logging.Logger.getLogger(ChiTietLoaiSanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietLoaiSanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietLoaiSanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietLoaiSanPhamDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(ChiTietLoaiSanPhamDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                ChiTietLoaiSanPhamDialog dialog = new ChiTietLoaiSanPhamDialog(new javax.swing.JFrame(), true);
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

    @Override
    public void initTable() {
        getTable().setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng xuất"
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
            handleViewGiaXuat(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
