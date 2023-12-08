
package Cac_Class;

/**
 *
 * @author ASUS
 */
public class PhongHoc {
    private int id_phong;
    private String TenPhong;
    private int SoChoNgoi;
    private String LoaiPhong;
    private String CoSo;
    private String TrangThai;
    private String Email;

    public PhongHoc() {
    }

    public PhongHoc(String TenPhong, int SoChoNgoi, String LoaiPhong,String Coso) {
        this.TenPhong = TenPhong;
        this.SoChoNgoi = SoChoNgoi;
        this.LoaiPhong = LoaiPhong;
        this.CoSo = Coso;
    }

    public PhongHoc(int id_phong, String TenPhong, int SoChoNgoi, String LoaiPhong, String CoSo, String TrangThai) {
        this.id_phong = id_phong;
        this.TenPhong = TenPhong;
        this.SoChoNgoi = SoChoNgoi;
        this.LoaiPhong = LoaiPhong;
        this.CoSo = CoSo;
        this.TrangThai = TrangThai;
    }

    

    public PhongHoc(String TenPhong, int SoChoNgoi, String LoaiPhong, String CoSo, String TrangThai, String Email) {
        this.TenPhong = TenPhong;
        this.SoChoNgoi = SoChoNgoi;
        this.LoaiPhong = LoaiPhong;
        this.CoSo = CoSo;
        this.TrangThai = TrangThai;
        this.Email = Email;
    }

    public int getId_phong() {
        return id_phong;
    }

    public void setId_phong(int id_phong) {
        this.id_phong = id_phong;
    }

    
    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    
    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public int getSoChoNgoi() {
        return SoChoNgoi;
    }

    public void setSoChoNgoi(int SoChoNgoi) {
        this.SoChoNgoi = SoChoNgoi;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCoSo() {
        return CoSo;
    }

    public void setCoSo(String CoSo) {
        this.CoSo = CoSo;
    }
    
    
    
}
