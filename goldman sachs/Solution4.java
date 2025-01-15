import java.util.HashSet;

public class Solution4 {
    public static int countDistinct(int[] nums, int k, int p) {
        HashSet<String> uniqueSubarrays = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int divisibleCount = 0;
            StringBuilder subarray = new StringBuilder();

            for (int j = i; j < n; j++) {
                if (nums[j] % p == 0) {
                    divisibleCount++;
                }
                if (divisibleCount > k) {
                    break; // Stop expanding if divisible count exceeds k
                }

                // Add current element to subarray and store as unique string
                subarray.append(nums[j]).append(",");
                uniqueSubarrays.add(subarray.toString());
            }
        }

        return uniqueSubarrays.size();
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 3, 3, 2, 2};
        int k1 = 2, p1 = 2;
        System.out.println(countDistinct(nums1, k1, p1)); // Output: 11

        // Example 2
        int[] nums2 = {1, 2, 3, 4};
        int k2 = 4, p2 = 1;
        System.out.println(countDistinct(nums2, k2, p2)); // Output: 10
    }
}
