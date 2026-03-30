package sliding_window;

public class CountOccurencesOfAnagrams {

    public static int search(String txt, String pat) {
        int k = pat.length();
        int n = txt.length();
        if (n < k) return 0;
        int[] patFrequency = new int[26];
        int[] windowFrequency = new int[26];
        for (int i = 0; i < k; i++) {
            patFrequency[pat.charAt(i) - 'a']++;
            windowFrequency[txt.charAt(i) - 'a']++;
        }
        int count = 0;
        if (isEqual(patFrequency, windowFrequency)) {
            count++;
        }
        for (int i = k; i < n; i++) {
            windowFrequency[txt.charAt(i) - 'a']++;
            windowFrequency[txt.charAt(i - k) - 'a']--;
            if (isEqual(patFrequency, windowFrequency)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isEqual(int[] patFrequency, int[] windowFrequency) {
        for (int i = 0; i < patFrequency.length; i++) {
            if (patFrequency[i] != windowFrequency[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.printf("Output: " + search(txt, pat));
    }
}
