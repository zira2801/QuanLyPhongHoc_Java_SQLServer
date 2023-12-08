/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrangHome;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ASUS
 */
public class QuanLyThongKeController {
    private ThongKeService thongkeservice = null;

    public QuanLyThongKeController() {
        thongkeservice = new ThongKeServiceImp1();
    }
    
    public void setTenPhongToChart(JPanel jpnItem){
        List<PhongHocBean> listItem = thongkeservice.getListByPhongHoc();
        if(listItem != null){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(PhongHocBean item : listItem){
                dataset.addValue(item.getSolansd(),"",item.getTenph());
            }
            JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ VỀ SỐ LẦN SỬ DỤNG CỦA CÁC PHÒNG HỌC","Phòng học","Số lần sử dụng", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(),637));
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
           jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }
    
}
