/**
 * Class: Start
 * Purpose: main class to make this program run
 * Author: Learning_Jay
 * Data: 11.11.2017
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Start {
    public static void main(String[] args){
        /**
         * loading data first
         */
        HashMap<Integer,String> wordList = preLoad();
        System.out.println("Which word list do you want to load?");
        Scanner input = new Scanner(System.in);
        int num  = input.nextInt();

        ArrayList<Words> wordsArrayList = loadingWords(wordList.get(num));
        ArrayList<WrongWords> wrongWords = loadingWrongWords("WrongWords.txt");

        Driver driver = new Driver();
        driver.run(wordsArrayList,wrongWords);


    }

    private static ArrayList<WrongWords> loadingWrongWords(String s) {
        ArrayList<WrongWords> wrongWords = new ArrayList<WrongWords>();
        try {
            Scanner scanner = new Scanner(new File(s));
            while (scanner.hasNext()){
                StringTokenizer st = new StringTokenizer(scanner.nextLine()," ");
                WrongWords words = new WrongWords(st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()));
                wrongWords.add(words);
            }
        } catch (FileNotFoundException e){
            System.out.println("Can not find file: " + s);
        }
        return wrongWords;
    }

    private static HashMap<Integer, String> preLoad() {
        HashMap<Integer, String> wordList = new HashMap<Integer, String>();
        for (int i =1; i<36;i++){
            wordList.put(i,"/Users/KBOY/IdeaProjects/CET-4/WordList/WordList"+i+".txt");
        }
        return wordList;
    }

    private static ArrayList<Words> loadingWords(String s) {
        ArrayList<Words> wordsArrayList = new ArrayList<Words>();
        try {
            Scanner scanner = new Scanner(new File(s));
            while (scanner.hasNext()){
                StringTokenizer st = new StringTokenizer(scanner.nextLine()," ");
                Words words = new Words(st.nextToken(),st.nextToken(),st.nextToken());
                wordsArrayList.add(words);
            }
        } catch (FileNotFoundException e){
            System.out.println("Can not find file: " + s);
        }
        return wordsArrayList;
    }
}
