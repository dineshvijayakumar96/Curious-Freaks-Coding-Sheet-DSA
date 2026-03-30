package array;

public class TripletSumInArray {

    public static boolean tripleSum(int[] arr, int target) {
        if (arr == null || arr.length < 3) return false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) return true;
                if (sum < target) left++;
                else right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 13;
        System.out.println("Output: " + tripleSum(arr, target));
    }
}
