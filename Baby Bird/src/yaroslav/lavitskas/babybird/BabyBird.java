package yaroslav.lavitskas.babybird;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class BabyBird extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel ScorePanel = new JPanel();
	
	public BabyBird()
	{
		initGUI();
		setTitle("Baby Bird");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		try
		{
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		}
		catch (Exception e)
		{
			
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new BabyBird();
				
			}
		});
	}
	
	private void initGUI()
	{
		JLabel titleLabel = new JLabel("Baby Bird");
		add(titleLabel);
		
		// main panel
		
		// score panel
		
		//flight panle
		
		//bottom panel
		
		//bird net panel
	}

}
