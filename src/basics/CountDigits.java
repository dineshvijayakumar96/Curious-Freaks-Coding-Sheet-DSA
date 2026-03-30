package basics;

public class CountDigits {

    public static int find(int n) {

        int result = 0;
        String numbers = String.valueOf(n);

        for (int i = 0; i < numbers.length(); i++) {

            if (numbers.charAt(i) == '0') {

            } else if (n % (numbers.charAt(i) - '0') == 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int n = 20;
        int n2 = 2446;

        System.out.println("Output: " + find(n));
    }
}
