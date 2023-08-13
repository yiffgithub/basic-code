package assignment6;

import java.util.Arrays;

public class MWaySearchTreeNode {
    static class Node {
        int[] keys;//key words, must be an array
        Node[] children; //children must be array
        int KeyNumber; //判断有效的关键词
        boolean leaf = true; // decide if or if not a leaf
        int t; //最小度数，最小孩子数 就是m

        public Node(int t) {


            this.t = t; // t >=2
            this.children = new Node[2 * t];
            this.keys = new int[2 * t - 1];


        }
        public Node(int[] keys){
            this.keys = keys;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, KeyNumber));
        }
        //多路查找方法

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


            }//如果是叶子，代表下面什么都没有，所以反悔null
            if (leaf) {
                return null;
            }
            //如果不是叶子
            return children[i].get(key);

        }

        //a method to insert key in 指定的index
        //写一个方法在指定的索引处插入key
        //【1，3，5】如果要插入一个2，那么就要先把3和5向后推进一个index，然后插入
        void insertkey(int key, int index) {

            for (int i = KeyNumber - 1; i >= index; i--) {
                keys[i + 1] = keys[i];//从后往前向后推进element
            }
            keys[index] = key;// insert element
            KeyNumber++;

        }
        // there is another method for inserting index by arraycopy
       /* void insertkey (int key , int index){
            System.arraycopy(keys, index, keys, index+1, KeyNumber - index);
            keys[index] = key;
            KeyNumber ++;

        }*/


        //想children index那里插入 children
        void insertchild(Node child, int index) {
            //从后往前移动元素
            System.arraycopy(children, index, children, index + 1, KeyNumber - index);
            children[index] = child;
            //KeyNumber++;


        }
    }

    Node root;

    int t;
    final int Max_KEY_NUMBER; //最大关键词，final为不可更改的变量
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

    //1. key exist
    //use get method
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    //2. add  key
 /*   首先查找本节点中的插入位置 i，如果没有空位 (key 被找到)应该走更新的逻辑，目前什么没做
            接下来分两种情况
    如果节点是叶子节点，可以直接插入了
。 如果节点是非叶子节点，需要继续在 children[i] 处继续递归插入无论哪种情况，插入完成后都可能超过节点 keys 数目限制，此时应当执行节点分裂*/
    public void put( int key) {
        DoPut(root, key,null,0);

    }

    private void DoPut(Node node, int key,Node parent, int index ) {

        int i = 0;
        while (i < node.KeyNumber) {
            if (node.keys[i] == key)//这是一个更新操作，而不是i插入操作
                return;
            if (node.keys[i]>key) //找到了插入位置，现在的i就是插入位置
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
  /*  private void DoPut(Node node, int key, Node parent, int index) {
        int i = 0;
        while (i < node.KeyNumber) {
            if (node.keys[i] == key) //这是一个更新操作，而不是插入操作
                return;
            if (node.keys[i]>key) //找到了插入位置，现在的i就是插入位置
            {
                break;
            }
            i++;
        }

        if (node.leaf) {
            // Check if the node is full
            if (node.KeyNumber == Max_KEY_NUMBER) {
                // If the node is the root
                if(parent == null) {
                    Node newRoot = new Node(t);
                    newRoot.leaf = false;
                    newRoot.insertchild(node, 0);
                    this.root = newRoot;
                    parent = newRoot;
                    index = 0;
                }
                // Split the node
                split(node, parent, index);
                // Retry insertion with the parent
                DoPut(root, key,null,0);
            } else {
                node.insertkey(key, i);
            }
        } else {
            // If the child node is full
            if (node.children[i].KeyNumber == Max_KEY_NUMBER) {
                // Split the child node
                split(node.children[i], node, i);
                // If the key is greater than the middle key in the child, insert into the new right child
                if (key > node.keys[i]) {
                    i++;
                }
            }
            DoPut(node.children[i], key, node, i);
        }

        // No need to check for splitting here, because it will be done in the next recursion level if needed
    }*/


    //创建 right 节点 (分烈后大于当前 left 节点的)，把t 以后的 key 和 child 都拷贝过去。
    // t-1处的 key 插入到 parent 的 index 处，index 指left 作为孩子时的索right 节点作为 parent 的孩子插入到 index +1处
    //分列方法
    /*Parameter
    left：要分割的点
    parent，要分割的点的父节点
    index：分割节点的第几个孩子，是一个索引*/
    public void split(Node left, Node parent, int index) {
        //如果需要分别的是root节点
        if(parent == null){
            Node newroot = new Node(t);
            newroot.leaf=false;
            newroot.insertchild(left,0);
            this.root = newroot;
            parent = newroot;

        }
        //创建right节点，把leaf种t之后的key全拷贝过去
        Node right = new Node(t);
        right.leaf = left.leaf;
        System.arraycopy(left.keys, t, right.keys, 0, t - 1);
        //如果分裂的不是叶子节点，别忘了把子节点，就是孩子带过去
        if (!left.leaf) {
            System.arraycopy(left.children, t, right.children, 0, t);
        }
        right.KeyNumber = t - 1;
        left.KeyNumber = t - 1;
        //中间的key（也就是t-1处）的要插入到父结点中去
        int mid = left.keys[t - 1];
        parent.insertkey(mid, index);
        // make right to be parent's children (a new child)
        parent.insertchild(right, index + 1);
    }
    /*public void printTree(Node node, String indent) {
        if (node == null) {
            System.out.println(indent + "null");
            return;
        }

        // 打印此节点的所有关键字
        System.out.println(indent + "Keys: " + Arrays.toString(Arrays.copyOfRange(node.keys, 0, node.KeyNumber)));

        // 如果此节点不是叶子节点，则递归地打印其所有子节点
        if (!node.leaf) {
            for (int i = 0; i <= node.KeyNumber; i++) {
                printTree(node.children[i], indent + "  ");
            }
        }
    }*/
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




    //3. delete key

    // 在 MWaySearchTreeNode 类中添加以下方法
   /* public void printTree(Node node, String prefix) {
        if (node == null) {
            System.out.println(prefix + "- null");
            return;
        }

        // 打印此节点的所有关键字
        System.out.println(prefix + "- Keys: " + Arrays.toString(Arrays.copyOfRange(node.keys, 0, node.KeyNumber)));

        // 如果此节点不是叶子节点，则递归地打印其所有子节点
        if (!node.leaf) {
            for (int i = 0; i <= node.KeyNumber; i++) {
                printTree(node.children[i], prefix + "  |");
            }
        }
    }*/

}




















