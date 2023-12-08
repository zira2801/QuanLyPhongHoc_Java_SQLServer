
package Cac_Class;

import java.util.Date;
import java.sql.Blob;
/**
 *
 * @author ASUS
 */
public class LichHoc {
    private String maGV;
    private String tenGV;
    private String tenPhong;
    private String loaiPhong;
    private Date ngayHoc;
    private int TietBD;
    private int TietKT;
    private String sogiohoc;
    private String tenMonHoc;
    private Blob anhGV;
    private String Email; 

    


    public LichHoc(String maGV, String tenGV, String tenPhong, String loaiPhong, Date ngayHoc, int TietBD, int TietKT,String sogiohoc, String tenMonHoc,Blob anhGV) {

        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.ngayHoc = ngayHoc;
        this.TietBD = TietBD;
        this.TietKT = TietKT;
        this.sogiohoc = sogiohoc;
        this.tenMonHoc = tenMonHoc;
        this.anhGV = anhGV;
    }

    public LichHoc() {
    }

    public Blob getAnhGV() {
        return anhGV;
    }

    public void setAnhGV(Blob anhGV) {
        this.anhGV = anhGV;
    }

    
    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    
    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    
    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public int getTietBD() {
        return TietBD;
    }

    public void setTietBD(int TietBD) {
        this.TietBD = TietBD;
    }

    public int getTietKT() {
        return TietKT;
    }

    public void setTietKT(int TietKT) {
        this.TietKT = TietKT;
    }

    public String getSogiohoc() {
        return sogiohoc;
    }

    public void setSogiohoc(String sogiohoc) {
        this.sogiohoc = sogiohoc;
    }

   
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
    
}
