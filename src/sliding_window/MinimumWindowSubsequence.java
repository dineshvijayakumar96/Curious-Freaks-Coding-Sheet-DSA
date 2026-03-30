package sliding_window;

public class MinimumWindowSubsequence {

    public static String minWindow(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) return "";
        int minLength = Integer.MAX_VALUE;
        int minStart = -1;
        int i = 0;
        int j = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
                if (j == s2.length()) {
                    int rightWindow = i;
                    j--;
                    while (j >= 0) {
                        if (s1.charAt(i) == s2.charAt(j)) {
                            j--;
                        }
                        if (j >= 0) {
                            i--;
                        }
                    }
                    int currentLength = rightWindow - i + 1;
                    if (currentLength < minLength) {
                        minLength = currentLength;
                        minStart = i;
                    }
                    j = 0;
                }
            }
            i++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s1.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "eksrg";
        System.out.println("Output: " + minWindow(s1, s2));
    }
}
