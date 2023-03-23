// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
// a^2 + b^2 = c^2
// For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.
// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int limit = 1000;
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 1; i < limit; i++) {
            for (int j = i+1; j < limit; j++) {
                int k = 1000-i-j;
                if (Math.pow(i,2) + Math.pow(j,2) == Math.pow(k,2)) {
                    a = i;
                    b = j;
                    c = k;
                    break;
                }
            }
        }
       
        long endTime = System.nanoTime();
        System.out.printf("%d x %d x %d = %,d%n", a,b,c,a*b*c);
        System.out.printf("Time taken: %,dns%n",endTime-startTime);
    }
}
