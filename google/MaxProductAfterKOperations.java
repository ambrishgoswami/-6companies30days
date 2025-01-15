import java.util.PriorityQueue;

public class MaxProductAfterKOperations {
    public int maximumProduct(int[] nums, int k) {
        // Define the modulo value
        final int MOD = 1_000_000_007;

        // Min-heap to store the elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
        }

        // Perform k operations
        while (k > 0) {
            int smallest = minHeap.poll();
            minHeap.offer(smallest + 1);
            k--;
        }

        // Calculate the product of elements in the heap
        long product = 1;
        while (!minHeap.isEmpty()) {
            product = (product * minHeap.poll()) % MOD;
        }

        return (int) product;
    }

    public static void main(String[] args) {
        MaxProductAfterKOperations solution = new MaxProductAfterKOperations();

        // Example 1
        int[] nums1 = {0, 4};
        int k1 = 5;
        System.out.println(solution.maximumProduct(nums1, k1)); // Output: 20

        // Example 2
        int[] nums2 = {6, 3, 3, 2};
        int k2 = 2;
        System.out.println(solution.maximumProduct(nums2, k2)); // Output: 216
    }
}
