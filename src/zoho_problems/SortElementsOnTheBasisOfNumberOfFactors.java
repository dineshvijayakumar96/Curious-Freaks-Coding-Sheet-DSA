package zoho_problems;

import java.util.*;

public class SortElementsOnTheBasisOfNumberOfFactors {

    public static int[] sortByFactors(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k : arr) {
            map.put(k, getFactors(k));
        }
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        list.sort((n1, n2) -> {
            int frequency1 = map.get(n1);
            int frequency2 = map.get(n2);
            if (frequency1 != frequency2) {
                return frequency2 - frequency1;
            }
            return 0;
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static int getFactors(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 11, 10, 20, 9, 16, 23 };
        System.out.println("Output: " + Arrays.toString(sortByFactors(arr)));
    }
}
