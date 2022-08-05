package ir.ciph3r.mercury.modules.impl.fly;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.entity.Player;

@CommandAlias("Fly")
public class Fly extends CommandModule {
    public Fly() {
        super("Fly", MercuryAPI.INSTANCE.getConfig().FLY_ENABLED, null);
        setCommandNameAndSyntax("/Fly", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.fly")
    @CommandCompletion("@players")
    public void onDefault(Player player, @Optional @Conditions("noAdmin") OnlinePlayer target) {
        if (target == null) {
            player.setAllowFlight(!(player.getAllowFlight()));
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().FLY_MESSAGE
                    .replace("{status}", handleFlyStatus(player)));
        } else {
            if (player.hasPermission("mercury.commands.fly.others")) {
                target.getPlayer().setAllowFlight(!(target.getPlayer().getAllowFlight()));
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().FLY_MESSAGE_OTHERS
                        .replace("{player}", target.getPlayer().getName())
                        .replace("{status}", handleFlyStatus(target.getPlayer())));
            }
        }
    }

    private String handleFlyStatus(Player player) {
        if (player.getAllowFlight()) {
            return "&aEnabled";
        } else {
            return "&cDisabled";
        }
    }
}
