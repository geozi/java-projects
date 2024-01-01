package challenges;

import java.util.Scanner;

public class PalindromicIntegerVersion2 {
    /**
     * Checks if a number is a palindrome.
     * @param num A number of type int
     * @return True if the number is a palindrome, false otherwise.
     */
    static boolean isPalindrome(int num) {
        boolean compResult = true;

        String numAsString = Integer.toString(num);
        char left, right;
        int n = (int) Math.floor(Math.log10(num) + 1);
        for(int i = 0, j = n-1; i < n && j >= 0; i++, j-- ) {
            left = numAsString.charAt(i);
            right = numAsString.charAt(j);
            if(left != right) {
                compResult = false;
                break;
            }
        }
        return compResult;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;

        System.out.printf("Enter a number: ");
        number = input.nextInt();

        if(isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
    }
}
