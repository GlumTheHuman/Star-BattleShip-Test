package starWarsGamePackage;

import java.util.Random;

public class GameCalc {
	
	Random rollDice = new Random();

	private int shield;
	private int waitFor;
	private int diceRoll = 0;
	
	private int yourHull = 0;
	private int yourShields = 0;
	private int yourPower = 0;
	private int yourDamage = 0;
	private int yourMissiles = 0;
	private int yourCoolDown = 0;
	private int yourLCD;
	private int ionCharge = 0;
	
	private int computerHull = 0;
	private int computerShields = 0;
	private int computerPower = 0;
	private int computerDamage = 0;
	private int computerMissiles = 0;
	private int computerCoolDown = 0;
	private int computerLCD;
	private int comIonCharge = 0;
	private int score = 0;
	private int computerMaxHull;
	private int heatFor = 0;
	private int comHeatFor = 0;
	private int attack = 0;
	private int comAttack = 0;
	private int computerMaxPower = 0;
	private int computerIon = 0;
	private int computerPowerRegen = 0;
	private int computerShieldRegen = 0;
	private int computerMaxShields = 0;
	
	private boolean wait = false;
	
	private boolean doAttack = false;
	private boolean overHeat = false;
	private boolean ionShields = false;
	private boolean nullShields = false;
	private boolean powerCore = true;
	private boolean ionCanon = true;
	private boolean heavyLasers = true;
	
	private boolean comDoAttack = false;
	private boolean comOverHeat = false;
	private boolean comIonShields = false;
	private boolean comNullShields = false;
	private boolean comPowerCore = true;
	private boolean comIonCanon = true;
	private boolean comHeavyLasers = true;

	public void testDamage(int hull, String player, int num){
		
		diceRoll = rollDice.nextInt(5);
			
		if (hull <=25 && diceRoll <= 4) {
			diceRoll = rollDice.nextInt(3);
			if (diceRoll == 0) {
				if(num == 1 && heavyLasers) {
					heavyLasers = false;
					System.out.println(player + "heavy lasers have been destroyed!");
				} else if (num == 2 && comHeavyLasers) {
					comHeavyLasers = false;
					System.out.println(player + "heavy lasers have been destroyed!");
				}
				
			} else if (diceRoll == 1) {
				if(num == 1 && ionCanon == true) {
					ionCanon = false;
					System.out.println(player + "ion canon has been destroyed!");
				} else if (num == 2 && comIonCanon) {
					comIonCanon = false;
					System.out.println(player + "ion canon has been destroyed!");
				}
				
			} else if (diceRoll == 2) {
				if(num == 1 && powerCore) {
					powerCore = false;
					System.out.println(player + "power core has been destroyed!");
				} else if (num == 2 && comPowerCore) {
					comPowerCore = false;
					System.out.println(player + "power core has been destroyed!");
				}
				
			}
		} else if (hull <= 35 && diceRoll <= 2) {
			diceRoll = rollDice.nextInt(3);
			if (diceRoll == 0) {
				if(num == 1 && heavyLasers) {
					heavyLasers = false;
					System.out.println(player + "heavy lasers have been destroyed!");
				} else if (num == 2 && comHeavyLasers) {
					comHeavyLasers = false;
					System.out.println(player + "heavy lasers have been destroyed!");
				}
				
			} else if (diceRoll == 1) {
				if(num == 1 && ionCanon) {
					ionCanon = false;
					System.out.println(player + "ion canon has been destroyed!");
				} else if (num == 2 && comIonCanon) {
					comIonCanon = false;
					System.out.println(player + "ion canon has been destroyed!");
				}
				
			} else if (diceRoll == 2) {
				if(num == 1 && powerCore) {
					powerCore = false;
					System.out.println(player + "power core has been destroyed!");
				} else if (num == 2 && comPowerCore) {
					comPowerCore = false;
					System.out.println(player + "power core has been destroyed!");
				}
				
			}
		} else if (hull <= 50 && diceRoll == 0) {
			diceRoll = rollDice.nextInt(2);
			if (diceRoll == 0) {
				if(num == 1 && heavyLasers) {
					heavyLasers = false;
					System.out.println(player + "heavy lasers have been destroyed!");
				} else if (num == 2 && comHeavyLasers) {
					comHeavyLasers = false;
					System.out.println(player + "heavy lasers have been destroyed!");
				}

			} else if (diceRoll == 1) {
				if(num == 1  && ionCanon) {
					ionCanon = false;
					System.out.println(player + "ion canon has been destroyed!");
				} else if (num == 2&& comIonCanon) {
					comIonCanon = false;
					System.out.println(player + "ion canon has been destroyed!");
				}
				
			}
		}
	}
	
