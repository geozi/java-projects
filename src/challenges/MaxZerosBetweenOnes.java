package challenges;

import java.util.Scanner;

public class MaxZerosBetweenOnes {
    /**
     * Counts the length of a number in binary form.
     * @param num A number of type int.
     * @return The number of digits in binary form.
     */
    static int countBinaryDigits(int num) {
        int count = 0;

        while(num > 0) {
            num >>>=1;
            count++;
        }

        return count;
    }

    /**
     * Finds the max number of consecutive zeros
     * between 1s in binary form.
     * @param num A number of int.
     * @return The max number of consecutive zeros.
     */
    static int countMaxZerosBetweenOnes(int num) {
        int n = countBinaryDigits(num);
        int maxZeroSeq = 0;
        int countZeros = 0;
        boolean firstOneFound = false;


        for (int i = 0; i < n; i++) {
            if((num & 1) == 0) {
                countZeros++;
            } else {
                if(firstOneFound && maxZeroSeq < countZeros ) {
                    maxZeroSeq = countZeros;
                } else {
                    firstOneFound = true;
                }
                countZeros=0;
            }

            num >>>=1;
        }
        return maxZeroSeq;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;

        System.out.print("Enter a number: ");
        num = input.nextInt();

        int consecZeros = countMaxZerosBetweenOnes(num);
        System.out.println(num  + " = " + Integer.toBinaryString(num));
        System.out.println("Max zeros between ones: " + countMaxZerosBetweenOnes(num) );

    }
}
