package semin;

import org.junit.Test;

import static semin.Solver.evaluate;
import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void Test1(){
        String[] sequence = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )".split(" ");
        assertEquals(101, evaluate(sequence), 0.01);
    }

    @Test
    public void Test2(){
        String[] sequence = "( 1 + ( 5 * ( 4 * 5 ) ) ) ( 1 + ( 5 * 20 ) )".split(" ");
        assertEquals(101, evaluate(sequence), 0.01);
    }

    @Test
    public void Test3(){
        String[] sequence = "( 1 + 100 )".split(" ");
        assertEquals(101, evaluate(sequence), 0.01);
    }
}