package BUS;

import DAO.tonKhoDAO;
import DTO.ChiTietTonKhoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class TonKhoBUS {
    public TonKhoBUS() {
    }
    
    public ArrayList<ChiTietTonKhoDTO> getDetailTonKho(int masanpham, int makho, boolean restrictGiaNhap) throws SQLException {
        return tonKhoDAO.getInstance().getDetailTonKho(masanpham, makho, restrictGiaNhap);
    }
}
