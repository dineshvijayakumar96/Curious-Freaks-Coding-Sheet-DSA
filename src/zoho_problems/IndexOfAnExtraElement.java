package zoho_problems;

public class IndexOfAnExtraElement {

    public static int findExtra(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) return -1;
        int low = 0;
        int high = b.length - 1;
        int result = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == b[mid]) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = { 2,4,6,8,9,10,12 };
        int[] b = { 2,4,6,8,10,12 };
        System.out.println("Output: " + findExtra(a, b));
    }
}
