import java.util.*;

class MaximumSquareHole {
    public static int maxSquareHole(int n, int m, int[] hBars, int[] vBars) {
        // Include the border bars
        List<Integer> hAllBars = new ArrayList<>();
        List<Integer> vAllBars = new ArrayList<>();

        hAllBars.add(1);
        hAllBars.addAll(Arrays.stream(hBars).boxed().toList());
        hAllBars.add(n + 2);

        vAllBars.add(1);
        vAllBars.addAll(Arrays.stream(vBars).boxed().toList());
        vAllBars.add(m + 2);

        Collections.sort(hAllBars);
        Collections.sort(vAllBars);

        // Find the maximum gap between consecutive horizontal bars
        int maxHGap = 0;
        for (int i = 1; i < hAllBars.size(); i++) {
            maxHGap = Math.max(maxHGap, hAllBars.get(i) - hAllBars.get(i - 1) - 1);
        }

        // Find the maximum gap between consecutive vertical bars
        int maxVGap = 0;
        for (int i = 1; i < vAllBars.size(); i++) {
            maxVGap = Math.max(maxVGap, vAllBars.get(i) - vAllBars.get(i - 1) - 1);
        }

        // The maximum square area is the product of the largest gaps
        return maxHGap * maxVGap;
    }

    public static void main(String[] args) {
        // Example 1
        System.out.println(maxSquareHole(2, 1, new int[]{2, 3}, new int[]{2})); // Output: 4

        // Example 2
        System.out.println(maxSquareHole(1, 1, new int[]{2}, new int[]{2})); // Output: 4

        // Example 3
        System.out.println(maxSquareHole(2, 3, new int[]{2, 3}, new int[]{2, 4})); // Output: 4
    }
}

