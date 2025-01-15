class Solution7 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1]; // dp[i] = number of people who discover the secret on day i
        dp[1] = 1; // On day 1, 1 person knows the secret
        long total = 0; // Total number of people who know the secret

        for (int day = 1; day <= n; day++) {
            // Add the number of people who discover the secret on this day
            total = (total + dp[day]) % MOD;

            // People start sharing the secret after `delay` days
            if (day + delay <= n) {
                dp[day + delay] = (dp[day + delay] + dp[day]) % MOD;
            }

            // People forget the secret after `forget` days
            if (day + forget <= n) {
                dp[day + forget] = (dp[day + forget] - dp[day] + MOD) % MOD;
            }
        }

        return (int) total;
    }

    // Helper method for testing
    public static void main(String[] args) {
        Solution7 solution = new Solution7();

        // Example 1
        System.out.println(solution.peopleAwareOfSecret(6, 2, 4)); // Output: 5

        // Example 2
        System.out.println(solution.peopleAwareOfSecret(4, 1, 3)); // Output: 6
    }
}
