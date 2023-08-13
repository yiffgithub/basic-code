package assignment6;

public class Test1 {
    public static void main(String[] args) {
        MWaySearchTreeNode tree = new MWaySearchTreeNode(3);
        tree.put(10);
        tree.put( 20);
        tree.put(30);
        tree.printTree(tree.root, 0);
    }
}
