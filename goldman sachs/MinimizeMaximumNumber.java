public class MinimizeMaximumNumber {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long low = 1, high = (long) 1e18; // Upper bound due to large constraints
        long lcm = lcm(divisor1, divisor2);

        while (low < high) {
            long mid = (low + high) / 2;

            // Numbers not divisible by divisor1 or divisor2
            long count1 = mid - mid / divisor1;
            long count2 = mid - mid / divisor2;

            // Numbers not divisible by either divisor
            long common = mid - mid / lcm;

            if (count1 >= uniqueCnt1 && count2 >= uniqueCnt2 && common >= (uniqueCnt1 + uniqueCnt2)) {
                high = mid; // Reduce the search space
            } else {
                low = mid + 1; // Increase the search space
            }
        }

        return (int) low;
    }

    // Helper method to compute LCM
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    // Helper method to compute GCD
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        MinimizeMaximumNumber solver = new MinimizeMaximumNumber();

        // Test cases
        System.out.println(solver.minimizeSet(2, 7, 1, 3)); // Output: 4
        System.out.println(solver.minimizeSet(3, 5, 2, 1)); // Output: 3
        System.out.println(solver.minimizeSet(2, 4, 8, 2)); // Output: 15
    }
}
