package challenges;

public class MaxConsecutiveZerosInBinary {

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
     * in binary form.
     * @param num A number of int.
     * @return The max number of consecutive zeros.
     */
    static int countMaxConsecutiveZeros(int num) {
        int n = countBinaryDigits(num);
        int max = 0;
        int zeroNum = 0;

        for (int i = 0; i < n; i++) {
            if((num & 1) == 0) {
                zeroNum++;
            } else {
                if(max < zeroNum) max = zeroNum;
                zeroNum = 0;
            }

            num >>>=1;
        }
        return max;
    }

    public static void main(String[] args) {
        int num = 81;
        int consecZeros = countMaxConsecutiveZeros(num);
        System.out.println(consecZeros);

    }
}
