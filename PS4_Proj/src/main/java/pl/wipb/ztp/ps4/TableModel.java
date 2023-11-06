package pl.wipb.ztp.ps4;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private Data data = null;

    @Override
    public int getRowCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return rowIndex;
        }
        if (columnIndex == 1) {
            return data.get(rowIndex);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Indeks";
        }
        if (column == 1) {
            return "Wartość";
        }
        return super.getColumnName(column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 1) {
            data.set(rowIndex, (int) aValue);
        }
        super.setValueAt(aValue, rowIndex, columnIndex);
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int colIdx) {
        return Integer.class;
    }

    public void changeData(Data newData) {
        data = newData;;
        fireTableStructureChanged();
    }
}
