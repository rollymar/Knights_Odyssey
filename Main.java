import javax.swing.*;
import system.mainmenu.GameController;

class Main {
	public static void main(String[] args) {
		JFrame mainFrame = createMainFrame();
		new GameController(mainFrame);
	}

	static JFrame createMainFrame() {
		JFrame frame = new JFrame();
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		return frame;
	}
}