package sliding_window;

public class LengthOfTheLongestSubstring {

    public static int longestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[] lastSeen = new int[26];
        for (int i = 0; i < lastSeen.length; i++) {
            lastSeen[i] = -1;
        }
        int leftWindow = 0;
        int length = 0;
        for (int rightWindow = 0; rightWindow < s.length(); rightWindow++) {
            int characterIndex = s.charAt(rightWindow) - 'a';
            if (lastSeen[characterIndex] != -1) {
                if (lastSeen[characterIndex] + 1 > leftWindow) {
                    leftWindow = lastSeen[characterIndex] + 1;
                }
            }
            lastSeen[characterIndex] = rightWindow;
            if (rightWindow - leftWindow + 1 > length) {
                length = rightWindow - leftWindow + 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.printf("Output: " + longestUniqueSubstring(s));
    }
}
