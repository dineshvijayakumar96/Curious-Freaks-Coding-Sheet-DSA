package zoho_problems;

public class StringTransformation {

    private static final long MOD = 1_000_000_007;

    public static int numberOfWays(String s, String t, long k) {
        int n = s.length();
        int p = countOccurrences(s, t);
        long[][] matrix = {{0, n - 1}, {1, n - 2}};
        long[][] resMatrix = power(matrix, k);
        long ways0 = resMatrix[0][0];
        long ways1 = resMatrix[1][0];
        if (s.equals(t)) {
            return (int) ((ways0 + (p - 1) * ways1) % MOD);
        } else {
            return (int) ((p * ways1) % MOD);
        }
    }

    private static int countOccurrences(String s, String t) {
        String combined = t + "#" + s + s;
        int n = s.length();
        int[] z = new int[combined.length()];
        int count = 0;
        int l = 0, r = 0;
        for (int i = 1; i < combined.length(); i++) {
            if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);
            while (i + z[i] < combined.length() && combined.charAt(z[i]) == combined.charAt(i + z[i])) z[i]++;
            if (i + z[i] - 1 > r) {
                l = i; r = i + z[i] - 1;
            }
            // If match found within the first n shifts of s+s
            if (i > n && i <= 2 * n && z[i] >= n) {
                if (i - (n + 1) < n) count++;
            }
        }
        return count;
    }

    private static long[][] power(long[][] a, long b) {
        long[][] res = {{1, 0}, {0, 1}};
        while (b > 0) {
            if (b % 2 == 1) res = multiply(res, a);
            a = multiply(a, a);
            b /= 2;
        }
        return res;
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < 2; l++) {
                    c[i][j] = (c[i][j] + a[i][l] * b[l][j]) % MOD;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdab";
        long k = 2;
        System.out.println("Output: " + numberOfWays(s, t, k));
    }
}
