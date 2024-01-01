package challenges;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementVersion2 {
    /**
     * Removes the target integer from an array of integers
     * by using an ArrayList and an integer array as auxiliary
     * data structures.
     * @param array An array of integers.
     * @param target The integer to be removed.
     * @return A copy of the original array without the target value.
     */
    static int[] removeTargetInstances(int[] array, int target) {
        int n = array.length;
        int countTargetInstances = 0;
        ArrayList<Integer> arrayAsList = new ArrayList<>();
        int[] arrayWithoutTargetInstances;

        for (int i = 0; i < n; i++) {
            if(array[i] != target) {
                arrayAsList.add(array[i]);
            } else {
                countTargetInstances++;
            }
        }

        arrayWithoutTargetInstances = new int[n - countTargetInstances];

        for (int i = 0; i < arrayWithoutTargetInstances.length; i++) {
            arrayWithoutTargetInstances[i] = arrayAsList.get(i);
        }

        return arrayWithoutTargetInstances;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{44, 30, 25, 35, 11, 46, 62, 61, 84, 31, 22, 27, 65, 66, 65, 18, 71};
        int target = 65;
        int[] numbersWithoutTarget;

        System.out.println(Arrays.toString(numbers));
        numbersWithoutTarget = removeTargetInstances(numbers, target);
        System.out.println(Arrays.toString(numbersWithoutTarget));

    }
}
