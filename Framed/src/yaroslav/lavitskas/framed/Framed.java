package yaroslav.lavitskas.framed;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import yaroslav.lavitskas.mycomponents.TitleLabel;

public class Framed extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int GRIDSIZE = 3;
	private LightButton lightButton[][] = new LightButton[GRIDSIZE][GRIDSIZE];
	
	public Framed()
	{
		initGUI();
	}
	
	private void initGUI()
	{
		TitleLabel titleLable = new TitleLabel("Framed");
		add(titleLable, BorderLayout.PAGE_START);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		
		for (int row=0; row<GRIDSIZE; row++)
		{
			for (int col=0; col<GRIDSIZE; col++)
			{
				lightButton[row][col]=new LightButton(row, col);
				lightButton[row][col].addActionListener(e -> 
				{
					LightButton button = (LightButton) e.getSource();
					int row2 = button.getRow();
					int col2 = button.getCol();
					toggleLight(row2, col2);
				});
				centerPanel.add(lightButton[row][col]);
			}
		}
		
		setResizable(false);
		pack();
		setLocationRelativeTo(null);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private  void toggleLight(int row, int col)
	{
		lightButton[row][col].toggle();
	}

	public static void main(String[] args) {
		try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());}		
		catch (Exception e) {}

		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				new Framed();
				
			}
		});

	}

}
