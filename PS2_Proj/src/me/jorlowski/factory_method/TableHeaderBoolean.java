package me.jorlowski.factory_method;

public class TableHeaderBoolean extends TableHeader {
    public TableHeaderBoolean(String type) {
        super(type);
    }

    @Override
    public TableData getTableData() {
        return new TableDataBoolean();
    }
}
