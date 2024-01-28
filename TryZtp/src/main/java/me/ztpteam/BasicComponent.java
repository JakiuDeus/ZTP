package me.ztpteam;

import me.ztpteam.commands.Command;

import java.util.List;

public interface BasicComponent {
    List<Command> getCommands();
    String getStatus();
    List<ComponentType> getType();
}
