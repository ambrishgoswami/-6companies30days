import java.util.*;

public class   RottenOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Initialize the queue with all initially rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // If there are no fresh oranges, return 0 (no time needed)
        if (freshOranges == 0) return 0;
        
        int minutesElapsed = -1;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutesElapsed++;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                
                // Infect adjacent fresh oranges
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    
                    // Check bounds and if the orange is fresh
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark orange as rotten
                        queue.offer(new int[]{newRow, newCol});
                        freshOranges--;
                    }
                }
            }
        }
        
        // If there are still fresh oranges left, return -1
        return freshOranges == 0 ? minutesElapsed : -1;
    }
    public static void main(String[] args){
      RottenOranges solution = new RottenOranges();

     // Example 1
     int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
     System.out.println(solution.orangesRotting(grid1)); 

    }
}

