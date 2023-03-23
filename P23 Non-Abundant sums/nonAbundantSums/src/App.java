
// A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

// A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

// As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

// Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers. - 4,179,871

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int limit = 28_123;
        int totalSum = 0;
        for (int i = 1; i < limit; i++) {
            if (!isSumOfAbundantNumbers(i)) {
                totalSum += i;
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("The sum of non abundant numbers below %,d is: %,d%n", limit,totalSum);
        System.out.printf("Time taken: %,d%n",endTime-startTime);
    }

    public static boolean isSumOfAbundantNumbers(int num){
        int lim = (num+2)/2;
        for (int i = 1; i < lim; i++) {
            int a = num-i;
            if (isAbundant(i) && isAbundant(a)) {
                return(true);
            }
        }
        return(false);
    }

    public static boolean isAbundant(int num){
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum > num) {
            return(true);
        }
        return(false);
    }
    
}

