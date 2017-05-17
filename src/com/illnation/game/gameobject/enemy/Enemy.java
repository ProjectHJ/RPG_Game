package com.illnation.game.gameobject.enemy;

import com.illnation.game.Util;
import com.illnation.game.gameobject.GameObject;
import com.illnation.game.gameobject.StatObject;
import com.illnation.game.gameobject.player.Stats;
import com.illnation.game.time.Delay;

public class Enemy extends StatObject {

	private float attackRange;
	private Delay attackDelay;
	private StatObject target;

	protected static float sightRange = 128f;

	public Enemy(int level) {
		stats = new Stats(level, false);
		target = null;
		attackDelay = new Delay(0);
		attackRange = 48;
		attackDelay.start();
	}

	@Override
	public void update() {
		 if (target == null) {
			look();
		} else {
			if (attackDelay.over() && Util.lineOfSight(this, target) && Util.distance(x, y, getTarget().getX(), getTarget().getY()) <= attackRange) {
				attack();
			} else {
				if (Util.distance(x, y, getTarget().getX(), getTarget().getY()) >= sightRange * 2) {
					look();
				} else {
					chase();
				}
			}
		}

		if (Stats.getCurrentHealth() <= 0) {
			death();
		}
	}

	protected void attack() {

	}

	protected void look() {

	}

	protected void chase() {

	}

	protected void death() {

	}

	public void setTarget(StatObject go) {
		target = go;
	}

	public GameObject getTarget() {
		return target;
	}

	public Stats getStats() {
		return stats;
	}
	
	public void getAttackRange() {
		
	}

}
