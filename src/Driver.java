/**
 * Class: Driver
 * Purpose: testing words
 * Author: Learning_Jay
 * Data: 11.11.2017
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    int countWrong = 0;
    ArrayList<Words> currentWrong = new ArrayList<Words>();
    public void run(ArrayList<Words> wordsArrayList, ArrayList<WrongWords> wrongWords) {
        Boolean quite;
        System.out.println("This word list have " + wordsArrayList.size() + " words");
        do {
            for (Words word : wordsArrayList) {
                System.out.println("Write the word base on word's mean: ");
                System.out.println(word.getProperty()+"\t"+word.getMeans());
                Scanner input = new Scanner(System.in);
                String typingWord = input.next();
                System.out.println("This word is: " + word.getWord());
                if (typingWord.compareToIgnoreCase(word.getWord()) != 0) {
                    System.out.println(
                            "!!WARNING!!\nYou type as: " + typingWord
                                    + "\nThis word will add to wrong word list, you can check it late."
                    );
                    addWrongWords(word, wrongWords);
                }
                else
                    System.out.println("You type as: " + typingWord);

            }
            System.out.println("\nyou have go through this word list once, do you want do it again? \n yes/no.");
            Scanner input = new Scanner(System.in);
            if (input.next().equalsIgnoreCase("yes"))
                quite = true;
            else
                quite = false;
        }while (quite);
        System.out.println("You type wrongly: "+ countWrong + " Words.");
        for (Words w: currentWrong)
            System.out.println(w.toString());
        saveWrongWords(wrongWords);
        saveCurrentWrong();
    }

    private void saveCurrentWrong() {
        try {
            FileWriter fw = new FileWriter("CurrentWrongWords.txt");
            BufferedWriter output = new BufferedWriter(fw);
            for (Words w: currentWrong){
                output.write(w.toString());
                output.newLine();
            }
            output.close();
        } catch (Exception e){
            System.out.println("I cannot create that file");
        }
    }

    private void saveWrongWords(ArrayList<WrongWords> wrongWords) {
        try {
            FileWriter fw = new FileWriter("WrongWords.txt");
            BufferedWriter output = new BufferedWriter(fw);
            for (WrongWords w: wrongWords){
                output.write(w.toString());
                output.newLine();
            }
            output.close();
        } catch (Exception e){
            System.out.println("I cannot create that file");
        }
    }

    private void addWrongWords(Words word, ArrayList<WrongWords> wrongWords) {
        Boolean flag = false;
        countWrong++;
        currentWrong.add(word);
        if(wrongWords != null){
            for (WrongWords w :wrongWords) {
                if (word.getWord() == w.getWord()){
                    flag = true;
                    w.setTimes(w.getTimes()+1);
                }
            }
        }
        if (!flag)
            wrongWords.add(new WrongWords(word.getWord(),word.getProperty(),word.getMeans(),1));
        else
            System.out.println("Word: "+word.getWord()+" Wrong times increase once.");
    }
}
