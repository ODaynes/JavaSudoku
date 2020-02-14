package test;

import org.junit.Assert;
import org.junit.Test;
import util.ArrayMethods;

/**
 * Test methods for ArrayMethods class
 */

public class ArrayMethodsTests {

    @Test
    public void testShiftRight() {
        char[] expected = new char[] {'g','h','i','a','b','c','d','e','f'};
        char[] actual = ArrayMethods.shiftRight(new char[] {'a','b','c','d','e','f','g','h','i'}, 3);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testShiftQuadrantRight() {
        char[] expected = new char[] {'c','a','b','f','d','e','i','g','h'};
        char[] actual = ArrayMethods.shiftQuadrantRight(new char[] {'a','b','c','d','e','f','g','h','i'}, 1);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSwapElements() {
        char[] expected = new char[] {'c','b','a'};
        char[] actual = new char[] {'a','b','c'};

        ArrayMethods.swapElements(actual, 0, 2);
        Assert.assertArrayEquals(expected, actual);
    }
}
