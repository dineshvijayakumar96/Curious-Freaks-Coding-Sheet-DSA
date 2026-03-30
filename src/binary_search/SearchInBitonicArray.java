package binary_search;

public class SearchInBitonicArray {

    public static int findB(int[] A, int B) {
        int peak = findPeek(A);
        int indexOfB = binarySearch(A, 0, peak, B);
        if (indexOfB == -1) {
            return binarySearch(A, peak, A.length - 1, B);
        } else {
            return indexOfB;
        }
    }

    public static int findPeek(int[] arr) {
        if (arr.length == 1) return 0;
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            //Left Half
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            } else { //Right Half
                low = mid + 1;
            }
        }
        return low;
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {
        boolean isAsc = arr[low] < arr[high];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = { 1, 20, 50, 40, 10 };
        int B = 5;
        System.out.println("Output: " + findB(A, B));
    }
}
