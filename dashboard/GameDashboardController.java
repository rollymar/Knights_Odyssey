	package system.dashboard;



	import system.mainmenu.GameController;
	import java.net.URL;
	import javax.swing.*;
	import java.util.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.io.IOException;
	import javax.imageio.ImageIO;
	import java.io.File;	
	import java.util.Timer;
	import java.util.TimerTask;
	import javax.sound.sampled.*;

	public class GameDashboardController implements ActionListener {

		protected int maxExp = 100;
		protected int level = 1;
    	protected int baseExp = 0;
    	protected int expOverValue = 100;
    	protected int maxHp;
    	protected int skeleDmg, mutantRatDmg;
    	protected String location = "Unknown";
    	protected String playerClassType = "None";
		protected int baseAtk, baseDef, baseAgi, baseHp, hpReduction, guardDamage, typingIndex;
		protected JFrame mainFrame;
		protected String fontName, inputName, raceType, baseWeapon, baseArmour, currentDialogue, musicDirectory;
		protected JPanel dashboardPanel, iconPanel, portraitPanel, statusPanel, statsPanel;
		protected JLabel playerName,atkLabel,defLabel,agiLabel, raceLabel, hpLabel, weaponLabel, armourLabel, typeOfclass, bodyStatusLabel, gifLabel, opponentHpLabel, levelLabel, expLabel, currentLocation;
		protected JButton talkBtn, runBtn, attackBtn, tauntBtn;
		protected JTextArea dialogueTextArea;
		protected Timer typingTimer;
    	protected Clip backgroundMusic;
    	protected Actions actionHandler;
    	protected JProgressBar expBar;
    	private Timer healTimer;
    	private PlayerManager playerManager;

		public GameDashboardController(JFrame mainFrame, String fontName, String inputName, int baseAtk, int baseDef, int baseAgi, String raceType, int baseHp, String baseWeapon, String baseArmour) {
			this.mainFrame = mainFrame;
			this.fontName = fontName;
			this.inputName = inputName;
			this.baseAtk = baseAtk;
			this.baseDef = baseDef;
			this.baseAgi = baseAgi;
			this.baseHp = baseHp;
			this.baseWeapon = baseWeapon;
			this.baseArmour = baseArmour;
			this.actionHandler = new Actions(this);
			this.playerManager = new PlayerManager(this);
			this.maxHp = baseHp;


			stopBackgroundMusic();
			System.out.println(baseHp);

			//Panel----------------------------------------------------------
			dashboardPanel = new  JPanel();
			GameDashboardView.addPanel(mainFrame, dashboardPanel,0,0,600,600);

			iconPanel = new JPanel();
        	GameDashboardView.addPanelIcon(iconPanel, dashboardPanel,460, 425, 100, 100);

        	statusPanel = new JPanel();
        	GameDashboardView.addStatusPanel(statusPanel, dashboardPanel,10,420,220,130);

        	statsPanel = new JPanel();
        	GameDashboardView.addStatusPanel(statsPanel, dashboardPanel,460,420,110,130);


        	UIManager.put("ProgressBar.background", Color.WHITE);
			UIManager.put("ProgressBar.foreground", Color.YELLOW);
			UIManager.put("ProgressBar.selectionBackground", Color.RED);
			UIManager.put("ProgressBar.selectionForeground", Color.GREEN);


        	expBar = new JProgressBar();
        	GameDashboardView.addJbar(expBar,statusPanel,10,110,200,15);
        	

			ImageIcon icon = new ImageIcon("resources/images/bgTest copy1.jpg");
			JLabel label = new JLabel(icon);
			label.setBounds(0,0,220,250);
			portraitPanel = new JPanel();
			portraitPanel.add(label);
			GameDashboardView.addPortraitPanel(portraitPanel, dashboardPanel, 10, 150, 220, 250);
        	

        	// Replace "your_gif.gif" with the actual path to your GIF file
			String absolutePath = "resources/images/Skull2.gif";
        	ImageIcon gifIcon = new ImageIcon(absolutePath);

        	if (gifIcon != null) {
            gifLabel = new JLabel(gifIcon);

            // Set layout manager for iconPanel
            iconPanel.setLayout(new FlowLayout());

            // Add the gifLabel to the iconPanel
            iconPanel.add(gifLabel);

            // Set iconPanel to be opaque
            iconPanel.setOpaque(true);

            // Make sure iconPanel and gifLabel are visible
            iconPanel.setVisible(false);
            gifLabel.setVisible(false);

            // Add iconPanel to the dashboardPanel
            dashboardPanel.add(iconPanel);

            // If you want the new component to be on top, you may not need to explicitly set Z order and repaint
            // dashboardPanel.setComponentZOrder(iconPanel, 0);
            // dashboardPanel.repaint();

            // Repaint the iconPanel to reflect changes
            iconPanel.repaint();
        	} else {
            System.out.println("Unable to load the GIF image.");
        	}
    

			//Labels---------------------------------------------------------
			playerName = new JLabel();
			playerName.setText(SetTextAndDirectories.NAME + String.valueOf(inputName));
			GameDashboardView.addLabelStatus(playerName, mainFrame, statusPanel, fontName, 10,0,250,30,15);

			raceLabel = new JLabel();
			raceLabel.setText(SetTextAndDirectories.RACE + String.valueOf(raceType));
			GameDashboardView.addLabelStatus(raceLabel,mainFrame,statusPanel,fontName,10,20,110,30,15);

			atkLabel = new JLabel();
			atkLabel.setText(SetTextAndDirectories.ATK + String.valueOf(baseAtk));
			GameDashboardView.addLabelStatus(atkLabel,mainFrame,statsPanel,fontName,10,30,300,30,15);

			defLabel = new JLabel();
			defLabel.setText(SetTextAndDirectories.DEF + String.valueOf(baseDef));
			GameDashboardView.addLabelStatus(defLabel,mainFrame,statsPanel,fontName,10,60,300,30,15);

			agiLabel = new JLabel();
			agiLabel.setText(SetTextAndDirectories.AGI + String.valueOf(baseAgi));
			GameDashboardView.addLabelStatus(agiLabel,mainFrame,statsPanel,fontName,10,90,300,30,15);

			hpLabel = new JLabel();
			hpLabel.setText(SetTextAndDirectories.HP + String.valueOf(baseHp) +"/"+String.valueOf(maxHp));
			GameDashboardView.addLabelStatus(hpLabel,mainFrame,statsPanel,fontName,10,0,250,30,15);

			weaponLabel = new JLabel();
			weaponLabel.setText(SetTextAndDirectories.WEAPON);
			GameDashboardView.addLabel(weaponLabel,mainFrame,dashboardPanel,fontName,10,0,200,30,15);

			armourLabel = new JLabel();
			armourLabel.setText(SetTextAndDirectories.ARMOUR);
			GameDashboardView.addLabel(armourLabel,mainFrame,dashboardPanel,fontName,10,20,300,30,15);

			typeOfclass = new JLabel();
			typeOfclass.setText(SetTextAndDirectories.CLASS + String.valueOf(playerClassType));
			GameDashboardView.addLabelStatus(typeOfclass,mainFrame,statusPanel,fontName,10,40,300,30,15);

			levelLabel = new JLabel();
			levelLabel.setText(SetTextAndDirectories.LEVEL + String.valueOf(level));
			GameDashboardView.addLabelStatus(levelLabel,mainFrame,statusPanel,fontName,10,60,300,30,15);

			expLabel = new JLabel();
			expLabel.setText(SetTextAndDirectories.EXP + String.valueOf(baseExp)+" / "+ String.valueOf(expOverValue));
			GameDashboardView.addLabelStatus(expLabel,mainFrame,statusPanel,fontName,10,80,300,30,15);

			currentLocation = new JLabel();
			currentLocation.setText(SetTextAndDirectories.LOCATION + location);
			GameDashboardView.addLabel(currentLocation,mainFrame,dashboardPanel,fontName,420,0,250,30,15);

			bodyStatusLabel = new JLabel();
			bodyStatusLabel.setText(SetTextAndDirectories.STATUS);
			GameDashboardView.addLabel(bodyStatusLabel,mainFrame,dashboardPanel,fontName,270, 515, 200, 30,15);


			//Dialogue TextArea--------------------------------------------
			dialogueTextArea = new JTextArea();
			GameDashboardView.addTextArea(dialogueTextArea,mainFrame,dashboardPanel,fontName,240,150,330,250,16);
			dialogueTextArea.setLineWrap(true);
        	dialogueTextArea.setWrapStyleWord(true);

			//Buttons------------------------------------------------------
			talkBtn = new JButton(Scripts.DEFAULT_ACTION1);
	        GameDashboardView.addButton(talkBtn, mainFrame, dashboardPanel, fontName, 240, 420, 100, 40, 15);
	        talkBtn.addActionListener(this);
	        

	        attackBtn = new JButton(Scripts.DEFAULT_ACTION2);
			GameDashboardView.addButton(attackBtn, mainFrame, dashboardPanel, fontName,240, 470, 100, 40,15);
			attackBtn.addActionListener(this);
			
			runBtn = new JButton(Scripts.DEFAULT_ACTION3);
			GameDashboardView.addButton(runBtn, mainFrame, dashboardPanel, fontName,350, 420, 100, 40,15);
			runBtn.addActionListener(this);

			tauntBtn = new JButton(Scripts.DEFAULT_ACTION4);
			GameDashboardView.addButton(tauntBtn, mainFrame, dashboardPanel, fontName,350, 470, 100, 40,15);
			tauntBtn.addActionListener(this);

			mainFrame.setVisible(true);
			typingTimer = new Timer();
        	
        	dialogue(Scripts.STRANGER);
        	disableAtkRunTauntBtn();
        	talkBtn.setText("Start");
        	
		}
	

 /*----------------------------------------------------------------------------------


	Other methods


 ------------------------------------------------------------------------------------*/

 	protected void stopBackgroundMusic() {
    if (backgroundMusic != null) {
        if (backgroundMusic.isRunning()) {
            backgroundMusic.stop();
        }
        backgroundMusic.close(); // Close the Clip
    }
	}

 	protected static Clip playMusicAsync(String filePath, int loops) {
    try {
        final Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File(filePath)));

        // Add a listener to stop the music when it finishes playing
        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                clip.close();
            }
        });

        // Start the music in a separate thread
        new Thread(() -> {
            clip.loop(loops);
            clip.start();
        }).start();

        return clip;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
	}

	protected void dialogue(String text) {
	    currentDialogue = text; // Set the initial text
	    typingIndex = 0;
	    startTypingEffect();
	}

	protected void startTypingEffect() {
	    if (typingTimer != null) {
	        // Timer exists, cancel it
	        typingTimer.cancel();
	    }

	    typingTimer = new Timer();

	    typingTimer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	            if (typingIndex <= currentDialogue.length()) {
	                String partialText = currentDialogue.substring(0, typingIndex);
	                dialogueTextArea.setText(partialText);
	                typingIndex++;
	            } else {
	                // Typing finished, cancel the timer
	                typingTimer.cancel();
	                showNextButton();  // Set timer to null after canceling
	            }
	        }
	    }, 0, 40); // Adjust the delay (0) and period (40) as needed
	}

	protected void showNextButton() {
	    talkBtn.setVisible(true);
	    attackBtn.setVisible(true);
	    runBtn.setVisible(true); // Make the "next" button visible
	    tauntBtn.setVisible(true);
	    mainFrame.revalidate();    // Revalidate the frame to update the layout
	    mainFrame.repaint();       // Repaint the frame to ensure the button is immediately visible    
	}

	protected void setBtnInvisible() {
		talkBtn.setVisible(false);
    	attackBtn.setVisible(false);
   		runBtn.setVisible(false);
   		tauntBtn.setVisible(false);
	}

	protected void disableRunTauntBtn() {
		runBtn.setEnabled(false);
        tauntBtn.setEnabled(false);
	}

	protected void disableAtkRunTauntBtn() {
		attackBtn.setEnabled(false);
		runBtn.setEnabled(false);
		tauntBtn.setEnabled(false);
	}

	protected void disableAtkandTauntBtn() {
		attackBtn.setEnabled(false);
		tauntBtn.setEnabled(false);
	}

	protected void enableBtns() {
		talkBtn.setEnabled(true);
		attackBtn.setEnabled(true);
		runBtn.setEnabled(true);
		tauntBtn.setEnabled(true);
	}

	// Method to load a new ImageIcon based on the file path
	protected ImageIcon loadNewImage(String imagePath) {
	    return new ImageIcon(imagePath);
	}

	// Method to update the portrait image
	protected void updatePortraitImage(ImageIcon newIcon) {
	    JLabel label = (JLabel) portraitPanel.getComponent(0); // Assuming the label is the first component
	    label.setIcon(newIcon);
	    portraitPanel.repaint();
	}	

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == talkBtn) {
            actionHandler.handleTalkButton();
        } else if (event.getSource() == attackBtn) {
            actionHandler.handleAttackButton();  	 
		} else if (event.getSource() == runBtn) {
			actionHandler.handleRunButton();
		} else if (event.getSource() == tauntBtn) {
			actionHandler.handleTauntButton();
		} 
	
	}
}