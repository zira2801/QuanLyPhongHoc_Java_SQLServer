
package TrangHome;

import Database.Connect_DB;
import com.sun.istack.logging.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class THongKeDAOImp1 implements ThongKeDao{
Connect_DB cn = new Connect_DB();
ToanCuc tt = new ToanCuc();
    @Override
    public List<PhongHocBean> getListByPhongHoc() {
        try{
            Connection conn = cn.getConnection();
         String sql = "SELECT tenPhong, Solansudung FROM PhongHoc where Email = ?";
         List<PhongHocBean> list = new ArrayList<>();
         PreparedStatement ps = conn.prepareCall(sql);
         ps.setString(1,tt.getEmail());
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
             PhongHocBean phb = new PhongHocBean();
             phb.setTenph(rs.getString("tenPhong"));
             phb.setSolansd(rs.getInt("Solansudung"));
             list.add(phb);
         }
         return list;
        }
         catch(SQLException ex){
             ex.printStackTrace();
         }
        return null;
    }
    
}
