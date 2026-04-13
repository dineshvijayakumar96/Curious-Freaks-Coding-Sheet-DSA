package zoho_problems;

import java.util.Arrays;
import java.util.Random;

public class ArrayShuffle {

    public static void shuffle(int[] arr) {
        if (arr.length == 0) return;
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        shuffle(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}
