package assignment6;

public class failtest {

    public static void main(String[] args) {
        MWaySearchTreeNode testtree = new MWaySearchTreeNode();
        MWaySearchTreeNode.Node root = testtree.root;
        root.leaf = false;
        root.keys[0] = 50;
        root.keys[1]=60;
        root.keys[2]= 80;
        root.KeyNumber = 3;


        root.children[0] = new MWaySearchTreeNode.Node(new int[]{1, 2, 3,87,185,75,184});
        root.children[0].KeyNumber= 7;
        root.children[1] = new MWaySearchTreeNode.Node(new int[]{6,54,892,845,6});
        root.children[1].KeyNumber= 5;

        testtree.split(root.children[0], root, 0);
        System.out.println(root.toString());
        System.out.println(root.children[0]);
        System.out.println(root.children[1]);
        System.out.println(root.children[2]);
        
    }
}
