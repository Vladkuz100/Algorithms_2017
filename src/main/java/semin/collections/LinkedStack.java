package semin.collections;

import java.util.Iterator;

public class LinkedStack<Item> implements IStack<Item> {

    private Node<Item> head;
    private int size;

    @Override
    public void push(Item item) {
        head = new Node<>(item, head);
        size++;
    }

    @Override
    public Item pop() {
        Item item = head.item;
        head = head.next;
        size--;
        return item;
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
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {

        private Node<Item> currentPos = head;
        @Override
        public boolean hasNext() {
            return currentPos != null;
        }

        @Override
        public Item next() {
            Item currentItem = currentPos.item;
            currentPos = currentPos.next;
            return currentItem;
        }

    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;

        public Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }
}

