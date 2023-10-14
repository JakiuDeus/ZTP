package me.jorlowski.factory_method;

public abstract class TableHeader {
    private final String type;

    public TableHeader(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }

    public abstract TableData getTableData();
    
}
