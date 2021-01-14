package com.sathonay.kits.commands;

import com.sathonay.core.api.command.ParentCommand;
import com.sathonay.kits.commands.kit.*;
import com.sathonay.kits.manager.KitsManager;

public class KitCommand extends ParentCommand {
    public KitCommand(KitsManager kitsManager) {
        super("kit");
        setPermission("kit.command.kit");
        registerSubCommands(
                new KitAddCommand(kitsManager),
                new KitRemoveCommand(kitsManager),
                new KitRemovePermissionCommand(kitsManager),
                new KitSetCommand(kitsManager),
                new KitSetIconCommand(kitsManager),
                new KitSetDisplayNameCommand(kitsManager),
                new KitSetPermssionCommand(kitsManager),
                new KitInfoCommand(kitsManager),
                new KitListCommand(kitsManager)
        );
    }
}
