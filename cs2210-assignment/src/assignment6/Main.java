package assignment6;

public class Main {
    public static void main(String[] args) {
        // 创建一个度为 4 的 MWaySearchTreeNode
        MWaySearchTreeNode tree = new MWaySearchTreeNode(4);

        // 向树中添加一些关键字
        tree.put(50);
        tree.put(60);
        tree.put( 80);
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
        tree.put( 61);
        tree.put( 62);
        tree.put(57);
        tree.put(55);
        tree.put(56);
        System.out.println("Tree contains 71: " + tree.contains(71)); // 应打印 "Tree contains 71: false"
        System.out.println("Tree structure by printTree method:");
        System.out.println("Tree without inserting");
        tree.printTree(tree.root, 0);
        System.out.println("Tree after inserting 71:");
        tree.put( 71);
        tree.printTree(tree.root, 0);
        System.out.println("Tree after inserting 84:");
        tree.put( 84);
        //  tree.put(tree.root, 59);
       // MWaySearchTreeNode.printNode(tree.root);
       // MWaySearchTreeNode.BTreePrinter.printNode(tree.root);
        // 使用 printTree 方法打印树的结构

       // tree.printTree(tree.root, "");
        tree.printTree(tree.root, 0);

        // 使用 printNode 方法打印树的结构
      //  System.out.println("\nTree structure by printNode method:");
        //MWaySearchTreeNode.printNode(tree.root);

        System.out.println("Tree contains 71: " + tree.contains(71)); // 应打印 "Tree contains 71: true"
    }
}
//ffffffffffffffffff