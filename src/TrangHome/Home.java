
package TrangHome;


import Cac_Class.GiangVien;
import Cac_Class.KhoTB;
import Cac_Class.LichHoc;
import Cac_Class.MonHoc;
import Cac_Class.PhongHoc;
import Cac_Class.ThietBi;
import Database.Connect_DB;
import LoginAndRegister.LoginForm;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.List;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import javaswingdev.drawer.DrawerItem;
import javaswingdev.drawer.EventDrawer;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.Blob;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;

public class Home extends javax.swing.JFrame {
    String duongdananh = null;
    String anhTB = null;
    Color DefaultColor,ClickedColor;
    ArrayList<PhongHoc>  listPhong = new ArrayList<PhongHoc>();
    ArrayList<ThietBi> listTB = new ArrayList<ThietBi>();
    ArrayList<GiangVien> listGV = new ArrayList<GiangVien>(); 
    ArrayList<MonHoc> listMH = new ArrayList<MonHoc>();
    ArrayList<LichHoc> listLH = new ArrayList<LichHoc>();
    ArrayList<KhoTB> listKhoTB = new ArrayList<KhoTB>();
    Connect_DB cn = new Connect_DB();
    int current = 0;
    private DrawerController drawer;
    //Sự kiện hiển thị thống kê
        QuanLyThongKeController controller = new QuanLyThongKeController();
    public Home() throws IOException, SQLException {
        initComponents();
         this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Mở cửa sổ toàn màn hình

        
        ToanCuc tt = new ToanCuc();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawer = Drawer.newDrawer(this)
                .header(new HeaderMenu())
                .addChild(new DrawerItem("Phân công phòng học").icon(new ImageIcon(getClass().getResource("/icon/icons8-home-24 (1).png"))).build())
                .addChild(new DrawerItem("Phòng học").icon(new ImageIcon(getClass().getResource("/icon1/icons8-classroom-24 (2).png"))).build())
                .addChild(new DrawerItem("Thiết bị").icon(new ImageIcon(getClass().getResource("/icon1/icons8-machine-learning-24 (2).png"))).build())
                .addChild(new DrawerItem("Giảng viên").icon(new ImageIcon(getClass().getResource("/icon1/icons8-school-director-26 (2).png"))).build())
                .addChild(new DrawerItem("Môn học").icon(new ImageIcon(getClass().getResource("/icon1/icons8-portrait-24 (1).png"))).build())
                .addChild(new DrawerItem("Kho thiết bị").icon(new ImageIcon(getClass().getResource("/icon1/thietbiQL.png"))).build())
                .addChild(new DrawerItem("Thống kê").icon(new ImageIcon(getClass().getResource("/icon1/barchart.png"))).build())
               .event(new EventDrawer(){
            @Override
            public void selected( int i,DrawerItem di) {
                String itemName = di.getText();
               switch(itemName){
                 case "Phân công phòng học":
                    Home.setVisible(true);
                    QLPhong.setVisible(false);
                    QLThietBi.setVisible(false);
                    QLGiaoVien.setVisible(false);
                    QLMonHoc.setVisible(false);
                    QLKhoTB.setVisible(false);
                    ThongKe.setVisible(false);
                    break;
                case "Phòng học":
                    Home.setVisible(false);
                    QLPhong.setVisible(true);
                    QLThietBi.setVisible(false);
                    QLGiaoVien.setVisible(false);
                    QLMonHoc.setVisible(false);
                    QLKhoTB.setVisible(false);
                    ThongKe.setVisible(false);
                    break;
                case "Thiết bị":
                    Home.setVisible(false);
                    QLPhong.setVisible(false);
                    QLThietBi.setVisible(true);
                    QLGiaoVien.setVisible(false);
                    QLMonHoc.setVisible(false);
                    QLKhoTB.setVisible(false);
                    ThongKe.setVisible(false);
                    break;
                case "Giảng viên":
                    Home.setVisible(false);
                    QLPhong.setVisible(false);
                    QLThietBi.setVisible(false);
                    QLGiaoVien.setVisible(true);
                    QLMonHoc.setVisible(false);
                    QLKhoTB.setVisible(false);
                    ThongKe.setVisible(false);
                    break;
                case "Môn học":
                    Home.setVisible(false);
                    QLPhong.setVisible(false);
                    QLThietBi.setVisible(false);
                    QLGiaoVien.setVisible(false);
                    QLMonHoc.setVisible(true);
                    QLKhoTB.setVisible(false);
                    ThongKe.setVisible(false);
                    break;
                case "Kho thiết bị":
                    Home.setVisible(false);
                    QLPhong.setVisible(false);
                    QLThietBi.setVisible(false);
                    QLGiaoVien.setVisible(false);
                    QLMonHoc.setVisible(false);
                    QLKhoTB.setVisible(true);
                    ThongKe.setVisible(false);
                    break;
                case "Thống kê":
                    Home.setVisible(false);
                    QLPhong.setVisible(false);
                    QLThietBi.setVisible(false);
                    QLGiaoVien.setVisible(false);
                    QLMonHoc.setVisible(false);
                    QLKhoTB.setVisible(false);
                    ThongKe.setVisible(true);
                    break;
               }
               
            }
                })
                .build();
        
        DefaultColor = new Color(56, 161, 222);
        ClickedColor = new Color(47, 139, 192);
     
        //Load loai phong
        LayDuLoaiPhongLenHome();
        //Load tên phòng lên trang home
        LayDuTenPHLenHome();
        LoadJComboCHonPhongHome();
        
        LayDuTenPHLenHome2();
        LoadJComboCHonPhongHome2();
        //Load dữ liệu lên trang THiết bị
         LayDuTenPHLen();
         LoadJComboCHonPhong();
         
         //Load dữ liệu MaGV lên trang Môn học
         LayDuMaGVLen();
         LoadJComboCHonGV();
         
         //Load dữ liệu lên trang Home
         LayDuMaGVLenHome();
         LoadJComboCHonGVHome();
         
         //Load dữ liệu tên môn học lên trang Home
         LayDuTenMonLenHome();
         LoadJComboCHonMonHocHome();
         //Load du lieu vao array phong hoc
         LoadDataPhongHoc();
         LoadDataTablePhongHoc();
         
        LoadDataThietBi();
        LoadDataTableThietBi();
        
        LoadDataGV();
        LoadDataTableGV();
        
        LoadDataMonHoc();
        LoadDataTableMH();
        
       
        loadTenGV(tt.getEmail());
        
        //Load tên thiết bị lên
        LayDuTenThietBiLen();
        LoadJComboCHonThietBi();
        //Load ten gv
        loadTenGVHome();
        
        //Load bảng đặt phòng
        LoadDataDatPhongHoc();
        LoadDataTableDatPhongHoc();
        
        //Load ảnh gv lên trang home
       loadAnhGVHome();
       
       //Load ảnh lên trang môn học
       loadAnhGVMonHoc();
       
       //Load dữ liệu kho thiết bị
       LoadDataKhoThietBi();
       LoadDataTableKhoTB();
       
       //Load số lượng thiết bị trong kho
       loadTSoluongTB(tt.getEmail());
       jComboBoxMaGV.setSelectedItem(null);
       jComboBoxTenPhong.setSelectedItem(null);
       
       jComboBoxTietBD.setSelectedItem(null);
        jComboBoxTietKT.setSelectedItem(null);
        
        jComboBoxGiangVien.setSelectedItem(null);
        
        jComboBoxPhong.setSelectedItem(null);
        
        jComboBoxThietBi.setSelectedItem(null);
        jTableGV.getColumn("Ảnh").setCellRenderer(new ImageRenderer());
        jTableGV.setRowHeight(100);
        TableColumnModel columnModel = jTableGV.getColumnModel();
        columnModel.getColumn(0).setCellRenderer(new CenterRenderer());
        columnModel.getColumn(1).setCellRenderer(new CenterRenderer());
        columnModel.getColumn(2).setCellRenderer(new CenterRenderer());
        columnModel.getColumn(3).setCellRenderer(new CenterRenderer());
        columnModel.getColumn(4).setCellRenderer(new CenterRenderer());
        
        jTableMonHoc.getColumn("Ảnh giảng viên").setCellRenderer(new ImageRenderer());
        jTableMonHoc.setRowHeight(100);
        TableColumnModel columnModelmh = jTableMonHoc.getColumnModel();
        columnModelmh.getColumn(0).setCellRenderer(new CenterRenderer());
        columnModelmh.getColumn(1).setCellRenderer(new CenterRenderer());
        columnModelmh.getColumn(2).setCellRenderer(new CenterRenderer());
        columnModelmh.getColumn(3).setCellRenderer(new CenterRenderer());
        
        jTextField6.setEnabled(false);
        jTextField6.setDisabledTextColor(Color.DARK_GRAY);
        
        //Chỉnh ô cho các bảng 
        //Phòng học
        jTable1.setRowHeight(30);
        TableColumnModel columnModelPH = jTable1.getColumnModel();
        columnModelPH.getColumn(0).setCellRenderer(new CenterRenderer());
        columnModelPH.getColumn(1).setCellRenderer(new CenterRenderer());
        columnModelPH.getColumn(2).setCellRenderer(new CenterRenderer());
        columnModelPH.getColumn(3).setCellRenderer(new CenterRenderer());
        columnModelPH.getColumn(4).setCellRenderer(new CenterRenderer());
        
        //Thiết bị
        jTableTB.setRowHeight(100);
        jTableTB.getColumn("Ảnh thiết bị").setCellRenderer(new ImageRenderer());
        jTableTB.getColumn("Tên thiết bị").setCellRenderer(new XuongDOng());
        TableColumnModel colulTmnModelTB = jTableTB.getColumnModel();
        colulTmnModelTB.getColumn(0).setCellRenderer(new CenterRenderer());
        colulTmnModelTB.getColumn(1).setCellRenderer(new CenterRenderer());
        colulTmnModelTB.getColumn(2).setCellRenderer(new CenterRenderer());
        colulTmnModelTB.getColumn(3).setCellRenderer(new CenterRenderer());
        
        //Phân công phòng
        jTableDatPhong.setRowHeight(30);
        TableColumnModel columnModelPC = jTableDatPhong.getColumnModel();
        columnModelPC.getColumn(0).setCellRenderer(new CenterRenderer());
        columnModelPC.getColumn(1).setCellRenderer(new CenterRenderer());
        columnModelPC.getColumn(2).setCellRenderer(new CenterRenderer());
        columnModelPC.getColumn(3).setCellRenderer(new CenterRenderer());
        columnModelPC.getColumn(4).setCellRenderer(new CenterRenderer());
        columnModelPC.getColumn(5).setCellRenderer(new CenterRenderer());
        columnModelPC.getColumn(6).setCellRenderer(new CenterRenderer());
        columnModelPC.getColumn(7).setCellRenderer(new CenterRenderer());
        
        //Kho thiết bị
        jTableKhoTB.setRowHeight(100);
        TableColumnModel columnModelKTB = jTableKhoTB.getColumnModel();
        jTableKhoTB.getColumn("Ảnh thiết bị").setCellRenderer(new ImageRenderer());
        jTableKhoTB.getColumn("Tên thiết bị").setCellRenderer(new XuongDOng());
        columnModelKTB.getColumn(0).setCellRenderer(new CenterRenderer());
        columnModelKTB.getColumn(2).setCellRenderer(new CenterRenderer());
        columnModelKTB.getColumn(3).setCellRenderer(new CenterRenderer());
       columnModelKTB.getColumn(4).setCellRenderer(new CenterRenderer());
        columnModelKTB.getColumn(5).setCellRenderer(new CenterRenderer());
        columnModelPC.getColumn(6).setCellRenderer(new CenterRenderer());
        
        jComboBox1.setSelectedItem(null);
        
        
        controller.setTenPhongToChart(jPanelThongKe);
    }
    
