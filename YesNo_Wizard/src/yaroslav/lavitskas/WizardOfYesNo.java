package yaroslav.lavitskas;

import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;




 
public class WizardOfYesNo extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String[] ANSWER = {"Yes", "Go for it!", "Let's do it", "It's great idea to do", "Definitely", "No.", "I wouldn't." , "Bad idea.", "Don't do it", "Nor", "Nope"}; 
	
	public WizardOfYesNo()
	{
		
		Random rand = new Random();
		int numberOfAnswers = ANSWER.length;
		int pick = rand.nextInt(numberOfAnswers);
		String answer = ANSWER[pick];
		
		
		setTitle("Wizard of Yes/No");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 100);
		setResizable(false);
		
		JLabel label1 = new JLabel();
		Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 32);
		label1.setFont(font);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setText(answer);
		add(label1);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
	
	
	}
	
	public static void main(String[] arr)
	{
		
		try
		{
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		}
		catch (Exception e)
		{
			
		}
		
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				new WizardOfYesNo();
				
			}
		});
		

	}

}
