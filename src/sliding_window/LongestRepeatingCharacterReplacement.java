package sliding_window;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int[] letterCounts = new int[26];
        int leftWindow = 0;
        int maxFrequency = 0;
        int length = 0;
        for (int rightWindow = 0; rightWindow < s.length(); rightWindow++) {
            int rightCharacterIndex = s.charAt(rightWindow) - 'A';
            letterCounts[rightCharacterIndex]++;
            if (letterCounts[rightCharacterIndex] > maxFrequency) {
                maxFrequency = letterCounts[rightCharacterIndex];
            }
            int currentWindowSize = rightWindow - leftWindow + 1;
            if (currentWindowSize - maxFrequency > k) {
                int leftCharacterIndex = s.charAt(leftWindow) - 'A';
                letterCounts[leftCharacterIndex]--;
                leftWindow++;
            }
            currentWindowSize = rightWindow - leftWindow + 1;
            if (currentWindowSize > length) {
                length = currentWindowSize;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.printf("Output: " + characterReplacement(s, k));
    }
}
