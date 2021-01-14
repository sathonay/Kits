package com.sathonay.kits.commands.kit;

import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class KitRemovePermissionCommand extends KitSubCommand {
    public KitRemovePermissionCommand(KitsManager kitsManager) {
        super("kit removepermission <kit>", kitsManager, "removepermission");
    }

    @Override
    public void execute(CommandSender sender, String[] args, String label, Kit kit) {
        kit.setPermission(null);
        sender.sendMessage(ChatColor.GREEN + "The permission of the kit was removed.");
    }
}