	public void findScore(int score, int yourHull, int yourMissiles, int yourShields, int computerShields, int yourPower, int round, int yourMaxHull, int yourMaxShields, int yourMaxMissiles, int yourMaxPower) {
		this.score = score;
		this.score = 2000 * yourHull / yourMaxHull;
		this.score = this.score + 500 * yourMaxShields / yourMaxShields;
		// "Danger. Do not enter!"this.score = this.score + 30 * yourPower * yourMaxPower /675;
		this.score = this.score + 100 * yourMissiles / yourMaxMissiles;
		this.score = this.score - round * 50;
		if (heavyLasers && ionCanon && powerCore) {
			this.score = this.score + 750;
		} else if ((heavyLasers && ionCanon) || (heavyLasers && powerCore) || (powerCore && ionCanon)) {
			this.score = this.score + 450;	
		} else if (heavyLasers || powerCore || ionCanon) {
			this.score = this.score + 150;
		}
		if (comHeavyLasers == false && comIonCanon == false && comPowerCore == false) {
			this.score = this.score + 550;
		} else if ((comHeavyLasers == false && comIonCanon == false) || (comHeavyLasers == false && comPowerCore == false) || (comPowerCore == false && comIonCanon == false)) {
			this.score = this.score + 350;	
		} else if (comHeavyLasers == false || comPowerCore == false || comIonCanon == false) {
			this.score = this.score + 100;
		}
		
	}
	
