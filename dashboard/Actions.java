package system.dashboard;

import system.mainmenu.GameController;
import system.dashboard.GameDashboardController;  
import system.dashboard.ConversationState;
import system.dashboard.ConversationStateAttack;
import system.dashboard.ConversationStateRun;
import system.dashboard.ConversationStateTaunt;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.util.Random;
import javax.swing.JOptionPane;


public class Actions extends PlayerManager {
    protected GameDashboardController controller;
    protected ConversationState conversationState = ConversationState.CASE1;
    protected ConversationStateAttack conversationStateAttack = ConversationStateAttack.CASE1;
    protected ConversationStateRun conversationStateRun = ConversationStateRun.CASE1;
    protected ConversationStateTaunt conversationStateTaunt = ConversationStateTaunt.CASE1;


    public Actions(GameDashboardController controller) {
        super(controller);
        this.controller = controller;
    }

    protected void locationSetterMethod() {
        controller.currentLocation.setText(SetTextAndDirectories.LOCATION + controller.location);
    }
  
    protected void handleCLericDialogues(String playerClass) {
    if (playerClass.equals(Scripts.C_MAGE)) {
        controller.dialogue(Scripts.D_CLERIC_MAGE);
    } 

    else if (playerClass.equals(Scripts.C_PALADIN)) {
        controller.dialogue(Scripts.D_CLERIC_PALADIN);
    }

    else if (playerClass.equals(Scripts.C_DRUID)) {
        controller.dialogue(Scripts.D_CLERIC_DRUID);
    }

    else if (playerClass.equals(Scripts.C_BARB)) {
        controller.dialogue(Scripts.D_CLERIC_BARBARIAN);
    }
    }

    protected void setInviMethod() {
        controller.setBtnInvisible();
    }

    protected void handleDeathMethod() {
        controller.dialogue(Scripts.RIP);
        controller.statsPanel.setVisible(false);
        controller.iconPanel.setVisible(true);
        controller.gifLabel.setVisible(true);
        controller.talkBtn.setText(Scripts.EXIT);
        controller.attackBtn.setText(Scripts.EXIT);
        controller.runBtn.setText(Scripts.EXIT);
        controller.tauntBtn.setText(Scripts.EXIT);
        controller.bodyStatusLabel.setText(SetTextAndDirectories.BODYSTATUSDEAD);
        conversationState = ConversationState.LOSER;
        conversationStateAttack = ConversationStateAttack.LOSER;
        conversationStateRun = ConversationStateRun.LOSER;
        conversationStateTaunt = ConversationStateTaunt.LOSER;
    }

    protected void handleSelectLocation() {
        controller.dialogue(controller.inputName+Scripts.A05);
        controller.talkBtn.setText(Scripts.CPT);
        controller.attackBtn.setText(Scripts.LIB);
        controller.runBtn.setText(Scripts.MAR);
        controller.tauntBtn.setText(Scripts.POR);
    }

    protected void btnResetMethod() {
        controller.talkBtn.setText(Scripts.DEFAULT_ACTION1);
        controller.attackBtn.setText(Scripts.DEFAULT_ACTION2);
        controller.runBtn.setText(Scripts.DEFAULT_ACTION3);
        controller.tauntBtn.setText(Scripts.DEFAULT_ACTION4);
    }

    protected void btnSetDungeons() {
        controller.talkBtn.setText(Scripts.L_SEWER);
        controller.attackBtn.setText(Scripts.L_FOREST);
        controller.runBtn.setText(Scripts.L_CRYPT);
        controller.tauntBtn.setText(Scripts.L_CORRUPTED_DUNGEON);
    }

    protected void btnSetNextMethod() {
        controller.disableAtkRunTauntBtn();
        controller.talkBtn.setText(Scripts.DIAGNEXT);
    }

    protected void btnTalkModification() {
        controller.talkBtn.setText(Scripts.DEFAULT_ACTION2);
        controller.runBtn.setText(Scripts.DEFAULT_ACTION3);
    }

    protected void btnSetBattleMode() {
        controller.talkBtn.setText(Scripts.DEFAULT_ACTION2);
        controller.runBtn.setText(Scripts.DEFAULT_ACTION3);
        controller.attackBtn.setText(Scripts.DEFAULT_ACTION_HEAL);
        controller.tauntBtn.setText(Scripts.DEFAULT_ACTION4);
    }

