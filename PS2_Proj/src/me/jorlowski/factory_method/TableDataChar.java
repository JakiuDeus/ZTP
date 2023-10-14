package me.jorlowski.factory_method;

public class TableDataChar implements TableData {
    private final char data;

    public TableDataChar() {
        data = (char)rnd.nextInt(255);
    }
    public String toString() {
        return Character.toString(data);
    }
}
