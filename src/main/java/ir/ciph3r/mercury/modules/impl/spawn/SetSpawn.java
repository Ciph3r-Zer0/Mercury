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
        super("SetSpawn", MercuryAPI.INSTANCE.getConfigManager().getValues().SPAWN_ENABLED);
    }

    @Default
    @CommandPermission("mercury.commands.setspawn")
    public void onSetSpawn(Player player) {
        MercuryAPI.INSTANCE.getConfigManager().setSpawnPoint(LocationUtils.serializeLocation(player.getLocation()));
        MercuryAPI.INSTANCE.getConfigManager().reload();
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().SPAWN_SET.replace("{status}", "&aSuccess"));
    }
}
