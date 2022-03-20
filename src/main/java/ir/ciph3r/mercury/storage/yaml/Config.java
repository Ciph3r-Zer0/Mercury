package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.yaml.models.Model;

public class Config extends Model {
	public Config(Mercury mercury) {
		super(mercury, "config.yml");
		setup();
	}

	public boolean
			FLY_ENABLED

			,GAMEMODE_ENABLED

			,TELEPORT_ENABLED

			,HAT_ENABLED

			,SHUFFLE_ENABLED

			,ROTATE_ENABLED

			,KNOCKBACK_ENABLED

			,CLEAR_INVENTORY_ENABLED

			,SPEED_ENABLED

			,TELL_ENABLED

			,CROSS_TELEPORT_ENABLED

			,SUDO_ENABLED

			,SPAWN_ENABLED
			,SPAWN_ON_JOIN
			,SPAWN_ON_RESPAWN
			,SPAWN_ON_VOID

			,LIGHTNING_ENABLED

			,COORDINATES_ENABLED;

	@Override
	public void init() {
		FLY_ENABLED = getFileConfig().getBoolean("Modules.Fly.Enabled");

		GAMEMODE_ENABLED = getFileConfig().getBoolean("Modules.GameMode.Enabled");

		TELEPORT_ENABLED = getFileConfig().getBoolean("Modules.Teleport.Enabled");

		HAT_ENABLED	= getFileConfig().getBoolean("Modules.Hat.Enabled");

		SHUFFLE_ENABLED = getFileConfig().getBoolean("Modules.Shuffle.Enabled");

		ROTATE_ENABLED = getFileConfig().getBoolean("Modules.Rotate.Enabled");

		KNOCKBACK_ENABLED = getFileConfig().getBoolean("Modules.Knockback.Enabled");

		CLEAR_INVENTORY_ENABLED = getFileConfig().getBoolean("Modules.ClearInventory.Enabled");

		SPEED_ENABLED = getFileConfig().getBoolean("Modules.Speed.Enabled");

		TELL_ENABLED = getFileConfig().getBoolean("Modules.Tell.Enabled");

		CROSS_TELEPORT_ENABLED = getFileConfig().getBoolean("Modules.CrossTeleport.Enabled");

		SUDO_ENABLED = getFileConfig().getBoolean("Modules.Sudo.Enabled");

		SPAWN_ENABLED = getFileConfig().getBoolean("Modules.Spawn.Enabled");
		SPAWN_ON_JOIN = getFileConfig().getBoolean("Modules.Spawn.onJoin");
		SPAWN_ON_RESPAWN = getFileConfig().getBoolean("Modules.Spawn.onRespawn");
		SPAWN_ON_VOID = getFileConfig().getBoolean("Modules.Spawn.onVoid");

		LIGHTNING_ENABLED = getFileConfig().getBoolean("Modules.Lightning.Enabled");

		COORDINATES_ENABLED = getFileConfig().getBoolean("Modules.Coordinates.Enabled");
	}
}
