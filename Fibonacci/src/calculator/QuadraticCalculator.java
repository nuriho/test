package calculator;

import javax.swing.SwingUtilities;

public class QuadraticCalculator
{
	public static void main(String[] args)
	{
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuadraticFrame();
            }
        });
	}

}
