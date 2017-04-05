package renderer;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ArrayRenderer {
    public static String render(Object object) {
        if(object instanceof Field)
            System.out.println("Yeeah");

        Field arrayField = (Field) object;

        String result = "";
        result = arrayField.getName() + "(Type " + arrayField.getType() + ") [";


/*
        try {
            Arrays.toString(arrayField.get(object));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
*/

        try {
            result +=  arrayField.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }

}
