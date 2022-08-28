package ir.ciph3r.mercury.modules.impl.clearinventory;

import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("Clearinventory|CI|ClearINV")
public class ClearInventory extends CommandModule {
    public ClearInventory() {
        super("ClearInventory", MercuryAPI.INSTANCE.getConfig().CLEAR_INVENTORY_ENABLED);
        setCommandNameAndSyntax("/ClearInventory", "[player]");
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.clearinventory")
    @CommandCompletion("@players")
    public void onClearInventory(Player sender) {
        sender.getInventory().clear();
        ChatUtils.sendColorizedMSG(sender, MercuryAPI.INSTANCE.getMessages().CLEAR_INVENTORY_MESSAGE);
    }

    @Default
    @Syntax("[player]")
    @CommandPermission("mercury.commands.clearinventory.others")
    @CommandCompletion("@players")
    public void onClearInventoryOthers(CommandSender sender, @Conditions("noAdmin") OnlinePlayer target) {
        target.getPlayer().getInventory().clear();
        ChatUtils.sendColorizedMSG(sender, MercuryAPI.INSTANCE.getMessages().CLEAR_INVENTORY_MESSAGE_OTHERS.replace("{player}", target.getPlayer().getName()));
    }

}
