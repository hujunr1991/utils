//package com.example.springboorutil.HashMapTest;
//
//
//import java.io.Serializable;
//import java.util.AbstractMap;
//import java.util.Map;
//import java.util.Objects;
//
//public class HashMaptest<K, V> extends AbstractMap
//        implements Map<K, V>,Cloneable, Serializable {
//
//    static final int DEFAULT_INITIAL_CAPACITY = 1<<4;
//    static final int MAXIMUM_CAPACITY = 1<<30;
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//    static final int TREEIFY_THRESHOLD = 8;
//    static final int UNTREEIFY_THRESHOLD = 6;
//    static final int MIN_TREEIFY_CAPACITY = 64;
//
//
//    static class Node<K, V> implements Map.Entry<K, V> {
//        final int hash;
//        final K key;
//        V value;
//        Node<K,V> next;
//
//        private Node(int hash, K key, V value, Node<K, V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        @Override
//        public K getKey() {
//            return key;
//        }
//
//        @Override
//        public V getValue() {
//            return value;
//        }
//
//        public String toString(){
//            return key + ":" + value;
//        }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o) {
//            if (o == this)
//                return true;
//            if (o instanceof Map.Entry) {
//                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//                if (Objects.equals(key, getKey()) && Objects.equals(value, getValue())) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }false
//
//    /**
//     * 未完待续
//     */
//
//
//
//
//
//
//
//}
