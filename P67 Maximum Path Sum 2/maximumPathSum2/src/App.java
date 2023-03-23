import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Hacked based on
// https://www.geeksforgeeks.org/read-file-into-an-array-in-java/

// The sum of the minimum path is: 6,580
// Time taken: 10,201,700ns

public class App {
    public static void main(String[] args) throws IOException{
        long startTime = System.nanoTime();
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();
       
        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("numbers.txt"));
       
        // read entire line as string
        String line = bf.readLine();
       
        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }
       
        // closing bufferreader object
        bf.close();
       
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
       
        // printing each line of file
        // which is stored in array
        int index = 0;
        int sum = 0;
        for (String str : array) {
            String[] strArray = str.split(" ");
            if (strArray.length > 1) {
                if (Integer.parseInt(strArray[index]) < Integer.parseInt(strArray[index+1])) {
                   index++;
                }
            } 
            sum += Integer.parseInt(strArray[index]);
            
        }

        long endTime = System.nanoTime();

        System.out.printf("The sum of the minimum path is: %,d%n",sum);
        System.out.printf("Time taken: %,dns%n", endTime-startTime);
        
    }
}
