package zoho_problems;

public class EquilibriumPoint {

    public static int findEquilibrium(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int leftSum = 0;
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        for (int i = 0; i < n - 1; i++) {
            if (leftSum == (totalSum - leftSum - arr[i])) return i;
            leftSum += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println("Output: " + findEquilibrium(arr));
    }
}
