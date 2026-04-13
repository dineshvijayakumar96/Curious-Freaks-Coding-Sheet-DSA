package zoho_problems;

public class CheckFoSubsequence {

    public static boolean isSubSequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        if (m < n) return false;
        int pointerA = 0;
        int PointerB = 0;
        while (pointerA < n && PointerB < m) {
            if (A.charAt(pointerA) == B.charAt(PointerB)) {
                pointerA++;
            }
            PointerB++;
        }
        return pointerA == n;
    }

    public static void main(String[] args) {
        String A = "gksrek";
        String B = "geeksforgeeks";
        System.out.println("Output: " + isSubSequence(A, B));
    }
}
