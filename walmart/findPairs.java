import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // If k is negative, there are no valid pairs

        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;

        // Count the frequency of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through the map to find valid pairs
        for (int num : countMap.keySet()) {
            if (k == 0) {
                // Special case for k = 0, we need at least two of the same number
                if (countMap.get(num) > 1) {
                    result++;
                }
            } else {
                // For k > 0, we need to check if num + k exists in the map
                if (countMap.containsKey(num + k)) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {3, 1, 4, 1, 5};
        int k1 = 2;
        System.out.println(solution.findPairs(nums1, k1)); // Output: 2

        // Example 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 1;
        System.out.println(solution.findPairs(nums2, k2)); // Output: 4

        // Example 3
        int[] nums3 = {1, 3, 1, 5, 4};
        int k3 = 0;
        System.out.println(solution.findPairs(nums3, k3)); // Output: 1
    }
}
