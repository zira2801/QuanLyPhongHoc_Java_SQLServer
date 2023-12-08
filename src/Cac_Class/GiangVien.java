/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cac_Class;

import java.util.Date;
import java.sql.Blob;

/**
 *
 * @author ASUS
 */
public class GiangVien {
    private String MaGV;
    private String tenGiangVien;
    private String gt;
    private String sodt;
    private Date ngaysinh;
    private Blob anhgv;
    private String email;

    public GiangVien(String MaGV, String tenGiangVien, String gt, Date ngaysinh, String email) {
        this.MaGV = MaGV;
        this.tenGiangVien = tenGiangVien;
        this.gt = gt;
        this.ngaysinh = ngaysinh;
        this.email = email;
    }

    public GiangVien(String MaGV, String tenGiangVien, String gt, String sodt, Date ngaysinh,Blob anhgv) {
        this.MaGV = MaGV;
        this.tenGiangVien = tenGiangVien;
        this.gt = gt;
        this.sodt = sodt;
        this.ngaysinh = ngaysinh;
        this.anhgv = anhgv;
    }

    
    public GiangVien() {
    }

    public String getSodt() {
        return sodt;
    }

    public Blob getAnhgv() {
        return anhgv;
    }

    public void setAnhgv(Blob anhgv) {
        this.anhgv = anhgv;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    
    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
