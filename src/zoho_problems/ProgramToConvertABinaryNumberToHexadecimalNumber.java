    package zoho_problems;

    public class ProgramToConvertABinaryNumberToHexadecimalNumber {

        public static String convertBinToHex(String binary) {
            if (binary == null || binary.isEmpty()) return "";
            String[] parts = binary.split("\\.");
            String integerPart = parts[0];
            StringBuilder result = new StringBuilder();
            StringBuilder intStr =  new StringBuilder(integerPart);
            while (intStr.length() % 4 != 0) {
                intStr.insert(0, '0');
            }
            for (int i = 0; i < intStr.length(); i += 4) {
                String chunk = intStr.substring(i, i + 4);
                result.append(getHexCharacter(chunk));
            }
            if (parts.length > 1) {
                result.append(".");
                StringBuilder fracStr = new StringBuilder(parts[1]);
                while (fracStr.length() % 4 != 0) {
                    fracStr.append('0');
                }
                for (int i = 0; i < fracStr.length(); i += 4) {
                    String chunk = fracStr.substring(i, i + 4);
                    result.append(getHexCharacter(chunk));
                }
            }
            return result.toString();
        }

//        private static String getHexCharacter(String chunk) {
//            int decimalValue = Integer.parseInt(chunk, 2);
//            return Integer.toHexString(decimalValue);
//        }

        private static String getHexCharacter(String chunk) {
            int sum = 0;
            if (chunk.charAt(0) == '1') sum += 8;
            if (chunk.charAt(1) == '1') sum += 4;
            if (chunk.charAt(2) == '1') sum += 2;
            if (chunk.charAt(3) == '1') sum += 1;

            if (sum < 10) {
                return String.valueOf(sum);
            } else {
                char hexLetter = (char) ('A' + (sum - 10));
                return String.valueOf(hexLetter);
            }
        }

        public static void main(String[] args) {
            String binary = "1111001010010100001.010110110011011";
            System.out.println("Output: " + convertBinToHex(binary));
        }
    }
