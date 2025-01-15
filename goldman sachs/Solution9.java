class Solution9 {
    public int numberOfWays(int startPos, int endPos, int k) {
        final int MOD = 1000000007;
        
        // Initialize the DP table with the size of 2k + 1 (to accommodate all possible positions)
        int[] dp = new int[2 * k + 1];
        dp[startPos + k] = 1;  // The starting position with a shift by k
        
        // Iterate over each step
        for (int steps = 1; steps <= k; steps++) {
            int[] nextDp = new int[2 * k + 1];  // Temporary array for the next step
            
            // Update the dp table for the next step
            for (int pos = 0; pos < 2 * k + 1; pos++) {
                if (dp[pos] > 0) {
                    if (pos - 1 >= 0) {
                        nextDp[pos - 1] = (nextDp[pos - 1] + dp[pos]) % MOD;  // Move left
                    }
                    if (pos + 1 < 2 * k + 1) {
                        nextDp[pos + 1] = (nextDp[pos + 1] + dp[pos]) % MOD;  // Move right
                    }
                }
            }
            dp = nextDp;  // Move to the next step
        }
        
        // The target position is endPos + k due to the shift, so return dp[endPos + k]
        return dp[endPos + k];
    }

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        
        // Example 1
        System.out.println(solution.numberOfWays(1, 2, 3));  // Output: 3
        
        // Example 2
        System.out.println(solution.numberOfWays(2, 5, 10));  // Output: 0
    }
}

