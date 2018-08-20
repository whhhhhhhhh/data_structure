package edu.hebut.wang.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的特点：
 * 性质1：在二叉树的第i层上至多有2^(i-1)个节点(i >= 1)
 * 性质2：深度为k的二叉树至多有2^k-1个节点(k >=1)
 * 性质3：对于任意一棵二叉树T而言，其叶子节点数目为N0,度为2的节点数目为N2，则有N0 = N2 + 1。
 * 性质4：具有n个节点的完全二叉树的深度 h = log2n + 1。
 */
public class Tree {
    private Node root;
    private List<Node> list = new ArrayList<>();

    //    public Tree(){
//        init();
//    }
    //树的初始化:先从叶节点开始,由叶到根
//    public void init(){
//        Node x=new Node("X",null,null);
//        Node y=new Node("Y",null,null);
//        Node d=new Node("d",x,y);
//        Node e=new Node("e",null,null);
//        Node f=new Node("f",null,null);
//        Node c=new Node("c",e,f);
//        Node b=new Node("b",d,null);
//        Node a=new Node("a",b,c);
//        root =a;
//    }
    //定义节点类：
    private class Node {
        private int data;
        private Node lchild;//定义指向左子树的指针
        private Node rchild;//定义指向右子树的指针

        public Node(int data) {
            this.data = data;
            this.lchild = null;
            this.rchild = null;
        }
    }

