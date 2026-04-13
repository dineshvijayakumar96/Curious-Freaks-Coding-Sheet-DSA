package zoho_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDigitsIteratively {

    public static int[] removeDigits(int[] numbers, int[] digits) {
        List<String> currentList =  new ArrayList<>();
        for (int number : numbers) {
            currentList.add(String.valueOf(number));
        }
        for (int digit : digits) {
            if (currentList.isEmpty()) break;
            String digitStr = String.valueOf(digit);
            List<String> nextList =  new ArrayList<>();
            for (String numberStr : currentList) {
                String updated = numberStr.replace(digitStr, "");
                if (!updated.isEmpty()) nextList.add(updated);
            }
            currentList = nextList;
        }
        int[] result = new int[currentList.size()];
        for (int i = 0; i < currentList.size(); i++) {
            result[i] = Integer.parseInt(currentList.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = { 123, 456, 14, 781 };
        int[] digits = { 1, 4 };
        System.out.println("Output: " + Arrays.toString(removeDigits(numbers, digits)));
    }
}
