package com.sathonay.kits.commands.kit;

import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.StringJoiner;

public class KitSetDisplayNameCommand extends KitSubCommand {
    public KitSetDisplayNameCommand(KitsManager kitsManager) {
        super("kit setDisplayName <kit> <displayname>", kitsManager, "setdisplayname");
    }

    public void execute(CommandSender sender, String[] args, String label, Kit kit) {
        StringJoiner displayNameJoiner = new StringJoiner(" ");
        for (int argIndex = 2; argIndex < args.length; argIndex++) {
            displayNameJoiner.add(args[argIndex]);
        }
        kit.setDisplayName(displayNameJoiner.toString());
        sender.sendMessage(ChatColor.GREEN + "The display-name of the kit was updated.");
    }
}
