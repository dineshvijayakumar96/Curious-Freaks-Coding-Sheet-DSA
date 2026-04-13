package zoho_problems;

import java.util.ArrayList;

public class ModifyTheArray {

    public static ArrayList<Integer> modifyAndRearrangeArr(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) return result;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] = arr[i] + arr[i + 1];
                arr[i + 1] = 0;
            }
            if (arr[i] != 0) result.add(arr[i]);
        }
        if (arr[n - 1] != 0) result.add(arr[n - 1]);
        while (result.size() < n) {
            result.add(0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 0, 4, 0, 8 };
        System.out.println("Output: " + modifyAndRearrangeArr(arr));
    }
}
