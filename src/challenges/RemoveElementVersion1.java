package challenges;

import java.util.Arrays;

public class RemoveElementVersion1 {
    /**
     * Replaces the instances of a number with zeros
     * @param array An array of integers.
     * @param target The integer to be removed of type int.
     * @return The number of replaced instances.
     */
    static int replaceWithZero(int[] array, int target) {
        int n = array.length;
        int countReplaced = 0;

        for (int i = 0; i < n ; i++) {
            if(array[i] == target) {
                array[i] = 0;
                countReplaced++;
            }
        }
        return countReplaced;
    }

    /**
     * Moves the zeros to the end of the array.
     * @param array An array of integers.
     * @param endPositionCount The number of end positions to hold the zeros.
     */
    static void moveZerosToEnd(int[] array, int endPositionCount) {
        int n = array.length;
        int i = 0;
        int countSwaps = 0;
        int temp;

        while (countSwaps != endPositionCount) {
            if (array[i] == 0 && array[n - 1] != 0) {
                temp = array[i];
                array[i] = array[n - 1];
                array[n - 1] = temp;
                n--;
                countSwaps++;
            }
            i++;
        }
    }

    /**
     * Copies the contents of an array of integers
     * to a new array excluding the zeroes at the
     * end.
     * @param array An array of integers
     * @param zeroCount The number of zeros in the array.
     * @return An array of integers with reduced length.
     */
    static int[] copyToNewArray(int[] array, int zeroCount) {
        int n = array.length - zeroCount;
        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }

        public static void main (String[]args){
            int[] numbers = new int[]{44, 30, 25, 35, 11, 46, 62, 61, 84, 31, 22, 27, 65, 66, 65, 18, 71};
            int instanceCount;
            int[] arrayWithoutZeros;

            // Display the contents of initial array.
            System.out.println(Arrays.toString(numbers));

            // Display the contents of the array after replacing number
            // instances with zero.
            instanceCount = replaceWithZero(numbers, 65);
            System.out.println(Arrays.toString(numbers));

            // Display the contents after moving the zeros to the
            // end of the array.
            moveZerosToEnd(numbers, instanceCount);
            System.out.println(Arrays.toString(numbers));

            // Display the contents of the array as copied without the zeros.
            arrayWithoutZeros = copyToNewArray(numbers, instanceCount);
            System.out.println(Arrays.toString(arrayWithoutZeros));
    }
}

