package zoho_problems;

import java.util.Arrays;

public class NextGreaterEvenNumber {

    public static long getNextEven(String x) {
        char[] S = x.toCharArray();
        int n = S.length;
        for (int i = n - 2; i >= 0; i--) {
            char bestCharToPlaceAtI = (char) ('9' + 1);
            int bestJ = -1;
            for (int j = i + 1; j < n; j++) {
                if (S[j] > S[i]) {
                    if (S[j] < bestCharToPlaceAtI) {
                        if (hasEvenDigit(S, i, j)) {
                            bestCharToPlaceAtI = S[j];
                            bestJ = j;
                        }
                    }
                }
            }
            if (bestJ != -1) {
                char temp = S[i];
                S[i] = S[bestJ];
                S[bestJ] = temp;
                int largestEvenIdx = -1;
                char largestEvenChar = '/';
                for (int k = i + 1; k < n; k++) {
                    if ((S[k] - '0') % 2 == 0) {
                        if (S[k] > largestEvenChar) {
                            largestEvenChar = S[k];
                            largestEvenIdx = k;
                        }
                    }
                }
                StringBuilder pool = new StringBuilder();
                for (int k = i + 1; k < n; k++) {
                    if (k == largestEvenIdx) {
                        largestEvenIdx = -1;
                        continue;
                    }
                    pool.append(S[k]);
                }
                char[] sortedPool = pool.toString().toCharArray();
                Arrays.sort(sortedPool);
                int index = i + 1;
                for (char c : sortedPool) {
                    S[index++] = c;
                }
                S[index] = largestEvenChar;
                return Long.parseLong(new String(S));
            }
        }
        return -1;
    }

    private static boolean hasEvenDigit(char[] S, int i, int candidateJ) {
        if ((S[i] - '0') % 2 == 0) return true;
        for (int k = i + 1; k < S.length; k++) {
            if (k == candidateJ) continue;
            if ((S[k] - '0') % 2 == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String x = "34722641";
        System.out.println("Output: " + getNextEven(x));
    }
}
