package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.yaml.models.Model;

public class Messages extends Model {
	public Messages(Mercury core) {
		super(core, "messages.yml");
	}

	//TODO: fix {prefix} in lists
	public static String PREFIX;
	public static String NO_PERMISSION;
	public static String NO_CONSOLE;
	public static String PLAYER_NOT_FOUND;

	public static String NICK_NAME_USAGE;
	public static String NICK_NAME_RESET;
	public static String NICK_NAME_CHANGED;
	public static String NICK_NAME_CHANGED_OTHERS;

	public static String FLY_ENABLED;
	public static String FLY_DISABLED;
	public static String FLY_ENABLED_ADMIN;
	public static String FLY_DISABLED_ADMIN;

	public static String GAMEMODE_CHANGED;

	@Override
	public void init() {
		PREFIX = getConfig().getString("Prefix");
		NO_PERMISSION = getConfig().getString("NoPermission").replace("{prefix}", PREFIX);
		NO_CONSOLE = getConfig().getString("NoConsole").replace("{prefix}", PREFIX);
		PLAYER_NOT_FOUND = getConfig().getString("PlayerNotFound").replace("{prefix}", PREFIX);

		NICK_NAME_USAGE = getConfig().getString("Modules.Nickname.Usage").replace("{prefix}", PREFIX);
		NICK_NAME_RESET = getConfig().getString("Modules.Nickname.Reset").replace("{prefix}", PREFIX);
		NICK_NAME_CHANGED = getConfig().getString("Modules.Nickname.Changed").replace("{prefix}", PREFIX);
		NICK_NAME_CHANGED_OTHERS = getConfig().getString("Modules.Nickname.ChangedOthers").replace("{prefix}", PREFIX);

		FLY_ENABLED = getConfig().getString("Modules.Fly.Enabled").replace("{prefix}", PREFIX);
		FLY_DISABLED = getConfig().getString("Modules.Fly.Disabled").replace("{prefix}", PREFIX);
		FLY_ENABLED_ADMIN = getConfig().getString("Modules.Fly.EnabledAdmin").replace("{prefix}", PREFIX);
		FLY_DISABLED_ADMIN = getConfig().getString("Modules.Fly.DisabledAdmin").replace("{prefix}", PREFIX);

		GAMEMODE_CHANGED = getConfig().getString("Modules.Gamemode.Change").replace("{prefix}", PREFIX);
	}
}
