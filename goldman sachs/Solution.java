import java.util.*;
public class Solution {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int k, int n, int start, List<Integer> combination, List<List<Integer>> result) {
        // Base case: If the combination is valid, add it to the result
        if (combination.size() == k && n == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        // Explore further combinations
        for (int i = start; i <= 9; i++) {
            // Add the current number to the combination
            combination.add(i);
            // Recursively explore further numbers with the updated sum and combination
            backtrack(k, n - i, i + 1, combination, result);
            // Backtrack by removing the last added number
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Example 1
        int k1 = 3, n1 = 7;
        System.out.println(combinationSum3(k1, n1)); // Output: [[1, 2, 4]]
        
        // Example 2
        int k2 = 3, n2 = 9;
        System.out.println(combinationSum3(k2, n2)); // Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
        
        // Example 3
        int k3 = 4, n3 = 1;
        System.out.println(combinationSum3(k3, n3)); // Output: []
    }
}
