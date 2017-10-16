package semin.collections;

import java.util.Iterator;

public class TwoStackQueue<Item> implements IQueue<Item> {

    private IStack<Item> stack1;
    private IStack<Item> stack2;

    public TwoStackQueue() {
        stack1 = new ArrayStack<>();
        stack2 = new ArrayStack<>();
    }

    @Override
    public void enqueue(Item item) {
        stack1.push(item);
    }

    @Override
    public Item dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        return stack2.size()+stack1.size();
    }

    @Override
    public Iterator<Item> iterator() {
        return new TwoStackQueueIterator();
    }
    private class TwoStackQueueIterator implements Iterator<Item> {
        private Iterator<Item> stack2Iterator = stack2.iterator();
        private Iterator<Item> stack1RevIterator;

        public TwoStackQueueIterator() {
            final IStack<Item> tmp = new ArrayStack<>();
            for (Item aStack1 : stack1) {
                tmp.push(aStack1);
            }
            stack1RevIterator = tmp.iterator();
        }

        @Override
        public boolean hasNext() {
            return stack2Iterator.hasNext() || stack1RevIterator.hasNext();
        }

        @Override
        public Item next() {
            if (stack2Iterator.hasNext()) {
                return stack2Iterator.next();
            } else {
                return stack1RevIterator.next();
            }
        }
    }
}
