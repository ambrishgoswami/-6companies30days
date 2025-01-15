import java.util.*;

public class TrimmedNumbers {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int qLen = queries.length;
        int[] result = new int[qLen];
        
        for (int i = 0; i < qLen; i++) {
            int k = queries[i][0]; // k-th smallest number
            int trim = queries[i][1]; // number of rightmost digits to retain
            
            // List to store trimmed numbers with original indices
            List<int[]> trimmed = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                String trimmedStr = nums[j].substring(nums[j].length() - trim);
                trimmed.add(new int[]{Integer.parseInt(trimmedStr), j}); // store value and index
            }
            
            // Sort by value, then by index
            trimmed.sort((a, b) -> (a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])));
            
            // Get the k-th smallest's index
            result[i] = trimmed.get(k - 1)[1];
        }
        
        return result;
    }

    public static void main(String[] args) {
        TrimmedNumbers solution = new TrimmedNumbers();
        
        // Example 1
        String[] nums1 = {"102", "473", "251", "814"};
        int[][] queries1 = {{1, 1}, {2, 3}, {4, 2}, {1, 2}};
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums1, queries1))); // Output: [2, 2, 1, 0]
        
        // Example 2
        String[] nums2 = {"24", "37", "96", "04"};
        int[][] queries2 = {{2, 1}, {2, 2}};
        System.out.println(Arrays.toString(solution.smallestTrimmedNumbers(nums2, queries2))); // Output: [3, 0]
    }
}
