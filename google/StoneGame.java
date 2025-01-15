import java.util.Arrays;

public class StoneGame {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] stones = new int[n][2];

        // Calculate the combined values and store them with their indices
        for (int i = 0; i < n; i++) {
            stones[i][0] = aliceValues[i] + bobValues[i]; // Combined value
            stones[i][1] = i; // Index of the stone
        }

        // Sort stones by their combined value in descending order
        Arrays.sort(stones, (a, b) -> b[0] - a[0]);

        int aliceScore = 0, bobScore = 0;

        // Alternate picking stones
        for (int i = 0; i < n; i++) {
            int index = stones[i][1];
            if (i % 2 == 0) {
                aliceScore += aliceValues[index]; // Alice's turn
            } else {
                bobScore += bobValues[index]; // Bob's turn
            }
        }

        // Determine the winner
        if (aliceScore > bobScore) {
            return 1;
        } else if (bobScore > aliceScore) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        StoneGame game = new StoneGame();

        // Example 1
        System.out.println(game.stoneGameVI(new int[]{1, 3}, new int[]{2, 1})); // Output: 1

        // Example 2
        System.out.println(game.stoneGameVI(new int[]{1, 2}, new int[]{3, 1})); // Output: 0

        // Example 3
        System.out.println(game.stoneGameVI(new int[]{2, 4, 3}, new int[]{1, 6, 7})); // Output: -1
    }
}
