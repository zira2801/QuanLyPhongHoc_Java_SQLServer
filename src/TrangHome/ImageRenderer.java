
package TrangHome;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ASUS
 */
public class ImageRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
    if(value instanceof ImageIcon){
      ImageIcon icon = (ImageIcon)value;
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setIcon(icon);
    }
    return label;
    }
    
}
