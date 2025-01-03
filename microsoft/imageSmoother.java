
public class imageSmoother {
    public int[][] imageSmoother1(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] result = new int[m][n];

        // Iterate through each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0, count = 0;

                // Iterate through the 3x3 window
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        // Check if the cell is within bounds
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            sum += img[r][c];
                            count++;
                        }
                    }
                }

                // Calculate the smoothed value
                result[i][j] = sum / count;
            }
        }

        return result;
    }

    public static void main(String[] args) {
       imageSmoother smoother = new imageSmoother();

        // Test case 1
        int[][] img1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] result1 = smoother.imageSmoother1(img1);
        for (int[] row : result1) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // Test case 2
        int[][] img2 = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        int[][] result2 = smoother.imageSmoother1(img2);
        for (int[] row : result2) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

