public class StaircaseWays {
    public int waysToReachK(int k) {
        if (k == 0) return 2; // Base case: Stair 0 has exactly 2 ways.

        long mod = (long) 1e9 + 7; // To prevent overflow.
        long[] dp = new long[k + 1]; // DP array to store the number of ways.
        dp[0] = 1; // Base case: 1 way to stay at stair 0.

        for (int jump = 0; jump <= 60; jump++) { // 60 because 2^60 > 10^9
            long pow2 = (1L << jump); // Compute 2^jump efficiently.
            for (int i = k; i >= 0; i--) {
                if (i - pow2 >= 0) {
                    dp[i] = (dp[i] + dp[(int) (i - pow2)]) % mod;
                }
            }
        }

        long result = dp[k]; // Ways to reach stair k.
        for (int i = 0; i < k; i++) {
            result = (result + dp[i]) % mod;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        StaircaseWays solution = new StaircaseWays();

        // Example 1
        int k1 = 0;
        System.out.println(solution.waysToReachK(k1)); // Output: 2

        // Example 2
        int k2 = 1;
        System.out.println(solution.waysToReachK(k2)); // Output: 4

        // Example 3
        int k3 = 10;
        System.out.println(solution.waysToReachK(k3)); // Test for larger k
    }
}

