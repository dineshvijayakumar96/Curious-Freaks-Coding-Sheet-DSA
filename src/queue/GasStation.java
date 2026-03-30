package queue;

public class GasStation {

    public static int startStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startStation = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += (gas[i] - cost[i]);
            if (currentGas < 0) {
                startStation = i + 1;
                currentGas = 0;
            }
        }
        if (totalGas < totalCost) return -1;
        return startStation;
    }

    public static void main(String[] args) {
        int[] gas = { 4, 5, 7, 4 };
        int[] cost = { 6, 6, 3, 5 };
        System.out.println("Output: " + startStation(gas, cost));
    }
}
