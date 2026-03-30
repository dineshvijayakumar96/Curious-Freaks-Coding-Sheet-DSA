package basics;

public class PerfectNumbers {

    public static boolean isPerfectNumber(int n) {

        if (n <= 1) return false;

        int sum = 1;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;

                if ((n / i) != i) {
                    sum += n / i;
                }
            }
        }

        return sum == n;
    }

    public static void main(String[] args) {

        int n = 6;
        System.out.println("Output: " + isPerfectNumber(n));
    }
}
