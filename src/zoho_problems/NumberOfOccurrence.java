package zoho_problems;

public class NumberOfOccurrence {

    public static int countFreq(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 2, 3 };
        int target = 2;
        System.out.println("Output: " + countFreq(arr, target));
    }
}
