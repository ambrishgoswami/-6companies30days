import java.util.*;

public class InfectionTime {
    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        // Step 1: Build the graph from the binary tree
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        // Step 2: Perform BFS to calculate infection time
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infected = false;

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                        infected = true;
                    }
                }
            }

            if (infected) {
                minutes++;
            }
        }

        return minutes;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (node == null) return;

        graph.putIfAbsent(node.val, new ArrayList<>());

        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    public static void main(String[] args) {
        InfectionTime solution = new InfectionTime();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(10);
        root1.right.right = new TreeNode(6);
        root1.left.right.left = new TreeNode(9);
        root1.left.right.right = new TreeNode(2);
        System.out.println(solution.amountOfTime(root1, 3)); // Output: 4

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println(solution.amountOfTime(root2, 1)); // Output: 0
    }
}

