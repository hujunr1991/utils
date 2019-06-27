package com.example.springboorutil.DataStructures.LinkedlLIst;

public class LinkedList<E> {

    public class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    // 在链表的index(0-based)位置添加新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        //先找到插入前的节点prev

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        size++;
    }

    //头节点添加元素
    public void addFrist(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    //get
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    //set
    public E set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.e = e;
    }

    //find--查找是否存在
    public boolean contains(E e) {
        Node prev = dummyHead.next;
        while (prev != null) {
            if (prev.e.equals(e)) {
                return true;
            }
            prev = prev.next;
        }
        return false;
    }

    //删除
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i=0; i < index - 1;i++) {
           //拿到要删除的节点的前一个节点
            cur = cur.next;
        }
        //获得删除节点
        Node ret = cur.next;
        //将节点之前指向节点之后
        cur.next = ret.next;
        //让删除节点的next为空
        ret.next = null;
        size--;
        return ret.e;
    }

    public E removeFrist(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "-> ");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
