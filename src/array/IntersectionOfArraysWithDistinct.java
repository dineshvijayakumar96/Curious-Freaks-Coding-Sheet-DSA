package array;

import java.util.HashSet;

public class IntersectionOfArraysWithDistinct {

    public static int intersect(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (set.contains(b[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {89, 24, 75, 11, 23};
        int[] b = {89, 2, 4};
        System.out.println("Output: " + intersect(a, b));
    }
}
