package zoho_problems;

public class MiddlePattern {

    public static void printPattern(String s) {
        int n = s.length();
        int mid = n / 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = (mid + i) % n;
            result.append(s.charAt(index));
            System.out.print(result + "$ ");
        }
        System.out.print("");
    }

    public static void main(String[] args) {
        String s = "PROGRAM";
        printPattern(s);
    }
}
