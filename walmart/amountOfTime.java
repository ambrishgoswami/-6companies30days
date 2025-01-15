
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
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

        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infected = false;

            // Process each node at the current level
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

            // If any new node was infected, increment the time (minute)
            if (infected) {
                minutes++;
            }
        }

        return minutes;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (node == null) return;

        // Add the current node to the graph
        graph.putIfAbsent(node.val, new ArrayList<>());

        // If there is a parent, connect it to the current node
        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }

        // Recursively build the graph for left and right children
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        Solution solution = new Solution();
        int start1 = 3;
        System.out.println("Time to infect all nodes starting from node " + start1 + ": " + solution.amountOfTime(root1, start1));

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        int start2 = 4;
        System.out.println("Time to infect all nodes starting from node " + start2 + ": " + solution.amountOfTime(root2, start2));
    }
}

