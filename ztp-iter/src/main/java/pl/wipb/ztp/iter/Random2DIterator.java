package pl.wipb.ztp.iter;

import java.util.*;
import java.util.stream.Collectors;

public class Random2DIterator<E> implements Iterator<E> {
    // TODO
    private List<E> collection;
    private final Random random;
    private int pos;

    public Random2DIterator(E[][] table, int x, int y) {
        collection = Arrays.stream(table)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        pos = y * table[y].length + x;
        random = new Random(System.currentTimeMillis());
    }

    public Random2DIterator(E[][] table) {
        collection = Arrays.stream(table)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        pos = 0;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public boolean hasNext() {
        return pos < collection.size();
    }

    @Override
    public E next() {
        if (hasNext()) {
            int index = random.nextInt(collection.size() - pos);
            return collection.remove(pos + index);
        }
        throw new NoSuchElementException("No more elements");
    }
}