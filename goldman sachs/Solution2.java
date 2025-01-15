import java.util.*;

public class Solution2 {
    public static int[] findMissingAndRepeating(int[] arr, int n) {
        // Initialize expected sums
        long S_expected = (long) n * (n + 1) / 2;
        long P_expected = (long) n * (n + 1) * (2 * n + 1) / 6;

        // Calculate actual sums
        long S_actual = 0, P_actual = 0;
        for (int num : arr) {
            S_actual += num;
            P_actual += (long) num * num;
        }

        // Differences
        long S_diff = S_actual - S_expected; // b - a
        long P_diff = P_actual - P_expected; // b^2 - a^2

        // Solve equations
        long sum = P_diff / S_diff; // b + a
        long b = (S_diff + sum) / 2;
        long a = sum - b;

        return new int[]{(int) b, (int) a};
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {2, 2};
        System.out.println(Arrays.toString(findMissingAndRepeating(arr1, arr1.length))); // [2, 1]

        // Example 2
        int[] arr2 = {1, 3, 3};
        System.out.println(Arrays.toString(findMissingAndRepeating(arr2, arr2.length))); // [3, 2]

        // Example 3
        int[] arr3 = {4, 3, 6, 2, 1, 1};
        System.out.println(Arrays.toString(findMissingAndRepeating(arr3, arr3.length))); // [1, 5]
    }
}

