
import java.util.*;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort the envelopes
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Descending order for heights if widths are the same
            }
            return a[0] - b[0]; // Ascending order for widths
        });

        // Step 2: Extract the heights and apply LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        return lengthOfLIS(heights);
    }

    // Helper function to find the length of LIS using binary search
    private int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos < lis.size()) {
                lis.set(pos, num);
            } else {
                lis.add(num);
            }
        }

        return lis.size();
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

