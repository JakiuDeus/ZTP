package me.ztpteam.lights;

import me.ztpteam.ComponentType;
import me.ztpteam.commands.Command;
import me.ztpteam.commands.SetLEDCommand;

import java.util.List;

public class LED implements Light {
    private String hexRGB;
    private Light light;
    private ComponentType type;

    public LED (Light light) {
        this.light = light;
        hexRGB = "#FFFFFF";
        type = ComponentType.LED;
    }

    public String getLedVal() {
        return hexRGB;
    }

    @Override
    public void decorate(Light light) {
        this.light = light;
    }

    @Override
    public List<Command> getCommands() {
        List<Command> commands = light.getCommands();
        commands.add(new SetLEDCommand(this));
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
        return light.getStatus() + "\nLED: hex Color = " + hexRGB;
    }

    public void setVal(String ledVal) {
        hexRGB = ledVal;
    }
}
