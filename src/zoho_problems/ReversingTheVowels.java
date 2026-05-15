package zoho_problems;

public class ReversingTheVowels {

    public static String modify(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        char[] arr = s.toCharArray();
        while (left < right) {
            if (!isVowel(arr[left])) {
                left++;
            } else if (!isVowel(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println("Output: " + modify(s));
    }
}
