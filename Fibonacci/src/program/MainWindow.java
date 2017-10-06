package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainWindow
{

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNumber;
	private Fibonacci fib;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{		
		fib = new Fibonacci();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		JPanel labelPanel = new JPanel(new GridLayout(0,1));
		JPanel textPanel = new JPanel(new GridLayout(0,1));
		frame.getContentPane().add(labelPanel);
		frame.getContentPane().add(textPanel);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem fileItemExit = new JMenuItem("Exit");
		menuBar.add(fileMenu);
		fileMenu.add(fileItemExit);
		fileItemExit.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				WindowEvent windowClosing = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
				frame.dispatchEvent(windowClosing);
			}
		});
		frame.setJMenuBar(menuBar);
		
		JLabel lblEnterSequenceNumber = new JLabel("Enter Sequence Number", SwingConstants.CENTER);
		labelPanel.add(lblEnterSequenceNumber);
		
		lblNumber = new JLabel("Number", SwingConstants.CENTER);
		labelPanel.add(lblNumber);
		
		textField = new JTextField(10);
		textPanel.add(textField);
		
		JButton btnButtonName = new JButton("Button Name");
		textPanel.add(btnButtonName);
		btnButtonName.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				int num = fib.fib(Integer.parseInt(textField.getText()));
				lblNumber.setText( Integer.toString(num) );
			}
				});
		frame.pack();
	}

}
