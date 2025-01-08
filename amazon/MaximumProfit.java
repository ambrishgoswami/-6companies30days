 public class MaximumProfit {

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        // If k >= n/2, then it is the same problem as the unlimited transactions problem
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

       
        int[][] dp = new int[k + 1][n];

        // Fill the dp table
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0]; 
            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i]);
            }
        }

        return dp[k][n - 1]; // Max profit with k transactions by the last day
    }

    public static void main(String[] args) {
        int[] prices1 = {2, 4, 1};
        int k1 = 2;
        System.out.println(maxProfit(k1, prices1)); // Output: 2

        int[] prices2 = {3, 2, 6, 5, 0, 3};
        int k2 = 2;
        System.out.println(maxProfit(k2, prices2)); // Output: 7
    }
}
