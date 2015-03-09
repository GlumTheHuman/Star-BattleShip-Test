package starWarsGamePackage;

import java.util.Scanner;

public class StarWarsGame {
	
	private static int highscore = 1956;
	
	private static String input2;
	
	
	private static int score = 0;
	private static int round = 1;
	private static int yourHull = 0;
	private static int yourShields = 0;
	private static int yourPower = 0;
	private static int yourDamage = 0;
	private static int yourMissiles = 0;
	private static int yourCoolDown = 0;
	private static int ionCharge = 0;
	private static int yourMaxPower = 0;
	private static int yourIon = 0;
	private static int yourPowerRegen = 0;
	private static int yourShieldRegen = 0;
	private static int yourMaxShields = 0;
	private static int yourMaxHull = 0;
	private static int yourMaxMissiles = 0;
	
	private static boolean doWhileLoop = true;
	private static boolean doWhileLoop2 = true;
	private static boolean nullShields = false;
	
	private static GameCalc command;
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Star BattleShip Beta 1.5.3 type LOG for more");
		System.out.println();
		System.out.println("-Highscore: " + highscore + "-");
		System.out.println();
		System.out.println("Put some helpful game rule jargon stuff here:");
		do {
			System.out.println();
			System.out.println("Choose your starship class: CETACEA, LYRIAN, BARIUS, LOG or INFO");
			input2 = input.next();
			switch (input2){
			
			case "info" :
				System.out.println("-The Cetacea class is a heavy warship with high power reserves and strong shields");
				System.out.println(" but has a low amount of missiles and a very weak ion canon.");
				System.out.println("-The Lyrian class gunship carries a huge playload of missiles, plenty of power");
				System.out.println(" but has low power regen and lowish shields.");
				System.out.println("-The Barius class corvette has a deadly ion canon and good power and shield regen");
				System.out.println(" but has a weak hull and a small power reserve.");
			break;
			
			case "cetacea" :
				Starship cetacea = new Starship();
				cetacea.setHull(120);
				cetacea.setShields(25);
				cetacea.setShieldRegen(2);
				cetacea.setPower(150);
				cetacea.setPowerRegen(20);
				cetacea.setMissiles(2);
				cetacea.setIonCanon(1);
				
				yourHull = cetacea.hull;
				yourShields = cetacea.shields;
				yourShieldRegen = cetacea.shieldRegen;
				yourPower = cetacea.power;
				yourPowerRegen = cetacea.powerRegen;
				yourMissiles = cetacea.missiles;
				yourIon = cetacea.ionCanon;
				yourMaxPower = cetacea.power;
				yourMaxShields = cetacea.shields;
				yourMaxHull = cetacea.hull;
				yourMaxMissiles = cetacea.missiles;
				System.out.println("You have choosen: Cetacea class");
				doWhileLoop2 = false;
			break;
			
			case "barius" :
				Starship barius = new Starship();
				barius.setHull(80);
				barius.setShields(18);
				barius.setShieldRegen(4);
				barius.setPower(90);
				barius.setPowerRegen(30);
				barius.setMissiles(3);
				barius.setIonCanon(4);
				
				yourHull = barius.hull;
				yourShields = barius.shields;
				yourShieldRegen = barius.shieldRegen;
				yourPower = barius.power;
				yourPowerRegen = barius.powerRegen;
				yourMissiles = barius.missiles;
				yourIon = barius.ionCanon;
				yourMaxPower = barius.power;
				yourMaxShields = barius.shields;
				yourMaxHull = barius.hull;
				yourMaxMissiles = barius.missiles;
				System.out.println("You have choosen: Barius class");
				doWhileLoop2 = false;
			break;
			
			case "lyrian" :
				Starship lyrian = new Starship();
				lyrian.setHull(90);
				lyrian.setShields(20);
				lyrian.setShieldRegen(4);
				lyrian.setPower(120);
				lyrian.setPowerRegen(25);
				lyrian.setMissiles(5);
				lyrian.setIonCanon(2);
				
				yourHull = lyrian.hull;
				yourShields = lyrian.shields;
				yourShieldRegen = lyrian.shieldRegen;
				yourPower = lyrian.power;
				yourPowerRegen = lyrian.powerRegen;
				yourMissiles = lyrian.missiles;
				yourIon = lyrian.ionCanon;
				yourMaxPower = lyrian.power;
				yourMaxShields = lyrian.shields;
				yourMaxHull = lyrian.hull;
				yourMaxMissiles = lyrian.missiles;
				System.out.println("You have choosen: Lyrian class");
				doWhileLoop2 = false;
			break;
		
			case "log" :
				System.out.println();
				System.out.println("Beta 1.5.3");
				System.out.println("-Added a cooldown for lasers.");
				System.out.println("-Fixed more bugs.");
				System.out.println();
				System.out.println("Beta 1.4.5");
				System.out.println("-Added new ship classes: Cetacea, Lyrian and Barius.");
				System.out.println("-Added new AI for the Barius.(also the ai will only choose the barius(only for a while though(I hope)))");
				System.out.println("-Fixed subsystems.");
				System.out.println("-Updated scoring system.");
				System.out.println("-Fixed even more bugs.");
				System.out.println();
				System.out.println("Beta 1.3.5");
				System.out.println("-Added subsystems: Heavy Lasers, Ion Canon and Power Core.");
				System.out.println("-Changed scoring.");
				System.out.println("-Updated AI");
				System.out.println("-Added easter eggs(hint: potato)");
				System.out.println("-Fixed some more bugs");
				System.out.println();
				System.out.println("Beta 1.2.2");
				System.out.println("-Added a new weapon: The Ion Canon.");
				System.out.println("-Got the ion canon to work.");
				System.out.println("-Added this change log.");
				System.out.println("-Added version number at the top.");
				System.out.println("-Fixed a LOT of random bugs.");
				System.out.println("-Re-buffed missiles.");
				break;
			};
		} while (doWhileLoop2);
		
