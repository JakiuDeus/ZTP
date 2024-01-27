package me.ztpteam.commands;

import me.ztpteam.ComponentType;
import me.ztpteam.lights.BasicLight;

public class SwitchOnOffCommand implements Command {

    private BasicLight light;
    public SwitchOnOffCommand(BasicLight light) {
        this.light = light;
    }

    @Override
    public void execute() {

    }

    @Override
    public ComponentType getType() {
        return ComponentType.BASIC_LIGHT;
    }

    @Override
    public String toString() {
        return "Switch On/Off Command";
    }
}
