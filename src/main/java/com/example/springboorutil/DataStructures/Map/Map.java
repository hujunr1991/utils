package com.example.springboorutil.DataStructures.Map;

public interface Map<K, V> {
    void add(K key, V value);

    void set(K key, V newValue);

    boolean isEmpty();

    boolean contains(K key);

    V get(K key);

    int getSize();

    V remove(K key);
}
