package BUS;

import DAO.ThongKeDAO;
import DTO.DateRangeDTO;
import DTO.ThongKe.*;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
