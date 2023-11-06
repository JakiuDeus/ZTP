package pl.wipb.ztp.ps4;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.AbstractListModel;

// baza danych - kolekcja Data
class Baza extends AbstractListModel<Data>{
    private final List<Data> ar = new ArrayList<>();


    public void add(Data tab){
    	ar.add(tab);
        fireIntervalAdded(this, ar.size()-1, ar.size()-1);
    }

    public void remove(int idx){
    	if (idx < 0 || idx >= ar.size()) {
            throw new ArrayIndexOutOfBoundsException("" + idx);
        }
        ar.remove(idx);
        fireIntervalRemoved(this, idx, idx);
    }

    public int getSize() {
    	return ar.size();
    }

    public Data getElementAt(int index) {
    	if (index < 0 || index >= ar.size()) {
            throw new ArrayIndexOutOfBoundsException("" + index);
        }
        return ar.get(index);
    }
}