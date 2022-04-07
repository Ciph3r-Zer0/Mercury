package ir.ciph3r.mercury.storage.Permissions;

public class Perms {
	public static String
			RELOAD
			,FLY
			,FLY_OTHERS

			,GAMEMODE
			,GAMEMODE_OTHERS

			,TELEPORT
			,TELEPORT_OTHERS

			,HAT
			,HAT_OTHERS

			,SHUFFLE

			,ROTATE

			,KNOCKBACK

			,CLEAR_INVENTORY

			,SPEED

			,TELL
			,REPLY

			,CROSS_TELEPORT

			,SUDO

			,SPAWN
			,SPAWN_OTHERS
			,SET_SPAWN

			,LIGHTENING
			,LIGHTENING_OTHERS

			,COORDINATES
			,COORDINATES_OTHERS

			,BROADCAST

			,PLUGIN_LIST

			,HEAL
			,HEAL_OTHERS

			,FEED
			,FEED_OTHERS;

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

		BROADCAST = "mercury.commands.broadcast";

		PLUGIN_LIST = "mercury.commands.pluginlist";

		HEAL = "mercury.commands.heal";
		HEAL_OTHERS = "mercury.commands.heal.others";

		FEED = "mercury.commands.feed";
		FEED_OTHERS = "mercury.commands.feed.others";
	}
}