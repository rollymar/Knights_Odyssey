package system.select;

import javax.swing.*;
import java.awt.*;

class GameCharSelectView {

	static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int heigth) {
		panel.setBounds(x,y,width,heigth);
		panel.setLayout(null);
		panel.setBackground(Color.black);

		frame.add(panel);
	}

	static void addText(JTextField text, JFrame frame, JPanel panel, String fontName, int x, int y, int width, int heigth, int fontSize) {
		text.setBounds(x,y,width,heigth);
		text.setBackground(Color.black);
		text.setForeground(Color.white);
		text.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.green));
		text.setFont(new Font(fontName, Font.PLAIN, fontSize));

		panel.add(text);

		frame.add(panel);
	}

	static void addLabel(JLabel label, JFrame frame, JPanel panel, String fontName, int x, int y, int width, int heigth, int fontSize) {
		label.setBounds(x,y,width,heigth);
		label.setFont(new Font(fontName, Font.PLAIN, fontSize));
		label.setForeground(Color.green);

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