package array;

import java.util.ArrayList;

public class RemoveDuplicatesSortedArray {

    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null || arr.length == 0) return list;
        int left = 0, right = left + 1;
        list.add(arr[left]);
        if (arr.length < 2) return list;
        while (right < arr.length) {
            if (arr[right] != arr[left]) {
                list.add(arr[right]);
                left  = right;
            }
            right++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        System.out.println("Output: " + removeDuplicates(arr));
    }
}
