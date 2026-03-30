package array;

public class MissingInArray {

    public static int findMissingNumber(int[] arr) {

        long totalSum = (long) (arr.length + 1) * ((arr.length + 1) + 1) / 2;
        long actualSum = 0;
        for (int j : arr) {
            actualSum += j;
        }
        return (int) (totalSum - actualSum);
    }

    public static void main(String[] args) {

        int[] arr = { 13, 5, 4, 10, 7, 11, 1, 9, 12, 8, 2, 6 };
        System.out.println("Output: " + findMissingNumber(arr));
    }
}
