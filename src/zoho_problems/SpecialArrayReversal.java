package zoho_problems;

public class SpecialArrayReversal {

    public static String reverse(String s) {
        if (s.isEmpty()) return "";
        int n = s.length();
        char[] arr = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            if (!Character.isLetter(s.charAt(left))) {
                left++;
            } else if (!Character.isLetter(s.charAt(right))) {
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
        String s = "A&x#";
        System.out.println("Output: " + reverse(s));
    }
}
