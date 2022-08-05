package ir.ciph3r.mercury.modules.impl.spawn;

import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import ir.ciph3r.mercury.utility.LocationUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

@CommandAlias("SetSpawn")
public class SetSpawn extends CommandModule {
    public SetSpawn() {
        super("SetSpawn", MercuryAPI.INSTANCE.getConfig().SPAWN_ENABLED, null);
    }

    @Default
    @CommandPermission("mercury.commands.setspawn")
    public void onDefault(Player player) {
        try {
            MercuryAPI.INSTANCE.getConfig().set("modules.spawn.location", LocationUtils.serializeLocation(player.getLocation()));
            MercuryAPI.INSTANCE.getConfig().reloadSpawnLocation();
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPAWN_MESSAGE_SET.replace("{status}", "&aSuccess"));
        } catch (IOException | InvalidConfigurationException e) {
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPAWN_MESSAGE_SET.replace("{status}", "&cFail"));
            e.printStackTrace();
        }
    }
}
