package basics;

public class PrimeNumber {

    public static boolean isPrime(int n) {

        // n % n == 0 and n % 1 == 0, so count = 2
        int count = 2;

        if (n == 1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int n = 7;
        System.out.println("Output: " + isPrime(n));
    }
}
