
import org.junit.Before;
import org.junit.Test;
import renderer.Renderer;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test class for single tests.
 * @see RendererTestParameterized
 */
public class RendererTest {
    private final int someConstant = 5;
    private SomeClass toRender;
    private Renderer renderer;

    /**
     * Sets up the necessary variables for the test.
     */
    @Before
    public void setUp() {
        toRender = new SomeClass(someConstant);
        renderer = new Renderer(toRender);
    }

    /**
     * Single test as an example of how a JUnit test looks like.
     * @throws Exception
     */
    @Test
    public void testRendering() {
        assertEquals("Instance of SomeClass:\n"
                        + "foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\ndate (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\nHello World!",
                renderer.render());
    }
}