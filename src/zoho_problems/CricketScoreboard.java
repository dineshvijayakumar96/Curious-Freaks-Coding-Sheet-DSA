package zoho_problems;

public class CricketScoreboard {

    public static void calculateScores(String[] input) {
        int[] players = new int[11];
        int extras = 0;
        int currentStrike = 0;
        int nonStrike = 1;
        int nextPlayer = 2;
        for (String ball : input) {
            if (ball == "WD") {
                extras++;
            } else if (ball == "W") {
                currentStrike = nextPlayer;
                nextPlayer++;
            } else if (ball.equals("0") || ball.equals(".")) {
                continue;
            } else {
                int runs = Integer.parseInt(ball);
                players[currentStrike] += runs;
                if (runs % 2 != 0) {
                    int temp = currentStrike;
                    currentStrike = nonStrike;
                    nonStrike = temp;
                }
            }
        }
        System.out.println("-----------");
        System.out.println("Scoreboard");
        System.out.println("-----------");
        for (int i = 0; i < nextPlayer; i++) {
            System.out.println("Player " + (i + 1) + ": " + players[i]);
        }
        System.out.println("Extras: " + extras);
    }

    public static void main(String[] args) {
        String[] input = {"2", "1", "W", "0", "WD", "4", "0"};
        calculateScores(input);
    }
}
