package semin;

import org.junit.Test;

import static semin.SolverExt.calcAll;
import static org.junit.Assert.*;

public class SolverExtTest {

    @Test
    public void Test1(){
        String[] sequence = "1 + ( 2 + 3 ) * 4".split(" ");
        assertEquals(21, calcAll(sequence), 0.01);
    }

    @Test
    public void Test2(){
        String[] sequence = "5 + 4 / 2".split(" ");
        assertEquals(7, calcAll(sequence), 0.01);
    }

    @Test
    public void Test3(){
        String[] sequence = "1 + 100".split(" ");
        assertEquals(101,  calcAll(sequence), 0.01);
    }
}
