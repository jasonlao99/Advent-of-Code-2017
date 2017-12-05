/*
 * Jason Lao
 * 12/1/17
 * Advent of Code Day 1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static void main (String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input/Day1.txt"));
        String numSequence = input.nextLine();
        System.out.println("The solution to captcha part 1 is: " + calculateCaptcha1(numSequence));
        System.out.println("The solution to captcha part 2 is: " + calculateCaptcha2(numSequence));
    }

    public static int calculateCaptcha1 (String digits) {
        int sum = 0;
        for (int i = 0; i < (digits.length() - 1); i++) {
            if(digits.charAt(i) == digits.charAt(i + 1)) {
                sum += Character.getNumericValue(digits.charAt(i));
            }
        }
        if(digits.charAt(digits.length() - 1) == digits.charAt(0)) {
            sum += Character.getNumericValue(digits.charAt(digits.length() - 1));
        }
        return sum;
    }

    public static int calculateCaptcha2 (String digits) {
        int sum = 0;
        for (int i = 0; i < digits.length() / 2; i++) {
            if(digits.charAt(i) == digits.charAt(i + digits.length() / 2)) {
                sum += Character.getNumericValue(digits.charAt(i));
            }
        }
        sum *= 2;
        return sum;
    }
}