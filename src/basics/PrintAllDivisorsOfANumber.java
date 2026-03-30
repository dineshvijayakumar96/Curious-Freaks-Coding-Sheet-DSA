package basics;

import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisorsOfANumber {

    public static List<Integer> calculateDivisors(int n){
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                divisors.add(i);
            }
        }

        return divisors;
    }

    public static void main(String[] args) {

        int n = 439;
        System.out.println("Output: " + calculateDivisors(n));
    }
}
