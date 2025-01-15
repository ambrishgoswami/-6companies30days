public class PreorderSerialization {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int slots = 1; // Root provides one slot

        for (String node : nodes) {
            // Each node occupies one slot
            slots--;

            // If at any point slots are negative, the serialization is invalid
            if (slots < 0) {
                return false;
            }

            // Non-null nodes add two slots (left and right child)
            if (!node.equals("#")) {
                slots += 2;
            }
        }

        // All slots should be used up for valid serialization
        return slots == 0;
    }

    public static void main(String[] args) {
        PreorderSerialization solution = new PreorderSerialization();

        String preorder1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(solution.isValidSerialization(preorder1)); // Output: true

        String preorder2 = "1,#";
        System.out.println(solution.isValidSerialization(preorder2)); // Output: false

        String preorder3 = "9,#,#,1";
        System.out.println(solution.isValidSerialization(preorder3)); // Output: false
    }
}

