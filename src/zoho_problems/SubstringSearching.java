package zoho_problems;

public class SubstringSearching {

    public static int searchIndex(String hayStack, String needle) {
        if (hayStack.isEmpty() || needle.isEmpty()) return -1;
        int n = hayStack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                if (needle.charAt(j) == hayStack.charAt(i + j)) {
                    if (j == m - 1) return i;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String hayStack = "mississippi";
        String needle = "issip";
        System.out.println("Output: " + searchIndex(hayStack, needle));
    }
}
