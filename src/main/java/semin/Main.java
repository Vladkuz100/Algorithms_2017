package semin;


import semin.collections.CyclicArrayQueue;
import semin.collections.IQueue;
import semin.collections.IStack;
import semin.collections.LinkedQueue;
import semin.collections.LinkedStack;
import semin.collections.TwoStackQueue;
import semin.collections.CyclicArrayDeque;
import semin.collections.ArrayPriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("LinkedStack");
        IStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        for (int i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("LinkedQueue");
        IQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
       for (int i : queue) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 20; i++) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("TwoStackQueue");
        queue = new TwoStackQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(queue.dequeue() + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("CyclicArrayQueue");
        CyclicArrayQueue  qqueue = new CyclicArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            qqueue.enqueue(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(qqueue.dequeue() + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("CyclicArrayDeque");
        CyclicArrayDeque  dequeue = new CyclicArrayDeque();
        for (int i = 0; i < 20; i++) {
            dequeue.pushFront(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(dequeue.popBack() + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Arr prior queue");
        ArrayPriorityQueue apk = new ArrayPriorityQueue();
        for (int i = 0; i < 20; i++) {
            apk.add(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(apk.extractMin()+ " ");
        }
    }
}
