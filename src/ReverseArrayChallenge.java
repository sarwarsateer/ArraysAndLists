import java.util.Arrays;

public class ReverseArrayChallenge {
    public static void main(String[] args) {

        int[] arrayNum = {1, 2, 3, 4, 5, 6};

        System.out.println("Array before reverse: " + Arrays.toString(arrayNum));

//        int[] reversedArray = reverseArray(arrayNum);
//
//        System.out.println("Array after reverse: " + Arrays.toString(reversedArray));

        System.out.println("It's reversed by reverse method\n");
        reverse(arrayNum);
        System.out.println(Arrays.toString(arrayNum));

    }

    private static int[] reverseArray(int[] array) {
        int arrayLength = array.length;
        int[] reversedArray = new int[arrayLength];

        int arrayCounter = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[arrayCounter];
            arrayCounter--;
        }

        return reversedArray;
    }

    private static int[] reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfIndex = array.length / 2;

        for (int i = 0; i < halfIndex; i++) {
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }

        return array;
    }
}
