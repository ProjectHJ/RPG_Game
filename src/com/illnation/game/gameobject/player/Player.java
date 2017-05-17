package com.illnation.game.gameobject.player;

import org.lwjgl.input.Keyboard;

import com.illnation.game.gameobject.StatObject;
import com.illnation.game.gameobject.inventory.Inventory;
import com.illnation.game.gameobject.item.Item;
import com.illnation.game.text.Text;

@SuppressWarnings("unused")
public class Player extends StatObject {

	public static final float width = 32, height = 32;
	public static String name = "Player";

	private Stats stats;
	private Inventory inventory;
	private Text t = new Text();

	public Player(float x, float y) {
		init(x, y, 0.89f, 0.5f, 0.18f, width, height, 2);
		stats = new Stats(0, true);
		inventory = new Inventory(20);
	}

	@Override
	public void update() {
		Stats.update();
	}

	public void addItem(Item item) {
		inventory.add(item);
	}

	public void getInput() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			move(0, 1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			move(0, -1);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			move(-1, 0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			move(1, 0);
		}
	}

	private void move(float magX, float magY) {
		x += (getSpeed() * magX);
		y += (getSpeed() * magY);
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}
