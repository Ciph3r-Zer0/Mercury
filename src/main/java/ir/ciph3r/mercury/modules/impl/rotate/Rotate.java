package ir.ciph3r.mercury.modules.impl.rotate;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import ir.ciph3r.mercury.utility.NumeralUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@CommandAlias("Rotate")
public class Rotate extends CommandModule {
    public Rotate() {
        super("Rotate", MercuryAPI.INSTANCE.getConfig().ROTATE_ENABLED, null);
        setCommandNameAndSyntax("/Rotate", "<player>");
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.rotate")
    @CommandCompletion("@players")
    public void onDefault(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            ChatUtils.sendColorizedMSG(player, getCommandUsage());
        } else {
            float generatedPitch = NumeralUtils.generateRandomNumber(-90, 90, target.getPlayer().getLocation().getPitch());
            float generatedYaw = NumeralUtils.generateRandomNumber(-179, 180, target.getPlayer().getLocation().getPitch());

            Location rotatedLocation = target.getPlayer().getLocation();
            rotatedLocation.setPitch(generatedPitch);
            rotatedLocation.setYaw(generatedYaw);

            target.getPlayer().teleport(rotatedLocation);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().ROTATE_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()));
        }
    }
}
