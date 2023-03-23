import java.util.ArrayList;
import java.util.List;

// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
// What is the 10 001st prime number? = 104,743

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int target = 10_001;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        
        int i = 5;
        while (primes.size() < target) {
            if (isPrime(i)) { primes.add(i); }

            // boolean check = true;
            // for (Integer integer : primes) {
            //     if (i % integer == 0) { check = false; }
            // }
            // if (check) { primes.add(i); }

            i+=2;
                        
        }

           
        

        long endTime = System.nanoTime();
        System.out.printf("Prime number %,d is: %,d%n",target, primes.get(primes.size()-1));
        System.out.printf("Time taken: %,dns%n",endTime-startTime);
    }

    public static boolean isPrime(int toFactor){
        int count = 0;
        boolean primacy = true;
        int i = 1;
        while (i < toFactor) {
            if (toFactor % i == 0) {
                count++;
                if (count > 1) {
                    primacy = false;
                    break;
                }
            }
            i+=2;
        }
        return primacy;
    }

    
}