	public void computerTurn(int yourHull, int computerHull, int yourShields, int computerShields, int computerPower) {
		
		computerDamage = 0;
		this.yourShields = yourShields;
		this.yourHull = yourHull;
		this.computerPower = computerPower;
		this.computerShields = computerShields;
		if(comPowerCore) {
			if (computerPower < computerMaxPower) {
				this.computerPower += computerPowerRegen;
			}
			if (this.computerPower > computerMaxPower) {
			this.computerPower = computerMaxPower;
			}
		} else {
			if (computerPower < computerMaxPower) {
				this.computerPower += 10;
			}
			if (this.computerPower > computerMaxPower) {
			this.computerPower = computerMaxPower;
			}
		}
		
		
		if (computerShields < computerMaxShields) {
			if (ionCharge > 0) {
				this.computerShields += 1;
			} else {
				this.computerShields += computerShieldRegen;
			}
		}	
		if (this.comIonCharge > 0) {
			this.comIonCharge--;
		}
		if (this.computerShields < 5 && this.computerPower >= 25) {
			
			if (this.computerPower > 65) {
				computerShield(computerPower, computerShields, 3);	
			} else if (this.computerPower > 40) {
				computerShield(computerPower, computerShields, 2);	
			} else if (this.computerPower > 25) {
				computerShield(computerPower, computerShields, 1);	
			}
		} else if (this.computerShields < 10 && this.computerPower >= 25) {
			
			diceRoll = rollDice.nextInt(2);
			if (diceRoll == 1 && computerMissiles >= 3) {
				computerMissile(computerMissiles, computerCoolDown, computerDamage, comNullShields);
			} else if (diceRoll == 0) {
				if (this.computerPower > 40) {
					computerShield(computerPower, computerShields, 2);	
				} else if (this.computerPower > 25) {
					computerShield(computerPower, computerShields, 1);	
				}
			} else {
				computerLaser(computerPower, computerDamage, 2);
			}
			
		} else if (yourHull <= 25 && this.computerMissiles > 0 && this.computerCoolDown <= 0) {
			computerMissile(computerMissiles, computerCoolDown, computerDamage, comNullShields);
				
		} else if (yourShields <= 5 && this.computerPower >= 10) {
			if (this.computerPower > 50 && comHeavyLasers) {
				computerLaser(computerPower, computerDamage, 3);		
			} else if (this.computerPower > 20) {
				computerLaser(computerPower, computerDamage, 2);
			} else if (this.computerPower > 10) {
				computerLaser(computerPower, computerDamage, 1);
			}
		} else if (yourShields <= 10 && computerPower >= 10) {
			if (this.computerPower > 20) {
				computerLaser(computerPower, computerDamage, 2);	
			} else if (this.computerPower > 10) {
				computerLaser(computerPower, computerDamage, 1);
			}
			
		} else if (computerPower > 55 && this.comIonCharge <= 0 && comIonCanon) {
			diceRoll = rollDice.nextInt(4);
			if (computerPower >= 80 && diceRoll == 1) {
				computerIonCanon(computerDamage, this.computerPower, comIonShields, ionCharge);
			} else if (diceRoll == 0) {
				wait = true;
			}
			
		} else if (this.computerPower >= 10 && wait != true) {	
			diceRoll = rollDice.nextInt(3);
			if (diceRoll == 0 && computerPower >= 50 && comHeavyLasers) {
				computerLaser(computerPower, computerDamage, 3);
			} else if (diceRoll == 1 || diceRoll == 2) {
				computerLaser(computerPower, computerDamage, 1);
			}
			
		}

		
		if (this.computerCoolDown > 0) {
			if (this.computerPower >= this.computerCoolDown) {
				this.computerPower -= this.computerCoolDown;
				this.computerCoolDown = 0;
			} else if (this.computerPower < this.computerCoolDown) {
				this.computerCoolDown -= this.computerPower;
				this.computerPower = 0;
			}
			
		}
		if (comNullShields != true && comIonShields != true) {
			this.yourShields -= computerDamage;
			if (this.yourShields <= 0) {
				this.yourShields = 0;
				this.yourHull -= this.computerDamage * 2;
			} else if (this.yourShields <= 5) {
				this.yourHull -= this.computerDamage;
			} else if (this.yourShields <= 10) {
				this.yourHull -= this.computerDamage / 2;
			}
			
		} else if (comIonShields == true) {
			this.yourShields -= computerDamage;
			this.comIonShields = false;
		} else {
			this.yourHull -= this.computerDamage * 2;
			comNullShields = false;
		}
		
	}
	
	public void ceteceaAi(int yourHull, int computerHull, int yourShields, int computerShields, int computerPower) {

		computerDamage = 0;
		this.yourShields = yourShields;
		this.yourHull = yourHull;
		this.computerPower = computerPower;
		this.computerShields = computerShields;
		if(comPowerCore) {
			if (computerPower < computerMaxPower) {
				this.computerPower += computerPowerRegen;
			}
			if (this.computerPower > computerMaxPower) {
			this.computerPower = computerMaxPower;
			}
		} else {
			if (computerPower < computerMaxPower) {
				this.computerPower += 10;
			}
			if (this.computerPower > computerMaxPower) {
			this.computerPower = computerMaxPower;
			}
		}
		
		
		if (computerShields < computerMaxShields) {
			if (ionCharge > 0) {
				this.computerShields += 1;
			} else {
				this.computerShields += computerShieldRegen;
			}
		}	
		if (this.comIonCharge > 0) {
			this.comIonCharge--;	
		}
		
		//Put new Ai here:
		
		
		if (this.computerCoolDown > 0) {
			if (this.computerPower >= this.computerCoolDown) {
				this.computerPower -= this.computerCoolDown;
				this.computerCoolDown = 0;
			} else if (this.computerPower < this.computerCoolDown) {
				this.computerCoolDown -= this.computerPower;
				this.computerPower = 0;
			}
			
		}
		if (comNullShields != true && comIonShields != true) {
			this.yourShields -= computerDamage;
			if (this.yourShields <= 0) {
				this.yourShields = 0;
				this.yourHull -= this.computerDamage * 2;
			} else if (this.yourShields <= 5) {
				this.yourHull -= this.computerDamage;
			} else if (this.yourShields <= 10) {
				this.yourHull -= this.computerDamage / 2;
			}
			
		} else if (comIonShields == true) {
			this.yourShields -= computerDamage;
			this.comIonShields = false;
		} else {
			this.yourHull -= this.computerDamage * 2;
			comNullShields = false;
		}
		
	}
	
