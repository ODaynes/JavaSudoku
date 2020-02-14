package util;

import java.util.Arrays;
import java.util.Random;

/**
 * Custom methods to help with processing arrays
 *
 * @author owen.daynes
 * @date 13 February 2020
 */
public class ArrayMethods {

    /**
     * Randomises elements in array
     *
     * @param arr Array to randomise
     * @return randomly ordered array
     */
    public static char[] suffleCharArray(char[] arr) {
        char[] arrCopy = Arrays.copyOf(arr, arr.length);
        Random rand = new Random();

        for(int i = 0; i < arrCopy.length; i++) {
            int j = rand.nextInt(arrCopy.length);
            swapElements(arrCopy, i, j);
        }

        return arrCopy;
    }

    /**
     * Shifts elements in array to the right by provided amount
     *
     * @param arr Array to shift elements of
     * @param by How much to shift each element by
     * @return array with shifted elements
     */
    public static char[] shiftRight(char[] arr, int by) {
        char[] arrCopy = new char[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int j = (i + by) % arrCopy.length;
            arrCopy[j] = arr[i];
        }

        return arrCopy;
    }

    /**
     * Rotates the elements in each quadrant provided amount
     *
     * @param arr Array to shift elements of
     * @param by How much to shift each element by
     * @return array with shifted elements
     */
    public static char[] shiftQuadrantRight(char[] arr, int by) {
        char[] arrCopy = new char[arr.length];
        int size = (int) Math.sqrt(arr.length);

        for(int quadrant = 1; quadrant < size + 1; quadrant++) {
            int offset = size * (quadrant - 1);
            for (int i = 0 + offset; i < size + offset; i++) {
                int j = ((i + by) % size) + offset;
                arrCopy[j] = arr[i];
            }
        }


        return arrCopy;
    }

    /**
     * Swaps elements arr[i] and arr[j]
     *
     * @param arr Array to swap elements in
     * @param i index of first element
     * @param j index of second element
     */
    private static void swapElements(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
