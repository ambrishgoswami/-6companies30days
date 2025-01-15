public class MinimumProduct {
    private static final int MOD = 1_000_000_007;

    // Function to compute (base^exp) % MOD using fast exponentiation
    private long modExp(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        long maxNum = (1L << p) - 1; // 2^p - 1
        long secondMaxNum = maxNum - 1; // 2^p - 2
        long count = (1L << (p - 1)) - 1; // 2^(p-1) - 1

        // Calculate the result using the formula
        long result = modExp(secondMaxNum, count, MOD) * maxNum % MOD;
        return (int) result;
    }

    public static void main(String[] args) {
        MinimumProduct solver = new MinimumProduct();
        
        // Test cases
        System.out.println(solver.minNonZeroProduct(1)); // Output: 1
        System.out.println(solver.minNonZeroProduct(2)); // Output: 6
        System.out.println(solver.minNonZeroProduct(3)); // Output: 1512
    }
}

