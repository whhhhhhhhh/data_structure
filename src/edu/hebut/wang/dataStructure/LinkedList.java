package edu.hebut.wang.dataStructure;

/**
 * 模拟单项链表
 * 模拟双端链表的尾插
 * 模拟双向链表的删除尾节点
 * @param <T>
 */
public class LinkedList<T> {

    private Node<T> first;
    private Node<T> rear;
    private int size;

    private static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    /**
     * 从头部进行插入
     * 步骤：1.新结点的next链指向当前头结点；2.将first指向新节点
     * 时间复杂度：O(1)
     *
     * @param data
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = first;
        first = newNode;
        size++;
    }

    /**
     * 从头部进行删除操作
     * 步骤：1.将头结点的next链置空 2.将first引用指向第二个结点
     * 时间复杂度为：O(1)
     *
     * @return
     */
    public boolean deleteFirst() {
        if (isEmpty()) {
            return false;
        }
        Node secondNode = first.next;
        first.next = null;
        first = secondNode;
        size--;
        return true;
    }

    /**
     * 取出第i个结点
     * 步骤：从头结点进行遍历，取第i个结点
     * 时间复杂度：O(n)，此操作对于利用数组实现的顺序存储结构，仅需常数阶O(1)即可完成。
     *
     * @param index
     * @return
     */
    public T get(int index) throws Exception {
        if (!checkIndex(index)) {
            throw new Exception("index不合法");
        }
        Node<T> curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * 遍历线性表
     * 时间复杂度：O(n)
     */
    public void displayList() {
        Node<T> currNode = first;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    /**
     * 链表大小
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * index是否合法
     *
     * @param index
     * @return
     */
    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * 链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 双端链表，从尾部进行插入
     * 步骤：将当前尾结点的next链指向新节点即可
     * 时间复杂度：O(1)
     *
     * @param data
     */
    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
            rear = newNode;
            size++;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        size++;
    }

    /**
     * 删除尾结点
     * 主要步骤：1.将rear指向倒数第二个结点 2.处理相关结点的引用链
     * 时间复杂度：O(1)
     */
    public void deleteLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("链表为空");
        }
        Node<T> secondLast = rear.prev;
        rear.prev = null;
        rear = secondLast;
        if (rear == null) {
            first = null;
        } else {
            rear.next = null;
        }
        size--;
    }
}
