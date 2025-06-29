package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MathUtilsTest {

    private MathUtils mathUtils;

    @Before
    public void setUp() {
        mathUtils = new MathUtils();
        System.out.println("Setup completed.");
    }

    @After
    public void tearDown() {
        System.out.println("Test completed.");
    }

    @Test
    public void testSquare() {
        int input = 4;
        int result = mathUtils.square(input);
        assertEquals(16, result);
    }

    @Test
    public void testCube() {
        int input = 3;
        int result = mathUtils.cube(input);
        assertEquals(27, result);
    }
}

