package ir.ciph3r.mercury.storage.yaml;

import ir.ciph3r.mercury.Mercury;
import ir.ciph3r.mercury.storage.yaml.models.Model;

import java.util.ArrayList;
import java.util.List;

public class Config extends Model {
	public Config(Mercury mercury) {
		super(mercury, "config.yml");
	}

	public static String DATA_TYPE;

	public static boolean NICK_NAME_ENABLED;
	public static List<String> NICK_NAME_RESET;

	public static boolean FLY_ENABLED;

	public static boolean GAMEMODE_ENABLED;

	public static boolean TELEPORT_ENABLED;

	public static boolean HAT_ENABLED;

	public static boolean SHUFFLE_ENABLED;

	public static boolean ROTATE_ENABLED;

	public static boolean CLEAR_INVENTORY_ENABLED;

	public static boolean SPEED_ENABLED;

	public static boolean TELL_ENABLED;

	@Override
	public void init() {
		DATA_TYPE = getConfig().getString("DataType");

		NICK_NAME_ENABLED = getConfig().getBoolean("Modules.Nickname.Enabled");
		NICK_NAME_RESET = new ArrayList<>(getConfig().getStringList("Modules.Nickname.Reset"));

		FLY_ENABLED = getConfig().getBoolean("Modules.Fly.Enabled");

		GAMEMODE_ENABLED = getConfig().getBoolean("Modules.GameMode.Enabled");

		TELEPORT_ENABLED = getConfig().getBoolean("Modules.Teleport.Enabled");

		HAT_ENABLED	= getConfig().getBoolean("Modules.Hat.Enabled");

		SHUFFLE_ENABLED = getConfig().getBoolean("Modules.Shuffle.Enabled");

		ROTATE_ENABLED = getConfig().getBoolean("Modules.Rotate.Enabled");

		CLEAR_INVENTORY_ENABLED = getConfig().getBoolean("Modules.ClearInventory.Enabled");

		SPEED_ENABLED = getConfig().getBoolean("Modules.Speed.Enabled");

		TELL_ENABLED = getConfig().getBoolean("Modules.Tell.Enabled");
	}
}
