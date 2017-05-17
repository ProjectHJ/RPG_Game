package com.illnation.game;

import com.illnation.game.gameobject.GameObject;

public class Util {

	public static boolean lineOfSight(GameObject obj1, GameObject obj2) {
		return true;
	}

	public static float distance(float x1, float y1, float x2, float y2) {
		double x = x2 - x1;
		double y = y2 - y1;

		return (float) Math.sqrt((x * x) + (y * y));
	}

}
