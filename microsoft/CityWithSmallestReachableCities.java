
import java.util.*;

public class CityWithSmallestReachableCities {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0; // Distance from a city to itself is 0
        }

        // Fill in the distances from the edges
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            distance[from][to] = weight;
            distance[to][from] = weight; // Because the graph is bidirectional
        }

        // Floyd-Warshall Algorithm to compute shortest paths between all pairs of cities
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        // Find the city with the smallest number of reachable cities within the distance threshold
        int minReachableCities = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }

            // Update the result based on the conditions
            if (reachableCities < minReachableCities || 
               (reachableCities == minReachableCities && i > resultCity)) {
                minReachableCities = reachableCities;
                resultCity = i;
            }
        }

        return resultCity;
    }

    public static void main(String[] args) {
        CityWithSmallestReachableCities solution = new CityWithSmallestReachableCities();

        // Example 1
        int n1 = 4;
        int[][] edges1 = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold1 = 4;
        System.out.println(solution.findTheCity(n1, edges1, distanceThreshold1)); // Output: 3

        // Example 2
        int n2 = 5;
        int[][] edges2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int distanceThreshold2 = 2;
        System.out.println(solution.findTheCity(n2, edges2, distanceThreshold2)); // Output: 0
    }
}

