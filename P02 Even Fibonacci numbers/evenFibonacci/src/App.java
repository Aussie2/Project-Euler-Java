// Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
// By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int limit = 4000000;
        int f1 = 1;
        int f2 = 2;
        int carry;
        int sum = f2;
        // System.out.println(f1);
        
        do {
            carry = f1 + f2;
            // System.out.println(f2);
            f1 = f2;
            f2 = carry;
            
            if (f2 % 2 == 0) {
                sum += f2;
            } 
        }while (f2 < limit);

        long endTime = System.nanoTime();
        long duration = endTime-startTime;
        System.out.printf("Sum of even Fibonacci below %d is: %d%n", limit, sum);
        System.out.printf("Time elapsed: %,d",duration);
    }
}