		command = new GameCalc();
		boolean doAttack = false;
		
		command.computerShip();
		
		do {
			
			if (command.getPowerC()) {
				if (yourPower < yourMaxPower) {
					yourPower += yourPowerRegen;
				}
				if (yourPower > yourMaxPower) {
					yourPower = yourMaxPower;
				}
			} else {
				if (yourPower < yourMaxPower) {
					yourPower += 10;
				}
				if (yourPower > yourMaxPower) {
					yourPower = yourMaxPower;
				}
			}
			if (yourShields < yourMaxShields && command.getComCharge() <= 0) {
				yourShields += yourShieldRegen;
			} else if (yourShields < 20 && command.getComCharge() > 0) {
				yourShields += 1;
			}
			if (command.getIonC()) {
				if (ionCharge > 0) {
				ionCharge--;
				}
			} else {
				ionCharge = 0;
			}
			
			yourDamage = command.getDamage();
			
			System.out.println();
			System.out.println("------" + "Round " + round + "------");
			System.out.println();
			System.out.println("You have " + yourPower  + "/" + yourMaxPower + " power");
			System.out.println("Shields at " + yourShields + "/" + yourMaxShields);
			System.out.println("Hull at " + yourHull + "/" + yourMaxHull);
			System.out.println("You have " + yourMissiles + " missiles");
			System.out.println("Laser heat at " + command.getYourLCD());
			if (yourCoolDown > 0) {
				System.out.println("Missile cooldown at " + yourCoolDown + "%");
			} else {
				System.out.println("Missiles not on cooldown");
			}
			if (command.getIonC()) {
				if (ionCharge > 0) {
					System.out.println("Ion canon charging: " + ionCharge + " turns left");
				} else {
					System.out.println("Ion canon is charged");
				}
			}
			System.out.println();
			command.getComStats();
			System.out.println();
			if (command.getIonC() && command.getYourLCD() < 100) {
				System.out.println("Type in LASER(50-10), MISSILE(80), SHIELD(65-25), ION(80) or WAIT:");
			} else if (command.getIonC() && command.getYourLCD() >= 100) {
				System.out.println("Type in MISSILE(80), SHIELD(65-25), ION(80) or WAIT:");
			} else if (!command.getIonC() && command.getYourLCD() >= 100) {
				System.out.println("Type in MISSILE(80), SHIELD(65-25) or WAIT:");
			} else if (!command.getIonC() && command.getYourLCD() < 100) {
				System.out.println("Type in LASER(50-10) MISSILE(80), SHIELD(65-25) or WAIT:");
			}
			input2 = input.next();
			
			if ("laser".equals(input2)) {
				
				if(command.getHeavyL() && command.getYourLCD() < 100) {
				System.out.println("Select power level: High 12Dmg(50), Med 8Dmg(20), Low 4Dmg(10)");
				input2 = input.next();
				
				command.laser(input2, yourPower, yourDamage, true);
				yourDamage = command.getDamage();
				yourPower = command.getPower();
				doAttack = true;
				} else if(!command.getHeavyL() && command.getYourLCD() > 100) {
					System.out.println("Select power level: Med 8Dmg(20), Low 4Dmg(10)");
					input2 = input.next();
					
					command.laser(input2, yourPower, yourDamage, false);
					yourDamage = command.getDamage();
					yourPower = command.getPower();
				} else {
					System.out.println("You can't fire your lasers, they have overheated!");
				}
			} else if ("shield".equals(input2)) {
				System.out.println("Select  level: High +7(65), Med +5(40), Low +3(25)");
				input2 = input.next();
				
				command.shield(input2, yourPower, yourShields);
				yourShields = command.getShields();
				yourPower = command.getPower();
				
			} else if ("missile".equals(input2)) {
				
				command.missile(input2, yourMissiles, yourDamage, yourCoolDown, nullShields);
				yourCoolDown = command.getCoolDown();
				yourMissiles = command.getMissiles();
				nullShields = command.getNull();
				yourDamage = command.getDamage();
				doAttack = true;
				
			} else if ("log".equals(input2)) {
				
				System.out.println();
				System.out.println("Beta 1.5.3");
				System.out.println("-Added a cooldown for lasers.");
				System.out.println("-Updated Ai.");
				System.out.println("-Fixed more bugs");
				System.out.println();
				System.out.println("Beta 1.4.5");
				System.out.println("-Added new ship classes: Cetacea, Lyrian and Barius.");
				System.out.println("-Added new AI for the Barius.(also the ai will only choose the barius(only for a while though(I hope)))");
				System.out.println("-Fixed subsystems.");
				System.out.println("-Updated scoring system.");
				System.out.println("-Added a cooldown for lasers.");
				System.out.println("-Fixed even more bugs.");
				System.out.println();
				System.out.println("Beta 1.3.5");
				System.out.println("-Added subsystems: Heavy Lasers, Ion Canon and Power Core.");
				System.out.println("-Changed scoring.");
				System.out.println("-Updated AI");
				System.out.println("-Added easter eggs(hint: potato)");
				System.out.println("-Fixed some more bugs");
				System.out.println();
				System.out.println("Beta 1.2.2");
				System.out.println("-Added a new weapon: The Ion Canon.");
				System.out.println("-Got the ion canon to work.");
				System.out.println("-Added this change log.");
				System.out.println("-Added version number at the top.");
				System.out.println("-Fixed a LOT of random bugs.");
				System.out.println("-Re-buffed missiles.");
				
			
			} else if ("ion".equals(input2)){
				
				if  (command.getIonC()) {
				
					command.ionCanon(yourDamage, yourPower, ionCharge, yourIon);
					yourDamage = command.getDamage();
					yourPower = command.getPower();
					ionCharge = command.getCharge();
					doAttack = true;
				} else {
					System.out.println("You ion canon has taken too much damage");
				}
			
			} else if ("potato".equals(input2)) {
				System.out.println("Billy: Jimmy... We're running out of time. I think it's time for plan 'P'.");
				System.out.println("Jimmy: You don't mean...");
				System.out.println("Billy: I do. Jimmy... Prepare the SPUD GUN!");
				System.out.println("Spud Gun: Charging... 23%");
				System.out.println("Spud Gun: Charging... 42%");
				System.out.println("Spud Gun: Charging... 78%");
				System.out.println("Spud Gun: Charging... 99%");
				System.out.println("Spud Gun: 100%. Ready to Fire.");
				System.out.println("Billy: FIRE!");
				System.out.println("Jimmy: IMA FIRIN' MY SPUD CANNON!");
				System.out.println("*Wooosh*");
				System.out.println(".");
				System.out.println(".");
				System.out.println(".");
				System.out.println("*Bounces off ship and floats off into space... -9.20 damage.*");
				System.out.println("*It had no effect.*");
				System.out.println("Jimmy: ...");
				System.out.println("Billy: We're doomed...");
				System.out.println();
				
			} else if ("potayno".equals(input2)) {
				while(true) {
					System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println("JONAH!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println("YOU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println("CRASHED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println("THE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					System.out.println("GAME!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				}
			}
				
			if (doAttack) {
				command.yourAttack(command.getComShields(), command.getComHull(), yourDamage, nullShields);
				nullShields = command.getNull();
				yourDamage = command.getDamage();
				doAttack = false;
				
				if (yourDamage > 0) {
				command.testDamage(command.getComHull(), "The computers ", 2);	
				}
			}
			
			
			if (yourHull <= 0) {
				command.findScore(score, yourHull, yourMissiles, yourShields, command.getComShields(), yourPower, round, yourMaxHull, yourMaxShields, yourMaxMissiles, yourMaxPower);
				score = command.getScore();
				System.out.println("-----------------------");
				System.out.println("Game over.");
				if (score > highscore) {
					System.out.println("New Highscore!: " + score);
				} else {
					System.out.println("Your score: " + score);
				}
				System.out.println("-----------------------");
				doWhileLoop = false;
			} else if (command.getComHull() <= 0) {
				System.out.println("-------------");
				command.findScore(score, yourHull, yourMissiles, yourShields, command.getComShields(), yourPower, round, yourMaxHull, yourMaxShields, yourMaxMissiles, yourMaxPower);
				score = command.getScore();
				System.out.println("You have won!");
				if (score > highscore) {
					System.out.println("New Highscore!: " + score);
				} else {
					System.out.println("Your score: " + score);
				}
				System.out.println("-------------");
				doWhileLoop = false;
			}
			if (doWhileLoop) {
				
				command.bariusAi(yourHull, command.getComHull(), yourShields, command.getComShields(), command.getComPower());
				yourHull = command.getYourHull();
				yourShields = command.getShields();
				
				if (command.getComDamage() > 0) {
					command.testDamage(yourHull, "Your ", 1);
				}
				
				
				if (yourCoolDown > 0) {
					if (yourPower >= yourCoolDown) {
						yourPower -= yourCoolDown;
						yourCoolDown = 0;
					} else if (yourPower < yourCoolDown) {
						yourCoolDown -= yourPower;
						yourPower = 0;
					}
				}
			}
			
			
			round++;	

			
		} while(doWhileLoop);
		
		input.close();
	}

}