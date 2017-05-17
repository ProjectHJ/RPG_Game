package com.illnation.game.gameobject.item;

import com.illnation.engine.Sprite;
import com.illnation.engine.physics.Physics;
import com.illnation.game.gameobject.GameObject;
import com.illnation.game.gameobject.player.Player;

public class Item extends GameObject {

	protected String name;

	protected Player player;

	public Item(Player player) {
		this.player = player;
	}

	public void pickUpItem() {
		System.out.println("Player picked up " + name);
		player.addItem(this);
		remove();
	}

	@Override
	public void update() {
		if (Physics.checkCollision(this, player) != null) {
			pickUpItem();
		}
	}

	public String getName() {
		return name;
	}

	protected void init(float x, float y, float r, float g, float b, float sx, float sy, String name) {
		this.x = x;
		this.y = y;
		this.type = ITEM_ID;
		this.spr = new Sprite(r, g, b, sx, sy);
		this.name = name;
	}
}
