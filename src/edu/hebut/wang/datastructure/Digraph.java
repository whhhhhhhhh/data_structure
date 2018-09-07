package edu.hebut.wang.datastructure;

import java.util.HashSet;
import java.util.Set;

/**
 * 有向图的邻接矩阵
 */
public class Digraph {

    //顶点数量
    private int vertexsNum;
    //边数量
    private int edgesNum;
    //邻接矩阵
    private int[][] arc;

    public Digraph(int[][] data, int vertexsNum) {
        this.vertexsNum = vertexsNum;
        this.edgesNum = data.length;
        arc = new int[vertexsNum][vertexsNum];
        //初始化二维数组为无限大
        for (int i = 0; i < vertexsNum; i++) {
            for (int j = 0; j < vertexsNum; j++) {
                arc[i][j] = Integer.MAX_VALUE;
            }
        }
        //有向边赋值为1
        for (int i = 0; i < data.length; i++) {
            int tail = data[i][0];
            int head = data[i][1];
            arc[tail][head] = 1;
        }
    }

    //用于测试，返回一个顶点的邻接点
    public Iterable<Integer> adj(int vertex) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < vertexsNum; i++) {
            if (arc[vertex][i] != Integer.MAX_VALUE) {
                set.add(i);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int[][] data = {
                {0,3},
                {1,0},
                {1,2},
                {2,0},
                {2,1},
        };
        Digraph wd = new Digraph(data,4);
        for(int i :wd.adj(1)) {
            System.out.println(i);
        }
    }
}
