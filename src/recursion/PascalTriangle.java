package recursion;

import java.util.ArrayList;

public class PascalTriangle {

    public static ArrayList<Integer> pascalInitialize(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int R = n - 1;
        getNthRow(0, 1, R, list);
        return list;
    }

    public static void getNthRow(int i, long previous, int R, ArrayList<Integer> list) {
        if (i > R) {
            return;
        }
        list.add((int) previous);
        long current = previous * (R - i) / (i + 1);
        getNthRow(i + 1, current, R, list);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Output: " + pascalInitialize(n));
    }
}
