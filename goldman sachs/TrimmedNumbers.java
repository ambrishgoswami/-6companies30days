import java.util.*;

public class TrimmedNumbers {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int k = queries[q][0];
            int trimLength = queries[q][1];

            // Create a list of pairs where each pair is [trimmedNumber, originalIndex]
            List<int[]> trimmedList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                // Extract the trimmed version of the number
                String trimmed = nums[i].substring(nums[i].length() - trimLength);
                trimmedList.add(new int[] { Integer.parseInt(trimmed), i });
            }

            // Sort the trimmed list based on:
            // 1. Trimmed number (ascending)
            // 2. Original index (ascending) for ties
            trimmedList.sort((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

            // Get the k-th smallest trimmed number's original index
            result[q] = trimmedList.get(k - 1)[1];
        }

        return result;
    }

    public static void main(String[] args) {
        TrimmedNumbers solver = new TrimmedNumbers();

        // Test case 1
        String[] nums1 = {"102", "473", "251", "814"};
        int[][] queries1 = {{1, 1}, {2, 3}, {4, 2}, {1, 2}};
        System.out.println(Arrays.toString(solver.smallestTrimmedNumbers(nums1, queries1)));
        // Output: [2, 2, 1, 0]

        // Test case 2
        String[] nums2 = {"24", "37", "96", "04"};
        int[][] queries2 = {{2, 1}, {2, 2}};
        System.out.println(Arrays.toString(solver.smallestTrimmedNumbers(nums2, queries2)));
        // Output: [3, 0]
    }
}