    protected void musicManagerMethod(String music){
        try {
            controller.backgroundMusic = controller.playMusicAsync(music, AudioSystem.getClip().LOOP_CONTINUOUSLY);
            } catch (LineUnavailableException e) {
                    e.printStackTrace();
            }     
    }



    public void handleTalkButton() {
        switch (conversationState) {
            case CASE1:
                setInviMethod();
                controller.enableBtns();
                controller.tauntBtn.setEnabled(false);
                btnResetMethod();
                controller.musicDirectory = SetTextAndDirectories.MUSICGALAN;
                musicManagerMethod(controller.musicDirectory);
                conversationState = ConversationState.CASE2;
                controller.dialogue(controller.inputName + Scripts.HELLO);

                ImageIcon newIcon = controller.loadNewImage(SetTextAndDirectories.IMAGETEST);
                controller.updatePortraitImage(newIcon);
                break;

            case CASE2:
                setInviMethod();
                conversationState = ConversationState.CASE3;
                controller.dialogue(Scripts.HI);
                break;

            case CASE3:
                setInviMethod();
                conversationState = ConversationState.CASE4;
                controller.dialogue(controller.inputName+Scripts.WHAT);
                break;

            case CASE4:
                setInviMethod();
                conversationState  = ConversationState.CASE5;
                controller.dialogue(Scripts.LOOK);
                break;

            case CASE5:
                setInviMethod();
                conversationState = ConversationState.CASE6;
                controller.dialogue(controller.inputName+Scripts.SORRY);
                break;
            
            case CASE6:
                setInviMethod();
                conversationState = ConversationState.CASE7;
                controller.dialogue(Scripts.MEAN);
                break;

            case CASE7:
                setInviMethod();
                conversationState = ConversationState.CASE8;
                controller.dialogue(controller.inputName+Scripts.NEED);
                break;

            case CASE8:
                setInviMethod();
                conversationState = ConversationState.CASE9;
                controller.dialogue(Scripts.HEY1+controller.inputName+Scripts.HEY2);
                break;

            case CASE9:
                setInviMethod();
                conversationState = ConversationState.CASE10;
                controller.dialogue(Scripts.WEIRD);
                break;

            case CASE10:
                setInviMethod();
                controller.disableRunTauntBtn();
                controller.stopBackgroundMusic();
                controller.musicDirectory = SetTextAndDirectories.MUSICBONE;
                musicManagerMethod(controller.musicDirectory);
                controller.dialogue(Scripts.SKULL);
                conversationState = ConversationState.CASE11;
                conversationStateAttack = ConversationStateAttack.MISTAKE1;

                ImageIcon newIcon1 = controller.loadNewImage(SetTextAndDirectories.IMAGETEST);
                controller.updatePortraitImage(newIcon1);
                break;

            case CASE11:
                setInviMethod();
                conversationState = ConversationState.CASE12;
                controller.dialogue(controller.inputName+Scripts.BONES);
                break;

            case CASE12:
                setInviMethod();
                controller.dialogue(Scripts.SKULL1);
                conversationState = ConversationState.CASE13;
                conversationStateAttack = ConversationStateAttack.MISTAKE1;
                break;

            case CASE13:
                setInviMethod();
                controller.dialogue(Scripts.WIZ);
                conversationState = ConversationState.CASE14;
                conversationStateAttack = ConversationStateAttack.CASE5;

                ImageIcon newIcon2 = controller.loadNewImage(SetTextAndDirectories.IMAGETEST);
                controller.updatePortraitImage(newIcon2);
                break;

            case CASE14:
                setInviMethod();
                controller.dialogue(Scripts.SKULL2);
                conversationState = ConversationState.CASE15;
                conversationStateAttack = ConversationStateAttack.MISTAKE1;

                ImageIcon newIcon3 = controller.loadNewImage(SetTextAndDirectories.IMAGETEST);
                controller.updatePortraitImage(newIcon3);
                break;

            case CASE15:
                setInviMethod();
                controller.dialogue(Scripts.WALKS);
                conversationState = ConversationState.CASE16;
                break;

            case CASE16:
                setInviMethod();
                controller.dialogue(Scripts.WIZ1); 
                conversationState = ConversationState.CASE17;
                conversationStateAttack = ConversationStateAttack.CASE6;

                ImageIcon newIcon4 = controller.loadNewImage(SetTextAndDirectories.IMAGETEST);
                controller.updatePortraitImage(newIcon4);
                break;

            case CASE17:
                setInviMethod();
                controller.enableBtns();
                controller.stopBackgroundMusic();
                controller.musicDirectory = SetTextAndDirectories.MUSICGALAN;
                musicManagerMethod(controller.musicDirectory);

                controller.dialogue(controller.inputName+Scripts.A01);
                conversationState = ConversationState.CASE18;
                break;  

            case CASE18:
                setInviMethod();
                controller.disableRunTauntBtn();
                controller.talkBtn.setText(Scripts.CHECK);
                controller.attackBtn.setText(Scripts.IGNORE);
                conversationState = ConversationState.CASE19;
                conversationStateAttack = ConversationStateAttack.CASE21;
                controller.dialogue(controller.inputName+Scripts.A02);
                break;

            case CASE19:
                setInviMethod();
                controller.talkBtn.setText(Scripts.TAKE);
                controller.attackBtn.setText(Scripts.THROW);
                conversationState = ConversationState.CASE20;
                controller.dialogue(controller.inputName+Scripts.A03);
                break;

            case CASE20:
                setInviMethod();
                btnResetMethod();
                controller.disableAtkRunTauntBtn();
                controller.talkBtn.setText(Scripts.DIAGNEXT);
                controller.dialogue(String.format(Scripts.A04));
                controller.baseWeapon = "Rusty Knife";
                conversationState = ConversationState.CASE21;
                controller.weaponLabel.setText(SetTextAndDirectories.WEAPON +String.valueOf(controller.baseWeapon));
                break;

            case CASE21:
                setInviMethod();
                controller.enableBtns();
                handleSelectLocation();
                conversationState = ConversationState.CASE22;
                conversationStateAttack = ConversationStateAttack.CASE8;
                conversationStateRun = ConversationStateRun.CASE3;
                conversationStateTaunt = ConversationStateTaunt.CASE2;
                break;

            case CASE22:
                setInviMethod();
                controller.dialogue(controller.inputName+Scripts.CAPITOL);
                controller.talkBtn.setText(Scripts.GD);
                controller.attackBtn.setText(Scripts.VEN);
                controller.runBtn.setText(Scripts.BARKY);
                controller.tauntBtn.setText(Scripts.CLE);
                conversationState = ConversationState.CASE23;
                conversationStateAttack = ConversationStateAttack.CASE9;
                conversationStateRun = ConversationStateRun.CASE4;
                conversationStateTaunt = ConversationStateTaunt.CASE1;
                break;  

            case CASE23:
                setInviMethod();
                controller.dialogue(controller.inputName+Scripts.GUARD);
                controller.location = Scripts.MER;
                locationSetterMethod();
                conversationStateTaunt = ConversationStateTaunt.CASE3;   
                break;

            case CASE24:
                setInviMethod();
                controller.disableAtkRunTauntBtn();
                controller.dialogue(Scripts.CLETALK);
                controller.talkBtn.setText(Scripts.PICK);
                controller.attackBtn.setText(Scripts.DEFAULT_ACTION2);
                controller.runBtn.setText(Scripts.DEFAULT_ACTION3);
                controller.tauntBtn.setText(Scripts.DEFAULT_ACTION4);
                conversationState = ConversationState.CASE25;
                break;

            case CASE25:
                setInviMethod();
                controller.enableBtns();
                controller.dialogue(Scripts.CLSS);
                controller.talkBtn.setText(Scripts.MAG);
                controller.runBtn.setText(Scripts.PAL);
                controller.attackBtn.setText(Scripts.DRU);
                controller.tauntBtn.setText(Scripts.BRB);
                conversationState = ConversationState.CASE26;
                conversationStateAttack = ConversationStateAttack.CASE10;
                conversationStateRun = ConversationStateRun.CASE5;
                conversationStateTaunt = ConversationStateTaunt.CASE4;
                break;

            case CASE26:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.dialogue(controller.inputName+Scripts.MAGECLASS);
                controller.playerClassType = Scripts.C_MAGE;
                controller.typeOfclass.setText(SetTextAndDirectories.CLASS + String.valueOf(controller.playerClassType));
                conversationState = ConversationState.CASE27;
                break;

            case CASE27:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.baseExp += 50;
                expCalculator(controller.baseExp, controller.expOverValue, controller.maxExp);
                controller.dialogue(Scripts.COMPLETE + Scripts.EXPUP50 + Scripts.NEWQUEST + Scripts.Q_DESTROY);
                conversationState = ConversationState.CASE28;
                break;

            case CASE28:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                handleCLericDialogues(controller.playerClassType);
                conversationState = ConversationState.CASE29;
                break;

            case CASE29:
                setInviMethod();
                btnSetDungeons();
                healPlayerMethod();
                controller.disableAtkRunTauntBtn();
                controller.dialogue(Scripts.D_SELECTION);
                conversationState = ConversationState.CASE30;
                conversationStateAttack = ConversationStateAttack.CASE11;
                conversationStateRun = ConversationStateRun.CASE6;
                conversationStateTaunt = ConversationStateTaunt.CASE5;
                break;

            //Dungeon-------------------------------------------------------------------                
            
            case CASE30:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.location = Scripts.L_SEWER;
                locationSetterMethod();
                controller.dialogue(Scripts.LD_SEWER + controller.inputName + Scripts.LD_SEWER_PLAYER_REACT);
                conversationState = ConversationState.CASE31;
                break;

            case CASE31:
                setInviMethod();
                btnResetMethod();
                btnTalkModification();
                controller.enableBtns();
                controller.disableAtkandTauntBtn();
                controller.dialogue(Scripts.LD_SEWER_SKELE);
                conversationState = ConversationState.CASE32;
                conversationStateRun = ConversationStateRun.CASESUB1;
                break;

            case CASE32:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                handleRandomItemDrop();
                controller.skeleDmg = 5;
                controller.baseExp+=30;
                expCalculator(controller.baseExp, controller.expOverValue, controller.maxExp);
                combatSystemMethod(controller.baseHp, controller.skeleDmg);
                controller.dialogue(Scripts.LD_SEWER_VICTORY);
                conversationState = ConversationState.CASE33;
                break;

            case CASE33:
                setInviMethod();
                btnResetMethod();
                btnTalkModification();
                controller.enableBtns();
                controller.disableAtkandTauntBtn();
                controller.dialogue(Scripts.LD_SEWER_RAT);
                conversationState = ConversationState.CASE34;
                conversationStateRun = ConversationStateRun.CASESUB1;
                break;

            case CASE34:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                handleRandomItemDrop();
                controller.mutantRatDmg = 5;
                controller.baseExp+=30;
                expCalculator(controller.baseExp, controller.expOverValue, controller.maxExp);
                combatSystemMethod(controller.baseHp, controller.mutantRatDmg);
                controller.dialogue(Scripts.LD_SEWER_VICTORY);
                conversationState = ConversationState.CASE35;
                break;

            case CASE35:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.disableAtkandTauntBtn();
                controller.dialogue(Scripts.LD_SEWER_TRAPPED);
                conversationState = ConversationState.CASE36;
                break;

            case CASE36:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.disableAtkandTauntBtn();
                controller.dialogue(controller.inputName + Scripts.LD_SEWER_PANIC);
                conversationState = ConversationState.CASE37;
                break;

            case CASE37:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.disableAtkandTauntBtn();
                controller.dialogue(controller.inputName + Scripts.HERE);
                conversationState = ConversationState.CASE38;
                break;

            case CASE38:
                setInviMethod();
                btnResetMethod();
                btnSetBattleMode();
                controller.enableBtns();
                controller.tauntBtn.setEnabled(false);
                controller.dialogue(Scripts.LD_SEWER_UNDEAD);
                conversationState = ConversationState.CASE39;
                conversationStateAttack = ConversationStateAttack.CASESUB1;
                conversationStateRun = ConversationStateRun.CASESUB1;
                break;

            case CASE39:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                handleRandomItemDrop();
                controller.mutantRatDmg = 8;
                controller.baseExp+=60;
                expCalculator(controller.baseExp, controller.expOverValue, controller.maxExp);
                combatSystemMethod(controller.baseHp, controller.mutantRatDmg);
                controller.dialogue(Scripts.LD_SEWER_VICTORY_UNDEADS);
                // Check for player death
                if (controller.baseHp == 0) {
                    conversationStateAttack = ConversationStateAttack.DEATH;
                    conversationState = ConversationState.DEATH;
                    conversationStateRun = ConversationStateRun.DEATH;
                    conversationStateTaunt = ConversationStateTaunt.DEATH;
                } else if (controller.level == 20) {
                    conversationState = ConversationState.CASE41;

                } else  {
                    conversationState = ConversationState.CASE40;
                }
                break;

            case CASE40:
                setInviMethod();
                btnSetBattleMode();
                controller.enableBtns();
                controller.tauntBtn.setEnabled(false);
                controller.dialogue(Scripts.LD_SEWER_UNDEAD_TYPE2);
                conversationState = ConversationState.CASE39;
                conversationStateAttack = ConversationStateAttack.CASESUB1;
                conversationStateRun = ConversationStateRun.CASESUB3;
                break;

            case CASE41:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.disableAtkandTauntBtn();
                controller.dialogue(controller.inputName + Scripts.LD_SEWER_PLAYER_REACTS_ELITES);
                conversationState = ConversationState.CASE42;
                break;

            case CASE42:

                break;

            case CASE43:

                break;

            case STOPPER:

                break;


            //Dugeon Events subBranch----------------------------------------------------
            case CASESUB1:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.dialogue(Scripts.NEW_SECTION);
                conversationState = ConversationState.CASE31;
                break;

            case CASESUB2:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.dialogue(Scripts.NEW_SECTION);
                conversationState = ConversationState.CASE40;
                break;

            case CASESUB3:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.dialogue(Scripts.NEW_SECTION);
                conversationState = ConversationState.CASE40;
                break;

             //SubBranch-----------------------------------------------------------------
            
             case CASE1_1:
                setInviMethod();
                conversationState = ConversationState.CASE1_2;
                controller.dialogue(Scripts.A06);
                break;

            case CASE1_2:
                setInviMethod();
                conversationState = ConversationState.CASE1_3;
                controller.dialogue(Scripts.A07);
                break;

            case CASE1_3:
                setInviMethod();
                controller.guardDamage = 25;
                combatSystemMethod(controller.baseHp, controller.guardDamage);
                controller.statsPanel.setVisible(false);
                controller.iconPanel.setVisible(true);
                controller.gifLabel.setVisible(true);
                controller.bodyStatusLabel.setText(SetTextAndDirectories.BODYSTATUSDEAD);
                controller.dialogue(Scripts.A08);
                break;

            case DEATH:
                setInviMethod();
                handleDeathMethod();
                break;

            case LOSER:
                controller.stopBackgroundMusic();
                GameDashboardView.clearFrame(controller.mainFrame);
                new GameController(controller.mainFrame);
                break;      

            default:
                controller.dialogue(Scripts.DEF);
                break;
        }
    }

