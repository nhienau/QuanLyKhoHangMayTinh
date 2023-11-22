package DAO;

import DTO.NguoiDungDTO;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import model.Account;

public class NguoiDungDAO {
    public NguoiDungDAO() {
    }

    public NguoiDungDTO verifyLogin(String username) throws SQLException {
        NguoiDungDTO user = null;
        try {
            Connection conn = JDBCUtil.getConnection();
            String query = "SELECT * FROM nguoidung WHERE taikhoan = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String taiKhoan = rs.getString("taikhoan");
                String matKhau = rs.getString("matkhau");
                String hoTen = rs.getString("hoten");
                String email = rs.getString("email");
                int maNhomQuyen = rs.getInt("maNhomQuyen");
                int trangThai = rs.getInt("trangThai");
                user = new NguoiDungDTO(taiKhoan, matKhau, hoTen, email, maNhomQuyen, trangThai);
            }
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }
    
    public NguoiDungDTO getInfoByEmail(String email) throws SQLException {
        NguoiDungDTO user = null;
        try {
            Connection conn = JDBCUtil.getConnection();
            String query = "SELECT taikhoan, email, manhomquyen, trangthai FROM nguoidung WHERE email = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String taiKhoan = rs.getString("taikhoan");
                email = rs.getString("email");
                int maNhomQuyen = rs.getInt("manhomquyen");
                int trangThai = rs.getInt("trangThai");
                user = new NguoiDungDTO(taiKhoan, null, null, email, maNhomQuyen, trangThai);
            }
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }
    
    //@Override
//    public int update(NguoiDungDTO t) {
//        int ketQua = 0;
//        try {
//            Connection con = JDBCUtil.getConnection();
//            String sql = "UPDATE nguoidung SET matkhau=?, hoten=?, email=?, manhomquen=?, trangthai=? WHERE userName=?";
//            PreparedStatement pst = con.prepareStatement(sql);          
//            pst.setString(1, t.getMatKhau());
//            pst.setString(2, t.getHoTen());
//            pst.setString(3, t.getEmail());
//            pst.setInt(4, t.getMaNhomQuyen());
//            pst.setInt(5, t.getTrangThai());
//            pst.setString(6, t.getTaiKhoan());
//            ketQua = pst.executeUpdate();
//            JDBCUtil.closeConnection(con);
//
//        } catch (Exception e) {
//            // TODO: handle exception
//            e.printStackTrace();
//        }
//        return ketQua;
//    }
    
    public int changePassword(NguoiDungDTO user, String newPassword) throws SQLException {
        int result = 0;
        try {
            Connection conn = JDBCUtil.getConnection();
            String query = "UPDATE nguoidung SET matkhau = ? WHERE taikhoan = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, user.getTaiKhoan());
            result = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
    
    public int changeEmail(NguoiDungDTO user, String newEmail) throws SQLException {
        int result = 0;
        try {
            Connection conn = JDBCUtil.getConnection();
            String query = "UPDATE nguoidung SET email = ? WHERE taikhoan = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, newEmail);
            ps.setString(2, user.getTaiKhoan());
            result = ps.executeUpdate();
            JDBCUtil.closeConnection(conn);
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
}
