package renderer;

import java.lang.reflect.Array;

/**
 * Customised Renderer for array class.
 */
final class ArrayRenderer {
    /**
     * private constructor for ArrayRenderer class.
     * It is private because as a helper class it should not have a public constructor.
     */
    private ArrayRenderer() {
    }

    /**
     * static render class for any type of array.
     *
     * @param object array to be rendered
     * @return result string representation of array
     */
    public static String render(Object object) {
        Object[] objectArray = convertToArray(object);

        String result = "[";
        for (Object o : objectArray) {
            result += o + ", ";
        }
        return result + "]\n";
    }

    /**
     * @param object to be converted to array.
     * @return array of objects.
     */
    private static Object[] convertToArray(Object object) {

        Object item = Array.get(object, 0);
        int arrayLength = Array.getLength(object);
        Object[] test = (Object[]) Array.newInstance(item.getClass(), arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            test[i] = Array.get(object, i);
        }
        return test;
    }
}