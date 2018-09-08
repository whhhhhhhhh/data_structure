package edu.hebut.wang.datastructure.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 有向图的邻接表
 */
public class AdjListDigraph {

    private class EdgeNode {

        int index;
        EdgeNode next;

        public EdgeNode(int index, EdgeNode next) {
            this.index = index;
            this.next = next;
        }
    }

    private class VertexNode {
        int id;
        EdgeNode headNode;
    }

    private VertexNode[] vertexs;
    private int vertexsNum;
    private int edgesNum;

    public AdjListDigraph(int[][] data, int vertexsNum) {
        this.vertexsNum = vertexsNum;
        this.edgesNum = data.length;
        this.vertexs = new VertexNode[vertexsNum];

        for (int i = 0; i < vertexs.length; i++) {
            vertexs[i] = new VertexNode();
            vertexs[i].id = i;
        }

        for (int i = 0; i < data.length; i++) {
            int index = data[i][1];
            //头插法，先取出当前头
            EdgeNode next = vertexs[data[i][0]].headNode;
            EdgeNode eNode = new EdgeNode(index,next);
            vertexs[data[i][0]].headNode = eNode;
        }
    }

    //用于测试，返回一个顶点的邻接点
    public Iterable<Integer> adj(int index) {
        Set<Integer> set = new HashSet<>();
        EdgeNode current = vertexs[index].headNode;
        while(current != null) {
            VertexNode node = vertexs[current.index];
            set.add(node.id);
            current = current.next;
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
        AdjListDigraph ald = new AdjListDigraph(data,4);
        for(int i :ald.adj(0)) {
            System.out.println(i);
        }
    }

}
