package me.ztpteam.commands;

public enum CommandType {
    SEE_INFO("Pokaż informacje"),
    SET_LED("Ustaw kolor"),
    SWITCH_ON_OFF("Włącz / wyłącz"),
    TUNE_LIGHT("Ustaw jasność");

    private final String commandType;

    CommandType(String commandType) {
        this.commandType = commandType;
    }

    public String getName() {
        return commandType;
    }
}
