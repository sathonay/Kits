package com.sathonay.kits.commands.kit;

import com.google.common.collect.Lists;
import com.sathonay.core.api.command.SubCommandPlayer;
import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.model.Kit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class KitSubCommand extends SubCommandPlayer {
    protected final KitsManager kitsManager;
    public KitSubCommand(String syntax, KitsManager kitsManager, String... names)  {
        super(syntax, names);
        this.kitsManager = kitsManager;
    }

    @Override
    public void execute(Player player, String[] args, String label) {

        String kitName = args[1];
        if (!kitsManager.containsKey(kitName)) {
            player.sendMessage("Kit not found");
            return;
        }

        execute(player, args, label, kitsManager.get(kitName));
    }

    public abstract void execute(Player player, String[] args, String label, Kit kit);

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        if (args.length == 2) return Lists.newArrayList(kitsManager.keySet());
        return super.tabComplete(sender, alias, args);
    }
}
