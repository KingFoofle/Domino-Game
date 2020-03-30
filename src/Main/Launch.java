package Main;

import java.awt.Toolkit;
import javax.swing.JFrame;

public class Launch {

	public static void main(String[] args) throws InterruptedException {
		// TODO: Dominoes repeat. Fix it
		JFrame frame = new JFrame();
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
		frame.setTitle("Dominoes!");
		
		// When we click "X" , close the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Can't resize if false
		frame.setResizable(false);
		
		// Init my canvas
		Screen myCanvas = new Screen();
		
		// Add my created canvas to the frame
		frame.add(myCanvas);
		
		// Make the screen visible
		frame.setVisible(false);
		DominoTable test = new DominoTable(4);

		test.spreadDominoes();
		
		System.out.println(test.getPlayers()[0].getHand());
		
		while (true) {
			frame.repaint();
			Thread.sleep(100);
		}
		


	}

}
