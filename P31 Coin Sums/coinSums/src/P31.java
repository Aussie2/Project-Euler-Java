// Coin sums Problem 31
// In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:

// 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
// It is possible to make £2 in the following way:

// 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
// How many different ways can £2 be made using any number of coins? - 73,680

public class P31 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        int count = 0;
        for (int i = 0; i < 3; i++) { // £1
            for (int j = 0; j < 5; j++) { // 50p
                for (int k = 0; k < 11; k++) { // 20p
                    for (int l = 0; l < 21; l++) { // 10p
                        for (int m = 0; m < 41; m++) { // 5p
                            for (int n = 0; n < 100; n++) { // 2p
                                for (int o = 0; o < 201; o++) { // pennies
                                    if (i*100 + j*50 + k*20 + l*10 + m*5 + n*2 + o*1 == 200) {
                                        count ++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long endTime = System.nanoTime();


        System.out.printf("The count is: %,d%n", count);
        System.out.printf("Time taken: %,dns%n", endTime-startTime);
    }
}
