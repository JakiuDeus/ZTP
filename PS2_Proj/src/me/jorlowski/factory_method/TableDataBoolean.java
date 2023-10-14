package me.jorlowski.factory_method;

public class TableDataBoolean implements TableData {
    private final boolean data;

    public TableDataBoolean() {
        data = rnd.nextBoolean();
    }
    public String toString() {
        return Boolean.toString(data);
    }
}
