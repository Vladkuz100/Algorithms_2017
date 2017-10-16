package semin.collections;

import java.util.Iterator;

public class LinkedDeque<Item> implements IDeque<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    @Override
    public void pushFront(Item item) {
        final Node<Item> tmp = head;
        head = new Node<>(item);
        if (isEmpty()) {
            tail = head;
        } else {
            tmp.prev = head;
            head.next = tmp;
        }
        size++;
    }

    @Override
    public void pushBack(Item item) {
        final Node<Item> tmp = tail;
        tail = new Node<>(item);
        if (isEmpty()) {
            head = tail;
        } else {
            tmp.next = tail;
            tail.prev = tmp;
        }
        size++;
    }

    @Override
    public Item popFront() {
        size--;
        final Item value = head.item;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return value;
    }

    @Override
    public Item popBack() {
        size--;
        final Item value = tail.item;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedDequeIterator();
    }

    private class LinkedDequeIterator implements Iterator<Item> {
        private Node<Item> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            final Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;

        public Node(Item item) {
            this.item = item;
        }
    }
}
