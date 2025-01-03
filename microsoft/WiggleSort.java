import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] result = new int[n];
        
        // Step 2: Use two pointers to populate result array
        int mid = (n - 1) / 2; // Middle index (end of the first half)
        int end = n - 1;       // End of the second half
        
        // Fill odd indices with elements from the second half
        for (int i = 0; i < n; i += 2) {
            result[i] = nums[mid--];
        }
        
        // Fill even indices with elements from the first half
        for (int i = 1; i < n; i += 2) {
            result[i] = nums[end--];
        }
        
        // Step 3: Copy result back into nums
        System.arraycopy(result, 0, nums, 0, n);
    }
    
    public static void main(String[] args) {
        WiggleSort ws = new WiggleSort();
        
        int[] nums1 = {1, 5, 1, 1, 6, 4};
        ws.wiggleSort(nums1);
        System.out.println(Arrays.toString(nums1)); // Output: [1, 6, 1, 5, 1, 4]
        
        int[] nums2 = {1, 3, 2, 2, 3, 1};
        ws.wiggleSort(nums2);
        System.out.println(Arrays.toString(nums2)); // Output: [2, 3, 1, 3, 1, 2]
    }
}
