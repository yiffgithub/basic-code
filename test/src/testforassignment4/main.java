package testforassignment4;

public class main {
    public static void main(String[] args) {
        // Create nodes for two binary trees
        TreeNode t1 = new TreeNode(23);
        t1.left = new TreeNode(17);
        t1.right = new TreeNode(39);
        t1.left.left = new TreeNode(9);
        t1.right.right = new TreeNode(78);
        t1.right.right.right = new TreeNode(61);

        TreeNode t2 = new TreeNode(18);
        t2.left = new TreeNode(15);
        t2.right = new TreeNode(20);
        t2.right.right = new TreeNode(25);
        t2.left.right = new TreeNode(16);
        t2.left.right.left = new TreeNode(19);

        // Create an instance of MergeBinaryTree and merge the two binary trees
        MergeBinaryTree merger = new MergeBinaryTree();
        TreeNode merged = merger.merge(t1, t2);

        // Create an instance of BST and insert nodes
        BST bst = new BST();
        // Insert all nodes of 'merged' into 'bst'
        dfs(merged, bst);
        bst.insert(844645);
        bst.insert(0);

        // Preorder traversal
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
        Rotation rotation = new Rotation();
        if (!isBalanced) {
            bst.root = rotation.singleRotation(bst.root, true);
        }

        // Check again if the tree is balanced
        isBalanced = avl.checkBalance(bst.root);
        System.out.println("Is the tree balanced after rotation? " + isBalanced);
    }

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

    public static class Rotation {
        public TreeNode singleRotation(TreeNode root, boolean rotateLeft) {
            if (rotateLeft) {
                TreeNode newRoot = root.right;
                root.right = newRoot.left;
                newRoot.left = root;
                return newRoot;
            } else {
                TreeNode newRoot = root.left;
                root.left = newRoot.right;
                newRoot.right = root;
                return newRoot;
            }
        }

        public TreeNode doubleRotation(TreeNode root, boolean rotateLeft) {
            if (rotateLeft) {
                root.right = singleRotation(root.right, false);
                return singleRotation(root, true);
            } else {
                root.left = singleRotation(root.left, true);
                return singleRotation(root, false);
            }
        }
    }

    // 1. MergeBinaryTree类
    public static class MergeBinaryTree {
        public TreeNode merge(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            t1.val += t2.val;
            t1.left = merge(t1.left, t2.left);
            t1.right = merge(t1.right, t2.right);
            return t1;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 2. BST类
    public static class BST {
        TreeNode root;

        public void insert(int val) {
            root = insertRec(root, val);
        }

        TreeNode insertRec(TreeNode root, int val) {
            if (root == null) {
                root = new TreeNode(val);
                return root;
            }
            if (val < root.val) {
                root.left = insertRec(root.left, val);
            } else if (val > root.val) {
                root.right = insertRec(root.right, val);
            }
            return root;
        }
    }

    public static class AVL {public int height(TreeNode root) {


        if (root == null) {
            return 0;
        }
        /*System.out.println("the height of this tree is  "+ Math.max(height(root.left), height(root.right)) + 1);*/

        return Math.max(height(root.left), height(root.right)) + 1;

    }

        public boolean checkBalance(TreeNode root) {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.abs(leftHeight - rightHeight) <= 1;
        }
    }
}
