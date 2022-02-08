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
	}
}
