/**
 * This KnowledgeBaseBST class stores statements in a Binary Search Tree (BST).
 * It allows loading data from a file, updating or adding statements, and searching for a statement by term.
 */
 
 //Makanaka Mangwanda
//15 March 2025


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class KnowledgeBaseBST {

    
    private BinarySearchTree<Statement> knowledgeBase;

    public KnowledgeBaseBST() {
    knowledgeBase = new BinarySearchTree<>();
    }

    /**
     * Loads statements from a file into the Binary Search Tree.
     * Each line in the file should be formatted as: term, sentence, score (separated by tabs).
     *
     * @param fileName The name of the file that is containing the statements.
     * @return {@code true} if the file was successfully loaded, otherwise {@code false}.
     */
    public boolean fileLoad(String fileName) {
        try (BufferedReader r = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = r.readLine()) != null) {
                String parts[] = line.split("\t");

                if (parts.length == 3) {
                    String term = parts[0];
                    String sentence = parts[1];
                    double score = Double.parseDouble(parts[2]);
                    Statement statement = new Statement(term, sentence, score);
                    updateStatement(statement); // Update or insert the statement into the BST
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Updates an existing statement in the BST or adds a new one if it does not exist.
     * If a statement with the same term exists, it updates the sentence and score.
     *
     * @param newStat The new statement to be added or updated in the BST.
     */
    public void updateStatement(Statement newStat) {
        BinaryTreeNode<Statement> foundIt = knowledgeBase.find(newStat);

        if (foundIt != null) {
            // Update the existing statement
            Statement oldStat = foundIt.data;
            oldStat.setStatement(newStat.getSentence());
            oldStat.setScore(newStat.getScore());
        } else {
            // Inserting a new statement
            knowledgeBase.insert(newStat);
        }
    }

    /**
     * this method searches for a statement in the BST using the given term.
     *
     * @param term The term to search for.
     * @return The Statement object if found, otherwise null
     */
    public Statement searchStatement(String term) {
        Statement search = new Statement(term, "", 0.0);
        BinaryTreeNode<Statement> foundIt = knowledgeBase.find(search);
        return foundIt != null ? foundIt.data : null;
    }

    /**
     * Displays all statements in the BST in order.
     */
    public void displayKnowledgeBase() {
        Order(knowledgeBase.root);
    }

    /**
     * Recursively printing out statements of the BST in sorted order.
     *
     * @param node The current node in the BST traversal.
     */
    private void Order(BinaryTreeNode<Statement> node) {
        if (node != null) {
            Order(node.left);
            System.out.println(node.data);
            Order(node.right);
        }
    }
}
