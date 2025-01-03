
import java.util.*;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // Use a map for memoization to avoid redundant computations
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        // Check if we already computed the result for the current needs
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int n = needs.size();
        // Calculate the cost without using any special offers
        int minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += needs.get(i) * price.get(i);
        }

        // Try to use each special offer
        for (List<Integer> offer : special) {
            List<Integer> newNeeds = new ArrayList<>();
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                // If the offer provides more items than needed, it's invalid
                if (needs.get(i) < offer.get(i)) {
                    valid = false;
                    break;
                }
                // Compute the remaining needs after applying the offer
                newNeeds.add(needs.get(i) - offer.get(i));
            }

            // If the offer is valid, calculate the cost recursively
            if (valid) {
                minCost = Math.min(minCost, offer.get(n) + dfs(price, special, newNeeds, memo));
            }
        }

        // Store the result in the memoization map
        memo.put(needs, minCost);
        return minCost;
    }

    public static void main(String[] args) {
        ShoppingOffers so = new ShoppingOffers();

        // Example 1
        List<Integer> price1 = Arrays.asList(2, 5);
        List<List<Integer>> special1 = Arrays.asList(
                Arrays.asList(3, 0, 5),
                Arrays.asList(1, 2, 10)
        );
        List<Integer> needs1 = Arrays.asList(3, 2);
        System.out.println(so.shoppingOffers(price1, special1, needs1)); // Output: 14

        // Example 2
        List<Integer> price2 = Arrays.asList(2, 3, 4);
        List<List<Integer>> special2 = Arrays.asList(
                Arrays.asList(1, 1, 0, 4),
                Arrays.asList(2, 2, 1, 9)
        );
        List<Integer> needs2 = Arrays.asList(1, 2, 1);
        System.out.println(so.shoppingOffers(price2, special2, needs2)); // Output: 11
    }
}

