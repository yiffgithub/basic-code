package assignment6;

import java.util.Arrays;

public class MWaySearchTreeNode {
    static class Node {
        int[] keys; // keywords, must be an array
        Node[] children; // children must be an array
        int KeyNumber; // determining valid keywords
        boolean leaf = true; // determine if it is a leaf or not
        int t; // minimum degree, minimum number of children which is m

        public Node(int t) {
            this.t = t; // t >= 2
            this.children = new Node[2 * t];
            this.keys = new int[2 * t - 1];
        }

        public Node(int[] keys) {
            this.keys = keys;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, KeyNumber));
        }

        // Multi-way search method
        Node get(int key) {
            int i = 0;
            while (i < KeyNumber) {
                if (keys[i] == key) {
                    return this;
                }
                if (keys[i] > key) {
                    break;
                }
                i++;
            }
            // If it is a leaf, there is nothing below it, so return null
            if (leaf) {
                return null;
            }
            // If not a leaf
            return children[i].get(key);
        }

        // a method to insert key at a specified index
        void insertkey(int key, int index) {
            for (int i = KeyNumber - 1; i >= index; i--) {
                keys[i + 1] = keys[i]; // move elements from the back to the front
            }
            keys[index] = key; // insert element
            KeyNumber++;
        }

        // insert child node at the specified index in children
        void insertchild(Node child, int index) {
            System.arraycopy(children, index, children, index + 1, KeyNumber - index);
            children[index] = child;
        }
    }

    Node root;

    int t;
    final int Max_KEY_NUMBER; // maximum number of keywords
    final int Min_KEY_NUMBER;

    public MWaySearchTreeNode() {
        this(2);
    }

    public MWaySearchTreeNode(int t) {
        this.t = t;
        root = new Node(t);
        Max_KEY_NUMBER = 2 * t - 1;
        Min_KEY_NUMBER = t - 1;
    }

    // 1. Check if key exists
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    // 2. add key
    public void put( int key) {
        DoPut(root, key,null,0);
    }

    private void DoPut(Node node, int key,Node parent, int index ) {
        int i = 0;
        while (i < node.KeyNumber) {
            if (node.keys[i] == key) // this is an update operation, not an insertion operation
                return;
            if (node.keys[i]>key) // found the insert position, the current i is the insert position
            {
                break;
            }
            i++;
        }
        if (node.leaf) {
            node.insertkey(key, i);
        } else {
            DoPut(node.children[i], key,node,i);
        }
        if (node.KeyNumber == Max_KEY_NUMBER){
            split(node,parent,index);
        }
    }

    // Method for splitting nodes
    private void split(Node left, Node parent, int index) {
        // if the node to be split is the root node
        if(parent == null){
            Node newroot = new Node(t);
            newroot.leaf=false;
            newroot.insertchild(left,0);
            this.root = newroot;
            parent = newroot;
        }
        // create right node, copy all keys after t in leaf
        Node right = new Node(t);
        right.leaf = left.leaf;
        System.arraycopy(left.keys, t, right.keys, 0, t - 1);
        // if it is not a leaf node being split, remember to take the child nodes
        if (!left.leaf) {
            System.arraycopy(left.children, t, right.children, 0, t);
        }
        right.KeyNumber = t - 1;
        left.KeyNumber = t - 1;
        // the key at position t-1 needs to be inserted into the parent node
        int mid = left.keys[t - 1];
        parent.insertkey(mid, index);
        // make right to be parent's children (a new child)
        parent.insertchild(right, index + 1);
    }

    public void printTree(Node node, int level) {
        if (node == null)
            return;

        System.out.println("Level " + level + " Keys: " + Arrays.toString(Arrays.copyOfRange(node.keys, 0, node.KeyNumber)));

        if (!node.leaf) {
            for (int i = 0; i <= node.KeyNumber; i++) {
                printTree(node.children[i], level + 1);
            }
        }
    }
}
