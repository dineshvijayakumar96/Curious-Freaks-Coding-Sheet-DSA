package zoho_problems;

public class QueenMoves {

    public static int countMoves(int n, int r_q, int c_q, int[][] obstacles) {
        int d1 = n - r_q;
        int d2 = r_q - 1;
        int d3 = n - c_q;
        int d4 = c_q - 1;
        int d5 = Math.min(d1, d3);
        int d6 = Math.min(d1, d4);
        int d7 = Math.min(d2, d3);
        int d8 = Math.min(d2, d4);
        for (int[] obs : obstacles) {
            int r_o = obs[0];
            int c_o = obs[1];
            if (c_o == c_q) {
                if (r_o > r_q) d1 = Math.min(d1, r_o - r_q - 1);
                else d2 = Math.min(d2, r_q - r_o - 1);
            }
            else if (r_o == r_q) {
                if (c_o > c_q) d3 = Math.min(d3, c_o - c_q - 1);
                else d4 = Math.min(d4, c_q - c_o - 1);
            }
            else if (Math.abs(r_o - r_q) == Math.abs(c_o - c_q)) {
                if (r_o > r_q && c_o > c_q) d5 = Math.min(d5, r_o - r_q - 1);
                else if (r_o > r_q && c_o < c_q) d6 = Math.min(d6, r_o - r_q - 1);
                else if (r_o < r_q && c_o > c_q) d7 = Math.min(d7, r_q - r_o - 1);
                else if (r_o < r_q) d8 = Math.min(d8, r_q - r_o - 1);
            }
        }
        return d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8;
    }

    public static void main(String[] args) {
        int n = 8, r_q = 4, c_q = 4;
        int[][] obstacles = {{3, 5}};
        System.out.println("Output: " + countMoves(n, r_q, c_q, obstacles));
    }
}
