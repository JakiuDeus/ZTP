package pl.wipb.ztp.ps4;

public class ProxyCopy implements Data {

    private Data original, copy;

    public ProxyCopy(Data original) {
        this.original = original;
        Data.setCopy(this, original);
        copy = null;
    }

    @Override
    public int get(int idx) {
        return original != null ? original.get(idx) : copy.get(idx);
    }

    @Override
    public void set(int idx, int value) {

        if (original != null) {
            Data.release(this);
            copy = new RealData(original.size());
            for (int i=0; i<original.size(); i++) {
                copy.set(i, original.get(i));
            }
            original = null;
        } else {
            Data.release((Data)this);
        }

        copy.set(idx, value);
    }

    @Override
    public int size() {
        return copy == null ? original.size() : copy.size();
    }
}
