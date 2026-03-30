package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> findFoursum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (arr == null || arr.length < 3) return list;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int left = j + 1, right = arr.length - 1;
                while(left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(arr[i]);
                        list1.add(arr[j]);
                        list1.add(arr[left]);
                        list1.add(arr[right]);
                        list.add(list1);
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println("Output: " + findFoursum(arr, target));
    }
}
