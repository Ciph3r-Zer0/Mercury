package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.yaml.models.Model;

public class Messages extends Model {
	public Messages(Mercury mercury) {
		super(mercury, "messages.yml");
		setup();
	}

	public String PREFIX;
	public String NO_PERMISSION;
	public String NO_CONSOLE;
	public String PLAYER_NOT_FOUND;
	public String ARGS_NOT_NUMBER;

	public String RELOAD_SUCCESS;
	public String RELOAD_FAILED;

	public String FLY_ENABLED;
	public String FLY_DISABLED;
	public String FLY_ENABLED_ADMIN;
	public String FLY_DISABLED_ADMIN;

	public String GAMEMODE_USAGE;
	public String GAMEMODE_CHANGED;
	public String GAMEMODE_CHANGED_ADMIN;

	public String TELEPORT_USAGE;
	public String TELEPORT_SUCCESS_PLAYER;
	public String TELEPORT_SUCCESS_OTHERS;
	public String TELEPORT_SUCCESS_LOCATION;
	public String TELEPORT_SUCCESS_OTHERS_LOCATION;

	public String HAT_UPDATED;
	public String HAT_UPDATED_ADMIN;

	public String SHUFFLE_USAGE;
	public String SHUFFLE_SUCCESS_ADMIN;

	public String ROTATE_USAGE;
	public String ROTATE_SUCCESS_ADMIN;

	public String CLEAR_INVENTORY_SUCCESS;
	public String CLEAR_INVENTORY_SUCCESS_OTHERS;

	public String SPEED_USAGE;
	public String SPEED_WALK_SUCCESS;
	public String SPEED_FLY_SUCCESS;
	public String SPEED_RESET;

	public String TELL_USAGE;
	public String TELL_MESSAGE_FORMAT;
	public String TELL_SELF_MESSAGE_FORMAT;
	public String REPLY_USAGE;
	public String REPLY_MESSAGE_FORMAT;
	public String REPLY_SELF_MESSAGE_FORMAT;
	public String REPLY_NO_RECEIVER;

	public String CROSS_TELEPORT_USAGE;
	public String CROSS_TELEPORT_SUCCESS;

	public String SUDO_USAGE;
	public String SUDO_SUCCESS;

	public String SPAWN_NOT_SET;
	public String SPAWN_SET_SUCCESSFUL;
	public String SPAWN_SUCCESSFUL;
	public String SPAWN_SUCCESSFUL_OTHERS;

	public String LIGHTNING_SUCCESS;
	public String LIGHTNING_SUCCESS_OTHERS;

	public String COORDINATES_MESSAGE;
	public String COORDINATES_MESSAGE_OTHERS;

