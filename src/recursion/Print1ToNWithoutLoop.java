package recursion;

public class Print1ToNWithoutLoop {

    public static void print1ToN(int n) {
        if (n == 0) return;
        print1ToN(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 10;
        print1ToN(n);
    }
}
