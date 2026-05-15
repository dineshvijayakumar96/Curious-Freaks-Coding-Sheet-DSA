package zoho_problems;

public class KnapsackProblem {

    public static int knapsack(int W, int[] val, int[] wt) {
        int n = val.length;
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int W = 4;
        int[] val = { 1, 2, 3 };
        int[] wt = { 4, 5, 1 };
        System.out.println("Output: " + knapsack(W, val, wt));
    }
}
