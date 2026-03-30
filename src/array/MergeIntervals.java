package array;

import java.util.Arrays;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int left = 0;
        for (int right = 1; right < intervals.length; right++) {
            if (intervals[right][0] <= intervals[left][1]) {
                intervals[left][1] = Math.max(intervals[left][1], intervals[right][1]);
                if (intervals[left][0] > intervals[right][0]) {
                    intervals[left][0] = intervals[right][0];
                }
            } else {
                left++;
                intervals[left] = intervals[right];
            }
        }
        return Arrays.copyOf(intervals, left + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2,4}, {3,5}};
        System.out.println("Output: " + Arrays.deepToString(merge(intervals)));
    }
}
