package com.sathonay.kits.commands.kit;

import com.google.common.collect.Lists;
import com.sathonay.core.api.command.SubCommand;
import com.sathonay.kits.manager.KitsManager;
import com.sathonay.kits.model.Kit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class KitSubCommand extends SubCommand {
    protected final KitsManager kitsManager;
    public KitSubCommand(String syntax, KitsManager kitsManager, String... names)  {
        super(syntax, names);
        this.kitsManager = kitsManager;
    }

    @Override
    public void execute(CommandSender sender, String[] args, String label) {

        String kitName = args[1];
        if (!kitsManager.containsKey(kitName)) {
            sender.sendMessage("Kit not found");
            return;
        }

        execute(sender, args, label, kitsManager.get(kitName));
        if (sender instanceof Player) execute((Player) sender, args, label, kitsManager.get(kitName));
        kitsManager.saveUpdates();
    }

    public void execute(Player player, String[] args, String label, Kit kit) {}

    public void execute(CommandSender sender, String[] args, String label, Kit kit) {}

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
        if (args.length == 2) return Lists.newArrayList(kitsManager.keySet());
        return super.tabComplete(sender, alias, args);
    }
}
