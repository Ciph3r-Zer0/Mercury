package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.modules.tell.Tell;
import ir.ciph3r.mercury.storage.yaml.models.Model;

public class Messages extends Model {
	public Messages(Mercury mercury) {
		super(mercury, "messages.yml");
	}

	public static String PREFIX;
	public static String NO_PERMISSION;
	public static String NO_CONSOLE;
	public static String PLAYER_NOT_FOUND;
	public static String ARGS_NOT_NUMBER;

	public static String NICK_NAME_USAGE;
	public static String NICK_NAME_RESET;
	public static String NICK_NAME_CHANGED;
	public static String NICK_NAME_CHANGED_OTHERS;

	public static String FLY_ENABLED;
	public static String FLY_DISABLED;
	public static String FLY_ENABLED_ADMIN;
	public static String FLY_DISABLED_ADMIN;

	public static String GAMEMODE_USAGE;
	public static String GAMEMODE_CHANGED;
	public static String GAMEMODE_CHANGED_ADMIN;

	public static String TELEPORT_USAGE;
	public static String TELEPORT_SUCCESS_PLAYER;
	public static String TELEPORT_SUCCESS_OTHERS;
	public static String TELEPORT_SUCCESS_LOCATION;
	public static String TELEPORT_SUCCESS_OTHERS_LOCATION;

	public static String HAT_UPDATED;
	public static String HAT_UPDATED_ADMIN;

	public static String SHUFFLE_USAGE;
	public static String SHUFFLE_SUCCESS_ADMIN;

	public static String ROTATE_USAGE;
	public static String ROTATE_SUCCESS_ADMIN;

	public static String CLEAR_INVENTORY_SUCCESS;
	public static String CLEAR_INVENTORY_SUCCESS_OTHERS;

	public static String SPEED_USAGE;
	public static String SPEED_WALK_SUCCESS;
	public static String SPEED_FLY_SUCCESS;
	public static String SPEED_RESET;

	public static String TELL_USAGE;
	public static String TELL_MESSAGE_FORMAT;
	public static String TELL_SELF_MESSAGE_FORMAT;
	public static String REPLY_USAGE;
	public static String REPLY_MESSAGE_FORMAT;
	public static String REPLY_SELF_MESSAGE_FORMAT;
	public static String REPLY_NO_RECEIVER;

	public static String CROSS_TELEPORT_USAGE;

	public static String SUDO_USAGE;
	public static String SUDO_SUCCESS;

