package me.jorlowski.factory_method;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

class Database extends AbstractTableModel {
    private final List<TableHeader> headers;
    private final List<List<TableData>> data;

    public Database() {
        headers = new ArrayList<>();
        data = new ArrayList<>();
    }

    public void addRow() {
        List<TableData> row = new ArrayList<>();
        for (TableHeader col : headers) {
            row.add(col.getTableData()); // wywołanie metody fabrykującej
        }
        data.add(row);
        fireTableStructureChanged();
    }

    public void addCol(TableHeader type) {
        headers.add(type);
        for (List<TableData> row : data) {
            row.add(type.getTableData()); // wywołanie metody fabrykującej
        }
        fireTableStructureChanged();
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return headers.size();
    }

    public String getColumnName(int column) {
        return headers.get(column).toString();
    }

    public Object getValueAt(int row, int column) {
        return data.get(row).get(column);
    }
    
}
