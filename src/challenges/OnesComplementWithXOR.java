package challenges;

public class OnesComplementWithXOR {
    /**
     * Counts the number of bits in binary form.
     * @param num A number of type int.
     * @return The count of bits of type int.
     */
    static int countBitsInBinary(int num) {
        int count = 0;
        while(num != 0) {
            count++;
            num>>>=1;
        }

        return count;
    }

    /**
     * Uses the countBitsInBinary(int) method
     * to generate the ones' complement of a number.
     * @param num A number of type int.
     * @return The ones' complement of the inserted number.
     */
    static int onesComplement(int num) {
        int bitNum = countBitsInBinary(num);
        for (int i = 0; i < bitNum; i++) {
            int bitMask = 1 << i;
            num ^= bitMask;
        }

        return num;
    }

    public static void main(String[] args) {
        int num = 142;
        System.out.println("Initial number in binary: " + Integer.toBinaryString(num));
        System.out.println("The ones' complement of the initial number: " + Integer.toBinaryString(onesComplement(num)));
    }
}
