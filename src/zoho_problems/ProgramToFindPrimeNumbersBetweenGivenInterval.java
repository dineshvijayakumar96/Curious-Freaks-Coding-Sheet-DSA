package zoho_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramToFindPrimeNumbersBetweenGivenInterval {

    public static int[] findPrimeNumbers(int m, int n) {
        if(m > n || n < 2) return new int[0];
        boolean[] possiblePrimeNumbers = primeNumbers(n);
        List<Integer> primes = new ArrayList<>();
        int start = Math.max(m, 2);
        for (int i = start; i <= n; i++) {
            if (possiblePrimeNumbers[i]) {
                primes.add(i);
            }
        }
        int[] result = new int[primes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = primes.get(i);
        }
        return result;
    }

    private static boolean[] primeNumbers(int n) {
        boolean[] result = new boolean[n + 1];
        Arrays.fill(result, true);
        result[0] = false;
        result[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (result[i]) {
                for (int j = i * i; j <= n; j += i) {
                    result[j] = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int m = 1;
        int n = 10;
        System.out.println("Output: " + Arrays.toString(findPrimeNumbers(m, n)));
    }
}
