package sliding_window;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        int[] characterCounts = new int[128];
        for (char c : t.toCharArray()) {
            characterCounts[c]++;
        }
        int leftWindow = 0;
        int rightWindow = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = 0;
        int charactersNeeded = t.length();
        while (rightWindow < s.length()) {
            char rightCharacter = s.charAt(rightWindow);
            if (characterCounts[rightCharacter] > 0) {
                charactersNeeded--;
            }
            characterCounts[rightCharacter]--;
            rightWindow++;
            while (charactersNeeded == 0) {
                if (rightWindow - leftWindow < minWindowLength) {
                    minWindowLength = rightWindow - leftWindow;
                    minWindowStart = leftWindow;
                }
                char leftCharacter = s.charAt(leftWindow);
                characterCounts[leftCharacter]++;
                if (characterCounts[leftCharacter] > 0) {
                    charactersNeeded++;
                }
                leftWindow++;
            }
        }
        if (minWindowLength == Integer.MAX_VALUE) return "";
        return s.substring(minWindowStart, minWindowStart + minWindowLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Output: " + minWindow(s, t));
    }
}
