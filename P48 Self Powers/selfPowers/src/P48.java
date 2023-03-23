import java.math.BigInteger;

// Self powers Problem 48
// The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

// Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
// Reference: https://rianjs.net/2011/05/java-solution-to-project-euler-problem-48

public class P48 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        BigInteger total = BigInteger.ZERO;
        int limit = 1000;
        for (int i = 1; i < limit+1; i++) {
            BigInteger sum = BigInteger.valueOf(i).pow(i);
            total = total.add(sum);

        }
        String totStr = total.toString(10);
        totStr = totStr.substring(totStr.length()-10, totStr.length());
        long endTime = System.nanoTime();


        System.out.printf("Total: %s%n", totStr);
        System.out.printf("Time taken: %,dms%n",endTime-startTime);
    }
}
