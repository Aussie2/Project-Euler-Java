import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

// For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

// What is the total of all the name scores in the file?

public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        List<String> names = new ArrayList<String>();
        HashMap<Character, Integer> letters = new HashMap<>();
        
        BufferedReader bf = new BufferedReader(new FileReader("p022_names.txt")); // read the file
        
        letters = loadLetters(letters);                                                     // load letters into hashmap

        String name = bf.readLine();                                                        // read buffer into a string, it is one line
        bf.close();                                                                         // close the buffer

        names = loadNamesToList(name, names);                                               // load names from the file into the list names

        Collections.sort(names);                                                            // order the list

        int totalSum = sumRankedNameScores(names, letters);                                 // Sum the ranked name scores
                
        long endTime = System.nanoTime();
        System.out.printf("The sum of ranked name scores is: %,d%n",totalSum);
        System.out.printf("Time taken: %,d%n", endTime-startTime);
    }

    public static int getNameScore(String name, HashMap<Character, Integer> letters){
        int score = 0;
        for (int i = 0; i < name.length(); i++) {
            char ch = (char)name.charAt(i);
            score += letters.get(ch);
        }
        return(score);
    }

    public static HashMap<Character, Integer> loadLetters(HashMap<Character, Integer> letters){
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < letter.length(); i++) { // add letters to the hashmap letters
            char ch = letter.charAt(i);
            letters.put(ch, i+1);
        }
        return(letters);
    }

    public static List<String> loadNamesToList(String name,List<String> names){
        for (String nme : name.split(",")) {
            names.add(nme.replace("\"",""));
        }
        return(names);
    }

    public static int sumRankedNameScores(List<String> names, HashMap<Character, Integer> letters){
        int totalSum = 0;
        for (int i = 0; i < names.size(); i++) {
            String nme = names.get(i);
            totalSum += (i+1)*getNameScore(nme, letters);
        }
        return(totalSum);
    }
    
}
