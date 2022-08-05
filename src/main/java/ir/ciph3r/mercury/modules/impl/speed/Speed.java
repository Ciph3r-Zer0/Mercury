package ir.ciph3r.mercury.modules.impl.speed;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.entity.Player;

@CommandAlias("Speed")
public class Speed extends CommandModule {
    public Speed() {
        super("Speed", MercuryAPI.INSTANCE.getConfig().SPEED_ENABLED, null);
        setCommandNameAndSyntax("/Speed", "<Walk, Fly, Reset> <0-10> [player]");
    }

    @Default
    @Syntax("<Walk, Fly, Reset> <0-10> [player]")
    @CommandPermission("mercury.commands.speed")
    @CommandCompletion("Walk|Fly|Reset")
    public void onDefault(Player player) {
        ChatUtils.sendColorizedMSG(player, getCommandUsage());
    }

    @Syntax("<0-10> [player]")
    @Subcommand("Walk|W")
    @CommandPermission("mercury.commands.speed")
    @CommandCompletion("3 @players")
    public void onWalk(Player player, @Conditions("limits:min=0,max=10") Float speed, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setWalkSpeed(speed/10);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPEED_WALK_MESSAGE.replace("{amount}", String.valueOf(speed)));
        } else {
            if (player.hasPermission("mercury.commands.speed.others")) {
                target.getPlayer().setWalkSpeed(speed/10);
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPEED_WALK_MESSAGE_OTHERS.replace("{target}", target.getPlayer().getName()).replace("{amount}", String.valueOf(speed)));
            }
        }
    }

    @Syntax("<0-10> [player]")
    @Subcommand("Fly|F")
    @CommandPermission("mercury.commands.speed")
    @CommandCompletion("3 @players")
    public void onFly(Player player, @Conditions("limits:min=0,max=10") Float speed, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setFlySpeed(speed/10);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPEED_FLY_MESSAGE.replace("{amount}", String.valueOf(speed)));
        } else {
            if (player.hasPermission("mercury.commands.speed.others")) {
                target.getPlayer().setFlySpeed(speed/10);
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPEED_FLY_MESSAGE_OTHERS.replace("{target}", target.getPlayer().getName()).replace("{amount}", String.valueOf(speed)));
            }
        }
    }

    @Syntax("[player]")
    @Subcommand("Reset|R")
    @CommandPermission("mercury.commands.speed.reset")
    @CommandCompletion("@players")
    public void onReset(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setWalkSpeed(0.2f);
            player.setFlySpeed(0.2f);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPEED_RESET_MESSAGE);
        } else if (player.hasPermission("mercury.commands.speed.reset.others")){
            target.getPlayer().setWalkSpeed(0.2f);
            target.getPlayer().setFlySpeed(0.2f);
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().SPEED_RESET_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()));
        }
    }
}
