package zoho_problems;

import java.util.ArrayList;
import java.util.HashSet;

public class UniqueRowsInBooleanMatrix {

    public static ArrayList<ArrayList<Integer>> uniqueRow(int[][] a, int r, int c) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> seen = new HashSet<>();
        for (int i = 0; i < r; i++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                currentRow.add(a[i][j]);
            }
            if (seen.add(currentRow)) {
                result.add(currentRow);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = { {1, 1, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 1} };
        int r = a.length;
        int c = a[0].length;
        System.out.println("Output: " + uniqueRow(a, r, c));
    }
}
