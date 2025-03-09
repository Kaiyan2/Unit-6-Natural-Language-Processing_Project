import java.util.ArrayList;
import java.util.Scanner;

public class MyNLP {

  private ArrayList<String> words20k;
  private ArrayList<String> FrequentWords;
  private ArrayList<Integer> count;

  /**
   * Constructor for the MyNLP class. 
   * Initializes the words20k list by reading the "Words20k.txt" file.
   */
  public MyNLP() {
    words20k = FileReader.toStringList("Words20k.txt");
  }

  /**
   * Converts user input into a list of words.
   * 
   * @param userInput The input string from the user.
   * @return An ArrayList containing individual words from the input string.
   */
  public ArrayList<String> userStringToList(String userInput) {
    ArrayList<String> wordList = new ArrayList<String>();

    // Call removePunctuation method to clean the input
    String cleanedInput = removePunctuation(userInput);
    
    // Convert to lowercase and split the cleaned string into words
    String[] userArray = cleanedInput.split(" ");
    
    // Add each word from the array to the list
    for (String word : userArray) {
      // Add each word to the list
      wordList.add(word); 
    }
    
    return wordList; // Return the list of words
  }

  /**
   * Removes punctuation from a given string. 
   * Only letters, numbers, and spaces are retained, and characters are converted to lowercase.
   * 
   * @param inputString The input string from which punctuation will be removed.
   * @return A cleaned string with no punctuation, where all letters are in lowercase.
   */
  public String removePunctuation(String inputString) {
    // Initialize an empty string to store the cleaned result
    String cleanedString = ""; 

    // Traverse through every character in the given string
    for (int i = 0; i < inputString.length(); i++) {
      // Get the character at position i
      char currentChar = inputString.charAt(i); 
      
      // Checks if the string is a letter, number, or space
      if ((currentChar >= 'a' && currentChar <= 'z') || 
          (currentChar >= 'A' && currentChar <= 'Z') || 
          (currentChar >= '0' && currentChar <= '9') || 
          currentChar == ' ') {
        cleanedString += Character.toLowerCase(currentChar); // Add the character to the cleaned string (in lowercase)
      }
    }

    return cleanedString; // Return the cleaned string without punctuation
  }

  /**
   * Counts the frequency of each word in the provided word list.
   * 
   * @param wordList The list of words to count frequencies for.
   */
  public void countFrequentWords(ArrayList<String> wordList) {
    FrequentWords = new ArrayList<String>();
    count = new ArrayList<Integer>();

    // Loop through each word in the word list
    for (int start = 0; start < wordList.size(); start++) {
      String currentWord = wordList.get(start);
      boolean found = false;
      
      // Check if the word is already in the FrequentWords list
      for (int i = 0; i < FrequentWords.size(); i++) {
        if (FrequentWords.get(i).equals(currentWord)) {
          // Increment the count for the word
          count.set(i, count.get(i) + 1);
          found = true;
        }
      }
      
      // If the word was not found, add it to the FrequentWords list with a count of 1
      if (!found) {
        FrequentWords.add(currentWord);
        count.add(1);
      }
    }
  }

  /**
   * Prompts the user to input text, processes it, and displays frequent words.
   * Displays a list of words that occur more than once in the user input and their counts.
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter text
    System.out.println("Type your text here:");
    String userInput = input.nextLine();
    System.out.println(" ");
    
    // Process the user input and count frequent words
    System.out.println("These are the most frequent words used:");
    ArrayList<String> words = userStringToList(userInput);
    countFrequentWords(words);

    // Print only words that appear more than once
    for (int i = 0; i < FrequentWords.size(); i++) {
        if (count.get(i) > 1) {
          // Print only the word
            System.out.println(FrequentWords.get(i));
        }
    }
    System.out.println(" ");    
    
    // Print word counts in the format "word: count"
    System.out.println("This is how common your words occur in your text:");
    for (int i = 0; i < FrequentWords.size(); i++) {
        if (count.get(i) > 1) {
          // Display word and its count
        System.out.println(FrequentWords.get(i) + ": " + count.get(i)); 
    }
    }
    System.out.println(" ");

    // Close the scanner to free resources
    input.close(); 
  }
}