/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cac_Class;
import java.sql.Blob;
/**
 *
 * @author ASUS
 */
public class MonHoc {
    private int id_mh;
    private String tenMonHoc;
    private int SoTinChi;
    private String tenGV;
    private String MaGV;
    private Blob anhGV;
    private String Email;

    public MonHoc(int id_mh, String tenMonHoc, int SoTinChi, String tenGV, String Email) {
        this.id_mh = id_mh;
        this.tenMonHoc = tenMonHoc;
        this.SoTinChi = SoTinChi;
        this.tenGV = tenGV;
        this.Email = Email;
    }

    public MonHoc(int id_mh, String tenMonHoc, int SoTinChi, String tenGV, String MaGV,Blob anhGV ,String Email) {
        this.id_mh = id_mh;
        this.tenMonHoc = tenMonHoc;
        this.SoTinChi = SoTinChi;
        this.tenGV = tenGV;
        this.MaGV = MaGV;
        this.anhGV = anhGV;
        this.Email = Email;
    }

    
    public MonHoc() {
    }

    public Blob getAnhGV() {
        return anhGV;
    }

    public void setAnhGV(Blob anhGV) {
        this.anhGV = anhGV;
    }

    
    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    
    public int getId_mh() {
        return id_mh;
    }

    public void setId_mh(int id_mh) {
        this.id_mh = id_mh;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getSoTinChi() {
        return SoTinChi;
    }

    public void setSoTinChi(int SoTinChi) {
        this.SoTinChi = SoTinChi;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
}
