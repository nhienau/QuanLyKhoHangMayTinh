package BUS;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuatDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhieuXuatBUS {
    PhieuXuatDAO dao = new PhieuXuatDAO();

    public ArrayList<PhieuXuatDTO> getList() throws SQLException {
        return dao.getAllPhieuXuat();
    }

    public String add(PhieuXuatDTO px) throws SQLException {
//        System.out.println(px);
//        dao.create(px);
//        boolean isExist = dao.checkExistById(px.getMaPhieuXuat());
        if (px != null) {
            boolean isSuccess = dao.create(px);
            if (isSuccess) {
                return "tao thanh cong";
            } else {
                return "tao khong thanh cong";
            }
        } else {
            return "name da duoc tim thay trong db";
        }
    }
}
