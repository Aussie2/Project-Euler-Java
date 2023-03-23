import java.util.ArrayList;
import java.util.List;

// Digit cancelling fractions Problem 33
// The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

// We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

// There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

// If the product of these four fractions is given in its lowest common terms, find the value of the denominator. - 100

// ranges 10-99
// 30/50 = 3/5
// 49/98 = 4/8

public class P33 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int finalNum = 1;
        int finalDen = 1;

        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                List<Integer> numer = splitter(i);
                List<Integer> denom = splitter(j);

                if (!numer.contains(0) || !denom.contains(0)) {                         // Remove trivial examples          
                    List<Integer> ab = parseFraction(numer, denom);
                    int a = ab.get(0);
                    int b = ab.get(1);

                    double large = (double)i/(double)j;
                    double small = (double)a/(double)b;
                    if (large == small && large < 1) {
                        // System.out.printf("%d/%d %d/%d %1.2f %n", i,j, a,b, large);
                        finalNum *= i;
                        finalDen *= j;
                    }
                }
            }
        }

        int lcf = getDivisor(finalNum, finalDen);
        long endTime = System.nanoTime();
        System.out.printf("The final; fraction is: %,d/%,d%n", finalNum/lcf, finalDen/lcf);
        
        System.out.printf("LCF: %,d%n", lcf);
        System.out.printf("denominator is: %,d%n", finalDen/lcf);
        System.out.printf("Time taken: %,dns%n", endTime-startTime);
        
    }

    public static List<Integer> splitter(int num){
        List<Integer> split = new ArrayList<>();
        while (num > 0){
            int val = num % 10;
            split.add(val);
            num /= 10;
        }
        return(split);
    }

    public static List<Integer> parseFraction(List<Integer> numer, List<Integer> denom){
        List<Integer> output = new ArrayList<>();
        int a = 0;
        int b = 0;
        if (numer.get(0).equals(denom.get(0))) {
            a = numer.get(1);
            b = denom.get(1);
        } 
        else if (numer.get(0).equals(denom.get(1))) {
            a = numer.get(1);
            b = denom.get(0);
        }
        else if (numer.get(1).equals(denom.get(0))) {
            a = numer.get(0);
            b = denom.get(1);
        }
        else if (numer.get(1).equals(denom.get(1))) {
            a = numer.get(0);
            b = denom.get(0);
        }
        output.add(a);
        output.add(b);
        return(output);
    }

    public static int getDivisor(int num, int den){
        int lowest = Math.min(num, den);
        int returnVal = 0;
        for (int i = 1; i < (lowest+1); i++) {
            if (num % i == 0 && den % i == 0) {
                returnVal = i;
            }
        }
        return(returnVal);
    }
}


