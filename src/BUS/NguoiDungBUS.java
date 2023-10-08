package BUS;

import DAO.NguoiDungDAO;
import DTO.NguoiDungDTO;
import java.sql.SQLException;

public class NguoiDungBUS {
    private final NguoiDungDAO ndDAO = new NguoiDungDAO();

    public NguoiDungBUS() {
    }
    
    public NguoiDungDTO verifyLogin(String username) throws SQLException {
        return ndDAO.verifyLogin(username);
    }
}
