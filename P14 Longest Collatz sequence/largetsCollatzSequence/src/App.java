// The following iterative sequence is defined for the set of positive integers:

// n → n/2 (n is even)
// n → 3n + 1 (n is odd)

// Using the rule above and starting with 13, we generate the following sequence:

// 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
// It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

// Which starting number, under one million, produces the longest chain?

// NOTE: Once the chain starts the terms are allowed to go above one million.

// The longest collatz sequence in numbers below 1000000 is: 476 coming from the number: 910107
// Time taken: 412,604,200ns

public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        
        int start = 1_000_000;
        int num = 0;
        int maxLen = 0;

        for (int i = 1; i < start+1; i++) {
            int col = collatz(i);
            if (col > maxLen) {
                maxLen = col;
                num = i;
            }
        }

        long endTime = System.nanoTime();

        System.out.printf("The longest collatz sequence in numbers below %d is: %d coming from the number: %d%n", start, maxLen, num);
        System.out.printf("Time taken: %,dns %n", endTime-startTime);
    }

    public static int collatz(int num){
        int count = 1;
        while (num > 1) {
            if (num %2 == 0) {
                num /= 2;
            } else {
                num = 3*num + 1;
            }
            count++;
        }
        return(count);
    }
}
