package recursion;

import java.util.ArrayList;

public class PrintPattern {

    public static ArrayList<Integer> pattern(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        return patternSystem(n, list);
    }

    public static ArrayList<Integer> patternSystem(int n, ArrayList<Integer> list) {
        list.add(n);
        if (n <= 0){
            return list;
        }
        patternSystem(n - 5, list);
        list.add(n);
        return list;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Output: " + pattern(n));
    }
}
