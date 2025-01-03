
public class Overlap {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
       
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));
        
       
        int distanceX = xCenter - closestX;
        int distanceY = yCenter - closestY;

     
        return (distanceX * distanceX + distanceY * distanceY) <= (radius * radius);
    }

    public static void main(String[] args) {
        Overlap solution = new Overlap();

        // Test case 1
        System.out.println(solution.checkOverlap(1, 0, 0, 1, -1, 3, 1)); // Output: true

        // Test case 2
        System.out.println(solution.checkOverlap(1, 1, 1, 1, -3, 2, -1)); // Output: false

        // Test case 3
        System.out.println(solution.checkOverlap(1, 0, 0, -1, 0, 0, 1)); // Output: true
    }
}
