package com.sathonay.kits.commands;

import com.sathonay.core.api.command.ParentCommand;
import com.sathonay.kits.commands.kit.*;
import com.sathonay.kits.handler.KitsHandler;

public class KitCommand extends ParentCommand {
    public KitCommand(KitsHandler kitsHandler) {
        super("kit");
        setPermission("kit.command.kit");
        registerSubCommands(
                new KitAddCommand(kitsHandler),
                new KitRemoveCommand(kitsHandler),
                new KitSetCommand(kitsHandler),
                new KitSetIconCommand(kitsHandler),
                new KitSetDisplayNameCommand(kitsHandler),
                new KitListCommand(kitsHandler)
        );
    }
}
