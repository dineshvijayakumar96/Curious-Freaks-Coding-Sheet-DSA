package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {

    public static ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());
        for (int i = k; i < arr.length; i++) {
            int outGoingElement = arr[i - k];
            int outGoingCount = map.get(outGoingElement);
            if (outGoingCount == 1) {
                map.remove(outGoingElement);
            } else {
                map.put(outGoingElement, outGoingCount - 1);
            }
            int incomingElement = arr[i];
            map.put(incomingElement, map.getOrDefault(incomingElement, 0) + 1);
            result.add(map.size());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4 };
        int k = 3;
        System.out.println("Output: " + countDistinct(arr, k));
    }
}
