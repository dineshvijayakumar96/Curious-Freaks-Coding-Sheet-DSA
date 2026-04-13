package zoho_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SortingElementsOfAnArrayByFrequency {

    public static int[] sort(int[] A) {
        if (A.length == 0) return A;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : A) {
            list.add(num);
        }
        list.sort(
                (n1, n2) -> {
                    int frequency1 = map.get(n1);
                    int frequency2 = map.get(n2);
                    if (frequency1 != frequency2) {
                        return frequency2 - frequency1;
                    }
                    return n1 - n2;
                }
        );
        for (int i = 0; i < A.length; i++) {
            A[i] = list.get(i);
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 5, 5, 4, 6, 4 };
        sort(A);
        System.out.println(Arrays.toString(A));
    }
}
