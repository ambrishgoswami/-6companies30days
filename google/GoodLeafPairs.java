class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class GoodLeafPairs {

    public int countPairs(TreeNode root, int distance) {
        int[] result = new int[1];
        dfs(root, distance, result);
        return result[0];
    }

    private int[] dfs(TreeNode node, int distance, int[] result) {
        if (node == null) {
            return new int[distance + 1];
        }

        if (node.left == null && node.right == null) {
            int[] leafDistances = new int[distance + 1];
            leafDistances[1] = 1; // A leaf node contributes at distance 1
            return leafDistances;
        }

        int[] leftDistances = dfs(node.left, distance, result);
        int[] rightDistances = dfs(node.right, distance, result);

        // Count good pairs from left and right subtrees
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    result[0] += leftDistances[i] * rightDistances[j];
                }
            }
        }

        // Aggregate distances for the current node
        int[] currentDistances = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentDistances[i + 1] = leftDistances[i] + rightDistances[i];
        }

        return currentDistances;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3));
        System.out.println(new GoodLeafPairs().countPairs(root1, 3)); // Output: 1

        // Example 2
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(new GoodLeafPairs().countPairs(root2, 3)); // Output: 2

        // Example 3
        TreeNode root3 = new TreeNode(7,
                new TreeNode(1, new TreeNode(6), null),
                new TreeNode(4, new TreeNode(5), new TreeNode(3, null, new TreeNode(2))));
        System.out.println(new GoodLeafPairs().countPairs(root3, 3)); // Output: 1
    }
}