	public void bariusAi(int yourHull, int computerHull, int yourShields, int computerShields, int computerPower) {
		
		laserCoolDown();
		
		computerDamage = 0;
		this.yourShields = yourShields;
		this.yourHull = yourHull;
		this.computerPower = computerPower;
		this.computerShields = computerShields;
		if(comPowerCore) {
			if (computerPower < computerMaxPower) {
				this.computerPower += computerPowerRegen;
			}
			if (this.computerPower > computerMaxPower) {
			this.computerPower = computerMaxPower;
			}
		} else {
			if (computerPower < computerMaxPower) {
				this.computerPower += 10;
			}
			if (this.computerPower > computerMaxPower) {
			this.computerPower = computerMaxPower;
			}
		}
		
		
		if (computerShields < computerMaxShields) {
			if (ionCharge > 0) {
				this.computerShields += 1;
			} else {
				this.computerShields += computerShieldRegen;
			}
		}	
		if (this.comIonCharge > 0) {
			this.comIonCharge--;	
		}
		if (!wait || waitFor <= 0) {
			if (computerShields <= 5 || computerHull <= 15) {
				diceRoll = rollDice.nextInt(3);
				if (diceRoll == 0 && computerHull <= 15 && shield <= 3) {
					if (computerPower >= 40) {
						computerShield(computerPower, computerShields, 2);
					} else if (computerPower >= 25) {
						computerShield(computerPower, computerShields, 1);
					}
				} else if (computerPower >= 65 && diceRoll == 1) {
					computerShield(computerPower, computerShields, 3);
					shield++;
				} else if (computerPower >= 40 && diceRoll == 1) {
					computerShield(computerPower, computerShields, 2);
					shield++;
				} else if (computerPower >= 25 && diceRoll == 1) {
					computerShield(computerPower, computerShields, 1);
					shield++;
					
				} else if (diceRoll == 2) {
					if (computerPower >= 50) {
						computerLaser(computerPower, computerDamage, 3);
					} else if (computerPower >= 25) {
						computerLaser(computerPower, computerDamage, 2);
					}
				} else {
					wait = true;
				}
			} else if (yourHull <= 20) {
				if (computerMissiles > 0 && computerCoolDown <= 0) {
					if (computerPower >= 50) {
						computerMissile(computerMissiles, computerCoolDown, computerDamage, comNullShields);
					} else if (computerPower >= 25) {
						wait = true;
					} else {
						waitFor = 2;
					}
				} else if (computerPower >= 50 && computerLCD < 100) {
					computerLaser(computerPower, computerDamage, 3);
				} else if (computerPower >= 20 && computerLCD < 100) {
					computerLaser(computerPower, computerDamage, 2);
					waitFor = 2;
				} 	
	 		} else if (computerCoolDown > 0) {
	 			diceRoll = rollDice.nextInt(3);
	 			if (diceRoll == 0 || diceRoll == 1 && computerLCD < 100) {
	 				computerLaser(computerPower, computerDamage, 1);
	 			}
	 		} else {
	 			diceRoll = rollDice.nextInt(3);
	 			if (diceRoll == 0) {
	 				if (computerPower >= 50 && computerLCD < 100) {
	 					computerLaser(computerPower, computerDamage, 3);
	 				} else if (computerPower >= 10 && computerLCD < 100) {
	 					computerLaser(computerPower, computerDamage, 1);
	 				} else {
	 					wait = true;
	 				}
	 			} else if (diceRoll == 1) {
	 				if (computerPower >= 50 && computerMissiles > 0) {
	 					computerMissile(computerMissiles, computerCoolDown, computerDamage, comNullShields);
	 				} else if (computerPower >= 20 && computerLCD < 100) {
	 					computerLaser(computerPower, computerDamage, 2);
	 				}
	 			} else if (diceRoll == 2) {
	 				if (computerPower >= 40) {
	 					computerShield(computerPower, computerShields, 2);
	 				} else if (computerPower >= 25) {
	 					computerShield(computerPower, computerShields, 1);
	 				}
	 			}
	 		}
		} else {
			if (wait) {
				wait = false;
			} else if (waitFor > 0) {
				waitFor--;
			}
		}
		
		if (this.computerCoolDown > 0) {
			if (this.computerPower >= this.computerCoolDown) {
				this.computerPower -= this.computerCoolDown;
				this.computerCoolDown = 0;
			} else if (this.computerPower < this.computerCoolDown) {
				this.computerCoolDown -= this.computerPower;
				this.computerPower = 0;
			}
			
		}
		
		
		
		if (comNullShields != true && comIonShields != true) {
			this.yourShields -= computerDamage;
			if (this.yourShields <= 0) {
				this.yourShields = 0;
				this.yourHull -= this.computerDamage * 2;
			} else if (this.yourShields <= 5) {
				this.yourHull -= this.computerDamage;
			} else if (this.yourShields <= 10) {
				this.yourHull -= this.computerDamage / 2;
			}
			
		} else if (comIonShields == true) {
			this.yourShields -= computerDamage;
			this.comIonShields = false;
		} else {
			this.yourHull -= this.computerDamage * 2;
			comNullShields = false;
		}
		
		comLaserCoolDown();

	}
	
