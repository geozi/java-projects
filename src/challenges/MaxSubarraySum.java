package challenges;

import java.util.Arrays;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] subArray;
        int currentSum = 0;
        int globalSum = 0;
        int startIndex = 0;
        int endIndex = 0;

        for(int i =0;i < array.length;i++) {
            currentSum += array[i];
            if(currentSum < 0) {
                currentSum = 0;
                startIndex = i + 1;
            } else {
                if(currentSum > globalSum) {
                    globalSum = currentSum;
                    endIndex = i;
                }
            }
        }

        subArray = Arrays.copyOfRange(array, startIndex, endIndex+1);

        System.out.println("Greatest sum: " + globalSum);
        System.out.println("Subarray: " + Arrays.toString(subArray) );
    }
}
