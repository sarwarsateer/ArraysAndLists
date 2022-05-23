import java.util.Scanner;

public class MinElementChallenge {
    static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int[] returnedArray = readIntegers(count);
        int returnedMinValue = findMin(returnedArray);
        System.out.println("minimum value is:" + returnedMinValue);
    }

    private static int[] readIntegers(int count) {
        int[] inputNumbers = new int[count];
        for (int i = 0; i < count; i++) {
            int number = scanner.nextInt();
            scanner.nextLine();
            inputNumbers[i] = number;
        }
        return inputNumbers;
    }

    private static int findMin(int[] inputArray) {

        int minValue = Integer.MAX_VALUE;// we compare the value to the maximum integer value

        for (int i = 0; i < inputArray.length; i++) {
                int value = inputArray[i];
                if (value < minValue) {
                    minValue = value;
                }
            }
        return minValue;
    }
}
