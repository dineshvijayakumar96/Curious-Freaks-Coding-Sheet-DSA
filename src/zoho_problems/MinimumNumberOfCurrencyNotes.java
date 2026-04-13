package zoho_problems;

public class MinimumNumberOfCurrencyNotes {

    public static void countNotes(int amount) {
        if (amount <= 0) return;
        int[] currencyNotes = { 2000, 500, 200, 100, 50, 20, 10, 5, 1 };
        for (int currencyNote : currencyNotes) {
            if (amount >= currencyNote) {
                int count = amount / currencyNote;
                amount = amount % currencyNote;
                System.out.println(currencyNote + " : " + count);
            }
        }
    }

    public static void main(String[] args) {
        int amount1 = 800;
        System.out.println("Input : " + amount1);
        System.out.println("Output:");
        countNotes(amount1);

        System.out.println("\n-------------------\n");

        int amount2 = 2456;
        System.out.println("Input : " + amount2);
        System.out.println("Output:");
        countNotes(amount2);
    }
}
