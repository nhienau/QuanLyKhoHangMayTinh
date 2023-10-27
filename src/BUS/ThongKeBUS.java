package BUS;

import DAO.ThongKeDAO;
import DTO.ThongKe.ThongKeDoanhThuDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThongKeBUS {
    private final ThongKeDAO tkDAO = new ThongKeDAO();

    public ThongKeBUS() {
    }
    
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThu7NgayQua() throws SQLException {
        return tkDAO.thongKeDoanhThu7NgayQua();
    }
}
