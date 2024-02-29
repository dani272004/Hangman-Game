package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args){

        //Instances of a class
        Helper helper = new Helper();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //Auxiliary variables
        int counter = 0;
        int counter2 = 0;
        int attempts;
        boolean correct;
        boolean exist;
        String charactersUsed = "";

        String [] wordList = {"apple", "banana", "orange", "table", "chair", "book", "sun", "moon", "cloud", "flower"
                , "elephant", "giraffe", "computer", "keyboard", "guitar", "diamond", "mountain", "ocean", "island",
                "puzzle"}; //Word array

        String randomWord = wordList[random.nextInt(wordList.length)];//Select a random word
        char[] theWord = randomWord.toCharArray();//Convert that word to a char array
        attempts = theWord.length + 3;//Assign a value to attempts

        //A new char type to: track the current state of the random word && initialize it to _.
        char[] theWordCurrently = new char [theWord.length];
        for (int i=0; i < theWordCurrently.length; i++){
            theWordCurrently[i] = '_';
        }

        //Game's logic
        while (attempts > 0 && counter < theWordCurrently.length) {

            correct = false;
            exist = false;
            helper.displayInfo1(theWordCurrently, charactersUsed, counter2, attempts);//Displays Info
            char userInput = scanner.next().charAt(0);

            //Checks if the inputted character is repeated
            for (int i = 0; i < charactersUsed.length(); i++) {
                if (charactersUsed.contains(String.valueOf(userInput))) {
                    exist = true;
                    break;
                }
            }

            if(!exist) {
                charactersUsed += String.valueOf(userInput).concat(", ");

                for (int i = 0; i < theWord.length; i++) {
                    if (userInput == theWord[i]) {
                        theWordCurrently[i] = userInput;
                        correct = true;
                        counter++;
                    }
                    counter2++;
                }

                if (!correct) {
                    attempts--;
                }

            }

            helper.displayInfo2();

            helper.decide(theWord, counter, attempts);//Decides weather you won

        }
    }
}

