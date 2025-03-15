//09 March 2025
//Textmenu to displaying the information


import java.util.Scanner;
import java.io.IOException;


public class TextMenu{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        KnowledgeBase knowledgeBase = new KnowledgeBase(100);
        boolean isLoaded = false;//track the success

        while(true){
        System.out.println("Choose an action from the menu:");
        System.out.println("1.Load a knowledge base from a file");
        System.out.println("2.Add a new statement to the knowledge base");
        System.out.println("3.Search for a statement in the knowledge base by term");
        System.out.println("4.Search for a statement in the knowledge base by term and sentence");
        System.out.println("5.quit");
        

         System.out.print("\n" +"Enter your choice: ");
        
         

         String choice = scanner.nextLine();

         switch(choice){
            case "1":
                System.out.print("\n"+"Enter file name: ");
                String fileName = scanner.nextLine();
                try{
                
                boolean loaded = knowledgeBase.fileLoad(fileName);//load into the KnowledgeBase
                if (loaded) {
                isLoaded = true; // setting the loaded flag to true
                System.out.println("\n" +"Knowledge base loaded successfully." + "\n");
                }
                else{
                     System.out.println("Failed to load knowledge base." + "\n");
                }
                
                }
                
                catch(IOException e){
                System.out.println("An error occured while loading the file" + "\n");
                }
               
                
                
                break;

            case "2":
                System.out.println("\n"+ "Enter the term:");
                String term = scanner.nextLine();

                System.out.println("Enter the statement:");
                String sentence = scanner.nextLine();

                System.out.println("Enter the confidence score:");
                double score = Double.parseDouble(scanner.nextLine());
                knowledgeBase.UpdateStatement(term, sentence, score);
                System.out.println("Statement for term " + term + " has been updated." + "\n"); 
                break;

            case "3":
                 System.out.print("\n"+"Enter the term to search: ");
                 String searchTerm = scanner.nextLine().trim();
                 Statement foundStatement = knowledgeBase.searchStatement(searchTerm);
                 if (foundStatement != null) {
                 System.out.println("Statement found: " + foundStatement.sentence + " (Confidence score: " + foundStatement.score +")" + "\n");
                 }
                 else{
                 System.out.println("Statement not found.");
                 }
                 break;

            case "4":
                System.out.println("Enter the term:");
                String term1 = scanner.nextLine().trim();
                System.out.println("Enter the statement to search for:");
                String sentence1 = scanner.nextLine();

                Statement statementSearch = knowledgeBase.searchStatement(term1);
                if ( statementSearch != null &&  statementSearch.getSentence().equalsIgnoreCase(sentence1)) {
                System.out.println("The statement was found: " + statementSearch .getSentence() + " and has a confidence score of : " +statementSearch .getScore() + ")"+"\n");
                } else {
                System.out.println("Statement not found.");
                }
                break;

                 

                 case "5":
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