	public void lyrianAi(int yourHull, int computerHull, int yourShields, int computerShields, int computerPower) {

		computerDamage = 0;
		this.yourShields = yourShields;
		this.yourHull = yourHull;
		this.computerPower = computerPower;
		this.computerShields = computerShields;
		if(comPowerCore) {
			if (computerPower < computerMaxPower) {
				this.computerPower += computerPowerRegen;
			}
			if (this.computerPower > computerMaxPower) {
			this.computerPower = computerMaxPower;
			}
		} else {
			if (computerPower < computerMaxPower) {
				this.computerPower += 10;
			}
			if (this.computerPower > computerMaxPower) {
			this.computerPower = computerMaxPower;
			}
		}
		
		
		if (computerShields < computerMaxShields) {
			if (ionCharge > 0) {
				this.computerShields += 1;
			} else {
				this.computerShields += computerShieldRegen;
			}
		}	
		if (comIonCanon) {
			if (this.comIonCharge > 0) {
				this.comIonCharge--;	
			}
		} else {
			comIonCharge = 0;
		}
		
		//Put new Ai here:
		
		
		if (this.computerCoolDown > 0) {
			if (this.computerPower >= this.computerCoolDown) {
				this.computerPower -= this.computerCoolDown;
				this.computerCoolDown = 0;
			} else if (this.computerPower < this.computerCoolDown) {
				this.computerCoolDown -= this.computerPower;
				this.computerPower = 0;
			}
			
		}
		if (comNullShields != true && comIonShields != true) {
			this.yourShields -= computerDamage;
			if (this.yourShields <= 0) {
				this.yourShields = 0;
				this.yourHull -= this.computerDamage * 2;
			} else if (this.yourShields <= 5) {
				this.yourHull -= this.computerDamage;
			} else if (this.yourShields <= 10) {
				this.yourHull -= this.computerDamage / 2;
			}
			
		} else if (comIonShields == true) {
			this.yourShields -= computerDamage;
			this.comIonShields = false;
		} else {
			this.yourHull -= this.computerDamage * 2;
			comNullShields = false;
		}
		
	}
	
