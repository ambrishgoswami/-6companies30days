 import java.util.*;

class ThroneInheritance {
    private static class Node {
        String name;
        List<Node> children;
        boolean isAlive;

        Node(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.isAlive = true;
        }
    }

    private final Node king;
    private final Map<String, Node> map;

    public ThroneInheritance(String kingName) {
        this.king = new Node(kingName);
        this.map = new HashMap<>();
        map.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Node parent = map.get(parentName);
        Node child = new Node(childName);
        parent.children.add(child);
        map.put(childName, child);
    }

    public void death(String name) {
        Node node = map.get(name);
        if (node != null) {
            node.isAlive = false;
        }
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        preorderTraversal(king, order);
        return order;
    }

    private void preorderTraversal(Node node, List<String> order) {
        if (node.isAlive) {
            order.add(node.name);
        }
        for (Node child : node.children) {
            preorderTraversal(child, order);
        }
    }

    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king");
        t.birth("king", "andy");
        t.birth("king", "bob");
        t.birth("king", "catherine");
        t.birth("andy", "matthew");
        t.birth("bob", "alex");
        t.birth("bob", "asha");
        System.out.println(t.getInheritanceOrder()); // Output: [king, andy, matthew, bob, alex, asha, catherine]
        t.death("bob");
        System.out.println(t.getInheritanceOrder()); // Output: [king, andy, matthew, alex, asha, catherine]
    }
}

