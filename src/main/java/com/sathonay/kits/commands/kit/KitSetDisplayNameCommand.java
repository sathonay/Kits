package com.sathonay.kits.commands.kit;

import com.sathonay.core.api.util.CC;
import com.sathonay.kits.handler.KitsHandler;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.StringJoiner;

public class KitSetDisplayNameCommand extends KitSubCommand{
    public KitSetDisplayNameCommand(KitsHandler kitsHandler) {
        super("kit setDisplayName <kit> <displayname>", kitsHandler, "setdisplayname");
    }

    @Override
    public void execute(Player player, String[] args, String label, Kit kit) {
        StringJoiner displayNameJoiner = new StringJoiner(" ");
        for (int argIndex = 2; argIndex < args.length; argIndex++) {
            displayNameJoiner.add(args[argIndex]);
        }
        kit.setDisplayName(displayNameJoiner.toString());
        player.sendMessage(ChatColor.GREEN + "The display-name of the kit was updated.");
    }
}
