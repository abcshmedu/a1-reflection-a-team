/**
 * Created by Nelson on 06.04.2017.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import renderer.Renderer;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Parameterized test for Renderer class.
 * This test class runs a number of tests taken from a list of test cases.
 *
 * @author S. Siemens, S. Weiß
 * @see Renderer
 */

@RunWith(Parameterized.class)
public class RendererTestParameterized {

    private int fooValue;
    private String expectedValue;

    /**
     * Constructor for values to be tested during test.
     * @param fooValue The value of foo.
     * @param expectedValue The value expected to be returned by the render() method
     * @see Renderer
     */
    public RendererTestParameterized(int fooValue, String expectedValue) {
        this.fooValue = fooValue;
        this.expectedValue = expectedValue;
    }

    /**
     * Contains the test cases that are tested.
     * @return The collection that contains the test cases.
     */
    @Parameterized.Parameters
    public static Collection primeNumbers() {
        final int magicConstant = 234567;
        return Arrays.asList(new Object[][] {
                {2, "Instance of SomeClass:\n"
                        + "foo (Type int): 2\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nHello World!"},

                {magicConstant, "Instance of SomeClass:\n"
                        + "foo (Type int): 234567\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nHello World!" },
                {Integer.MIN_VALUE, "Instance of SomeClass:\n"
                        + "foo (Type int): -2147483648\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nHello World!" },
                {Integer.MAX_VALUE, "Instance of SomeClass:\n"
                        + "foo (Type int): 2147483647\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nHello World!" }
        });
    }



    /**
     * The test method that performs the individual junit tests for each case.
     * @throws Exception
     */
    @Test
    public void testRendering() {
        assertEquals(new Renderer(new SomeClass(fooValue)).render(), expectedValue);
    }
}
