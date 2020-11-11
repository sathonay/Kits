package com.sathonay.kits.commands;

import com.sathonay.core.api.command.newcommand.command.PlayerCommand;
import com.sathonay.core.menu.Menus;
import com.sathonay.kits.menu.KitsMenu;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class KitsCommand extends PlayerCommand {
    public Menus menus;
    public KitsCommand(Menus menus) {
        super("kits");
        this.menus = menus;
    }

    @Override
    public void perform(Player player, Command command, String s, String[] strings) {
        menus.open(player, KitsMenu.class);
    }
}
