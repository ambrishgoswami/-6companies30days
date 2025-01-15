import java.util.Arrays;

public class rotational {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int currentF = 0;

        // Calculate the sum of all elements and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            currentF += i * nums[i];
        }

        // Initialize the maximum value with F(0)
        int maxF = currentF;

        // Calculate F(k) for k = 1 to n-1 using the relation derived above
        for (int k = 1; k < n; k++) {
            // Transition from F(k-1) to F(k)
            currentF = currentF + sum - n * nums[n - k];
            maxF = Math.max(maxF, currentF);
        }

        return maxF;
    }
    public static void main(String[] args) {
      rotational solution = new rotational();
          int[] nums1 = {2, 1, 3, 3};
       
        System.out.println("rotation function"+solution.maxRotateFunction(nums1));
    }
}
