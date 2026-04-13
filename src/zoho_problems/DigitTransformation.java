package zoho_problems;

public class DigitTransformation {

    public static String transformNumber(int number, int digit) {
        if (digit == 0) return "";
        StringBuilder result = new StringBuilder();
        addDigit(number, digit, result);
        return result.toString();
    }

    private static void addDigit(int number, int digit, StringBuilder result) {
        if (number == 0) return;
        addDigit(number / 10, digit, result);
        int currentDigit = number % 10;
        int currentSum = currentDigit + digit;
        result.append(currentSum);
    }

    public static void main(String[] args) {
        int number = 2875;
        int digit = 4;
        System.out.println("Output: " + transformNumber(number, digit));
    }
}
