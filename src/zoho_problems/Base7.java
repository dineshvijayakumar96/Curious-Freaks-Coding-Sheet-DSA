package zoho_problems;

public class Base7 {

    public static String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();
        int n = Math.abs(num);
        while (n > 0) {
            result.append(n % 7);
            n = n / 7;
        }
        if (num < 0) result.append("-");
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 100;
        System.out.println("Output: " + convertToBase7(num));
    }
}
