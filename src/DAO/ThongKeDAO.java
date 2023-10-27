package DAO;

import DTO.ThongKe.ThongKeDoanhThuDTO;
import database.JDBCUtil;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ThongKeDAO {
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
}
