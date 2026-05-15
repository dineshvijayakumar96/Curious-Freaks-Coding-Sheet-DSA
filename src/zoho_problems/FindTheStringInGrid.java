package zoho_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheStringInGrid {

    private static final int[] directionX = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] directionY = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static int[][] searchWord(char[][] grid, String word) {
        int row = grid.length;
        int col = grid[0].length;
        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (checkAllDirections(grid, r, c, word)) {
                    list.add(new int[]{r, c});
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    private static boolean checkAllDirections(char[][] grid, int r, int c, String word) {
        if (grid[r][c] != word.charAt(0)) return false;
        int n = grid.length;
        int m = grid[0].length;
        int len = word.length();
        for (int direction = 0; direction < 8; direction++) {
            int k;
            int currentRow = r + directionX[direction];
            int currentCol = c + directionY[direction];
            for (k = 1; k < len; k++) {
                if (currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= m) break;
                if (grid[currentRow][currentCol] != word.charAt(k)) break;
                currentRow += directionX[direction];
                currentCol += directionY[direction];
            }
            if (k == len) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'a','b','c'},
                {'d','r','f'},
                {'g','h','i'}
        };
        String word = "abc";
        System.out.println("Output: " + Arrays.deepToString(searchWord(grid, word)));
    }
}
