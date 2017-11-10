package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class QuadraticFrame
{
	private JTextField aTextField;
	private JTextField bTextField;
	private JTextField cTextField;
	private JButton calculateButton;
	private String pattern = "-?\\d+(\\.\\d+)?";
	private boolean aIsValid = true;
	private boolean bIsValid = true;
	private boolean cIsValid = true;

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
		JTextField xPText = new JTextField("0", 12);
		xPText.setEditable(false);
		JTextField xNText = new JTextField("0", 12);
		xNText.setEditable(false);

		aTextField = new JTextField("0", 12);
		aTextField.getDocument().addDocumentListener(new AFieldListener());
		bTextField = new JTextField("0", 12);
		bTextField.getDocument().addDocumentListener(new BFieldListener());
		cTextField = new JTextField("0", 12);
		cTextField.getDocument().addDocumentListener(new CFieldListener());

		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				double a = Double.parseDouble(aTextField.getText());
				double b = Double.parseDouble(bTextField.getText());
				double c = Double.parseDouble(cTextField.getText());
				double[] x = QuadraticEquation.solve(a, b, c);

				xPText.setText(String.format("%1f", x[0]));
				xNText.setText(String.format("%1f", x[1]));
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(calculateButton);

		JPanel xPanel = new JPanel();
		xPanel.setLayout(new GridLayout(2, 2));
		xPanel.add(xPLabel);
		xPanel.add(xNLabel);
		xPanel.add(xPText);
		xPanel.add(xNText);

		JPanel labelTextPanel = new JPanel();
		labelTextPanel.setLayout(new GridLayout(2, 4));

		labelTextPanel.add(aLabel);
		labelTextPanel.add(bLabel);
		labelTextPanel.add(cLabel);

		labelTextPanel.add(aTextField);
		labelTextPanel.add(bTextField);
		labelTextPanel.add(cTextField);

		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(equation, BorderLayout.PAGE_START);
		mainFrame.add(xPanel, BorderLayout.PAGE_END);
		mainFrame.add(labelTextPanel, BorderLayout.CENTER);
		mainFrame.add(buttonPanel, BorderLayout.LINE_END);

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	private boolean CanCalculate()
	{
		if (aIsValid && bIsValid && cIsValid)
			return true;
		return false;
	}
	
	private void setButtonEnabledIfValid()
	{
		calculateButton.setEnabled(CanCalculate());
	}

	private class AFieldListener implements DocumentListener
	{

		@Override
		public void changedUpdate(DocumentEvent e)
		{
			// not needed for plain text field
		}

		@Override
		public void insertUpdate(DocumentEvent e)
		{
			validateInputA();
			setButtonEnabledIfValid();
		}

		@Override
		public void removeUpdate(DocumentEvent e)
		{
			validateInputA();
			setButtonEnabledIfValid();
		}

		private void validateInputA()
		{
			String aText = aTextField.getText();
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(aText);
			if (m.matches())
			{
				aTextField.setForeground(Color.BLACK);
				aIsValid = true;
			} else
			{
				aTextField.setForeground(Color.RED);
				aIsValid = false;
			}
		}
	}

	private class BFieldListener implements DocumentListener
	{

		@Override
		public void changedUpdate(DocumentEvent e)
		{
			// not needed for plain text field
		}

		@Override
		public void insertUpdate(DocumentEvent e)
		{
			validateInputB();
			setButtonEnabledIfValid();
		}

		@Override
		public void removeUpdate(DocumentEvent e)
		{
			validateInputB();
			setButtonEnabledIfValid();
		}

		private void validateInputB()
		{
			String bText = bTextField.getText();
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(bText);
			if (m.matches())
			{
				bTextField.setForeground(Color.BLACK);
				bIsValid = true;
			} else
			{
				bTextField.setForeground(Color.RED);
				bIsValid = false;
			}
		}
	}

	private class CFieldListener implements DocumentListener
	{

		@Override
		public void changedUpdate(DocumentEvent e)
		{
			// not needed for plain text field
		}

		@Override
		public void insertUpdate(DocumentEvent e)
		{
			validateInputC();
			setButtonEnabledIfValid();
		}

		@Override
		public void removeUpdate(DocumentEvent e)
		{
			validateInputC();
			setButtonEnabledIfValid();
		}

		private void validateInputC()
		{
			String cText = cTextField.getText();
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(cText);
			if (m.matches())
			{
				cTextField.setForeground(Color.BLACK);
				cIsValid = true;
			} else
			{
				cTextField.setForeground(Color.RED);
				cIsValid = false;
			}
		}
	}
}
