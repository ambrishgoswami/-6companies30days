import java.util.HashMap;
import java.util.*;
import java.util.Random;

class Solution1 {
    private int m, n, total;
    private Map<Integer, Integer> map;
    private Random random;

    public Solution1(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public int[] flip() {
        int randIndex = random.nextInt(total--);
        int actualIndex = map.getOrDefault(randIndex, randIndex);

        // Map the selected index to the last available index
        map.put(randIndex, map.getOrDefault(total, total));
        
        return new int[]{actualIndex / n, actualIndex % n};
    }

    public void reset() {
        map.clear();
        total = m * n;
    }
    public class Main {
        public static void main(String[] args) {
            Solution1 solution = new Solution1(3, 1);
            System.out.println(Arrays.toString(solution.flip())); // [1, 0] or [0, 0] or [2, 0]
            System.out.println(Arrays.toString(solution.flip())); // Remaining indices
            System.out.println(Arrays.toString(solution.flip())); // Last index
            solution.reset();
            System.out.println(Arrays.toString(solution.flip())); // Reset indices
        }
    }
    
}
