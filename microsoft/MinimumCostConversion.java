
import java.util.*;

public class MinimumCostConversion {
    private static final int ALPHABET_SIZE = 26; // For lowercase letters a-z

    public int minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;

        // Build graph for character transformations
        int[][] graph = new int[ALPHABET_SIZE][ALPHABET_SIZE];
        for (int[] row : graph) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            graph[i][i] = 0; // Cost to transform a character to itself is 0
        }
        for (int i = 0; i < m; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            graph[u][v] = Math.min(graph[u][v], cost[i]); // Choose the minimum cost for each transformation
        }

        // Floyd-Warshall algorithm to find shortest path between all pairs of characters
        for (int k = 0; k < ALPHABET_SIZE; k++) {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                for (int j = 0; j < ALPHABET_SIZE; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        // Calculate the total minimum cost to convert source to target
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            int srcChar = source.charAt(i) - 'a';
            int tgtChar = target.charAt(i) - 'a';
            if (graph[srcChar][tgtChar] == Integer.MAX_VALUE) {
                return -1; // Conversion is impossible
            }
            totalCost += graph[srcChar][tgtChar];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        MinimumCostConversion mcc = new MinimumCostConversion();

        // Example 1
        String source1 = "abcd";
        String target1 = "acbe";
        char[] original1 = {'a', 'b', 'c', 'c', 'e', 'd'};
        char[] changed1 = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost1 = {2, 5, 5, 1, 2, 20};
        System.out.println(mcc.minimumCost(source1, target1, original1, changed1, cost1)); // Output: 28

        // Example 2
        String source2 = "aaaa";
        String target2 = "bbbb";
        char[] original2 = {'a', 'c'};
        char[] changed2 = {'c', 'b'};
        int[] cost2 = {1, 2};
        System.out.println(mcc.minimumCost(source2, target2, original2, changed2, cost2)); // Output: 12

        // Example 3
        String source3 = "abcd";
        String target3 = "abce";
        char[] original3 = {'a'};
        char[] changed3 = {'e'};
        int[] cost3 = {10000};
        System.out.println(mcc.minimumCost(source3, target3, original3, changed3, cost3)); // Output: -1
    }
}

