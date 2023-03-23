// Quadratic primes Problem 27
// Euler discovered the remarkable quadratic formula:

// n^2 + n + 41

// It turns out that the formula will produce 40 primes for the consecutive integer values 0 <= n <= 39. However, when n=40, 40^2 + 40 + 41 is divisible by 41, and certainly when n=41, 41^2 + 41 + 41 is clearly divisible by 41.

// The incredible formula n^2 - 79n + 1601 was discovered, which produces 80 primes for the consecutive values 0 <= n <= 79. The product of the coefficients, −79 and 1601, is −126479.

// Considering quadratics of the form:

// n^2 + an + b, where |a| < 1000 and b <= 1000

// where |n| is the modulus/absolute value of n
// e.g. |11| = 11 and |-4| = 4
// Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
// https://snipcademy.com/challenges/quadratic-primes
// http://www.javaproblems.com/2013/11/project-euler-problem-27-quadratic_27.html
// a: -61, b: 971, axb: -59231

public class p27 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int maxA = 0;
        int maxB = 0;
        int maxN = 0;

        int currentMax = 0;

        for (int a = -999; a < 1000; a+=2) {
            for (int b = 3; b < 1000; b+=2) {
                currentMax = findMaxN(a,b);
                if (currentMax > maxN) {
                    maxN = currentMax;
                    maxA = a;
                    maxB = b;
                }
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.printf("a: %d, b: %d, a*b: %d%n", maxA, maxB, maxA*maxB);
        System.out.printf("Time taken: %,dms%n", endTime-startTime);
    }

    public static int findMaxN(int a, int b){
        int max = 0;
        int n = 2;

        while(isPrime(n*n + a*n + b)){
            if(n > max){
                max = n++;
            }
        }
        return max;
    }

    public static boolean isPrime(int input){
        if (input == 2) {
            return true;
        } 
        if (input <= 1) {
            return false;
        } 
        if (input %2 == 0) {
            return false;
        }
        for (int i = input-2; i >= Math.sqrt(input); i -=2) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}
