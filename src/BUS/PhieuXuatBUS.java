/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuatDTO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author EV
 */
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
