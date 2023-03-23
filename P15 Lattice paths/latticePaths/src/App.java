import java.math.BigInteger;

// Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

// How many such routes are there through a 20×20 grid? -   137,846,528,820

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int m = 20;
        int n = 20;
        
        System.out.printf("The number of possible paths for an %d by %d grid is: %,d%n",m,n,getPaths(m,n));

        long endTime = System.nanoTime();
        System.out.printf("Time taken: %,dns%n",endTime-startTime);
    }
    public static long factorial(long n){
        if (n >= 1) {
            return(n * factorial(n - 1));
        } else {
            return(1);
        }
    }
    public static double paths(long n){
        return( factorial(2*n)/ (factorial(n)*factorial(n)) );
    }

    public static BigInteger recursiveBigInteger(int n){
        BigInteger n1 = new BigInteger("1");
        int result = BigInteger.valueOf(n).compareTo(n1);
        if (result >= 0) {
            return(BigInteger.valueOf(n).multiply(recursiveBigInteger((n-1))));
        } else {
            return(new BigInteger("1"));
        }
    }

    public static BigInteger getFactorial(int m){
        BigInteger n1 = new BigInteger("1");
        for (int i = 2; i < m+1; i++) {
            n1 = n1.multiply(BigInteger.valueOf(i));
        }
        return(n1);
    }

    public static BigInteger getPaths(int m, int n){
        BigInteger numerator   = recursiveBigInteger(n+m);
        BigInteger denominator = recursiveBigInteger(m).multiply(recursiveBigInteger(n));
        return(numerator.divide(denominator));
    }
}
