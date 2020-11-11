package com.sathonay.kits.commands.kit;

import com.sathonay.core.api.command.SubCommandPlayer;
import com.sathonay.kits.handler.KitsHandler;
import com.sathonay.kits.model.Kit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.Objects;

public class KitAddCommand extends SubCommandPlayer {
    private final KitsHandler kitsHandler;
    public KitAddCommand(KitsHandler kitsHandler) {
        super("kit add <kit>", "add");
        this.kitsHandler = kitsHandler;
    }

    @Override
    public void execute(Player player, String[] args, String label) {

        PlayerInventory inventory = player.getInventory();
        Kit kit = kitsHandler.putIfAbsent(args[1], new Kit(/*, inventory.getArmorContents()*/ inventory.getContents()).setDisplayName(args[1]));
        if (Objects.nonNull(kit)) player.sendMessage(ChatColor.GREEN + "Kit created.");
        else player.sendMessage(ChatColor.RED + "This kit already exist");
    }
}
