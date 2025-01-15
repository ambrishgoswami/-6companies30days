import java.util.Arrays;

public class DistanceValue {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // Sort arr2 for efficient range checks
        Arrays.sort(arr2);

        int count = 0;

        for (int num : arr1) {
            if (isValid(num, arr2, d)) {
                count++;
            }
        }

        return count;
    }

    // Helper function to check if num satisfies the condition
    private boolean isValid(int num, int[] arr2, int d) {
        int left = 0, right = arr2.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Math.abs(num - arr2[mid]) <= d) {
                return false; // Condition fails for this num
            }

            if (arr2[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return true; // No element satisfies the condition
    }

    public static void main(String[] args) {
        DistanceValue solver = new DistanceValue();

        // Test cases
        System.out.println(solver.findTheDistanceValue(
            new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2)); // Output: 2
        System.out.println(solver.findTheDistanceValue(
            new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3)); // Output: 2
        System.out.println(solver.findTheDistanceValue(
            new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6)); // Output: 1
    }
}

