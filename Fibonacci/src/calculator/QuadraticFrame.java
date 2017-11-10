package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuadraticFrame
{
	public QuadraticFrame()
	{
		JFrame mainFrame = new JFrame("Quadratic Equation Calculator");
		
		JLabel equation = new JLabel("x = ( -b +/- sqrt(b^2 - 4ac) ) / 2a");
		equation.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel xPLabel = new JLabel("+X");
		xPLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel xNLabel = new JLabel("-X");
		xNLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel aLabel = new JLabel("A");
		aLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel bLabel = new JLabel("B");
		bLabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel cLabel = new JLabel("C");
		cLabel.setHorizontalAlignment(JLabel.CENTER);
		JTextField xPText = new JTextField(12);
		xPText.setEditable(false);
		JTextField xNText = new JTextField(12);
		xNText.setEditable(false);

		JTextField aText = new JTextField(12);
		JTextField bText = new JTextField(12);
		JTextField cText = new JTextField(12);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				double a = Double.parseDouble(aText.getText());
				double b = Double.parseDouble(bText.getText());
				double c = Double.parseDouble(cText.getText());
				double[] x = QuadraticEquation.solve(a, b, c);

				xPText.setText(String.format("%1f", x[0]));
				xNText.setText(String.format("%1f", x[1]));
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(calculateButton);
		
		JPanel xPanel = new JPanel();
		xPanel.setLayout(new GridLayout(2,2));
		xPanel.add(xPLabel);
		xPanel.add(xNLabel);
		xPanel.add(xPText);
		xPanel.add(xNText);
		
		JPanel labelTextPanel = new JPanel();
		labelTextPanel.setLayout(new GridLayout(2,4));
		
		labelTextPanel.add(aLabel);
		labelTextPanel.add(bLabel);
		labelTextPanel.add(cLabel);
		
		labelTextPanel.add(aText);
		labelTextPanel.add(bText);
		labelTextPanel.add(cText);
		
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(equation, BorderLayout.PAGE_START);
		mainFrame.add(xPanel, BorderLayout.PAGE_END);
		mainFrame.add(labelTextPanel, BorderLayout.CENTER);
		mainFrame.add(buttonPanel, BorderLayout.LINE_END);
		
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

}
