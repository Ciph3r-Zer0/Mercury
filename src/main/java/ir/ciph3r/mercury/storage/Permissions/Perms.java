package ir.ciph3r.mercury.storage.Permissions;

public class Perms {
	public static String NICKNAME;
	public static String NICKNAME_OTHERS;
	public static String FLY;
	public static String FLY_OTHERS;
	public static String GAMEMODE;

	public void init() {
		NICKNAME = "mercury.commands.nickname";
		NICKNAME_OTHERS = "mercury.commands.nickname.others";
		FLY = "mercury.commands.fly";
		FLY_OTHERS = "mercury.commands.fly.others";
		GAMEMODE = "mercury.commands.gamemode";
	}
}
