import java.util.*;
public class Solution6 {
    static class Result {
        boolean isBST;
        int sum, min, max;

        Result(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    private Result postOrder(TreeNode node) {
        if (node == null) {
            // Base case: Empty tree is a valid BST with sum = 0
            return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = postOrder(node.left);
        Result right = postOrder(node.right);

        // Check if the current tree is a valid BST
        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            int currentSum = node.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, currentSum);

            // Return current tree's result
            return new Result(true, currentSum, 
                              Math.min(node.val, left.min), 
                              Math.max(node.val, right.max));
        }

        // If not a BST, propagate invalid result
        return new Result(false, 0, 0, 0);
    }

    // Helper method for testing
    public static void main(String[] args) {
        Solution6 solution = new Solution6();

        // Example 1
        TreeNode root1 = new TreeNode(1,
            new TreeNode(4,
                new TreeNode(2),
                new TreeNode(4)
            ),
            new TreeNode(3,
                new TreeNode(2),
                new TreeNode(5,
                    new TreeNode(4),
                    new TreeNode(6)
                )
            )
        );
        System.out.println(solution.maxSumBST(root1)); // Output: 20

        // Example 2
        TreeNode root2 = new TreeNode(4,
            new TreeNode(3,
                new TreeNode(1),
                new TreeNode(2)
            ),
            null
        );
        System.out.println(solution.maxSumBST(root2)); // Output: 2

        // Example 3
        TreeNode root3 = new TreeNode(-4,
            new TreeNode(-2),
            new TreeNode(-5)
        );
        System.out.println(solution.maxSumBST(root3)); // Output: 0
    }
}

// TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

