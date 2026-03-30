package recursion;

public class Pow_X_N {

    public static double myPow(double x, int n) {
        return powOfXN(x, (long) n);
    }

    public static double powOfXN(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1 /  powOfXN(x, -n);
        if (n % 2 == 0) {
            double f = powOfXN(x, n/2);
            return f * f;
        }
        return x * powOfXN(x, n - 1);
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println("Output: " + myPow(x, n));
    }
}
