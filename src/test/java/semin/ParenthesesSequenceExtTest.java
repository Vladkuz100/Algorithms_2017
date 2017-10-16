package semin;

import org.junit.Assert;
import org.junit.Test;

import static semin.ParenthesesSequenceExt.isBalanced;
import static org.junit.Assert.*;

public class ParenthesesSequenceExtTest {

    @Test
    public void Test0(){
        String str = "";
        //assertEquals(true,isBalanced(str));
        assertTrue(isBalanced(str));
    }

    @Test
    public void Test1(){
        String str = "(())";
        //assertEquals(true,isBalanced(str));
        assertTrue(isBalanced(str));
    }

    @Test
    public void Test2(){
        String str = "))((";
        assertEquals(false,isBalanced(str));
    }

    @Test
    public void Test3(){
        String str = "(()";
        assertEquals(false,isBalanced(str));
    }

    @Test
    public void Test4(){
        String str = "((()";
        assertEquals(false,isBalanced(str));
    }

    @Test
    public void Test5(){
        String str = "(()()(())((())))";
        assertEquals(true,isBalanced(str));
    }

    @Test
    public void Test6(){
        String str = "([{}])";
        assertEquals(true,isBalanced(str));
    }

    @Test
    public void Test7(){
        String str = "(([]{}[){})";
        assertEquals(false,isBalanced(str));
    }

    @Test
    public void Test8(){
        String str = "}])([{";
        assertEquals(false,isBalanced(str));
    }
}