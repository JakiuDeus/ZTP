package me.jorlowski.factory_method;

public class TableHeaderChar extends TableHeader {
    public TableHeaderChar(String type) {
        super(type);
    }

    @Override
    public TableData getTableData() {
        return new TableDataChar();
    }
}
