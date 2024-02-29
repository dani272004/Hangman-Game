package Hangman;

import java.util.Arrays;

public class Helper {

    public Helper(){
    }

    public void displayInfo1(char[] wordc, String charUsed, int pcounter, int pattemps){
        System.out.println("================================");
        if (pcounter > 0){
            System.out.println("Characters used: " + charUsed);
        }
        System.out.println("Attemps: " + pattemps);
        System.out.println("Guess the word: \n" + Arrays.toString(wordc));
    }

    public void displayInfo2(){
        System.out.println("================================");
        System.out.println();
        System.out.println();
    }

    public void decide(char[] theword, int pcounter, int pattemps){ //Decides weather you won
        if(theword.length == pcounter) {
            System.out.println("You Won!!!");
            System.out.println(Arrays.toString(theword));
        }

        if (pattemps <= 0){
            System.out.println("Game Over");
            System.out.println("The word is: " + Arrays.toString(theword));
        }
    }



}
