package com.illnation.game;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import com.illnation.game.gameobject.GameObject;
import com.illnation.game.gameobject.enemy.monster.Goblin;
import com.illnation.game.gameobject.player.Player;

public class Game {

	private ArrayList<GameObject> objects;
	private ArrayList<GameObject> remove;

	private Player player;

	public Game() {

		objects = new ArrayList<GameObject>();
		remove = new ArrayList<GameObject>();

		player = new Player(Display.getWidth() / 2 - Player.width, Display.getHeight() / 2 - Player.height);

		objects.add(player);
		
		// Add objects below this line!

		objects.add(new Goblin(0, 0, 1));

		// Add objects above this line!
	}

	public void getInput() {
		player.getInput();
	}

	public void update() {
		for (GameObject go : objects) {

			if (!go.getRemove()) {
				go.update();
			} else {
				remove.add(go);
			}
		}

		for (GameObject go : remove) {
			objects.remove(go);
		}
	}

	public void render() {
		for (GameObject go : objects) {
			go.render();
		}
	}

	public ArrayList<GameObject> sphereCollide(float x, float y, float radius) {
		ArrayList<GameObject> res = new ArrayList<>();

		for (GameObject go : objects) {
			if (Util.distance(go.getX(), go.getY(), x, y) < radius) {
				res.add(go);
			}
		}

		return res;
	}
}
