package me.jorlowski.factory_method;

public class TableHeaderDouble extends TableHeader {
    public TableHeaderDouble(String type) {
        super(type);
    }

    @Override
    public TableData getTableData() {
        return new TableDataDouble();
    }
}
