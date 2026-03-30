package recursion;

public class ImplementAtoi {

    public static int atoi(String s) {
        if (s.isEmpty()) return 0;
        int i = 0;
        int n = s.length();
        for (int j = i; j <= n; j++) {
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }
        if (i == n) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        return (int) atoiMethod(s, i, sign, 0);
    }

    public static long atoiMethod(String s, int i, int sign, long result) {
        if (i >= s.length() || s.charAt(i) < '0' || s.charAt(i) > '9') {
            return result * sign;
        }
        int digit = s.charAt(i) - '0';
        result = (result * 10) + digit;
        if (sign == 1 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && -result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return atoiMethod(s, i + 1, sign, result);
    }

    public static void main(String[] args) {
        String s = "-999999999999";
        System.out.println("Output: " + atoi(s));
    }
}
