package ir.ciph3r.mercury.dependency;

import ir.ciph3r.mercury.Mercury;
import lombok.Getter;
import org.bukkit.Bukkit;

public class Depend {
	private Mercury mercury;
	@Getter
	private static boolean PAPIEnabled = false;

	public void PlaceholderAPI() {
		if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
			PAPIEnabled = false;
		} else {
			PAPIEnabled = true;
		}
	}
}
