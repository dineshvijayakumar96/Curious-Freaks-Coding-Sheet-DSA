package array;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionOfArraysWithDuplicates {

    public static ArrayList<Integer> union(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            set.add(b[i]);
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 2, 3, 3, 2};
        System.out.println("Output: " + union(a, b));
    }
}
