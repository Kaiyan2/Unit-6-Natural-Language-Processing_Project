import java.util.ArrayList;

public class NLPRunner {

  /**
   * The main method to run the NLP application.
   * It creates an instance of the MyNLP class and calls the prompt method to interact with the user.
   * 
   * @param args Command-line arguments (not used in this program).
   */
  public static void main(String[] args) {

    // Instantiate a MyNLP object to access methods for processing user input and text analysis
    MyNLP nlp = new MyNLP();

    // Call the prompt method to ask the user for input and display results
    nlp.prompt();
  }
}