import java.util.LinkedList;
import java.util.Queue;

public class Solution5 {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] heights = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        // Directions for moving north, south, east, west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Initialize the queue with all water cells
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check bounds and if the cell is unvisited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    heights[newX][newY] = heights[x][y] + 1;
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return heights;
    }

    public static void main(String[] args) {
        Solution5 solution = new Solution5();

        // Example 1
        int[][] isWater1 = {{0, 1}, {0, 0}};
        int[][] result1 = solution.highestPeak(isWater1);
        printMatrix(result1); // Output: [[1, 0], [2, 1]]

        // Example 2
        int[][] isWater2 = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        int[][] result2 = solution.highestPeak(isWater2);
        printMatrix(result2); // Output: [[1, 1, 0], [0, 1, 1], [1, 2, 2]]
    }

    // Helper function to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

