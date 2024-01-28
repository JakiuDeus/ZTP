package me.ztpteam.commands;

import me.ztpteam.ComponentType;
import me.ztpteam.boards.Status;
import me.ztpteam.lights.BasicLight;

public class SwitchOnOffCommand implements Command {

    private BasicLight light;
    public SwitchOnOffCommand(BasicLight light) {
        this.light = light;
    }

    public Status execute() {
        return light.switchOnOff();
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.BASIC_LIGHT;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.SWITCH_ON_OFF;
    }

    @Override
    public String toString() {
        return "Switch On/Off Command";
    }
}
