import java.math.BigInteger;

// 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
// What is the sum of the digits of the number 2^1000? - 1,366

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        BigInteger power = new BigInteger("2").pow(1000);
        String value = power.toString(1);
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            char ch = (char)value.codePointAt(i);
            sum += Character.getNumericValue(ch);
        }
        long endTime = System.nanoTime();
        System.out.printf("The sum of digits for 2^1000 is: %,d%n",sum);
        System.out.printf("Time taken: %,dns %n", endTime-startTime);
    }
}
