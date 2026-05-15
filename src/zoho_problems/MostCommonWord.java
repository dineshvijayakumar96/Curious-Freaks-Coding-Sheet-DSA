package zoho_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        String cleanedParagraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = cleanedParagraph.split("\\s+");
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }
        Map<String, Integer> counts = new HashMap<>();
        String result = "";
        int maxFrequency = 0;
        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }
            int currentCount = counts.getOrDefault(word, 0) + 1;
            counts.put(word, currentCount);
            if (currentCount > maxFrequency) {
                maxFrequency = currentCount;
                result = word;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = { "hit" };
        System.out.println("Output: " + mostCommonWord(paragraph, banned));
    }
}
