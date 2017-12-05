/*
 * Jason Lao
 * 12/1/17
 * Advent of Code Day 4
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input/Day4.txt"));
        int validCounter1 = 0;
        int validCounter2 = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] passphrase = line.split("\\s");
            if(isValid1(passphrase))
                validCounter1++;
            if(isValid2(passphrase))
                validCounter2++;
        }
        System.out.println("There are " + validCounter1 + " passphases for part 1");
        System.out.println("There are " + validCounter2 + " passphases for part 2");
    }

    public static Boolean isValid1(String[] passphraseArray) {
        for(int i = 0; i < passphraseArray.length; i++) {
            for (int j = 0; j < passphraseArray.length; j++) {
                if(i != j && passphraseArray[i].equals(passphraseArray[j]))
                    return false;
            }
        }
        return true;
    }

    public static Boolean isValid2(String[] passphraseArray) {
        for(int i = 0; i < passphraseArray.length; i++) {
            char[] word1 = passphraseArray[i].toCharArray();
            Arrays.sort(word1);
            for (int j = 0; j < passphraseArray.length; j++) {
                char[] word2 = passphraseArray[j].toCharArray();
                Arrays.sort(word2);
                if(i != j && Arrays.equals(word1, word2)) {
                    return false;
                }
            }
        }
        return true;
    }
}