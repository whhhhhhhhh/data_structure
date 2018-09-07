package edu.hebut.wang.datastructure;

/**
 * 二叉排序树
 * 左子树都小于根节点，右子树都大于根节点
 */
public class BinarySortTree {

    //根节点
    private Node root;

    /**
     * 树的结点
     */
    private static class Node {
        //数据域
        private long data;
        //左子结点
        private Node leftChild;
        //右子结点
        private Node rightChild;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 插入结点
     *
     * @param data
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        Node currNode = root;
        Node parentNode;
        //如果是空树
        if (root == null) {
            root = newNode;
            return;
        }
        while (true) {
            parentNode = currNode;
            //向右搜寻
            if (data > currNode.data) {
                currNode = currNode.rightChild;
                if (currNode == null) {
                    parentNode.rightChild = newNode;
                    return;
                }
            } else {
                //向左搜寻
                currNode = currNode.leftChild;
                if (currNode == null) {
                    parentNode.leftChild = newNode;
                    return;
                }
            }
        }

    }

    /**
     * 前序遍历
     *
     * @param currNode
     */
    public void preOrder(Node currNode) {
        if (currNode == null) {
            return;
        }
        System.out.print(currNode.data + " ");
        preOrder(currNode.leftChild);
        preOrder(currNode.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param currNode
     */
    public void inOrder(Node currNode) {
        if (currNode == null) {
            return;
        }
        inOrder(currNode.leftChild);
        System.out.print(currNode.data + " ");
        inOrder(currNode.rightChild);

    }

    /**
     * 后序遍历
     *
     * @param currNode
     */
    public void postOrder(Node currNode) {
        if (currNode == null) {
            return;
        }
        postOrder(currNode.leftChild);
        postOrder(currNode.rightChild);
        System.out.print(currNode.data + " ");
    }

    /**
     * 查找结点
     *
     * @param data
     * @return
     */
    public Node find(long data) {
        Node currNode = root;
        while (currNode != null) {
            if (data > currNode.data) {
                currNode = currNode.rightChild;
            } else if (data < currNode.data) {
                currNode = currNode.leftChild;
            } else {
                return currNode;
            }
        }
        return null;
    }

    /**
     * 删除结点 分为3种情况
     * 1.叶子结点
     * 2.该节点有一个子节点
     * 3.该节点有二个子节点， 找到中序遍历的后继节点替换删除的节点
     * @param data
     */
    public boolean delete(long data) throws Exception {
        Node curr = root;
        //保持一个父节点的引用
        Node parent = curr;
        //删除结点是左子结点还是右子结点，
        boolean isLeft = true;
        while (curr != null && curr.data != data) {
            parent = curr;
            if (data > curr.data) {
                curr = curr.rightChild;
                isLeft = false;
            } else {
                curr = curr.leftChild;
                isLeft = true;
            }
        }
        if (curr == null) {
            throw new Exception("要删除的结点不存在");
        }
        //第一种情况,要删除的结点为叶子结点
        if (curr.leftChild == null && curr.rightChild == null) {
            if (curr == root) {
                root = null;
                return true;
            }
            if (isLeft) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (curr.leftChild == null) {
            //第二种情况，要删除的结点有一个子节点且是右子结点
            if (curr == root) {
                root = curr.rightChild;
                return true;
            }
            if (isLeft) {
                parent.leftChild = curr.rightChild;
            } else {
                parent.rightChild = curr.rightChild;
            }
        } else if (curr.rightChild == null) {
            //第二种情况，要删除的结点有一个子节点且是左子结点
            if (curr == root) {
                root = curr.leftChild;
                return true;
            }
            if (isLeft) {
                parent.leftChild = curr.leftChild;
            } else {
                parent.rightChild = curr.leftChild;
            }
        } else {
            //第三种情况，也是最复杂的一种情况，要删除的结点有两个子节点，需要找寻中序后继结点
            Node succeeder = getSucceeder(curr);
            if (curr == root) {
                root = succeeder;
                return true;
            }
            if (isLeft) {
                parent.leftChild = succeeder;
            } else {
                parent.rightChild = succeeder;
            }
            //当后继结点为删除结点的右子结点
            succeeder.leftChild = curr.leftChild;

        }
        return true;
    }

    public Node getSucceeder(Node delNode) {
        Node succeeder = delNode;
        Node parent = delNode;
        Node currNode = delNode.rightChild;
        //寻找后继结点
        while (currNode != null) {
            parent = succeeder;
            succeeder = currNode;
            currNode = currNode.leftChild;
        }
        //如果后继结点不是要删除结点的右子结点
        if (succeeder != delNode.rightChild) {
            parent.leftChild = succeeder.rightChild;
            //将后继结点的左右子结点分别指向要删除结点的左右子节点
            succeeder.leftChild = delNode.leftChild;
            succeeder.rightChild = delNode.rightChild;
        }
        return succeeder;

    }

}