    public void LayDuTenPHLen(){
          ToanCuc tt = new ToanCuc();
        try{
          Connection conn = cn.getConnection();
          String query = "SELECT tenPhong FROM PhongHoc where Email = ?";
          PreparedStatement st = conn.prepareStatement(query);
          st.setString(1, tt.getEmail());
          ResultSet rs = st.executeQuery();
          
          ArrayList<String> dataList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("tenPhong");
                dataList.add(name);
            }

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(dataList.toArray(new String[0]));
            jComboBoxPhong.setModel(comboBoxModel);
        }
        catch (Exception ex){
            
        }
    }
    //Lấy dữ liệu tên phòng lên jCOmbobox
    public void LayDuTenPHLenHome(){
          ToanCuc tt = new ToanCuc();
        try{
          Connection conn = cn.getConnection();
          String query = "SELECT tenPhong FROM PhongHoc where Email = ?";
          PreparedStatement st = conn.prepareStatement(query);
          st.setString(1, tt.getEmail());
          ResultSet rs = st.executeQuery();
          
          ArrayList<String> dataList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("tenPhong");
                dataList.add(name);
            }

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(dataList.toArray(new String[0]));
            jComboBoxTenPhong.setModel(comboBoxModel);
        }
        catch (Exception ex){
            
        }
    }
    //Load Dữ lại dữ liệu lên Jcombobox
     public void LoadJComboCHonPhongHome(){
        DefaultComboBoxModel<String> newComboBoxModel = (DefaultComboBoxModel<String>) jComboBoxTenPhong.getModel();
        jComboBoxTenPhong.setModel(newComboBoxModel);
    }
     
     
     //Lấy dữ liệu tên phòng lên jCOmbobox
    public void LayDuTenPHLenHome2(){
          ToanCuc tt = new ToanCuc();
        try{
          Connection conn = cn.getConnection();
          String query = "SELECT tenPhong FROM PhongHoc where Email = ?";
          PreparedStatement st = conn.prepareStatement(query);
          st.setString(1, tt.getEmail());
          ResultSet rs = st.executeQuery();
          
          ArrayList<String> dataList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("tenPhong");
                dataList.add(name);
            }

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(dataList.toArray(new String[0]));
            jComboBox1.setModel(comboBoxModel);
        }
        catch (Exception ex){
            
        }
    }
    //Load Dữ lại dữ liệu lên Jcombobox
     public void LoadJComboCHonPhongHome2(){
        DefaultComboBoxModel<String> newComboBoxModel = (DefaultComboBoxModel<String>) jComboBox1.getModel();
        jComboBox1.setModel(newComboBoxModel);
    }
      //Lấy dữ liệu tên thiết bị lên jCOmbobox
    public void LayDuTenThietBiLen(){
          ToanCuc tt = new ToanCuc();
        try{    
          Connection conn = cn.getConnection();
          String query = "SELECT TenTB FROM KhoThietBi where Email = ?";
          PreparedStatement st = conn.prepareStatement(query);
          st.setString(1, tt.getEmail());
          ResultSet rs = st.executeQuery();
          
          ArrayList<String> dataList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("TenTB");
                dataList.add(name);
            }

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(dataList.toArray(new String[0]));
            jComboBoxThietBi.setModel(comboBoxModel);
        }
        catch (Exception ex){
            
        }
    }
    
    //Load Dữ lại dữ liệu tên thiết bị lên Jcombobox
     public void LoadJComboCHonThietBi(){
        DefaultComboBoxModel<String> newComboBoxModel = (DefaultComboBoxModel<String>) jComboBoxThietBi.getModel();
        jComboBoxThietBi.setModel(newComboBoxModel);
    }
    //Lấy Tên giáo viên lên
    public void LayDuMaGVLen(){
          ToanCuc tt = new ToanCuc();
          GiangVien gv = new GiangVien();
        try{
          Connection conn = cn.getConnection();
          String query = "SELECT MaGV from GiangVien where Email = ?";
          PreparedStatement st = conn.prepareStatement(query);
          st.setString(1, tt.getEmail());
          ResultSet rs = st.executeQuery();
          
          ArrayList<String> dataList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("MaGV");
                dataList.add(name);
            }

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(dataList.toArray(new String[0]));
            jComboBoxGiangVien.setModel(comboBoxModel);
        }
        catch (Exception ex){
            
        }
    }
    
    // JCombobox chọn Giáo viên
    public void LoadJComboCHonGV(){
        DefaultComboBoxModel<String> newComboBoxModel = (DefaultComboBoxModel<String>) jComboBoxGiangVien.getModel();
        jComboBoxGiangVien.setModel(newComboBoxModel);
    }
    
    //Load lại dữ liệu Môn học ở trang Home
    
    //Lấy dữ liệu MaGV lên trang Home
    public void LayDuMaGVLenHome(){
          ToanCuc tt = new ToanCuc();
        try{
          Connection conn = cn.getConnection();
          String query = "SELECT MaGV from GiangVien where Email = ?";
          PreparedStatement st = conn.prepareStatement(query);
          st.setString(1, tt.getEmail());
          ResultSet rs = st.executeQuery();
          
          ArrayList<String> dataList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("MaGV");
                dataList.add(name);
            }

            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(dataList.toArray(new String[0]));
            jComboBoxMaGV.setModel(comboBoxModel);
        }
        catch (Exception ex){
            
        }
    }
    //Load lại dữ liệu Jcombobox MaGV trang Home
    public void LoadJComboCHonGVHome(){
        DefaultComboBoxModel<String> newComboBoxModel = (DefaultComboBoxModel<String>) jComboBoxMaGV.getModel();
        jComboBoxMaGV.setModel(newComboBoxModel);
    }
    
    //Load dữ liệu tên môn học lên Jcombobox
    public void LayDuTenMonLenHome(){
          ToanCuc tt = new ToanCuc();
         jComboBoxMaGV.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedMaGV = (String) jComboBoxMaGV.getSelectedItem();
                try {
                    Connection conn = cn.getConnection();
                    String query = "SELECT tenMonHoc from MonHoc WHERE id_gv = ? AND Email = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    int id_gv = 0;
                    String queryPhongHoc = "SELECT id_gv FROM GiangVien WHERE MaGV = ? and Email = ?";
                       PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                       stPhongHoc.setString(1, selectedMaGV);
                       stPhongHoc.setString(2, tt.getEmail());
                       ResultSet rs = stPhongHoc.executeQuery();
                       // Nếu tìm thấy kết quả, lấy giá trị id_phong
                     if (rs.next()) {
                           id_gv = rs.getInt("id_gv");
                           }
                    st.setInt(1, id_gv);
                    st.setString(2, tt.getEmail());
                    ResultSet resultSet = st.executeQuery();
                    ArrayList<String> dataList = new ArrayList<>();
                    while (resultSet.next()) {
                    String name = resultSet.getString("tenMonHoc");
                    dataList.add(name);
                    }

                    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(dataList.toArray(new String[0]));
                    jComboBoxMonHoc.setModel(comboBoxModel);
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
    }
    //Load lại dữ liệu tên môn học
    public void LoadJComboCHonMonHocHome(){
        DefaultComboBoxModel<String> newComboBoxModel = (DefaultComboBoxModel<String>) jComboBoxMonHoc.getModel();
        jComboBoxMonHoc.setModel(newComboBoxModel);
    }
    
    //Load Loại Phòng học 
    public void LayDuLoaiPhongLenHome(){
          ToanCuc tt = new ToanCuc();
         jComboBoxTenPhong.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedTenPhong = (String) jComboBoxTenPhong.getSelectedItem();
                try {
                    Connection conn = cn.getConnection();
                    String query = "SELECT LoaiPhong from PhongHoc WHERE tenPhong = ? and Email = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setString(1, selectedTenPhong);
                    st.setString(2, tt.getEmail());
                    ResultSet resultSet = st.executeQuery();
                    if (resultSet.next()) {
                        String loaiphong = resultSet.getString("LoaiPhong");
                        jTextFieldLoaiPhong.setText(loaiphong);
                    } else {
                        jTextFieldLoaiPhong.setText("");
                    }
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
         jTextFieldLoaiPhong.setEnabled(false);
         jTextFieldLoaiPhong.setDisabledTextColor(Color.DARK_GRAY);
    }
    
    //Load ten gia vien len trang home
    public void loadTenGVHome(){
        ToanCuc tt = new ToanCuc();
        jComboBoxMaGV.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedMaGV = (String) jComboBoxMaGV.getSelectedItem();
                try {
                    Connection conn = cn.getConnection();
                    String query = "SELECT tenGiangVien FROM GiangVien WHERE MaGV = ? AND Email = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setString(1, selectedMaGV);
                    st.setString(2, tt.getEmail());
                    ResultSet resultSet = st.executeQuery();
                    if (resultSet.next()) {
                        String tenGiangVien = resultSet.getString("tenGiangVien");
                        jTextFieldTenGV.setText(tenGiangVien);
                    } else {
                        jTextFieldTenGV.setText("");
                    }
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
    jTextFieldTenGV.setEnabled(false);
     jTextFieldTenGV.setDisabledTextColor(Color.DARK_GRAY);
    }
    
    //Load Anh len Trang Home
    public void loadAnhGVHome(){
        ToanCuc tt = new ToanCuc();
        jComboBoxMaGV.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedMaGV = (String) jComboBoxMaGV.getSelectedItem();
                try {
                    Connection conn = cn.getConnection();
                    String query = "SELECT AnhGV FROM GiangVien WHERE MaGV = ? AND Email = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setString(1, selectedMaGV);
                    st.setString(2, tt.getEmail());
                    ResultSet resultSet = st.executeQuery();
                    if (resultSet.next()) {
                        Blob imagePath = resultSet.getBlob("AnhGV");
                        ImageIcon imageIcon = new ImageIcon(imagePath.getBytes(1,(int)imagePath.length()));
                        Image image = imageIcon.getImage().getScaledInstance(hinhgvHome.getWidth(), hinhgvHome.getHeight(), Image.SCALE_SMOOTH);
                        hinhgvHome.setIcon(new ImageIcon(image));
                    } else {
                        hinhgvHome.setIcon(null);
                    }
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
    }
    
    //Load anh len trang Môn học
    public void loadAnhGVMonHoc(){
        ToanCuc tt = new ToanCuc();
        jComboBoxGiangVien.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedMaGV = (String) jComboBoxGiangVien.getSelectedItem();
                try {
                    Connection conn = cn.getConnection();
                    String query = "SELECT AnhGV FROM GiangVien WHERE MaGV = ? AND Email = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setString(1, selectedMaGV);
                    st.setString(2, tt.getEmail());
                    ResultSet resultSet = st.executeQuery();
                    if (resultSet.next()) {
                        Blob imagePath = resultSet.getBlob("AnhGV");
                        ImageIcon imageIcon = new ImageIcon(imagePath.getBytes(1,(int)imagePath.length()));
                        Image image = imageIcon.getImage().getScaledInstance(hinhgvMH.getWidth(), hinhgvMH.getHeight(), Image.SCALE_SMOOTH);
                        hinhgvMH.setIcon(new ImageIcon(image));
                        hinhgvMH.setIcon(new ImageIcon(image));
                    } else {
                        hinhgvMH.setIcon(null);
                    }
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
    }
    //Load du lieu phong hoc
    public void LoadDataPhongHoc(){
        ToanCuc tt = new ToanCuc();
        try{
            Connection conn = cn.getConnection();
             String query = "SELECT * FROM PhongHoc WHERE Email = ?";
             PreparedStatement statement = conn.prepareCall(query);
             statement.setString(1, tt.getEmail());
            ResultSet resultSet = statement.executeQuery();
            listPhong.clear();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String tenPhong = resultSet.getString(2);
                int socho = resultSet.getInt(3);
                String loaiPhong = resultSet.getString(4);
                String coso = resultSet.getString(5);
                String trangthai = resultSet.getString(6);
                PhongHoc ph = new PhongHoc(id,tenPhong,socho,loaiPhong,coso,trangthai);
                listPhong.add(ph);
            }
            conn.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    //Load du lieu vao bang Phong Hoc
    public void LoadDataTablePhongHoc(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(PhongHoc ph : listPhong){
            model.addRow(new Object[] {ph.getTenPhong(),ph.getLoaiPhong(),ph.getCoSo(),ph.getSoChoNgoi(),ph.getTrangThai()});
        }
    }
    
    //Load lai du lieu chọn phòng học
    public void LoadJComboCHonPhong(){
        DefaultComboBoxModel<String> newComboBoxModel = (DefaultComboBoxModel<String>) jComboBoxPhong.getModel();
        jComboBoxPhong.setModel(newComboBoxModel);
    }
    //Phương thức mở menu
    int width = 203;
    int height = 1000;
    void openMenuBar(){
        //Tạo luồng chạy song song với luồng chính Main
        new Thread(new Runnable(){
            @Override
            public void run(){
             for(int i = 0;i<width;i++){
                /* pnMenu.setSize(i,height);*/
                 
                 try {
                     //mở từ từ
                     Thread.sleep(2);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }   
            }
        }).start();
    }
    
    //Phương thức đống menu
    void closeMenuBar(){
        //Tạo luồng chạy song song với luồng chính Main
        new Thread(new Runnable(){
            @Override
            public void run(){
             for(int i = width;i>0;i--){
            /*     pnMenu.setSize(i,height);*/
                 
                 try {
                     Thread.sleep(2);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }   
            }
        }).start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableDatPhong = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        ReSearhHome = new javax.swing.JButton();
        TimPhongHome = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxTenPhong = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldLoaiPhong = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jComboBoxMaGV = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jTextFieldTenGV = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jComboBoxMonHoc = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        btnDatPhongDay = new javax.swing.JButton();
        btn_CapNhatPhongDay = new javax.swing.JButton();
        btnXoaPhongDay = new javax.swing.JButton();
        RePhongDay = new javax.swing.JButton();
        jCalendarNgayDay = new com.toedter.calendar.JCalendar();
        hinhgvHome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxTietBD = new javax.swing.JComboBox<>();
        jComboBoxTietKT = new javax.swing.JComboBox<>();
        QLPhong = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtmaSoPhong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSoChoNgoi = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtsearchField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        reSearch = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        UpdatePhong = new javax.swing.JButton();
        XoaPhong = new javax.swing.JButton();
        ThemPhong = new javax.swing.JButton();
        RePhong = new javax.swing.JButton();
        comboboxLoaiPhong = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        CoSo = new javax.swing.JComboBox<>();
        QLThietBi = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTB = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        TimPhongThemThietBi = new javax.swing.JButton();
        ThemThietBi = new javax.swing.JButton();
        UpdateThietBi = new javax.swing.JButton();
        XoaThietBi = new javax.swing.JButton();
        TimPhongThemThietBi4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        JLabelTenPhong = new javax.swing.JTextField();
        jComboBoxPhong = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jComboBoxTTThietBi = new javax.swing.JComboBox<>();
        jComboBoxThietBi = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        txtSoLuongTrongKho = new javax.swing.JTextField();
        QLGiaoVien = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGV = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtTenGV = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxGT = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        txtMaGV = new javax.swing.JTextField();
        ThemGV = new javax.swing.JButton();
        UpdateGV = new javax.swing.JButton();
        XoaGV = new javax.swing.JButton();
        ReGV = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        NgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        hinhgv = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        QLMonHoc = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMonHoc = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jComboBoxTinChi = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txtTenMonHoc = new javax.swing.JTextField();
        jComboBoxGiangVien = new javax.swing.JComboBox<>();
        ThemMon = new javax.swing.JButton();
        SuaMon = new javax.swing.JButton();
        XoaMon = new javax.swing.JButton();
        ReMon = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        TenGV_txt_Mon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hinhgvMH = new javax.swing.JLabel();
        QLKhoTB = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableKhoTB = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTimTB = new javax.swing.JTextField();
        jButtonTimTB = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtMaTB = new javax.swing.JTextField();
        txtLoaiTB = new javax.swing.JTextField();
        txtNameTB = new javax.swing.JTextField();
        txtNXS = new javax.swing.JTextField();
        txtSLTB = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        hinhTB = new javax.swing.JLabel();
        btn_ThemTB = new javax.swing.JButton();
        btn_CapNhatTB = new javax.swing.JButton();
        btn_XoaTB = new javax.swing.JButton();
        btn_ReTB = new javax.swing.JButton();
        ThongKe = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanelThongKe = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý phòng học");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(56, 161, 222));
        jPanel6.setPreferredSize(new java.awt.Dimension(710, 87));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8menu26.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quản lý phòng học");

        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogOut.setText("Đăng xuất");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(527, 527, 527)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(77, 77, 77))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnLogOut)))
                .addContainerGap())
        );

        jPanel4.setLayout(new java.awt.CardLayout());

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                HomeAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 161, 222), 5));
        jPanel11.setPreferredSize(new java.awt.Dimension(902, 474));

        jTableDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên phòng", "Loại phòng", "Ngày dạy", "Tiết bắt đầu", "Tiết kết thúc", "Môn học", "Mã GV", "Giảng viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatPhongMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableDatPhong);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 161, 222));
        jLabel1.setText("Danh sách các phòng đang hoạt động");

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(56, 161, 222));
        jLabel34.setText("Tìm phòng trống");

        ReSearhHome.setBackground(new java.awt.Color(56, 161, 222));
        ReSearhHome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ReSearhHome.setForeground(new java.awt.Color(255, 255, 255));
        ReSearhHome.setText("Refresh");
        ReSearhHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReSearhHomeActionPerformed(evt);
            }
        });

        TimPhongHome.setBackground(new java.awt.Color(56, 161, 222));
        TimPhongHome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TimPhongHome.setForeground(new java.awt.Color(255, 255, 255));
        TimPhongHome.setText("Lọc");
        TimPhongHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimPhongHomeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(56, 161, 222));
        jLabel2.setText("Thời gian dạy:");

        jLabel3.setText("Tên phòng:");

        jLabel7.setText("Tiết bắt đầu:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));

        jLabel8.setText("Tiết kết thúc:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(16, 16, 16)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TimPhongHome, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ReSearhHome, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(19, 19, 19)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimPhongHome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReSearhHome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(56, 161, 222));
        jLabel33.setText("Phân công phòng học");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Tên phòng:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Loại phòng:");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Mã giảng viên:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Tên giảng viên:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Môn học:");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Ngày dạy:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Tiết bắt đầu:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Tiết kết thúc");

        btnDatPhongDay.setBackground(new java.awt.Color(56, 161, 222));
        btnDatPhongDay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatPhongDay.setForeground(new java.awt.Color(255, 255, 255));
        btnDatPhongDay.setText("Phân công phòng học");
        btnDatPhongDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongDayActionPerformed(evt);
            }
        });

        btn_CapNhatPhongDay.setBackground(new java.awt.Color(56, 161, 222));
        btn_CapNhatPhongDay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_CapNhatPhongDay.setForeground(new java.awt.Color(255, 255, 255));
        btn_CapNhatPhongDay.setText("Cập nhật");
        btn_CapNhatPhongDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatPhongDayActionPerformed(evt);
            }
        });

        btnXoaPhongDay.setBackground(new java.awt.Color(56, 161, 222));
        btnXoaPhongDay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaPhongDay.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaPhongDay.setText("Xóa");
        btnXoaPhongDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPhongDayActionPerformed(evt);
            }
        });

        RePhongDay.setBackground(new java.awt.Color(56, 161, 222));
        RePhongDay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RePhongDay.setForeground(new java.awt.Color(255, 255, 255));
        RePhongDay.setText("Refresh");
        RePhongDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RePhongDayActionPerformed(evt);
            }
        });

        hinhgvHome.setBackground(new java.awt.Color(204, 204, 204));
        hinhgvHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hinhgvHome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ảnh giảng viên");

        jComboBoxTietBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "11", "12", "13", "14", "15" }));

        jComboBoxTietKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTietBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel41)
                            .addComponent(btnDatPhongDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaPhongDay, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(143, 143, 143)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTietKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)
                            .addComponent(btn_CapNhatPhongDay, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RePhongDay, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel39))
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addGap(18, 18, 18))
                                    .addGroup(HomeLayout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(21, 21, 21)))
                                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxTenPhong, 0, 202, Short.MAX_VALUE)
                                    .addComponent(jTextFieldLoaiPhong)))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(jCalendarNgayDay, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hinhgvHome, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(42, 42, 42))))
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HomeLayout.createSequentialGroup()
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextFieldLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hinhgvHome, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HomeLayout.createSequentialGroup()
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jComboBoxMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jTextFieldTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(jComboBoxMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel40))
                            .addGroup(HomeLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jCalendarNgayDay, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTietBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTietKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatPhongDay, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_CapNhatPhongDay, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaPhongDay, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RePhongDay, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel4.add(Home, "card2");

        QLPhong.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Mã số phòng:");

        txtmaSoPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaSoPhongActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Loại phòng:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Số chỗ ngồi:");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(56, 161, 222));
        jLabel15.setText("Tìm phòng");

        txtsearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchFieldKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(56, 161, 222));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        reSearch.setBackground(new java.awt.Color(56, 161, 222));
        reSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reSearch.setForeground(new java.awt.Color(255, 255, 255));
        reSearch.setText("Refresh");
        reSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reSearchActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 161, 222), 5));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên phòng", "Loại phòng", "Cơ sở", "Số chỗ ngồi", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(reSearch))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtsearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(56, 161, 222));
        jLabel14.setText("Quản lý phòng");

        UpdatePhong.setBackground(new java.awt.Color(56, 161, 222));
        UpdatePhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UpdatePhong.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePhong.setText("Sửa");
        UpdatePhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePhongActionPerformed(evt);
            }
        });

        XoaPhong.setBackground(new java.awt.Color(56, 161, 222));
        XoaPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        XoaPhong.setForeground(new java.awt.Color(255, 255, 255));
        XoaPhong.setText("Xóa");
        XoaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaPhongActionPerformed(evt);
            }
        });

        ThemPhong.setBackground(new java.awt.Color(56, 161, 222));
        ThemPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThemPhong.setForeground(new java.awt.Color(255, 255, 255));
        ThemPhong.setText("Thêm");
        ThemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemPhongActionPerformed(evt);
            }
        });

        RePhong.setBackground(new java.awt.Color(56, 161, 222));
        RePhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RePhong.setForeground(new java.awt.Color(255, 255, 255));
        RePhong.setText("Refresh");
        RePhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RePhongActionPerformed(evt);
            }
        });

        comboboxLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lý thuyết", "Thực hành" }));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Cơ sở:");

        CoSo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));
        CoSo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoSoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QLPhongLayout = new javax.swing.GroupLayout(QLPhong);
        QLPhong.setLayout(QLPhongLayout);
        QLPhongLayout.setHorizontalGroup(
            QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLPhongLayout.createSequentialGroup()
                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QLPhongLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel14))
                    .addGroup(QLPhongLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QLPhongLayout.createSequentialGroup()
                                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoChoNgoi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CoSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboboxLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtmaSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(QLPhongLayout.createSequentialGroup()
                                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(XoaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ThemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(116, 116, 116)
                                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(UpdatePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        QLPhongLayout.setVerticalGroup(
            QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(42, 42, 42)
                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(CoSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QLPhongLayout.createSequentialGroup()
                        .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtmaSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(jLabel12))
                    .addGroup(QLPhongLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(comboboxLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSoChoNgoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdatePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(QLPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(XoaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(QLPhong, "card3");

        QLThietBi.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(56, 161, 222));
        jLabel16.setText("Chọn phòng:");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.setPreferredSize(new java.awt.Dimension(798, 613));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 161, 222), 5));
        jPanel16.setPreferredSize(new java.awt.Dimension(782, 474));

        jTableTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên phòng", "Tên thiết bị", "Số lượng", "Tình trạng thiết bị", "Ảnh thiết bị"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTB.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTableTBMouseDragged(evt);
            }
        });
        jTableTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTBMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableTB);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText(" Chọn thiết bị:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Số lượng cần lấy:");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(56, 161, 222));
        jLabel22.setText("Quản lý thiết bị");

        TimPhongThemThietBi.setBackground(new java.awt.Color(56, 161, 222));
        TimPhongThemThietBi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TimPhongThemThietBi.setForeground(new java.awt.Color(255, 255, 255));
        TimPhongThemThietBi.setText("Chọn");
        TimPhongThemThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimPhongThemThietBiActionPerformed(evt);
            }
        });

        ThemThietBi.setBackground(new java.awt.Color(56, 161, 222));
        ThemThietBi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThemThietBi.setForeground(new java.awt.Color(255, 255, 255));
        ThemThietBi.setText("Thêm");
        ThemThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemThietBiActionPerformed(evt);
            }
        });

        UpdateThietBi.setBackground(new java.awt.Color(56, 161, 222));
        UpdateThietBi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UpdateThietBi.setForeground(new java.awt.Color(255, 255, 255));
        UpdateThietBi.setText("Sửa");
        UpdateThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateThietBiActionPerformed(evt);
            }
        });

        XoaThietBi.setBackground(new java.awt.Color(56, 161, 222));
        XoaThietBi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        XoaThietBi.setForeground(new java.awt.Color(255, 255, 255));
        XoaThietBi.setText("Xóa");
        XoaThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaThietBiActionPerformed(evt);
            }
        });

        TimPhongThemThietBi4.setBackground(new java.awt.Color(56, 161, 222));
        TimPhongThemThietBi4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TimPhongThemThietBi4.setForeground(new java.awt.Color(255, 255, 255));
        TimPhongThemThietBi4.setText("Refresh");
        TimPhongThemThietBi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimPhongThemThietBi4ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Tên phòng:");

        jComboBoxPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPhongActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Tình trạng thiết bị:");

        jComboBoxTTThietBi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tốt", "Cần sửa chữa" }));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Số lượng trong kho:");

        txtSoLuongTrongKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongTrongKhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QLThietBiLayout = new javax.swing.GroupLayout(QLThietBi);
        QLThietBi.setLayout(QLThietBiLayout);
        QLThietBiLayout.setHorizontalGroup(
            QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLThietBiLayout.createSequentialGroup()
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QLThietBiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QLThietBiLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ThemThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(XoaThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99)
                                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(UpdateThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TimPhongThemThietBi4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(QLThietBiLayout.createSequentialGroup()
                                    .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(32, 32, 32)
                                    .addComponent(TimPhongThemThietBi))
                                .addGroup(QLThietBiLayout.createSequentialGroup()
                                    .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(QLThietBiLayout.createSequentialGroup()
                                            .addComponent(jLabel49)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSoLuongTrongKho))
                                        .addGroup(QLThietBiLayout.createSequentialGroup()
                                            .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(QLThietBiLayout.createSequentialGroup()
                                                    .addGap(3, 3, 3)
                                                    .addComponent(jLabel23))
                                                .addComponent(jLabel20))
                                            .addGap(46, 46, 46)
                                            .addComponent(jComboBoxThietBi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(11, 11, 11)))
                            .addGroup(QLThietBiLayout.createSequentialGroup()
                                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel21))
                                .addGap(20, 20, 20)
                                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoLuong)
                                    .addComponent(JLabelTenPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                    .addComponent(jComboBoxTTThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(QLThietBiLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        QLThietBiLayout.setVerticalGroup(
            QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLThietBiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(41, 41, 41)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimPhongThemThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(JLabelTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBoxThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtSoLuongTrongKho, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jComboBoxTTThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(QLThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(XoaThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimPhongThemThietBi4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );

        jPanel4.add(QLThietBi, "card4");

        QLGiaoVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(56, 161, 222));
        jLabel24.setText("Quản lý giảng viên");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setName(""); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(918, 613));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 161, 222), 5));

        jTableGV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giảng viên", "Tên giảng viên", "Giới tính", "Số điện thoại", "Ngày sinh", "Ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGV);
        if (jTableGV.getColumnModel().getColumnCount() > 0) {
            jTableGV.getColumnModel().getColumn(1).setResizable(false);
            jTableGV.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Tên giảng viên:");

        txtTenGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenGVActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Giới tính:");

        jComboBoxGT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Mã giảng viên :");

        txtMaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaGVActionPerformed(evt);
            }
        });

        ThemGV.setBackground(new java.awt.Color(56, 161, 222));
        ThemGV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThemGV.setForeground(new java.awt.Color(255, 255, 255));
        ThemGV.setText("Thêm");
        ThemGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemGVActionPerformed(evt);
            }
        });

        UpdateGV.setBackground(new java.awt.Color(56, 161, 222));
        UpdateGV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        UpdateGV.setForeground(new java.awt.Color(255, 255, 255));
        UpdateGV.setText("Sửa");
        UpdateGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateGVActionPerformed(evt);
            }
        });

        XoaGV.setBackground(new java.awt.Color(56, 161, 222));
        XoaGV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        XoaGV.setForeground(new java.awt.Color(255, 255, 255));
        XoaGV.setText("Xóa");
        XoaGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaGVActionPerformed(evt);
            }
        });

        ReGV.setBackground(new java.awt.Color(56, 161, 222));
        ReGV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ReGV.setForeground(new java.awt.Color(255, 255, 255));
        ReGV.setText("Refresh");
        ReGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReGVActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Ngày sinh:");

        NgaySinh.setDateFormatString("dd-MM-yyyy");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Số điện thoại:");

        hinhgv.setBackground(new java.awt.Color(204, 204, 204));
        hinhgv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hinhgv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setText("Chọn ảnh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QLGiaoVienLayout = new javax.swing.GroupLayout(QLGiaoVien);
        QLGiaoVien.setLayout(QLGiaoVienLayout);
        QLGiaoVienLayout.setHorizontalGroup(
            QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLGiaoVienLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(QLGiaoVienLayout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addComponent(jLabel24))
                        .addGroup(QLGiaoVienLayout.createSequentialGroup()
                            .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31)
                                .addComponent(jLabel19))
                            .addGap(18, 18, 18)
                            .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSDT)))
                        .addGroup(QLGiaoVienLayout.createSequentialGroup()
                            .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel25)
                                .addComponent(jLabel18))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaGV)
                                    .addComponent(txtTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(QLGiaoVienLayout.createSequentialGroup()
                        .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ThemGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(XoaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateGV, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReGV, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QLGiaoVienLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jButton2))
                            .addComponent(hinhgv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        QLGiaoVienLayout.setVerticalGroup(
            QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLGiaoVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(53, 53, 53)
                .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxGT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(QLGiaoVienLayout.createSequentialGroup()
                        .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(34, 34, 34)
                        .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(QLGiaoVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QLGiaoVienLayout.createSequentialGroup()
                        .addComponent(UpdateGV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(ReGV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QLGiaoVienLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hinhgv, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(QLGiaoVienLayout.createSequentialGroup()
                        .addComponent(ThemGV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(XoaGV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );

        jPanel4.add(QLGiaoVien, "card5");

        QLMonHoc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(56, 161, 222));
        jLabel26.setText("Quản lý môn học ");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setPreferredSize(new java.awt.Dimension(798, 613));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 161, 222), 5));

        jTableMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên môn học", "Số tín chỉ", "Tên giáo viên", "Mã GV", "Ảnh giảng viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMonHocMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableMonHoc);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Tên môn học:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Số tín chỉ:");

        jComboBoxTinChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4" }));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Mã giảng viên:");

        ThemMon.setBackground(new java.awt.Color(56, 161, 222));
        ThemMon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ThemMon.setForeground(new java.awt.Color(255, 255, 255));
        ThemMon.setText("Thêm");
        ThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemMonActionPerformed(evt);
            }
        });

        SuaMon.setBackground(new java.awt.Color(56, 161, 222));
        SuaMon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SuaMon.setForeground(new java.awt.Color(255, 255, 255));
        SuaMon.setText("Sửa");
        SuaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaMonActionPerformed(evt);
            }
        });

        XoaMon.setBackground(new java.awt.Color(56, 161, 222));
        XoaMon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        XoaMon.setForeground(new java.awt.Color(255, 255, 255));
        XoaMon.setText("Xóa");
        XoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaMonActionPerformed(evt);
            }
        });

        ReMon.setBackground(new java.awt.Color(56, 161, 222));
        ReMon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ReMon.setForeground(new java.awt.Color(255, 255, 255));
        ReMon.setText("Refresh");
        ReMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReMonActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Tên giảng viên:");

        TenGV_txt_Mon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ảnh giảng viên");

        hinhgvMH.setBackground(new java.awt.Color(204, 204, 204));
        hinhgvMH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hinhgvMH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout QLMonHocLayout = new javax.swing.GroupLayout(QLMonHoc);
        QLMonHoc.setLayout(QLMonHocLayout);
        QLMonHocLayout.setHorizontalGroup(
            QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLMonHocLayout.createSequentialGroup()
                .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QLMonHocLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ThemMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(XoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SuaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReMon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(QLMonHocLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QLMonHocLayout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TenGV_txt_Mon))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QLMonHocLayout.createSequentialGroup()
                                .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(18, 18, 18)
                                .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenMonHoc)
                                    .addComponent(jComboBoxGiangVien, 0, 206, Short.MAX_VALUE))))
                        .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QLMonHocLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(hinhgvMH, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(QLMonHocLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel5))))
                    .addGroup(QLMonHocLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        QLMonHocLayout.setVerticalGroup(
            QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLMonHocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(43, 43, 43)
                .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(QLMonHocLayout.createSequentialGroup()
                        .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtTenMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jComboBoxTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jComboBoxGiangVien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(TenGV_txt_Mon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(QLMonHocLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(hinhgvMH, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(QLMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(XoaMon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReMon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );

        jPanel4.add(QLMonHoc, "card6");

        QLKhoTB.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 161, 222), 5));

        jTableKhoTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thiết bị", "Tên thiết bị", "Loại thiết bị", "Số lượng", "Nhà sản xuất", "Ngày nhập", "Ảnh thiết bị"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableKhoTB.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableKhoTBAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jTableKhoTBAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTableKhoTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhoTBMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableKhoTB);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(56, 161, 222));
        jLabel6.setText("Tìm kiếm thiết bị");

        jButtonTimTB.setBackground(new java.awt.Color(56, 161, 222));
        jButtonTimTB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonTimTB.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTimTB.setText("TÌm");
        jButtonTimTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimTBActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(56, 161, 222));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Refresh");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTimTB, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonTimTB, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTimTB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTimTB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(56, 161, 222));
        jLabel44.setText("Quản lý kho thiết bị");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Loại thiết bị:");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setText("Nhà sản xuất:");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("Tên thiết bị:");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("Mã thiết bị:");

        txtNXS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNXSActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setText("Số lượng:");

        jButton3.setText("Chọn ảnh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        hinhTB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_ThemTB.setBackground(new java.awt.Color(56, 161, 222));
        btn_ThemTB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ThemTB.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemTB.setText("Thêm");
        btn_ThemTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemTBActionPerformed(evt);
            }
        });

        btn_CapNhatTB.setBackground(new java.awt.Color(56, 161, 222));
        btn_CapNhatTB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_CapNhatTB.setForeground(new java.awt.Color(255, 255, 255));
        btn_CapNhatTB.setText("Cập nhật");
        btn_CapNhatTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatTBActionPerformed(evt);
            }
        });

        btn_XoaTB.setBackground(new java.awt.Color(56, 161, 222));
        btn_XoaTB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_XoaTB.setForeground(new java.awt.Color(255, 255, 255));
        btn_XoaTB.setText("Xóa");
        btn_XoaTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTBActionPerformed(evt);
            }
        });

        btn_ReTB.setBackground(new java.awt.Color(56, 161, 222));
        btn_ReTB.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ReTB.setForeground(new java.awt.Color(255, 255, 255));
        btn_ReTB.setText("Refresh");
        btn_ReTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReTBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QLKhoTBLayout = new javax.swing.GroupLayout(QLKhoTB);
        QLKhoTB.setLayout(QLKhoTBLayout);
        QLKhoTBLayout.setHorizontalGroup(
            QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLKhoTBLayout.createSequentialGroup()
                .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QLKhoTBLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_ThemTB, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(btn_XoaTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_CapNhatTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ReTB, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hinhTB, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QLKhoTBLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jButton3)
                                .addGap(74, 74, 74)))
                        .addGap(12, 12, 12))
                    .addGroup(QLKhoTBLayout.createSequentialGroup()
                        .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(QLKhoTBLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel44))
                            .addGroup(QLKhoTBLayout.createSequentialGroup()
                                .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(QLKhoTBLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel50)
                                            .addComponent(jLabel47)
                                            .addComponent(jLabel46)
                                            .addComponent(jLabel45)))
                                    .addGroup(QLKhoTBLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel48)))
                                .addGap(36, 36, 36)
                                .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNXS, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLoaiTB, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSLTB, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNameTB, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        QLKhoTBLayout.setVerticalGroup(
            QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QLKhoTBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addGap(51, 51, 51)
                .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QLKhoTBLayout.createSequentialGroup()
                        .addComponent(txtMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNameTB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)))
                    .addComponent(jLabel45))
                .addGap(20, 20, 20)
                .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtLoaiTB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSLTB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(27, 27, 27)
                .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtNXS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hinhTB, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(QLKhoTBLayout.createSequentialGroup()
                        .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_CapNhatTB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(QLKhoTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_XoaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ReTB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(QLKhoTB, "card7");

        ThongKe.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelThongKeLayout = new javax.swing.GroupLayout(jPanelThongKe);
        jPanelThongKe.setLayout(jPanelThongKeLayout);
        jPanelThongKeLayout.setHorizontalGroup(
            jPanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1283, Short.MAX_VALUE)
        );
        jPanelThongKeLayout.setVerticalGroup(
            jPanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(jPanelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout ThongKeLayout = new javax.swing.GroupLayout(ThongKe);
        ThongKe.setLayout(ThongKeLayout);
        ThongKeLayout.setHorizontalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ThongKeLayout.setVerticalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(ThongKe, "card8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1651, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
      /*  openMenuBar();*/
       if(drawer.isShow()){
            drawer.hide();
        }
        else{
            drawer.show();
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txtmaSoPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaSoPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaSoPhongActionPerformed


    private void UpdatePhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePhongActionPerformed
        ToanCuc tt = new ToanCuc();
        String selectedText = (String) comboboxLoaiPhong.getSelectedItem();
        String chonLoai = (String) CoSo.getSelectedItem();
        
         if(txtmaSoPhong.getText().isEmpty() && txtSoChoNgoi.getText().isEmpty()){
          JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
        }
        else{
             
                  String TENPHONG = chonLoai + ""+txtmaSoPhong.getText();
            int selectedRow = jTable1.getSelectedRow();
            // Lấy giá trị từ cột "Name" của dòng được chọn
              String selectedValue = (String) jTable1.getValueAt(selectedRow, 0); 
              if(selectedRow != -1){
                  if(checkTrungPhongTrongBang(TENPHONG)){
                      JOptionPane.showMessageDialog(this, "Thiết bị đã có trong phòng");
                  }
                  else{
                      if(!selectedValue.equals(TENPHONG) ){
                  JOptionPane.showMessageDialog(this, "Tên phòng không hợp lệ");
              }
              else{
                  try{
            Connection conn = cn.getConnection();
             String namephong = txtmaSoPhong.getText(); 
            if(namephong.length() > 2 || isNumber(namephong)==false){
                 JOptionPane.showMessageDialog(this, "Mã số phòng không hợp lệ");
            }
            else{
                
             int sochongoi = Integer.parseInt(txtSoChoNgoi.getText());
                 if(sochongoi <=100){
              String update = "Update PhongHoc set SoChoNgoi=?,LoaiPhong=?,CoSo=? where Email = ? and tenPhong = ?";
             PreparedStatement st = conn.prepareStatement(update);
             st.setInt(1, sochongoi);
             st.setString(2, selectedText);
             st.setString(3, chonLoai);
             st.setString(4, tt.getEmail());
             st.setString(5, TENPHONG);
              st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Update phòng học thành công"); 
                txtmaSoPhong.setText("");
                txtSoChoNgoi.setText("");
             
             conn.close();
             LayDuTenPHLen();
             LoadJComboCHonPhong();
             
             LayDuTenPHLenHome();
             LoadJComboCHonPhongHome();
             
             LayDuTenPHLenHome2();
             LoadJComboCHonPhongHome2();
             //Load loai phong
        LayDuLoaiPhongLenHome();
            }
                 else{
                     JOptionPane.showMessageDialog(this, "Số chỗ ngồi không được vượt quá 100"); 
                 }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Update phòng học thất bại");
        }   
                  } 
                    }
                  
                    }
           
 }
        LoadDataPhongHoc();
        LoadDataTablePhongHoc();
        jComboBoxPhong.setSelectedItem(null);
    }//GEN-LAST:event_UpdatePhongActionPerformed

    private void XoaGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaGVActionPerformed
        ToanCuc tt = new ToanCuc();
        
        String selectedGT = (String) jComboBoxGT.getSelectedItem();
       
             try{
            Connection conn = cn.getConnection(); 
            // Lấy 2 ký tự đầu
                String haiKyTuDau = txtMaGV.getText().substring(0, 2);

                // Lấy 2 ký tự cuối
                String haiKyTuCuoi = txtMaGV.getText().substring(txtMaGV.getText().length() - 2);
             if(txtMaGV.getText().length() > 4 || txtMaGV.getText().length() < 4 || !haiKyTuDau.equals("GV") || isNumber(haiKyTuCuoi)==false){
                 JOptionPane.showMessageDialog(this, "Mã giảng viên không được quá 4 ký tự , 2 ký tự đầu phải là GV và 2 ký tự sau phải là số");
            }
            else{
                 String checkLichHocQuery = "SELECT COUNT(*) FROM LichHoc WHERE id_gv in (SELECT id_gv FROM GiangVien WHERE MaGV = ? and  Email = ?)";
            PreparedStatement checkLichHocStatement = conn.prepareStatement(checkLichHocQuery);
            checkLichHocStatement.setString(1, txtMaGV.getText());
            checkLichHocStatement.setString(2, tt.getEmail());
            ResultSet checkLichHocResult = checkLichHocStatement.executeQuery();
             
            // Lấy số lượng bản ghi liên quan
            int lichHocCount = 0;
            if (checkLichHocResult.next()) {
                lichHocCount = checkLichHocResult.getInt(1);
            }
            if(lichHocCount == 0){
                 //Tạm thời tắt khóa ngoại
          /* String disableForeignKey = "ALTER TABLE dbo.MonHoc NOCHECK CONSTRAINT FK__MonHoc__MaGV__3F466844";
            PreparedStatement disableFkStatement = conn.prepareStatement(disableForeignKey);
            disableFkStatement.execute();
            
            String disableForeignKey2 = "ALTER TABLE dbo.LichHoc NOCHECK CONSTRAINT FK__LichHoc__MaGV__46E78A0C";
            PreparedStatement disableFkStatement2 = conn.prepareStatement(disableForeignKey2);
            disableFkStatement2.execute();*/
            
              String update = "Delete from GiangVien  where MaGV = ? and Email = ?";
             PreparedStatement st = conn.prepareCall(update);
             // Lấy giá trị ngày từ JDateChooser
             st.setString(1,txtMaGV.getText());
             st.setString(2,tt.getEmail());
              st.executeUpdate();
              
             String deletetb = "Delete mh " +
             "from MonHoc mh join GiangVien gv on mh.id_gv = gv.id_gv" +
              " where mh.Email = ?  and gv.MaGV = ?";
             PreparedStatement sttb = conn.prepareStatement(deletetb);
             sttb.setString(1, tt.getEmail());
             sttb.setString(2, txtMaGV.getText());
             sttb.executeUpdate();
             /*
             String ttgv = "null";
             String updategv = "Update LichHoc set MaGV = ? where MaGV = ? and Email = ?";
             PreparedStatement sttt = conn.prepareCall(updategv);
             sttt.setString(1,txtTenGV.getText());
              sttt.setString(2,txtTenGV.getText());
             sttt.setString(3, tt.getEmail());
              sttb.executeUpdate();
            // Bật lại ràng buộc khóa ngoại
            String enableForeignKey = "ALTER TABLE dbo.MonHoc CHECK CONSTRAINT FK__MonHoc__MaGV__3F466844";
            PreparedStatement enableFkStatement = conn.prepareStatement(enableForeignKey);
            enableFkStatement.execute();
            
            
            String enableForeignKey2 = "ALTER TABLE dbo.LichHoc CHECK CONSTRAINT FK__LichHoc__MaGV__46E78A0C";
            PreparedStatement enableFkStatement2 = conn.prepareStatement(enableForeignKey2);
            enableFkStatement2.execute();*/
                JOptionPane.showMessageDialog(this, "Xóa giáo viên có mã "+ txtMaGV.getText() +" thành công"); 
                txtMaGV.setText(null);
                txtTenGV.setText(null);
                NgaySinh.setDate(null);
             txtSDT.setText(null);
             
               hinhgv.setIcon(null);
               
               txtTenMonHoc.setText(null);
               jComboBoxGiangVien.setSelectedItem(null);
               jComboBoxTinChi.setSelectedItem(null);
               jTableMonHoc.clearSelection();
               TenGV_txt_Mon.setText(null);
               hinhgvMH.setIcon(null);
               txtMaGV.setEnabled(true);
               
             conn.close();
             LayDuMaGVLen();
            LoadJComboCHonGV();
            LayDuMaGVLenHome();
         LoadJComboCHonGVHome();
         
         }
            else{
                JOptionPane.showMessageDialog(this, "Giảng viên đang dạy không thể xóa"); 
            }
            }
         }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Xóa giáo viên thất bại");
        }
        LoadDataGV();
        try {
            LoadDataTableGV();
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoadDataMonHoc();
        try {
            LoadDataTableMH();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
         LoadDataDatPhongHoc();
        LoadDataTableDatPhongHoc();
        jComboBoxGiangVien.setSelectedItem(null);
        jComboBoxMaGV.setSelectedItem(null);
    }//GEN-LAST:event_XoaGVActionPerformed

    //Them phong
    private void ThemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemPhongActionPerformed
        ToanCuc tt = new ToanCuc();
        
        String selectedText = (String) comboboxLoaiPhong.getSelectedItem();
        String chonLoai = (String) CoSo.getSelectedItem();
        String TENPHONG = chonLoai + ""+txtmaSoPhong.getText();
        if(txtmaSoPhong.getText().isEmpty() && txtSoChoNgoi.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
        }
        else{
           if(checkTrungPhong(TENPHONG)==true){
         JOptionPane.showMessageDialog(this, "Tên phòng đã tồn tại");   
        }
        else{
             try{
            Connection conn = cn.getConnection();
             String namephong = txtmaSoPhong.getText(); 
            if(namephong.length() > 2 || isNumber(namephong)==false){
                 JOptionPane.showMessageDialog(this, "Mã số phòng không hợp lệ");
            }
            else{
             int sochongoi = Integer.parseInt(txtSoChoNgoi.getText());
             if(sochongoi <=100){
                    String insert = "INSERT INTO PhongHoc(tenPhong, SoChoNgoi, LoaiPhong,CoSo,TrangThai,Solansudung, Email) VALUES (?,?,?,?,?,?,?)";
             PreparedStatement st = conn.prepareCall(insert);
             String trangthai = "Trống";
             st.setString(1, TENPHONG);
             st.setInt(2, sochongoi);
             st.setString(3, selectedText);
             st.setString(4, chonLoai);
             st.setString(5, trangthai);
             st.setInt(6, 0);
             st.setString(7, tt.getEmail());
              st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm phòng học thành công"); 
                txtmaSoPhong.setText("");
                txtSoChoNgoi.setText("");
             
             conn.close();
              LayDuTenPHLen();
             LoadJComboCHonPhong();
             LayDuTenPHLenHome();
             LoadJComboCHonPhongHome();
             LayDuTenPHLenHome2();
             LoadJComboCHonPhongHome2();
             jComboBoxTenPhong.setSelectedItem(null);
             
             }
             else{
                 JOptionPane.showMessageDialog(this, "Số chỗ ngồi không vượt quá 100");
             }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Thêm phòng học thất bại");
        }
       } 
    }
        LoadDataPhongHoc();
        LoadDataTablePhongHoc();
        controller.setTenPhongToChart(jPanelThongKe);
        jComboBoxPhong.setSelectedItem(null);
    }//GEN-LAST:event_ThemPhongActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        current = jTable1.getSelectedRow();
        if(current != -1){
        DisplayPhong(current);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void CoSoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoSoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CoSoActionPerformed

    private void XoaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaPhongActionPerformed
         ToanCuc tt = new ToanCuc();
        String selectedText = (String) comboboxLoaiPhong.getSelectedItem();
        String chonLoai = (String) CoSo.getSelectedItem();
        
        if(txtmaSoPhong.getText().isEmpty() && txtSoChoNgoi.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
        }
        else{
            int selectedRow = jTable1.getSelectedRow();
            // Lấy giá trị từ cột "Name" của dòng được chọn
              String selectedValue = (String) jTable1.getValueAt(selectedRow, 0);
            
              if(selectedRow != -1){
                  String TENPHONG = chonLoai + ""+txtmaSoPhong.getText();
              if(!selectedValue.equals(TENPHONG) ){
                  JOptionPane.showMessageDialog(this, "Tên phòng không hợp lệ");
              }
              else{
                  try{
            Connection conn = cn.getConnection();
             String namephong = txtmaSoPhong.getText(); 
            if(namephong.length() > 2 || isNumber(namephong)==false){
                 JOptionPane.showMessageDialog(this, "Mã số phòng không hợp lệ");
            }
            else{
                String checkLichHocQuery = "SELECT COUNT(*) FROM LichHoc WHERE id_phong IN (SELECT id_phong FROM PhongHoc WHERE tenPhong = ?)";
            PreparedStatement checkLichHocStatement = conn.prepareStatement(checkLichHocQuery);
            checkLichHocStatement.setString(1, TENPHONG);
            ResultSet checkLichHocResult = checkLichHocStatement.executeQuery();
             
            // Lấy số lượng bản ghi liên quan
            int lichHocCount = 0;
            if (checkLichHocResult.next()) {
                lichHocCount = checkLichHocResult.getInt(1);
            }
            if(lichHocCount == 0){
               
                // Tạm thời tắt ràng buộc khóa ngoại
            /*String disableForeignKey = "ALTER TABLE dbo.LichHoc NOCHECK CONSTRAINT FK__LichHoc__tenPhon__46E78A0C";
            PreparedStatement disableFkStatement = conn.prepareStatement(disableForeignKey);
            disableFkStatement.execute();*/
            
            String delete = "Delete from PhongHoc where Email = ? and tenPhong = ?";
             PreparedStatement st = conn.prepareStatement(delete);
             st.setString(1, tt.getEmail());
             st.setString(2, TENPHONG);
             st.executeUpdate();
             
             String deletetb = "Delete tb " +
             "from ThietBi tb join PhongHoc ph on tb.id_phong = ph.id_phong" +
              " where tb.Email = ?  and ph.tenPhong = ?";
             PreparedStatement sttb = conn.prepareStatement(deletetb);
             sttb.setString(1, tt.getEmail());
             sttb.setString(2, TENPHONG);
             sttb.executeUpdate();
            
             JOptionPane.showMessageDialog(this, "Xóa phòng học thành công"); 
                
             // Bật lại ràng buộc khóa ngoại
            // Bật lại ràng buộc khóa ngoại
           /*
            String enableForeignKey = "ALTER TABLE dbo.LichHoc CHECK CONSTRAINT FK__LichHoc__tenPhon__46E78A0C";
            PreparedStatement enableFkStatement = conn.prepareStatement(enableForeignKey);
            enableFkStatement.execute();*/
            
             conn.close();
             DisplayPhong(current--); 
             LayDuTenPHLen();
            LoadJComboCHonPhong();
            
            LayDuTenPHLenHome();
            LoadJComboCHonPhongHome();
            
            LayDuTenPHLenHome2();
             LoadJComboCHonPhongHome2();
            txtmaSoPhong.setText(null);
            txtSoChoNgoi.setText(null); 
            }
            else{
              JOptionPane.showMessageDialog(this, "Phòng đang hoạt động không thể xóa phòng");  
            }
            }
            
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Xóa phòng học thất bại");
        }
                  
        controller.setTenPhongToChart(jPanelThongKe);
              }
              
        } 
      }
        LoadDataPhongHoc();
        LoadDataTablePhongHoc();
        LoadDataThietBi();
        try {
            LoadDataTableThietBi();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoadDataDatPhongHoc();
        LoadDataTableDatPhongHoc();
        jComboBoxPhong.setSelectedItem(null);
         
    }//GEN-LAST:event_XoaPhongActionPerformed
  
    
    private void RePhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RePhongActionPerformed
        txtmaSoPhong.setText("");
        txtSoChoNgoi.setText("");
        jTable1.clearSelection();
        jComboBoxPhong.setSelectedItem(null);
    }//GEN-LAST:event_RePhongActionPerformed

    private void txtsearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchFieldKeyReleased
        
    }//GEN-LAST:event_txtsearchFieldKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       listPhong.clear();
         ToanCuc tt = new ToanCuc();
         int sochongoi = 0;
         try{
          Connection conn = cn.getConnection();
          if(txtsearchField.getText().isEmpty()){
              sochongoi = 0;
          }
          else{
              if(txtsearchField.getText().chars().allMatch(Character::isDigit)){
              sochongoi = Integer.parseInt(txtsearchField.getText());
          }
          }
           String timphong = "select * from PhongHoc where tenPhong like '%" + txtsearchField.getText()+"%' and Email like '"+tt.getEmail()+"'";
          PreparedStatement st = conn.prepareStatement(timphong);
          ResultSet rs = st.executeQuery();
          while(rs.next()){
              int id = rs.getInt("id_phong");
              String tenphong = rs.getString("tenPhong");
              int socho = rs.getInt("SoChoNgoi");
              String loaiphong = rs.getString("LoaiPhong");
              String coso = rs.getString("CoSo");
              String trangthai = rs.getString("TrangThai");
              
              PhongHoc ph = new PhongHoc(id,tenphong,socho,loaiphong,coso,trangthai);
              
              listPhong.add(ph);
          }
          conn.close();
          LoadDataTablePhongHoc();
         }
         catch (Exception ex){
             ex.printStackTrace();
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reSearchActionPerformed
        txtsearchField.setText(null);
    }//GEN-LAST:event_reSearchActionPerformed

    private void jComboBoxPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPhongActionPerformed
      
    }//GEN-LAST:event_jComboBoxPhongActionPerformed

    private void TimPhongThemThietBiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimPhongThemThietBiActionPerformed
        ThietBi tb = new ThietBi();
        String selectedText = (String) jComboBoxPhong.getSelectedItem();
        JLabelTenPhong.setText(selectedText);
    }//GEN-LAST:event_TimPhongThemThietBiActionPerformed

    public void loadTSoluongTB(String email){
        jComboBoxThietBi.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedTenTB = (String) jComboBoxThietBi.getSelectedItem();
                try {
                    Connection conn = cn.getConnection();
                    String query = "SELECT SoLuongTB FROM KhoThietBi WHERE TenTB = ? AND Email = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setString(1, selectedTenTB);
                    st.setString(2, email);
                    ResultSet resultSet = st.executeQuery();
                    if (resultSet.next()) {
                        String tenGiangVien = resultSet.getString("SoLuongTB");
                        txtSoLuongTrongKho.setText(tenGiangVien);
                    } else {
                        txtSoLuongTrongKho.setText("");
                    }
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
    txtSoLuongTrongKho.setEditable(false);
    txtSoLuongTrongKho.setDisabledTextColor(Color.DARK_GRAY);
    }
    private void ThemThietBiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemThietBiActionPerformed
        ToanCuc tt = new ToanCuc();
        
        String selectedText = (String) jComboBoxPhong.getSelectedItem();
        String selectedTextTT = (String) jComboBoxTTThietBi.getSelectedItem();
        String chonThietBi = (String) jComboBoxThietBi.getSelectedItem();
        if(selectedText == null || JLabelTenPhong.getText().isEmpty() || chonThietBi == null || txtSoLuong.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn phải điền đầy đủ thông tin");
        }
        else{
            try{
            Connection conn = cn.getConnection();
           boolean hasDuplicate = false; // Biến để kiểm tra xem có dòng nào giống dữ liệu nhập không
    
            // Duyệt qua từng dòng trong JTable
            for (int row = 0; row < jTableTB.getRowCount(); row++) {
                String tenThietBi = jTableTB.getValueAt(row, 1).toString(); // Lấy giá trị cột "tenThietBi" của dòng
                String tenPhong = jTableTB.getValueAt(row, 0).toString(); // Lấy giá trị cột "tenPhong" của dòng

                // Kiểm tra nếu dữ liệu của dòng giống với dữ liệu nhập
                if (tenThietBi.equals(chonThietBi) && tenPhong.equals(selectedText)) {
                    hasDuplicate = true;
                    break; // Thoát khỏi vòng lặp nếu tìm thấy dòng giống
                }
            }  
            if(hasDuplicate){
                 JOptionPane.showMessageDialog(this, "Thiết bị đã có trong phòng bạn chỉ có thể cập nhật hoặc xóa");
            }
            else{
                int soluongtrongkho = Integer.parseInt(txtSoLuongTrongKho.getText());
             int soluong = Integer.parseInt(txtSoLuong.getText());
             if(soluongtrongkho < soluong){
                JOptionPane.showMessageDialog(this, "Số lương thiết bị bàn cần không đủ"); 
             }
             else{
              String insert = "INSERT INTO ThietBi(id_tb, soLuong,id_phong,TinhTrangTB,Email) VALUES (?,?,?,?,?)";
             PreparedStatement st = conn.prepareCall(insert);
             int id_phong = 0;
             String queryPhongHoc = "SELECT id_phong FROM PhongHoc WHERE tenPhong = ?";
                PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                stPhongHoc.setString(1, selectedText);
                ResultSet rs = stPhongHoc.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rs.next()) {
                    id_phong = rs.getInt("id_phong");
                    }
              
              int id_tb1 = 0;
             String querytb = "SELECT id_tb FROM KhoThietBi WHERE TenTB = ?";
                PreparedStatement sttb1 = conn.prepareStatement(querytb);
                sttb1.setString(1, chonThietBi);
                ResultSet rstb1 = sttb1.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rstb1.next()) {
                    id_tb1 = rstb1.getInt("id_tb");
                    }
             st.setInt(1, id_tb1);
             st.setInt(2, soluong);
             st.setInt(3, id_phong);
             st.setString(4, selectedTextTT);
             st.setString(5, tt.getEmail());
              st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm thiết bị vào phòng "+selectedText+ " thành công");
                txtSoLuong.setText(null);
                JLabelTenPhong.setText(null);
                jComboBoxThietBi.setSelectedItem(null);
                jComboBoxPhong.setSelectedItem(null);
                txtSoLuongTrongKho.setText(null);
                String update = "Update KhoThietBi set SoLuongTB = ? where Email = ? and id_tb = ?";
                PreparedStatement stthietbi = conn.prepareCall(update);
                 int id_tb = 0;
             String queryTB = "SELECT id_tb FROM KhoThietBi WHERE TenTB = ?";
                PreparedStatement stTB = conn.prepareStatement(queryTB);
                stTB.setString(1, chonThietBi);
                ResultSet rstb = stTB.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rstb.next()) {
                    id_tb = rstb.getInt("id_tb");
                    }
              int soluonglayra = soluongtrongkho - soluong;
              stthietbi.setInt(1, soluonglayra);
              stthietbi.setString(2, tt.getEmail());
              stthietbi.setInt(3, id_tb);
              stthietbi.executeUpdate();
              LoadDataKhoThietBi();
              LoadDataTableKhoTB();
             conn.close();
             }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Thêm thiết bị thất bại");
        }
       }
             
        LoadDataThietBi();
        try {
            LoadDataTableThietBi();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ThemThietBiActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void UpdateThietBiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateThietBiActionPerformed
        ToanCuc tt = new ToanCuc();
        
        String selectedText = (String) jComboBoxPhong.getSelectedItem();
        String selectedTextTT = (String) jComboBoxTTThietBi.getSelectedItem();
        String chonThietBi = (String) jComboBoxThietBi.getSelectedItem();
        if(selectedText == null || JLabelTenPhong.getText().isEmpty() || chonThietBi == null || txtSoLuong.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn phải điền đầy đủ thông tin");
        }
        else{
             try{
                 int selectedRow = jTableTB.getSelectedRow(); // Lấy chỉ số của dòng được chọn
                int selectectSoluong = Integer.parseInt(jTableTB.getValueAt(selectedRow,jTableTB.getColumn("Số lượng").getModelIndex()).toString());
            Connection conn = cn.getConnection();
             // Kiểm tra sự tồn tại của thiết bị trong phòng
        
        ThietBi tb = new ThietBi();
            if(checkTrungPhongVaThietBi(JLabelTenPhong.getText(),chonThietBi)){
                 JOptionPane.showMessageDialog(this, "Thiết bị đã có trong phòng bạn chỉ có thể cập nhật hoặc xóa");
                 return;
            }
            else{
                if(checkTrungPhongTB(selectedText)==false){
                    JOptionPane.showMessageDialog(this, "Phòng chưa có thiết bị để cập nhật");
                }
                else{
                    int soluongtrongkho = Integer.parseInt(txtSoLuongTrongKho.getText());
                    int soluong = Integer.parseInt(txtSoLuong.getText());
                    int soluongbi = soluong - selectectSoluong;
                    int id_phong = 0;
             String queryPhongHoc = "SELECT id_phong FROM PhongHoc WHERE tenPhong = ?";
                PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                stPhongHoc.setString(1, selectedText);
                ResultSet rs = stPhongHoc.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rs.next()) {
                    id_phong = rs.getInt("id_phong");
                    }
              
               int id_tb1 = 0;
             String querytb = "SELECT id_tb FROM KhoThietBi WHERE TenTB = ?";
                PreparedStatement sttb1 = conn.prepareStatement(querytb);
                sttb1.setString(1, chonThietBi);
                ResultSet rstb1 = sttb1.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rstb1.next()) {
                    id_tb1 = rstb1.getInt("id_tb");
                    }
             if(soluongbi < 0){
              String update1 = "Update ThietBi set id_tb = ?,soLuong= ?,TinhTrangTB= ? where Email = ? and id_phong = ?";
             PreparedStatement st1 = conn.prepareCall(update1);
             st1.setInt(1, id_tb1);
             st1.setInt(2, soluong);
             st1.setString(3, selectedTextTT);
             st1.setString(4, tt.getEmail());
             st1.setInt(5, id_phong);
             st1.executeUpdate();
             jComboBoxThietBi.setSelectedItem(null);
             txtSoLuong.setText(null);
             JLabelTenPhong.setText(null);
             jComboBoxPhong.setSelectedItem(null);
             
             JOptionPane.showMessageDialog(this, "Cập thiết bị phòng "+selectedText+ " thành công"); 
                   
             String updatesl1 = "Update KhoThietBi set SoLuongTB = ? where Email = ? and id_tb = ?";
                PreparedStatement stthietbi1 = conn.prepareCall(updatesl1);
                 int id_tb2 = 0;
             String queryTB1 = "SELECT id_tb FROM KhoThietBi WHERE TenTB = ?";
                PreparedStatement stTB1 = conn.prepareStatement(queryTB1);
                stTB1.setString(1, chonThietBi);
                ResultSet rstb = stTB1.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rstb.next()) {
                    id_tb2 = rstb.getInt("id_tb");
                    }
              int soluonglayra = soluongtrongkho + ((soluongbi) * (-1));
              stthietbi1.setInt(1, soluonglayra);
              stthietbi1.setString(2, tt.getEmail());
              stthietbi1.setInt(3, id_tb2);
              stthietbi1.executeUpdate();
             }
             else{
                 if(soluongbi > soluongtrongkho){
                      JOptionPane.showMessageDialog(this, "Số lượng thiết bị trong kho không đủ!"); 
                 }
                 else{
                     if(soluongbi == soluongtrongkho){
                         JOptionPane.showMessageDialog(this, "Bạn phải để số lượng thiết bị còn lại tỏng kho là 1!");
                     }
                     else{
                        String update1 = "Update ThietBi set id_tb = ?,soLuong = ?,TinhTrangTB = ? where Email = ? and id_phong = ?";
             PreparedStatement st1 = conn.prepareCall(update1);
             st1.setInt(1, id_tb1);
             st1.setInt(2, soluong);
             st1.setString(3, selectedTextTT);
             st1.setString(4, tt.getEmail());
             st1.setInt(5, id_phong);
             st1.executeUpdate();
             jComboBoxThietBi.setSelectedItem(null);
             txtSoLuong.setText(null);
             JLabelTenPhong.setText(null);
             jComboBoxPhong.setSelectedItem(null);
             jComboBoxThietBi.setSelectedItem(null);
             JOptionPane.showMessageDialog(this, "Cập thiết bị phòng "+selectedText+ " thành công"); 
                   
             String updatesl1 = "Update KhoThietBi set SoLuongTB = ? where Email = ? and id_tb = ?";
                PreparedStatement stthietbi1 = conn.prepareCall(updatesl1);
                 int id_tb2 = 0;
             String queryTB1 = "SELECT id_tb FROM KhoThietBi WHERE TenTB = ?";
                PreparedStatement stTB1 = conn.prepareStatement(queryTB1);
                stTB1.setString(1, chonThietBi);
                ResultSet rstb = stTB1.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rstb.next()) {
                    id_tb2 = rstb.getInt("id_tb");
                    }
              int soluonglayra = soluongtrongkho - soluongbi;
              stthietbi1.setInt(1, soluonglayra);
              stthietbi1.setString(2, tt.getEmail());
              stthietbi1.setInt(3, id_tb2);
              stthietbi1.executeUpdate();
                 } 
              }
              
             }
             conn.close();
             LoadDataKhoThietBi();
              LoadDataTableKhoTB();
              txtSoLuongTrongKho.setText(null);
            }
         }
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Cập nhật thiết bị thất bại");
        }
      }
        LoadDataThietBi();
        try {
            LoadDataTableThietBi();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateThietBiActionPerformed

    private void jTableTBMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTBMouseDragged
       
    }//GEN-LAST:event_jTableTBMouseDragged

    //Check tên phòng
    public boolean checkTrungPhongTrongBang(String tenphong){
        int selectedRow = jTable1.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTable1.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
            String valueTenPhong = jTable1.getValueAt(row, jTable1.getColumn("Tên phòng").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Phòng"
             
        for(int i = 0;i<listPhong.size();i++){
            if(tenphong.equalsIgnoreCase(valueTenPhong))
                return true;
        }
    }
    return false;
 }
    //Check ten thiet bi va ten phong
    public boolean checkTrungPhongVaThietBi(String tenphong,String tenTB){
        int selectedRow = jTableTB.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTableTB.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
            String valueTenPhong = jTableTB.getValueAt(row, jTableTB.getColumn("Tên phòng").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Phòng"
              String valueTenThietBi = jTableTB.getValueAt(row,jTableTB.getColumn("Tên thiết bị").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Thiết Bị"
        for(int i = 0;i<listTB.size();i++){
            if(tenphong.equalsIgnoreCase(valueTenPhong) && tenTB.equals(valueTenThietBi))
                return true;
        }
    }
    return false;
 }
    
    //Check trùng Mã GV trong bảng
 public boolean checkTrungMaGV(String MaGV){
        int selectedRow = jTableGV.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTableGV.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
             String valueMaGV = jTableGV.getValueAt(row,jTableGV.getColumn("Mã giảng viên").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Thiết Bị"
        for(int i = 0;i<listGV.size();i++){
            if( MaGV.equals(valueMaGV))
                return true;
        }
    }
    return false;
 }
    private void jTableTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTBMouseClicked
         current = jTableTB.getSelectedRow();
        if(current != -1){
        DisplayThietBi(current);
        }
    }//GEN-LAST:event_jTableTBMouseClicked

    private void TimPhongThemThietBi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimPhongThemThietBi4ActionPerformed
        jComboBoxThietBi.setSelectedItem(null);
        txtSoLuong.setText(null);
        JLabelTenPhong.setText(null);
         jTableTB.clearSelection();
         jComboBoxPhong.setSelectedItem(null);
         txtSoLuongTrongKho.setText(null);
    }//GEN-LAST:event_TimPhongThemThietBi4ActionPerformed

    private void XoaThietBiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaThietBiActionPerformed
         ToanCuc tt = new ToanCuc();
        String chonThietBi = (String) jComboBoxThietBi.getSelectedItem();
        String selectedText = (String) jComboBoxPhong.getSelectedItem();
        if(selectedText == null || JLabelTenPhong.getText().isEmpty() || chonThietBi == null || txtSoLuong.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Bạn phải điền đầy đủ thông tin");
        }
        else{
             try{
                 int soluongtrongkho = Integer.parseInt(txtSoLuongTrongKho.getText());
                  int selectedRow = jTableTB.getSelectedRow(); // Lấy chỉ số của dòng được chọn
                int selectectSoluong = Integer.parseInt(jTableTB.getValueAt(selectedRow,jTableTB.getColumn("Số lượng").getModelIndex()).toString());
            Connection conn = cn.getConnection();
             // Kiểm tra sự tồn tại của thiết bị trong phòng
        
        ThietBi tb = new ThietBi();
            String update = "Delete from ThietBi where id_tb = ? and id_phong = ? and Email = ?";
             PreparedStatement st = conn.prepareCall(update);
             int id_phong = 0;
             String queryPhongHoc = "SELECT id_phong FROM PhongHoc WHERE tenPhong = ?";
                PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                stPhongHoc.setString(1, selectedText);
                ResultSet rs = stPhongHoc.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rs.next()) {
                    id_phong = rs.getInt("id_phong");
                    }
              
              int id_tb2 = 0;
             String querytb = "SELECT id_tb FROM KhoThietBi WHERE TenTB = ?";
                PreparedStatement sttb1 = conn.prepareStatement(querytb);
                sttb1.setString(1, chonThietBi);
                ResultSet rstb1 = sttb1.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rstb1.next()) {
                    id_tb2 = rstb1.getInt("id_tb");
                    }
              st.setInt(1,id_tb2);
             st.setInt(2,id_phong);
             st.setString(3,tt.getEmail());
             st.executeUpdate();
            jComboBoxThietBi.setSelectedItem(null);
            jComboBoxPhong.setSelectedItem(null);
             txtSoLuong.setText(null);
            JLabelTenPhong.setText(null);
            txtSoLuongTrongKho.setText(null);
             JOptionPane.showMessageDialog(this, "Xóa thiết bị từ phòng "+selectedText+ " thành công"); 

             String updatesl1 = "Update KhoThietBi set SoLuongTB = ? where Email = ? and id_tb = ?";
                PreparedStatement stthietbi1 = conn.prepareCall(updatesl1);
                 int id_tb1 = 0;
             String queryTB1 = "SELECT id_tb FROM KhoThietBi WHERE TenTB = ?";
                PreparedStatement stTB1 = conn.prepareStatement(queryTB1);
                stTB1.setString(1, chonThietBi);
                ResultSet rstb = stTB1.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rstb.next()) {
                    id_tb1 = rstb.getInt("id_tb");
                    }
              int soluonglayra = soluongtrongkho + selectectSoluong;
              stthietbi1.setInt(1, soluonglayra);
              stthietbi1.setString(2, tt.getEmail());
              stthietbi1.setInt(3, id_tb1);
              stthietbi1.executeUpdate();
              LoadDataKhoThietBi();
              LoadDataTableKhoTB();
              txtSoLuongTrongKho.setText(null);
             conn.close();
             
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Xóa thiết bị thất bại");
        }
      }
        LoadDataThietBi();
        try {
            LoadDataTableThietBi();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_XoaThietBiActionPerformed

   
    private void ThemGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemGVActionPerformed
        ToanCuc tt = new ToanCuc();
        String selectedGT = (String) jComboBoxGT.getSelectedItem();
       if(txtMaGV.getText().isEmpty() || txtTenGV.getText().isEmpty() || txtSDT.getText().isEmpty() || NgaySinh == null || hinhgv.getIcon() == null)
       { 
           JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
       }
       else{
           try{
            Connection conn = cn.getConnection(); 
            // Lấy 2 ký tự đầu
                String haiKyTuDau = txtMaGV.getText().substring(0, 2);
                if(checkTrungGV(txtMaGV.getText())){
                    JOptionPane.showMessageDialog(this, "Mã giáo viên đã tồn tại");
                }
                else{
                     // Lấy 2 ký tự cuối
                String haiKyTuCuoi = txtMaGV.getText().substring(txtMaGV.getText().length() - 2);
             if(txtMaGV.getText().length() > 4 || txtMaGV.getText().length() < 4 || !haiKyTuDau.equals("GV") || isNumber(haiKyTuCuoi)==false){
                 JOptionPane.showMessageDialog(this, "Mã giảng viên không được quá 4 ký tự , 2 ký tự đầu phải là GV và 2 ký tự sau phải là số");
            }
            else{
                 
                 if(checkSDT1(txtSDT.getText())){
                     JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                 }
                 else{
                     String insert = "INSERT INTO GiangVien(MaGV, tenGiangVien,GioiTinh,SoDT,NgaySinh,AnhGV,Email) VALUES (?,?,?,?,?,?,?)";
             PreparedStatement st = conn.prepareCall(insert);
             // Lấy giá trị ngày từ JDateChooser
            Date selectedDate = NgaySinh.getDate();
             st.setString(1,txtMaGV.getText());
             st.setString(2,txtTenGV.getText() );
             st.setString(3, selectedGT);
             st.setString(4,txtSDT.getText());
             st.setDate(5, new java.sql.Date(selectedDate.getTime()));
             InputStream is = new FileInputStream(new File(duongdananh));
             st.setBlob(6, is);
             st.setString(7,tt.getEmail());
              st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm giáo viên thành công"); 
                txtMaGV.setText(null);
                txtTenGV.setText(null);
                NgaySinh.setDate(null);
             txtSDT.setText(null);
             hinhgv.setIcon(null);
            txtMaGV.setEnabled(true);
             conn.close();
             LayDuMaGVLen();
            LoadJComboCHonGV();
            LayDuMaGVLenHome();
         LoadJComboCHonGVHome();
            }
          }
              
         }
           
      }       
        
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Giáo viên đã tồn tại");
        }       
       }
       
        LoadDataGV();
        try {
            LoadDataTableGV();
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBoxGiangVien.setSelectedItem(null);
         jComboBoxMaGV.setSelectedItem(null);
    }//GEN-LAST:event_ThemGVActionPerformed

    private void txtMaGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaGVActionPerformed

    private void jTableGVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGVMouseClicked
        current = jTableGV.getSelectedRow();
        if(current != -1){
            try {
                DisplayGV(current);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTableGVMouseClicked

    private void UpdateGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateGVActionPerformed
         ToanCuc tt = new ToanCuc();
        
        String selectedGT = (String) jComboBoxGT.getSelectedItem();
       if(txtMaGV.getText().isEmpty() || txtTenGV.getText().isEmpty() || txtSDT.getText().isEmpty() || NgaySinh == null || hinhgv.getIcon() == null)
       { 
           JOptionPane.showMessageDialog(this, "Bạn chưa điền đủ thông tin");
       }
       else{
             try{
            Connection conn = cn.getConnection(); 
            // Lấy 2 ký tự đầu
                String haiKyTuDau = txtMaGV.getText().substring(0, 2);

               if(checkTrungMaGV(txtMaGV.getText())){
                   JOptionPane.showMessageDialog(this, "Mã giảng viên đã tồn tại không thể cập nhật");
               }
               else{
                   // Lấy 2 ký tự cuối
                String haiKyTuCuoi = txtMaGV.getText().substring(txtMaGV.getText().length() - 2);
             if(txtMaGV.getText().length() > 4 || txtMaGV.getText().length() < 4 || !haiKyTuDau.equals("GV") || isNumber(haiKyTuCuoi)==false){
                 JOptionPane.showMessageDialog(this, "Mã giảng viên không được quá 4 ký tự , 2 ký tự đầu phải là GV và 2 ký tự sau phải là số");
            }
            else{
                 if(checkSDT(txtSDT.getText())){
                     JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại");
                 }
                 else{
                      String update = "Update GiangVien set tenGiangVien = ? ,GioiTinh = ? ,NgaySinh = ?, SoDT = ?, AnhGV =? where MaGV = ? and Email = ?";
             PreparedStatement st = conn.prepareCall(update);
             // Lấy giá trị ngày từ JDateChooser
            Date selectedDate = NgaySinh.getDate();
             st.setString(1,txtTenGV.getText() );
             st.setString(2, selectedGT);
             st.setDate(3, new java.sql.Date(selectedDate.getTime()));
             st.setString(4,txtSDT.getText());
             InputStream is = new FileInputStream(new File(duongdananh));
             st.setBlob(5,is);
             st.setString(6,txtMaGV.getText());
             st.setString(7,tt.getEmail());
              st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cập nhật giáo viên có mã "+ txtMaGV.getText() +" thành công"); 
                
                
                txtMaGV.setText(null);
                txtTenGV.setText(null);
                NgaySinh.setDate(null);
             txtSDT.setText(null);
               hinhgv.setIcon(null);
               txtMaGV.setEnabled(true);
               
                String updateAnh = "Update MonHoc set AnhGV =? where id_gv = ? and Email = ?";
             PreparedStatement stAnh = conn.prepareCall(updateAnh);
             int id_gv = 0;
             String queryGV = "SELECT id_gv FROM GiangVien WHERE MaGV = ?";
                PreparedStatement stGV = conn.prepareStatement(queryGV);
                stGV .setString(1, txtMaGV.getText());
                ResultSet rs = stGV.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rs.next()) {
                    id_gv = rs.getInt("id_gv");
                    }
             InputStream isAnh = new FileInputStream(new File(duongdananh));
             stAnh.setBlob(1,isAnh);
             stAnh.setInt(2,id_gv);
             stAnh.setString(3,tt.getEmail());
             stAnh.executeUpdate();
             conn.close();
             LayDuMaGVLen();
            LoadJComboCHonGV();
             LayDuMaGVLenHome();
            LoadJComboCHonGVHome();
            LoadDataMonHoc();
            LoadDataTableMH();
            }
         }
         }
    }
        catch (HeadlessException | FileNotFoundException | SQLException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Cập nhật giáo viên thất bại");
        }    catch (IOException ex) {      
                 Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
             }      
       }
        LoadDataGV();
        try {
            LoadDataTableGV();
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        jComboBoxGiangVien.setSelectedItem(null);
    }//GEN-LAST:event_UpdateGVActionPerformed
        public boolean checkSDT1(String sdt){
          for(int i = 0;i<listGV.size();i++){
               if(listGV.get(i).getSodt().equalsIgnoreCase(sdt))
               return true;
           }
           return false;
       }
    
    public boolean checkSDT(String sdt){
        int selectedRow = jTableGV.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTableGV.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
            String valueSDT = jTableGV.getValueAt(row, jTableGV.getColumn("Số điện thoại").getModelIndex()).toString(); // Lấy giá trị từ cột "Số điện thoại"
        for(int i = 0;i<listGV.size();i++){
            if(sdt.equalsIgnoreCase(valueSDT))
                return true;
        }
    }
    return false;
    }
    private void ReGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReGVActionPerformed
                txtMaGV.setText(null);
                txtTenGV.setText(null);
                NgaySinh.setDate(null);
                jTableGV.clearSelection();
                txtSDT.setText(null);
               hinhgv.setIcon(null);
                txtMaGV.setEditable(true);
    }//GEN-LAST:event_ReGVActionPerformed

    private void ThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemMonActionPerformed
        ToanCuc tt = new ToanCuc();
        
        String selectedText = (String) jComboBoxGiangVien.getSelectedItem();
        int selectTinChi = Integer.parseInt(jComboBoxTinChi.getSelectedItem().toString());
        if(txtTenMonHoc.getText().isEmpty() || jComboBoxGiangVien == null){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
        }
        else{
           try{
            Connection conn = cn.getConnection();
            boolean hasDuplicate = false; // Biến để kiểm tra xem có dòng nào giống dữ liệu nhập không
    
            // Duyệt qua từng dòng trong JTable
            for (int row = 0; row < jTableMonHoc.getRowCount(); row++) {
                String tenMon = jTableMonHoc.getValueAt(row, 1).toString(); 
                String MaGV = jTableMonHoc.getValueAt(row, 4).toString(); 

                // Kiểm tra nếu dữ liệu của dòng giống với dữ liệu nhập
                if (tenMon.equals(txtTenMonHoc.getText()) && MaGV.equals(selectedText)) {
                    hasDuplicate = true;
                    break; // Thoát khỏi vòng lặp nếu tìm thấy dòng giống
                }
            }  
            if(hasDuplicate){
                 JOptionPane.showMessageDialog(this, "Giáo viên đang dạy môn này");
            }
            else{
               String insert = "INSERT INTO MonHoc(tenMonHoc, SoTinChi,id_gv,Email) VALUES (?,?,?,?)";
             PreparedStatement st = conn.prepareCall(insert);
             int id_gv = 0;
             String queryPhongHoc = "SELECT id_gv FROM GiangVien WHERE MaGV = ?";
                PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                stPhongHoc.setString(1, selectedText);
                ResultSet rs = stPhongHoc.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rs.next()) {
                    id_gv = rs.getInt("id_gv");
                    }
             st.setInt(2, selectTinChi);
             st.setString(1, txtTenMonHoc.getText());
             st.setInt(3, id_gv);
             st.setString(4, tt.getEmail());
              st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm môn học cho giáo viên có mã "+selectedText+ " thành công"); 
                 txtTenMonHoc.setText(null);
                jComboBoxGiangVien.setSelectedItem(null);
                jTableMonHoc.clearSelection();
                TenGV_txt_Mon.setText(null);
                hinhgvMH.setIcon(null);
             conn.close();
             LayDuMaGVLen();
         LoadJComboCHonPhong(); 
         
         LayDuTenMonLenHome();
         LoadJComboCHonMonHocHome();
            } 
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Thêm môn học thất bại");
        } 
        }
             
        LoadDataMonHoc();
        try {
            LoadDataTableMH();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ThemMonActionPerformed

    public void loadTenGV(String email){
        jComboBoxGiangVien.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedMaGV = (String) jComboBoxGiangVien.getSelectedItem();
                try {
                    Connection conn = cn.getConnection();
                    String query = "SELECT tenGiangVien FROM GiangVien WHERE MaGV = ? AND Email = ?";
                    PreparedStatement st = conn.prepareStatement(query);
                    st.setString(1, selectedMaGV);
                    st.setString(2, email);
                    ResultSet resultSet = st.executeQuery();
                    if (resultSet.next()) {
                        String tenGiangVien = resultSet.getString("tenGiangVien");
                        TenGV_txt_Mon.setText(tenGiangVien);
                    } else {
                        TenGV_txt_Mon.setText("");
                    }
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
    TenGV_txt_Mon.setEnabled(false);
    TenGV_txt_Mon.setDisabledTextColor(Color.DARK_GRAY);
    }
    private void SuaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaMonActionPerformed
        ToanCuc tt = new ToanCuc();
        
        String selectedText = (String) jComboBoxGiangVien.getSelectedItem();
        int selectTinChi = Integer.parseInt(jComboBoxTinChi.getSelectedItem().toString());
        if(txtTenMonHoc.getText().isEmpty() || jComboBoxGiangVien == null || jComboBoxTinChi == null ){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đủ thông tin");
        }
        else{
        if(checkTrungMonHoc(txtTenMonHoc.getText(),selectedText)){
            JOptionPane.showMessageDialog(this, "Giáo viên đang dạy môn này không thể cập nhật");
        }
        else{
            try{
            Connection conn = cn.getConnection();
            boolean hasDuplicate = false; // Biến để kiểm tra xem có dòng nào giống dữ liệu nhập không
    
            // Duyệt qua từng dòng trong JTable
            for (int row = 0; row < jTableTB.getRowCount(); row++) {
                String tenMon = jTableTB.getValueAt(row, 0).toString(); 
                String MaGV = jTableTB.getValueAt(row, 3).toString(); 

                // Kiểm tra nếu dữ liệu của dòng giống với dữ liệu nhập
                if (tenMon.equals(txtTenMonHoc.getText()) && MaGV.equals(selectedText)) {
                    hasDuplicate = true;
                    break; // Thoát khỏi vòng lặp nếu tìm thấy dòng giống
                }
            }  
            if(hasDuplicate){
                 JOptionPane.showMessageDialog(this, "Giáo viên đang dạy môn này");
            }
            else{
                int selectedRow = jTableMonHoc.getSelectedRow(); // Lấy chỉ số của dòng được chọn
                String tenMonHoc = jTableMonHoc.getValueAt(selectedRow,jTableMonHoc.getColumn("Tên môn học").getModelIndex()).toString(); // Lấy giá trị ID từ cột đầu tiên của dòng được chọn
               String insert = "Update MonHoc set tenMonHoc = ?, SoTinChi  = ? where Email = ? and id_gv = ? and tenMonHoc = ? ";
             PreparedStatement st = conn.prepareCall(insert);
             int id_gv = 0;
             String queryPhongHoc = "SELECT id_gv FROM GiangVien WHERE MaGV = ?";
                PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                stPhongHoc.setString(1, selectedText);
                ResultSet rs = stPhongHoc.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
              if (rs.next()) {
                    id_gv = rs.getInt("id_gv");
                    }
             st.setString(1, txtTenMonHoc.getText());
             st.setInt(2, selectTinChi);
             st.setString(3, tt.getEmail());
             st.setInt(4, id_gv);
             st.setString(5, tenMonHoc);
              st.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cập nhật môn học cho giáo viên có mã "+selectedText+ " thành công"); 
                txtTenMonHoc.setText(null);
                jComboBoxGiangVien.setSelectedItem(null);
                jTableMonHoc.clearSelection();
                TenGV_txt_Mon.setText(null);
                hinhgvMH.setIcon(null);
             conn.close();
             LayDuMaGVLen();
         LoadJComboCHonPhong(); 
         LayDuTenMonLenHome();
         LoadJComboCHonMonHocHome();
            } 
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Cập nhật môn học thất bại");
        }
       }
    }
             
        LoadDataMonHoc();
        try {
            LoadDataTableMH();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SuaMonActionPerformed

    private void XoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaMonActionPerformed
        
            // Lấy giá trị từ cột "Name" của dòng được chọn
               ToanCuc tt = new ToanCuc();
        
        String selectedText = (String) jComboBoxGiangVien.getSelectedItem();
        int selectTinChi = Integer.parseInt(jComboBoxTinChi.getSelectedItem().toString());
             try{
            Connection conn = cn.getConnection();
            boolean hasDuplicate = false; // Biến để kiểm tra xem có dòng nào giống dữ liệu nhập không
    
            // Duyệt qua từng dòng trong JTable
            for (int row = 0; row < jTableTB.getRowCount(); row++) {
                String tenMon = jTableTB.getValueAt(row, 0).toString(); 
                String MaGV = jTableTB.getValueAt(row, 3).toString(); 

                // Kiểm tra nếu dữ liệu của dòng giống với dữ liệu nhập
                if (tenMon.equals(txtTenMonHoc.getText()) && MaGV.equals(selectedText)) {
                    hasDuplicate = true;
                    break; // Thoát khỏi vòng lặp nếu tìm thấy dòng giống
                }
            }  
            if(hasDuplicate){
                 JOptionPane.showMessageDialog(this, "Giáo viên đang dạy môn này");
            }
            else{
                int selectedRow = jTableMonHoc.getSelectedRow(); // Lấy chỉ số của dòng được chọn
                String selectedValue = (String) jTableMonHoc.getValueAt(selectedRow,0);
                String selectMaGV = (String) jTableMonHoc.getValueAt(selectedRow,3);
                int selectectTinChi = Integer.parseInt(jTableMonHoc.getValueAt(selectedRow,jTableMonHoc.getColumn("Số tín chỉ").getModelIndex()).toString());
              if(!selectedValue.equals(txtTenMonHoc.getText()) ){
                  JOptionPane.showMessageDialog(this, "Tên môn học không trùng");
              }
              else{
                  if(!selectMaGV.equals(selectedText)){
                     JOptionPane.showMessageDialog(this, "Mã giáo viên không trùng"); 
                  }
                  else{
                      if(selectectTinChi != selectTinChi ){
                          JOptionPane.showMessageDialog(this, "Số tín chỉ không trùng"); 
                      }
                      else{
                          String tenMH = txtTenMonHoc.getText();
                        int id_gv = 0;
                        String insert = "Delete from MonHoc where Email = ? and tenMonHoc = ? and id_gv = ?";
                        PreparedStatement st = conn.prepareCall(insert);
                        String queryMonHoc = "SELECT id_gv FROM GiangVien WHERE MaGV = ?";
                           PreparedStatement stMonHoc = conn.prepareStatement(queryMonHoc);
                           stMonHoc.setString(1, selectedText);
                           ResultSet rs = stMonHoc.executeQuery();
                           // Nếu tìm thấy kết quả, lấy giá trị id_phong
                         if (rs.next()) {
                                id_gv =rs.getInt("id_gv");
                           }
                        st.setString(1, tt.getEmail());
                        st.setString(2, tenMH);
                        st.setInt(3, id_gv);
                        
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Xóa môn học cho giáo viên có mã "+selectedText+ " thành công"); 
                        txtTenMonHoc.setText(null);
                        jComboBoxGiangVien.setSelectedItem(null);
                        jComboBoxTinChi.setSelectedItem(null);
                        jTableMonHoc.clearSelection();
                        TenGV_txt_Mon.setText(null);

                       hinhgvMH.setIcon(null);
                  conn.close();
                  LayDuMaGVLen();
                  LoadJComboCHonPhong(); 
                  
                  LayDuTenMonLenHome();
                  LoadJComboCHonMonHocHome();
            }    
           }
                      
           }
         }
                
      }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Xóa môn học thất bại");
        }
        LoadDataMonHoc();
        try {
            LoadDataTableMH();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_XoaMonActionPerformed

    private void ReMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReMonActionPerformed
        txtTenMonHoc.setText(null);
        jComboBoxGiangVien.setSelectedItem(null);
        jComboBoxTinChi.setSelectedItem(null);
        jTableMonHoc.clearSelection();
        TenGV_txt_Mon.setText(null);
        hinhgvMH.setIcon(null);
    }//GEN-LAST:event_ReMonActionPerformed

    private void jTableMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMonHocMouseClicked
          current = jTableMonHoc.getSelectedRow();
        if(current != -1){
              try {
                  DisplayMH(current);
              } catch (SQLException ex) {
                  Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
    }//GEN-LAST:event_jTableMonHocMouseClicked

    
    //Lấy du lieu dat phong
    public void LoadDataDatPhongHoc(){
        ToanCuc tt = new ToanCuc();
        try{
            Connection conn = cn.getConnection();
             String query = "SELECT ph.tenPhong,ph.LoaiPhong,ngayHoc,tietbd,tietkt,tenmonhoc,gv.MaGV,gv.tenGiangVien ,gv.AnhGV FROM LichHoc lh "
                     + " inner join GiangVien gv on lh.id_gv = gv.id_gv "
                     + " inner join PhongHoc ph on lh.id_phong = ph.id_phong "
                     + " inner join TaiKhoan tk on lh.Email = tk.Email"
                     + " WHERE lh.Email = ?";
             PreparedStatement statement = conn.prepareCall(query);
             statement.setString(1, tt.getEmail());
            ResultSet resultSet = statement.executeQuery();
            listLH.clear();
            while(resultSet.next()){
                String tenPhong = resultSet.getString(1);
                String loaiPhong = resultSet.getString(2);
                Date ngayhoc = resultSet.getDate(3);
                int tbd = resultSet.getInt(4);
                int tkt = resultSet.getInt(5);
                String tenmonhoc = resultSet.getString(6);
                String maGV = resultSet.getString(7);
                String teGV = resultSet.getString(8);
                Blob AnhGV = resultSet.getBlob(9);
                int startMinute = (tbd - 1) * 50;
                int endMinute = tkt * 50;
                int totalMinutes = endMinute - startMinute;
                int hours = totalMinutes / 60;
                int minutes = totalMinutes % 60;
                String thoigianhoc = hours + " giờ "+minutes+" phút";
                LichHoc lh = new LichHoc(maGV,teGV,tenPhong,loaiPhong,ngayhoc,tbd,tkt,thoigianhoc,tenmonhoc,AnhGV);
                listLH.add(lh);
            }
            conn.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    //Load du lieu vao bang Phong Hoc
    public void LoadDataTableDatPhongHoc(){
        DefaultTableModel model = (DefaultTableModel) jTableDatPhong.getModel();
        model.setRowCount(0);
        
        for(LichHoc lh : listLH){
            
            Date ngayhoc = lh.getNgayHoc();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            String ngayhocString = formatter.format(ngayhoc);
            model.addRow(new Object[] {lh.getTenPhong(),lh.getLoaiPhong(),ngayhocString,lh.getTietBD(),lh.getTietKT(),lh.getTenMonHoc(),lh.getMaGV(),lh.getTenGV()});
        }
    }
    
    //Check trùng GV
    public boolean checkTrungGVDP(String MaGV){
        for(int i = 0;i<listLH.size();i++){
            if(listLH.get(i).getMaGV().equalsIgnoreCase(MaGV))
                return true;
        }
        return false;
    }
    
    //Check trùng ngày dạy Nếu giá trị trả về là 0, điều đó có nghĩa là hai ngày bằng nhau.
     public boolean checkTrungNgayDayDP(Date ngayday){
        for(int i = 0;i<listLH.size();i++){
            if(listLH.get(i).getNgayHoc().equals(ngayday))
                return true;
        }
        return false;
    }
     
     //Check trùng giờ bắt đầu và kết thúc
     public boolean checkTrungTietDay(int tiet1 , int tiet2){
        for(int i = 0;i<listLH.size();i++){
            if(listLH.get(i).getTietBD() == tiet1 && listLH.get(i).getTietKT() == tiet2)
                return true;
        }
        return false;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            JFileChooser f = new JFileChooser();
            f.setDialogTitle("Mở file ảnh");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            if(ftenanh != null){
                String path = ftenanh.getAbsolutePath();
           try{
               BufferedImage bi = ImageIO.read(new File(path));
               BufferedImage sharp = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_ARGB);
               float[] sharpen = {0.0625f, 0.125f, 0.0625f,
                      0.125f, 0.25f, 0.125f,
                      0.0625f, 0.125f, 0.0625f};
               Kernel kernel = new Kernel(3, 3, sharpen);
                ConvolveOp op = new ConvolveOp(kernel);
            // Áp dụng mặt nạ sắc nét
                op.filter(bi, sharp); 
               Image img = sharp.getScaledInstance(173, 225,Image.SCALE_SMOOTH);
               ImageIcon icon  =new ImageIcon(img);
               hinhgv.setIcon(icon);
               JOptionPane.showMessageDialog(this, "Chọn ảnh thành công"); 
               duongdananh = path;
           } 
        catch(Exception ex){
            System.out.println("Chưa chọn ảnh");
            System.out.println(duongdananh);
        }
            }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void HomeAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_HomeAncestorAdded

    }//GEN-LAST:event_HomeAncestorAdded

    private void RePhongDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RePhongDayActionPerformed
                        jComboBoxTenPhong.setSelectedItem(null);
                        jTextFieldLoaiPhong.setText(null);
                        jComboBoxMaGV.setSelectedItem(null);
                        jTextFieldTenGV.setText(null);
                        jComboBoxMonHoc.setSelectedItem(null);
                        jComboBoxTietBD.setSelectedItem(null);
                        jComboBoxTietKT.setSelectedItem(null);
                        hinhgvHome.setIcon(null);
                        jTableDatPhong.clearSelection();
                        jTextField6.setText(null);
                        LoadJComboCHonMonHocHome();
    }//GEN-LAST:event_RePhongDayActionPerformed

    private void btnXoaPhongDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPhongDayActionPerformed
        ToanCuc tt = new ToanCuc();

        String selectedTenPhong = (String) jComboBoxTenPhong.getSelectedItem();
        String selectedMaGV = (String) jComboBoxMaGV.getSelectedItem();
        String selectedMonHoc = (String) jComboBoxMonHoc.getSelectedItem();
        String selectedTietBDsr =(String) jComboBoxTietBD.getSelectedItem();
        String selectedKTsr = (String) jComboBoxTietKT.getSelectedItem();
        java.util.Date day = jCalendarNgayDay.getDate();

       if(selectedTenPhong == null || selectedMaGV == null || selectedTietBDsr == null || selectedKTsr == null ){
           JOptionPane.showMessageDialog(this,"Bạn phải chọn đủ thông tin !");
       }
       else{
           int selectedTietBD =  Integer.parseInt(selectedTietBDsr);
        int selectedKT = Integer.parseInt(selectedKTsr);
        boolean isInvalidTime = ( selectedTietBD > selectedKT);
        try{
            Connection conn = cn.getConnection();
            boolean hasDuplicate = false; // Biến để kiểm tra xem có dòng nào giống dữ liệu nhập không
              int selectedRow = jTableDatPhong.getSelectedRow();
             String tenphong = jTableDatPhong.getValueAt(selectedRow,jTableDatPhong.getColumn("Tên phòng").getModelIndex()).toString();
            int tietbd = Integer.parseInt(jTableDatPhong.getValueAt(selectedRow,jTableDatPhong.getColumn("Tiết bắt đầu").getModelIndex()).toString());
             int tietkt = Integer.parseInt(jTableDatPhong.getValueAt(selectedRow,jTableDatPhong.getColumn("Tiết kết thúc").getModelIndex()).toString());
            if(isInvalidTime){
                JOptionPane.showMessageDialog(this,"Nhập số tiết không hợp lệ");
            }
            else{
                        String update = "Delete from LichHoc where id_phong = ? and Email = ? and tietbd = ? and tietkt = ?";
                        PreparedStatement st = conn.prepareCall(update);
                         int id_phong = 0;
                        String queryPhongHoc = "SELECT id_phong FROM PhongHoc WHERE tenPhong = ?";
                           PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                           stPhongHoc.setString(1, tenphong);
                           ResultSet rs = stPhongHoc.executeQuery();
                           // Nếu tìm thấy kết quả, lấy giá trị id_phong
                         if (rs.next()) {
                               id_phong = rs.getInt("id_phong");
                               }
                        st.setInt(1, id_phong);
                        st.setString(2, tt.getEmail());
                        st.setInt(3, tietbd);
                        st.setInt(4, tietkt);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                        String checkTBQuery = "SELECT COUNT(*) FROM LichHoc WHERE id_phong in (SELECT id_phong FROM PhongHoc WHERE tenPhong = ? and  Email = ?)";
            PreparedStatement checkLichHocStatement = conn.prepareStatement(checkTBQuery);
            checkLichHocStatement.setString(1,selectedTenPhong);
            checkLichHocStatement.setString(2, tt.getEmail());
            ResultSet checkTBResult = checkLichHocStatement.executeQuery();
             
            // Lấy số lượng bản ghi liên quan
            int ThietBiCount = 0;
            if (checkTBResult.next()) {
                ThietBiCount = checkTBResult.getInt(1);
            }
            if(ThietBiCount == 0){
                String updatett = "Update PhongHoc set TrangThai = ? where tenPhong =? and Email = ?";
                        PreparedStatement sttt = conn.prepareCall(updatett);
                        String trangthai = "Trống";
                        sttt.setString(1,trangthai);
                        sttt.setString(2,selectedTenPhong);
                        sttt.setString(3, tt.getEmail());
                        sttt.executeUpdate();
            }
            else{
               String updatett = "Update PhongHoc set TrangThai = ? where tenPhong =? and Email = ?";
                        PreparedStatement sttt = conn.prepareCall(updatett);
                        String trangthai = "Đang hoạt động";
                        sttt.setString(1,trangthai);
                        sttt.setString(2,selectedTenPhong);
                        sttt.setString(3, tt.getEmail());
                        sttt.executeUpdate();
            }
                        conn.close();
                         jComboBoxTenPhong.setSelectedItem(null);
                        jTextFieldLoaiPhong.setText(null);
                        jComboBoxMaGV.setSelectedItem(null);
                        jTextFieldTenGV.setText(null);
                        jComboBoxMonHoc.setSelectedItem(null);
                        jComboBoxTietBD.setSelectedItem(null);
                        jComboBoxTietKT.setSelectedItem(null);
                        hinhgvHome.setIcon(null);
                        jTextField6.setText(null);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Xóa phòng thất bại");
        }
       }
       
     LoadDataDatPhongHoc();
     LoadDataTableDatPhongHoc();
     LoadDataPhongHoc();
     LoadDataTablePhongHoc();
    }//GEN-LAST:event_btnXoaPhongDayActionPerformed

    private void btn_CapNhatPhongDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatPhongDayActionPerformed
         ToanCuc tt = new ToanCuc();

        String selectedTenPhong = (String) jComboBoxTenPhong.getSelectedItem();
        String selectedMaGV = (String) jComboBoxMaGV.getSelectedItem();
        String selectedMonHoc = (String) jComboBoxMonHoc.getSelectedItem();
        String selectedTietBDsr =  (String) jComboBoxTietBD.getSelectedItem();
        String selectedKTsr = (String) jComboBoxTietKT.getSelectedItem();
        java.util.Date day = jCalendarNgayDay.getDate();

        if(selectedTenPhong == null || selectedMaGV == null || selectedTietBDsr == null || selectedKTsr == null ){
           JOptionPane.showMessageDialog(this,"Bạn phải chọn đủ thông tin !");
       }
       else{
           int selectedTietBD =  Integer.parseInt(selectedTietBDsr);
        int selectedKT = Integer.parseInt(selectedKTsr);
        boolean isInvalidTime = ( selectedTietBD > selectedKT);
        
        try{
            Connection conn = cn.getConnection();
            boolean hasDuplicate = false; // Biến để kiểm tra xem có dòng nào giống dữ liệu nhập không
              int selectedRow = jTableDatPhong.getSelectedRow();
             String tenphong = jTableDatPhong.getValueAt(selectedRow,jTableDatPhong.getColumn("Tên phòng").getModelIndex()).toString();
            
            if(isInvalidTime){
                JOptionPane.showMessageDialog(this,"Nhập số tiết không hợp lệ");
            }
            else{
                 if(checkTrungPhongDat(selectedTenPhong,selectedTietBD,selectedKT)){
                 JOptionPane.showMessageDialog(this, "Phòng "+selectedTenPhong+" đã bị trùng lịch phân công không thể cập nhật!");
            }
                else{
                     if(checkTrungGVDat(selectedMaGV,selectedTietBD,selectedKT)){
                        JOptionPane.showMessageDialog(this, "Giảng viên bị trùng lịch không thể cập nhật!"); 
                     }
                     else{
                       int id_phong = 0;
                        String queryPhongHoc = "SELECT id_phong FROM PhongHoc WHERE tenPhong = ?";
                           PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                           stPhongHoc.setString(1, tenphong);
                           ResultSet rs = stPhongHoc.executeQuery();
                           // Nếu tìm thấy kết quả, lấy giá trị id_phong
                         if (rs.next()) {
                               id_phong = rs.getInt("id_phong");
                               }
                         //Lấy id của bảng lịch học
                         int id = 0;
                         String queryLH = "SELECT id FROM LichHoc WHERE id_phong = ?";
                           PreparedStatement stlh = conn.prepareStatement(queryLH);
                           stlh.setInt(1, id_phong);
                           ResultSet rslh = stlh.executeQuery();
                           // Nếu tìm thấy kết quả, lấy giá trị id_phong
                         if (rslh.next()) {
                               id = rslh.getInt("id");
                               }
                        String update = "Update LichHoc set id_gv = ? ,tietbd = ? ,tietkt = ? where id = ? and Email = ?";
                        PreparedStatement st = conn.prepareCall(update);
                        
                         int id_gv = 0;
                        String queryGV = "SELECT id_gv FROM GiangVien WHERE MaGV = ?";
                           PreparedStatement stGV = conn.prepareStatement(queryGV);
                           stGV.setString(1, selectedMaGV);
                           ResultSet rsgv = stGV.executeQuery();
                           // Nếu tìm thấy kết quả, lấy giá trị id_phong
                         if (rsgv.next()) {
                               id_gv = rsgv.getInt("id_gv");
                               }
                         
                        st.setInt(1,id_gv);
                        st.setInt(2, selectedTietBD);
                        st.setInt(3, selectedKT);
                        st.setInt(4, id);
                        st.setString(5, tt.getEmail());
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Cập nhật phòng thành công");
                        conn.close();
                         jComboBoxTenPhong.setSelectedItem(null);
                        jTextFieldLoaiPhong.setText(null);
                        jComboBoxMaGV.setSelectedItem(null);
                        jTextFieldTenGV.setText(null);
                        jComboBoxMonHoc.setSelectedItem(null);
                        jComboBoxTietBD.setSelectedItem(null);
                        jComboBoxTietKT.setSelectedItem(null);
                        hinhgvHome.setIcon(null);
                        jTextField6.setText(null);
                        LoadDataDatPhongHoc();
                        LoadDataTableDatPhongHoc();  
                     }
                      
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Cập nhật phòng được phân công thất bại");
        }
       }
    }//GEN-LAST:event_btn_CapNhatPhongDayActionPerformed

    //Check trùng Môn trong bảng
    public boolean checkTrungMonHoc(String tenmonhoc,String MaGV){
        int selectedRow = jTableMonHoc.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTableMonHoc.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
            String valueTenMH = jTableMonHoc.getValueAt(row, jTableMonHoc.getColumn("Tên môn học").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Phòng"
             String valueMaGV = jTableMonHoc.getValueAt(row, jTableMonHoc.getColumn("Mã GV").getModelIndex()).toString();
        for(int i = 0;i<listMH.size();i++){
            if(tenmonhoc.equalsIgnoreCase(valueTenMH) && valueMaGV.equalsIgnoreCase(valueMaGV))
                return true;
        }
    }
    return false;
 }
    //CHeck trùng phòng để update
    public boolean checkTrungPhongDat(String tenphong,int tiet1,int tiet2){
        int selectedRow = jTableDatPhong.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTableDatPhong.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
            String valueTenPhong = jTableDatPhong.getValueAt(row, jTableDatPhong.getColumn("Tên phòng").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Phòng"
            int valuetietBD = Integer.parseInt(jTableDatPhong.getValueAt(row, jTableDatPhong.getColumn("Tiết bắt đầu").getModelIndex()).toString());
            int valuetietKT = Integer.parseInt(jTableDatPhong.getValueAt(row, jTableDatPhong.getColumn("Tiết kết thúc").getModelIndex()).toString());
        for(int i = 0;i<listLH.size();i++){
            if(tenphong.equalsIgnoreCase(valueTenPhong) && (tiet1 >= valuetietBD && tiet1 < valuetietKT ||
            tiet2 > valuetietBD && tiet2 <= valuetietKT) || (tiet1 == valuetietKT|| tiet2 == valuetietBD))
                return true;
        }
    }
    return false;
 }
    
     //CHeck trùng GV để update
    public boolean checkTrungGVPC(String MaGV,int tiet1,int tiet2){
         int selectedRow = jTableDatPhong.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTableDatPhong.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
            String valueMaGV = jTableDatPhong.getValueAt(row, jTableDatPhong.getColumn("Mã GV").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Phòng"
            int valuetietBD = Integer.parseInt(jTableDatPhong.getValueAt(row, jTableDatPhong.getColumn("Tiết bắt đầu").getModelIndex()).toString());
            int valuetietKT = Integer.parseInt(jTableDatPhong.getValueAt(row, jTableDatPhong.getColumn("Tiết kết thúc").getModelIndex()).toString());
        for(int i = 0;i<listLH.size();i++){
            if(MaGV.equalsIgnoreCase(valueMaGV) && (tiet1 >= valuetietBD && tiet1 < valuetietKT ||
            tiet2 > valuetietBD && tiet2 <= valuetietKT) || (tiet1 == valuetietKT|| tiet2 == valuetietBD))
                return true;
        }
    }
    return false;
    }
    
 
    //CHeck trùng GV để update
    public boolean checkTrungGVDat(String MaGV,int tiet1,int tiet2){
        int selectedRow = jTableDatPhong.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTableDatPhong.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
            int valuetietBD = Integer.parseInt(jTableDatPhong.getValueAt(row, jTableDatPhong.getColumn("Tiết bắt đầu").getModelIndex()).toString());
            int valuetietKT = Integer.parseInt(jTableDatPhong.getValueAt(row, jTableDatPhong.getColumn("Tiết kết thúc").getModelIndex()).toString());
        String valueMaGV = jTableDatPhong.getValueAt(row,jTableDatPhong.getColumn("Mã GV").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Thiết Bị"
        for(int i = 0;i<listLH.size();i++){
            if(MaGV.equals(valueMaGV)&& (tiet1 >= valuetietBD && tiet1 < valuetietKT ||
            tiet2 > valuetietBD && tiet2 <= valuetietKT) || (tiet1 == valuetietKT|| tiet2 == valuetietBD))
                return true;
        }
    }
    return false;
 }
    private void btnDatPhongDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatPhongDayActionPerformed
        ToanCuc tt = new ToanCuc();

        
        String selectedTenPhong = (String) jComboBoxTenPhong.getSelectedItem();
        String selectedMaGV = (String) jComboBoxMaGV.getSelectedItem();
        String selectedMonHoc = (String) jComboBoxMonHoc.getSelectedItem();
        String selectedTietBDsr = (String) jComboBoxTietBD.getSelectedItem();
        String selectedKTsr = (String) jComboBoxTietKT.getSelectedItem();
        java.util.Date day = jCalendarNgayDay.getDate();
           int selectedTietBD =  Integer.parseInt(selectedTietBDsr);
        int selectedKT = Integer.parseInt(selectedKTsr);
        boolean isTrungPhongDP = checkTrungPhongDP(selectedTenPhong,selectedTietBD,selectedKT);

       if(selectedTenPhong == null || selectedMaGV == null || selectedTietBDsr == null || selectedKTsr == null || selectedMonHoc == null ){
           JOptionPane.showMessageDialog(this,"Bạn phải chọn đủ thông tin !");
       }
       else{
        boolean isInvalidTime = ( selectedTietBD > selectedKT);
         try{
            Connection conn = cn.getConnection();
            if(isInvalidTime){
                JOptionPane.showMessageDialog(this,"Nhập số tiết không hợp lệ");
            }
            else{
                if(checkTrungPhongDP(selectedTenPhong,selectedTietBD,selectedKT)){
                    JOptionPane.showMessageDialog(this, "Phòng "+ selectedTenPhong+" đã được phân công");
                }
                else{
                    if(checkTrungGVPC(selectedMaGV,selectedTietBD,selectedKT)){
                        JOptionPane.showMessageDialog(this, "Giáo viên bị trùng lịch không thể thêm");
                    }
                    else{
                        String insert = "INSERT INTO LichHoc(id_phong, ngayHoc,tietbd,tietkt,tenmonhoc,id_gv,Email) VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement st = conn.prepareCall(insert);
                        int id_phong = 0;
                        String queryPhongHoc = "SELECT id_phong FROM PhongHoc WHERE tenPhong = ?";
                           PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                           stPhongHoc.setString(1, selectedTenPhong);
                           ResultSet rs = stPhongHoc.executeQuery();
                           // Nếu tìm thấy kết quả, lấy giá trị id_phong
                         if (rs.next()) {
                               id_phong = rs.getInt("id_phong");
                               }
                         
                         int id_gv = 0;
                        String queryGV = "SELECT id_gv FROM GiangVien WHERE MaGV = ? and Email like ?";
                           PreparedStatement stGV = conn.prepareStatement(queryGV);
                           stGV.setString(1, selectedMaGV);
                           stGV.setString(2,tt.getEmail());
                           ResultSet rsgv = stGV.executeQuery();
                           // Nếu tìm thấy kết quả, lấy giá trị id_phong
                         if (rsgv.next()) {
                               id_gv = rsgv.getInt("id_gv");
                               }
                        st.setInt(1,id_phong );
                        st.setDate(2,new java.sql.Date(day.getTime()));
                        st.setInt(3, selectedTietBD);
                        st.setInt(4, selectedKT);
                        st.setString(5, selectedMonHoc);
                        st.setInt(6, id_gv);
                        st.setString(7, tt.getEmail());
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Phân công phòng học "+selectedTenPhong + " thành công");
                        String updatett = "Update PhongHoc set TrangThai = ? where tenPhong =? and Email = ?";
                        PreparedStatement sttt = conn.prepareCall(updatett);
                        String trangthai = "Đang hoạt động";
                        sttt.setString(1,trangthai);
                        sttt.setString(2,selectedTenPhong);
                        sttt.setString(3, tt.getEmail());
                        sttt.executeUpdate();

                        jComboBoxTenPhong.setSelectedItem(null);
                        jTextFieldLoaiPhong.setText(null);
                        jComboBoxMaGV.setSelectedItem(null);
                        jTextFieldTenGV.setText(null);
                        jComboBoxMonHoc.setSelectedItem(null);
                        jComboBoxTietBD.setSelectedItem(null);
                        jComboBoxTietKT.setSelectedItem(null);
                        hinhgvHome.setIcon(null);
                        
                        String updateslan = "Update PhongHoc set Solansudung = Solansudung + 1 where tenPhong = ? and Email = ?";
                        PreparedStatement stsl = conn.prepareCall(updateslan);
                        stsl.setString(1,selectedTenPhong);
                        stsl.setString(2, tt.getEmail());
                        stsl.executeUpdate();

                        conn.close();
                        LoadDataPhongHoc();
                        LoadDataTablePhongHoc();
                        
                    }
                        
                }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Đặt phòng học thất bại");
        }  
       }
         LoadDataDatPhongHoc();
         LoadDataTableDatPhongHoc();
         controller.setTenPhongToChart(jPanelThongKe);
         //Sự kiện hiển thị thống kê
           QuanLyThongKeController controller = new QuanLyThongKeController();
    }//GEN-LAST:event_btnDatPhongDayActionPerformed

    private void TimPhongHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimPhongHomeActionPerformed
        listLH.clear();
         ToanCuc tt = new ToanCuc();
         try{
             String selectedTenPhong = (String) jComboBox1.getSelectedItem();
             String selectedTietBDsr = (String) jComboBox2.getSelectedItem();
        String selectedKTsr = (String) jComboBox3.getSelectedItem();
        int selectedTietBD =  Integer.parseInt(selectedTietBDsr);
        int selectedKT = Integer.parseInt(selectedKTsr);
        if(selectedTietBD > selectedKT){
            JOptionPane.showMessageDialog(this, "Số tiết không hợp lệ");
        }
        else{
           Connection conn = cn.getConnection();
           String query = "SELECT ph.tenPhong,ph.LoaiPhong,ngayHoc,tietbd,tietkt,tenmonhoc,gv.MaGV,gv.tenGiangVien ,gv.AnhGV FROM LichHoc lh "
                     + " inner join GiangVien gv on lh.id_gv = gv.id_gv "
                     + " inner join PhongHoc ph on lh.id_phong = ph.id_phong "
                     + " inner join TaiKhoan tk on lh.Email = tk.Email"
                     + " WHERE ph.tenPhong like '%" + selectedTenPhong +"%' and lh.Email like '"+tt.getEmail()+"' and tietbd >= " + selectedTietBD +" and tietkt <= "+ selectedKT +"";
          PreparedStatement st = conn.prepareStatement(query);
          ResultSet rs = st.executeQuery();
          while(rs.next()){
              String tenPhong = rs.getString(1);
                String loaiPhong = rs.getString(2);
                Date ngayhoc = rs.getDate(3);
                int tbd = rs.getInt(4);
                int tkt = rs.getInt(5);
                String tenmonhoc = rs.getString(6);
                String maGV = rs.getString(7);
                String teGV = rs.getString(8);
                Blob AnhGV = rs.getBlob(9);
                 int startMinute = (tbd - 1) * 50;
                 int endMinute = tkt * 50;
                int totalMinutes = endMinute - startMinute;
                int hours = totalMinutes / 60;
                int minutes = totalMinutes % 60;
                String thoigianhoc = hours + " giờ "+minutes+" phút";
                LichHoc lh = new LichHoc(maGV,teGV,tenPhong,loaiPhong,ngayhoc,tbd,tkt,thoigianhoc,tenmonhoc,AnhGV);
                listLH.add(lh);
          }
          conn.close();
          LoadDataTableDatPhongHoc(); 
        }
          
         }
         catch (Exception ex){
             ex.printStackTrace();
         }
         jTextField6.setText(null);
    }//GEN-LAST:event_TimPhongHomeActionPerformed

    private void ReSearhHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReSearhHomeActionPerformed
        jComboBox1.setSelectedItem(null);
        jComboBox2.setSelectedItem(null);
        jComboBox3.setSelectedItem(null);
        jTextField6.setText(null);
         LoadDataDatPhongHoc();
        LoadDataTableDatPhongHoc();
    }//GEN-LAST:event_ReSearhHomeActionPerformed

    private void jTableDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatPhongMouseClicked
         current = jTableDatPhong.getSelectedRow();
        if(current != -1){
             try {
                 DisplayDatPhong(current) ;
             } catch (SQLException ex) {
                 Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
             }
        }      
    }//GEN-LAST:event_jTableDatPhongMouseClicked

    private void txtTenGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenGVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenGVActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất ?","Có",JOptionPane.YES_NO_OPTION);
        if(a==0){
            this.setVisible(false);
            this.dispose();
            ToanCuc tt = new ToanCuc();
            tt.setEmail(null);
            LoginForm lg = new LoginForm();
            lg.setVisible(true);
            
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         JFileChooser f = new JFileChooser();
            f.setDialogTitle("Mở file ảnh");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            if(ftenanh != null){
                String path = ftenanh.getAbsolutePath();
           try{
               BufferedImage bi = ImageIO.read(new File(path));
               BufferedImage sharp = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_ARGB);
               float[] sharpen = {0.0625f, 0.125f, 0.0625f,
                      0.125f, 0.25f, 0.125f,
                      0.0625f, 0.125f, 0.0625f};
               Kernel kernel = new Kernel(3, 3, sharpen);
                ConvolveOp op = new ConvolveOp(kernel);
            // Áp dụng mặt nạ sắc nét
                op.filter(bi, sharp); 
               Image img = sharp.getScaledInstance(222, 167,Image.SCALE_SMOOTH);
               ImageIcon icon  =new ImageIcon(img);
               hinhTB.setIcon(icon);
               JOptionPane.showMessageDialog(this, "Chọn ảnh thành công"); 
               anhTB = path;
           } 
        catch(Exception ex){
            System.out.println("Chưa chọn ảnh");
            System.out.println(duongdananh);
        }
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    public boolean checkTrungMaThietBi(String maTB){
        for(int i = 0;i<listKhoTB.size();i++){
            if(listKhoTB.get(i).getMaTB().equalsIgnoreCase(maTB))
                return true;
        }
        return false;
    }
    
    public boolean checkTrungTenThietBi(String tenTB){
        for(int i = 0;i<listKhoTB.size();i++){
            if(listKhoTB.get(i).getTenTB().equalsIgnoreCase(tenTB))
                return true;
        }
        return false;
    }
    
    public void LoadDataKhoThietBi(){
        ToanCuc tt = new ToanCuc();
        try{
            Connection conn = cn.getConnection();
             String query = "SELECT * FROM KhoThietBi WHERE Email = ?";
             PreparedStatement statement = conn.prepareCall(query);
             statement.setString(1, tt.getEmail());
            ResultSet resultSet = statement.executeQuery();
            listKhoTB.clear();
            while(resultSet.next()){
                int id = resultSet.getInt("id_tb");
                String maTB = resultSet.getString("MaTB");
                String tenTB = resultSet.getString("TenTB");
                String loaiTB = resultSet.getString("LoaiTB");
                int soluong = resultSet.getInt("SoLuongTB");
                String NSX = resultSet.getString("NhaSX");
                Date ngayNhap = resultSet.getDate("NgayNhap");
                Blob image = resultSet.getBlob("AnhTB");
                KhoTB khotb = new KhoTB(id,maTB,tenTB,loaiTB,soluong,NSX,ngayNhap,image);
                listKhoTB.add(khotb);
            }
            conn.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    //Load du lieu vao bang Phong Hoc
    public void LoadDataTableKhoTB() throws SQLException, IOException{
        DefaultTableModel model = (DefaultTableModel) jTableKhoTB.getModel();
        model.setRowCount(0);
        
        for(KhoTB tb : listKhoTB){
            Blob anhtbBlob = tb.getAnhtb();
  // Chuyển Blob sang byte array
                 byte[] anhtbBytes = anhtbBlob.getBytes(1, (int)anhtbBlob.length());
  // Tạo Image từ byte array
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(anhtbBytes));
                Image dimg = img.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);  
            
            //Chỉnh ngày sinh
            Date ngayNhap = tb.getNgaynhap();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            String ngayNhapString = formatter.format(ngayNhap);
            model.addRow(new Object[] {tb.getMaTB(),tb.getTenTB(),tb.getLoaiTB(),tb.getSoluong(),tb.getNhaSX(),ngayNhapString,icon});
        }
    }
    private void btn_ThemTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemTBActionPerformed
        ToanCuc tt = new ToanCuc();
        Date currentDate = new Date();
        String MaTB = txtMaTB.getText();
        String tenTB = txtNameTB.getText();
        String loaiTB = txtLoaiTB.getText();
        String textslTB = txtSLTB.getText();
        String NhaSX = txtNXS.getText();
        if(MaTB.equals("")|| tenTB.equals("") || loaiTB.equals("")|| loaiTB.equals("") || textslTB.equals("") || NhaSX.equals("") || hinhTB.getIcon() == null){
            JOptionPane.showMessageDialog(this,"Bạn phải nhập đủ thông tin");
        }
       else{
         try{
            Connection conn = cn.getConnection();
            if(checkTrungMaThietBi(MaTB)){
                JOptionPane.showMessageDialog(this,"Mã thiết bị đã tồn tại ");
            }
            else{
                    if( checkTrungTenThietBi(tenTB))
                    {
                        JOptionPane.showMessageDialog(this,"Tên thiết bị đã tồn tại");
                    }
                    else{
                        int slTB = Integer.parseInt(textslTB);
                        String insert = "INSERT INTO KhoThietBi(MaTB,TenTB,LoaiTB,SoLuongTB,NhaSX,NgayNhap,AnhTB,Email) VALUES (?,?,?,?,?,?,?,?)";
                        PreparedStatement st;
                        st = conn.prepareCall(insert);
                        st.setString(1,MaTB);
                        st.setString(2, tenTB);
                        st.setString(3, loaiTB);
                        st.setInt(4, slTB);
                        st.setString(5, NhaSX);
                        st.setDate(6, new java.sql.Date(currentDate.getTime()));
                        InputStream is = new FileInputStream(new File(anhTB));
                        st.setBlob(7, is);
                        st.setString(8,tt.getEmail());
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Thêm thiết bị vào kho thành công");
                        txtMaTB.setText(null);
                        txtNameTB.setText(null);
                        txtLoaiTB.setText(null);
                        txtSLTB.setText(null);
                        txtNXS.setText(null);
                        hinhTB.setIcon(null);
                        conn.close();
                        LayDuTenThietBiLen();
                        LoadJComboCHonThietBi();
                    }
            }
        }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Thêm thiết bị thất bại");
        }  
       }
         LoadDataKhoThietBi();
        try {
            LoadDataTableKhoTB();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBoxThietBi.setSelectedItem(null);
    }//GEN-LAST:event_btn_ThemTBActionPerformed

    public void DisplayKhoTB(int i) throws SQLException{
        KhoTB tb = listKhoTB.get(i);
        txtMaTB.setText(tb.getMaTB());
        txtNameTB.setText(tb.getTenTB());
        txtLoaiTB.setText(tb.getLoaiTB());
        txtSLTB.setText(String.valueOf(tb.getSoluong()));
        txtNXS.setText(tb.getNhaSX());
        Blob imagePath = tb.getAnhtb();
         ImageIcon imageIcon = new ImageIcon(imagePath.getBytes(1, (int) imagePath.length()));
        Image image = imageIcon.getImage().getScaledInstance(hinhTB.getWidth(), hinhTB.getHeight(), Image.SCALE_SMOOTH);
        hinhTB.setIcon(new ImageIcon(image));
        try (InputStream inputStream = imagePath.getBinaryStream()) {

        // Định danh cho tệp tạm thời

        File tempFile = File.createTempFile("temp", ".tmp");
        String tempFilePath = tempFile.getAbsolutePath();

        // Sao chép dữ liệu từ Blob vào tệp tạm thời

        try (OutputStream outputStream = new FileOutputStream(tempFilePath)) {

        byte[] buffer = new byte[1024];

        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {

        outputStream.write(buffer, 0, bytesRead);

        }

        }

        // Sau khi sao chép xong, imagePathString sẽ chứa đường dẫn tới tệp tạm thời

        anhTB = tempFilePath;

        } catch (IOException | SQLException e) {

        e.printStackTrace();

        }
        txtMaTB.setEditable(false);
        txtMaTB.setDisabledTextColor(Color.DARK_GRAY);
    }
    
    public boolean checkTrungThietBiTrongKho(String tenTB){
        int selectedRow = jTableKhoTB.getSelectedRow(); // Lấy chỉ số của dòng được chọn
        // Duyệt qua tất cả các dòng trong jTable
    for (int row = 0; row < jTableKhoTB.getRowCount(); row++) {
        if (row == selectedRow) {
            continue; // Bỏ qua dòng được chọn
        }
        
              String valueTenThietBi = jTableKhoTB.getValueAt(row,jTableKhoTB.getColumn("Tên thiết bị").getModelIndex()).toString(); // Lấy giá trị từ cột "Tên Thiết Bị"
        for(int i = 0;i<listKhoTB.size();i++){
            if(tenTB.equals(valueTenThietBi))
                return true;
        }
    }
    return false;
    }
    private void btn_CapNhatTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatTBActionPerformed
        ToanCuc tt = new ToanCuc();
        Date currentDate = new Date();
        String MaTB = txtMaTB.getText();
        String tenTB = txtNameTB.getText();
        String loaiTB = txtLoaiTB.getText();
        String textslTB = txtSLTB.getText();
        String NhaSX = txtNXS.getText();
        if(tenTB.equals("") || loaiTB.equals("")|| loaiTB.equals("") || textslTB.equals("") || NhaSX.equals("")){
            JOptionPane.showMessageDialog(this,"Bạn phải nhập đủ thông tin");
        }
       else{
         try{
             if(checkTrungThietBiTrongKho(tenTB)){
                JOptionPane.showMessageDialog(this, "Thiết bị đã có trong kho!"); 
             }
             else{
                 Connection conn = cn.getConnection();
                        int slTB = Integer.parseInt(textslTB);
                        String update = "Update KhoThietBi set TenTB = ?, LoaiTB = ?, SoLuongTB  = ?, NhaSX = ?, NgayNhap = ?, AnhTB = ? where Email = ? and id_tb = ? and MaTB = ? ";
                        PreparedStatement st;
                        st = conn.prepareCall(update);
                        int id_tb = 0;
                    String queryPhongHoc = "SELECT id_tb FROM KhoThietBi WHERE MaTB = ?";
                    PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                    stPhongHoc.setString(1, MaTB);
                    ResultSet rs = stPhongHoc.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
                if (rs.next()) {
                    id_tb = rs.getInt("id_tb");
                    }   
                        st.setString(1,tenTB);
                        st.setString(2,loaiTB);
                        st.setInt(3, slTB);
                        st.setString(4, NhaSX);
                        st.setDate(5,new java.sql.Date(currentDate.getTime()));
                        InputStream is = new FileInputStream(new File(anhTB));
                        st.setBlob(6, is);
                        st.setString(7,tt.getEmail());
                        st.setInt(8,id_tb);
                        st.setString(9,MaTB);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Cập nhật kho thiết bị thành công");
                        txtMaTB.setText(null);
                        txtNameTB.setText(null);
                        txtLoaiTB.setText(null);
                        txtSLTB.setText(null);
                        txtNXS.setText(null);
                        hinhTB.setIcon(null);
                        conn.close();
                        LayDuTenThietBiLen();
                        LoadJComboCHonThietBi();
             }
            }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Cập nhật kho thiết bị thất bại");
        }  
       }
         LoadDataKhoThietBi();
        try {
            LoadDataTableKhoTB();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBoxThietBi.setSelectedItem(null);
    }//GEN-LAST:event_btn_CapNhatTBActionPerformed

    private void btn_XoaTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTBActionPerformed
        ToanCuc tt = new ToanCuc();
        Date currentDate = new Date();
        String MaTB = txtMaTB.getText();
        String tenTB = txtNameTB.getText();
        String loaiTB = txtLoaiTB.getText();
        String textslTB = txtSLTB.getText();
        String NhaSX = txtNXS.getText();
        if(tenTB.equals("") || loaiTB.equals("")|| loaiTB.equals("") || textslTB.equals("") || NhaSX.equals("")){
            JOptionPane.showMessageDialog(this,"Bạn phải nhập đủ thông tin");
        }
       else{
         try{
                 Connection conn = cn.getConnection();
                        int slTB = Integer.parseInt(textslTB);
                
                String checkTBQuery = "SELECT COUNT(*) FROM ThietBi WHERE id_tb in (SELECT id_tb FROM KhoThietBi WHERE MaTB = ? and  Email = ?)";
            PreparedStatement checkLichHocStatement = conn.prepareStatement(checkTBQuery);
            checkLichHocStatement.setString(1, txtMaTB.getText());
            checkLichHocStatement.setString(2, tt.getEmail());
            ResultSet checkTBResult = checkLichHocStatement.executeQuery();
             
            // Lấy số lượng bản ghi liên quan
            int ThietBiCount = 0;
            if (checkTBResult.next()) {
                ThietBiCount = checkTBResult.getInt(1);
            }
            if(ThietBiCount == 0){
                 String update = "Delete from KhoThietBi where Email = ? and tenTB = ? and id_tb = ?";
                        PreparedStatement st;
                        st = conn.prepareCall(update);
                        int id_tb = 0;
                    String queryPhongHoc = "SELECT id_tb FROM KhoThietBi WHERE MaTB = ?";
                    PreparedStatement stPhongHoc = conn.prepareStatement(queryPhongHoc);
                    stPhongHoc.setString(1, MaTB);
                    ResultSet rs = stPhongHoc.executeQuery();
                // Nếu tìm thấy kết quả, lấy giá trị id_phong
                if (rs.next()) {
                    id_tb = rs.getInt("id_tb");
                    }   
                        st.setString(1,tt.getEmail());
                        st.setString(2,tenTB);
                        st.setInt(3, id_tb);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Xóa thiết bị thành công");
                        txtMaTB.setText(null);
                        txtNameTB.setText(null);
                        txtLoaiTB.setText(null);
                        txtSLTB.setText(null);
                        txtNXS.setText(null);
                        hinhTB.setIcon(null);
                        txtMaTB.setEditable(true);
                        conn.close(); 
                        LayDuTenThietBiLen();
                        LoadJComboCHonThietBi();
            }
            else{
                JOptionPane.showMessageDialog(this, "Thiết bị đang sử dụng không thể xóa");
            }       
            }
        catch (Exception ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Xóa thiết bị thất bại");
        }  
       }
         LoadDataKhoThietBi();
        try {
            LoadDataTableKhoTB();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBoxThietBi.setSelectedItem(null);
    }//GEN-LAST:event_btn_XoaTBActionPerformed

    private void btn_ReTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReTBActionPerformed
       txtMaTB.setText(null);
        txtNameTB.setText(null);
        txtLoaiTB.setText(null);
        txtSLTB.setText(null);
        txtNXS.setText(null);
        hinhTB.setIcon(null);
        jTableKhoTB.clearSelection();
        txtMaTB.setEditable(true);
        txtNameTB.setEditable(true);
    }//GEN-LAST:event_btn_ReTBActionPerformed

    private void txtNXSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNXSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNXSActionPerformed

    private void jTableKhoTBAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableKhoTBAncestorAdded
        
    }//GEN-LAST:event_jTableKhoTBAncestorAdded

    private void jTableKhoTBAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableKhoTBAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableKhoTBAncestorMoved

    private void jTableKhoTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKhoTBMouseClicked
        current = jTableKhoTB.getSelectedRow();
        if(current != -1){
    try {
        DisplayKhoTB(current);
    } catch (SQLException ex) {
        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
    }//GEN-LAST:event_jTableKhoTBMouseClicked

    private void txtSoLuongTrongKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongTrongKhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongTrongKhoActionPerformed

    private void jButtonTimTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimTBActionPerformed
        listKhoTB.clear();
         ToanCuc tt = new ToanCuc();
         try{
          Connection conn = cn.getConnection();
           String timtb = "select * from KhoThietBi where TenTB like '%" + jTextFieldTimTB.getText()+"%' and Email like '"+tt.getEmail()+"'";
          PreparedStatement st = conn.prepareStatement(timtb);
          ResultSet rs = st.executeQuery();
          while(rs.next()){
              int id = rs.getInt("id_tb");
              String maTB = rs.getString("MaTB");
              String tenTB = rs.getString("TenTB");
              String loaitb = rs.getString("LoaiTB");
              int soluongtb = rs.getInt("SoLuongTB");
              String nhasx = rs.getString("NhaSX");
              Date ngaynhap = rs.getDate("NgayNhap");
              Blob anhtb = rs.getBlob("AnhTB");
              
              KhoTB tb = new KhoTB(id,maTB,tenTB,loaitb,soluongtb,nhasx,ngaynhap,anhtb);
              
              listKhoTB.add(tb);
          }
          conn.close();
          LoadDataTableKhoTB();
         }
         catch (Exception ex){
             ex.printStackTrace();
         }        
    }//GEN-LAST:event_jButtonTimTBActionPerformed
