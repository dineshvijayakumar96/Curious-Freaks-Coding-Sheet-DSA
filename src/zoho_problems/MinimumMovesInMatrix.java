package zoho_problems;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovesInMatrix {

    public static class Cell {
        int row;
        int col;
        int distance;
        public Cell(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static int minMoves(int[][] matrix) {
        int n = matrix.length;
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    queue.add(new Cell(i, j, 0));
                    visited[i][j] = true;
                    break;
                }
            }
        }
        int[] rowOffsets = { -1, 1, 0, 0 };
        int[] colOffsets = { 0, 0, -1, 1 };
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            if (matrix[current.row][current.col] == 2) {
                return current.distance;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = current.row + rowOffsets[i];
                int newCol = current.col + colOffsets[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n
                        && !visited[newRow][newCol] && matrix[newRow][newCol] != 0) {
                    visited[newRow][newCol] = true;
                    queue.add(new Cell(newRow, newCol, current.distance + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = { {0 , 3 , 2}, {3 , 3 , 0}, {1 , 3 , 0} };
        System.out.println("Output: " + minMoves(matrix));
    }
}
