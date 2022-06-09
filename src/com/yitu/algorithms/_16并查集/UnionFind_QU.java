package com.yitu.algorithms._16并查集;

/**
 * Quick Union
 */
public class UnionFind_QU extends UnionFind {

    public UnionFind_QU(int capacity) {
        super(capacity);
    }

    /**
     * 通过parent链条不断地向上找，直到找到根节点
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        // 根节点必定指向自己，所以自己指向自己必定是根节点
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    /**
     * 将v1的根节点嫁接到v2的根节点上
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        parents[p1] = p2;
    }
}
