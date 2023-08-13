package assignment6;

public class TestRootSplit {
    public static void main(String[] args) {
        MWaySearchTreeNode testtree = new MWaySearchTreeNode(4);
        MWaySearchTreeNode.Node root = testtree.root;
        root.leaf = false;
        root.keys[0] = 50;
        root.keys[1] = 60;
        root.keys[2] = 80
        ;
        root.KeyNumber = 3;
        root.children[0] = new MWaySearchTreeNode.Node(new int[]{30, 35});
        root.children[0].KeyNumber = 2;
        root.children[1] = new MWaySearchTreeNode.Node(new int[]{52, 54, 55, 56, 57, 58, 59});
        root.children[1].KeyNumber = 7;
        root.children[2] = new MWaySearchTreeNode.Node(new int[]{61, 62, 63, 70, 73});

        root.children[2].KeyNumber = 5;
        root.children[3] = new MWaySearchTreeNode.Node(new int[]{100});
        root.children[3].KeyNumber = 1;


        System.out.println("Tree structure by printTree method:");

        testtree.printTree(testtree.root, 0);
        //    testtree.split(root.children[0],root,0);



    }
}
