package basics;

public class ReverseDigits {

    public static int reverse(int n) {

        char[] numbers = Integer.toString(n).toCharArray();
        int index = numbers.length;

        for (int i = 0; i < index / 2; i++) {

            char swap = numbers[index - 1];
            numbers[(index - 1) - i] = numbers[i];
            numbers[i] = swap;
        }

        index = 0;
        String output = "";

        while (index < numbers.length) {

            output += numbers[index];
            index++;
        }

        return Integer.parseInt(output);
    }

    public static void main(String[] args) {

        int n2 = 122;
        int n = 200;

        System.out.println("Output: " + reverse(n));
    }
}
