package assignment6;

public class Test3 {
    public static void main(String[] args) {
        MWaySearchTreeNode tree = new MWaySearchTreeNode(3);
        tree.put( 10);
        tree.put( 20);
        tree.put( 30);
        tree.put( 40);
        tree.put( 50);
        tree.put( 60);
        //tree.put(tree.root, 70); // This will cause the root to split
        tree.printTree(tree.root, 0);
    }
}

