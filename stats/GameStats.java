package system.stats;

public class GameStats {
    public int atk, def, agi, hp, damage;
    public String race, weapons, armour;

    public GameStats() {
        this(0, 0, 0, 0, 0, "","","");
    }

    public GameStats(int atk, int def, int agi, int hp, int damage, String race, String weapons, String armour) {
        this.atk = atk;
        this.def = def;
        this.agi = agi;
        this.race = race;
        this.hp = hp;
        this.weapons = weapons;
        this.armour = armour;
        this.damage = damage;

    }
}
