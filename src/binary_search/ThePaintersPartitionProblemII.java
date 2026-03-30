package binary_search;

public class ThePaintersPartitionProblemII {

    public static int findMinMax(int[] arr,int k) {
        long low = 0;
        long high = 0;
        for (int i = 0; i < arr.length; i++) {
            high += arr[i];
            if (arr[i] > low) {
                low = arr[i];
            }
        }
        long result = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            int noOfPainters = findNoOfPainters(arr, mid);
            if (noOfPainters > k) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return (int) result;
    }

    public static int findNoOfPainters(int[] arr, long mid) {
        int noOfPainters = 1;
        long timePerPainter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (timePerPainter + arr[i] <= mid) {
                timePerPainter += arr[i];
            } else {
                noOfPainters++;
                timePerPainter = arr[i];
            }
        }
        return noOfPainters;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 200, 300, 400 };
        int k = 1;
        System.out.println("Output: " + findMinMax(arr, k));
    }
}
