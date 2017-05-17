package com.illnation.engine;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.illnation.error.ErrorCodes;
import com.illnation.game.Game;
import com.illnation.game.gameobject.GameObject;
import com.illnation.game.gameobject.enemy.monster.Goblin;
import com.illnation.game.time.Time;

public class Main {

	public static final int red = 0, blue = 255, green = 0, alpha = 0, fps = 60, majVersion = 0, minVersion = 0, releaseVersion = 1;
	public static final boolean sync = true;
	public static final String build = "Alpha", name = "RPG";
	public static final String title = name + " " + majVersion + "." + minVersion + "." + releaseVersion + "_" + build;

	private static final ErrorCodes code = new ErrorCodes();
	private static Game game = new Game();

	public static Date date = new Date();
	public static SimpleDateFormat ft = new SimpleDateFormat("kk:mm:ss");
	public static long timeNow = System.currentTimeMillis();

	private static Goblin goblin;

	public static void main(String[] args) {

		System.out.println("[" + ft.format(date) + "]" + "Welcome to " + title);

		try {
			System.out.println("[" + ft.format(date) + "]" + "Initializing Display");
			initDisplay();
			System.out.println("[" + ft.format(date) + "]" + "Initialized Display");

			System.out.println("[" + ft.format(date) + "]" + "Initializing OpenGL");
			initGL();
			System.out.println("[" + ft.format(date) + "]" + "Initialized OpenGL");

			System.out.println("[" + ft.format(date) + "]" + "Initializing Game");
			initGame();
			System.out.println("[" + ft.format(date) + "]" + "Initialized Game");

			System.out.println("[" + ft.format(date) + "]" + "Starting Game Loop");
			gameLoop();
			System.out.println("[" + ft.format(date) + "]" + "Game Loop Started");

			System.out.println("[" + ft.format(date) + "]" + "Cleaning up");
			cleanUp();
			System.out.println("[" + ft.format(date) + "]" + "Cleaned up");

		} catch (Exception e) {
			System.err.println(code.InitializationErrorCode + ": " + code.InitializationErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static ArrayList<GameObject> sphereCollide(float x, float y, float radius) {
		return game.sphereCollide(x, y, radius);
	}

	private static void initDisplay() {

		try {
			int width = 480, height = width / 16 * 10, scale = 2;
			Display.setDisplayMode(new DisplayMode(width * scale, height * scale));
			Display.create();
			Keyboard.create();
			Display.setVSyncEnabled(sync);
			Display.setTitle(title);

			System.out.println("[" + ft.format(date) + "]" + "Created Display: " + width + "x" + height + ", with x" + scale + " scale");

		} catch (LWJGLException e) {
			System.err.println(code.DisplayInitializationErrorCode + ": " + code.DisplayInitializationErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void initGL() {
		try {
			GL11.glMatrixMode(GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
			GL11.glMatrixMode(GL_MODELVIEW);

			GL11.glDisable(GL_DEPTH_TEST);

			GL11.glClearColor(red, green, blue, alpha);
		} catch (Exception e) {
			System.err.println(code.OpenGLInitializationErrorCode + ": " + code.OpenGLInitializationErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void gameLoop() {
		try {
			Time.init();
			while (!Display.isCloseRequested()) {
				Time.update();
				getInput();
				update();
				render();
			}
		} catch (Exception e) {
			System.err.println(code.GameLoopInitializationErrorCode + ": " + code.GameLoopInitializationErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void render() {
		try {
			GL11.glClear(GL_COLOR_BUFFER_BIT);
			GL11.glLoadIdentity();

			game.render();

			Display.update();
			Display.sync(fps);

		} catch (Exception e) {
			System.err.println(code.RenderEngineInitializationErrorCode + ": " + code.RenderEngineInitializationErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void update() {
		try {
			game.update();
		} catch (Exception e) {
			System.err.println(code.GameLoopInitializationErrorCode + ": " + code.GameLoopInitializationErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void getInput() {
		try {
			game.getInput();
		} catch (Exception e) {
			System.err.println(code.InputErrorCode + ": " + code.InputErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void cleanUp() {
		try {
			Display.destroy();
			Keyboard.destroy();
		} catch (Exception e) {
			System.err.println(code.CleanUpErrorCode + ": " + code.CleanUpErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}

	private static void initGame() {
		try {
			game = new Game();
		} catch (Exception e) {
			System.err.println(code.GameInitializationErrorCode + ": " + code.GameInitializationErrorString);
			e.printStackTrace();
			System.exit(0);
		}
	}
}
