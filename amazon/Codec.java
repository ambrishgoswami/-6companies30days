import java.util.*;

public class Codec {

    // Serialize a binary tree to a single string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Deserialize a string to a binary tree
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Example Usage
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Create a sample binary tree: [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        String serialized = codec.serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        // Deserialize the string back to a tree
        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized Tree (Preorder Traversal):");
        printPreorder(deserializedRoot);
    }

    // Utility method to print the tree in preorder for verification
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
