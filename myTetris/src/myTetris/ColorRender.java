package myTetris;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class ColorRender extends JLabel implements TableCellRenderer {

	protected ColorRender() {
		setOpaque(true); // MUST do this for background to show up.
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		if (table.getValueAt(row, column) != null) {
			if (Integer.valueOf(table.getValueAt(row, column).toString()) == 0) {
				setBackground(Color.GRAY);
				// setForeground(Color.BLACK);
			}

			if (Integer.valueOf(table.getValueAt(row, column).toString()) == 1) {
				setBackground(Color.BLUE);
				// setForeground(Color.BLACK);
			}
			if (Integer.valueOf(table.getValueAt(row, column).toString()) == 2) {
				setBackground(Color.ORANGE);
				// setForeground(Color.BLACK);
			}
		} else
			setBackground(Color.GRAY);
		return this;
	}
}
