package me.jorlowski;
class TableDataInt implements TableData {
    private final int data;

    public TableDataInt() {
        data = rnd.nextInt(100);
    }

    public String toString() {
        return Integer.toString(data);
    }
    
}
/* ... */
