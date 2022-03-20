package ir.ciph3r.mercury.storage.Permissions;

public class Perms {
	public static String RELOAD;

	public static String FLY;
	public static String FLY_OTHERS;

	public static String GAMEMODE;
	public static String GAMEMODE_OTHERS;

	public static String TELEPORT;
	public static String TELEPORT_OTHERS;

	public static String HAT;
	public static String HAT_OTHERS;

	public static String SHUFFLE;

	public static String ROTATE;

	public static String KNOCKBACK;

	public static String CLEAR_INVENTORY;

	public static String SPEED;

	public static String TELL;
	public static String REPLY;

	public static String CROSS_TELEPORT;

	public static String SUDO;

	public static String SPAWN;
	public static String SPAWN_OTHERS;
	public static String SET_SPAWN;

	public static String LIGHTENING;
	public static String LIGHTENING_OTHERS;

	public static String COORDINATES;
	public static String COORDINATES_OTHERS;

	public void init() {
		RELOAD = "mercury.commands.reload";

		FLY = "mercury.commands.fly";
		FLY_OTHERS = "mercury.commands.fly.others";

		GAMEMODE = "mercury.commands.gamemode";
		GAMEMODE_OTHERS = "mercury.commands.gamemode.others";

		TELEPORT = "mercury.commands.teleport";
		TELEPORT_OTHERS = "mercury.commands.teleport.others";

		HAT = "mercury.commands.hat";
		HAT_OTHERS = "mercury.commands.hat.otherst";

		SHUFFLE = "mercury.commands.shuffle";

		ROTATE = "mercury.commands.rotate";

		KNOCKBACK = "mercury.commands.knockback";

		CLEAR_INVENTORY = "mercury.commands.clearinventory";

		SPEED = "mercury.commands.speed";

		TELL = "mercury.commands.tell";
		REPLY = "mercury.commands.reply";

		CROSS_TELEPORT = "mercury.commands.crossteleport";

		SUDO = "mercury.commands.sudo";

		SPAWN = "mercury.commands.spawn";
		SPAWN_OTHERS = "mercury.commands.spawn.others";
		SET_SPAWN = "mercury.commands.setspawn";

		LIGHTENING = "mercury.commands.lightening";
		LIGHTENING_OTHERS = "mercury.commands.lightening.others";

		COORDINATES = "mercury.commands.coordinates";
		COORDINATES_OTHERS = "mercury.commands.coordinates.others";
	}
}
