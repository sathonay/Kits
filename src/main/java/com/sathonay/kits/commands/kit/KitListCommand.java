package com.sathonay.kits.commands.kit;

import com.sathonay.core.api.command.SubCommand;
import com.sathonay.kits.handler.KitsHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Set;

public class KitListCommand extends SubCommand {
    private final KitsHandler kitsHandler;
    public KitListCommand(KitsHandler kitsHandler) {
        super("kit list", "list");
        this.kitsHandler = kitsHandler;
    }

    @Override
    public void execute(CommandSender sender, String[] args, String label) {
        Set<String> kits = kitsHandler.keySet();
        if (kits.isEmpty()) {
            sender.sendMessage("There is no kit");
            return;
        }
        sender.sendMessage(ChatColor.GOLD + "Kits (" + ChatColor.WHITE +  kits.size() + ChatColor.GOLD + "):");
        kits.forEach(kitName ->
                sender.sendMessage("  " + ChatColor.GOLD + kitName)
        );
    }
}
