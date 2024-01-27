package me.ztpteam.commands;

import me.ztpteam.ComponentType;
import me.ztpteam.lights.LED;
import me.ztpteam.lights.TunableLight;

public class TuneLightCommand implements Command {
    private TunableLight light;
    private byte tuneVal;

    public TuneLightCommand(TunableLight light) {
        this.light = light;
        tuneVal = light.getTune();
    }

    @Override
    public void execute() {
        light.setVal(tuneVal);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.TUNABLE_LIGHT;
    }

    public void setTuneVal(byte tuneVal) {
        this.tuneVal = tuneVal;
    }

    @Override
    public String toString() {
        return "Set Tune Command";
    }
}
