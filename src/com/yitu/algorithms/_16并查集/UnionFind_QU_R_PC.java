package com.yitu.algorithms._16并查集;

/**
 * Quick Union - 基于rank的优化 - 路径压缩（Path Compression）
 * <p>
 * 什么是路径压缩？
 * 在find时使路径上的所有节点都指向根节点，从而降低树的高度
 */
public class UnionFind_QU_R_PC extends UnionFind_QU_R {
    public UnionFind_QU_R_PC(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        if (parents[v] != v) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
