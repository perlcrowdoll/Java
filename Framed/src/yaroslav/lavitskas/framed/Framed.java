package yaroslav.lavitskas.framed;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
					toggleLights(row2, col2);
					endGameIfDone();
				});
				centerPanel.add(lightButton[row][col]);
			}
		}
		
		setResizable(false);
		pack();
		setLocationRelativeTo(null);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		newGame();
		
	}
	private void endGameIfDone()
	{
		boolean done = 
		   lightButton[0][0].isLit()
		&& lightButton[0][1].isLit()
		&& lightButton[0][2].isLit()
		&& lightButton[1][0].isLit()
		&& !lightButton[1][1].isLit()
		&& lightButton[1][2].isLit()
		&& lightButton[2][0].isLit()
		&& lightButton[2][1].isLit()
		&& lightButton[2][2].isLit();
		String message = "Congratulations! You won! Do you want to play again?";
		if (done)
		{
			int option = JOptionPane.showConfirmDialog(this, message, "Play again?", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) newGame();
			else System.exit(0);
		}
		
		
	}
	
	private void newGame()
	{
		for (int row=0; row<GRIDSIZE; row++)
		{
			for (int col=0; col<GRIDSIZE; col++)
			{
				lightButton[row][col].toggle();
			}
			lightButton[1][1].toggle();
		}
		
		Random rand = new Random();
		for (int i=0;i<10;i++)
		{
		int numberOfTimes = rand.nextInt(10);
		int row = rand.nextInt(GRIDSIZE);
		int col = rand.nextInt(GRIDSIZE);
		toggleLights(row, col);		
		}
	}
	
	private  void toggleLights(int row, int col)
	{
		//top left corner
		if (row==0 && col==0)
		{
			lightButton[1][1].toggle();
			lightButton[0][1].toggle();
			lightButton[1][0].toggle();
		}
		
		//top right corner
		if (row==0 && col==2)
		{
			lightButton[0][1].toggle();
			lightButton[1][1].toggle();
			lightButton[1][2].toggle();
		}
		
		//bottom left corner
		if (row==2 && col==0)
		{
			lightButton[1][0].toggle();
			lightButton[1][1].toggle();
			lightButton[2][1].toggle();
		}
		
		//bottom right corner
		if (row==2 && col==2)
		{
			lightButton[1][2].toggle();
			lightButton[2][1].toggle();
			lightButton[1][1].toggle();
		}
		
		
		//top row middle
		if (row==0 && col==1)
		{
			lightButton[0][0].toggle();
			lightButton[0][2].toggle();
		}
		
		//bottom row middle
		if (row==2 && col==1)
		{
			lightButton[2][0].toggle();
			lightButton[2][2].toggle();
		}
		
		//left side middle
		if (row==1 && col==0)
		{
			lightButton[0][0].toggle();
			lightButton[2][0].toggle();
		}
		
		//right side middle
		if (row==1 && col==2)
		{
			lightButton[0][2].toggle();
			lightButton[2][2].toggle();
		}
		
		// center
		if (row==1 && col==1)
		{
			lightButton[0][1].toggle();
			lightButton[2][1].toggle();
			lightButton[1][0].toggle();
			lightButton[1][2].toggle();
		}
		
		
		
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
