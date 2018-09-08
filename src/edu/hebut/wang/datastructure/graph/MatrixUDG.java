package edu.hebut.wang.datastructure.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 无向图的邻接矩阵
 */
public class MatrixUDG {

    private int[] mVexs;
    private int[][] mMatrix;

    public MatrixUDG(int[] vexs, int[][] edges) {
        this.mVexs = vexs;
        int vexNum = vexs.length;
        int edgeNum = edges.length;

        mMatrix = new int[vexNum][vexNum];
        for (int i = 0; i < edgeNum; i ++) {
            mMatrix[edges[i][0]][edges[i][1]] = 1;
            mMatrix[edges[i][1]][edges[i][0]] = 1;
        }
    }

    public int[] getmVexs() {
        return mVexs;
    }

    public Iterable<Integer> adj(int vex) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < mVexs.length; i ++) {
            if (mMatrix[i][vex] == 1) {
                set.add(i);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0,3},
                {1,0},
                {1,2},
                {2,0},
                {2,1},
        };
        int[] vexs = {0,1,2,3};
        MatrixUDG m = new MatrixUDG(vexs,edges);
        for (int i : m.adj(0)) {
            System.out.println(i);
        }
    }
}
