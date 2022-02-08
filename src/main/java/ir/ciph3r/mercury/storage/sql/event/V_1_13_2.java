package ir.ciph3r.mercury.storage.sql.event;

import ir.ciph3r.mercury.storage.sql.models.PlayerModel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class V_1_13_2 implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		PlayerModel model = PlayerModel.queryByUUID(player.getUniqueId().toString());
		if (model == null) model = new PlayerModel(event.getPlayer()).create();
		model.incrementJoins(1);
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player player = (Player) event.getEntity();
		PlayerModel model = PlayerModel.queryByUUID(player.getUniqueId().toString());
		if (model == null) model = new PlayerModel(player).create();
		model.incrementDeath(1);
	}
}
