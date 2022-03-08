package com.company;


import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);

        int size = 0;
        String line;
        while (fileScanner.hasNextLine()) {
            line = fileScanner.nextLine();
            size += 1;
        }

        int randomNumber = (int) (Math.random() * size + 1);

        Scanner fileScanner2 = new Scanner(file);
        String chosenMovie = "";
        for (int i = 0; i < randomNumber; i++) {
            chosenMovie = fileScanner2.nextLine();
        }

        System.out.println("I have drawn a movie title for you. Try to guess it by entering the next letters. You have 10 tries.");
        //System.out.println(chosenMovie);

        System.out.println(new String(chosenMovie).replaceAll("\\w", "_"));

        char[] chosenMovieArray = chosenMovie.toCharArray();

        String hiddenTittle = new String(chosenMovie).replaceAll("\\w", "_");
        char[] hiddenTittleArray = hiddenTittle.toCharArray();

        Scanner scanner = new Scanner(System.in);
        for (int i = 10; i > 0; i--) {
            System.out.println("Guess a letter, you have " + i + " chosen");
            char guess = scanner.next().charAt(0);
            for (int j = 0; j < chosenMovieArray.length; j++) {
                if (guess == chosenMovieArray[j]) {
                    hiddenTittleArray[j] = guess;
                }
            }
            for (int k = 0; k < chosenMovieArray.length; k++) {
                System.out.print(hiddenTittleArray[k]);
            }
            System.out.println();

            if((String.copyValueOf(hiddenTittleArray)).equals(chosenMovie)){
                System.out.println("Great! You have won.");
                break;
            }

            System.out.println("Do you want try to guess whole title? (y/n)");
            Scanner scanner2 = new Scanner(System.in);
            char yesOrNo = scanner2.next().charAt(0);
            if (yesOrNo == 'y') {
                System.out.println("Write your answer:");
                Scanner scanner3 = new Scanner(System.in);
                String tryToGuess = scanner3.nextLine();
                if (tryToGuess.equals(chosenMovie)) {
                    System.out.println("Great! You have won.");
                    break;
                } else {
                    System.out.println("You're wrong.");
                }
            }
            if(i == 1){
                System.out.println("It's over. You've lost.");
            }
        }
    }
}