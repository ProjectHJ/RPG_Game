package com.illnation.game.gameobject;

import com.illnation.game.gameobject.player.Stats;

public class StatObject extends GameObject {

	protected Stats stats;

	public void damage(int amount) {
		stats.damage(amount);
	}

	public int getCurrentHealth() {
		return Stats.getCurrentHealth();
	}

	public int getMaxHealth() {
		return Stats.getMaxHealth();
	}

	public float getAttack() {
		return Stats.getAttack();
	}

	public float getWisdom() {
		return Stats.getWisdom();
	}

	public float getSpeed() {
		return Stats.getSpeed();
	}

	public float getDexterity() {
		return Stats.getDexterity();
	}

	public float getMagic() {
		return Stats.getMagic();
	}

}
