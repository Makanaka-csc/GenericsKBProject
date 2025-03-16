//09 March 2025
//Textmenu to displaying the information

/**
 * The TextMenu class provides a text-based interface for interacting with a knowledge base.
 * It allows users to load a knowledge base from a file, add new statements, and search
 * for statements by term or term and sentence.
 */


import java.util.Scanner;
import java.io.IOException;

public class TextMenu {


       public static void main(String[] args) {
        // Create scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        KnowledgeBase knowledgeBase = new KnowledgeBase(100);
        
        // Flag to track if the knowledge base is successfully loaded
        boolean isLoaded = false;

        // Infinite loop to display the menu and wait for user input
        while (true) {
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Load a knowledge base from a file");
            System.out.println("2. Add a new statement to the knowledge base");
            System.out.println("3. Search for a statement in the knowledge base by term");
            System.out.println("4. Search for a statement in the knowledge base by term and sentence");
            System.out.println("5. Quit");

            System.out.print("\n" + "Enter your choice: ");
           
            String choice = scanner.nextLine();

          
            switch (choice) {
                case "1":
                    // Load the knowledge base from a file
                    System.out.print("\n" + "Enter file name: ");
                    String fileName = scanner.nextLine();
                    try {
                        // Load file into the knowledge base
                        boolean loaded = knowledgeBase.fileLoad(fileName);
                        
                        // Check if the file was loaded successfully
                        if (loaded) {
                            isLoaded = true; // Set the loaded flag to true
                            System.out.println("\n" + "Knowledge base loaded successfully." + "\n");
                        } else {
                            System.out.println("Failed to load knowledge base." + "\n");
                        }
                    } catch (IOException e) {
                        // Handle any file loading errors
                        System.out.println("An error occurred while loading the file" + "\n");
                    }
                    break;

                case "2":
                    // Add a new statement to the knowledge base
                    System.out.println("\n" + "Enter the term:");
                    String term = scanner.nextLine();

                    System.out.println("Enter the statement:");
                    String sentence = scanner.nextLine();

                    System.out.println("Enter the confidence score:");
                    double score = Double.parseDouble(scanner.nextLine());

                    // Update the statement or add a new one
                    knowledgeBase.UpdateStatement(term, sentence, score);
                    System.out.println("Statement for term " + term + " has been updated." + "\n");
                    break;

                case "3":
                   
                    System.out.print("\n" + "Enter the term to search: ");
                    String searchTerm = scanner.nextLine().trim();

                 
                    Statement foundStatement = knowledgeBase.searchStatement(searchTerm);
                    if (foundStatement != null) {
                      
                        System.out.println("Statement found: " + foundStatement.sentence + " (Confidence score: " + foundStatement.score + ")" + "\n");
                    } else 
                        System.out.println("Statement not found.");
                    }
                    break;

                case "4":
                    // Search for a statement by both term and sentence
                    System.out.println("Enter the term:");
                    String term1 = scanner.nextLine().trim();
                    System.out.println("Enter the statement to search for:");
                    String sentence1 = scanner.nextLine();

                    // Search for the statement by term
                    Statement statementSearch = knowledgeBase.searchStatement(term1);
                    if (statementSearch != null && statementSearch.getSentence().equalsIgnoreCase(sentence1)) {
                        // Print the statement if both term and sentence match
                        System.out.println("The statement was found: " + statementSearch.getSentence() + " and has a confidence score of: " + statementSearch.getScore() + ")" + "\n");
                    } else {
                        // Print if the statement is not found
                        System.out.println("Statement not found.");
                    }
                    break;

                case "5":
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();  
                    System.exit(0);   
                    break;

                default:
               
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
≈
