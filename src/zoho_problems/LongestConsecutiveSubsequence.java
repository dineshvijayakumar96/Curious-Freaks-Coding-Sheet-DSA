package zoho_problems;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    public static int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int longestStreak = 0;
        for (int num : arr) {
            set.add(num);
            if (num < min) min = num;
        }
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arr = { 15, 13, 12, 14, 11, 10, 9 };
        System.out.println("Output: " + longestConsecutive(arr));
    }
}
