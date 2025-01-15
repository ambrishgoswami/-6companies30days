import java.util.*;

public class MinimumDaysToDisconnectGrid {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check if the grid is already disconnected
        if (countIslands(grid) != 1) return 0;

        // Try removing one cell and check if the grid gets disconnected
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0; // Temporarily remove the land cell
                    if (countIslands(grid) != 1) return 1; // Check if disconnected
                    grid[i][j] = 1; // Restore the land cell
                }
            }
        }

        // If one removal doesn't work, it will take at most 2 days
        return 2;
    }

    private int countIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islandCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0 || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int[] dir : DIRECTIONS) {
            dfs(grid, visited, x + dir[0], y + dir[1]);
        }
    }

    public static void main(String[] args) {
        MinimumDaysToDisconnectGrid solver = new MinimumDaysToDisconnectGrid();

        int[][] grid1 = {
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
        System.out.println(solver.minDays(grid1)); // Output: 2

        int[][] grid2 = {
            {1, 1}
        };
        System.out.println(solver.minDays(grid2)); // Output: 2
    }
}

