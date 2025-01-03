
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        // Count bulls and track unmatched digits
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }

        // Count cows
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        // Return the result in "xAyB" format
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows solution = new BullsAndCows();

        // Example 1
        String secret1 = "1807";
        String guess1 = "7810";
        System.out.println(solution.getHint(secret1, guess1)); // Output: "1A3B"

        // Example 2
        String secret2 = "1123";
        String guess2 = "0111";
        System.out.println(solution.getHint(secret2, guess2)); // Output: "1A1B"

        // Additional Test Case
        String secret3 = "12345";
        String guess3 = "54321";
        System.out.println(solution.getHint(secret3, guess3)); // Output: "0A5B"
    }
}

