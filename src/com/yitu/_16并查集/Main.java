package com.yitu._16并查集;

import com.yitu.tools.Asserts;
import com.yitu.tools.Times;

public class Main {
    static final int count = 1000000;
    public static void main(String[] args) {
        testTime(new UnionFind_QU_R_PC(count));
        testTime(new UnionFind_QU_R_PS(count));
        testTime(new UnionFind_QU_R_PH(count));
    }
    static void testTime(UnionFind uf) {
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

        Asserts.test(!uf.isSame(2, 7));

        uf.union(4, 6);

        Asserts.test(uf.isSame(2, 7));

        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < count; i++) {
                uf.union((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }

            for (int i = 0; i < count; i++) {
                uf.isSame((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }
        });
    }
}
