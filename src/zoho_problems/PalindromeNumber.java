package zoho_problems;

public class PalindromeNumber {

    public static boolean isPalindrome(int n) {
        long reversed = 0;
        int absolute = (n < 0 ? -n : n);
        int temp = absolute;
        while (temp > 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        return absolute == reversed;
    }

    public static void main(String[] args) {
        int n = 123;
        System.out.println("Output: " + isPalindrome(n));
    }
}
