// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
// Find the largest palindrome made from the product of two 3-digit numbers.

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int is = 0;
        int js = 0;
        int largest = 0;
        int limit = 999;
        int result = 0;
        for (int i = 0; i < limit+1; i++) {
            for (int j = 0; j < limit+1; j++) {
                result = i*j;
                
                if (isPalindrome(result) && result > largest) {
                    largest = result;
                    is = i;
                    js = j;
                }
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime-startTime;
        System.out.printf("%d x %d = %d which is a palindrome %n", is,js,largest);
        System.out.printf("Time elapsed: %,dns%n",duration);
    }

    public static boolean isPalindrome(int num){
        boolean palindromic = true;
        int revNum = 0;
        int origNum = num;
        int remainder = 0;
        while (num != 0){
            remainder = num % 10;
            revNum = revNum*10 + remainder;
            num /= 10;
        }
        if (origNum != revNum) {
            palindromic = false;
        }
        return(palindromic);
    }
}
