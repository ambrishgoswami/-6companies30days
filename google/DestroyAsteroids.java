import java.util.*;
public class DestroyAsteroids {
    public boolean canDestroyAllAsteroids(int mass, int[] asteroids) {
        // Sort the asteroids by mass in ascending order
        Arrays.sort(asteroids);

        long currentMass = mass; // Use long to avoid overflow during calculations

        for (int asteroid : asteroids) {
            if (currentMass >= asteroid) {
                currentMass += asteroid; // Destroy the asteroid and add its mass
            } else {
                return false; // If the planet cannot destroy an asteroid, return false
            }
        }

        return true; // All asteroids can be destroyed
    }

    public static void main(String[] args) {
        DestroyAsteroids solution = new DestroyAsteroids();

        // Example 1
        int mass1 = 10;
        int[] asteroids1 = {3, 9, 19, 5, 21};
        System.out.println(solution.canDestroyAllAsteroids(mass1, asteroids1)); // Output: true

        // Example 2
        int mass2 = 5;
        int[] asteroids2 = {4, 9, 23, 4};
        System.out.println(solution.canDestroyAllAsteroids(mass2, asteroids2)); // Output: false
    }
}
