package yaroslav.lavitskas.guessmycolor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import yaroslav.lavitskas.mycomponents.TitleLabel;

public class GuessMyColor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel samplePanel = new JPanel();
	private JPanel targetPanel = new JPanel();
	private int targetRed=0;
	private int targetGreen=0;
	private int targetBlue=0;
	private int red=0;
	private int green=0;
	private int blue=0;
	
	
	
	public GuessMyColor()
	{

		initGui();
		setTitle("Guess My Color");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		generateTargetColor();
		
	}
	
	private void initGui()
	{

		TitleLabel titleLabel = new TitleLabel("Guess My Color");
		add(titleLabel, BorderLayout.PAGE_START);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		add(centerPanel, BorderLayout.CENTER);
		
		Dimension size = new Dimension(50, 50);
		
		samplePanel.setBackground(Color.BLACK);
		samplePanel.setPreferredSize(size);
		centerPanel.add(samplePanel);
		
		
		targetPanel.setBackground(Color.CYAN);
		targetPanel.setPreferredSize(size);
		centerPanel.add(targetPanel);
		
		/*
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.RED);
		add(leftPanel, BorderLayout.LINE_START);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(Color.GREEN);
		add(rightPanel, BorderLayout.LINE_END);
		*/
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.BLACK);
		add(buttonPanel, BorderLayout.PAGE_END);
		
		JButton moreRedButton = new JButton("+");
		moreRedButton.setBackground(Color.red);
		moreRedButton.addActionListener(e -> 
		{
		increaseRed();
		updateColorSample();
		});
		buttonPanel.add(moreRedButton);
		
		JButton lessRedButton = new JButton("-");
		lessRedButton.setBackground(Color.red);
		lessRedButton.addActionListener(e -> 
		{
		decreaseRed();
		updateColorSample();
		});
		buttonPanel.add(lessRedButton);
		
		JButton moreGreenButton = new JButton("+");
		moreGreenButton.setBackground(Color.green);
		moreGreenButton.addActionListener(e -> 
		{
		increaseGreen();
		updateColorSample();
		});
		buttonPanel.add(moreGreenButton);
		
		JButton lessGreenButton = new JButton("-");
		lessGreenButton.setBackground(Color.green);
		lessGreenButton.addActionListener(e -> 
		{
			decreaseGreen();
			updateColorSample();
		});
		buttonPanel.add(lessGreenButton);
		
		JButton moreBlueButton = new JButton("+");
		moreBlueButton.setBackground(Color.blue);
		moreBlueButton.addActionListener(e -> 
		{
			increaseBlue();
			updateColorSample();
		});
		buttonPanel.add(moreBlueButton);
		
		JButton lessBlueButton = new JButton("-");
		lessBlueButton.setBackground(Color.blue);
		lessBlueButton.addActionListener(e -> 
		{
		decreaseBlue();
		updateColorSample();
		});
		buttonPanel.add(lessBlueButton);
		

		
		
	}
	
	private void updateColorSample()
	{
		Color color = new Color(red, green, blue);
		samplePanel.setBackground(color);
		if (red == targetRed && green == targetGreen && blue == targetBlue) 
		{
			String message = "Congratulations!";
			JOptionPane.showMessageDialog(this, message);
		}
	}
	
	private void increaseRed()
	{
		if (red<=240) red += 15;
	}
	
	private void decreaseRed()
	{
		if (red>=15) red -= 15;
	}
	
	private void increaseGreen()
	{
		if (green<=240) green += 15;
	}
	
	private void decreaseGreen()
	{
		if (green>=15) green -= 15;
	}
	
	private void increaseBlue()
	{
		if (blue<=240) blue += 15;
	}
	
	private void decreaseBlue()
	{
		if (blue>=15) blue -= 15;
	}
	
	private void generateTargetColor()
	{
		Random rand = new Random();
		this.targetRed=rand.nextInt(18)*15;
		this.targetGreen=rand.nextInt(18)*15;
		this.targetBlue=rand.nextInt(18)*15;
		Color targetColor = new Color(targetRed, targetGreen, targetBlue);
		targetPanel.setBackground(targetColor);
	}

	public static void main(String[] args) {
		try {
		String feellook = UIManager.getCrossPlatformLookAndFeelClassName();
		UIManager.setLookAndFeel(feellook);
		}
		catch (Exception e)
		{
			
		}
		
		EventQueue.invokeLater(new Runnable() {
			

			public void run() {
				new GuessMyColor();
				
			}
		});

	}
	
	
	

}
