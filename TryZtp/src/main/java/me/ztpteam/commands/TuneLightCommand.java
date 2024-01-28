package me.ztpteam.commands;

import me.ztpteam.ComponentType;
import me.ztpteam.boards.Status;
import me.ztpteam.lights.TunableLight;

public class TuneLightCommand implements Command {
    private TunableLight light;
    private byte tuneVal;

    public TuneLightCommand(TunableLight light) {
        this.light = light;
        tuneVal = light.getTune();
    }

    @Override
    public Status execute() {
        return light.setVal(tuneVal);
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.TUNABLE_LIGHT;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.TUNE_LIGHT;
    }

    public void setTuneVal(byte tuneVal) {
        this.tuneVal = tuneVal;
    }

    @Override
    public String toString() {
        return "Set Tune Command";
    }
}
