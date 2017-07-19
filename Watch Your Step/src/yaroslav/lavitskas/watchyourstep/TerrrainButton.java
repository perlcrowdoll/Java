package yaroslav.lavitskas.watchyourstep;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class TerrrainButton extends JButton {


	private static final long serialVersionUID = 1L;
	
	private static int SIZE = 50;
	private int row = 0;
	private int col = 0;
	private int nextToHoles = 0;
	private boolean hole;
	private boolean revealed;
	
	public TerrrainButton(int row, int col)
	{
		this.row = row;
		this.col = col;
		Dimension size = new Dimension(SIZE, SIZE);
		setPreferredSize(size);
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public boolean hasHole() {
		return hole;
	}
	
	public boolean isRevealed() {
		return revealed;	
	}
	
	public void setHole(boolean hasHole) {
		this.hole = hasHole;
	}
	
	public void increaseHoleCount() {
		 nextToHoles++;
	}
	
	public boolean isNextToHoles() {
		return nextToHoles>0 ? true : false;	
	}
	
	public void reveal(boolean reveal) {
		this.revealed = reveal;
		if (reveal)
		{
			if (hasHole()) setBackground(Color.BLACK);
			else 
				{
					setBackground(Color.CYAN);
					if (isNextToHoles()) setText(String.valueOf(this.nextToHoles));
				}
		}
		else
		{
			setBackground(null);
			setText("");
		}
		setFocusPainted(false);
		
	}
	
	public void reset() {
		this.hole = false;
		this.revealed = false;
		this.nextToHoles = 0;
		setText("");
		setBackground(null);		
	}
	
	
}
