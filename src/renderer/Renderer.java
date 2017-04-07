package renderer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * Renderer class that is called initially to render fields and methods.
 *
 */
public class Renderer {
    private final Object object;
    private final Class classObject;

    /**
     * The constructor.
     *
     * @param object The object that should be rendered.
     */
    public Renderer(Object object) {
        this.object = object;
        this.classObject = object.getClass();
    }

    /**
     * Renders either the fields or methods or both.
     *
     * @return the rendered result string.
     */
    public String render() {
        String result = "Instance of SomeClass:\n";

        Field[] fields = classObject.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(renderer.RenderMe.class) != null) {
                field.setAccessible(true);

                if (!field.getAnnotation(renderer.RenderMe.class).with().equals("default")) {
                    try {
                        result += field.getName() + " (Type " + field.getType().getCanonicalName() + ") ";
                        result += ArrayRenderer.render(field.get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        result += field.getName() + " (Type " + field.getType().getCanonicalName() + "): " + field.get(object).toString() + "\n";
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }


        Method[] methods = classObject.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getAnnotation(renderer.RenderMe.class) != null) {
                if (method.getParameterTypes().length == 0) {
                    try {
                        result += method.invoke(object, null);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        return result;
    }
}
