package system.mainmenu;


import javax.swing.*;
import java.awt.*;
import java.applet.*;

class GameView {

	static void addPanel(JFrame frame, JPanel panel, int y, int x, int width, int heigth) {
		panel.setBounds(x, y, width, heigth);
		panel.setLayout(null);

		frame.add(panel);
	}

	static void addLabel(JLabel label, JFrame frame, JPanel panel, String fontName, int x, int y, int width, int heigth, int fontSize) {
		label.setBounds(x,y,width,heigth);
		label.setForeground(Color.green);
		label.setFont(new Font(fontName, Font.PLAIN, fontSize));

		panel.add(label);

		frame.add(panel);
	}

	static void addButton(JButton button, JFrame frame, JPanel panel, String fontName, int x, int y, int width, int heigth, int fontSize) {
		button.setBounds(x,y,width,heigth);
		button.setFocusPainted(false);
		button.setFont(new Font(fontName, Font.PLAIN, fontSize));
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setBorder(BorderFactory.createLineBorder(Color.green));

		panel.add(button);

		frame.add(panel);
	}

	static void clearFrame(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
	}
}