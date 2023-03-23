import java.util.HashMap;

// If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

// If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used? - 13,301

// NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        HashMap nums = new HashMap<Integer, Integer>();
        nums.put(0,0);
        nums.put(1,3);
        nums.put(2,3);
        nums.put(3,5);
        nums.put(4,4);
        nums.put(5,4);
        nums.put(6,3);
        nums.put(7,5);
        nums.put(8,5);
        nums.put(9,4);
        nums.put(10,3);
        nums.put(11,6);
        nums.put(12,6);
        nums.put(13,8);
        nums.put(14,8);
        nums.put(15,8);
        nums.put(16,7);
        nums.put(17,9);
        nums.put(18,8);
        nums.put(19,8);

        nums.put(20,6);
        nums.put(30,6);
        nums.put(40,6);
        nums.put(50,6);
        nums.put(60,5);
        nums.put(70,7);
        nums.put(80,6);
        nums.put(90,6);

        nums.put(100,7);
        nums.put(1000,8); 

        int target = 1000;
        int sum = 0;
        for (int i = 1; i < target; i++) {
            if (i == 1000) {
                sum += (int)nums.get(i);
            }
            else{
                if (i > 99) {
                    int hundreds = i / 100;
                    sum += (int)nums.get(hundreds) + (int)nums.get(100);
                    int remainder100 = i % 100;
                    if(remainder100 > 0){
                        sum += 3; // and
                    }
                    else {
                        sum = below20(remainder100, nums, sum);
                    } 
                }
                else {
                    sum = below20(i, nums, sum);
                }
            }
        }

        long endTime = System.nanoTime();

        System.out.printf("The sum total is: %,d%n",sum);
    System.out.printf("Time taken: %,d%n",endTime-startTime);
    }

    public static int below20(int i, HashMap nums, int sum){
        if (i > 20) {
            int remainder10 = i % 10;
            int tens = i / 10;
            sum += (int)nums.get(remainder10) + (int)nums.get(tens);
        } else {
            sum += (int)nums.get(i);
        }
        return(sum);
    }
}