	public void computerShip() {
		//diceRoll = rollDice.nextInt(3);
		diceRoll = 1;
		switch (diceRoll) {
			case 0 :
				Starship cetacea = new Starship();
				cetacea.setHull(120);
				cetacea.setShields(25);
				cetacea.setShieldRegen(2);
				cetacea.setPower(150);
				cetacea.setPowerRegen(20);
				cetacea.setMissiles(2);
				cetacea.setIonCanon(1);
				
				computerHull = cetacea.hull;
				computerShields = cetacea.shields;
				computerShieldRegen = cetacea.shieldRegen;
				computerPower = cetacea.power;
				computerPowerRegen = cetacea.powerRegen;
				computerMissiles = cetacea.missiles;
				computerIon = cetacea.ionCanon;
				computerMaxPower = cetacea.power;
				computerMaxShields = cetacea.shields;
				computerMaxHull = cetacea.hull;
				System.out.println();
				System.out.println("The computer has choosen: Cetacea class");
			break;
			
			case 1 :
				Starship barius = new Starship();
				barius.setHull(80);
				barius.setShields(18);
				barius.setShieldRegen(4);
				barius.setPower(90);
				barius.setPowerRegen(30);
				barius.setMissiles(3);
				barius.setIonCanon(4);
				
				computerHull = barius.hull;
				computerShields = barius.shields;
				computerShieldRegen = barius.shieldRegen;
				computerPower = barius.power;
				computerPowerRegen = barius.powerRegen;
				computerMissiles = barius.missiles;
				computerIon = barius.ionCanon;
				computerMaxPower = barius.power;
				computerMaxShields = barius.shields;
				computerMaxHull = barius.hull;
				System.out.println();
				System.out.println("The computer has choosen: Barius class");
			break;
			
			case 2 : 
				Starship lyrian = new Starship();
				lyrian.setHull(90);
				lyrian.setShields(20);
				lyrian.setShieldRegen(4);
				lyrian.setPower(120);
				lyrian.setPowerRegen(25);
				lyrian.setMissiles(5);
				lyrian.setIonCanon(2);
				
				computerHull = lyrian.hull;
				computerShields = lyrian.shields;
				computerShieldRegen = lyrian.shieldRegen;
				computerPower = lyrian.power;
				computerPowerRegen = lyrian.powerRegen;
				computerMissiles = lyrian.missiles;
				computerIon = lyrian.ionCanon;
				computerMaxPower = lyrian.power;
				computerMaxShields = lyrian.shields;
				computerMaxHull = lyrian.hull;
				System.out.println();
				System.out.println("The computer has choosen: Lyrian class");
			break;
		}
	}
	
	public void computerShield(int computerPower, int computerShields, int number) {
	
		if (number == 3) {
			this.computerShields += 7;
			this.computerPower -= 65;
			System.out.println();
			System.out.println("The computer charges his shields: Computer Shields +7");
		} else if (number == 2) {
			this.computerShields += 5;
			this.computerPower -= 40;
			System.out.println();
			System.out.println("The computer charges his shields: Computer Shields +5");
		} else if (number== 1) {
			this.computerShields += 3;
			this.computerPower -= 25;
			System.out.println();
			System.out.println("The computer charges his shields: Computer Shields +3");
		}
	}
	
	public void computerLaser(int computerPower, int computerDamage, int number) {
		if (number == 3) {
			this.computerDamage = 12;
			this.computerPower -= 50;
			comAttack = 3;
			
		} else if (number== 2) {
			this.computerDamage = 8;
			this.computerPower -= 20;
			comAttack = 2;
		} else if (number== 1) {
			this.computerDamage = 4;
			this.computerPower -= 10;
			comAttack = 1;
		}
		if (this.yourShields < 0) {
			this.yourShields = 0;
		}
		System.out.println();
		System.out.println("The computer fires lasers dealing " + this.computerDamage + " damage");
		
	}

	public void computerMissile(int computerMissiles, int computerCoolDown, int computerDamage, boolean comNullShields) {
		
		this.computerDamage = 8;
		this.computerCoolDown = 80;
		this.computerMissiles -= 1;
		this.comNullShields = true;
		System.out.println();
		System.out.println("The computer fires a missile dealing " + this.computerDamage + " damage");

	}
	
	public void computerIonCanon(int computerDamage, int computerPower, boolean comIonShields, int ionCharge) {
		
		this.computerDamage = 15;
		this.computerPower -= 80;
		this.comIonShields = true;
		this.comIonCharge = computerIon;
		System.out.println();
		System.out.println("The computer fires his ion canon dealing " + this.computerDamage + " damage");
	}
	
