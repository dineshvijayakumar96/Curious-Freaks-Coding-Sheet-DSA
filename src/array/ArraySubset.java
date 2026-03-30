package array;

import java.util.Hashtable;

public class ArraySubset {

    public static boolean isSubset(int[] a, int[] b) {

        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int j : a) {
            if (table.containsKey(j)) {
                table.put(j, table.get(j) + 1);
            } else {
                table.put(j, 1);
            }
        }
        for (int j : b) {
            if (table.get(j) == null) return false;
            if (table.get(j) >= 1) {
                table.put(j, table.get(j) - 1);
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};
        System.out.println("Output: " + isSubset(a, b));
    }
}
