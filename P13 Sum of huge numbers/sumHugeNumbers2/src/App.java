import java.util.Scanner;
import java.io.File;
import java.math.BigInteger;

public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        BigInteger sum = BigInteger.ZERO;
        String path = "C:\\Users\\pc\\Documents\\Java\\Euler\\P13 Sum of huge numbers\\sumHugeNumbers2\\src\\numbers.txt";
        try{
            Scanner scan = new Scanner(new File(path));
            
            while (scan.hasNextLine()) {
                sum = sum.add(new BigInteger(scan.nextLine()));
            }
            scan.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        long endTime = System.nanoTime();

        System.out.println("The first 10 digits are: " + sum.toString().substring(0, 10));
        System.out.printf("Time taken: %,d%n", endTime-startTime);
    }
}
