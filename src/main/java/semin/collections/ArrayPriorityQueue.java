package semin.collections;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayPriorityQueue<Key extends Comparable<Key>> implements IPriorityQueue<Key> {
    private static final int DEFAULT_CAPACITY = 10;

    private Key[] elementData;
    private Comparator<Key> comparator;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue() {
        elementData = (Key[]) new Comparable[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(Comparator<Key> comparator) {
        elementData = (Key[]) new Comparable[DEFAULT_CAPACITY];
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue(Key[] keys) {
        size = keys.length;
        elementData = (Key[]) new Comparable[size];
        System.arraycopy(keys, 0, elementData, 0, size);
        build();
    }

    @Override
    public void add(Key key) {
        grow();
        elementData[size++] = key;
        siftUp();
    }

    @Override
    public Key peek() {
        return elementData[0];
    }

    @Override
    public Key extractMin() {
        shrink();
        Key max = elementData[0];
        elementData[0] = elementData[--size];
        siftDown(0);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void build() {
        for (int i = size / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftUp() {
        int curIndex = size - 1;
        if (curIndex != 0) {
            int parentIndex;
            do {
                parentIndex = (curIndex - 1) / 2;
                if (greater(parentIndex, curIndex)) {
                    Key tmp = elementData[parentIndex];
                    elementData[parentIndex] = elementData[curIndex];
                    elementData[curIndex] = tmp;
                    curIndex = parentIndex;
                } else {
                    return;
                }
            } while (parentIndex != 0);
        }
    }

    private void siftDown(int i) {
        int p = i;
        while (p < size) {
            int maxChild = 2 * p + 1; // l
            if (maxChild >= size) {
                return;
            }
            int r = 2 * p + 2;
            if (r < size) {
                if (greater(maxChild, r)) {
                    maxChild = r;
                }
            }
            if (greater(p, maxChild)) {
                Key tmp = elementData[maxChild];
                elementData[maxChild] = elementData[p];
                elementData[p] = tmp;
            }
            p = maxChild;
        }
    }

    private void grow() {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;

            int newCapacity = oldCapacity + (oldCapacity >> 1);
            changeCapacity(newCapacity);
        }
    }

    private void shrink() {
        int oldCapacity = elementData.length;
        // не уменьшать размер меньше, чем размер по умолчанию
        if (elementData.length >= DEFAULT_CAPACITY &&
                size == oldCapacity >> 2) {
            changeCapacity(oldCapacity >> 1);
        }
    }

    @SuppressWarnings("unchecked")
    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private boolean greater(int i, int j) {
        return comparator == null
                ? elementData[i].compareTo(elementData[j]) > 0
                : comparator.compare(elementData[i], elementData[j]) > 0;
    }

    @Override
    public Iterator<Key> iterator() {
        return new ArrayPriorityQueueIterator();
    }

    private class ArrayPriorityQueueIterator implements Iterator<Key> {
        private int currentPosition = 0;

        @Override
        public boolean hasNext() {
            return currentPosition + 1 != size;
        }

        @Override
        public Key next() {
            return elementData[currentPosition++];
        }

    }
}

