import renderer.RenderMe;

import java.util.Date;

public class SomeClass {
    @RenderMe
    private int foo;

    @RenderMe(with = "renderer.ArrayRenderer")
    int[] array = {1, 2, 3,};

    @RenderMe
    private Date date = new Date(123456789);

    public SomeClass(int foo) {
        this.foo = foo;
    }

    @RenderMe
    public String returnHelloWorld(){
        return "Hello World!";
    }
}