	@Override
	public void init() {
		PREFIX = getFileConfig().getString("Prefix");
		NO_PERMISSION = getFileConfig().getString("NoPermission").replace("{prefix}", PREFIX);
		NO_CONSOLE = getFileConfig().getString("NoConsole").replace("{prefix}", PREFIX);
		PLAYER_NOT_FOUND = getFileConfig().getString("PlayerNotFound").replace("{prefix}", PREFIX);
		ARGS_NOT_NUMBER = getFileConfig().getString("ArgsNotNumber").replace("{prefix}", PREFIX);

		RELOAD_SUCCESS = getFileConfig().getString("Modules.Reload.Success").replace("{prefix}", PREFIX);
		RELOAD_FAILED = getFileConfig().getString("Modules.Reload.Failed").replace("{prefix}", PREFIX);

		FLY_ENABLED = getFileConfig().getString("Modules.Fly.Enabled").replace("{prefix}", PREFIX);
		FLY_DISABLED = getFileConfig().getString("Modules.Fly.Disabled").replace("{prefix}", PREFIX);
		FLY_ENABLED_ADMIN = getFileConfig().getString("Modules.Fly.EnabledAdmin").replace("{prefix}", PREFIX);
		FLY_DISABLED_ADMIN = getFileConfig().getString("Modules.Fly.DisabledAdmin").replace("{prefix}", PREFIX);

		GAMEMODE_USAGE = getFileConfig().getString("Modules.Gamemode.Usage").replace("{prefix}", PREFIX);
		GAMEMODE_CHANGED = getFileConfig().getString("Modules.Gamemode.Change").replace("{prefix}", PREFIX);
		GAMEMODE_CHANGED_ADMIN = getFileConfig().getString("Modules.Gamemode.ChangeAdmin").replace("{prefix}", PREFIX);

		TELEPORT_USAGE = getFileConfig().getString("Modules.Teleport.Usage").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_PLAYER = getFileConfig().getString("Modules.Teleport.SuccessPlayer").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_OTHERS = getFileConfig().getString("Modules.Teleport.SuccessOthers").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_LOCATION = getFileConfig().getString("Modules.Teleport.SuccessLocation").replace("{prefix}", PREFIX);
		TELEPORT_SUCCESS_OTHERS_LOCATION = getFileConfig().getString("Modules.Teleport.SuccessOthersLocation").replace("{prefix}", PREFIX);

		HAT_UPDATED = getFileConfig().getString("Modules.Hat.Updated").replace("{prefix}", PREFIX);
		HAT_UPDATED_ADMIN = getFileConfig().getString("Modules.Hat.UpdatedAdmin").replace("{prefix}", PREFIX);

		SHUFFLE_USAGE = getFileConfig().getString("Modules.Shuffle.Usage").replace("{prefix}", PREFIX);
		SHUFFLE_SUCCESS_ADMIN = getFileConfig().getString("Modules.Shuffle.SuccessAdmin").replace("{prefix}", PREFIX);

		ROTATE_USAGE = getFileConfig().getString("Modules.Rotate.Usage").replace("{prefix}", PREFIX);
		ROTATE_SUCCESS_ADMIN = getFileConfig().getString("Modules.Rotate.SuccessAdmin").replace("{prefix}", PREFIX);

		CLEAR_INVENTORY_SUCCESS = getFileConfig().getString("Modules.ClearInventory.Success").replace("{prefix}", PREFIX);
		CLEAR_INVENTORY_SUCCESS_OTHERS = getFileConfig().getString("Modules.ClearInventory.SuccessOthers").replace("{prefix}", PREFIX);

		SPEED_USAGE = getFileConfig().getString("Modules.Speed.Usage").replace("{prefix}", PREFIX);
		SPEED_WALK_SUCCESS = getFileConfig().getString("Modules.Speed.SuccessWalk").replace("{prefix}", PREFIX);
		SPEED_FLY_SUCCESS = getFileConfig().getString("Modules.Speed.SuccessFly").replace("{prefix}", PREFIX);
		SPEED_RESET = getFileConfig().getString("Modules.Speed.Reset").replace("{prefix}", PREFIX);

		TELL_USAGE = getFileConfig().getString("Modules.Tell.Usage").replace("{prefix}", PREFIX);
		TELL_MESSAGE_FORMAT = getFileConfig().getString("Modules.Tell.MessageFormat").replace("{prefix}", PREFIX);
		TELL_SELF_MESSAGE_FORMAT = getFileConfig().getString("Modules.Tell.SelfMessageFormat").replace("{prefix}", PREFIX);
		REPLY_USAGE = getFileConfig().getString("Modules.Reply.Usage").replace("{prefix}", PREFIX);
		REPLY_MESSAGE_FORMAT = getFileConfig().getString("Modules.Reply.MessageFormat").replace("{prefix}", PREFIX);
		REPLY_SELF_MESSAGE_FORMAT = getFileConfig().getString("Modules.Reply.SelfMessageFormat").replace("{prefix}", PREFIX);
		REPLY_NO_RECEIVER = getFileConfig().getString("Modules.Reply.NoReceiver").replace("{prefix}", PREFIX);

		CROSS_TELEPORT_USAGE = getFileConfig().getString("Modules.CrossTeleport.Usage").replace("{prefix}", PREFIX);
		CROSS_TELEPORT_SUCCESS = getFileConfig().getString("Modules.CrossTeleport.Success").replace("{prefix}", PREFIX);

		SUDO_USAGE = getFileConfig().getString("Modules.Sudo.Usage").replace("{prefix}", PREFIX);
		SUDO_SUCCESS = getFileConfig().getString("Modules.Sudo.Success").replace("{prefix}", PREFIX);

		SPAWN_NOT_SET = getFileConfig().getString("Modules.Spawn.SpawnNotSet").replace("{prefix}", PREFIX);
		SPAWN_SET_SUCCESSFUL =getFileConfig().getString("Modules.Spawn.SetSuccessful").replace("{prefix}", PREFIX);
		SPAWN_SUCCESSFUL = getFileConfig().getString("Modules.Spawn.Successful").replace("{prefix}", PREFIX);
		SPAWN_SUCCESSFUL_OTHERS = getFileConfig().getString("Modules.Spawn.SuccessfulOthers").replace("{prefix}", PREFIX);

		LIGHTNING_SUCCESS = getFileConfig().getString("Modules.Lightning.Success").replace("{prefix}", PREFIX);
		LIGHTNING_SUCCESS_OTHERS = getFileConfig().getString("Modules.Lightning.SuccessOthers").replace("{prefix}", PREFIX);

		COORDINATES_MESSAGE = getFileConfig().getString("Modules.Coordinates.Message").replace("{prefix}", PREFIX);
		COORDINATES_MESSAGE_OTHERS = getFileConfig().getString("Modules.Coordinates.MessageOthers").replace("{prefix}", PREFIX);
	}
}
