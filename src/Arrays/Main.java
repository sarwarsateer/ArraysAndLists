package Arrays;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers;
        numbers = getInputs(5);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("number " + numbers[i]);
        }

        System.out.println("the average is " + getTheAverageValue(numbers));
    }

    private static double getTheAverageValue(int[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum / numbers.length;
    }

    private static int[] getInputs(int numbers) {
        System.out.println("Enter 5 numbers \r");
        int[] values = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }
}
