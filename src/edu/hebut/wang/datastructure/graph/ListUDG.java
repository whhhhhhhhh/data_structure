package edu.hebut.wang.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 无向图邻接表
 */
public class ListUDG {

    //邻接表中表对应的链表的顶点
    private class ENode {
        // 该边所指向的顶点的位置
        int ivex;
        // 指向下一条弧的指针
        ENode nextEdge;
    }
    //顶点节点
    private class VNode {
        // 顶点信息
        int data;
        // 指向第一条依附该顶点的弧
        ENode firstEdge;
    }

    private VNode[] mVexs;

    public ListUDG(int[] vexs, int[][] edges) {

        //初始化顶点节点
        mVexs = new VNode[vexs.length];
        for (int i = 0; i < vexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }

        //初始化边
        for (int i = 0; i < edges.length; i++) {
            ENode next = mVexs[edges[i][0]].firstEdge;
            ENode node = new ENode();
            node.ivex = edges[i][1];
            node.nextEdge = next;
            mVexs[edges[i][0]].firstEdge = node;
        }
    }

    public Iterable<Integer> adj(int vex) {
        Set<Integer> set = new HashSet<>();
        VNode node = mVexs[vex];
        ENode first = node.firstEdge.nextEdge;
        while (first != null) {
            set.add(first.ivex);
            first = first.nextEdge;
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
        for (int i : m.adj(2)) {
            System.out.println(i);
        }
    }
}
