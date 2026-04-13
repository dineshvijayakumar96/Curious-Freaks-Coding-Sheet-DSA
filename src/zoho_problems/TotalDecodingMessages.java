package zoho_problems;

public class TotalDecodingMessages {

    public static int countWays(String digits) {
        if (digits == null || digits.isEmpty() || digits.charAt(0) == '0') return 0;
        int n = digits.length();
        int modulo = 1000000007;
        int previous2 = 1;
        int previous1 = 1;
        for (int i = 1; i < n; i++) {
            int currentWays = 0;
            if (digits.charAt(i) != '0') {
                currentWays = previous1;
            }
            int twoDigitValue = (digits.charAt(i - 1) - '0') * 10 + (digits.charAt(i) - '0');
            if (twoDigitValue >= 10 && twoDigitValue <= 26) {
                currentWays = (currentWays + previous2) % modulo;
            }
            if (currentWays == 0) return 0;
            previous2 = previous1;
            previous1 = currentWays;
        }
        return previous1;
    }

    public static void main(String[] args) {
        String digits = "123";
        System.out.println("Output: " + countWays(digits));
    }
}
