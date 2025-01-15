public class CarCollisions {

    public int countCollisions(String directions) {
        int n = directions.length();
        int collisions = 0;

        // Trim left-moving cars 'L' at the start
        int i = 0;
        while (i < n && directions.charAt(i) == 'L') {
            i++;
        }

        // Trim right-moving cars 'R' at the end
        int j = n - 1;
        while (j >= 0 && directions.charAt(j) == 'R') {
            j--;
        }

        // Count the remaining cars
        for (int k = i; k <= j; k++) {
            if (directions.charAt(k) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }

    public static void main(String[] args) {
        CarCollisions solver = new CarCollisions();

        // Test cases
        System.out.println(solver.countCollisions("RLRSLL")); // Output: 5
        System.out.println(solver.countCollisions("LLRR"));   // Output: 0
        System.out.println(solver.countCollisions("SSRRLL")); // Output: 4
        System.out.println(solver.countCollisions("RRS"));    // Output: 2
    }
}

