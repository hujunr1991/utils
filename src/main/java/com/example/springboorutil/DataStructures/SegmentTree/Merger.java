package com.example.springboorutil.DataStructures.SegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
