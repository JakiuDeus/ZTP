package me.jorlowski.factory_method;

public class TableHeaderInt extends TableHeader {
    public TableHeaderInt(String type) {
        super(type);
    }

    @Override
    public TableData getTableData() {
        return new TableDataInt();
    }
}
