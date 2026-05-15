package zoho_problems;

public class SumOfTwoLargeNumbers {

    public static String findSum(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = (i >= 0) ? s1.charAt(i--) - '0' : 0;
            int d2 = (j >= 0) ? s2.charAt(j--) - '0' : 0;
            int sum = d1 + d2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        result.reverse();
        int k = 0;
        while (k < result.length() - 1 && result.charAt(k) == '0') {
            k++;
        }
        return result.substring(k);
    }

    public static void main(String[] args) {
        String s1 = "25";
        String s2 = "23";
        System.out.println("Output: " + findSum(s1, s2));
    }
}
