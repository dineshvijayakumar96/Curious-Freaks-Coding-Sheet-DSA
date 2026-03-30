package array;

public class TrappingRainWater {

    public static int trapRainWater(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int left = 0, right = arr.length - 1, maxLeft = 0, maxRight = 0, water = 0;
        while (left <= right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > maxLeft) {
                    maxLeft = arr[left];
                } else {
                    water += maxLeft - arr[left];
                }
                left++;
            } else {
                if (arr[right] > maxRight) {
                    maxRight = arr[right];
                } else {
                    water += maxRight - arr[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 0, 4, 0, 2};
        System.out.println("Output: " + trapRainWater(arr));
    }
}
