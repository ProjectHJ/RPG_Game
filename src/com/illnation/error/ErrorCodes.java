package com.illnation.error;

public class ErrorCodes {
	public final String InitializationErrorCode = "0x000000";
	public final String InitializationErrorString = "Engine could not be initialized.";

	public final String DisplayInitializationErrorCode = "0x0000001";
	public final String DisplayInitializationErrorString = "Display could not be initialized.";

	public final String KeyboardInitializationErrorCode = "0x000002";
	public final String KeyboardInitializationErrorString = "Keyboard could not be intitialized";

	public final String OpenGLInitializationErrorCode = "0x000003";
	public final String OpenGLInitializationErrorString = "OpenGL could not be initialized.";

	public final String GameLoopInitializationErrorCode = "0x000004";
	public final String GameLoopInitializationErrorString = "Game loop could not be initialized.";

	public final String RenderEngineInitializationErrorCode = "0x000005";
	public final String RenderEngineInitializationErrorString = "Render engine could not be intitialized.";

	public final String UpdateEngineInitializationErrorCode = "0x000006";
	public final String UpdateEngineInitializationErrorString = "Update engine could not be intitialized.";

	public final String InputErrorCode = "0x000007";
	public final String InputErrorString = "Could not get the specified input.";

	public final String CleanUpErrorCode = "0x000008";
	public final String CleanUpErrorString = "Could not clean up.";

	public final String GameInitializationErrorCode = "0x000009";
	public final String GameInitializationErrorString = "Game could not be initialized.";

	public final String CollisionErrorCode = "0x0000a1";
	public final String CollisionErrorString = "Could not detect collision.";
}
