import java.math.BigInteger;

// n! means n × (n − 1) × ... × 3 × 2 × 1

// For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
// and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

// Find the sum of the digits in the number 100! = 648

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int n = 100;
        int result = sumDigits(recursiveBigInteger(n).toString(1));

        long endTime = System.nanoTime();
        System.out.printf("The sum of digits of %d! is: %,d%n",n,result);
        System.out.printf("Time taken: %,d%n", endTime-startTime);
        
    }
    
    public static BigInteger recursiveBigInteger(int n){ // needed because the number is quite large 10^157 or so
        BigInteger n1 = new BigInteger("1");
        int result = BigInteger.valueOf(n).compareTo(n1);
        if (result >= 0) {
            return(BigInteger.valueOf(n).multiply(recursiveBigInteger((n-1))));
        } else {
            return(n1);
        }
    }

    public static int sumDigits(String digits){
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            char ch = (char)digits.codePointAt(i);
            sum += Character.getNumericValue(ch);
        }
        return(sum);
    }
}
