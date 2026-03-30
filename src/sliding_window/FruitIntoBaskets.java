package sliding_window;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;
        int[] fruitFrequency = new int[fruits.length];
        int distinctFruits = 0;
        int leftWindow = 0;
        int length = 0;
        for (int rightWindow = 0; rightWindow < fruits.length; rightWindow++) {
            if (fruitFrequency[fruits[rightWindow]] == 0) {
                distinctFruits++;
            }
            fruitFrequency[fruits[rightWindow]]++;
            if (distinctFruits > 2) {
                fruitFrequency[fruits[leftWindow]]--;
                if (fruitFrequency[fruits[leftWindow]] == 0) {
                    distinctFruits--;
                }
                leftWindow++;
            }
            if (rightWindow - leftWindow + 1 > length) {
                length = rightWindow - leftWindow + 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] fruits = { 0,1,2,2 };
        System.out.printf("Output: " + totalFruit(fruits));
    }
}
