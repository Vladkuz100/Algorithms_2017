package semin.collections;

import java.util.Iterator;

public class CyclicArrayQueue<Item> implements IQueue<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    private Item[] elementData = (Item[]) new Object[DEFAULT_CAPACITY];
    private int head, tail;

    @Override
    public void enqueue(Item item) {
        grow();
        elementData[tail] = item;
        tail = (tail + 1) % elementData.length;
    }

    @Override
    public Item dequeue() {
        shrink();
        final Item item = elementData[head];
        head = (head + 1) % elementData.length;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        if (tail >= head) {
            return tail - head;
        } else {
            return (elementData.length - head) + tail;
        }
    }

    /**
     * TODO: implement it
     * Если массив заполнился,
     * то увеличить его размер в полтора раз
     */
    private void grow() {
        if (size() == elementData.length - 1) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            changeCapacity(newCapacity);
        }
    }

    /**
     * TODO: implement it
     * Если количество элементов в четыре раза меньше,
     * то уменьшить его размер в два раза
     */
    private void shrink() {
        int oldCapacity = elementData.length;
        // не уменьшать размер меньше, чем размер по умолчанию
        if (elementData.length >= DEFAULT_CAPACITY &&
                size() == oldCapacity >> 2) {
            changeCapacity(oldCapacity >> 1);
        }
    }

    @SuppressWarnings("unchecked")
    private void changeCapacity(int newCapacity) {
        final Item[] newElementData = (Item[]) new Object[newCapacity];
        if (tail >= head) {
            System.arraycopy(elementData, head, newElementData, 0, size());
            tail -= head;
            head = 0;
        } else {
            System.arraycopy(elementData, 0, newElementData, 0, tail);
            final int delta = newCapacity - elementData.length;
            System.arraycopy(elementData, head, newElementData, delta + head, elementData.length - head);
            head += delta;
        }
        elementData = newElementData;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CyclicArrayQueueIterator();
    }

    private class CyclicArrayQueueIterator implements Iterator<Item> {

        private int currentPosition = head;

        @Override
        public boolean hasNext() {
            return currentPosition != tail;
        }

        @Override
        public Item next() {
            final Item item = elementData[currentPosition];
            currentPosition = (currentPosition + 1) % elementData.length;
            return item;
        }

    }
}

