import java.util.HashSet;

public class MaximumSubarraySum {
    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return 0;

        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> window = new HashSet<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            // Add the current number to the window and sum
            while (window.contains(nums[right])) {
                // Remove elements from the left to maintain distinct elements
                currentSum -= nums[left];
                window.remove(nums[left]);
                left++;
            }

            window.add(nums[right]);
            currentSum += nums[right];

            // Check if the window size equals k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                // Slide the window
                currentSum -= nums[left];
                window.remove(nums[left]);
                left++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        System.out.println("Maximum Subarray Sum (Test 1): " + maximumSubarraySum(nums1, k1)); // Output: 15

        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        System.out.println("Maximum Subarray Sum (Test 2): " + maximumSubarraySum(nums2, k2)); // Output: 0

        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        System.out.println("Maximum Subarray Sum (Test 3): " + maximumSubarraySum(nums3, k3)); // Output: 9
    }
}

