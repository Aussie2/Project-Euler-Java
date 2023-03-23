// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
// Find the sum of all the multiples of 3 or 5 below 1000.

public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int limit = 1000;
        int sum = 0;
        for (int i = 0; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.printf("The sum of numbers under %d evenly divisible by 3 or 5 is: %d%n", limit, sum);
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);
        System.out.printf("Time elapsed: %dns%n",totalTime);
    }
}
