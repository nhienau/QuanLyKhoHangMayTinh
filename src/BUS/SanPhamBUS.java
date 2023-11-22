package BUS;

import DTO.SanPhamDTO;
import DAO.SanPhamDAO;
import java.util.ArrayList;

public class SanPhamBUS {
    SanPhamDAO spDAO = new SanPhamDAO();
    
    public ArrayList<SanPhamDTO> getlistProducts(){
        return spDAO.getlistProduct();
    }
    
    public String addProduct(SanPhamDTO sp){
        if(spDAO.addProduct(sp))
            return "Thêm sản phẩm thành công!";
        return "Thêm sản phẩm thất bại!";
    }
    
    public String deleteProduct(int id){
        if(spDAO.deleteProduct(id))
            return "Xóa sản phẩm thành công!";
        return "Xóa sản phẩm thất bại!";
    }
    
    public String updateProduct(SanPhamDTO sp){
        if(spDAO.updateProduct(sp))
            return "Sửa sản phẩm thành công!";
        return "Sửa sản phẩm thất bại!";
    }
}
