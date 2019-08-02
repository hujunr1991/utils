package com.example.springboorutil.DataStructures.UnionFind;

public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