    /**
     * 将数组构建成一个完全二叉树
     */
    public Node createTree(int[] arr) {
        List<Node> nodeList = new LinkedList<>();
        //构建节点并放入list中
        for (int nodeIndex = 0; nodeIndex < arr.length; nodeIndex++) {
            nodeList.add(new Node(arr[nodeIndex]));
        }
        //父节点数量为arr.length/2-1，父节点的左孩子下标为2n+1，右孩子为2n+2，构建父节点的左右节点
        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).lchild = nodeList.get(2 * parentIndex + 1);
            nodeList.get(parentIndex).rchild = nodeList.get(2 * parentIndex + 2);
        }
        //只有节点数为奇数时最后的父节点才有右孩子
        int lastParentIndex = arr.length / 2 - 1;
        nodeList.get(lastParentIndex).lchild = nodeList.get(lastParentIndex * 2 + 1);

        if (arr.length % 2 == 1) {
            nodeList.get(lastParentIndex).rchild = nodeList.get(lastParentIndex * 2 + 2);
        }
        root = nodeList.get(0);
        //返回根节点
        return root;
    }

    /**
     * 对该二叉树进行前序遍历 结果存储到list中
     */
    public void preOrder(Node node) {
//        if (node == null) {
//            return;
//        }
        list.add(node); //先将根节点存入list
//        preOrder(node.lchild);
//        preOrder(node.rchild);
        //如果左子树不为空继续往左找，在递归调用方法的时候一直会将子树的根存入list，这就做到了先遍历根节点
        if (node.lchild != null) {
            preOrder(node.lchild);
        }
        //无论走到哪一层，只要当前节点左子树为空，那么就可以在右子树上遍历，保证了根左右的遍历顺序
        if (node.rchild != null) {
            preOrder(node.rchild);
        }
    }

    /**
     * 对该二叉树进行中序遍历 结果存储到list中
     */
    public void inOrder(Node node) {
        if (node.lchild != null) {
            inOrder(node.lchild);
        }
        list.add(node);
        if (node.rchild != null) {
            inOrder(node.rchild);
        }
    }

    /**
     * 对该二叉树进行后序遍历 结果存储到list中
     */
    public void postOrder(Node node) {
        if (node.lchild != null) {
            postOrder(node.lchild);
        }
        if (node.rchild != null) {
            postOrder(node.rchild);
        }
        list.add(node);

    }


    /**
     * 非递归实现的二叉树后序遍历<br>
     * 借助于一个栈进行实现
     *
     * @param root
     */
    public void endWithOneStack(Node root) {
        System.out.println();
        if (root == null) {
            return;
        } else {
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            // 该节点代表已经打印过的节点，待会会及时的进行更新
            Node printedNode = null;
            while (!stack.isEmpty()) {
                // 获取 栈顶的元素的值，而不是pop掉栈顶的值
                root = stack.peek();
                // 如果当前栈顶元素的左节点不为空，左右节点均未被打印过，说明该节点是全新的，所以压入栈中
                if (root.lchild != null && printedNode != root.lchild && printedNode != root.rchild) {
                    stack.push(root.lchild);
                } else if (root.rchild != null && printedNode != root.rchild) {
                    // 第一层不满足，则说明该节点的左子树已经被打印过了。如果栈顶元素的右节点未被打印过，则将右节点压入栈中
                    stack.push(root.rchild);
                } else {
                    // 上面两种情况均不满足的时候则说明左右子树均被打印过，此时只需要弹出栈顶元素，打印该值即可
                    System.out.println("当前值为：" + stack.pop().data);
                    // 记得实时的更新打印过的节点的值
                    printedNode = root;
                }
            }
        }
    }

    /**
     * 非递归实现的二叉树的后序遍历<br>
     * 借助于两个栈来实现
     *
     * @param root
     */
    public void endWith2Stack(Node root) {
        System.out.println();
        if (root == null) {
            return;
        } else {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();

            stack1.push(root);
            // 对每一个头结点进行判断，先将头结点放入栈2中，然后依次将该节点的子元素放入栈1.顺序为left-->right。便是因为后序遍历为“左右根”
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root);
                if (root.lchild != null) {
                    stack1.push(root.lchild);
                }

                if (root.rchild != null) {
                    stack1.push(root.rchild);
                }
            }

            // 直接遍历输出栈2，即可实现后序遍历的节点值的输出
            while (!stack2.isEmpty()) {
                System.out.println("当前节点的值：" + stack2.pop().data);
            }
        }
    }

    /**
     * 非递归实现的二叉树的中序遍历
     *
     * @param root
     */
    public void mid(Node root) {
        System.out.println();
        if (root == null) {
            return;
        } else {
            Stack<Node> nodes = new Stack<>();

            // 使用或的方式是因为 第一次的时候战中元素为空，root的非null特性可以保证程序可以执行下去
            while (!nodes.isEmpty() || root != null) {
                // 当前节点元素值不为空，则放入栈中，否则先打印出当前节点的值，然后将头结点变为当前节点的右子节点。
                if (root != null) {
                    nodes.push(root);
                    root = root.lchild;
                } else {
                    Node temp = nodes.pop();
                    System.out.println("当前节点的值：" + temp.data);
                    root = temp.rchild;
                }
            }

        }
    }

    /**
     * 非递归实现的二叉树的先序遍历
     *
     * @param root
     */
    public void pre(Node root) {
        System.out.println();

        // 如果头结点为空，则没有遍历的必要性，直接返回即可
        if (root == null) {
            return;
        } else {
            // 初始化用于存放节点顺序的栈结构
            Stack<Node> nodes = new Stack<Node>();
            // 先把root节点放入栈中，便于接下来的循环放入节点操作
            nodes.add(root);

            while (!nodes.isEmpty()) {
                // 取出栈顶元素，判断其是否有子节点
                Node temp = nodes.pop();

                System.out.println("当前节点的值：" + temp.data);
                // 先放入右边子节点的原因是先序遍历的话输出的时候左节点优先于右节点输出，而栈的特性决定了要先放入右边的节点
                if (temp.rchild != null) {
                    nodes.push(temp.rchild);
                }
                if (temp.lchild != null) {
                    nodes.push(temp.lchild);
                }
            }
        }
    }


    /**
     * 返回当前数的深度
     * 说明:
     * 1、如果一棵树只有一个结点，它的深度为1。
     * 2、如果根结点只有左子树而没有右子树，那么树的深度是其左子树的深度加1；
     * 3、如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加1；
     * 4、如果既有右子树又有左子树，那该树的深度就是其左、右子树深度的较大值再加1。
     *
     * @return 树的深度
     */
    public int getTreeDepth(Node node) {

        if (node.lchild == null && node.rchild == null) {
            return 1;
        }
        int left = 0, right = 0;
        if (node.lchild != null) {
            left = getTreeDepth(node.lchild);
        }
        if (node.rchild != null) {
            right = getTreeDepth(node.rchild);
        }
        return left > right ? left + 1 : right + 1;
    }


    //得到遍历结果
    public List<Node> getResult() {
        return list;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node root = tree.createTree(arr);
        System.out.println("根节点是:" + root.data);
        tree.mid(root);
//        tree.preOrder(root);
        //tree.postOrder(root);
        for (Node node : tree.getResult()) {
            System.out.println(node.data);
        }
        System.out.println("树的深度是" + tree.getTreeDepth(root));

    }

}


