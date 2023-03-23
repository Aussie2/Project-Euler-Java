// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
// Find the sum of all the primes below two million.
// https://www.kjevo.com/464/project-euler-problem-10-java/ 

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // long limit = 2_000_000;
        // long sum = 2;
        // for (int i = 3; i < limit; i+=2) {
        //     if (isPrime(i)) {
        //         // System.out.println(i);
        //         sum += i;
        //     }
        // }

        int max = 2_000_000;
        boolean[] markings = new boolean[max];
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (!markings[i]) {
                for (int j = 2*i; j < max; j += i) {
                    markings[j] = true;
                }
            }
        }

        long sum = 2;
        for (int i = 3; i < max; i += 2) {
            if (!markings[i]) {
                sum += i;
            }
        }
        long endTime = System.nanoTime();
        System.out.println(sum);


        
        // System.out.printf("The sum of primes below %,d is: %,d%n", limit, sum);
        System.out.printf("Time taken: %,dns%n", endTime-startTime);
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
