package zoho_problems;

public class DigitExtraction {

    public static boolean extractAFromB(int a, int b) {
        if (a == b) return true;
        a = Math.abs(a);
        b = Math.abs(b);
        int divisor = 1;
        int tempB = b;
        while (tempB > 0) {
            divisor *= 10;
            tempB /= 10;
        }
        while (a >= b) {
            if (a % divisor == b) return true;
            a /= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 1234;
        int b = 23;
        System.out.println("Output: " + extractAFromB(a, b));
    }
}
