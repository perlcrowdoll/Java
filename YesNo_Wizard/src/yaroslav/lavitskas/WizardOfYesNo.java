package yaroslav.lavitskas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import yaroslav.lavitskas.mycomponents.TitleLabel;




 
public class WizardOfYesNo extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String[] ANSWER = {"Yes", "Go for it!", "Let's do it", "It's great idea to do", "Definitely", "No.", "I wouldn't." , "Bad idea.", "Don't do it", "Nor", "Nope"}; 
	
	public WizardOfYesNo()
	{
		
		Random rand = new Random();
		int numberOfAnswers = ANSWER.length;
		int pick = rand.nextInt(numberOfAnswers);
		String answer = ANSWER[pick];
		String disclaimer = "This is only suggestion. Use your own good judgment. The Wizard of Yes/No is not responsible for the consequences of your decisions.";
		
		TitleLabel titleLabel = new TitleLabel("Wizard of Yes/No");
		add(titleLabel, BorderLayout.PAGE_START);
		
		setTitle("Wizard of Yes/No");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 100);
		setResizable(false);
		
		JLabel label1 = new JLabel();
		Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 32);
		label1.setFont(font);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setText(answer);
		label1.setOpaque(true);
		if (pick <5) label1.setBackground(Color.GREEN);
		else label1.setBackground(Color.RED);
			
		add(label1, BorderLayout.CENTER);
		
		JTextArea disclaimerTextArea = new JTextArea(disclaimer);
		disclaimerTextArea.setLineWrap(true);
		disclaimerTextArea.setWrapStyleWord(true);
		disclaimerTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(disclaimerTextArea);
		Dimension size = new Dimension(0, 50);
		scrollPane.setPreferredSize(size);
		add(scrollPane, BorderLayout.PAGE_END);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
	
	
	}
	
	public static void main(String[] arr)
	{
		
		try
		{
			//String className = UIManager.getCrossPlatformLookAndFeelClassName();
			String className = UIManager.getSystemLookAndFeelClassName();
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
