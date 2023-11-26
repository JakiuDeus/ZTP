package me.ztpteam.command;

public class ShipmentInvoker {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
