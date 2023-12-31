package GUI.Dialog.Chart;

import helper.ChartColor;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JPanel;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;

public abstract class PieChartGUI extends javax.swing.JFrame {

    public PieChartGUI() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public PieChartGUI(JDialog parent, String title) {
        initComponents();
        setTitle(title);
        setLocationRelativeTo(parent);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
    }
    
    private PieChart getChart(String title) {
        PieChart chart = new PieChartBuilder().width(800).height(600).title(title).build();
        
        chart.getStyler().setSeriesColors(ChartColor.chartColor);
        chart.getStyler().setToolTipsEnabled(true);
        chart.getStyler().setToolTipFont(new Font("Arial", Font.BOLD, 16));
        chart.getStyler().setLabelsFont(new Font("Arial", Font.BOLD, 16));
        
        addSeries(chart);
        
        return chart;
    }

    public void displayChart(String title) {
        JPanel chartPanel = new XChartPanel<PieChart>(getChart(title));
        pChartContainer.removeAll();
        pChartContainer.add(chartPanel, BorderLayout.CENTER);
        pChartContainer.repaint();
        pChartContainer.validate();
    }
    
    
    public abstract void addSeries(PieChart chart);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pChartContainer = new javax.swing.JPanel();
        placeholder = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pChartContainer.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout placeholderLayout = new javax.swing.GroupLayout(placeholder);
        placeholder.setLayout(placeholderLayout);
        placeholderLayout.setHorizontalGroup(
            placeholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
        );
        placeholderLayout.setVerticalGroup(
            placeholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        pChartContainer.add(placeholder, java.awt.BorderLayout.CENTER);

        getContentPane().add(pChartContainer, java.awt.BorderLayout.CENTER);

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
            java.util.logging.Logger.getLogger(PieChartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PieChartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PieChartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PieChartGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PieChartGUI pc = new PieChartGUI() {
                    @Override
                    public void addSeries(PieChart chart) {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };
                pc.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pChartContainer;
    private javax.swing.JPanel placeholder;
    // End of variables declaration//GEN-END:variables
}
