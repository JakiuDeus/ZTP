package me.jorlowski.factory_method;


public class TableDataDouble implements TableData {
    private final double data;

    public TableDataDouble() {
        data = rnd.nextDouble() * 100;
    }

    public String toString() {
        return Double.toString(data);
    }
}
