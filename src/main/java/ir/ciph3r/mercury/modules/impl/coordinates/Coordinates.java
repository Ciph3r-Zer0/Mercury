package ir.ciph3r.mercury.modules.impl.coordinates;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

@CommandAlias("Coordinates|Coords")
public class Coordinates extends CommandModule {
    public Coordinates() {
        super("Coordinates", MercuryAPI.INSTANCE.getConfig().COORDINATES_ENABLED, null);
        setCommandNameAndSyntax("/Coordinates", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.coordinates")
    @CommandCompletion("@players")
    public void onDefault(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        final DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (target == null) {
            Location loc = player.getLocation();
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().COORDINATES_MESSAGE
                    .replace("{world}", loc.getWorld().getName())
                    .replace("{x}", decimalFormat.format(loc.getX()))
                    .replace("{y}", decimalFormat.format(loc.getY()))
                    .replace("{z}", decimalFormat.format(loc.getZ())));
        } else {
            if (player.hasPermission("mercury.commands.coordinates.others")) {
                Location loc = target.player.getLocation();
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().COORDINATES_MESSAGE_OTHERS
                        .replace("{player}", target.getPlayer().getName())
                        .replace("{world}", loc.getWorld().getName())
                        .replace("{x}", decimalFormat.format(loc.getX()))
                        .replace("{y}", decimalFormat.format(loc.getY()))
                        .replace("{z}", decimalFormat.format(loc.getZ())));
            }
        }
    }
}
