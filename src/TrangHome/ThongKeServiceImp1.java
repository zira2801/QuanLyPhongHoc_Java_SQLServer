/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrangHome;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class ThongKeServiceImp1 implements ThongKeService{
private ThongKeDao thongkedao = null;

    public ThongKeServiceImp1() {
        thongkedao = new THongKeDAOImp1();
    }
    @Override
    public List<PhongHocBean> getListByPhongHoc() {
        return thongkedao.getListByPhongHoc();
    }
    
}
