package com.illnation.game.gameobject.player;

@SuppressWarnings({ "unused", "static-access" })
public class Stats {

	public final static double constantLevel = 25 * Math.pow(3, (3.0 / 2.0));
	public static int experience;
	public static int XPGoal;
	public static int health = 100;
	public static int level;
	public static int speed;

	private static boolean levelable;

	public Stats(int experience, boolean levelable) {
		this.levelable = levelable;
		if (levelable) {
			this.experience = experience;
			this.level = 1;
		} else {
			this.experience = -1;
			this.level = (int) experience;
		}

		health = getMaxHealth();
	}

	public static void update() {
		// System.out.println("Level:" + getLevel() + " Experience: " +
		// Stats.experience + "/" + XPGoal + " " + getCurrentHealth() + "/" +
		// getMaxHealth());
	}

	public static int getLevel() {
		if (!levelable) {
			return level;
		}

		switch (experience) {
		case 50:
			level = 1;
			XPGoal = 200;
			break;
		case 200:
			level = 2;
			XPGoal = 450;
			break;
		case 450:
			level = 3;
			XPGoal = 700;
			break;
		case 700:
			level = 4;
			XPGoal = 950;
			break;
		case 950:
			level = 5;
			XPGoal = 1350;
			break;
		case 1350:
			level = 6;
			XPGoal = 1800;
			break;
		case 1800:
			level = 7;
			XPGoal = 2300;
			break;
		case 2300:
			level = 8;
			XPGoal = 2950;
			break;
		case 2950:
			level = 9;
			XPGoal = 3650;
			break;
		case 3650:
			level = 10;
			XPGoal = 4300;
			break;
		case 4300:
			level = 11;
			XPGoal = 5100;
			break;
		case 5100:
			level = 12;
			XPGoal = 6000;
			break;
		case 6000:
			level = 13;
			XPGoal = 7150;
			break;
		case 7150:
			level = 14;
			XPGoal = 8350;
			break;
		case 8350:
			level = 15;
			XPGoal = 10500;
			break;
		case 10500:
			level = 16;
			XPGoal = 13550;
			break;
		case 13550:
			level = 17;
			XPGoal = 17850;
			break;
		case 17850:
			level = 18;
			XPGoal = 18650;
			break;
		case 18650:
			level = 19;
			XPGoal = 20000;
			break;
		case 20000:
			level = 20;
			break;
		}
		return level;
	}

	public static int getCurrentHealth() {
		int max = getMaxHealth();
		if (health > max) {
			health = max;
		}

		return (int) health;
	}

	public static int getMaxHealth() {
		return (int) getLevel() * health;
	}

	public static float getAttack() {
		return (float) getLevel();
	}

	public static float getWisdom() {
		return (float) getLevel();
	}

	public static float getSpeed() {
		return (float) (4 + 5.6 * (getLevel() / 75));
	}

	public static float getDexterity() {
		return (float) getLevel();
	}

	public static float getMagic() {
		return (float) getLevel();
	}

	public void damage(int amount) {
		health -= amount;
	}

}
