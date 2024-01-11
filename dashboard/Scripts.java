package system.dashboard;


class Scripts {

	protected static final String DEF = "Default message";
	protected static final String RIP = "You're dead";
	protected static final String A05 = ": Now where should I Go?";
	protected static final String IDONO = ": I don't know the way";
	protected static final String PAIN = ": Aww!!!";
	protected static final String STRANGER = "Stranger: Hey wake up.. Heyy!!";
	protected static final String COMPLETE = ">>>Quest Complete<<<\n\n";
	protected static final String NEWQUEST = ">>>New Quest<<<\n";
	protected static final String RAN = ">>>You Run Away from the schene<<<";
	protected static final String NEW_SECTION = ">>>Entering new Section<<<";
	protected static final String HEALED = ">>>You are now fully recovered<<<";
	protected static final String HERE = ": here they come!!!";

	//Quests-----------------------------------------
	protected static final String Q_DESTROY = "Operation OverThrow\n(Destroy all enemy)";

	//EXP addition---------------------------------
	protected static final String EXPUP50 = "+50 EXP\n\n";

	//Actions-------------------------------------
	protected static final String CHECK = "Check it";
	protected static final String IGNORE = "Ignore it";
	protected static final String TAKE = "Take it";
	protected static final String THROW = "Throw it";
	protected static final String DEFAULT_ACTION1 = "Talk";
	protected static final String DEFAULT_ACTION2 = "Attack";
	protected static final String DEFAULT_ACTION3 = "Run";
	protected static final String DEFAULT_ACTION4 = "Taunt";
	protected static final String DEFAULT_ACTION_HEAL = "Hide";
	protected static final String EXIT = "Quit";
	protected static final String HELP = "Help";
	protected static final String PICK = "Class";
	protected static final String DIAGNEXT = "Next";

	//Character classes------------------------

	//For Buttons----------------------
	protected static final String MAG = "Mage";
	protected static final String PAL = "Paladin";
	protected static final String DRU = "Druid";
	protected static final String BRB = "Barb";

	//For String Value----------------
	protected static final String C_MAGE = "Mage";
	protected static final String C_PALADIN = "Paladin";
	protected static final String C_DRUID = "Druid";
	protected static final String C_BARB = "Barbarian";

	//Locations--------------------------------
	protected static final String CPT = "Capitol";
	protected static final String LIB = "Library";
	protected static final String MAR = "Market";
	protected static final String POR = "Port";
	protected static final String MER = "Merkeel";
	protected static final String L_SEWER = "Sewers";
	protected static final String L_FOREST = "Forest";
	protected static final String L_CRYPT = "Crypt";
	protected static final String L_CORRUPTED_DUNGEON = "Towers";

	//Location Dialogues-------------------------------------------

	//Sewer-------------------------------------------------------------
	protected static final String LD_SEWER_TRAPPED = ">>>The Ground is shaking<<<";
	protected static final String LD_SEWER = ">>>Now Entering Sewer<<<\n\n";
	protected static final String LD_SEWER_PLAYER_REACT = ": Phew Why I am doing this!";
	protected static final String LD_SEWER_SKELE = ">>>An Skeleton appeared<<<\n\n ATK 5 DEF 3\n\nRun or Attack?";
	protected static final String LD_SEWER_VICTORY = ">>>Enemy Defeated<<<\n\n+30 EXP";
	protected static final String LD_SEWER_VICTORY_UNDEADS = ">>>Undead Defeated<<<\n\n+60 EXP";
	protected static final String LD_SEWER_RAT =">>>You continued your journey you walk through the dark tunnels of Merkeel's Sewer systems and suddenly a Mutated rat appeared\n\n ATK 5 DEF 3<<<";
	protected static final String LD_SEWER_PANIC = ": On no I'm Trapped!! all exit way is now filled with undeads I have no choice I must figth to survive\n\n>>>New Quest<<<\nHold your line";
	protected static final String LD_SEWER_UNDEAD = ">>> Undeads <<<\nATK 8 DEF4 \n>>>press the Hide button to heal<<<";
	protected static final String LD_SEWER_UNDEAD_TYPE2 = ">>> Undeads <<<\nATK 8 DEF4";
	protected static final String LD_SEWER_UNDEAD_ELITES = ">>> Elite Undeads<<<\n ATK 10 DEF 5";
	protected static final String LD_SEWER_PLAYER_REACTS_ELITES = ": They are getting stronger";

	//Forest-------------------------------------------------------------
	protected static final String LD_FOREST = ">>>Now Entering Forest<<<\n\n";
	protected static final String LD_FOREST_PLAYER_REACT = ": eyes Lurking everywhere!";



    //Crypt------------------------------------------------------------
	protected static final String LD_CRYPT = ">>>Now Entering Crypt<<<\n\n";
	protected static final String LD_CRYPT_PLAYER_REACT = ": What kind of place is this?!";



	//Towers--------------------------------------------------------------------
	protected static final String LD_CORRUPTED_DUNGEON = ">>>Now Entering The Corrupted Towers<<<\n\n";
	protected static final String LD_CORRUPTED_DUNGEON_PLAYER_REACT = ": this place makes my \nbone chill";



