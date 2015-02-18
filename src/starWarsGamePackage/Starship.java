package starWarsGamePackage;

public class Starship {

	int hull = 100;
	int shields = 20;
	int shieldRegen = 5;
	int power = 100;
	int powerRegen = 100;
	int missiles = 3;
	int ionCanon = 3;
	
	void setHull(int newHull) {
		hull = newHull;
	}
	
	void setShields(int newShields) {
		shields = newShields;
	}
	
	void setShieldRegen(int newShieldRegen) {
		shieldRegen = newShieldRegen;
	}
	
	void setPower(int newPower) {
		power = newPower;
	}
	
	void setPowerRegen(int newPowerRegen) {
		powerRegen = newPowerRegen;
	}
	
	void setMissiles(int newMissiles) {
		missiles = newMissiles;
	}
	
	void setIonCanon(int newIonCanon) {
		ionCanon = newIonCanon;
	}
	
}