package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.yaml.models.Model;

public class Config extends Model {
	public Config(Mercury mercury) {
		super(mercury, "config.yml");
		setup();
	}

	public boolean FLY_ENABLED;

	public boolean GAMEMODE_ENABLED;

	public boolean TELEPORT_ENABLED;

	public boolean HAT_ENABLED;

	public boolean SHUFFLE_ENABLED;

	public boolean ROTATE_ENABLED;

	public boolean CLEAR_INVENTORY_ENABLED;

	public boolean SPEED_ENABLED;

	public boolean TELL_ENABLED;

	public boolean CROSS_TELEPORT_ENABLED;

	public boolean SUDO_ENABLED;

	public boolean SPAWN_ENABLED;
	public boolean SPAWN_ON_JOIN;
	public boolean SPAWN_ON_RESPAWN;
	public boolean SPAWN_ON_VOID;

	@Override
	public void init() {
		FLY_ENABLED = getFileConfig().getBoolean("Modules.Fly.Enabled");

		GAMEMODE_ENABLED = getFileConfig().getBoolean("Modules.GameMode.Enabled");

		TELEPORT_ENABLED = getFileConfig().getBoolean("Modules.Teleport.Enabled");

		HAT_ENABLED	= getFileConfig().getBoolean("Modules.Hat.Enabled");

		SHUFFLE_ENABLED = getFileConfig().getBoolean("Modules.Shuffle.Enabled");

		ROTATE_ENABLED = getFileConfig().getBoolean("Modules.Rotate.Enabled");

		CLEAR_INVENTORY_ENABLED = getFileConfig().getBoolean("Modules.ClearInventory.Enabled");

		SPEED_ENABLED = getFileConfig().getBoolean("Modules.Speed.Enabled");

		TELL_ENABLED = getFileConfig().getBoolean("Modules.Tell.Enabled");

		CROSS_TELEPORT_ENABLED = getFileConfig().getBoolean("Modules.CrossTeleport.Enabled");

		SUDO_ENABLED = getFileConfig().getBoolean("Modules.Sudo.Enabled");

		SPAWN_ENABLED = getFileConfig().getBoolean("Modules.Spawn.Enabled");
		SPAWN_ON_JOIN = getFileConfig().getBoolean("Modules.Spawn.onJoin");
		SPAWN_ON_RESPAWN = getFileConfig().getBoolean("Modules.Spawn.onRespawn");
		SPAWN_ON_VOID = getFileConfig().getBoolean("Modules.Spawn.onVoid");
	}
}
