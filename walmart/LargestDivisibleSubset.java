import java.util.*;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); 
        int n = nums.length;

        // Step 2: Initialize DP and parent arrays
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxSize = 0; // Maximum size of the subset
        int maxIndex = -1; // Index of the last element in the largest subset

        // Step 3: Build DP array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Step 4: Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(result); // Reverse to get the subset in sorted order
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 4, 8};

        System.out.println("Example 1: " + largestDivisibleSubset(nums1));
        System.out.println("Example 2: " + largestDivisibleSubset(nums2));
    }
}
