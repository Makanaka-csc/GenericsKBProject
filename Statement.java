/**
 * The Statement class represents a statement associated with a term and a confidence score.
 * It implements the Comparable interface to allow comparison based on the term.
 */
//Makanaka Mangwanda
//09 March 2025
 
 
 
public class Statement implements Comparable<Statement> {

    public String term;
    public double score;
    public String sentence;

    /**
     * Constructing a new Statement object.
     *
     * @param term The term associated with the statement.
     * @param sentence The actual sentence of the statement.
     * @param score The confidence score of the statement.
     */
    public Statement(String term, String sentence, double score) {
        this.term = term;
        this.score = score;
        this.sentence = sentence;
    }

     public String getTerm() {
        return term.trim();
    }

     public double getScore() {
        return score;
    }

    /**
     * getting the sentence of this statement.
     *
     * @return The sentence, trimmed of any leading or trailing spaces.
     */
    public String getSentence() {
        return sentence.trim();
    }

    /**
     * Updates the term of this statement.
     *
     * @param term The new term to be set.
     */
    public void setTerm(String term) {
        this.term = term;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * Updates the sentence of this statement.
     *
     * @param sentence The new sentence to be set.
     */
    public void setStatement(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Updates the sentence and score of this statement if the new score is higher.
     *
     * @param newSentence The new sentence to be set.
     * @param newScore The new confidence score to be set.
     */
    public void UpdateSentence(String newSentence, double newScore) {
        if (newScore > this.score) {
            this.sentence = newSentence;
            this.score = newScore;
        }
    }
    
    

    /**
     * Comparing the statement with another statement based on the term.
     *
     * @param other The statement being compare to.
     * 
     */
    @Override
    public int compareTo(Statement other) {
        return this.term.compareTo(other.term);
    }



      @Override
    public String toString() {
        return "Term: " + term + ", Score: " + score + ", Sentence: " + sentence;
    }
}

