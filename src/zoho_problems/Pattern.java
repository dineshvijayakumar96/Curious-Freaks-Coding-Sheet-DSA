package zoho_problems;

public class Pattern {

    public static void printDiamond(int n) {
        if (n <= 0) return;
        int stars = 1;
        int spaces = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
            stars++;
            spaces--;
        }
        stars -= 1;
        spaces = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
            stars -= 1;
            spaces++;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        printDiamond(n);
    }
}
