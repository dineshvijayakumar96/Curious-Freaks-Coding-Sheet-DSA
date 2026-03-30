package array;

public class KThElementOfTwoArrays {

    public static int kThElement(int[] a, int[] b, int k) {
        if (a.length == 0 && b.length > 0) return b[k - 1];
        if (b.length == 0 && a.length > 0) return a[k - 1];
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, kThElement = 0;
        for (int count = 0; count < k; count++) {
            if (i == a.length) {
                kThElement = b[j++];
            } else if (j == b.length) {
                kThElement = a[i++];
            } else if (a[i] < b[j]) {
                kThElement = a[i++];
            } else {
                kThElement = b[j++];
            }
        }
        return kThElement;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;
        System.out.println("Output: " + kThElement(a, b, k));
    }
}
