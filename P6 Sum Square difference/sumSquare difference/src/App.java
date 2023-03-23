// The sum of the squares of the first ten natural numbers is,
// 1^2 + 2^2+... 10^2 = 385
// The square of the sum of the first ten natural numbers is,
// (1+2+...10)^2 = 55^2 = 3025
// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is .
// 3025-385 = 2640
// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum. = 25164150

public class App {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        int limit = 100;
        double sums = 0;
        double squares = 0;
        for (int i = 1; i < limit+1; i++) {
            sums += i;
            squares += Math.pow(i,2);
        }
        sums = Math.pow(sums,2);
        double difference = sums-squares;
        long endTime = System.nanoTime();
        System.out.printf("The difference between the sum of the squares and the square of the sum for the first %d numbers is: %.0f%n", limit, difference);
        System.out.printf("Time taken: %dns%n", endTime-startTime);
        
        }
}
