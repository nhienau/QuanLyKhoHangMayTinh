package DTO;

public class khoDTO {
    private int maKho;
    private String tenKho;
    private String diaChi;
    private int trangThai;
    
    public khoDTO() {
    }

    public khoDTO(int maKho, String tenKho, String diaChi, int trangThai) {
        this.maKho = maKho;
        this.tenKho = tenKho;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public int getMaKho() {
        return maKho;
    }

    public void setMaKho(int maKho) {
        this.maKho = maKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
