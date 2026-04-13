package zoho_problems;

public class TwistedPrimeNumber {

    public static int isTwistedPrime(int N) {
        if (N < 2) return 0;
        if (isPrime(N)) {
            long reverse = 0;
            long target = N;
            while (target > 0) {
                reverse = reverse * 10 + target % 10;
                target = target / 10;
            }
            if (isPrime(reverse)) return 1;
        }
        return 0;
    }

    private static boolean isPrime(long N) {
        if (N == 2) return true;
        if (N % 2 == 0) return false;
        for (long i = 3; i * i <= N; i += 2) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 97;
        System.out.println("Output: " + isTwistedPrime(N));
    }
}
