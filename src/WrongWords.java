/**
 * Class: WrongWords
 * Purpose: Record the wrong words and how many times did it wrong
 * Author: Learning_Jay
 * Data: 11.11.2017
 */
public class WrongWords extends Words {
    private int times;
    public WrongWords(String word,String propety, String means,int times) {
        super(word, propety, means);
        this.times = times;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return super.getWord() + " " +super.getProperty()+ " " + super.getMeans() + " " + times;
    }
}
