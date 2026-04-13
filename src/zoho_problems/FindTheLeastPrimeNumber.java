package zoho_problems;

import java.util.Arrays;

public class FindTheLeastPrimeNumber {

    public static int[] findLeastPrimes(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) return new int[0];
        int n = A.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int a = A[i];
            int b = B[i];
            int leastPrime = -1;
            for (int j = 1; j < 1000; j++) {
                if ((a + j) % b == 0 && isPrime(j)) {
                    leastPrime = j;
                    break;
                }
            }
            result[i] = leastPrime;
        }
        return result;
    }

    private static boolean isPrime(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;
        if (n == 2) return true;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = { 20, 7 };
        int[] B = { 11, 5 };
        System.out.println(Arrays.toString(findLeastPrimes(A, B)));
    }
}
