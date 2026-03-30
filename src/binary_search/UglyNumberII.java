package binary_search;

public class UglyNumberII {

    public static int findNthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;
        for (int i = 1; i < n; i++) {
            int multipleTwo =  2 * dp[pointer1];
            int multipleThree = 3 * dp[pointer2];
            int multipleFive =  5 * dp[pointer3];
            dp[i] = Math.min(multipleTwo, Math.min(multipleThree, multipleFive));
            if (dp[i] == multipleTwo) pointer1++;
            if (dp[i] == multipleThree) pointer2++;
            if (dp[i] == multipleFive) pointer3++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Output: " + findNthUglyNumber(n));
    }
}
