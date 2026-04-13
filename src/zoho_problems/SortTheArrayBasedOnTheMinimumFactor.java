package zoho_problems;

import java.util.*;

public class SortTheArrayBasedOnTheMinimumFactor {

    public static int[] sortMinimumFactors(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        list.sort((n1, n2) -> {
            int factor1 = getMinPrimeFactor(n1);
            int factor2 = getMinPrimeFactor(n2);
            if (factor1 != factor2) {
                return factor1 - factor2;
            }
            return n1 - n2;
        });
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static int getMinPrimeFactor(int n) {
        if (n <= 1) return n;
        if (n % 2 == 0) return 2;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return i;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 11, 10, 20, 9, 16, 23 };
        System.out.println("Output: " + Arrays.toString(sortMinimumFactors(arr)));
    }
}
