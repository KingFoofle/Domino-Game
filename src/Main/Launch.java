package Main;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class Launch {

	public static void main(String[] args) throws InterruptedException {
		// TODO: Dominoes repeat. Fix it
		JFrame frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		frame.setTitle("Dominoes!");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		Screen myCanvas = new Screen();
		
		frame.add(myCanvas);
		
		frame.setVisible(false);
		DominoTable test = new DominoTable(4);
		
		while (true) {
			frame.repaint();
			Thread.sleep(100);
		}
		


	}

}
