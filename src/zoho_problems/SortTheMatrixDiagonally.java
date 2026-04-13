package zoho_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortTheMatrixDiagonally {

    public static int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int key = i - j;
                map.putIfAbsent(key, new PriorityQueue<>());
                map.get(key).add(mat[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int key = i - j;
                PriorityQueue<Integer> queue = map.get(key);
                if (queue != null && !queue.isEmpty()) {
                    mat[i][j] = queue.poll();
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = { {3,3,1,1}, {2,2,1,2}, {1,1,1,2} };
        System.out.println("Output: " + Arrays.deepToString(diagonalSort(mat)));
    }
}
