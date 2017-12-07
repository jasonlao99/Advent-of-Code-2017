/*
 * Jason Lao
 * 12/1/17
 * Advent of Code Day 5
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input/Day6.txt"));
        String[] strArray = input.nextLine().split("\\t");
        int[] banks = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
        int cycles = 0;
        ArrayList<String> states = new ArrayList<>();
        while(!states.contains(Arrays.toString(banks))) {
            states.add(Arrays.toString(banks));
            int largest = getIndexOfLargest(banks);
            int num = banks[largest];
            banks[getIndexOfLargest(banks)] = 0;
            for(int i = 1; i <= num; i++) {
                banks[(largest + i) % banks.length]++;
            }
            cycles++;
        }
        System.out.println("The number of cycles for part one is: " + cycles);
    }

    public static int getIndexOfLargest(int[] arr) {
        int index = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}