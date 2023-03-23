import java.util.ArrayList;
import java.util.List;

// Digit fifth powers Problem 30
// Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

// 1634 = 1^4 + 6^4 + 3^4 + 4^4
// 8208 = 8^4 + 2^4 + 0^4 + 8^4
// 9474 = 9^4 + 4^4 + 7^4 + 4^4
// As 1 = 14 is not a sum it is not included.

// The sum of these numbers is 1634 + 8208 + 9474 = 19316.

// Find the sum of all the numbers that can be written as the sum of fifth powers of their digits. 
// Answer - 443,839
// Range - 2000 to 354_294

// https://www.xarg.org/puzzle/project-euler/problem-30/
// https://www.programminglogic.com/solution-to-problem-30-on-project-euler/

public class P30 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int total = 0;

        for (int i = 2000; i < 354_294; i++) {
            if (isDdigitPower(i, 5)) {
                total += i;
            }
        }


        long endTime = System.nanoTime();
        System.out.printf("The total is: %,d%n",total);
        System.out.printf("Time taken: %,dns%n", endTime-startTime);
    }

    public static boolean isDdigitPower(int num, int power){
        
        List<Integer> collect = new ArrayList<>();
        int keep = num;
        while (num > 0) {
            collect.add(num % 10);
            num /= 10;
        }

        int sum = 0;
        for (Integer i : collect) {
            sum += Power(i,power);
        }

        return(keep == sum);
    }

    public static int Power(int n, int pow){
        int sum = n;
        for (int i = 0; i < pow-1; i++){
            sum *= n;
        }
        return(sum);
    }
}

