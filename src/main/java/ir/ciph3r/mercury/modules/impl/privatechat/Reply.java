package ir.ciph3r.mercury.modules.impl.privatechat;

import co.aikar.commands.annotation.*;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.modules.CommandModule;
import ir.ciph3r.mercury.modules.impl.privatechat.listener.PrivateChatListener;
import ir.ciph3r.mercury.utility.ArrayUtils;
import ir.ciph3r.mercury.utility.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandAlias("Reply|R")
public class Reply extends CommandModule {
    public Reply() {
        super("PrivateChat", MercuryAPI.INSTANCE.getConfig().PRIVATE_CHAT_ENABLED);
        setCommandNameAndSyntax("/Reply", "<message>");
    }

    @Default
    @Syntax("<message>")
    @CommandPermission("mercury.commands.reply")
    @CommandCompletion("@players")
    public void onDefault(Player player, String[] args) {
        if (args.length == 0) {
            ChatUtils.sendColorizedMSG(player, getCommandUsage());
            return;
        }
        if (!(PrivateChatListener.replyList.containsKey(player.getName()))) {
            ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().PRIVATE_CHAT_MESSAGE_NO_ONE_TO_REPLY);
        } else {
            Player target = Bukkit.getPlayer(PrivateChatListener.replyList.get(player.getName()));
            if (target == null) {
                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().NO_PLAYER_FOUND_OFFLINE.replace("{search}", PrivateChatListener.replyList.get(player.getName())));
            } else {
                String msg = ArrayUtils.createStringFromArray(args, 0, args.length);
                ChatUtils.sendColorizedMSG(target, MercuryAPI.INSTANCE.getMessages().PRIVATE_CHAT_MESSAGE
                        .replace("{sender}", player.getName())
                        .replace("{receiver}", target.getName())
                        .replace("{message}", msg));

                ChatUtils.sendColorizedMSG(player, MercuryAPI.INSTANCE.getMessages().PRIVATE_CHAT_MESSAGE
                        .replace("{sender}", player.getName())
                        .replace("{receiver}", target.getName())
                        .replace("{message}", msg));

                PrivateChatListener.replyList.put(target.getName(), player.getName());
            }
        }
    }
}