	@Override
	public void init() {
		PREFIX = getConfig().getString("Prefix");
		NO_PERMISSION = getConfig().getString("NoPermission").replace("{prefix}", PREFIX);
		NO_CONSOLE = getConfig().getString("NoConsole").replace("{prefix}", PREFIX);
		PLAYER_NOT_FOUND = getConfig().getString("PlayerNotFound").replace("{prefix}", PREFIX);
		ARGS_NOT_NUMBER = getConfig().getString("ArgsNotNumber").replace("{prefix}", PREFIX);

		NICK_NAME_USAGE = getConfig().getString("Modules.Nickname.Usage").replace("{prefix}", PREFIX);
		NICK_NAME_RESET = getConfig().getString("Modules.Nickname.Reset").replace("{prefix}", PREFIX);
		NICK_NAME_CHANGED = getConfig().getString("Modules.Nickname.Changed").replace("{prefix}", PREFIX);
		NICK_NAME_CHANGED_OTHERS = getConfig().getString("Modules.Nickname.ChangedOthers").replace("{prefix}", PREFIX);

		FLY_ENABLED = getConfig().getString("Modules.Fly.Enabled").replace("{prefix}", PREFIX);
		FLY_DISABLED = getConfig().getString("Modules.Fly.Disabled").replace("{prefix}", PREFIX);
		FLY_ENABLED_ADMIN = getConfig().getString("Modules.Fly.EnabledAdmin").replace("{prefix}", PREFIX);
		FLY_DISABLED_ADMIN = getConfig().getString("Modules.Fly.DisabledAdmin").replace("{prefix}", PREFIX);

		GAMEMODE_USAGE = getConfig().getString("Modules.Gamemode.Usage").replace("{prefix}", PREFIX);
		GAMEMODE_CHANGED = getConfig().getString("Modules.Gamemode.Change").replace("{prefix}", PREFIX);
		GAMEMODE_CHANGED_ADMIN = getConfig().getString("Modules.Gamemode.ChangeAdmin").replace("{prefix}", PREFIX);

		TELEPORT_USAGE = getConfig().getString("Modules.Teleport.Usage").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_PLAYER = getConfig().getString("Modules.Teleport.SuccessPlayer").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_OTHERS = getConfig().getString("Modules.Teleport.SuccessOthers").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_LOCATION = getConfig().getString("Modules.Teleport.SuccessLocation").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_OTHERS_LOCATION = getConfig().getString("Modules.Teleport.SuccessOthersLocation").replace("{prefix}", PREFIX);

		HAT_UPDATED = getConfig().getString("Modules.Hat.Updated").replace("{prefix}", PREFIX);
		HAT_UPDATED_ADMIN = getConfig().getString("Modules.Hat.UpdatedAdmin").replace("{prefix}", PREFIX);

		SHUFFLE_USAGE = getConfig().getString("Modules.Shuffle.Usage").replace("{prefix}", PREFIX);
		SHUFFLE_SUCCESS_ADMIN = getConfig().getString("Modules.Shuffle.SuccessAdmin").replace("{prefix}", PREFIX);

		ROTATE_USAGE = getConfig().getString("Modules.Rotate.Usage").replace("{prefix}", PREFIX);
		ROTATE_SUCCESS_ADMIN = getConfig().getString("Modules.Rotate.SuccessAdmin").replace("{prefix}", PREFIX);

		CLEAR_INVENTORY_SUCCESS = getConfig().getString("Modules.ClearInventory.Success").replace("{prefix}", PREFIX);
		CLEAR_INVENTORY_SUCCESS_OTHERS = getConfig().getString("Modules.ClearInventory.SuccessOthers").replace("{prefix}", PREFIX);

		SPEED_USAGE = getConfig().getString("Modules.Speed.Usage").replace("{prefix}", PREFIX);
		SPEED_WALK_SUCCESS = getConfig().getString("Modules.Speed.SuccessWalk").replace("{prefix}", PREFIX);
		SPEED_FLY_SUCCESS = getConfig().getString("Modules.Speed.SuccessFly").replace("{prefix}", PREFIX);
		SPEED_RESET = getConfig().getString("Modules.Speed.Reset").replace("{prefix}", PREFIX);

		TELL_USAGE = getConfig().getString("Modules.Tell.Usage").replace("{prefix}", PREFIX);
		TELL_MESSAGE_FORMAT = getConfig().getString("Modules.Tell.MessageFormat").replace("{prefix}", PREFIX);
		TELL_SELF_MESSAGE_FORMAT = getConfig().getString("Modules.Tell.SelfMessageFormat").replace("{prefix}", PREFIX);
		REPLY_USAGE = getConfig().getString("Modules.Reply.Usage").replace("{prefix}", PREFIX);
		REPLY_MESSAGE_FORMAT = getConfig().getString("Modules.Reply.MessageFormat").replace("{prefix}", PREFIX);
		REPLY_SELF_MESSAGE_FORMAT = getConfig().getString("Modules.Reply.SelfMessageFormat").replace("{prefix}", PREFIX);
		REPLY_NO_RECEIVER = getConfig().getString("Modules.Reply.NoReceiver").replace("{prefix}", PREFIX);

		CROSS_TELEPORT_USAGE = getConfig().getString("Modules.CrossTeleport.Usage").replace("{prefix}", PREFIX);

		SUDO_USAGE = getConfig().getString("Modules.Sudo.Usage").replace("{prefix}", PREFIX);
		SUDO_SUCCESS = getConfig().getString("Modules.Sudo.Success").replace("{prefix}", PREFIX);
	}
}
