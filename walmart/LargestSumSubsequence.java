import java.util.*;

public class LargestSumSubsequence {
    public static int[] maxSubsequence(int[] nums, int k) {
        // Step 1: Pair each element with its index
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i]; // Element value
            pairs[i][1] = i;       // Original index
        }

        // Step 2: Sort by value in descending order
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        // Step 3: Select the top `k` elements
        int[][] topK = Arrays.copyOfRange(pairs, 0, k);

        // Step 4: Sort the top `k` elements by their original index
        Arrays.sort(topK, (a, b) -> a[1] - b[1]);

        // Step 5: Extract the values to form the result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 1, 3, 3};
        int k1 = 2;
        System.out.println("Example 1: " + Arrays.toString(maxSubsequence(nums1, k1))); // Output: [3, 3]

        int[] nums2 = {-1, -2, 3, 4};
        int k2 = 3;
        System.out.println("Example 2: " + Arrays.toString(maxSubsequence(nums2, k2))); // Output: [-1, 3, 4]

        int[] nums3 = {3, 4, 3, 3};
        int k3 = 2;
        System.out.println("Example 3: " + Arrays.toString(maxSubsequence(nums3, k3))); // Output: [3, 4] or [4, 3]
    }
}