    public void handleAttackButton() {
    switch (conversationStateAttack) {
            case CASE1:
                setInviMethod();
                controller.stopBackgroundMusic();
                controller.musicDirectory = SetTextAndDirectories.MUSICBONE;
                musicManagerMethod(controller.musicDirectory);
                conversationState = ConversationState.CASE1_1;
                conversationStateAttack = ConversationStateAttack.CASE2;
                controller.dialogue(Scripts.A09);

            break;

            case CASE2:
                setInviMethod();
                conversationState = ConversationState.CASE1_1;
                conversationStateAttack = ConversationStateAttack.CASE3;
                controller.baseHp-=2;
                System.out.println(controller.baseHp);
                controller.hpLabel.setText(SetTextAndDirectories.HP + String.valueOf(controller.baseHp));
                controller.dialogue(Scripts.A10);
                break;

            case CASE3:
                setInviMethod();
                conversationStateAttack = ConversationStateAttack.CASE4;
                controller.dialogue(Scripts.A11);
                break;

            case CASE4:
                setInviMethod();
                controller.dialogue(Scripts.A12);
                controller.baseExp += 100;
                expCalculator(controller.baseExp, controller.expOverValue, controller.maxExp);
                conversationState = ConversationState.CASE1_3;
                conversationStateAttack = ConversationStateAttack.CASE7;
                break;


            case MISTAKE1:
                setInviMethod();
                controller.stopBackgroundMusic();
                controller.musicDirectory = SetTextAndDirectories.MUSICBONE;
                musicManagerMethod(controller.musicDirectory);
                controller.dialogue(Scripts.SKULL3);
                controller.bodyStatusLabel.setText(SetTextAndDirectories.BODYSTATUSDEAD);
                controller.statsPanel.setVisible(false);
                controller.iconPanel.setVisible(true);
                controller.gifLabel.setVisible(true);
                conversationState = ConversationState.DEATH;    
                conversationStateAttack = ConversationStateAttack.DEATH;
                conversationStateRun = ConversationStateRun.DEATH;
                conversationStateTaunt = ConversationStateTaunt.DEATH;
                break;    

            case CASE5:
                setInviMethod();
                controller.dialogue(Scripts.A13);
                conversationState = ConversationState.CASE13;
            break;

            case CASE6:
                setInviMethod();
                controller.dialogue(Scripts.A14);
                conversationState = ConversationState.CASE16;
            break;

            case CASE7:
                setInviMethod();
                controller.dialogue(controller.inputName+Scripts.A15);
            break;


            case CASE8:
                setInviMethod();
                controller.dialogue(controller.inputName+Scripts.IDONO);
            break;

            case CASE9:
                setInviMethod();
                controller.dialogue(controller.inputName+Scripts.VENDOR);
                break;

            case CASE10:
                setInviMethod();
                btnResetMethod();
                controller.disableAtkRunTauntBtn();
                controller.talkBtn.setText(Scripts.DIAGNEXT);
                controller.dialogue(controller.inputName+Scripts.DRUIDCLASS);
                controller.playerClassType = Scripts.C_DRUID;
                controller.typeOfclass.setText(SetTextAndDirectories.CLASS + String.valueOf(controller.playerClassType));
                conversationState = ConversationState.CASE27;
                break;

            //Dugeon-----------------------------------------------------------------------

            case CASE11:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.location = Scripts.L_FOREST;
                locationSetterMethod();
                controller.dialogue(Scripts.LD_FOREST + controller.inputName + Scripts.LD_FOREST_PLAYER_REACT);
                break;

            //Dungeon Events SubBranch------------------------------------------------------
            case CASESUB1:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                healPlayerMethod();
                controller.dialogue(Scripts.HEALED);
                conversationState = ConversationState.CASESUB2;
                break;

            case CASE21:
                setInviMethod();
                handleSelectLocation();
                conversationState = ConversationState.CASE22;
                conversationStateAttack = ConversationStateAttack.CASE8;
                conversationStateRun = ConversationStateRun.CASE3;
                conversationStateTaunt = ConversationStateTaunt.CASE2;
            break;

            case DEATH:
                setInviMethod();
                handleDeathMethod();
                break;

            case LOSER:
                controller.stopBackgroundMusic();
                GameDashboardView.clearFrame(controller.mainFrame);
                new GameController(controller.mainFrame);
            break;  

            case STOPPER:

                break;

            default:
                controller.dialogue(Scripts.DEF);
                break;
            } 
    }

