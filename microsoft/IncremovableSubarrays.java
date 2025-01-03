
import java.util.ArrayList;
import java.util.List;

public class IncremovableSubarrays {
    public int countIncremovableSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Iterate over all possible subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                // Check if removing nums[start...end] results in a strictly increasing array
                if (isStrictlyIncreasing(nums, start, end)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isStrictlyIncreasing(int[] nums, int start, int end) {
        List<Integer> modifiedArray = new ArrayList<>();

        // Construct the array after removing the subarray nums[start...end]
        for (int i = 0; i < nums.length; i++) {
            if (i < start || i > end) {
                modifiedArray.add(nums[i]);
            }
        }

        // Check if the modified array is strictly increasing
        for (int i = 1; i < modifiedArray.size(); i++) {
            if (modifiedArray.get(i) <= modifiedArray.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IncremovableSubarrays solution = new IncremovableSubarrays();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(solution.countIncremovableSubarrays(nums1)); // Output: 10

        // Example 2
        int[] nums2 = {6, 5, 7, 8};
        System.out.println(solution.countIncremovableSubarrays(nums2)); // Output: 7

        // Example 3
        int[] nums3 = {8, 7, 6, 6};
        System.out.println(solution.countIncremovableSubarrays(nums3)); // Output: 3
    }
}

