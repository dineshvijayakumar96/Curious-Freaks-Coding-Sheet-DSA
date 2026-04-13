package zoho_problems;

public class WordBreak {

    public static boolean wordBreak(String s, String[] dictionary) {
        if (s == null || s.isEmpty()) return false;
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : dictionary) {
                int len = word.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "ilike";
        String[] dictionary = { "i", "like", "gfg" };
        System.out.println("Output: " + wordBreak(s, dictionary));
    }
}
