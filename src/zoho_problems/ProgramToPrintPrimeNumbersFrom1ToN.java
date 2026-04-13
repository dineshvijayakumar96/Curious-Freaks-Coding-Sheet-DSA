package zoho_problems;

import java.util.Arrays;

public class ProgramToPrintPrimeNumbersFrom1ToN {

    public static void printPrimeNumbers(int n) {
        if (n < 2) return;
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.print("Output: ");
        printPrimeNumbers(n);
    }
}
