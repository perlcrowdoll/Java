package yaroslav.lavitskas.slidingtiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import yaroslav.lavitskas.mycomponents.TitleLabel;

public class SlidingTiles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FILENAME = "C:\\Users\\ylavitskas\\Downloads\\MoreDIYJava\\slidingTilesImage.jpg";
	
	private int tileSize=50;
	private int gridSize=4;
	private BufferedImage image = null;
	private TileButton[][] tile = new TileButton[gridSize][gridSize];
	private JPanel centerPanel = new JPanel();
	
	public SlidingTiles()
	{
		try
		{
			image = ImageIO.read(new File(FILENAME));
			TileButton.setTileSizeAndMaxTiles(tileSize, gridSize);
			newGUI();
			setTitle("Sliding Tiles");
			setResizable(false);
			pack();
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}
		catch (IOException e)
		{
			String message = "Image couldn't open the file";
			JOptionPane.showMessageDialog(this, message);
		}

	}

	private void newGUI() {
		TitleLabel titleLable = new TitleLabel("Sliding Tiles");
		add(titleLable, BorderLayout.PAGE_START);
		
		//Main Panel
		divideImage();
		
		//Button Panel
		
	}

	private void clickedTile(TileButton clickedTile) {
		int row=clickedTile.getRow();
		int col=clickedTile.getCol();
		if(row>0 && tile[row-1][col].hasNoImage())
		{
			clickedTile.swap(tile[row-1][col]);
		}
		if(row<2 && tile[row+1][col].hasNoImage())
		{
			clickedTile.swap(tile[row+1][col]);
		}
		if(col>0 && tile[col+1][col].hasNoImage())
		{
			clickedTile.swap(tile[row+1][col]);
		}
	}

	

	private void divideImage() {
		centerPanel.setLayout(new GridLayout(gridSize, gridSize));
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.removeAll();		
		int imageId = 0;
		for (int row=0; row<gridSize; row++)
		{
			for (int col=0; col<gridSize; col++)
			{
				int x =col*tileSize;
				int y =row*tileSize;
				BufferedImage subimage = image.getSubimage(x, y, tileSize, tileSize);
				ImageIcon imageIcon = new ImageIcon(subimage);
				tile[row][col] = new TileButton(imageIcon, imageId, row, col);
				tile[row][col].addActionListener(e -> {
					TileButton button = (TileButton) e.getSource();
					clickedTile(button);
					
				});
				centerPanel.add(tile[row][col]);
				imageId++;
			}
		}
		centerPanel.revalidate();
		
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			
		}

		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new SlidingTiles();
				
			}
		});

	}

}
