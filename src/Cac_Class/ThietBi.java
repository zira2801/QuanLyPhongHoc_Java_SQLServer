
package Cac_Class;

/**
 *
 * @author ASUS
 */
import java.sql.Blob;
public class ThietBi {
    private int id;
    private String tenThietBi;
    private int soluong;
    private String tenPhong;
    private String tinhtrangtb;
    private Blob anhtb;
    private String Email;

    public ThietBi() {
    }

    public ThietBi(int id, String tenThietBi, int soluong, String tenPhong,String tinhtrangtb ,Blob anhtb ,String Email) {
        this.id = id;
        this.tenThietBi = tenThietBi;
        this.soluong = soluong;
        this.tenPhong = tenPhong;
        this.anhtb = anhtb;
        this.Email = Email;
        this.tinhtrangtb = tinhtrangtb;
    }

    public ThietBi(String tenThietBi, int soluong, String tenPhong, String Email) {
        this.tenThietBi = tenThietBi;
        this.soluong = soluong;
        this.tenPhong = tenPhong;
        this.Email = Email;
    }

    public Blob getAnhtb() {
        return anhtb;
    }

    public void setAnhtb(Blob anhtb) {
        this.anhtb = anhtb;
    }

    
    public String getTinhtrangtb() {
        return tinhtrangtb;
    }

    public void setTinhtrangtb(String tinhtrangtb) {
        this.tinhtrangtb = tinhtrangtb;
    }

  

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
