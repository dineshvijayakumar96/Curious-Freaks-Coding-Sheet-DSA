package sliding_window;

import java.util.HashSet;

public class SubarrayWith0Sum {

    public static boolean findsum(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) return true;
            if (set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        System.out.println("Output: " + findsum(arr));
    }
}
