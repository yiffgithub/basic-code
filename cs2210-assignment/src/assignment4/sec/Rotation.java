package assignment4.sec;

//import javax.swing.tree.TreeNode;

public class Rotation {

    // Single right rotation
    public TreeNode singleRightRotate(TreeNode root) {
        TreeNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    // Single left rotation
    public TreeNode singleLeftRotate(TreeNode root) {
        TreeNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }

    // Double left right rotation
    public TreeNode doubleLeftRightRotate(TreeNode root) {
        root.left = singleLeftRotate(root.left);
        return singleRightRotate(root);
    }

    // Double right left rotation
    public TreeNode doubleRightLeftRotate(TreeNode root) {
        root.right = singleRightRotate(root.right);
        return singleLeftRotate(root);
    }

    // Choose rotation method
    public TreeNode chooseRotationMethod(TreeNode root, boolean isLeftHeavy, boolean isLeftChildHeavy) {
        if (isLeftHeavy) {
            if (isLeftChildHeavy) {
                return singleRightRotate(root);
            } else {
                return doubleLeftRightRotate(root);
            }
        } else {
            if (isLeftChildHeavy) {
                return doubleRightLeftRotate(root);
            } else {
                return singleLeftRotate(root);
            }
        }
    }
    public static TreeNode balanceTree(TreeNode node) {
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
    }
}

