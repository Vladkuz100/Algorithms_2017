package semin.collectionsTest;

import java.util.Iterator;

import org.junit.Test;

import semin.collections.TwoStackQueue;

import static org.junit.Assert.*;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TwoStackQueueTest {

    @Test
    public void constructor(){
        TwoStackQueue queue = new TwoStackQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0,queue.size());
    }

    @Test
    public void enqueueDequeue(){
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();

        queue.enqueue(1);
        assertEquals(1,queue.dequeue().intValue());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1,queue.dequeue().intValue());
        assertEquals(2,queue.dequeue().intValue());
        assertEquals(3,queue.dequeue().intValue());
    }


    @Test
    public void iterator(){
        TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        for(int i = 0; i< 10;i++) {
            queue.enqueue(i);
        }
        Iterator<Integer> iterator = queue.iterator();
        for(int i = 0; i< 10;i++){
            assertEquals(i,iterator.next().intValue());
        }
        assertFalse(iterator.hasNext());

    }


}