package zoho_problems;

public class ReversalAndSorting {

    public static String reverse(String s) {
        if (s.length() < 2) return s;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetter(arr[left])) {
                left++;
            } else if (!Character.isLetter(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String s = "a,b$cd";
        System.out.println("Output: " + reverse(s));
    }
}
