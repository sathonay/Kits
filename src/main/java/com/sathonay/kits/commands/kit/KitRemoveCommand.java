package com.sathonay.kits.commands.kit;

import com.sathonay.core.api.command.SubCommand;
import com.sathonay.kits.handler.KitsHandler;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class KitRemoveCommand extends SubCommand {
    private final KitsHandler kitsHandler;
    public KitRemoveCommand(KitsHandler kitsHandler) {
        super("kit remove <kit>", "remove");
        this.kitsHandler = kitsHandler;
    }

    @Override
    public void execute(CommandSender sender, String[] args, String label) {
        if (Objects.nonNull(kitsHandler.remove(args[1]))) sender.sendMessage(ChatColor.RED + "Kit removed.");
        else sender.sendMessage(ChatColor.RED + "This kit doesn't exist.");
    }
}
