package stack_data_structure;

import java.util.Stack;

public class MaxRectangle {

    public static int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] height = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) height[j]++;
                else height[j] = 0;
            }
            int area = maxRectangle(height);
            max = Math.max(area, max);
        }
        return max;
    }

    private static int maxRectangle(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= arr.length; i++) {
            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
                int height = arr[stack.peek()];
                stack.pop();
                int width;
                if (stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] mat = { {0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0} };
        System.out.println("Output: " + maxArea(mat));
    }
}
