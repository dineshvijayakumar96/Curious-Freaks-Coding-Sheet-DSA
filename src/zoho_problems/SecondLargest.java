package zoho_problems;

public class SecondLargest {

    public static int getSecondLargest(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int largest = -1;
        int secondLargest = -1;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 10, 10 };
        System.out.println("Output: " + getSecondLargest(arr));
    }
}
