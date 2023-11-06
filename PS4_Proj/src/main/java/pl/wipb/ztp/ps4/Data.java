package pl.wipb.ztp.ps4;

import java.util.*;

// dane przechowywane w bazie
interface Data {
    Map<ProxyCopy, Data> copies = new HashMap<>();
    int get(int idx);
    void set(int idx, int value);
    int size();
    static void setCopy(ProxyCopy p, Data d) {
        copies.put(p, d);
    }

    static void release(ProxyCopy d) {
        copies.remove(d);
    }
    static void release(Data d) {
        for(ProxyCopy p : copies.keySet()) {
            if (copies.get(p) == d) {
                p.set(0,p.get(0));
                copies.remove(p);
            }
        }
    }
}