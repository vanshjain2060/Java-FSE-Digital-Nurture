package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    Assertions demo = new Assertions();

    @Test
    public void testAssertEquals() {
        assertEquals("Sum should be correct", 10, demo.sum(4, 6));
    }

    @Test
    public void testAssertTrue() {
        assertTrue("Should be active", demo.isActive());
    }

    @Test
    public void testAssertFalse() {
        assertFalse("10 < 5 should be false", 10 < 5);
    }
}
