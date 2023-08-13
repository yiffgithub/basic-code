package assignment4.sec;

//import javax.swing.tree.TreeNode;

//import javax.swing.tree.TreeNode;

//import javax.swing.tree.TreeNode;

public class AVL {

    public int height(TreeNode root) {


        if (root == null) {
            return 0;
        }
        /*System.out.println("the height of this tree is  "+ Math.max(height(root.left), height(root.right)) + 1);*/

        return Math.max(height(root.left), height(root.right)) + 1;

    }

    public boolean checkBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1
                && checkBalance(root.left)
                && checkBalance(root.right);
    }

    public boolean isLeftHeavy(TreeNode node) {
        return height(node.left) > height(node.right);
    }

    // Method to check if the right subtree is heavier
    public boolean isRightHeavy(TreeNode node) {
        return height(node.right) > height(node.left);
    }

    // Method to check if the left child of a subtree is heavier
    public boolean isLeftChildHeavy(TreeNode node) {
        if (node.left != null) {
            return height(node.left.left) > height(node.left.right);
        }
        return false;
    }

    // Method to check if the right child of a subtree is heavier
    public boolean isRightChildHeavy(TreeNode node) {
        if (node.right != null) {
            return height(node.right.right) > height(node.right.left);
        }
        return false;
    }

}



