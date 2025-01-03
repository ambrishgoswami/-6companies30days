
public class  countingSubArray  {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                k--;
            }
            while (k < 0) {
                if (nums[left] % 2 != 0) {
                    k++;
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        countingSubArray  solution = new  countingSubArray ();

        
        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        System.out.println(solution.numberOfSubarrays(nums1, k1)); 

      
        int[] nums2 = {2, 4, 6};
        int k2 = 1;
        System.out.println(solution.numberOfSubarrays(nums2, k2)); 

        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k3 = 2;
        System.out.println(solution.numberOfSubarrays(nums3, k3)); 
    }
}

