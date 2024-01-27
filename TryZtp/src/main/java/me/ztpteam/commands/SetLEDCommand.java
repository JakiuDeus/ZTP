package me.ztpteam.commands;

import me.ztpteam.ComponentType;
import me.ztpteam.lights.LED;

public class SetLEDCommand implements Command {

    private LED led;
    private String ledVal;

    public SetLEDCommand(LED led) {
        this.led = led;
        ledVal = led.getLedVal();
    }

    @Override
    public void execute() {
        led.setVal(ledVal);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.LED;
    }

    public void setLedVal(String ledVal) {
        this.ledVal = ledVal;
    }

    @Override
    public String toString() {
        return "Set Led Command";
    }
}
