// Number spiral diagonals Problem 28
// Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

// 21 22 23 24 25
// 20  7  8  9 10
// 19  6  1  2 11
// 18  5  4  3 12
// 17 16 15 14 13

// It can be verified that the sum of the numbers on the diagonals is 101.

// What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way? - 669,171,001

public class P28 {
    public static void main(String[] args)  {
        long startTime = System.nanoTime();

        int num = 1001;
        int limit = num*num;
        
        int sum = compute(limit);

        long endTime = System.nanoTime();

        System.out.printf("Sum is: %,d%n", sum);
        System.out.printf("Time Taken: %,dns%n", endTime-startTime);
    }

    public static int compute(int limit){
        int num = 1;
        int iterator = 2;
        int sum = 1;

        while ((num + iterator) < limit) {
            for (int j = 0; j < 4; j++) {
                num += iterator;
                sum += num;
                // System.out.println(num);
            }
            iterator += 2;

        }
        return sum;
    }
}
