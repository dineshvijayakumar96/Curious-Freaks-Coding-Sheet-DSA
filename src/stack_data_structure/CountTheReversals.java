package stack_data_structure;

public class CountTheReversals {

    public static int countMinReversals(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }
        int leftBraces = 0;
        int rightBraces = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                leftBraces++;
            } else if (s.charAt(i) == '}') {
                if (leftBraces > 0) {
                    leftBraces--;
                } else {
                    rightBraces++;
                }
            }
        }
        int reversals = (leftBraces + 1) / 2 + (rightBraces + 1) / 2;
        return reversals;
    }

    public static void main(String[] args) {
        String s = "{{}{{{}{{}}{{";
        System.out.println("Output: " + countMinReversals(s));
    }
}
