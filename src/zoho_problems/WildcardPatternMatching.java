package zoho_problems;

public class WildcardPatternMatching {

    public static boolean wildCard(String txt, String pat) {
        int m = txt.length();
        int n = pat.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pat.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pChar = pat.charAt(i - 1);
                char tChar = txt.charAt(j - 1);
                if (pChar == tChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String txt = "ugegjtw";
        String pat = "u?*???**";
        System.out.println("Output: " + wildCard(txt, pat));
    }
}
