package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class SmallestDistinctWindow {

    public static int findSubString(String str) {
        Set<Character> uniqueCharacters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            uniqueCharacters.add(str.charAt(i));
        }
        int requiredDistinct = uniqueCharacters.size();
        int[] windowCount = new int[256];
        int left = 0;
        int currentDistinct = 0;
        int minWindowLength = Integer.MAX_VALUE;
        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            windowCount[rightChar]++;
            if (windowCount[rightChar] == 1) {
                currentDistinct++;
            }
            while (currentDistinct == requiredDistinct) {
                minWindowLength = Math.min(minWindowLength, right - left + 1);
                char leftChar = str.charAt(left);
                windowCount[leftChar]--;
                if (windowCount[leftChar] == 0) {
                    currentDistinct--;
                }
                left++;
            }
        }
        return minWindowLength;
    }

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println("Output: " + findSubString(str));
    }
}
