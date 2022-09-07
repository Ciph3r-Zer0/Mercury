package ir.ciph3r.mercury.modules.impl.rotate;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import ir.ciph3r.mercury.utility.NumeralUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Rotate")
public class Rotate extends CommandModule {
    public Rotate() {
        super("Rotate", MercuryAPI.INSTANCE.getConfigManager().getValues().ROTATE_ENABLED);
        setCommandNameAndSyntax("/Rotate", "<player>");
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.rotate")
    @CommandCompletion("@players")
    public void onRotate(CommandSender sender) {
        ChatUtils.sendColorizedMSG(sender, getCommandUsage());
    }

    @Default
    @Syntax("<player>")
    @CommandPermission("mercury.commands.rotate")
    @CommandCompletion("@players")
    public void onRotateOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        float generatedPitch = NumeralUtils.generateRandomNumber(-90, 90, target.getPlayer().getLocation().getPitch());
        float generatedYaw = NumeralUtils.generateRandomNumber(-179, 180, target.getPlayer().getLocation().getPitch());

        Location rotatedLocation = target.getPlayer().getLocation();
        rotatedLocation.setPitch(generatedPitch);
        rotatedLocation.setYaw(generatedYaw);

        target.getPlayer().teleport(rotatedLocation);
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getConfigManager().getValues().ROTATE_MESSAGE.replace("{target}", target.getPlayer().getName()));
    }
}
