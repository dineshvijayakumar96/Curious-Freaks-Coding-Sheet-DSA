package zoho_problems;

public class MinimumNumberOfCurrencyNotes {

    public static void countNotes(int amount) {
        if (amount <= 0) return;
        int[] currencyNotes = { 2000, 500, 200, 100, 50, 20, 10, 5, 1 };
        for (int i = 0; i < currencyNotes.length; i++) {
            if (amount >= currencyNotes[i]) {
                int count = amount / currencyNotes[i];
                amount = amount % currencyNotes[i];
                System.out.println(currencyNotes[i] + " : " + count);
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
