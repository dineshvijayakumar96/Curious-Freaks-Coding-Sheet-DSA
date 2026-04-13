package zoho_problems;

public class MissingInArray {

    public static int missingNum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length + 1;
        long expectedSum = (long) n * (n + 1) / 2;
        long currentSum = 0;
        for (int num : arr) {
            currentSum += num;
        }
        return (int) (expectedSum - currentSum);
    }

    public static void main(String[] args) {
        int[] arr = { 8, 2, 4, 5, 3, 7, 1 };
        System.out.println("Output: " + missingNum(arr));
    }
}
