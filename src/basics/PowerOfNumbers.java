package basics;

public class PowerOfNumbers {

    public static int powerOfNumber(int n) {

        char[] numbers = String.valueOf(n).toCharArray();
        String reversed = "";

        for (int i = 0; i < numbers.length / 2; i++) {
            char swap = numbers[i];
            numbers[i] = numbers[(numbers.length - 1) - i];
            numbers[(numbers.length - 1) -i] = swap;
        }

        reversed = String.valueOf(numbers);

        int reversedNumber = Integer.parseInt(reversed);
        int output = n;

        for (int i = 0; i < reversedNumber - 1; i++) {
            output *= n;
        }

        return output;
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println("Output: " + powerOfNumber(n));
    }
}
