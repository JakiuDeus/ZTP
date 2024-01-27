package me.ztpteam.lights;

import me.ztpteam.BasicComponent;
import me.ztpteam.ComponentType;
import me.ztpteam.commands.Command;
import me.ztpteam.commands.SwitchOnOffCommand;

import java.util.ArrayList;
import java.util.List;

public class BasicLight implements Light {
    private boolean isOn;
    private ComponentType type;

    public BasicLight(Light light) {
        isOn = false;
        type = ComponentType.BASIC_LIGHT;
    }

    public BasicLight() {
        isOn = false;
    }

    public void decorate(Light light) {
        throw new UnsupportedOperationException("Basic Light cannot be decorated, it is the root of light components");
    }

    public List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new SwitchOnOffCommand(this) {
            @Override
            public void execute() {
                isOn = !isOn;
            }
        });
        return commands;
    }

    @Override
    public String getStatus() {
        return "Basic Light: isOn = " + isOn;
    }
}
