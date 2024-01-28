package me.ztpteam;

public enum ComponentType {
    BASIC_LIGHT("Światło"),
    LED("LED"),
    TUNABLE_LIGHT("Przyciemniane");

    private final String componentType;

    ComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getName() {
        return componentType;
    }
}
