import java.util.*;

public class Solution {
    private static final int MOD = 1000000007;

    public int squareFreeSubsets(int[] nums) {
        // Step 1: Find all square-free numbers from 1 to 30
        Set<Integer> squareFreeNumbers = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            if (isSquareFree(i)) {
                squareFreeNumbers.add(i);
            }
        }

        // Step 2: Convert the input to only include square-free numbers
        List<Integer> validNumbers = new ArrayList<>();
        for (int num : nums) {
            if (squareFreeNumbers.contains(num)) {
                validNumbers.add(num);
            }
        }

        // Step 3: Use dynamic programming to count square-free subsets
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);  // base case: the empty subset

        for (int num : validNumbers) {
            List<Integer> toAdd = new ArrayList<>();
            for (int key : dp.keySet()) {
                int product = key * num;
                if (isSquareFree(product)) {
                    toAdd.add(product);
                }
            }
            for (int product : toAdd) {
                dp.put(product, (dp.getOrDefault(product, 0) + 1) % MOD);
            }
        }

        // Step 4: Return the count of non-empty square-free subsets
        int result = 0;
        for (int count : dp.values()) {
            result = (result + count) % MOD;
        }
        return result - 1;  // subtract the empty subset
    }

    // Check if a number is square-free
    private boolean isSquareFree(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % (i * i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 4, 4, 5};
        System.out.println(solution.squareFreeSubsets(nums1));  // Output: 3

        // Example 2
        int[] nums2 = {1};
        System.out.println(solution.squareFreeSubsets(nums2));  // Output: 1
    }
}

