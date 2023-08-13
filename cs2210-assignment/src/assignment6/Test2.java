package assignment6;

public class Test2 {
    public static void main(String[] args) {
        MWaySearchTreeNode tree = new MWaySearchTreeNode(3);
        tree.put( 10);
        tree.put( 20);
        tree.put( 30);
        tree.put( 40);
        tree.put( 50); // This will cause a split
        tree.printTree(tree.root, 0);
    }
}
