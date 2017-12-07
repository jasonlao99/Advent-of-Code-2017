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
        System.out.println("The number of cycles for part one is: " + getCycles(banks));
        System.out.println("The size of the loop for part two is: " + getLoopSize(banks));
    }

    public static int getCycles(int[] arr) {
        int cycles = 0;
        ArrayList<String> states = new ArrayList<>();
        while(!states.contains(Arrays.toString(arr))) {
            states.add(Arrays.toString(arr));
            redistribute(arr);
            cycles++;
        }
        return cycles;
    }

    public static int getLoopSize(int[] arr) {
        String original = Arrays.toString(arr);
        redistribute(arr);
        int loopSize = 1;
        while(!Arrays.toString(arr).equals(original)) {
            redistribute(arr);
            loopSize++;
        }
        return loopSize;
    }

    public static void redistribute(int[] arr) {
        int largest = getIndexOfLargest(arr);
        int num = arr[largest];
        arr[getIndexOfLargest(arr)] = 0;
        for(int i = 1; i <= num; i++) {
            arr[(largest + i) % arr.length]++;
        }
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