package zoho_problems;

public class CheckIfAStringIsSubsequenceOfOther {

    public static boolean isSubSeq(String s1, String s2) {
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < s1.length() && pointer2 < s2.length()) {
            if (s1.charAt(pointer1) == s2.charAt(pointer2)) {
                pointer1++;
            }
            pointer2++;
        }
        return pointer1 == s1.length();
    }

    public static void main(String[] args) {
        String s1 = "AXY";
        String s2 = "YADXCP";
        System.out.println("Output: " + isSubSeq(s1, s2));
    }
}
