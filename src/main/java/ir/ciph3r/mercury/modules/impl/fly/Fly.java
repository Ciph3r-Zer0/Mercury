package ir.ciph3r.mercury.modules.impl.fly;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Fly")
public class Fly extends CommandModule {
    public Fly() {
        super("Fly", MercuryAPI.INSTANCE.getConfig().FLY_ENABLED);
        setCommandNameAndSyntax("/Fly", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.fly")
    @CommandCompletion("@players")
    public void onFly(Player player) {
        player.setAllowFlight(!(player.getAllowFlight()));
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().FLY_MESSAGE
                .replace("{status}", handleFlyStatus(player)));
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.fly.others")
    @CommandCompletion("@players")
    public void onFlyOthers(CommandSender player, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().setAllowFlight(!(target.getPlayer().getAllowFlight()));
        ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().FLY_MESSAGE_OTHERS
                .replace("{player}", target.getPlayer().getName())
                .replace("{status}", handleFlyStatus(target.getPlayer())));
    }

    private String handleFlyStatus(Player player) {
        if (player.getAllowFlight()) {
            return "&aEnabled";
        } else {
            return "&cDisabled";
        }
    }
}
