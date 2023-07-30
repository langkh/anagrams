import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Random;

public class Anagram {
    static ArrayList<String> words = new ArrayList<>();
    static String alphabet = "aaabcdeeefffggghijkklmnoooppprsssttttuuuvwy";//42


    public static void main(String[] args) throws FileNotFoundException {


        File file = new File("C:\\Users\\schoo\\IdeaProjects\\anagramsv2_because_i_lost_the_python_version_\\src\\words.txt");
        Scanner scanner = new Scanner(file);//for file
        Scanner sc = new Scanner(System.in);//input
        while (scanner.hasNext()) {
            String word = scanner.next();
            word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            words.add(word);
        }
        String sixLetters = randLetters();
        ArrayList<String> possibleWords = new ArrayList<>();
        for (String word : words) {
            if (usesLetters(word, sixLetters)) {
                possibleWords.add(word);
            }
        }

        System.out.println("Welcome to Anagrams! Type in a word using the following letters:");
        System.out.println(sixLetters);
        ArrayList<String> inputtedWords = new ArrayList<>();
        Boolean keepGoing = true;
        while (keepGoing == true) {
            String userInput = sc.nextLine();
            int score = 0;
            if (!isWord(userInput)) {
                System.out.println("That's not a real word");
            } else if (userInput.equals("quit")) {
                System.out.println("Final score: " + score);
                System.out.println("Here were all the possible words:");
                for (String word : possibleWords) {
                    System.out.println(word);
                }
                System.out.println("Thanks for playing");
                keepGoing = false;
            } else if (!usesLetters(userInput, sixLetters)) {
                    System.out.println("You can only use the letters above!");
                }
            else if (inputtedWords.contains(userInput)){
                System.out.println("You already entered that word!");
                }
             else {
                score += userInput.length() * 100;
                System.out.println("score: " + score);
                inputtedWords.add(userInput);
            }
        }


    }
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
    public static String randLetters(){
        Random r = new Random();
        String sixletters = "";
        for (int x = 0; x<6;x++){
            int randint = r.nextInt(42);
            char letter = alphabet.charAt(randint);
            sixletters += " " +letter;
        }
        return sixletters;
    }
    public static Boolean isWord(String word){
        return words.contains(word);
    }
    public static Boolean usesLetters(String word, String sixLetters){
        if (word == null) {
            return false;
        }
        for (int x = 0; x <word.length(); x++) {
            String letter = String.valueOf(word.charAt(x));
            if (!sixLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}
