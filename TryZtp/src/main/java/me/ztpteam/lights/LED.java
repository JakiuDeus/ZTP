package me.ztpteam.lights;

import me.ztpteam.ComponentType;
import me.ztpteam.boards.Port;
import me.ztpteam.boards.Status;
import me.ztpteam.commands.Command;
import me.ztpteam.commands.SetLEDCommand;

import java.util.List;

public class LED implements Light {
    private String hexRGB;
    private Light light;
    private ComponentType type;
    private Port port;

    public LED (Light light) {
        this.light = light;
        hexRGB = "#FFFFFF";
        type = ComponentType.LED;
        port = light.getPort();
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
    public Port getPort() {
        return port;
    }

    @Override
    public String getStatus() {
        return light.getStatus() + "<br/>Kolor = " + hexRGB;
    }

    public Status setVal(String ledVal) {
        hexRGB = ledVal;
        return port.send("COLOR:"+ledVal);
    }
}
