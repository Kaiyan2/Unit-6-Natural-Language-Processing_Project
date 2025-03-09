import java.util.ArrayList;
import java.util.Scanner;

public class MyNLP {

  private ArrayList<String> words20k;
  private ArrayList<String> FrequentWords;
  private ArrayList<Integer> count;


  // Constructor
  public MyNLP() {
    words20k = FileReader.toStringList("Words20k.txt");
  }

  public ArrayList<String> userStringToList(String userInput) {
    ArrayList<String> wordList = new ArrayList<String>();
    
    // Call removePunctuation method to clean the input
    String cleanedInput = removePunctuation(userInput);
    
    // Convert to lowercase and split the cleaned string into words
    String[] userArray = cleanedInput.split(" ");
    
    for (String word : userArray) {
      wordList.add(word); // Add each word to the list
    }
    
    return wordList;
  }

  // Method to remove punctuation from a string (using Code.org methods)
  public String removePunctuation(String inputString) {
    String cleanedString = ""; // Initialize an empty string to store the cleaned result

    // Loop through each character in the input string
    for (int i = 0; i < inputString.length(); i++) {
      char currentChar = inputString.charAt(i); // Get the character at position i
      
      // Check if the character is a letter, number, or space
      if ((currentChar >= 'a' && currentChar <= 'z') || 
          (currentChar >= 'A' && currentChar <= 'Z') || 
          (currentChar >= '0' && currentChar <= '9') || 
          currentChar == ' ') {
        cleanedString += Character.toLowerCase(currentChar); // Add the character to the cleaned string (in lowercase)
      }
    }

    return cleanedString; // Return the cleaned string
  }

  public void countFrequentWords(ArrayList<String> wordList) {
    FrequentWords = new ArrayList<String>();
    count = new ArrayList<Integer>();

    for (int start = 0; start < wordList.size(); start++) {
      String currentWord = wordList.get(start);
      boolean found = false;
      for (int i = 0; i < FrequentWords.size(); i++) {
        if (FrequentWords.get(i).equals(currentWord)) {
          count.set(i, count.get(i) + 1);
          found = true;
        }
      }
      if (!found) {
        FrequentWords.add(currentWord);
        count.add(1);
      }
      
    }
  }


  /**
   * Starts the app and gets user input
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);

    System.out.println("Type your text here:");
    String userInput = input.nextLine();
    System.out.println(" ");
    
    System.out.println("These are the most frequent words used:");
    ArrayList<String> words = userStringToList(userInput);
    countFrequentWords(words);

    // Print only words that appear more than once
    for (int i = 0; i < FrequentWords.size(); i++) {
        if (count.get(i) > 1) {
            System.out.println(FrequentWords.get(i)); // Print only the word
        }
    }
    System.out.println(" ");    
    
    // Print word counts in the format "word: count"
    System.out.println("This is how common your words occur in your text:");
    for (int i = 0; i < FrequentWords.size(); i++) {
        if (count.get(i) > 1) {
        System.out.println(FrequentWords.get(i) + ": " + count.get(i));
    }
    }
    System.out.println(" ");
    
    input.close();
  }
}