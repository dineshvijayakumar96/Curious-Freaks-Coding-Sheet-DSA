package zoho_problems;

public class CheckIfTheSentenceIsPangram {

    public static boolean checkIfPangram(String sentence) {
        if (sentence == null || sentence.length() < 26) return false;
        boolean[] frequency = new boolean[26];
        int count = 0;
        for (char c : sentence.toCharArray()) {
            int index = c - 'a';
            if (!frequency[index]) {
                frequency[index] = true;
                count++;
            }
            if (count == 26) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println("Output: " + checkIfPangram(sentence));
    }
}
