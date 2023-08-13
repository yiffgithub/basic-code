package assignment4.sec;

public class Q2 {
    public static void main(String[] args) {
        // Create nodes for two binary trees
        TreeNode t1 = new TreeNode(23);
        t1.left = new TreeNode(17);
        t1.right = new TreeNode(39);
        t1.left.left = new TreeNode(9);
        t1.right.right = new TreeNode(78);
        t1.right.right.left = new TreeNode(61);

        TreeNode t2 = new TreeNode(18);
        t2.left = new TreeNode(15);
        t2.right = new TreeNode(20);
        t2.right.right = new TreeNode(25);
        t2.left.right = new TreeNode(16);
        t2.left.right.left = new TreeNode(19);

        // Create an instance of MergeBinaryTree and merge the two binary trees
        MergeBinaryTree merger = new MergeBinaryTree();
        TreeNode merged = merger.merge(t1, t2);
        // orginal tree
        System.out.println("The traversal method is Preorder Traversal");

        System.out.println("Traversing the original merged tree:");
        preOrderTraversal(merged);;

        // Create an instance of BST and insert nodes
        BST bst = new BST();
        // Insert all nodes of 'merged' into 'bst'
        dfs(merged, bst);
        /*bst.insert(99999);
        bst.insert(9999);*/
        bst.insert(999);
        bst.insert(0);
      //  bst.insert(8);
        //  bst.insert(7);

        // Preorder traversal after insert
        System.out.println("\n");
        System.out.println("The traversal method is Preorder Traversal");

        System.out.println("Traversing the bst after inserting 0 and 9999:");
        preOrderTraversal(bst.root);

        // Create an instance of AVL and check if the tree is balanced
        AVL avl = new AVL();
        int height = avl.height(bst.root);
        // Print the height
        System.out.println("\n");
        System.out.println("The height of bst is " + height);
        boolean isBalanced = avl.checkBalance(bst.root);
        System.out.println("\n");
        System.out.println("Is the tree balanced? " + isBalanced);

        // Create an instance of Rotation and perform rotation operation
      //  Rotation rotation = new Rotation();


        System.out.println("-------------------");
        preOrderTraversal(bst.root);
        if (!isBalanced) {
            bst.root= Rotation.balanceTree(bst.root);
        }
        System.out.println('\n');
        System.out.println("-------------------");
        preOrderTraversal(bst.root);

        // Check again if the tree is balanced
        //  isBalanced = avl.checkBalance(bst.root);
   isBalanced = avl.checkBalance(bst.root);
        System.out.println('\n');

        System.out.println("Is the tree balanced after rotation? " + isBalanced);

           /* while (!isBalanced) {
                boolean flag1   =  avl.isLeftChildHeavy(bst.root);
                boolean flag2 = avl.isLeftHeavy(bst.root);*/
                //  boolean flag3 = avl.isRightChildHeavy(bst.root);
                // boolean flag4 = avl.isRightChildHeavy(bst.root);
                // bst.root = rotation.singleRotation(bst.root, true);
                // bst.root = rotation.doubleRotation(bst.root,true);

                //bst.root=    rotation.chooseRotationMethod(bst.root, flag2, flag1);
            /*    isBalanced = avl.checkBalance(bst.root);
              //  System.out.println(isBalanced);*/
            }




    /*public static TreeNode balanceTree(TreeNode node) {
        // Base case: if node is null, return null
        if (node == null) {
            return null;
        }

        // First, balance the children of the node
        node.left = balanceTree(node.left);
        node.right = balanceTree(node.right);
        AVL avl = new AVL();
        Rotation rotation = new Rotation();
        // Then, check if the node itself is balanced
        boolean isBalanced = avl.checkBalance(node);
        if (!isBalanced) {
            boolean isLeftHeavy = avl.isLeftHeavy(node);
            boolean isLeftChildHeavy;
            if (isLeftHeavy) {
                isLeftChildHeavy = avl.isLeftChildHeavy(node);
            } else {
                isLeftChildHeavy = avl.isRightChildHeavy(node);
            }
            node = rotation.chooseRotationMethod(node, isLeftHeavy, isLeftChildHeavy);
        }

        // Return the (possibly new) node
        return node;
    }*/



    // Preorder traversal
    public static void preOrderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    // Transfer all values from one binary tree to another
    public static void dfs(TreeNode node, BST bst) {
        if (node != null) {
            bst.insert(node.val);
            dfs(node.left, bst);
            dfs(node.right, bst);
        }
    }

}
