package com.sathonay.kits.commands.kit;

import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class KitSetCommand extends KitSubCommand {
    public KitSetCommand(KitsManager kitsManager) {
        super("kit set <kit>", kitsManager, "set");
    }

    @Override
    public void execute(Player player, String[] args, String label, Kit kit) {
        PlayerInventory inventory = player.getInventory();
        //kit.setArmorContents(inventory.getArmorContents());
        kit.setContents(inventory.getContents());
        player.sendMessage(ChatColor.GREEN + "The kit content was updated.");
    }
}
