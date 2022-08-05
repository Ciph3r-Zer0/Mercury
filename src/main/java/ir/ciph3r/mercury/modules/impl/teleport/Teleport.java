package ir.ciph3r.mercury.modules.impl.teleport;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@CommandAlias("Teleport|TP")
public class Teleport extends CommandModule {
    public Teleport() {
        super("Teleport", MercuryAPI.INSTANCE.getConfig().TELEPORT_ENABLED, null);
        setCommandNameAndSyntax("/Teleport", "<player, location> [player]");
    }

    @Default
    @Syntax("<player> [player, location]")
    @CommandPermission("mercury.commands.teleport")
    @CommandCompletion("@players")
    public void onDefault(Player player) {
        ChatUtils.sendColorizedMSG(player, getCommandUsage());
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.teleport")
    @CommandCompletion("@players")
    public void onPlayer(Player player, @Conditions("noAdmin") OnlinePlayer target) {
        player.teleport(target.getPlayer().getLocation());
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().TELEPORT_MESSAGE.replace("{player}", target.getPlayer().getName()));
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.teleport.others")
    @CommandCompletion("@players @players")
    public void onPlayerToPlayer(Player player, @Conditions("noAdmin") OnlinePlayer target1, @Conditions("noAdmin") OnlinePlayer target2) {
        target1.getPlayer().teleport(target2.getPlayer().getLocation());
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().TELEPORT_MESSAGE_OTHERS
                .replace("{player}", target1.getPlayer().getName())
                .replace("{target}", target2.getPlayer().getName()));
    }

    @Default
    @Syntax("<X> <Y> <Z>")
    @CommandPermission("mercury.commands.teleport.coordinates.others")
    @CommandCompletion("@players 100 100 100")
    public void onXYZ(Player player, @Conditions("noAdmin") OnlinePlayer target, double x, double y, double z) {
        Location location = new Location(player.getWorld(), x, y, z);
        target.getPlayer().teleport(location);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().TELEPORT_MESSAGE_LOCATION
                .replace("{player}", target.getPlayer().getName())
                .replace("{x}", String.valueOf(location.getX()))
                .replace("{y}", String.valueOf(location.getY()))
                .replace("{z}", String.valueOf(location.getZ())));
    }

    @Default
    @Syntax("<X> <Y> <Z>")
    @CommandPermission("mercury.commands.teleport.coordinates")
    @CommandCompletion("100 100 100")
    public void onXYZ(Player player, double x, double y, double z) {
        Location location = new Location(player.getWorld(), x, y, z);
        player.teleport(location);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().TELEPORT_MESSAGE_LOCATION_OTHERS
                .replace("{x}", String.valueOf(location.getX()))
                .replace("{y}", String.valueOf(location.getY()))
                .replace("{z}", String.valueOf(location.getZ())));
    }
}
