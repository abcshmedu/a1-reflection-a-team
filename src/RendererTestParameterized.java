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

@RunWith(Parameterized.class)
public class RendererTestParameterized {

    private int fooValue;
    private String expectedValue;

    public RendererTestParameterized(int fooValue, String expectedValue) {
        this.fooValue = fooValue;
        this.expectedValue = expectedValue;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { 2, "Instance of SomeClass:\n" +
                        "foo (Type int): 2\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n"},

                { 23, "Instance of SomeClass:\n" +
                        "foo (Type int): 23\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" },
                { Integer.MIN_VALUE, "Instance of SomeClass:\n" +
                        "foo (Type int): -2147483648\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" },
                { Integer.MAX_VALUE, "Instance of SomeClass:\n" +
                        "foo (Type int): 2147483647\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n" }
        });
    }


    @Test
    public void testRendering() throws Exception {
        assertEquals(new Renderer(new SomeClass(fooValue)).render(), expectedValue);
    }
}