    public void handleRunButton() {
        switch(conversationStateRun) {

        case CASE1:
            setInviMethod();
            handleSelectLocation();
            controller.tauntBtn.setEnabled(true);
            conversationState = ConversationState.CASE22;
            conversationStateAttack = ConversationStateAttack.CASE8;
            conversationStateRun = ConversationStateRun.CASE3;
            conversationStateTaunt = ConversationStateTaunt.CASE2;
            break;

        case CASE3:
            setInviMethod();
            controller.dialogue(controller.inputName+Scripts.IDONO);
            break;

        case CASE4:
            setInviMethod();
            int dogDmg = 1;
            controller.dialogue(Scripts.DOG + controller.inputName + Scripts.PAIN);
            combatSystemMethod(controller.baseHp, dogDmg);
            break; 

        case CASE5:
            setInviMethod();
            btnResetMethod();
            controller.disableAtkRunTauntBtn();
            controller.talkBtn.setText(Scripts.DIAGNEXT);
            controller.dialogue(controller.inputName+Scripts.PALADCLASS);
            controller.playerClassType = Scripts.C_PALADIN;
            controller.typeOfclass.setText(SetTextAndDirectories.CLASS + String.valueOf(controller.playerClassType));
            conversationState = ConversationState.CASE27;
            break;


        //Dungeon--------------------------------------------------------------------------------------
        case CASE6:
            setInviMethod();
            btnResetMethod();
            btnSetNextMethod();
            controller.location = Scripts.L_CRYPT;
            locationSetterMethod();
            controller.dialogue(Scripts.LD_CRYPT + controller.inputName + Scripts.LD_CRYPT_PLAYER_REACT);
            break;    


        case CASESUB1:
            setInviMethod();
            btnResetMethod();
            btnSetNextMethod();
            controller.dialogue(Scripts.RAN);
            conversationState = ConversationState.CASESUB1;
            break;    

        case DEATH:
            setInviMethod();
            handleDeathMethod();
            break;

        case LOSER:
            controller.stopBackgroundMusic();
            GameDashboardView.clearFrame(controller.mainFrame);
            new GameController(controller.mainFrame);
            break;       

        case STOPPER:

            break;

            default:
                controller.dialogue(Scripts.DEF);
                break;

        }
    }

