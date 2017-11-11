/**
 * Class: Words
 * Purpose: Record the words to set a data construct
 * Author: Learning_Jay
 * Data: 11.11.2017
 */

public class Words {
    private String word,property,means;

    public Words(String word, String property, String means){
        this.word = word;
        this.property = property;
        this.means = means;
    }

    public String getWord() {
        return word;
    }

    public String getMeans() {
        return means;
    }

    public String getProperty() {
        return property;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    @Override
    public String toString() {
        return word + " " + property + " " + means;
    }
}
