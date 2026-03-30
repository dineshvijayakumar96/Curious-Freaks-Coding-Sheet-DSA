package array;

import java.util.ArrayList;

public class MinAndMaxInArray {

    public static ArrayList<Integer> calculateMinMax(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();

        if (arr.length == 0) {
            list.add(arr[0]);
            return list;
        }

        int min = Math.min(arr[0], arr[arr.length - 1]);
        int max = Math.max(arr[0], arr[arr.length - 1]);

        for (int i = 1; i < Math.ceil((double) arr.length / 2); i++) {

            if (arr[i] != 0 && arr[i] <= min && arr[i] <= max) {
                min = arr[i];
            } else if (arr[i] != 0 && arr[i] >= max && arr[i] >= min) {
                max = arr[i];
            }

            if (arr[i] != 0 && arr[(arr.length - 1) - i] <= min && arr[(arr.length - 1) - i] <= max) {
                min = arr[(arr.length - 1) - i];
            } else if (arr[(arr.length - 1) - i] >= max && arr[(arr.length - 1) - i] >= min) {
                max = arr[(arr.length - 1) - i];
            }
        }

        list.add(min);
        list.add(max);

        return list;
    }

    public static void main(String[] args) {

        int[] arr = { 32011, 123, 1045, 1205, 254, 28763, 6537, 3161 };
        System.out.println("Output: " + calculateMinMax(arr));
    }
}
