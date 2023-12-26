package challenges;

import java.util.Scanner;

public class PalindromicIntegerVersion1 {
    /**
     * Counts the number of digits in a
     * number of type int.
     * @param num A number of type int.
     * @return The number of digits.
     */
    static int countDigits(int num) {
        int count = 0;
        while(num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    /**
     * Checks if a number is a palindrome.
     * @param num A number of type integer.
     * @return True if the number is a palindrome, false otherwise.
     */
    static boolean isPalindrome(int num) {
        boolean compResult = true;
        int n = countDigits(num);
        int divisor = (int) (Math.pow(10, n-1));
        int leftDigit;
        int rightDigit;
        int temp = num;

        for(int i = 0; i < n; i++) {
            leftDigit = (num / divisor) % 10;
            rightDigit = temp % 10;

            if(leftDigit != rightDigit) {
                compResult = false;
                break;
            }

            divisor /= 10;
            temp /= 10;
        }
        return compResult;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.printf("Enter a number: ");
        number = input.nextInt();

        if(isPalindrome(number)){
            System.out.println(number + " is a palindrome number");
        } else {
            System.out.println(number + " is not a palindrome number");
        }
    }
}
