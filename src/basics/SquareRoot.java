package basics;

public class SquareRoot {

    public static int findPerfectSquare(int n) {

        int squareNumber = 0;

        if (n == 1) return 1;

        for (int i = 1; i <= n / 2; i++) {
            if (i * i == n) return i;
            if ((i * i < n) && (squareNumber <= n / 2)) squareNumber = i;
        }

        return squareNumber;
    }

    public static void main(String[] args) {

        int n = 1;
        System.out.println("Output: " + findPerfectSquare(n));
    }
}
