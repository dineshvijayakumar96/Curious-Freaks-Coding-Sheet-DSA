package basics;

public class Palindrome {

    public static boolean isPalindrome(int n) {

        if (n < 0) return false;
        if (n < 10) return true;

        char[] arr = String.valueOf(n).toCharArray();

        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        String output = String.valueOf(arr);

        return Integer.parseInt(output) == n;
    }

    public static void main(String[] args) {

        int n = 1221;
        System.out.println("Output: " + isPalindrome(n));
    }
}