    public void handleTauntButton() {
        switch (conversationStateTaunt) {
            case CASE1:
                setInviMethod();
                controller.disableAtkRunTauntBtn();
                controller.dialogue(controller.inputName+Scripts.CLERIC);
                controller.talkBtn.setText(Scripts.HELP);
                controller.runBtn.setText(Scripts.DEFAULT_ACTION3);
                controller.attackBtn.setText(Scripts.DEFAULT_ACTION2);
                controller.tauntBtn.setText(Scripts.DEFAULT_ACTION4);
                conversationState = ConversationState.CASE24;
                break;

            case CASE2:
                setInviMethod();
                controller.dialogue(controller.inputName+Scripts.IDONO);
                break;    

            case CASE3:
                setInviMethod();
                controller.disableAtkRunTauntBtn();
                controller.dialogue(controller.inputName+Scripts.CLEQ);
                controller.baseExp += 50;
                expCalculator(controller.baseExp, controller.expOverValue, controller.maxExp);
                controller.talkBtn.setText(Scripts.HELP);
                controller.runBtn.setText(Scripts.DEFAULT_ACTION3);
                controller.attackBtn.setText(Scripts.DEFAULT_ACTION2);
                controller.tauntBtn.setText(Scripts.DEFAULT_ACTION4);
                conversationState = ConversationState.CASE24;
                break;

            case CASE4:
                setInviMethod();
                btnResetMethod();
                controller.disableAtkRunTauntBtn();
                controller.talkBtn.setText(String.format(Scripts.DIAGNEXT));
                controller.dialogue(controller.inputName+String.format(Scripts.BARBCLASS));
                controller.playerClassType = Scripts.C_BARB;
                controller.typeOfclass.setText(SetTextAndDirectories.CLASS + String.valueOf(controller.playerClassType));
                conversationState = ConversationState.CASE27;
                break;


             //Dungeon--------------------------------------------------------------------------------------------------------------   
            case CASE5:
                setInviMethod();
                btnResetMethod();
                btnSetNextMethod();
                controller.location = Scripts.LD_CORRUPTED_DUNGEON;
                locationSetterMethod();
                controller.dialogue(Scripts.LD_CORRUPTED_DUNGEON + controller.inputName + Scripts.LD_CORRUPTED_DUNGEON_PLAYER_REACT);
                break; 


            case DEATH:
                setInviMethod();
                handleDeathMethod();
                break;

            case LOSER:
                controller.stopBackgroundMusic();
                GameDashboardView.clearFrame(controller.mainFrame);
                new GameController(controller.mainFrame);
                break;   

            case STOPPER:
                // Handle STOPPER case
                break;
            default:
                controller.dialogue(Scripts.DEF);
                break;
        }
    }

    private Clip getClip() {
        try {
            return AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return null;
        }
    }

}
