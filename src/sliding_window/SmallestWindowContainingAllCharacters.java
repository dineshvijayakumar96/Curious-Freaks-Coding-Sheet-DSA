package sliding_window;

public class SmallestWindowContainingAllCharacters {

    public static String minWindow(String s, String p) {
        if (s.length() < p.length()) return "";
        int[] map = new int[256];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i)]++;
        }
        int leftWindow = 0;
        int countMatched = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        for (int rightWindow = 0; rightWindow < s.length(); rightWindow++) {
            char rightCharacter = s.charAt(rightWindow);
            if (map[rightCharacter] > 0) {
                countMatched++;
            }
            map[rightCharacter]--;
            while (countMatched == p.length()) {
                if (rightWindow - leftWindow + 1 < minLength) {
                    minLength = rightWindow - leftWindow + 1;
                    startIndex = leftWindow;
                }
                char leftCharacter = s.charAt(leftWindow);
                map[leftCharacter]++;
                if (map[leftCharacter] > 0) {
                    countMatched--;
                }
                leftWindow++;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
        String s = "zoomlazapzo";
        String p = "oza";
        System.out.println("Output: " + minWindow(s, p));
    }
}
