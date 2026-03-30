package array;

import java.util.ArrayList;
import java.util.List;

public class FrequenciesInALimitedArray {

    public static List<Integer> count(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(0);
        }
        for (int j : arr) {
            list.set(j - 1, list.get(j - 1) + 1);
        }
        return list;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 2, 3, 5 };
        System.out.println("Output: " + count(arr));
    }
}
