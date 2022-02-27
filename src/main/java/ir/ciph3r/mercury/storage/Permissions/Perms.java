package ir.ciph3r.mercury.storage.Permissions;

public class Perms {
	public static String NICKNAME;
	public static String NICKNAME_OTHERS;

	public static String FLY;
	public static String FLY_OTHERS;

	public static String GAMEMODE;
	public static String GAMEMODE_OTHERS;

	public static String TELEPORT;
	public static String TELEPORT_OTHERS;

	public static String HAT;

	public void init() {
		NICKNAME = "mercury.commands.nickname";
		NICKNAME_OTHERS = "mercury.commands.nickname.others";

		FLY = "mercury.commands.fly";
		FLY_OTHERS = "mercury.commands.fly.others";

		GAMEMODE = "mercury.commands.gamemode";
		GAMEMODE_OTHERS = "mercury.commands.gamemode.others";

		TELEPORT = "mercury.commands.teleport";
		TELEPORT_OTHERS = "mercury.commands.teleport.others";

		HAT = "mercury.commands.hat";
	}
}
