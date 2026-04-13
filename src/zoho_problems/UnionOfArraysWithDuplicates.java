package zoho_problems;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionOfArraysWithDuplicates {

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }
        for (int num : b) {
            set.add(num);
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int[] b = { 4, 5, 6 };
        System.out.println("Output: " + findUnion(a, b));
    }
}
