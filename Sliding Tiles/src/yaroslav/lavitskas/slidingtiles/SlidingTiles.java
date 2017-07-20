package yaroslav.lavitskas.slidingtiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import yaroslav.lavitskas.mycomponents.TitleLabel;

public class SlidingTiles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String FILENAME = "slidingTilesImage.jpg";
	
	private int tileSize=50;
	private int gridSize=4;
	private BufferedImage image = null;
	
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
