
import java.util.*;

public class overlapRectangle {
    private int[][] rects;
    private int[] prefixSums;
    private int totalPoints;
    private Random random;

    public overlapRectangle(int[][] rects) {
        this.rects = rects;
        this.random = new Random();

        
        int n = rects.length;
        prefixSums = new int[n];
        totalPoints = 0;

        for (int i = 0; i < n; i++) {
            int[] rect = rects[i];
            int points = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1); 
            totalPoints += points;
            prefixSums[i] = totalPoints;
        }
    }

    public int[] pick() {
       
        int target = random.nextInt(totalPoints); 
        int rectIndex = binarySearch(target);

        // Pick a random point inside the selected rectangle
        int[] rect = rects[rectIndex];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1); 
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }

    private int binarySearch(int target) {
        int left = 0, right = prefixSums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] rects = {{-2, -2, 1, 1}, {2, 2, 4, 6}};
        overlapRectangle solution = new overlapRectangle(rects);

        // Generate 5 random picks
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(solution.pick()));
        }
    }
}

