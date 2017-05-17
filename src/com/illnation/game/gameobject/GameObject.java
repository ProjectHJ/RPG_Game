package com.illnation.game.gameobject;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import java.awt.Graphics;

import com.illnation.engine.Sprite;
import com.illnation.error.ErrorCodes;
import com.illnation.game.gameobject.enemy.monster.Goblin;

public abstract class GameObject {
	private static final ErrorCodes code = new ErrorCodes();
	protected int type;
	protected float x, y, sx, sy;
	protected Sprite spr;
	protected Goblin goblin;

	protected static final int PLAYER_ID = 2;
	protected static final int ITEM_ID = 1;

	protected boolean[] flags = new boolean[1];

	public void update() {

	}

	public void render() {
		try {
			glPushMatrix();
			{
				glTranslatef(x, y, 0);
				spr.render();
			}
			glPopMatrix();
		} catch (Exception e) {
			System.err.println(code.OpenGLInitializationErrorCode + ": " + code.OpenGLInitializationErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getSX() {
		return spr.getSX();
	}

	public float getSY() {
		return spr.getSY();
	}

	public int getType() {
		return type;
	}

	public boolean getRemove() {
		return flags[0];
	}

	public void remove() {
		flags[0] = true;
	}

	protected void init(float x, float y, float r, float g, float b, float sx, float sy, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.spr = new Sprite(r, g, b, sx, sy);
	}
}
