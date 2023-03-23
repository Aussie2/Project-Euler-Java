// The prime factors of 13195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143 ? = 6857

public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        long toFactor = 600851475143L;
        long reference = toFactor;
        int i = 2;
        while (i <= toFactor) {
            if ((toFactor % i == 0) && isprime(i)){
                    toFactor = toFactor/i;
            }
            i++;
        }

        long endTime = System.nanoTime();
        System.out.printf("The largest prine factor of %,d is: %,d%n", reference, i-1);
        long duration = endTime-startTime;
        System.out.printf("Time elapsed: %,dns%n", duration);
    }
    public static boolean isprime(int toFactor){
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
