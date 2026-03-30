package sliding_window;

public class SmallestWindowContaining01And2 {

    public static int smallestSubstring(String S) {
        int last0 = -1;
        int last1 = -1;
        int last2 = -1;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < S.length(); i++) {
            char currentCharacter = S.charAt(i);
            if (currentCharacter == '0') last0 = i;
            if (currentCharacter == '1') last1 = i;
            if (currentCharacter == '2') last2 = i;

            if (last0 != -1 && last1 != -1 && last2 != -1) {
                int leftBoundary = Math.min(last0, Math.min(last1, last2));
                int currentLength = i - leftBoundary + 1;
                minLength = Math.min(minLength, currentLength);
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        String S = "10212";
        System.out.println("Output: " + smallestSubstring(S));
    }
}
