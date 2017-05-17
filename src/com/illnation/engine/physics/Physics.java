package com.illnation.engine.physics;

import java.awt.Rectangle;

import com.illnation.game.gameobject.GameObject;

public class Physics {
	public static GameObject checkCollision(GameObject obj1, GameObject obj2) {
		Rectangle r1 = new Rectangle((int) obj1.getX(), (int) obj1.getY(), (int) obj1.getSX(), (int) obj1.getSY());
		Rectangle r2 = new Rectangle((int) obj2.getX(), (int) obj2.getY(), (int) obj2.getSX(), (int) obj2.getSY());

		boolean res = r1.intersects(r2);

		if (res) {
			return obj2;
		} else {
			return null;
		}
	}
}
