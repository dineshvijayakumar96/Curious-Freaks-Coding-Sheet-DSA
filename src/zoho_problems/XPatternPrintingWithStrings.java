package zoho_problems;

public class XPatternPrintingWithStrings {

    public static void printXPattern(String s) {
        if (s == null || s.isEmpty()) return;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || i + j == len - 1) {
                    System.out.print(s.charAt(j));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "PROGRAM";
        System.out.println("Output:");
        printXPattern(s);
    }
}
