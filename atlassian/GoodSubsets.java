import java.util.*;

public class GoodSubsets {
    public int numberOfGoodSubsets(int[] nums) {
        final int MOD = 1_000_000_007;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] freq = new int[31];
        
        // Count frequency of each number in nums
        for (int num : nums) {
            freq[num]++;
        }
        
        // Map each number to a bitmask of its prime factors
        int[] masks = new int[31];
        for (int i = 2; i <= 30; i++) {
            int mask = 0, x = i;
            boolean isValid = true;
            for (int j = 0; j < primes.length; j++) {
                if (x % primes[j] == 0) {
                    mask |= (1 << j);
                    x /= primes[j];
                    if (x % primes[j] == 0) { // Invalid if any prime is repeated
                        isValid = false;
                        break;
                    }
                }
            }
            masks[i] = isValid ? mask : 0;
        }
        
        // DP array
        int[] dp = new int[1 << primes.length];
        dp[0] = 1; // Empty subset
        
        // Update DP for each number
        for (int num = 2; num <= 30; num++) {
            if (freq[num] == 0 || masks[num] == 0) continue;
            
            int mask = masks[num];
            for (int prevMask = (1 << primes.length) - 1; prevMask >= 0; prevMask--) {
                if ((prevMask & mask) == 0) { // Ensure no overlap in prime factors
                    dp[prevMask | mask] = (int)((dp[prevMask | mask] + dp[prevMask] * (long)freq[num]) % MOD);
                }
            }
        }
        
        // Sum all good subsets
        long result = 0;
        for (int mask = 1; mask < (1 << primes.length); mask++) {
            result = (result + dp[mask]) % MOD;
        }
        
        // Multiply by subsets of 1
        if (freq[1] > 0) {
            result = result * powMod(2, freq[1], MOD) % MOD;
        }
        
        return (int)result;
    }
    
    // Fast modular exponentiation
    private long powMod(int base, int exp, int mod) {
        long result = 1, x = base;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * x % mod;
            }
            x = x * x % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        GoodSubsets solver = new GoodSubsets();
        System.out.println(solver.numberOfGoodSubsets(new int[]{1, 2, 3, 4})); // Output: 6
        System.out.println(solver.numberOfGoodSubsets(new int[]{4, 2, 3, 15})); // Output: 5
    }
}
