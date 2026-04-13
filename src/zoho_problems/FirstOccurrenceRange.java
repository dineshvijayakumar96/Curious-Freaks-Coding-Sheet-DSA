package zoho_problems;

import java.util.Arrays;

public class FirstOccurrenceRange {

    public static String findRange(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) return "";
        int[] occurrences = new int[256];
        Arrays.fill(occurrences, -1);
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (occurrences[c] == -1) {
                occurrences[c] = i;
            }
        }
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        boolean found = false;
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            int indexStr1 = occurrences[c];
            if (indexStr1 != -1) {
                minIndex = Math.min(minIndex, indexStr1);
                maxIndex = Math.max(maxIndex, indexStr1);
                found = true;
            }
        }
        if (!found) return "";
        return str1.substring(minIndex, maxIndex + 1);
    }

    public static void main(String[] args) {
        String str1 = "zohoquestions";
        String str2 = "set";
        System.out.println("Output: " + findRange(str1, str2));
    }
}
