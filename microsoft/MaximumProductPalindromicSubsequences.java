
public class MaximumProductPalindromicSubsequences {
    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;

        // Iterate over all pairs of masks
        for (int mask1 = 0; mask1 < (1 << n); mask1++) {
            if (!isPalindrome(s, mask1)) continue;

            for (int mask2 = 0; mask2 < (1 << n); mask2++) {
                if ((mask1 & mask2) != 0) continue; // Ensure disjoint subsequences
                if (!isPalindrome(s, mask2)) continue;

                // Calculate lengths and product
                int len1 = Integer.bitCount(mask1);
                int len2 = Integer.bitCount(mask2);
                maxProduct = Math.max(maxProduct, len1 * len2);
            }
        }

        return maxProduct;
    }

    // Helper function to check if a subsequence is a palindrome
    private boolean isPalindrome(String s, int mask) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if ((mask & (1 << i)) != 0) {
                sb.append(s.charAt(i));
            }
        }

        String subsequence = sb.toString();
        return subsequence.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        MaximumProductPalindromicSubsequences solution = new MaximumProductPalindromicSubsequences();

        // Example 1
        String s1 = "leetcodecom";
        System.out.println(solution.maxProduct(s1)); // Output: 9

        // Example 2
        String s2 = "bb";
        System.out.println(solution.maxProduct(s2)); // Output: 1

        // Example 3
        String s3 = "accbcaxxcxx";
        System.out.println(solution.maxProduct(s3)); // Output: 25
    }
}

