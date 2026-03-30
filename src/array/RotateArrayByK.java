package array;

import java.util.ArrayList;
import java.util.Arrays;

public class RotateArrayByK {

    public static ArrayList<Integer> rotate(ArrayList<Integer> arr, int k) {

        k %= arr.size();
        if (k == arr.size() || k == 0) return arr;
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.size() - 1);
        reverse(arr, 0, arr.size() - 1);
        return arr;
    }

    public static void reverse(ArrayList<Integer> arr, int start, int end) {
        while (start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);

        int k = 3;
        System.out.println("Input: " + Arrays.toString(arr.toArray()));
        System.out.println("k: " + k);
        System.out.println("Output: " + rotate(arr, k));
    }
}
