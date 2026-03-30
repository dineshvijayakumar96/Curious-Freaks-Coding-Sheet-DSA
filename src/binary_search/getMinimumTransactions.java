package binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class getMinimumTransactions {

    public static long findMinTransactions(List<Integer> assetAmounts) {
        long transactionLimit = assetAmounts.get(0);
        long totalSum = 0;

        for (int amount : assetAmounts) {
            totalSum += amount;
        }

        long minTransactions = Long.MAX_VALUE;
        long currentPrefixSum = 0;

        for (int i = 1; i < assetAmounts.size() - 1; i++) {
            if (transactionLimit > 0) {
                // Portfolio A
                currentPrefixSum += assetAmounts.get(i);

                // Portfolio B
                long suffixSum = totalSum - currentPrefixSum;

                long diff = Math.abs(currentPrefixSum - suffixSum);

                if (diff < minTransactions) {
                    transactionLimit--;
                    minTransactions = diff;
                }
            }
        }

        return minTransactions;
    }

    public static void main(String[] args) {
        List<Integer> assetAmounts = new ArrayList<>();
        Integer[] arr = { 4, 5, 7 };
        int k = 3;
        assetAmounts.add(k);
        assetAmounts.addAll(Arrays.asList(arr));
        System.out.println("Output: " + findMinTransactions(assetAmounts));
    }
}
