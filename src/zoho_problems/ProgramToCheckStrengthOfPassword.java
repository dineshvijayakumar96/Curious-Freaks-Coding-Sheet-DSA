package zoho_problems;

public class ProgramToCheckStrengthOfPassword {

    public static String isStrongPassword(String input) {
        int len = input.length();
        if (input.isEmpty()) return "Invalid";
        boolean containsLower = false;
        boolean containsUpper = false;
        boolean containsDigit = false;
        boolean containsSpecial = false;
        String special = "!@#$%^&*()-+";
        for (char character : input.toCharArray()) {
            if (Character.isLowerCase(character)) {
                containsLower = true;
            } else if (Character.isUpperCase(character)) {
                containsUpper = true;
            } else if (Character.isDigit(character)) {
                containsDigit = true;
            } else if (special.indexOf(character) != -1) {
                containsSpecial = true;
            }
        }
        if (containsLower && containsUpper && containsDigit && containsSpecial && len >= 8) {
            return "Strong";
        } else if (containsLower && containsUpper && containsSpecial && len >= 6) {
            return "Moderate";
        }
        return "Weak";
    }

    public static void main(String[] args) {
        String input = "GeeksforGeeks!@12";
        System.out.println("Output: " + isStrongPassword(input));
    }
}
