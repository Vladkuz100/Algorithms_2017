package semin.collectionsTest;

import org.junit.Test;

import semin.collections.ArrayStack;

import static org.junit.Assert.assertEquals;

public class ArrayStackTest {
    @Test
    public void constructor(){
        ArrayStack<Integer> arrStack = new ArrayStack<>();
        assertEquals(0,arrStack.size());
        arrStack.push(1);
        assertEquals(1,arrStack.size());
        arrStack.pop();
        assertEquals(0, arrStack.size());
    }

    @Test
    public void  pushPop(){
        ArrayStack<Integer> arrStack = new ArrayStack<>();
        arrStack.push(1);
        assertEquals(1,arrStack.size());
        assertEquals(1,(int)arrStack.pop());

        arrStack.push(1);
        arrStack.push(2);
        arrStack.push(3);
        assertEquals(3,arrStack.size());
        assertEquals(3,(int)arrStack.pop());
        assertEquals(2, arrStack.size());
        assertEquals(2,(int)arrStack.pop());
        assertEquals(1, arrStack.size());
        assertEquals(1,(int)arrStack.pop());
        assertEquals(0, arrStack.size());
    }

}