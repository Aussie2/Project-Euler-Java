// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20? = 232792560


public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        boolean exit = true;
        int limit = 10;
        int num = limit;
        boolean check = true;
        int[] divisors = new int[]{20,19,18,17,16,15,14,13,12,11};
        while (exit) {
            check = true;
            for (int i : divisors) {
                if (num % i != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                exit = false;
            }
            else{
                num += 10; 
            }            
        }
        
        
        long endTime = System.nanoTime();
        System.out.printf("Time taken: %,dns%n", endTime-startTime);
        System.out.printf("%d is the smallest number divisable by all the numbers between 1 and %d%n", num, limit);
    }
}