	//NPC--------------------------------------
	protected static final String GD = "Guard";
	protected static final String VEN = "Vendor";
	protected static final String BARKY = "Dog";
	protected static final String CLE = "Cleric";

	//Early Dialogues---------------------------
	protected static final String HELLO = ": Hello";
	protected static final String HI = "Stranger: Hi. Umm. I've never seen you before. Are you new Here?";
	protected static final String WHAT = ": What it is actually working ahahah";
	protected static final String LOOK = "Stranger: you look crazy";
	protected static final String SORRY = ": Sorry I'am just happy that it WORKS!!!!";
	protected static final String MEAN = "Stranger: What do you mean? What on Earth are you up to? ";
	protected static final String NEED = ": (Coverring the mouth).. Internal monologue(Oh crap I \nneed to be carefull)";
	protected static final String HEY1 = "Stranger: Hey  Hey!!\n\n";
	protected static final String HEY2 = ": Um.. Nothing! I am";
	protected static final String WEIRD = "Stranger: You're Weird \n>>>The Stranger walks away<<<";
	protected static final String BONES = ": 0_0 Son of a BONES!!!";
	protected static final String WALKS = ">>>Skeletor Walks Away<<<";

	protected static final String A01 = ": T..thanks!!\n>>>The Mysterious Wizard Walks \nAway<<<";
	protected static final String A02 = ": PHEWWW!!! I thought Im gonna die. Wait what is that?";
	protected static final String A03 = ": A knife!? What on earth am I supposed to do with this old rusty knife!";
	protected static final String A04 = ">>>You acquired a (Rusty Knife)<<<";
	protected static final String A06 = "Stranger: How dare you!!";
	protected static final String A07 = "Stranger: Guards!! please HElp me !!";
	protected static final String A08 = "Guard: Stop!!.. (Stab!!!).. (Slash!!) >>>The guard caught and killed you<<< GAME OVER";
	protected static final String A09 = "Stranger: Awww what the!!";
	protected static final String A10 = "Stranger: Takes This!!.. !!whack!!";
	protected static final String A11 = "Stranger: Stop";
	protected static final String A12 = ">>>You killed the Stranger<<<";
	protected static final String A13 = ">>>That would be a mistake!!!<<<";
	protected static final String A14 = ">>>That's a bad idea<<<";
	protected static final String A15 = ": What I have done!! Now I need to leave or someone will notice! ";

	protected static final String CAPITOL = ": Whoaa.. this place is magnificent! Well if only I knew where I am. I should ask these guys. ";
	protected static final String DOG = "Bark !! Bark!! \n>>> Dog Bites you<<<\n\n";
	protected static final String GUARD = ": Can I ask where am I?\n\nGuard: This is (Merkeel) the Capital city of the State of (Galandol)\n\n>>>New Quest<<<\nSeek for answers(Meet the Cleric)";
	protected static final String VENDOR = ": Can I ask where am I?\n\nVendor: I only entertain customers! if You're not \nplanning to buy something get\nlost! I'm busy!";
	protected static final String CLERIC = ": Can I ask where am I?\n\nCleric: Oh great! come and help me!";
	protected static final String CLEQ = ": Hello\n\nCleric: Oh great! come and help me!\n\n>>>Quest Complete<<<\n+50 EXP";
	protected static final String CLETALK = "Cleric: Hmm I've never seen you before clearly you are not from here Well thanks for the help\n\n>>>New Quest<<<\nPick a Class";
	protected static final String CLSS = ">>>Pick your Class<<<\n\nMage: \n\nPaladin: \n\nDruid: \n\nBarbarian: ";


	//Cleric Dialogues-----------------------------------------------
	protected static final String D_CLERIC_BARBARIAN = "Cleric: Ahh a Barbarian";
	protected static final String D_CLERIC_MAGE = "Cleric: Ahh a Mage";
	protected static final String D_CLERIC_PALADIN = "Cleric: Ahh a Paladin";
	protected static final String D_CLERIC_DRUID = "Cleric: Ahh a Druid";


	//Wizard vs Skeletor--------------------------------------------
	protected static final String WIZ1 = "Lucky of you I passed by.";
	protected static final String WIZ = "STOP!!";
    protected static final String SKULL3 = "";
    protected static final String SKULL2 = "Skeletor: RAAAA!!! Filty \nWizard!!";        
	protected static final String SKULL1 = "Skeletor: HMMMMM!! FOOD!  ";
	protected static final String SKULL = "Skeletor: Greetings!";


	//Class selection Dialogue---------------------------------------
	protected static final String MAGECLASS = ": A Mage!\n";
	protected static final String PALADCLASS = ": A Paladin!\n";
	protected static final String DRUIDCLASS = ": A Druid!\n";
	protected static final String BARBCLASS = ": A Barbarian!\nWait I hate this class >_<\nWell fine!";


	//BattleGrounds----------------------------------------------
	protected static final String D_SELECTION = ">>>Select your destination<<<\n\nSewers:\n\nForest: Locked\n\nCrypt: Locked\n\nCorrupted Towers: Locked";
}