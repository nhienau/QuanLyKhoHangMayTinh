/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DTO.NhaCungCapDTO;
import OldDAO.NhaCungCapDAO;
import java.util.ArrayList;
import model.NhaCungCap;

/**
 *
 * @author sinh
 */
public class SearchNhaCungCap {

    public static SearchNhaCungCap getInstance() {
        return new SearchNhaCungCap();
    }

    public ArrayList<NhaCungCapDTO> searchTatCa(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (String.valueOf(ncc.getMaNhaCungCap()).toLowerCase().contains(text.toLowerCase())
                    || ncc.getTenNhaCungCap().toLowerCase().contains(text.toLowerCase())
                    || ncc.getSdt().toLowerCase().contains(text.toLowerCase())
                    || ncc.getDiaChi().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> searchTenNCC(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getTenNhaCungCap().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> searchMaNCC(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (String.valueOf(ncc.getMaNhaCungCap()).toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> searchDiaChi(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getDiaChi().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> searchSdt(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getSdt().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }
}
