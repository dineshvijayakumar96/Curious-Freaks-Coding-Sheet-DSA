package binary_search;

public class AllocateMinimumPages {

    public static int findSmallestMax(int[] arr, int k) {
        if (arr.length < k) return -1;
        int low = 0, high = 0;
        for (int i = 0; i < arr.length; i++) {
            high += arr[i];
            low = Math.max(low, arr[i]);
        }
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int noOfStudents = findNoOfStudents(arr, mid);
            if (noOfStudents > k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }

    public static int findNoOfStudents(int[] arr, int maxPages) {
        int noOfStudents = 1;
        long pagesPerStudent = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pagesPerStudent + arr[i] <= maxPages) {
                pagesPerStudent += arr[i];
            } else {
                noOfStudents++;
                pagesPerStudent = arr[i];
            }
        }
        return noOfStudents;
    }

    public static void main(String[] args) {
        int[] arr = { 25, 46, 28, 49, 24 };
        int k = 4;
        System.out.println("Output: " + findSmallestMax(arr, k));
    }
}
