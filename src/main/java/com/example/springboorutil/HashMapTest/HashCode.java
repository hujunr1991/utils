package com.example.springboorutil.HashMapTest;

public class HashCode<K, V> {

//    public V put(K key, V value) {
//        //算hash值
//        int hash = hash(key.hashCode());
//        int i = indexFor(hash, table.length);
//        //如果该key已被插入，则替换掉旧的value （链接操作）
//        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
//            Object k;
//            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
//                V oldValue = e.value;
//                e.value = value;
//                e.recordAccess(this);
//                return oldValue;
//            }
//        }
//        modCount++;
//        //该key不存在，需要增加一个结点
//        addEntry(hash, key, value, i);
//        return null;
//    }
//
//    void addEntry(int hash, K key, V value, int bucketIndex)
//    {
//        Entry<K,V> e = table[bucketIndex];
//        table[bucketIndex] = new Entry<K,V>(hash, key, value, e);
//        //查看当前的size是否超过了我们设定的阈值threshold，如果超过，需要resize
//        if (size++ >= threshold)
//            resize(2 * table.length);
//    }


}
