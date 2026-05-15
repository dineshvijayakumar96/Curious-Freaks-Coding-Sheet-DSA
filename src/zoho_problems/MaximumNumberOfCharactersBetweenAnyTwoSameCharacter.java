package zoho_problems;

import java.util.Arrays;

public class MaximumNumberOfCharactersBetweenAnyTwoSameCharacter {

    public static int maxChars(String s) {
        int[] firstIndex = new int[256];
        Arrays.fill(firstIndex, -1);
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIndex[c] == -1) {
                firstIndex[c] = i;
            } else {
                int distance = i - firstIndex[c] - 1;
                maxLength = Math.max(maxLength, distance);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String S = "socks";
        System.out.println("Output: " + maxChars(S));
    }
}
