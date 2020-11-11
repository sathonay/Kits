package com.sathonay.kits.commands.kit;

import com.sathonay.kits.handler.KitsHandler;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class KitSetDisplayNameCommand extends KitSubCommand{
    public KitSetDisplayNameCommand(KitsHandler kitsHandler) {
        super("kit setDisplayName <kit> <displayname>", kitsHandler, "setdisplayname");
    }

    @Override
    public void execute(Player player, String[] args, String label, Kit kit) {
        kit.setDisplayName(args[2]);
        player.sendMessage(ChatColor.GREEN + "The display-name of the kit was updated.");
    }
}
