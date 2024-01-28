package me.ztpteam.lights;

import me.ztpteam.ComponentType;
import me.ztpteam.boards.Port;
import me.ztpteam.boards.Status;
import me.ztpteam.commands.Command;
import me.ztpteam.commands.SwitchOnOffCommand;

import java.util.ArrayList;
import java.util.List;

public class BasicLight implements Light {
    private Port port;
    private boolean isOn;
    private ComponentType type;

    public BasicLight(Light light) {
        isOn = false;
        type = ComponentType.BASIC_LIGHT;
    }

    public BasicLight(Port port) {
        isOn = false;
        type = ComponentType.BASIC_LIGHT;
        this.port = port;
    }

    public Port getPort() {
        return port;
    }

    public void decorate(Light light) {
        throw new UnsupportedOperationException("Basic Light cannot be decorated, it is the root of light components");
    }

    public List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new SwitchOnOffCommand(this));
        return commands;
    }

    public Status switchOnOff() {
        isOn = !isOn;
        return port.send("SWITCH");
    }

    public List<ComponentType> getType() {
        ArrayList<ComponentType> componentTypeList = new ArrayList<>();
        componentTypeList.add(type);
        return componentTypeList;
    }

    @Override
    public String getStatus() {
        return isOn ? "Włączone" : "Wyłączone";
    }
}
