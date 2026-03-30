package array;

import java.util.Hashtable;
import java.util.Objects;

public class CheckEqualArrays {

    public static boolean isEqual(int[] a, int[] b) {

        boolean flag = true;

        if (a.length != b.length) return false;
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Hashtable<Integer, Integer> table2 = new Hashtable<>();
        for (int j : a) {
            if (table.containsKey(j)) {
                table.put(j, table.get(j) + 1);
            } else {
                table.put(j, 1);
            }
        }
        for (int j : b) {
            if (table2.containsKey(j)) {
                table2.put(j, table2.get(j) + 1);
            } else {
                table2.put(j, 1);
            }
        }
        for (int i = 0; i < table.size(); i++) {
            if (!Objects.equals(table.get(a[i]), table2.get(a[i]))) return false;
            if (!Objects.equals(table.get(b[i]), table2.get(b[i]))) return false;
        }
        return flag;
    }

    public static void main(String[] args) {

        int[] a = {2, 0, 7, 3, 8, 2, 9, 1, 7, 2};
        int[] b = {3, 7, 5, 7, 2, 9, 8, 0, 2, 2};
        System.out.println("Output: " + isEqual(a, b));
    }
}
