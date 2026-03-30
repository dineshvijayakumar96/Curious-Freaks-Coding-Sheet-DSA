package basics;

public class GCD_OfTwoNumbers {

    public static int calculateGCD(int a, int b) {

        while (b != 0) {
            int temp = Math.min(a, b);
            b = Math.max(a, b) % temp;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {

        int a = 20;
        int b = 28;

        System.out.println("Output: " + calculateGCD(a, b));
    }
}