//Load du lieu phong hoc
    public void LoadDataThietBi(){
        ToanCuc tt = new ToanCuc();
        try{
            Connection conn = cn.getConnection();
             String query = "SELECT id,kb.TenTB,soLuong ,ph.tenPhong,TinhTrangTB,kb.AnhTB,tb.Email FROM ThietBi tb inner join PhongHoc ph on tb.id_phong = ph.id_phong "
                     + "inner join KhoThietBi kb on kb.id_tb = tb.id_tb WHERE tb.Email = ?";
             PreparedStatement statement = conn.prepareCall(query);
             statement.setString(1, tt.getEmail());
            ResultSet resultSet = statement.executeQuery();
            listTB.clear();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String tenThietBi = resultSet.getString(2);
                int soLuong = resultSet.getInt(3);
                String tenPhong = resultSet.getString(4);
                String tinhtrangtb = resultSet.getString(5);
                Blob anhtb = resultSet.getBlob(6);
                String email = resultSet.getString(7);
                ThietBi tb = new ThietBi(id,tenThietBi,soLuong,tenPhong,tinhtrangtb,anhtb,email);
                listTB.add(tb);
            }
            conn.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    //Load du lieu vao bang ThietBi
    public void LoadDataTableThietBi() throws SQLException, IOException{
        DefaultTableModel model = (DefaultTableModel) jTableTB.getModel();
        model.setRowCount(0);
        
        for(ThietBi tb : listTB){
            Blob anhtbBlob = tb.getAnhtb();
  // Chuyển Blob sang byte array
                 byte[] anhtbBytes = anhtbBlob.getBytes(1, (int)anhtbBlob.length());
  // Tạo Image từ byte array
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(anhtbBytes));
                Image dimg = img.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);  
            model.addRow(new Object[] {tb.getTenPhong(),tb.getTenThietBi(),tb.getSoluong(),tb.getTinhtrangtb(),icon});
        }
    }
    
    
    //Load dữ liệu GV
    public void LoadDataGV(){
        ToanCuc tt = new ToanCuc();
        try{
            Connection conn = cn.getConnection();
             String query = "SELECT * FROM GiangVien WHERE Email = ?";
             PreparedStatement statement = conn.prepareCall(query);
             statement.setString(1, tt.getEmail());
            ResultSet resultSet = statement.executeQuery();
            listGV.clear();
            while(resultSet.next()){
                String magv = resultSet.getString("MaGV");
                String tengv = resultSet.getString("tenGiangVien");
                String gt = resultSet.getString("GioiTinh");
                String sdt = resultSet.getString("SoDT");
                Date ngaysinh = resultSet.getDate("NgaySinh");
                Blob image = resultSet.getBlob("AnhGV");
                GiangVien gv = new GiangVien(magv,tengv,gt,sdt,ngaysinh,image);
                listGV.add(gv);
            }
            conn.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    //Load dữ liệu GV lên bảng
    public void LoadDataTableGV() throws IOException, SQLException{
        DefaultTableModel model = (DefaultTableModel) jTableGV.getModel();
        model.setRowCount(0);
        
        for(GiangVien gv : listGV){
             Blob anhGVBlob = gv.getAnhgv();
  // Chuyển Blob sang byte array
                 byte[] anhGVBytes = anhGVBlob.getBytes(1, (int)anhGVBlob.length());
  // Tạo Image từ byte array
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(anhGVBytes));
                Image dimg = img.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);  
            
            //Chỉnh ngày sinh
            Date ngaySinh = gv.getNgaysinh();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
            String ngaySinhString = formatter.format(ngaySinh);
            model.addRow(new Object[] {gv.getMaGV(),gv.getTenGiangVien(),gv.getGt(),gv.getSodt(),ngaySinhString,icon});
        }
    }
    
    //Load dữ liệu Môn học
    public void LoadDataMonHoc(){
        ToanCuc tt = new ToanCuc();
        try{
            Connection conn = cn.getConnection();
             String query = "SELECT id_mh,tenMonHoc,SoTinChi,gv.tenGiangVien,gv.MaGV,gv.AnhGV,mh.Email FROM MonHoc mh join GiangVien gv on mh.id_gv = gv.id_gv WHERE mh.Email = ?";
             PreparedStatement statement = conn.prepareCall(query);
             statement.setString(1, tt.getEmail());
            ResultSet resultSet = statement.executeQuery();
            listMH.clear();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String tenmh = resultSet.getString(2);
                int sotc = resultSet.getInt(3);
                String tengv = resultSet.getString(4);
                String magv = resultSet.getString(5);
                Blob anhGV = resultSet.getBlob(6);
                String email = resultSet.getString(7);
                MonHoc mh = new MonHoc(id,tenmh,sotc,tengv,magv,anhGV,email);
                listMH.add(mh);
            }
            conn.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    //Load dữ liệu môn học lên bảng
    public void LoadDataTableMH() throws SQLException, IOException{
        DefaultTableModel model = (DefaultTableModel) jTableMonHoc.getModel();
        model.setRowCount(0);
        
        for(MonHoc mh : listMH){
             Blob anhGVBlob = mh.getAnhGV();
             // Chuyển Blob sang byte array
                 byte[] anhGVBytes = anhGVBlob.getBytes(1, (int)anhGVBlob.length());
                // Tạo Image từ byte array
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(anhGVBytes));
                Image dimg = img.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);
            model.addRow(new Object[] {mh.getTenMonHoc(),mh.getSoTinChi(),mh.getTenGV(),mh.getMaGV(),icon});
        }
    }
   //Check Thiết bị
    public boolean checkThietBi(String tenTB){
        for(int i = 0;i<listTB.size();i++){
            if(listTB.get(i).getTenThietBi().equalsIgnoreCase(tenTB))
                return true;
        }
        return false;
    }
    //Trung phong list Thiet bi
     public boolean checkTrungPhongTB(String tenphong){
        for(int i = 0;i<listTB.size();i++){
            if(listTB.get(i).getTenPhong().equalsIgnoreCase(tenphong))
                return true;
        }
        return false;
    }
     
     //Check trung Giang vien
      public boolean checkTrungGV(String gv){
        for(int i = 0;i<listGV.size();i++){
            if(listGV.get(i).getMaGV().equalsIgnoreCase(gv))
                return true;
        }
        return false;
    }
    //laylay Phòng
    public void DisplayPhong(int i){
        PhongHoc ph = listPhong.get(i);
        String lastTwoChars = ph.getTenPhong().substring(ph.getTenPhong().length() - 2);
        txtmaSoPhong.setText(lastTwoChars);
        txtSoChoNgoi.setText(String.valueOf(ph.getSoChoNgoi()));
        // Hiển thị mục đã chọn trong JComboBox
        comboboxLoaiPhong.setSelectedItem(ph.getLoaiPhong());
        CoSo.setSelectedItem(ph.getCoSo()); // Thay comboBox bằng tên biến thực tế của bạn
    }
    
    //DIsplay đặt phòng
     public void DisplayDatPhong(int i) throws SQLException{
        LichHoc lh = listLH.get(i);
        jComboBoxTenPhong.setSelectedItem(lh.getTenPhong());
        jComboBoxMaGV.setSelectedItem(lh.getMaGV());
        jComboBoxTietBD.setSelectedItem(String.valueOf(lh.getTietBD()));
        jComboBoxTietKT.setSelectedItem(String.valueOf(lh.getTietKT()));
        jComboBoxMonHoc.setSelectedItem(lh.getTenMonHoc());
        Blob imagePath = lh.getAnhGV();
        ImageIcon imageIcon = new ImageIcon(imagePath.getBytes(1,(int) imagePath.length()));
        Image image = imageIcon.getImage().getScaledInstance(hinhgvHome.getWidth(), hinhgvHome.getHeight(), Image.SCALE_SMOOTH);
        hinhgvHome.setIcon(new ImageIcon(image));
        jTextField6.setText(lh.getSogiohoc());
        
    }
    //Display thiết bị
    public void DisplayThietBi(int i){
        ThietBi tb = listTB.get(i);
        JLabelTenPhong.setText(tb.getTenPhong());
        jComboBoxThietBi.setSelectedItem(tb.getTenThietBi());
        txtSoLuong.setText(String.valueOf(tb.getSoluong()));
        // Hiển thị mục đã chọn trong JComboBox
        jComboBoxPhong.setSelectedItem(tb.getTenPhong());
        jComboBoxTTThietBi.setSelectedItem(tb.getTinhtrangtb());
        JLabelTenPhong.setEnabled(false);
        JLabelTenPhong.setDisabledTextColor(Color.DARK_GRAY);
    }
    
    //Display GIangVien
    public void DisplayGV(int i) throws SQLException{
        GiangVien gv = listGV.get(i);
        txtMaGV.setText(gv.getMaGV());
        txtTenGV.setText(gv.getTenGiangVien());
        // Hiển thị mục đã chọn trong JComboBox
        jComboBoxGT.setSelectedItem(gv.getGt());
        NgaySinh.setDate(gv.getNgaysinh());
        txtSDT.setText(String.valueOf(gv.getSodt()));
        Blob imagePath = gv.getAnhgv();
         ImageIcon imageIcon = new ImageIcon(imagePath.getBytes(1, (int) imagePath.length()));
        Image image = imageIcon.getImage().getScaledInstance(hinhgv.getWidth(), hinhgv.getHeight(), Image.SCALE_SMOOTH);
        hinhgv.setIcon(new ImageIcon(image));
        try (InputStream inputStream = imagePath.getBinaryStream()) {

        // Định danh cho tệp tạm thời

        File tempFile = File.createTempFile("temp", ".tmp");
        String tempFilePath = tempFile.getAbsolutePath();

        // Sao chép dữ liệu từ Blob vào tệp tạm thời

        try (OutputStream outputStream = new FileOutputStream(tempFilePath)) {

        byte[] buffer = new byte[1024];

        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {

        outputStream.write(buffer, 0, bytesRead);

        }

        }

        // Sau khi sao chép xong, imagePathString sẽ chứa đường dẫn tới tệp tạm thời

        duongdananh = tempFilePath;

        } catch (IOException | SQLException e) {

        e.printStackTrace();

        }
    txtMaGV.setEditable(false);
        txtMaGV.setDisabledTextColor(Color.DARK_GRAY);
        
    }
    
    //Display Môn học
    public void DisplayMH(int i) throws SQLException{
        MonHoc mh = listMH.get(i);
        txtTenMonHoc.setText(mh.getTenMonHoc());
        jComboBoxTinChi.setSelectedItem(String.valueOf(mh.getSoTinChi()));
        jComboBoxGiangVien.setSelectedItem(mh.getMaGV());
        TenGV_txt_Mon.setText(mh.getTenGV());
        Blob imagePath = mh.getAnhGV();
         ImageIcon imageIcon = new ImageIcon(imagePath.getBytes(1, (int) imagePath.length()));
        Image image = imageIcon.getImage().getScaledInstance(hinhgvMH.getWidth(), hinhgvMH.getHeight(), Image.SCALE_SMOOTH);
    hinhgvMH.setIcon(new ImageIcon(image));
    
    try (InputStream inputStream = imagePath.getBinaryStream()) {

        // Định danh cho tệp tạm thời

        File tempFile = File.createTempFile("temp", ".tmp");
        String tempFilePath = tempFile.getAbsolutePath();

        // Sao chép dữ liệu từ Blob vào tệp tạm thời

        try (OutputStream outputStream = new FileOutputStream(tempFilePath)) {

        byte[] buffer = new byte[1024];

        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {

        outputStream.write(buffer, 0, bytesRead);

        }

        }

        // Sau khi sao chép xong, imagePathString sẽ chứa đường dẫn tới tệp tạm thời

        duongdananh = tempFilePath;

        } catch (IOException | SQLException e) {

        e.printStackTrace();

        }
    }
    // CHeck chuoi la so
    public static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //CHeck trung phong hoc
    public boolean checkTrungPhong(String tenphong){
        for(int i = 0;i<listPhong.size();i++){
            if(listPhong.get(i).getTenPhong().equalsIgnoreCase(tenphong))
                return true;
        }
        return false;
    }
    
    //CHeck trung phong hoc
    public boolean checkTrungPhongDP(String tenphong,int tiet1,int tiet2){
        for(int i = 0;i < listLH.size();i++){
            int tietBD = listLH.get(i).getTietBD();
        int tietKT = listLH.get(i).getTietKT();
            if(listLH.get(i).getTenPhong().equalsIgnoreCase(tenphong) && (tiet1 >= listLH.get(i).getTietBD() && tiet1 < listLH.get(i).getTietKT() ||
    tiet2 > listLH.get(i).getTietBD() && tiet2 <= listLH.get(i).getTietKT()))
                return true; 
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CoSo;
    private javax.swing.JPanel Home;
    private javax.swing.JTextField JLabelTenPhong;
    private com.toedter.calendar.JDateChooser NgaySinh;
    private javax.swing.JPanel QLGiaoVien;
    private javax.swing.JPanel QLKhoTB;
    private javax.swing.JPanel QLMonHoc;
    private javax.swing.JPanel QLPhong;
    private javax.swing.JPanel QLThietBi;
    private javax.swing.JButton ReGV;
    private javax.swing.JButton ReMon;
    private javax.swing.JButton RePhong;
    private javax.swing.JButton RePhongDay;
    private javax.swing.JButton ReSearhHome;
    private javax.swing.JButton SuaMon;
    private javax.swing.JTextField TenGV_txt_Mon;
    private javax.swing.JButton ThemGV;
    private javax.swing.JButton ThemMon;
    private javax.swing.JButton ThemPhong;
    private javax.swing.JButton ThemThietBi;
    private javax.swing.JPanel ThongKe;
    private javax.swing.JButton TimPhongHome;
    private javax.swing.JButton TimPhongThemThietBi;
    private javax.swing.JButton TimPhongThemThietBi4;
    private javax.swing.JButton UpdateGV;
    private javax.swing.JButton UpdatePhong;
    private javax.swing.JButton UpdateThietBi;
    private javax.swing.JButton XoaGV;
    private javax.swing.JButton XoaMon;
    private javax.swing.JButton XoaPhong;
    private javax.swing.JButton XoaThietBi;
    private javax.swing.JButton btnDatPhongDay;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnXoaPhongDay;
    private javax.swing.JButton btn_CapNhatPhongDay;
    private javax.swing.JButton btn_CapNhatTB;
    private javax.swing.JButton btn_ReTB;
    private javax.swing.JButton btn_ThemTB;
    private javax.swing.JButton btn_XoaTB;
    private javax.swing.JComboBox<String> comboboxLoaiPhong;
    private javax.swing.JLabel hinhTB;
    private javax.swing.JLabel hinhgv;
    private javax.swing.JLabel hinhgvHome;
    private javax.swing.JLabel hinhgvMH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonTimTB;
    private com.toedter.calendar.JCalendar jCalendarNgayDay;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBoxGT;
    private javax.swing.JComboBox<String> jComboBoxGiangVien;
    private javax.swing.JComboBox<String> jComboBoxMaGV;
    private javax.swing.JComboBox<String> jComboBoxMonHoc;
    private javax.swing.JComboBox<String> jComboBoxPhong;
    private javax.swing.JComboBox<String> jComboBoxTTThietBi;
    private javax.swing.JComboBox<String> jComboBoxTenPhong;
    private javax.swing.JComboBox<String> jComboBoxThietBi;
    private javax.swing.JComboBox<String> jComboBoxTietBD;
    private javax.swing.JComboBox<String> jComboBoxTietKT;
    private javax.swing.JComboBox<String> jComboBoxTinChi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelThongKe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableDatPhong;
    private javax.swing.JTable jTableGV;
    private javax.swing.JTable jTableKhoTB;
    private javax.swing.JTable jTableMonHoc;
    private javax.swing.JTable jTableTB;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextFieldLoaiPhong;
    private javax.swing.JTextField jTextFieldTenGV;
    private javax.swing.JTextField jTextFieldTimTB;
    private javax.swing.JButton reSearch;
    private javax.swing.JTextField txtLoaiTB;
    private javax.swing.JTextField txtMaGV;
    private javax.swing.JTextField txtMaTB;
    private javax.swing.JTextField txtNXS;
    private javax.swing.JTextField txtNameTB;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSLTB;
    private javax.swing.JTextField txtSoChoNgoi;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongTrongKho;
    private javax.swing.JTextField txtTenGV;
    private javax.swing.JTextField txtTenMonHoc;
    private javax.swing.JTextField txtmaSoPhong;
    private javax.swing.JTextField txtsearchField;
    // End of variables declaration//GEN-END:variables

    private Icon ResizeImage(String ImagePath) {
       ImageIcon MyImage = new ImageIcon(ImagePath);
       Image image = MyImage.getImage();
       Image newImage = image.getScaledInstance(hinhgv.getWidth(), hinhgv.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon img = new ImageIcon(newImage);
       return img;
    }
}
