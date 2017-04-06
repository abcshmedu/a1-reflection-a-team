package renderer;

import java.lang.reflect.Field;

public class Renderer {
    private final Object object;
    private final Class classObject;

    public Renderer(Object object) {
        this.object = object;
        this.classObject = object.getClass();
    }

    public String render() {
        String result = "";

        Field[] fields = classObject.getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(renderer.RenderMe.class) != null) {
                field.setAccessible(true);

                if (!field.getAnnotation(renderer.RenderMe.class).with().equals("default"))
                    try {
                        System.out.println(field.getType());

                        System.out.println(field.getType().getCanonicalName());
                        System.out.println(field.getType().getName());
                        result += field.getName() + " (Type " + field.getType().getCanonicalName() + ") ";
                        result += ArrayRenderer.render(field.get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                else {
                    try {
                        result += field.getName() + " (Type " + field.getType() + "): " + field.get(object).toString() + "\n";
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }
}
