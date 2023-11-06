package pl.wipb.ztp.ps4;

public class ProxyData implements Data {

    private final int size;
    private RealData data = null;

    public ProxyData(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("" + size);
        }
        this.size = size;
    }

    @Override
    public int get(int idx) {
        return data == null ? 0 : data.get(idx);
    }

    @Override
    public void set(int idx, int value) {
        if (data == null) {
            data = new RealData(size);
        }
        Data.release(this);
        data.set(idx, value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "(Proxy) " + (data == null ? "null, rozmiar " + size : data.toString());
    }
}
