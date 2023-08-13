package assignment6;

public class Main {
    public static void main(String[] args) {
        // Create an MWaySearchTreeNode with degree 4
        MWaySearchTreeNode tree = new MWaySearchTreeNode(4);

        // Add some keywords to the tree
        tree.put(50);
        tree.put(60);
        tree.put(80);
        tree.put(30);
        tree.put(35);
        tree.put(58);
        tree.put(59);
        tree.put(63);
        tree.put(70);
        tree.put(73);
        tree.put(100);
        tree.put(52);
        tree.put(54);
        tree.put(61);
        tree.put(62);
        tree.put(57);
        tree.put(55);
        tree.put(56);
        System.out.println("Tree contains 71: " + tree.contains(71)); // Should print "Tree contains 71: false"
        System.out.println("Tree structure by printTree method:");
        System.out.println("Tree without inserting");
        tree.printTree(tree.root, 0);
        System.out.println("Tree after inserting 71:");
        tree.put(71);
        tree.printTree(tree.root, 0);
        System.out.println("Tree after inserting 84:");
        tree.put(84);
        //  tree.put(tree.root, 59);
        // MWaySearchTreeNode.printNode(tree.root);
        // MWaySearchTreeNode.BTreePrinter.printNode(tree.root);
        // Use the printTree method to print the tree structure

        // tree.printTree(tree.root, "");
        tree.printTree(tree.root, 0);

        // Use the printNode method to print the tree structure
        //  System.out.println("\nTree structure by printNode method:");
        //MWaySearchTreeNode.printNode(tree.root);

        System.out.println("Tree contains 71: " + tree.contains(71)); // Should print "Tree contains 71: true"
    }
}
