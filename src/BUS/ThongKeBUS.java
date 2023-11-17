package BUS;

import DAO.ThongKeDAO;
import DTO.DateRangeDTO;
import DTO.ThongKe.*;
import static GUI.ThongKeGUI.CB_VALUE_GROUP_BY_DATE;
import static GUI.ThongKeGUI.CB_VALUE_GROUP_BY_MONTH;
import static GUI.ThongKeGUI.CB_VALUE_GROUP_BY_YEAR;
import helper.DateHelper;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ThongKeBUS {
    private final ThongKeDAO tkDAO = new ThongKeDAO();

    public ThongKeBUS() {
    }
    
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThu7NgayQua() throws SQLException {
        return tkDAO.thongKeDoanhThu7NgayQua();
    }
    
    public ArrayList<ThongKeTonKhoDTO> thongKeTonKho(DateRangeDTO dateRange, String productName) throws SQLException {
        return tkDAO.thongKeTonKho(dateRange, productName);
    }
    
    public ArrayList<ThongKeSanPhamDTO> thongKeSanPham(DateRangeDTO dateRange, String productName) throws SQLException {
        return tkDAO.thongKeSanPham(dateRange, productName);
    }
    
    public ArrayList<ChiTietSanPhamNhapDTO> thongKeChiTietSanPhamNhap(DateRangeDTO dateRange, int productId) throws SQLException {
        return tkDAO.thongKeChiTietSanPhamNhap(dateRange, productId);
    }
    
    public ArrayList<ChiTietGiaNhapNCCDTO> chiTietGiaNhapNCC (int productId, int providerId, DateRangeDTO dateRange) throws SQLException {
        return tkDAO.chiTietGiaNhapNCC(productId, providerId, dateRange);
    }
    
    public ArrayList<ThongKeLoaiSanPhamDTO> thongKeLoaiSanPham(DateRangeDTO dateRange, String productType) throws SQLException {
        return tkDAO.thongKeLoaiSanPham(dateRange, productType);
    }
    
    public ArrayList<ChiTietLoaiSanPhamDTO> chiTietLoaiSanPham(DateRangeDTO dateRange, int productTypeId) throws SQLException {
        return tkDAO.chiTietLoaiSanPham(dateRange, productTypeId);
    }
    
    public ArrayList<ChiTietGiaXuatSPDTO> chiTietGiaXuatSanPham (int productId, DateRangeDTO dateRange) throws SQLException {
        return tkDAO.chiTietGiaXuatSanPham(productId, dateRange);
    }
    
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThu(DateRangeDTO dateRange, String groupBy) throws SQLException, ParseException {
        return tkDAO.thongKeDoanhThu(dateRange, groupBy);
    }
    
    public LocalDateTime getOldestDate() throws SQLException {
        return tkDAO.getOldestDate();
    }
    
    public XSSFSheet exportDataDoanhThu(XSSFWorkbook workbook, ArrayList<ThongKeDoanhThuDTO> arr, TongDoanhThuDTO total, String groupBy) throws Exception {
        if (arr.isEmpty())
            throw new Exception("Không có dữ liệu");
        
        DateRangeDTO dateRange = total.getDateRange();
        
        // Create workbook with 1 sheet
        XSSFSheet sheet = workbook.createSheet(DateHelper.dateRangeToString(dateRange, DateHelper.EXCEL_SHEET_NAME_DATE_FORMATTER, "_"));
        
        // Get first column name
        String timelineColumnName = "";
        switch (groupBy) {
            case "date":
                timelineColumnName = CB_VALUE_GROUP_BY_DATE;
                break;
            case "month":
                timelineColumnName = CB_VALUE_GROUP_BY_MONTH;
                break;
            case "year":
                timelineColumnName = CB_VALUE_GROUP_BY_YEAR;
                break;
        }
        
        // Create first row: column name
        XSSFRow columnNameRow = sheet.createRow(0);
        XSSFCell[] columnNameCell = new XSSFCell[4];
        for (int i = 0; i < 4; ++i) {
            columnNameCell[i] = columnNameRow.createCell(i);
        }
        columnNameCell[0].setCellValue(timelineColumnName);
        columnNameCell[1].setCellValue("Chi phí (VND)");
        columnNameCell[2].setCellValue("Doanh thu (VND)");
        columnNameCell[3].setCellValue("Lợi nhuận (VND)");
        
        // Create summary row, contains total values
        XSSFRow summaryRow = sheet.createRow(1);
        XSSFCell[] summaryCell = new XSSFCell[4];
        for (int i = 0; i < 4; ++i) {
            summaryCell[i] = summaryRow.createCell(i);
        }
        summaryCell[0].setCellValue("Tổng");
        summaryCell[1].setCellValue(total.getTotalExpense());
        summaryCell[2].setCellValue(total.getTotalIncome());
        summaryCell[3].setCellValue(total.getTotalProfit());
        
        // Set date format
        XSSFCellStyle timelineStyle = workbook.createCellStyle();
        switch (groupBy) {
            case "date":
                timelineStyle.setDataFormat(workbook.createDataFormat().getFormat(DateHelper.DATE_PATTERN));
                break;
            case "month":
                timelineStyle.setDataFormat(workbook.createDataFormat().getFormat(DateHelper.MONTH_PATTERN));
                break;
            case "year":
                timelineStyle.setDataFormat(workbook.createDataFormat().getFormat(DateHelper.YEAR_PATTERN));
                break;
        }
        
        // Add data to cells
        for (int i = 0; i < arr.size(); ++i) {
            ThongKeDoanhThuDTO item = arr.get(i);
            XSSFRow row = sheet.createRow(i + 2);
            
            XSSFCell[] cell = new XSSFCell[4];
            
            for (int j = 0; j < 4; ++j) {
                cell[j] = row.createCell(j);
            }
            
            cell[0].setCellValue(item.getTimeline());
            cell[0].setCellStyle(timelineStyle);
            cell[1].setCellValue(item.getExpense());
            cell[2].setCellValue(item.getIncome());
            cell[3].setCellValue(item.getProfit());
        }
        
        // Resize columns' width to fit the contents
        for (int columnIndex = 0; columnIndex < sheet.getRow(0).getLastCellNum(); columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
        
        return sheet;
    }
}
