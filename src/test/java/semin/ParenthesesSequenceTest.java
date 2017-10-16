package semin;

import org.junit.Assert;

import static org.junit.Assert.*;
import static semin.ParenthesesSequence.isBalanced;
import static test_package.Test.out;

/**
 * Created by Vladkuz on 09.10.2017.
 */
public class ParenthesesSequenceTest {
    @org.junit.Test
    public void test_all() {
        String [] testList = new String[5];
        testList[0] = "()";
        testList[1] = ")((()))";
        testList[2] = ")(";
        testList[3] = "";
        testList[4] = "(()()(";
        assertTrue(isBalanced(testList[0]));
        assertFalse(isBalanced(testList[1]));
        assertFalse(isBalanced(testList[2]));
        assertTrue(isBalanced(testList[3]));
        assertFalse(isBalanced(testList[4]));
    }

}