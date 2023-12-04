package pl.wipb.ztp.iter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Basic2DIterator<E> implements Iterator<E> {
    private final List<E> collection;
    private int pos;

    public Basic2DIterator(E[][] table, int x, int y) {
        collection = Arrays.stream(table)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        pos = y * table[y].length + x;
    }

    public Basic2DIterator(E[][] table) {
        collection = Arrays.stream(table)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < collection.size();
    }

    @Override
    public E next() {
        if (hasNext()) {
            return collection.get(pos++);
        }
        throw new NoSuchElementException("No more elements");
    }
}
