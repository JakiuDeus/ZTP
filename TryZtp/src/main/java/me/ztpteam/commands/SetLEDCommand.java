package me.ztpteam.commands;

import me.ztpteam.ComponentType;
import me.ztpteam.boards.Status;
import me.ztpteam.lights.LED;

public class SetLEDCommand implements Command {

    private LED led;
    private String ledVal;

    public SetLEDCommand(LED led) {
        this.led = led;
        ledVal = led.getLedVal();
    }

    @Override
    public Status execute() {
        return led.setVal(ledVal);
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.LED;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.SET_LED;
    }

    public void setLedVal(String ledVal) {
        this.ledVal = ledVal;
    }

    @Override
    public String toString() {
        return "Set Led Command";
    }
}
