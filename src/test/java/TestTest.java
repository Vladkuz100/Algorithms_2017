import org.junit.*;

import  static test_package.Test.out;

import static org.junit.Assert.*;

/**
 * Created by Vladkuz on 09.10.2017.
 */
public class TestTest {
    @org.junit.Test
    public void outUU() {
        int res = out();
        Assert.assertEquals(res,100);
    }


}