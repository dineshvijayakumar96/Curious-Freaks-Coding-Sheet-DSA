package array;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static int[] primeNumbers(int n) {
        if (n < 2) return new int[0];
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeCount++;
            }
        }
        int[] primeArray = new int[primeCount];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeArray[index++] = i;
            }
        }
        return primeArray;
    }

    public static void main(String[] args) {
        int n = 35;
        System.out.println("Output: " + Arrays.toString(primeNumbers(n)));
    }
}
