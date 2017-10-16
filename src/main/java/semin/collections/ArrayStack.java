package semin.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<Item> implements IStack<Item> {

    private static final int DEFAULT_CAPACITY = 10;

    private Item[] elementData;
    private int size;


    public ArrayStack() {
        this.elementData = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(Item item) {
        grow();
        elementData[size++] = item;
    }

    @Override
    public Item pop() {
        shrink();
        return elementData[--size];
    }


    public Item peek() {
        if ( size<=0) return null;
        int t = size-1;
        return elementData[t];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * TODO: implement it
     * Если массив заполнился,
     * то увеличить его размер в полтора раз
     */
    private void grow() {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);// /2
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

        if (elementData.length >= DEFAULT_CAPACITY &&
                size == oldCapacity >> 2) {// /4
            changeCapacity(oldCapacity >> 1);
        }
    }
    private void changeCapacity(int newCapacity) {
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        private int currentPosition = size;

        @Override
        public boolean hasNext() {
            return currentPosition != 0;
        }

        @Override
        public Item next() {
            return elementData[--currentPosition];
        }

    }

}



