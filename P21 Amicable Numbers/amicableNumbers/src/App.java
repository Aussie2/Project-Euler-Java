import java.util.HashMap;
import java.util.Objects;

// Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
// If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

// For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

// Evaluate the sum of all the amicable numbers under 10000. 

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        
        int limit = 10_000;
        // HashMap<Integer, Integer> list = new HashMap<>();

        // for (int i = 1; i < limit+1; i++) {
        //     int result = dn(i);
        //     if (result > 1) {
        //         list.put(i,dn(i));
        //         // System.out.println(i + " : " + dn(i));
        //     }
            
        // }
        // System.out.println();
        // list.forEach((key, value) -> {
        //     list.forEach((key1, value1) -> {
        //         if ( !Objects.equals(key, key1) && (key1+1) == value && (key+1) == value1) {
        //                 System.out.println(key+1 + " : " + value + " -> " + (key1+1) + " : " + value1);
        //         }
        //     });
        // });
        int sum = 0;
        for (int i = 1; i < limit + 1; i++) {
            int test = dn(i);
            if (i == dn(test)){
                // System.out.printf("i = %d dn(i) = %,d%n",i,test);
                sum += i;
            }
        }

        long endTime = System.nanoTime();
        System.out.printf("sum is: %,d%n",sum);
        System.out.printf("Time taken: %,dns%n",endTime-startTime);
    }

    public static int dn(int n){
        int sum = 0;
        n = n+1/2;
        for (int i = 1; i < n; i++) {
            if (n % i ==0 && n != i) {
                sum += i;
            }
        }
        return(sum);
    }
}