	public void shield(String input2, int yourPower, int yourShields) {
		
		
		this.yourShields = yourShields;
		this.yourPower = yourPower;
		
		if ("high".equals(input2) && yourPower - 65 < 0) {
			System.out.println("You need more power.");
		} else if ("med".equals(input2) && yourPower - 40 < 0) {
			System.out.println("You need more power.");
		} else if ("low".equals(input2) && yourPower - 25 < 0) {
			System.out.println("You need more power.");
		} else {
			switch (input2) {
			case "high":
				this.yourShields += 7;
				this.yourPower -= 65;
				System.out.println("You charge your shields: Shields +7");
				System.out.println();
				break;
				
			case "med":
				this.yourShields += 5;
				this.yourPower -= 40;
				System.out.println("You charge your shields: Shields +5");
				System.out.println();
				break;
			
			case "low":
				this.yourShields += 3;
				this.yourPower -= 25;
				System.out.println("You charge your shields: Shields +3");
				System.out.println();
				break;
				
				
			}
		}

	}
	
	public void laser(String input2, int yourPower, int yourDamage, boolean boo) {
		
		
		if (boo) {
			this.yourPower = yourPower;
			this.yourDamage = 0;
			if ("high".equals(input2) && yourPower - 50 < 0) {
				System.out.println("You need more power.");
				this.yourDamage = 0;
			} else if ("med".equals(input2) && yourPower - 20 < 0) {
				System.out.println("You need more power.");
				this.yourDamage = 0;
			} else if ("low".equals(input2) && yourPower - 10 < 0) {
				System.out.println("You need more power.");
				this.yourDamage = 0;
			} else {
				switch (input2) {
				case "high":
					this.yourDamage = 12;
					this.yourPower -= 50;
					System.out.println();
					System.out.println("Your fire lasers dealing " + this.yourDamage + " damage");
					attack = 3;
					break;
				
				case "med":
					this.yourDamage = 8;
					this.yourPower -= 20;
					System.out.println();
					System.out.println("Your fire lasers dealing " + this.yourDamage + " damage");
					attack = 2;
					break;
			
				case "low":
					this.yourDamage = 4;
					this.yourPower -= 10;
					System.out.println();
					System.out.println("Your fire lasers dealing " + this.yourDamage + " damage");
					attack = 1;
					break;
				
				}
				if (this.computerShields < 0) {
					this.computerShields = 0;
				}
				
			}
		} else {
			this.yourPower = yourPower;
			this.yourDamage = 0;
			if ("high".equals(input2)) {
				System.out.println("Your heavy canons have taken too much damage!");
				this.yourDamage = 0;
			} else if ("med".equals(input2) && yourPower - 20 < 0) {
				System.out.println("You need more power.");
				this.yourDamage = 0;
			} else if ("low".equals(input2) && yourPower - 10 < 0) {
				System.out.println("You need more power.");
				this.yourDamage = 0;
			} else {
				switch (input2) {
				
				case "med":
					this.yourDamage = 8;
					this.yourPower -= 20;
					System.out.println();
					System.out.println("Your fire lasers dealing " + this.yourDamage + " damage");
					break;
			
				case "low":
					this.yourDamage = 4;
					this.yourPower -= 10;
					System.out.println();
					System.out.println("Your fire lasers dealing " + this.yourDamage + " damage");
					break;
				
				}
			}
		}
		
	}
	
	public void missile(String input2, int yourMissiles, int yourDamage, int yourCoolDown, boolean nullShields) {
		
		this.yourCoolDown = yourCoolDown;
		this.yourMissiles = yourMissiles;
		this.yourDamage = yourDamage;
		this.nullShields = nullShields;
		
		if(yourMissiles > 0 && yourCoolDown <= 0) {
			this.yourMissiles--;
			this.yourCoolDown = 80;
			this.yourDamage = 8;	
			this.nullShields = true;
		} else if (yourMissiles <= 0) {
			System.out.println("You need more missiles!");
			this.yourDamage = 0;
		} else {
			System.out.println("You are still on cooldown!");
			this.yourDamage = 0;
		}
		System.out.println("You fire a missile dealing " + this.yourDamage + " damage");
	}

	public void ionCanon(int yourDamage, int yourPower, int ionCharge, int yourIon) {
		this.yourPower = yourPower;
		this.ionCharge = ionCharge;
		if (yourPower >= 75) {
			this.yourDamage = 15;
			this.yourPower -= 75;
			ionShields = true;
			this.ionCharge = yourIon;
			System.out.println();
			System.out.println("You fire your ion canon dealing " + this.yourDamage + " damage");
		} else {
			System.out.println("You need more power!");
			this.yourDamage = 0;
		}
		
	}
	
