package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Challenge1 {
    //    Create a program using arrays that sort a list of integers in descending order.
//    Descending order is the highest value to lowest
//    In other words if the array had the values in it 106, 26, 81, 5, 15 your program should ultimately have an array with 106, 81, 26, 15, 5 in it
//    Set up the program so that the numbers to sort are read in from the keyboard
//    Implement the following methods - getIntegers, printArray, and sortIntegers
//    getIntegers return an array of entered integers from keyboard
//    printArray prints out the contents of the array
//    and sortIntegers should sort the array and return a new array containing the sorted numbers
//    you will have to figure out how to copy the array element from the passed array into a new array and sort them and return the new sorted array
// 106, 26, 81, 5, 15
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] intArrays = getIntegers(5);
        printArrays(intArrays);
        System.out.println("After soring");
        printArrays(sortIntegers(intArrays));

    }
    private static int[] getIntegers(int arrayLength) {
        System.out.println("Enter the Numbers \r");
        int[] values = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    private static void printArrays(int arrays[]) {
        System.out.println("Entered Values \r");
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    private static int[] sortIntegers(int arrays[]) {
//        int[] sortedArray = arrays;
        int[] sortedArray = Arrays.copyOf(arrays, arrays.length);// another built-in way of copyying arrays
        int temp;
        boolean flag = true;
        while (flag){
            flag = false;
            for (int i = 0; i < sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    flag = true;
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                }
            }
        }
        return sortedArray;
    }
}
