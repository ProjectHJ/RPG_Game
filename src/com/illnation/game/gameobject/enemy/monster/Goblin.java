package com.illnation.game.gameobject.enemy.monster;

import java.util.ArrayList;

import com.illnation.engine.Main;
import com.illnation.game.gameobject.GameObject;
import com.illnation.game.gameobject.StatObject;
import com.illnation.game.gameobject.enemy.Enemy;
import com.illnation.game.gameobject.player.Player;
import com.illnation.game.gameobject.player.Stats;

public class Goblin extends Enemy {

	public static final int width = 32, height = 32;
	public static final float damping = 0.39000001f;
	public static final float sightRange = 128f;

	public Goblin(float x, float y, int level) {
		super(level);
		this.init(x, y, 0.00001f, 0.5f, 0.000001f, width, height, 0);
		
		//attackRange = setAttackRange();
	}

	@Override
	protected void look() {
		ArrayList<GameObject> objects = Main.sphereCollide(x, y, sightRange);

		for (GameObject go : objects) {
			if (go.getType() == PLAYER_ID) {
				setTarget((StatObject) go);
			}
		}
	}

	@Override
	protected void chase() {
		float speedX = getTarget().getX() - x;
		float speedY = getTarget().getY() - y;

		float maxSpeed = Stats.getSpeed() * damping;

		if (speedX < maxSpeed) {
			speedX = -maxSpeed;
		}
		if (speedX > maxSpeed) {
			speedX = maxSpeed;
		}
		if (speedY < maxSpeed) {
			speedY = -maxSpeed;
		}
		if (speedY > maxSpeed) {
			speedY = maxSpeed;
		}

		x = x + speedX;
		y = y + speedY;
	}

	@Override
	protected void attack() {
		System.err.println("[" + Main.ft.format(Main.date) + "]" + "Goblin: Shooting " + Player.name + "_" + Player.name.length());
	}

	@Override
	protected void death() {
		remove();
	}
}
