package system.dashboard;

import javax.swing.JOptionPane;
import java.util.Random;
import system.dashboard.SetTextAndDirectories;
import system.dashboard.GameDashboardController;
import system.dashboard.ConversationState;
import system.dashboard.ConversationStateAttack;
import system.dashboard.ConversationStateRun;
import system.dashboard.ConversationStateTaunt;
import system.dashboard.Scripts;


public class PlayerManager {
	protected GameDashboardController controller;
	protected ConversationStateAttack conversationStateAttack;
    protected ConversationState conversationState;
    protected ConversationStateRun conversationStateRun;
    protected ConversationStateTaunt conversationStateTaunt;

	public PlayerManager(GameDashboardController controller) {
		this.controller = controller;
	}

	  protected void expCalculator(int baseExp, int expOverValue, int maxExp) {
    if (baseExp >= expOverValue) {
        // Level up logic
        controller.expOverValue *= 2;
        controller.baseExp = 0;
        controller.level++;
        controller.expBar.setMaximum(controller.expOverValue);

        // Increase maxHp when leveling up
        controller.maxHp += 5;

        // Restore HP to full when leveling up
        controller.baseHp = controller.maxHp;

        controller.maxExp *= 2;
        controller.baseAtk++;
        controller.baseDef++;
        controller.baseAgi++;

        // Display a JOptionPane to inform the player about the level up and increased stats
        String levelUpMessage = String.format("Congratulations! You leveled up to Level %d.\n\n"
                + "Stats Increased:\n"
                + "  - HP: +%d\n"
                + "  - ATK: +1\n"
                + "  - DEF: +1\n"
                + "  - AGI: +1", controller.level, 5);
        JOptionPane.showMessageDialog(null, levelUpMessage, "Level Up", JOptionPane.INFORMATION_MESSAGE);
        // Update UI with new stats
        updateUIWithStats();
    } else {
        // Update UI labels for normal experience gain
        controller.expBar.setValue(controller.baseExp);
        controller.expLabel.setText(SetTextAndDirectories.EXP + String.valueOf(controller.baseExp) + " / " + "<html><font color='#FFFF00'> " + String.valueOf(controller.expOverValue));
    }
}   
    protected void healPlayerMethod() {
        controller.baseHp = controller.maxHp;
        controller.hpLabel.setText(SetTextAndDirectories.HP + String.valueOf(controller.baseHp)+"/"+String.valueOf(controller.maxHp));
    }

    protected void updateUIWithStats() {
        // Update UI labels with new stats
        controller.expBar.setValue(controller.baseExp);
        controller.expLabel.setText(SetTextAndDirectories.EXP + String.valueOf(controller.baseExp) + " / " + "<html><font color='#FFFF00'> " + String.valueOf(controller.expOverValue));
        controller.levelLabel.setText(SetTextAndDirectories.LEVEL + String.valueOf(controller.level));
        controller.atkLabel.setText(SetTextAndDirectories.ATK + String.valueOf(controller.baseAtk));
        controller.defLabel.setText(SetTextAndDirectories.DEF + String.valueOf(controller.baseDef));
        controller.agiLabel.setText(SetTextAndDirectories.AGI + String.valueOf(controller.baseAgi));
        controller.hpLabel.setText(SetTextAndDirectories.HP + String.valueOf(controller.baseHp)+"/"+String.valueOf(controller.maxHp));
    }


    protected void combatSystemMethod(int baseHp, int enemyDamage) {
        controller.baseHp = Math.max(0, baseHp - enemyDamage);
        controller.hpLabel.setText(SetTextAndDirectories.HP + String.valueOf(controller.baseHp)+"/"+String.valueOf(controller.maxHp));

        if(controller.baseHp <= 0) {
            conversationStateAttack = ConversationStateAttack.DEATH;
            conversationState = ConversationState.DEATH;
            conversationStateRun = ConversationStateRun.DEATH;
            conversationStateTaunt = ConversationStateTaunt.DEATH;
        }
    }

   protected void handleRandomItemDrop() {
    // Check if a random item should drop
    if (shouldDropItem()) {
        String droppedItem = getRandomItem();
        controller.dialogue("The monster dropped: " + droppedItem);

        // Ask the player if they want to pick up the item
        int choice = JOptionPane.showOptionDialog(
                null,
                "Do you want to pick up the " + droppedItem + "?",
                "Item Drop",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );

        // Update the appropriate inventory (weapon or armor) based on the player's choice
        if (choice == JOptionPane.YES_OPTION) {
            if (droppedItem.equals("Sword") || droppedItem.equals("Axe") || droppedItem.equals("Bow") || droppedItem.equals("Staff") || droppedItem.equals("Dagger")) {
                controller.baseWeapon = droppedItem;
                controller.dialogue("You picked up the " + droppedItem);
                controller.weaponLabel.setText(SetTextAndDirectories.WEAPON + controller.baseWeapon);
            } else {
                controller.baseArmour = droppedItem;
                controller.dialogue("You picked up the " + droppedItem);
                controller.armourLabel.setText(SetTextAndDirectories.ARMOUR + controller.baseArmour);
            }
        } else {
            controller.dialogue("You ignored the " + droppedItem);
        }
    }
}

    protected boolean shouldDropItem() {
        // Use a random chance to determine if an item should drop
        Random random = new Random();
        double dropChance = 20; // Adjust this value based on desired drop probability (e.g., 20% chance)
        return random.nextDouble() <= dropChance;
    }

    protected String getRandomItem() {
        // Implement logic to select a random item
        String[] possibleItems = {"Sword", "Axe", "Bow", "Staff", "Dagger", "Helmet", "Chestplate", "Leggings", "Boots"};
        Random random = new Random();
        int randomIndex = random.nextInt(possibleItems.length);
        return possibleItems[randomIndex];
    }

}