/*
 * Jason Lao
 * 12/1/17
 * Advent of Code Day 2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("input/Day2.txt"));
        int checksum1 = 0;
        int checksum2 = 0;
        while(input.hasNextLine()) {
            String line = input.nextLine();
            int difference = getDifference(line);
            checksum1 += difference;
            int quotient = getQuotient(line);
            checksum2 += quotient;
        }
        System.out.println("The checksum for part 1 is " + checksum1);
        System.out.println("The checksum for part 2 is " + checksum2);
    }

    public static int getDifference(String sequence) {
        String[] numArray = sequence.split("\t");
        return (findBiggest(numArray) - findSmallest(numArray));
    }

    public static int getQuotient(String sequence) {
        String[] numArray = sequence.split("\t");
        int answer = 0;
        for(int i = 0; i < numArray.length; i++) {
            for(int j = 0; j < numArray.length; j++) {
                if (((Integer.parseInt(numArray[i]) % Integer.parseInt(numArray[j])) == 0) && j != i) {
                    answer = Integer.parseInt(numArray[i]) / Integer.parseInt(numArray[j]);
                }
            }
        }
        return answer;
    }

    public static int findBiggest(String[] array) {
        int biggest = 0;
        for(int i = 0; i < array.length; i++) {
            int num = Integer.parseInt(array[i]);
            if (num > biggest) {
                biggest = num;
            }
        }
        return biggest;
    }

    public static int findSmallest(String[] array) {
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++) {
            int num = Integer.parseInt(array[i]);
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }

}