package com.sathonay.kits.commands.kit;

import com.sathonay.kits.handler.KitsHandler;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class KitSetCommand extends KitSubCommand{
    public KitSetCommand(KitsHandler kitsHandler) {
        super("kit set <kit>", kitsHandler, "kit");
    }

    @Override
    public void execute(Player player, String[] args, String label, Kit kit) {
        PlayerInventory inventory = player.getInventory();
        //kit.setArmorContents(inventory.getArmorContents());
        kit.setContents(inventory.getContents());
        kitsHandler.saveUpdates();
        player.sendMessage(ChatColor.GREEN + "The kit content was updated.");
    }
}
