import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

// Pandigital products Problem 32
// We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

// The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

// Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

// HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum. - 45,228

public class P32 {
    public static void main(String[] args) {
        
        List<Integer> answerList = new ArrayList<>();

        for (int i = 1; i < 50; i++) {
            for (int j = i; j < 2000; j++) {
                int result = i*j;
                if (isPandigital(i, j, result)){
                    answerList.add(result);
                    System.out.printf("%,d x %,d = %,d length: %d%n",i,j,result, gatherings(i,j,result).size());
                    // System.out.println(gatherings(i,j,result).stream().sorted().collect(Collectors.toList()));
                }
            }
        }
        List<Integer> newList = new ArrayList<>();
        for (Integer value : answerList) {
            if (!newList.contains(value)) {
                newList.add(value);
            }
        }
        
        System.out.printf("Total sum: %,d%n",newList.stream().mapToInt(Integer::intValue).sum());
    }

    public static List<Integer> gatherings(int a, int b, int c){
        List<Integer> digitList = new ArrayList<>();
        digitList = gatherDigits(digitList, a);
        digitList = gatherDigits(digitList, b);
        digitList = gatherDigits(digitList, c);
        return digitList;
    }

    public static boolean isPandigital(int a, int b, int c){
        List<Integer> digitList = gatherings(a, b, c);
        if (digitList.size() != 9) {
            return false;
        }
        if (sumDigits(digitList)) {
            return(true);
        }
        return false;
    }

    public static List<Integer> gatherDigits(List<Integer> digitList, int num){
        while (num > 0) {    
            int val = num % 10;                                               // load the digits into the list 
            if (!digitList.contains(val)) {
                digitList.add(val);
            }
            else{
                digitList.add(0);
            }
            num /= 10;
        }
        return(digitList);                                                  // return result
    }

    public static boolean sumDigits(List<Integer> digitList){
        int listSize = digitList.size();  
        if (digitList.contains(0)) {
            return false;
        }                                  // get size of list - works
        if (listSize != 9) {
            return false;
        }
        else{
            int sum = digitList.stream().mapToInt(Integer::intValue).sum();     // sum the digits
            int theorySum = (listSize*(listSize+1))/2;                          // get theoretical sum 
            return(sum == theorySum);  
        }                                         // return a result
    }

}

