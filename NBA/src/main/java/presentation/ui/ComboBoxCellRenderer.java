package presentation.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

public class ComboBoxCellRenderer implements TableCellRenderer {
	 public Component getTableCellRendererComponent(JTable table, Object value,
	   boolean isSelected, boolean hasFocus, int row, int column) {
	  JButton cmb = (JButton) value;
	  if (isSelected) {
	   cmb.setForeground(table.getSelectionForeground());
	   cmb.setBackground(table.getSelectionBackground());
	  } else {
	   cmb
	     .setForeground((unselectedForeground != null) ? unselectedForeground
	       : table.getForeground());
	   cmb
	     .setBackground((unselectedBackground != null) ? unselectedBackground
	       : table.getBackground());
	  }
	  cmb.setFont(table.getFont());
	  if (hasFocus) {
	   cmb
	     .setBorder(UIManager
	       .getBorder("Table.focusCellHighlightBorder"));
	   if (!isSelected && table.isCellEditable(row, column)) {
	    Color col;
	    col = UIManager.getColor("Table.focusCellForeground");
	    if (col != null) {
	     cmb.setForeground(col);
	    }
	    col = UIManager.getColor("Table.focusCellBackground");
	    if (col != null) {
	     cmb.setBackground(col);
	    }
	   }
	  } else {
	   cmb.setBorder(noFocusBorder);
	  }
	  return cmb;
	 }

	 protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

	 private Color unselectedForeground;
	 private Color unselectedBackground;
	}
