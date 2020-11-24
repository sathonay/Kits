package com.sathonay.kits.commands.kit;

import com.sathonay.core.api.command.SubCommand;
import com.sathonay.kits.manager.KitsManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class KitRemoveCommand extends SubCommand {
    private final KitsManager kitsManager;
    public KitRemoveCommand(KitsManager kitsManager) {
        super("kit remove <kit>", "remove");
        this.kitsManager = kitsManager;
    }

    @Override
    public void execute(CommandSender sender, String[] args, String label) {
        if (Objects.nonNull(kitsManager.remove(args[1]))) sender.sendMessage(ChatColor.RED + "Kit removed.");
        else sender.sendMessage(ChatColor.RED + "This kit doesn't exist.");
    }
}
