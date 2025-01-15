import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes by width and then by height in descending order if widths are the same
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending order for height
            }
            return a[0] - b[0]; // Ascending order for width
        });

        // Extract the heights
        int[] heights = Arrays.stream(envelopes)
                              .mapToInt(e -> e[1])
                              .toArray();

        // Find the LIS on heights
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            // Binary search for the position to replace
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1); // Convert to insertion point
            }

            dp[index] = num;
            if (index == len) {
                len++; // Extend the length if necessary
            }
        }

        return len;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes solution = new RussianDollEnvelopes();

        // Example 1
        int[][] envelopes1 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(solution.maxEnvelopes(envelopes1)); // Output: 3

        // Example 2
        int[][] envelopes2 = {{1, 1}, {1, 1}, {1, 1}};
        System.out.println(solution.maxEnvelopes(envelopes2)); // Output: 1
    }
}
