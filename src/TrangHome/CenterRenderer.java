
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
public class CenterRenderer extends DefaultTableCellRenderer{
    @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
   
    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    label.setHorizontalAlignment(JLabel.CENTER);
    return label;
  }
}
