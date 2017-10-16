package semin.collectionsTest;

import java.util.Iterator;

import org.junit.Test;

import semin.collections.CyclicArrayQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CyclicArrayQueueTest {

    @Test
    public void constructor(){
        CyclicArrayQueue queue = new CyclicArrayQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0,queue.size());
    }

    @Test
    public void enqueueDequeue(){
        CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        queue.enqueue(1);
        assertEquals(1,queue.size());
        assertEquals(1,queue.dequeue().intValue());

    }

    @Test
    public void enqueueManyItems(){
        CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();

        for(int i =0; i< 10;i++){
            queue.enqueue(i);
            queue.dequeue();
        }

        assertTrue(queue.isEmpty());

        for (int i = 0; i < 40; i++) {
            queue.enqueue(i);
        }

        for(int i = 0; i< 20; i++){
            assertEquals(i,queue.dequeue().intValue());
        }
    }


    @Test
    public void iterator(){
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        final Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}