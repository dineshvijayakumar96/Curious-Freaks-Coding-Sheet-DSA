package array;

import java.util.Arrays;

public class CountTheTriplets {

    public static int countTriplets(int[] arr) {
        if (arr == null || arr.length < 3) return 0;
        Arrays.sort(arr);
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int low = 0, high = i - 1;
            while (low < high) {
                int sum = arr[low] + arr[high];
                if (sum == arr[i]) {
                    count++;
                    low++;
                    high--;
                } else if (sum > arr[i]) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {9562, 21353, 18168, 27396, 23272, 11927, 25386, 10625, 4474, 13056, 25293, 29752, 940, 22434, 11387, 29876, 23790, 25086, 22591, 26908, 4056, 13085, 22674, 31065, 26302, 26065, 12169, 26491, 643, 8765, 1100, 8025, 15282, 19095, 11466, 27000, 6602, 25901, 32683, 17711, 21722, 26534, 646, 11784, 5454, 18315, 18517, 20584, 26121, 29702, 5158, 29043, 3252, 7401, 5139, 3626, 15445, 27377, 18547, 30166, 22051, 3405, 27474, 25514, 11417, 16474, 27679, 23460, 31945, 12721, 21413, 20148, 4595, 25955, 9277, 18976, 18262, 131, 2625, 13863, 23622, 7397, 28867, 26597, 20095, 2598, 20095, 2678, 11961, 8172, 16143, 9054, 9084, 1391, 15454, 13864, 3638};
        //int[] arr = {2, 3, 4};
        System.out.println("Output: " + countTriplets(arr));
    }
}
