package system.dashboard;

import javax.swing.*;
import java.awt.*;


class GameDashboardView {

	static void addJbar(JProgressBar bar, JPanel statusPanel, int x , int y, int width, int heigth) {
		bar.setBounds(x,y,width,heigth);
		bar.setBorder(BorderFactory.createLineBorder(Color.white));
		statusPanel.add(bar);
	}



	static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int heigth) {
		panel.setBounds(x,y,width,heigth);
		panel.setLayout(null);
		panel.setBackground(Color.black);

		frame.add(panel);
	}

	static void addLabel(JLabel label, JFrame frame, JPanel panel, String fontName, int x, int y, int width, int heigth, int fontSize) {
		label.setBounds(x,y,width,heigth);
		label.setFont(new Font(fontName, Font.PLAIN, fontSize));
		label.setForeground(Color.green);


		panel.add(label);

		frame.add(panel);
	}


	static void addLabelStatus(JLabel label, JFrame frame, JPanel statusPanel,  String fontName, int x, int y, int width, int heigth, int fontSize) {
		label.setBounds(x,y,width,heigth);
		label.setFont(new Font(fontName, Font.PLAIN, fontSize));
		label.setForeground(Color.green);

		statusPanel.add(label);
	}

	static void addTextArea(JTextArea textArea, JFrame frame, JPanel panel, String fontName, int x, int y, int width, int heigth, int fontSize) {
		textArea.setBounds(x,y,width,heigth);
		textArea.setFont(new Font(fontName, Font.PLAIN, fontSize));
		textArea.setForeground(Color.white);
		textArea.setBackground(Color.black);
		textArea.setBorder(BorderFactory.createLineBorder(Color.white));
		textArea.setEditable(false);

		panel.add(textArea);

		frame.add(panel);
	}

	static void addText(JTextField text, JFrame frame, JPanel panel, String fontName, int x, int y, int width, int heigth, int fontSize) {
		text.setBounds(x,y,width,heigth);
		text.setBackground(Color.black);
		text.setForeground(Color.green);
		text.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white));
		text.setFont(new Font(fontName, Font.PLAIN, fontSize));

		panel.add(text);

		frame.add(panel);
	}

	static void addButton(JButton button, JFrame frame, JPanel panel, String fontName, int x, int y, int width, int heigth, int fontSize) {
		button.setBounds(x,y,width,heigth);
		button.setFocusPainted(false);
		button.setFont(new Font(fontName, Font.PLAIN, fontSize));
		button.setBackground(Color.black);
		button.setForeground(Color.green);
		button.setBorder(BorderFactory.createLineBorder(Color.white));

		panel.add(button);

		frame.add(panel);
	}



	static void addPanelIcon(JPanel iconPanel, JPanel panel, int x, int y, int width, int heigth) {
		iconPanel.setBounds(x,y,width,heigth);
		iconPanel.setLayout(null);
		iconPanel.setBackground(Color.black);


		panel.add(iconPanel);
	}


	static void addPortraitPanel(JPanel portraitPanel, JPanel panel, int x, int y, int width, int heigth) {
		portraitPanel.setBounds(x,y,width,heigth);
		portraitPanel.setLayout(null);
		portraitPanel.setBackground(Color.black);


		panel.add(portraitPanel);
	}


	static void addStatusPanel(JPanel statusPanel, JPanel panel, int x, int y, int width, int heigth) {
		statusPanel.setBounds(x,y,width,heigth);
		statusPanel.setLayout(null);
		statusPanel.setBackground(Color.black);
		statusPanel.setBorder(BorderFactory.createLineBorder(Color.white));

		panel.add(statusPanel);
	}


	static void clearFrame(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.revalidate();
		frame.repaint();
	}
}