import java.util.HashMap;
import java.util.Map;

public class LongestGoodSubarray {
    public int longestGoodSubarray(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Increase the frequency of the current element
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // If any element's frequency exceeds k, shrink the window
            while (freqMap.get(nums[right]) > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++; // Move the left pointer to shrink the window
            }

            // Update the maximum length of a valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestGoodSubarray solver = new LongestGoodSubarray();

        // Test cases
        System.out.println(solver.longestGoodSubarray(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2)); // Output: 6
        System.out.println(solver.longestGoodSubarray(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1)); // Output: 2
        System.out.println(solver.longestGoodSubarray(new int[]{5, 5, 5, 5, 5, 5, 5}, 4)); // Output: 4
    }
}

