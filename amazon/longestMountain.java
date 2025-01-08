public class longestMountain {
    public static int LongestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return 0; // A mountain must have at least 3 elements
        }

        int maxLen = 0;
        int i = 1;

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand to the left
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Expand to the right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the length of the mountain
                int currentMountainLength = right - left + 1;
                maxLen = Math.max(maxLen, currentMountainLength);

                // Move `i` to `right` for the next iteration
                i = right;
            } else {
                i++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {2, 1, 4, 7, 3, 2, 5};
        int[] arr2 = {2, 2, 2};
        int[] arr3 = {0, 1, 0, 1, 0, 1, 0};

        System.out.println("Longest Mountain Length (arr1): " + LongestMountain(arr1)); // Output: 5
        System.out.println("Longest Mountain Length (arr2): " + LongestMountain(arr2)); // Output: 0
        System.out.println("Longest Mountain Length (arr3): " + LongestMountain(arr3)); // Output: 3
    }
}
