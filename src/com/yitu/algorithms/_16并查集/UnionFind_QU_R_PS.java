package com.yitu.algorithms._16并查集;

/**
 * Quick Union - 基于rank的优化 - 路径分裂(Path Spliting)
 * 使路径上的每个节点都指向其祖父节点（parent的parent）
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R {
    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            int p = parents[v];
            parents[v] = parents[parents[v]];
            v = p;
        }
        return v;
    }
}
