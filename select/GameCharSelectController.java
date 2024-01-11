package system.select;

import system.mainmenu.GameController;
import system.dashboard.GameDashboardController;
import system.stats.GameStats;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class GameCharSelectController implements ActionListener {
	private JFrame mainFrame;
	private JPanel charSelectPanel;
	private JTextField charNameText;
	private JLabel nameLabel,selectRaceLabel,humanLabel,orcLabel,elfLabel;
	private JButton selectHumanBtn, selectOrcBtn, selectElfBtn, backBtn;

	private String fontName = "Monospaced";

	public GameCharSelectController(JFrame mainFrame) {
		this.mainFrame = mainFrame;

		//Panel----------------------------------------------------------------------
		charSelectPanel = new JPanel() {
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
		GameCharSelectView.addPanel(mainFrame,charSelectPanel,0,0,600,600);

		//TextField-------------------------------------------------------------------
		charNameText = new JTextField();
		GameCharSelectView.addText(charNameText, mainFrame, charSelectPanel, fontName,150,200,315,22,18);

		//Labels----------------------------------------------------------------------
		nameLabel = new JLabel("Name:");
		GameCharSelectView.addLabel(nameLabel,mainFrame,charSelectPanel,fontName,90,200,315,22,20);

		selectRaceLabel = new JLabel("Select Race");
		GameCharSelectView.addLabel(selectRaceLabel,mainFrame,charSelectPanel,fontName,90,250,315,22,20);

		humanLabel = new JLabel("<html>Human<br/>ATK: 12<br/>DEF: 11<br/>AGI: 9</html>", SwingConstants.CENTER);
		GameCharSelectView.addLabel(humanLabel,mainFrame,charSelectPanel,fontName,50,300,166,100,20);

		orcLabel = new JLabel("<html>Orc<br/>ATK: 15<br/>DEF: 16<br/> AGI: 5</html>", SwingConstants.CENTER);
		GameCharSelectView.addLabel(orcLabel,mainFrame,charSelectPanel,fontName,200,300,166,100,20);

		elfLabel = new JLabel("<html>Elf<br/>ATK: 12<br/>DEF: 8<br/>AGI: 14</html>", SwingConstants.CENTER);
		GameCharSelectView.addLabel(elfLabel,mainFrame,charSelectPanel,fontName,345,300,166,100,20);

		//Buttons----------------------------------------------------------------------
		selectHumanBtn = new JButton("Select");
		GameCharSelectView.addButton(selectHumanBtn,mainFrame,charSelectPanel,fontName,90,420,100,40,15);
		selectHumanBtn.addActionListener(this);

		selectOrcBtn = new JButton("Select");
		GameCharSelectView.addButton(selectOrcBtn,mainFrame,charSelectPanel,fontName,240,420,100,40,15);
		selectOrcBtn.addActionListener(this);

		selectElfBtn = new JButton("Select");
		GameCharSelectView.addButton(selectElfBtn,mainFrame,charSelectPanel,fontName,385,420,100,40,15);
		selectElfBtn.addActionListener(this);

		backBtn = new JButton("Back");
		GameCharSelectView.addButton(backBtn,mainFrame,charSelectPanel,fontName,10,10,100,40,15);
		backBtn.addActionListener(this);

		mainFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		GameStats stats = new GameStats();

		int baseHp = stats.hp + 10;


		if(event.getSource() == backBtn) {
			GameCharSelectView.clearFrame(mainFrame);
			new GameController(mainFrame);
		}else if(event.getSource() == selectHumanBtn) {
			
			//Human Stats--------------------------------
			int baseAtk = stats.atk + 12;
			int baseDef = stats.def + 11;
			int baseAgi = stats.agi + 9;
			String raceType = stats.race = "Human";
			String baseWeapon = stats.weapons = "";
			String baseArmour = stats.armour = "";

			String inputName = charNameText.getText();
			GameCharSelectView.clearFrame(mainFrame);
			new GameDashboardController(mainFrame, fontName, inputName, baseAtk, baseDef, baseAgi, raceType, baseHp, baseWeapon, baseArmour);

		}else if(event.getSource() == selectOrcBtn) {
			
			//Orc Stats--------------------------------
			int baseAtk = stats.atk + 15;
			int baseDef = stats.def + 16;
			int baseAgi = stats.agi + 5;
			String raceType = stats.race = "Orc";
			String baseWeapon = stats.weapons = "";
			String baseArmour = stats.armour = "";

			String inputName = charNameText.getText();
			GameCharSelectView.clearFrame(mainFrame);
			new GameDashboardController(mainFrame, fontName, inputName, baseAtk, baseDef, baseAgi, raceType, baseHp, baseWeapon, baseArmour);

		}else if(event.getSource() == selectElfBtn) {
			
			//Elf Stats--------------------------------
			int baseAtk = stats.atk + 12;
			int baseDef = stats.def + 8;
			int baseAgi = stats.agi + 14;
			String raceType = stats.race = "Elf";
			String baseWeapon = stats.weapons = "";
			String baseArmour = stats.armour = "";

			String inputName = charNameText.getText();
			GameCharSelectView.clearFrame(mainFrame);
			new GameDashboardController(mainFrame, fontName, inputName, baseAtk, baseDef, baseAgi, raceType, baseHp, baseWeapon, baseArmour);
		}
	}
}