package edu.hebut.wang.datastructure.graph;

/**
 * 深度优先遍历
 */
public class DFSTraverse {

    private boolean[] visited;

    public DFSTraverse(Digraph graph, int index) {
        visited = new boolean[graph.getVertexsNum()];
        dfs(graph,index);
    }

    private void dfs(Digraph graph, int index) {
        visited[index] = true;
        System.out.println(index);
        //找出当前顶点的邻接点
        for (int i : graph.adj(index)) {
            if (!visited[i]) {
                dfs(graph,i);
            }
        }
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
        DFSTraverse dfs = new DFSTraverse(wd,3);
    }
}
