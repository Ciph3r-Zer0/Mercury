package ir.ciph3r.mercury.modules.impl.spawn;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.spawn.listener.SpawnListener;
import ir.ciph3r.mercury.utility.ChatUtils;
import ir.ciph3r.mercury.utility.LocationUtils;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Spawn")
public class Spawn extends CommandModule {
    public Spawn() {
        super("Spawn", MercuryAPI.INSTANCE.getConfig().SPAWN_ENABLED);
        setCommandNameAndSyntax("Spawn", "[player]");
        addListeners(new SpawnListener());
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.spawn")
    @CommandCompletion("@players")
    public void onSpawn(Player player) {
        if (MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION.equalsIgnoreCase("")) {
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPAWN_MESSAGE_NOT_SET);
        } else {
            Location spawnLocation = LocationUtils.deserializeLocation(MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION);
            player.teleport(spawnLocation);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPAWN_MESSAGE);
        }
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.spawn.others")
    @CommandCompletion("@players")
    public void onSpawnOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        if (MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION.equalsIgnoreCase("")) {
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPAWN_MESSAGE_NOT_SET);
        } else {
            Location spawnLocation = LocationUtils.deserializeLocation(MercuryAPI.INSTANCE.getConfig().SPAWN_LOCATION);
            target.getPlayer().teleport(spawnLocation);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPAWN_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()));
        }
    }
}
