package myTetris;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

public class Field {

	protected static long score = 0;
	private JFrame frmMytetris;
	protected static JTable table;
	private static DefaultTableModel model;
	private static DefaultTableModel model2;
	protected static Byte[][] gamefield = new Byte[30][9];
	private static Byte[] columns = new Byte[9];
	private static Byte[] columns2 = new Byte[3];
	protected static Byte[][] figure = new Byte[3][3];
	protected JLabel label;
	private JLabel lblSpeed;
	protected JLabel label_1;
	protected JTable table_1;
	private JLabel lblNextFigure;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Field() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMytetris = new JFrame();
		frmMytetris.setTitle("myTetris");
		frmMytetris.setBounds(100, 100, 508, 893);
		frmMytetris.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMytetris.getContentPane().setLayout(
				new MigLayout("", "[fill][352.00,center][41.00][99.00][-58.00][35.00]", "[][][44.00][][][475.00][]"));
		filUpTable();
		model = new DefaultTableModel(gamefield, columns);
		table = new JTable(model);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setRowHeight(27);
		System.out.println();

		// table.setShowHorizontalLines(true);
		// table.setShowVerticalLines(true);
		table.setShowGrid(true);

		for (int i = 0; i < 9; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new ColorRender());
		}

		frmMytetris.getContentPane().add(table, "cell 1 1 1 5,grow");

		lblNextFigure = new JLabel("Next figure");
		frmMytetris.getContentPane().add(lblNextFigure, "cell 3 1");

		model2 = new DefaultTableModel(figure, columns2);
		table_1 = new JTable(model2);
		for (int i = 0; i < 3; i++) {
			table_1.getColumnModel().getColumn(i).setCellRenderer(new ColorRender());
		}
		table_1.setIntercellSpacing(new Dimension(1, 1));
		table_1.setShowGrid(true);

		frmMytetris.getContentPane().add(table_1, "cell 3 2,grow");

		JLabel lblNewLabel = new JLabel("Score:");
		frmMytetris.getContentPane().add(lblNewLabel, "flowx,cell 3 3,alignx left");

		lblSpeed = new JLabel("Speed:");
		frmMytetris.getContentPane().add(lblSpeed, "flowx,cell 3 4,alignx left");

		label = new JLabel();
		label.setText(String.valueOf(score));
		frmMytetris.getContentPane().add(label, "cell 3 3");

		label_1 = new JLabel("1");
		frmMytetris.getContentPane().add(label_1, "cell 3 4");
		frmMytetris.addKeyListener(new Controls());
		frmMytetris.setFocusable(true);
		frmMytetris.setVisible(true);

	}

	protected static void filUpTable() {
		byte value = 0;
		for (int i = 0; i < 30; i++) {
			for (int ii = 0; ii < 9; ii++) {
				gamefield[i][ii] = value;
			}
		}
	}

	protected static void filUpTable_1() {
		byte value = 0;
		for (int i = 0; i < 3; i++) {
			for (int ii = 0; ii < 3; ii++) {
				figure[i][ii] = value;
			}
		}
	}

}
