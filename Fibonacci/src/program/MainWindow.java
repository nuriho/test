package program;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainWindow
{

	private JFrame frame;
	private Maze maze;

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
		maze = new Maze();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
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

		JTextArea label = new JTextArea(maze.toString());
		label.setSize(150, 50);
		label.setEditable(false);
		label.setCursor(null);
		label.setOpaque(false);
		label.setFocusable(false);
		label.setLineWrap(true);
		label.setWrapStyleWord(true);
		label.setFont(new Font("monospaced", Font.PLAIN, 12));

		frame.getContentPane().add(label);

//		frame.pack();
	}

}
