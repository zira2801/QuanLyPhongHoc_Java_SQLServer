/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cac_Class;

import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class KhoTB {
    private int id_tb;
    private String maTB;
    private String tenTB;
    private String loaiTB;
    private int soluong;
    private String nhaSX;
    private Date ngaynhap;
    private Blob anhtb;

    public KhoTB() {
    }

    public KhoTB(int id_tb,String maTB, String tenTB, String loaiTB, int soluong, String nhaSX, Date ngaynhap,Blob anhtb) {
        this.id_tb = id_tb;
        this.maTB = maTB;
        this.tenTB = tenTB;
        this.loaiTB = loaiTB;
        this.soluong = soluong;
        this.nhaSX = nhaSX;
        this.ngaynhap = ngaynhap;
        this.anhtb = anhtb;
    }

    public Blob getAnhtb() {
        return anhtb;
    }

    public void setAnhtb(Blob anhtb) {
        this.anhtb = anhtb;
    }

    public int getId_tb() {
        return id_tb;
    }

    public void setId_tb(int id_tb) {
        this.id_tb = id_tb;
    }

    public String getMaTB() {
        return maTB;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getLoaiTB() {
        return loaiTB;
    }

    public void setLoaiTB(String loaiTB) {
        this.loaiTB = loaiTB;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    
    
}
