package com.example.springboorutil.DataStructures.Map;

public class LinkedListMaptest<K ,V> implements Map<K,V> {


    public class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }


    private Node dummyHead;
    private int size;

    public LinkedListMaptest(Node dummyHead, int size) {
        this.dummyHead = new Node();
        this.size = size;
    }

    public Node getNode(K key) {
        Node node = dummyHead.next;
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //如果key拿到的值为空，直接赋值，否则更新该值
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            node = new Node(key, value,dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    //更新值，必存在
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node== null ? null : node.value ;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }
}
