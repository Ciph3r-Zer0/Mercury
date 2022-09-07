package ir.ciph3r.mercury.modules.impl.coordinates;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

@CommandAlias("Coordinates|Coords")
public class Coordinates extends CommandModule {
    public Coordinates() {
        super("Coordinates", MercuryAPI.INSTANCE.getConfigManager().getValues().COORDINATED_ENABLED);
        setCommandNameAndSyntax("/Coordinates", "[player]");
    }

    private final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.coordinates")
    @CommandCompletion("@players")
    public void onCoordinates(Player player) {
        Location loc = player.getLocation();
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().COORDINATES_MESSAGE
                .replace("{world}", loc.getWorld().getName())
                .replace("{x}", decimalFormat.format(loc.getX()))
                .replace("{y}", decimalFormat.format(loc.getY()))
                .replace("{z}", decimalFormat.format(loc.getZ())));
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.coordinates.others")
    @CommandCompletion("@players")
    public void onCoordinatesOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        Location loc = target.player.getLocation();
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().COORDINATES_MESSAGE_OTHERS
                .replace("{target}", target.getPlayer().getName())
                .replace("{world}", loc.getWorld().getName())
                .replace("{x}", decimalFormat.format(loc.getX()))
                .replace("{y}", decimalFormat.format(loc.getY()))
                .replace("{z}", decimalFormat.format(loc.getZ())));
    }
}
