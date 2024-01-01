package challenges;

import java.util.Scanner;

public class TwoDArraySymmetry {
    /**
     * Checks if an array is symmetric.
     * @param array A 2D array of integers.
     * @return True if is symmetric, false otherwise.
     */
    static boolean isSymmetric(int[][] array) {
        boolean compResult = true;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] != array[j][i]) {
                    compResult = false;
                    break;
                }
            }
        }

        return compResult;
    }

    static boolean isValid(int r, int c) {
        return r > 0 && c > 0;
    }

    /**
     * Checks if an array is a square matrix,
     * ie has the same number of rows and columns.
     * @param r The number of rows of type int.
     * @param c The number of columns of type int.
     * @return True if the array is a square matrix, false otherwise.
     */
    static boolean isSquareMatrix(int r, int c) {
        return r == c;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] numbers;
        int row;
        int col;

        System.out.print("Enter number of rows: ");
        row = input.nextInt();
        System.out.print("Enter number of columns: ");
        col = input.nextInt();

        while(!isValid(row, col)) {
            System.out.println("Input not valid. Try again!");
            System.out.print("\nEnter number of rows: ");
            row = input.nextInt();
            System.out.print("Enter number of columns: ");
            col = input.nextInt();
        }

        if(isSquareMatrix(row, col)) {
            numbers = new int[row][col];

            System.out.println("\nEnter the numbers: ");
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers[i].length; j++) {
                    numbers[i][j] = input.nextInt();
                }
            }

            if(isSymmetric(numbers)) {
                System.out.println("\nThe array is symmetric.");
            } else {
                System.out.println("\nThe array is asymmetric.");
            }

        } else {
            System.out.println("\nThe array is asymmetric.");
        }
    }
}
