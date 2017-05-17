package com.illnation.game.gameobject.item.cube;

import com.illnation.game.gameobject.item.Item;
import com.illnation.game.gameobject.player.Player;

public class Cube extends Item {

	public static final float width = 32, height = 32;

	public Cube(float x, float y, Player player) {
		super(player);
		init(x, y, 0.5f, 1.0f, 0.5f, width, height, "cube");
	}
}
