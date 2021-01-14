package com.sathonay.kits.commands.kit;

import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class KitInfoCommand extends KitSubCommand{
    public KitInfoCommand(KitsManager kitsManager) {
        super("kit info <kit>", kitsManager, "info");
    }

    @Override
    public void execute(CommandSender sender, String[] args, String label, Kit kit) {
        sender.sendMessage(ChatColor.GOLD + args[1] + "'s info");
        sender.sendMessage("  Permission: " + (kit.getPermission() != null ? kit.getPermission() : "None"));
        sender.sendMessage("  Material: " + kit.getIcon().getType().name());
        sender.sendMessage("  DisplayName: " + (kit.getIcon().hasItemMeta() && kit.getIcon().getItemMeta().getDisplayName() != null ? kit.getIcon().getItemMeta().getDisplayName() : "None"));
    }
}
