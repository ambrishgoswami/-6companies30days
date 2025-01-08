

public class MatrixChainMultiplication {

    public static String matrixChainOrder(int[] arr) {
        int n = arr.length;

        // dp[i][j] will hold the minimum multiplication cost for matrices i to j
        int[][] dp = new int[n][n];

        // bracket[i][j] stores the index of the split point for optimal multiplication
        int[][] bracket = new int[n][n];

        // Fill the dp table
        for (int l = 2; l < n; l++) { // l is the chain length
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all split points
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        bracket[i][j] = k;
                    }
                }
            }
        }

        // Build the result string using the bracket table
        char[] matrices = new char[n - 1];
        for (int i = 0; i < n - 1; i++) {
            matrices[i] = (char) ('A' + i);
        }

        return buildOptimalOrder(bracket, matrices, 1, n - 1);
    }

    private static String buildOptimalOrder(int[][] bracket, char[] matrices, int i, int j) {
        if (i == j) {
            return String.valueOf(matrices[i - 1]);
        }
        return "(" + buildOptimalOrder(bracket, matrices, i, bracket[i][j]) +
               buildOptimalOrder(bracket, matrices, bracket[i][j] + 1, j) + ")";
    }

    public static void main(String[] args) {
        int[] arr1 = {40, 20, 30, 10, 30};
        System.out.println(matrixChainOrder(arr1).equals("((A(BC))D)"));

        int[] arr2 = {10, 20, 30};
        System.out.println(matrixChainOrder(arr2).equals("(AB)"));

        int[] arr3 = {3, 3, 3};
        System.out.println(matrixChainOrder(arr3).equals("(AB)"));
    }
}
