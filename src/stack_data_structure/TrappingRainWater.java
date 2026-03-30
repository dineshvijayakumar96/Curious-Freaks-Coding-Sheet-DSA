package stack_data_structure;

public class TrappingRainWater {

    public static int maxWater(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int leftMax = arr[left];
        int rightMax = arr[right];
        int maxWater = 0;
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    maxWater += (leftMax - arr[left]);
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    maxWater += (rightMax - arr[right]);
                }
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 0, 4, 0, 2 };
        System.out.println("Output: " + maxWater(arr));
    }
}
