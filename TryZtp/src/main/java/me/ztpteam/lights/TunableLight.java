package me.ztpteam.lights;

import me.ztpteam.ComponentType;
import me.ztpteam.commands.Command;
import me.ztpteam.commands.SetLEDCommand;
import me.ztpteam.commands.TuneLightCommand;

import java.util.List;

public class TunableLight implements Light {
    private byte tune;
    private Light light;
    private ComponentType type;


    public TunableLight (Light light) {
        this.light = light;
        tune = 100;
        type = ComponentType.TUNABLE_LIGHT;
    }

    public byte getTune() {
        return tune;
    }
    @Override
    public void decorate(Light light) {
        this.light = light;
    }

    @Override
    public List<Command> getCommands() {
        List<Command> commands = light.getCommands();
        commands.add(new TuneLightCommand(this));
        return commands;
    }

    @Override
    public List<ComponentType> getType() {
        List<ComponentType> componentTypeList = light.getType();
        componentTypeList.add(type);
        return componentTypeList;
    }
    @Override
    public String getStatus() {
        return light.getStatus() + "\nTunable light: tune value = " + tune;
    }

    public void setVal(byte tuneVal) {
        tune = tuneVal;
    }
}
