package yaroslav.lavitskas.watchyourstep;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import yaroslav.lavitskas.mycomponents.TitleLabel;

public class WatchYourStep extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int GRIDSIZE = 10;
	private static final int NUMBEROFHOLES = 10;
	private TerrrainButton[][] terrain = new TerrrainButton[GRIDSIZE][GRIDSIZE];
	private int totalRevealed=0;
	
	public WatchYourStep()
	{
		initGUI();
		setHoles();
		setTitle("Minner");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI()
	{
		TitleLabel titleLabel = new TitleLabel("Minner");
		add(titleLabel, BorderLayout.PAGE_START);
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		for (int row =0; row<GRIDSIZE;row++)
		{
			for (int col =0; col<GRIDSIZE;col++)
			{
				terrain[row][col] = new TerrrainButton(row, col);
				terrain[row][col].addActionListener(e ->
				{
					TerrrainButton button = (TerrrainButton) e.getSource();
					int row2 = button.getRow();
					int col2 = button.getCol();
					clickedTerrain(row2, col2);
				});
				centerPanel.add(terrain[row][col]);
			}
		}
		
	}
	
	private void checkNeighbors(int row, int col)
	{
		check(row-1, col-1);
		check(row-1, col);
		check(row-1, col+1);
		check(row, col-1);
		check(row, col+1);
		check(row+1, col-1);
		check(row+1, col);
		check(row+1, col+1);
	}
	
	private void clickedTerrain(int row, int col) {
		if (terrain[row][col].hasHole()) { 
			String message = "Game Over!";
			promptForNewGame(message);
		}
		else {
		check(row, col);
		checkNeighbors(row, col);
		if (GRIDSIZE*GRIDSIZE-NUMBEROFHOLES == totalRevealed)
		{
			String message = "Congratulations! You won!";
			promptForNewGame(message);
		}
		}
	}

	private void promptForNewGame(String message) {
		showHoles();
		int option = JOptionPane.showConfirmDialog(this, message, "Play again?", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION)
		{
			newGame();
		}
		else System.exit(0);
		
		
	}

	private void showHoles() {
		for (int row =0; row<GRIDSIZE;row++)
		{
			for (int col =0; col<GRIDSIZE;col++)
			{
				terrain[row][col].reveal(true);
			}
		}
		
	}

	private void newGame() {
		
		
		for (int row =0; row<GRIDSIZE;row++)
		{
			for (int col =0; col<GRIDSIZE;col++)
			{
				terrain[row][col].reset();
			}
		}
		setHoles();
		totalRevealed=0;
	}

	private void check(int row, int col) {
		if (row>-1 && col>-1 && row<GRIDSIZE && col<GRIDSIZE && !terrain[row][col].isRevealed() && !terrain[row][col].hasHole())
		{
			terrain[row][col].reveal(true);
			totalRevealed++;
			if(!terrain[row][col].isNextToHoles()) checkNeighbors(row, col);
		}
		
	}

	private void setHoles()
	{
		Random rand = new Random();
		for (int i=0; i<NUMBEROFHOLES;i++)
		{
			int pickRow=rand.nextInt(GRIDSIZE);
			int pickCol=rand.nextInt(GRIDSIZE);
			while(terrain[pickRow][pickCol].hasHole())
			{
				pickRow = rand.nextInt(GRIDSIZE);
				pickCol = rand.nextInt(GRIDSIZE);
			}
			terrain[pickRow][pickCol].setHole(true);
			addToNeighborsHoleCount(pickRow, pickCol);

		}
		
	}

	private void addToNeighborsHoleCount(int row, int col) {
		addToHoleCount(row-1, col-1);
		addToHoleCount(row-1, col);
		addToHoleCount(row-1, col+1);
		addToHoleCount(row, col-1);
		addToHoleCount(row, col+1);
		addToHoleCount(row+1, col-1);
		addToHoleCount(row+1, col);
		addToHoleCount(row+1, col+1);
		
	}

	private void addToHoleCount(int row, int col) {
		if (row>-1 && col>-1 && row<GRIDSIZE && col<GRIDSIZE)
		{
			terrain[row][col].increaseHoleCount();	
		}
	}

	public static void main(String[] args) {
		try {
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e)
		{
			
		}
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				new WatchYourStep();
				
			}
		});

	}

}