	public void yourAttack(int computerShields, int computerHull, int yourDamage, boolean nullShields) {
		
		this.computerHull = computerHull;
		this.computerShields = computerShields;
		this.nullShields = nullShields;
		if (nullShields != true && ionShields != true) {
			this.computerShields -= this.yourDamage;
			if (this.computerShields <= 0) {
				this.computerShields = 0;
				this.computerHull -= this.yourDamage * 2;
			} else if (this.computerShields <= 5) {
				this.computerHull -= this.yourDamage;
			} else if (this.computerShields <= 10) {
				this.computerHull -= this.yourDamage / 2;
			}
			
		} else if (ionShields == true) {
			this.computerShields -= this.yourDamage;
			ionShields = false;
		} else {
			this.computerHull -= this.yourDamage * 2;
			this.nullShields = false;
		}
	}
	
	public void laserCoolDown () {
		
		if (attack > 0) {
			switch (attack) {
				case 3:
					yourLCD += 50;
					doAttack = true;
				break;
				
				case 2:
					yourLCD += 35;
					doAttack = true;
				break;
				
				case 1:
					yourLCD += 25;
					doAttack = true;
				break;
			}
			if (yourLCD >= 100) {
				yourLCD = 100;
				overHeat = true;
				heatFor = 2;
				System.out.println("Your lasers have overheated!");
			}
			attack = 0;
		}
		if (!doAttack) {
			if (!overHeat && yourLCD > 0) {
				yourLCD -= 25;
				if (yourLCD < 0) {
					yourLCD = 0;
				}
			} else if (overHeat) {
				if (heatFor > 0) {
					heatFor--;
				}
				if (heatFor == 0) {
					overHeat = false;
				}
			}
			
		} else {
			doAttack = false;
		}
	}
	
	public void comLaserCoolDown () {

		if (comAttack > 0) {
			switch (comAttack) {
				case 3:
					computerLCD += 50;
					comDoAttack = true;
				break;
				
				case 2:
					computerLCD += 35;
					comDoAttack = true;
				break;
				
				case 1:
					computerLCD += 25;
					comDoAttack = true;
				break;
			}
			if (computerLCD >= 100) {
				computerLCD = 100;
				comOverHeat = true;
				comHeatFor = 2;
			}
			comAttack = 0;
		}
		if (!comDoAttack) {
			if (!comOverHeat && computerLCD > 0) {
				computerLCD -= 25;
				if (computerLCD < 0) {
					computerLCD = 0;
				}
			} else if (comOverHeat) {
				if (comHeatFor > 0) {
					comHeatFor--;
				}
				if (comHeatFor == 0) {
					comOverHeat = false;
				}
			}
			
		} else {
			comDoAttack = false;
		}
	}
	
 	public int getShields() {
		return yourShields;
	}
	
	public int getPower() {
		return yourPower;
	}
	
	public int getDamage() {
		return yourDamage;
	}
	
	public int getComDamage() {
		return computerDamage;
	}
	
	public int getCoolDown() {
		return yourCoolDown;
	}
	
	public int getMissiles() {
		return yourMissiles;
	}
	
	public boolean getNull() {
		return nullShields;
	}
	
	public int getComShields() {
		return this.computerShields;
	}
	
	public int getComHull() {
		return computerHull;
	}
	
	public int getYourHull() {
		return this.yourHull;
	}
	
	public int getComPower() {
		return computerPower;
	}

	public int getScore() {
		return this.score;
	}
	
	public int getCharge() {
		return this.ionCharge;
	}
	
	public int getYourLCD() {
		return this.yourLCD;
	}
	
	public int getComCharge() {
		return this.comIonCharge;
	}
	
	public boolean getHeavyL() {
		return this.heavyLasers;
	}
	
	public boolean getIonC() {
		return this.ionCanon;
	}
	
	public boolean getPowerC() {
		return this.powerCore;
	}

	public void getComStats() {
		System.out.println("Computer shields at " + computerShields + "/" + computerMaxShields);
		System.out.println("Computer hull at " + computerHull + "/" + computerMaxHull);
		
	}
}