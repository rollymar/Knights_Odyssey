package system.mainmenu;


import system.select.GameCharSelectController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;


public class GameController implements ActionListener {
	private JFrame mainFrame;
	private JPanel gamePanel;
	private JLabel gameLabel;
	private JButton newGameBtn,loadGameBtn,exitBtn;

	private String fontName = "Monospaced";

	public GameController(JFrame mainFrame) {
		this.mainFrame = mainFrame;

		//Game Panel (Background)---------------------------------------------------
		gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    Image backgroundImage = ImageIO.read(new File("resources/images/Untitled-1 copy.jpg")); // Set the correct path
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
		GameView.addPanel(mainFrame, gamePanel, 0, 0, 600, 600);


		//Label---------------------------------------------------------------------
		gameLabel = new JLabel("KNIGHT'S ODYSSEY");
		GameView.addLabel(gameLabel,mainFrame,gamePanel,fontName,205,160,315,22,20);

		//Buttons-------------------------------------------------------------------
		newGameBtn = new JButton("New Game");
		GameView.addButton(newGameBtn,mainFrame,gamePanel,fontName,217,238,166,49,15);
		newGameBtn.addActionListener(this);

		loadGameBtn = new JButton("Load Game");
		GameView.addButton(loadGameBtn,mainFrame,gamePanel,fontName,217,300,166,49,15);

		exitBtn = new JButton("Exit");
		GameView.addButton(exitBtn,mainFrame,gamePanel,fontName,217,362,166,49,15);



		mainFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == newGameBtn) {
			GameView.clearFrame(mainFrame);
			new GameCharSelectController(mainFrame);
		}
	}
}