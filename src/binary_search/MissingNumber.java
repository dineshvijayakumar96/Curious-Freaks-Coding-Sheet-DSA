package binary_search;

public class MissingNumber {

    public static int findMissingNumber(int[] arr) {
        int actualSum = 0, totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            actualSum += i + 1;
        }
        return actualSum - totalSum;
    }

    public static void main(String[] args) {
        int[] arr = { 9,6,4,2,3,5,7,0,1 };
        System.out.println("Output: " + findMissingNumber(arr));
    }
}
