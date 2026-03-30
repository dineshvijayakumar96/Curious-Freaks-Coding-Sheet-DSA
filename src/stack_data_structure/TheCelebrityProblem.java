package stack_data_structure;

public class TheCelebrityProblem {

    public static int celebrity(int[][] mat) {
        int candidate = 0;
        for (int i = 1; i < mat.length; i++){
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
        }
        for (int i = 0; i < mat.length; i++){
            if (i != candidate){
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[][] mat = { {1, 1, 0}, {0, 1, 0}, {0, 1, 1} };
        System.out.println("Output: " + celebrity(mat));
    }
}
