import renderer.RenderMe;

import java.util.Date;

/**
 * Class to be annotated.
 */
public class SomeClass {
    private final int thirdConstant = 3;
    private final int dateValue = 123456789;

    @RenderMe
    private int foo;

    @RenderMe(with = "renderer.ArrayRenderer")
    private int[] array = null; //{1, 2, thirdConstant, };

    @RenderMe
    private Date date = new Date(dateValue);

    /**
     * The constructor.
     * @param foo int value that represents some random number.
     */
    SomeClass(int foo) {
        this.foo = foo;
    }

    /**
     * Example method that is idempotent and can be tested with reflections.
     * @return A fixed string value.
     */
    @RenderMe
    public String returnHelloWorld() {
        return "Hello World!";
    }
}