package renderer;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ArrayRenderer {
    public static String render(Object object) {
        Object[] objectArray = convertToArray(object);



        String result = "[";
        for (Object o : objectArray) {
            result += o + ", ";
        }
        return result + "]\n";
    }

    private static Object[] convertToArray(Object object) {

        Object item = Array.get(object, 0);
        int arrayLength = Array.getLength(object);
        Object[] test = (Object[]) Array.newInstance(item.getClass(), arrayLength);

        for(int i = 0; i < arrayLength; i++){
            test[i] = Array.get(object, i);
        }
        return test;
    }
}