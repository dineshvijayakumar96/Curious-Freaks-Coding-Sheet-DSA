package basics;

public class ArmstrongNumbers {

    public static boolean isArmstrong(int n) {

        if (n >= 100 && n < 1000) {

            char[] arr = String.valueOf(n).toCharArray();
            int sum = 0;

            for (char c : arr) {
                sum += ((c - '0') * (c - '0') * (c - '0'));
            }

            return sum == n;
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 372;
        System.out.println("Output: " + isArmstrong(n));
    }
}
