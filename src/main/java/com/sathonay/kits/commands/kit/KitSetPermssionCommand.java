package com.sathonay.kits.commands.kit;

import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class KitSetPermssionCommand extends KitSubCommand {
    public KitSetPermssionCommand(KitsManager kitsManager) {
        super("kit setPermission <kit> <permission>", kitsManager, "setpermission");
    }

    @Override
    public void execute(CommandSender sender, String[] args, String label, Kit kit) {
        kit.setPermission(args[2]);
        sender.sendMessage(ChatColor.GREEN + "The permission of the kit was updated.");
    }
}
