// Problem 24 Lexicographic permutations
// A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

// 012   021   102   120   201   210

// What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?


public class App {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int limit = 1_000_000;

        int[] elements = new int[]{0,1,2,3,4,5,6,7,8,9};
        int[] d        = new int[]{0,0,0,0,0,0,0,0,0,0};
        d = cycles(elements, limit, d);

        long endTime = System.nanoTime();
        
        System.out.printf("The %,dth permutation is: %d,%d%d%d,%d%d%d,%d%d%d %n", limit, d[0], d[1], d[2], d[3], d[4], d[5], d[6], d[7], d[8], d[9]);
        System.out.printf("Time taken: %,d%n",endTime-startTime);
    }

    
    public static boolean forChecks(int[] f){
        if (f[0] != f[1] && f[0] != f[2] && f[0] != f[3] && f[0] != f[4] && f[0] != f[5] && f[0] != f[6] && f[0] != f[7] && f[0] != f[8] && f[0] != f[9] &&
            f[1] != f[2] && f[1] != f[3] && f[1] != f[4] && f[1] != f[5] && f[1] != f[6] && f[1] != f[7] && f[1] != f[8] && f[1] != f[9] &&
            f[2] != f[3] && f[2] != f[4] && f[2] != f[5] && f[2] != f[6] && f[2] != f[7] && f[2] != f[8] && f[2] != f[9] &&
            f[3] != f[4] && f[3] != f[5] && f[3] != f[6] && f[3] != f[7] && f[3] != f[8] && f[3] != f[9] &&
            f[4] != f[5] && f[4] != f[6] && f[4] != f[7] && f[4] != f[8] && f[4] != f[9] &&
            f[5] != f[6] && f[5] != f[7] && f[5] != f[8] && f[5] != f[9] &&
            f[6] != f[7] && f[6] != f[8] && f[6] != f[9] &&
            f[7] != f[8] && f[7] != f[9] &&
            f[8] != f[9]) {
                return(true);
            }
            else{
                return(false);
            }

    }

    public static int[] cycles(int[] elements, int limit, int[] dig){
        int counter = 0;
        for (int i : elements) {// 0
            for (int j : elements) { //1
                for (int k : elements) { // 2
                    for (int l : elements) { // 3
                        for (int m : elements) { // 4
                            for (int n : elements) { // 5
                                for (int o : elements) { // 6
                                    for (int p : elements) { // 7
                                        for (int q : elements) { // 8
                                            int r = 45-(i+j+k+l+m+n+o+p+q); // 9 less complex this way
                                            int[] forFields = new int[]{i,j,k,l,m,n,o,p,q,r};
                                            
                                            if (forChecks(forFields)) {
                                                counter ++;
                                                
                                                dig[0] = i;
                                                dig[1] = j;
                                                dig[2] = k;
                                                dig[3] = l;
                                                dig[4] = m;
                                                dig[5] = n;
                                                dig[6] = o;
                                                dig[7] = p;
                                                dig[8] = q;
                                                dig[9] = r;
                                            }
                                            if (counter == limit){
                                                return(dig);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
        }
        return(dig);
    }
}
