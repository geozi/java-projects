package challenges;

import java.util.Scanner;

public class CountOnesAndZerosInBinary {

    /**
     * Checks the LSB in the binary representation of
     * an unsigned number for 0 or 1, and increments
     * the corresponding index in the auxiliary array.
     * @param num A number of type long
     * @return An int[] array with the number of 1s and 0s
     */
    static int[] countOnesAndZeros(Long num ) {
        int[] tempArray = new int[2];

        while(num != 0) {

            if((num & 1) == 0) {
                tempArray[0]++;
            } else {
                tempArray[1]++;
            }
            num>>>=1;
        }
        return tempArray;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] zerosAndOnes;
        long number;

        System.out.print("\nEnter a number: ");
        number = input.nextLong();
        zerosAndOnes = countOnesAndZeros(number);
        System.out.println("\nThe number of 0s in the binary representation of " + number + " is " + zerosAndOnes[0]);
        System.out.println("The number of 1s in the binary representation of " + number + " is " + zerosAndOnes[1]);
    }
}
