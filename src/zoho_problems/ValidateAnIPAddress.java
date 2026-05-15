package zoho_problems;

public class ValidateAnIPAddress {

    public static boolean isValid(String s) {
        int len = s.length();
        int countDot = 0;
        if (s.charAt(0) == '.' && s.charAt(len - 1) == '.') return false;
        StringBuilder ip = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '.') {
                countDot++;
                if (!isValidNumber(ip.toString())) return false;
                ip.setLength(0);
            } else if (Character.isDigit(c)) {
                ip.append(c);
            } else  {
                return false;
            }
        }
        return countDot == 3 && isValidNumber(ip.toString());
    }

    private static boolean isValidNumber(String num) {
        if (num.isEmpty() || num.length() > 3) return false;
        if (num.length() > 1 && num.charAt(0) == '0') return false;
        int val = 0;
        for (int i = 0; i < num.length(); i++) {
            val = val * 10 + num.charAt(i) - '0';
        }
        return val >= 0 && val <= 255;
    }

    public static void main(String[] args) {
        String s = "0.0.0.255";
        System.out.println("Output: " + isValid(s));
    }
}
