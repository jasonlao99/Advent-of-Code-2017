/*
 * Jason Lao
 * 12/1/17
 * Advent of Code Day 5
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    public static void main (String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input/Day5.txt"));
        List<Integer> numList = new ArrayList<>();
        while(input.hasNextInt()) {
            numList.add(input.nextInt());
        }
        int[] numArray1 = numList.stream().mapToInt(i -> i).toArray();
        int[] numArray2 = numArray1.clone();

        System.out.println("The number of steps for part 1 is: " + getSteps1(numArray1));
        System.out.println("The number of steps for part 2 is: " + getSteps2(numArray2));
    }

    public static int getSteps1(int[] arr) {
        int stepCounter = 0;
        int index = 0;
        while(index < arr.length) {
            index += arr[index]++;
            stepCounter++;
        }
        return stepCounter;
    }

    public static int getSteps2(int[] arr) {
        int stepCounter = 0;
        int index = 0;
        while(index < arr.length) {
            int currentValue = arr[index];
            if(arr[index] < 3)
                arr[index] += 1;
            else
                arr[index] += -1;
            index += currentValue;
            stepCounter++;
        }
        return stepCounter;
    }
}
