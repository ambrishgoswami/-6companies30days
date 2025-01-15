import java.util.Arrays;

public class SmallestNumberOfReachableCities {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize distance matrix
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Set distance for edges and self-loops
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Count reachable cities for each city
        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update result based on the problem conditions
            if (reachableCount < minReachable || (reachableCount == minReachable && i > resultCity)) {
                minReachable = reachableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }

    public static void main(String[] args) {
        // Example 1
        int n1 = 4;
        int[][] edges1 = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold1 = 4;
        System.out.println(findTheCity(n1, edges1, distanceThreshold1)); // Output: 3

        // Example 2
        int n2 = 5;
        int[][] edges2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int distanceThreshold2 = 2;
        System.out.println(findTheCity(n2, edges2, distanceThreshold2)); // Output: 0
    }
}
