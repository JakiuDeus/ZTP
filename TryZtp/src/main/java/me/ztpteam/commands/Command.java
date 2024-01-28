package me.ztpteam.commands;

import me.ztpteam.ComponentType;
import me.ztpteam.boards.Status;

public interface Command {
    Status execute();
    ComponentType getComponentType();
    CommandType getCommandType();
}
