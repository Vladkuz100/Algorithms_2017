package semin.collectionsTest;

import java.util.Iterator;

import org.junit.Test;

import semin.collections.LinkedQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedQueueTest {

    @Test
    public void constructor(){
        LinkedQueue<Integer> queue = new LinkedQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0,queue.size());
        queue.enqueue(1);
        assertEquals(1,queue.size());
    }

    @Test
    public void enqueueDequeue(){
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        assertEquals(1,(int)queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(2,(int)queue.dequeue());
        assertEquals(3,(int)queue.dequeue());
    }


    @Test
    public void iterator(){
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1,iterator.next().intValue());
        assertEquals(2,iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}