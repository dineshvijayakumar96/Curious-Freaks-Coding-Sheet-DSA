package zoho_problems;

import java.math.BigInteger;

public class ProgramToConvertHexadecimalNumberToBinary {

    public static String hexToBin(String hexadecimal) {
        StringBuilder result = new StringBuilder("");
        for (char c : hexadecimal.toCharArray()) {
            String binary = switch (c) {
                case '0' -> "0000";
                case '1' -> "0001";
                case '2' -> "0010";
                case '3' -> "0011";
                case '4' -> "0100";
                case '5' -> "0101";
                case '6' -> "0110";
                case '7' -> "0111";
                case '8' -> "1000";
                case '9' -> "1001";
                case 'A', 'a' -> "1010";
                case 'B', 'b' -> "1011";
                case 'C', 'c' -> "1100";
                case 'D', 'd' -> "1101";
                case 'E', 'e' -> "1110";
                case 'F', 'f' -> "1111";
                case '.' -> ".";
                default -> "";
            };
            result.append(binary);
        }
        BigInteger bi = new BigInteger(hexadecimal, 16);
        System.out.println("In Build Method: " + bi.toString(2));
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String hexadecimal = "1AC5";
        System.out.println(hexToBin(hexadecimal));
    }
}
