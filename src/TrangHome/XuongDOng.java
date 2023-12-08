/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TrangHome;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ASUS
 */
public class XuongDOng extends DefaultTableCellRenderer{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
   
    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    label.setPreferredSize(new Dimension(100, 50));
    String text = value.toString();
  text = "<html><body style='width: 100px'>" + text + "</body></html>";
  label.setText(text);
  label.setHorizontalAlignment(JLabel.CENTER);
    return label;
  }
}
