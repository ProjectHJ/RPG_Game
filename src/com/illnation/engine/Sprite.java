package com.illnation.engine;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;

public class Sprite {

	private float red, blue, green, sx, sy;

	public Sprite(float red, float blue, float green, float sx, float sy) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.sx = sx;
		this.sy = sy;
	}

	public void render() {
		glColor3f(red, blue, green);
		drawFilledCircle(sx, sy, 16);
		glEnd();
	}

	public float getSX() {
		return sx;
	}

	public void setSX(float sx) {
		this.sx = sx;
	}

	public float getSY() {
		return sy;
	}

	public void setSY(float sy) {
		this.sy = sy;
	}

	public void drawFilledCircle(float x, float y, float radius) {
		int i;
		int triangleAmount = 20; // # of triangles used to draw circle

		// GLfloat radius = 0.8f; //radius
		float twicePi = (float) (2.0f * Math.PI);

		glBegin(GL_TRIANGLE_FAN);
		glVertex2f(x, y); // center of circle
		for (i = 0; i <= triangleAmount; i++) {
			GL11.glVertex2d(x + (radius * Math.cos(i * twicePi / triangleAmount)), y + (radius * Math.sin(i * twicePi / triangleAmount)));
		}
		glEnd();
	}

}
