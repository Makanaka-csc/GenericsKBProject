// An app that uses a traditional array to store elements and updates the statements associated with items in the initial knowledge base. 
//Makanaka Mangwanda
// 09 March 2025

import java.io.*;
import java.util.Arrays;


/**
* This KnowledgeBase class stores and manages a collection of statements.
* the class allows updating,and searching of statements
*/

public class KnowledgeBase{//consists of various terms and statements


    private Statement[] knowledgeBase;/**store the elements in an array */
    private int size;

   
   /** 
      * a knowledgeBase with a specified summary
    *
    * @param initialCapacity these are the maximum number of statements that it can hold 
    */
   
    public KnowledgeBase(int initialCapacity){/**how many statement objects the constructor can hold when it is created */
    knowledgeBase = new Statement[initialCapacity];
    size = 0;// no statements yet
    }



    public boolean fileLoad(String fileName)throws IOException{
    
    try(BufferedReader r = new BufferedReader(new FileReader(fileName))){
    String line;

    while ((line = r.readLine()) != null) {//continue executing as long as there are more lines
    String part[] = line.split("\t");//split the line on this delimeter

    //sentence consists of 3 parts
    if( part.length == 3){
        String term = part[0].trim();
        String sentence = part[1].trim();
        double score = Double.parseDouble(part[2].trim());
        UpdateStatement(term,sentence,score);//update
    }
        
    }
    return true;
    }
    
    catch(IOException e){
        return false;
      }
      
      }
      
      
      private void resize(){
      knowledgeBase =  Arrays.copyOf(knowledgeBase, size * 2);
      }

      
    
    /*method to update a statement
    */
    
    public void updateStatement(String term, String sentence, double score){
        //checking if the statement is already existing
         for (int i = 0; i < size; i++) {            
            if (knowledgeBase[i].getTerm().equals(term)) {

        // if the score is higher, then update
        if(score>knowledgeBase[i].getScore()){
            knowledgeBase[i].setStatement(sentence);
            knowledgeBase[i].setScore(score);  
        }

        return;
            }  

    }
       
    // If the statement is not found, add it to the array
    if (size >= knowledgeBase.length) {
        // Resize the array if necessary
        knowledgeBase = Arrays.copyOf(knowledgeBase, size * 2); 
    }
    knowledgeBase[size++] = new Statement(term, sentence, score);  // Add new statement
    }


    
        //searching for a statement by term 
        public Statement searchStatement(String searchTerm){
        for(int i = 0; i < size ;i++){
            if(knowledgeBase[i] != null && knowledgeBase[i].getTerm().trim().equalsIgnoreCase(searchTerm)){
                return knowledgeBase[i];
            }
            
        }
        return null;//null if the statement is not found
        }

        
        /**
         *Display all the statements stored in the knowledge base
         */
        public void DisplayKnowledgeBase(){
            for(int i = 0; i < size ; i++){
            System.out.println(knowledgeBase[i]);
            }
        }

}

