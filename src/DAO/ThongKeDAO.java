package DAO;

import DTO.DateRangeDTO;
import DTO.ThongKe.*;
import database.JDBCUtil;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ThongKeDAO {
    private final DateTimeFormatter sqlDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public ThongKeDAO() {
    }
    
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThu7NgayQua() throws SQLException {
        ArrayList<ThongKeDoanhThuDTO> result = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String query = """
                           WITH RECURSIVE dates(date) AS (
                             SELECT DATE_SUB(CURDATE(), INTERVAL 6 DAY)
                             UNION ALL
                             SELECT DATE_ADD(date, INTERVAL 1 DAY)
                             FROM dates
                             WHERE date < CURDATE()
                           )
                           SELECT 
                             dates.date AS ngay,
                             COALESCE(SUM(PN.tongtien), 0) AS chiphi,
                             COALESCE(SUM(PX.tongtien), 0) AS doanhthu
                           FROM dates
                           LEFT JOIN phieunhap PN ON dates.date = DATE(PN.thoigiantao)
                           LEFT JOIN phieuxuat PX ON dates.date = DATE(PX.thoigiantao)
                           LEFT JOIN trangthaiphieunhap TTPN ON PN.trangthai = TTPN.matrangthai
                           WHERE (TTPN.tentrangthai LIKE '%delivered%')
                              OR (TTPN.matrangthai IS NULL)
                           GROUP BY dates.date
                           ORDER BY dates.date;
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Date ngay = rs.getDate("ngay");
                Long chiPhi = rs.getLong("chiphi");
                Long doanhThu = rs.getLong("doanhthu");
                Long loiNhuan = doanhThu - chiPhi;
                result.add(new ThongKeDoanhThuDTO(ngay, chiPhi, doanhThu, loiNhuan));
            }
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
    
    public ArrayList<ThongKeTonKhoDTO> thongKeTonKho(DateRangeDTO dateRange, String productName) throws SQLException {
        ArrayList<ThongKeTonKhoDTO> result = new ArrayList<>();
        String fromDate = dateRange.getFromDate().format(sqlDateFormatter);
        String toDate = dateRange.getToDate().format(sqlDateFormatter);
        try {
            Connection conn = JDBCUtil.getConnection();
            String query = """
                           WITH nhaptrongky AS (
                           	SELECT masanpham, SUM(soluongnhap) AS soluongnhap
                           	FROM phieunhap PN JOIN chitietphieunhap CTPN ON PN.maphieunhap = CTPN.maphieunhap JOIN trangthaiphieunhap TTPN ON PN.trangthai = TTPN.matrangthai
                           	WHERE DATE(PN.thoigiantao) BETWEEN ? AND ? AND tentrangthai LIKE '%delivered%'
                           	GROUP BY masanpham
                           ), xuattrongky AS (
                           	SELECT masanpham, SUM(soluong) AS soluongxuat
                           	FROM phieuxuat PX JOIN chitietphieuxuat CTPX ON PX.maphieuxuat = CTPX.maphieuxuat
                           	WHERE DATE(PX.thoigiantao) BETWEEN ? AND ? AND PX.trangthai = 1
                           	GROUP BY masanpham
                           ), nhapdauky AS (
                           	SELECT masanpham, SUM(soluongnhap) AS soluongnhap
                           	FROM phieunhap PN JOIN chitietphieunhap CTPN ON PN.maphieunhap = CTPN.maphieunhap
                           	WHERE DATE(PN.thoigiantao) < ?
                           	GROUP BY masanpham
                           ), xuatdauky AS (
                           	SELECT masanpham, SUM(soluong) AS soluongxuat
                           	FROM phieuxuat PX JOIN chitietphieuxuat CTPX ON PX.maphieuxuat = CTPX.maphieuxuat
                           	WHERE DATE(PX.thoigiantao) < ?
                           	GROUP BY masanpham
                           ), dauky AS (
                           	SELECT SP.masanpham, COALESCE(NDK.soluongnhap, 0) - COALESCE(XDK.soluongxuat, 0) AS tondauky
                           	FROM sanpham SP
                               LEFT JOIN chitietcungcap CTCC ON SP.masanpham = CTCC.masanpham
                           	LEFT JOIN nhapdauky NDK ON CTCC.masanpham = NDK.masanpham
                           	LEFT JOIN xuatdauky XDK ON CTCC.masanpham = XDK.masanpham
                           ), tonkho AS (
                           	SELECT SP.masanpham, tensanpham, tondauky, COALESCE(NTK.soluongnhap, 0) AS nhaptrongky, COALESCE(XTK.soluongxuat, 0) AS xuattrongky, (tondauky + COALESCE(NTK.soluongnhap, 0) - COALESCE(XTK.soluongxuat, 0)) AS toncuoiky
                           	FROM dauky DK
                           	LEFT JOIN nhaptrongky NTK ON DK.masanpham = NTK.masanpham
                           	LEFT JOIN xuattrongky XTK ON DK.masanpham = XTK.masanpham
                           	JOIN sanpham SP ON SP.masanpham = DK.masanpham
                           )
                           SELECT DISTINCT * FROM tonkho
                           WHERE tensanpham LIKE ?
                           ORDER BY masanpham
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ps.setString(3, fromDate);
            ps.setString(4, toDate);
            ps.setString(5, fromDate);
            ps.setString(6, fromDate);
            ps.setString(7, "%" + productName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maSanPham = rs.getInt("masanpham");
                String tenSanPham = rs.getString("tensanpham");
                int tonDauKy = rs.getInt("tondauky");
                int nhapTrongKy = rs.getInt("nhaptrongky");
                int xuatTrongKy = rs.getInt("xuattrongky");
                int tonCuoiKy = rs.getInt("toncuoiky");
                result.add(new ThongKeTonKhoDTO(maSanPham, tenSanPham, tonDauKy, nhapTrongKy, xuatTrongKy, tonCuoiKy));
            }
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
    
    public ArrayList<ThongKeSanPhamDTO> thongKeSanPham(DateRangeDTO dateRange, String productName) throws SQLException {
        ArrayList<ThongKeSanPhamDTO> result = new ArrayList<>();
        String fromDate = dateRange.getFromDate().format(sqlDateFormatter);
        String toDate = dateRange.getToDate().format(sqlDateFormatter);
        try {
            Connection conn = JDBCUtil.getConnection();
            String query = """
                           WITH slnhap AS (
                               SELECT masanpham, SUM(soluongnhap) AS soluongnhap
                               FROM phieunhap PN
                               JOIN chitietphieunhap CTPN ON PN.maphieunhap = CTPN.maphieunhap
                               JOIN trangthaiphieunhap TTPN ON TTPN.matrangthai = PN.trangthai
                               WHERE tentrangthai LIKE '%delivered%' AND DATE(PN.thoigiantao) BETWEEN ? AND ?
                               GROUP BY masanpham
                           ), temp_table AS (
                               SELECT SP.masanpham, tenloaisanpham, tensanpham, COALESCE(soluongnhap, 0) AS soluongnhap
                               FROM sanpham SP JOIN slnhap SLN ON SP.masanpham = SLN.masanpham
                               JOIN loaisanpham LSP ON SP.maloaisanpham = LSP.maloaisanpham
                           )
                           SELECT * FROM temp_table
                           WHERE tensanpham LIKE ?
                           ORDER BY soluongnhap DESC, masanpham
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ps.setString(3, "%" + productName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maSanPham = rs.getInt("masanpham");
                String tenLoaiSanPham = rs.getString("tenloaisanpham");
                String tenSanPham = rs.getString("tensanpham");
                int soLuongNhap = rs.getInt("soluongnhap");
                result.add(new ThongKeSanPhamDTO(maSanPham, tenLoaiSanPham, tenSanPham, soLuongNhap));
            }
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
    
    public ArrayList<ChiTietSanPhamNhapDTO> thongKeChiTietSanPhamNhap(DateRangeDTO dateRange, int productId) throws SQLException {
        ArrayList<ChiTietSanPhamNhapDTO> result = new ArrayList<>();
        String fromDate = dateRange.getFromDate().format(sqlDateFormatter);
        String toDate = dateRange.getToDate().format(sqlDateFormatter);
        try {
            Connection conn = JDBCUtil.getConnection();
            String query = """
                            WITH tongnhap AS (
                                SELECT manhacungcap, SUM(soluongnhap) AS tongsoluongnhap, dongia
                                FROM phieunhap PN
                                JOIN chitietphieunhap CTPN ON PN.maphieunhap = CTPN.maphieunhap
                                JOIN trangthaiphieunhap TTPN ON TTPN.matrangthai = PN.trangthai
                                WHERE tentrangthai LIKE '%delivered%' AND DATE(PN.thoigiantao) BETWEEN ? AND ? AND masanpham = ?
                                GROUP BY manhacungcap
                                ORDER BY tongsoluongnhap
                            ), temp_table AS (
                                    SELECT TN.manhacungcap, tennhacungcap, tongsoluongnhap, dongia
                                FROM tongnhap TN JOIN nhacungcap NCC ON NCC.manhacungcap = TN.manhacungcap
                            )
                            SELECT * FROM temp_table
                            ORDER BY tongsoluongnhap DESC, dongia, manhacungcap
                           """;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ps.setInt(3, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maNhaCungCap = rs.getInt("manhacungcap");
                String tenNhaCungCap = rs.getString("tennhacungcap");
                int tongSoLuongNhap = rs.getInt("tongsoluongnhap");
                Long donGia = rs.getLong("dongia");
                result.add(new ChiTietSanPhamNhapDTO(maNhaCungCap, tenNhaCungCap, tongSoLuongNhap, donGia));
            }
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
}
