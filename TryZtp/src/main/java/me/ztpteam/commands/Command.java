package me.ztpteam.commands;

import me.ztpteam.ComponentType;

public interface Command {
    void execute();
    ComponentType getComponentType();
    CommandType getCommandType();
}
