package challenges;

import java.util.Arrays;

public class CyclicArrayElementRotation {
    /**
     * Shifts the array elements by n positions.
     * @param arr An array of integers.
     * @param n The number of shift positions.
     * @return An array of integers.
     */
    static int[] doCircularShiftBy(int[] arr, int n) {
        int[] shiftedArray = new int[arr.length];
        int newIndex;

        for (int i = 0; i < arr.length; i++) {
            newIndex = (i + n) % arr.length;
            shiftedArray[newIndex] = arr[i];
        }

        return shiftedArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] shiftedArray = doCircularShiftBy(array, 3);

        System.out.println(Arrays.toString(shiftedArray));
    }
}
