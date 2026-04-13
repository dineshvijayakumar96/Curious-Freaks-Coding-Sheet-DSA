package zoho_problems;

public class MinimumMovesToConvertString {

    public static int minimumMoves(String s) {
        if (s == null || s.isEmpty()) return 0;
        int moves = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == 'X') {
                moves++;
                index += 3;
            } else {
                index++;
            }
        }
        return moves;
    }

    public static void main(String[] args) {
        String s = "XXOX";
        System.out.println("Output: " + minimumMoves(s));
    }
}
