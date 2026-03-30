package sliding_window;

public class SubstringsOfLengthKWithK1DistinctElements {

    public static int substrCount(String s, int k) {
        if (s.length() < k) return 0;
        int[] elementCount = new int[26];
        int distinctCount = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            int charIndex = s.charAt(i) - 'a';
            if (elementCount[charIndex] == 0) {
                distinctCount++;
            }
            elementCount[charIndex]++;
        }
        if (distinctCount == (k - 1)) count++;
        for (int i = k; i < s.length(); i++) {
            int outGoingIndex = s.charAt(i - k) - 'a';
            elementCount[outGoingIndex]--;
            if (elementCount[outGoingIndex] == 0) {
                distinctCount--;
            }
            int inComingIndex  = s.charAt(i) - 'a';
            if (elementCount[inComingIndex] == 0) {
                distinctCount++;
            }
            elementCount[inComingIndex]++;
            if (distinctCount == (k - 1)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aabab";
        int k = 3;
        System.out.println("Output: " + substrCount(s, k));
    }
}
