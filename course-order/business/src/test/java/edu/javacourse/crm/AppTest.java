package edu.javacourse.crm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by artemtursunov on 14.12.16.
 */
public class AppTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test1() throws Exception {
        App p = new App();
            p.test1();
            Assert.fail();
    }

    @Test(expected = MyException.class)
    public void test2() throws Exception {
        App p = null;
        try {

            p.test2();
        }
        catch (Exception ex) {
            throw new MyException(ex.getMessage());
        }
    }

    @Test
    public void test3() throws Exception {
        App p = new App();
        p.test3();
    }

}