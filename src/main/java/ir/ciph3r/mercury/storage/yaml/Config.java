package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.yaml.models.Model;

public class Config extends Model {
	public Config(Mercury mercury) {
		super(mercury, "config.yml");
		setup();
	}

	public boolean
			BROADCAST_ENABLED

			,CLEAR_INVENTORY_ENABLED

			,COORDINATES_ENABLED

			,CROSS_TELEPORT_ENABLED

			,FLY_ENABLED

			,GAMEMODE_ENABLED

			,HAT_ENABLED

			,KNOCKBACK_ENABLED

			,LIGHTNING_ENABLED

			,PLUGIN_LIST_ENABLED

			,ROTATE_ENABLED

			,SHUFFLE_ENABLED

			,SPAWN_ENABLED
			,SPAWN_ON_JOIN
			,SPAWN_ON_RESPAWN
			,SPAWN_ON_VOID

			,SPEED_ENABLED

			,SUDO_ENABLED

			,TELEPORT_ENABLED

			,TELL_ENABLED;

	public int
			PLUGIN_LIST_PLUGIN_PER_PAGE;

	@Override
	public void init() {
		BROADCAST_ENABLED = getFileConfig().getBoolean("Modules.Broadcast.Enabled");

		CLEAR_INVENTORY_ENABLED = getFileConfig().getBoolean("Modules.ClearInventory.Enabled");

		COORDINATES_ENABLED = getFileConfig().getBoolean("Modules.Coordinates.Enabled");

		CROSS_TELEPORT_ENABLED = getFileConfig().getBoolean("Modules.CrossTeleport.Enabled");

		FLY_ENABLED = getFileConfig().getBoolean("Modules.Fly.Enabled");

		GAMEMODE_ENABLED = getFileConfig().getBoolean("Modules.GameMode.Enabled");

		HAT_ENABLED	= getFileConfig().getBoolean("Modules.Hat.Enabled");

		KNOCKBACK_ENABLED = getFileConfig().getBoolean("Modules.Knockback.Enabled");

		LIGHTNING_ENABLED = getFileConfig().getBoolean("Modules.Lightning.Enabled");

		PLUGIN_LIST_ENABLED = getFileConfig().getBoolean("Modules.PluginList.Enabled");
		PLUGIN_LIST_PLUGIN_PER_PAGE = getFileConfig().getInt("Modules.PluginList.PluginPerPage");

		ROTATE_ENABLED = getFileConfig().getBoolean("Modules.Rotate.Enabled");

		SHUFFLE_ENABLED = getFileConfig().getBoolean("Modules.Shuffle.Enabled");

		SPAWN_ENABLED = getFileConfig().getBoolean("Modules.Spawn.Enabled");
		SPAWN_ON_JOIN = getFileConfig().getBoolean("Modules.Spawn.onJoin");
		SPAWN_ON_RESPAWN = getFileConfig().getBoolean("Modules.Spawn.onRespawn");
		SPAWN_ON_VOID = getFileConfig().getBoolean("Modules.Spawn.onVoid");

		SPEED_ENABLED = getFileConfig().getBoolean("Modules.Speed.Enabled");

		SUDO_ENABLED = getFileConfig().getBoolean("Modules.Sudo.Enabled");

		TELEPORT_ENABLED = getFileConfig().getBoolean("Modules.Teleport.Enabled");

		TELL_ENABLED = getFileConfig().getBoolean("Modules.Tell.Enabled");
	}
}
