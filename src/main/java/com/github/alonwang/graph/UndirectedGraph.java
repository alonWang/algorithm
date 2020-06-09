package com.github.alonwang.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 无向图,节点数量不可变
 *
 * @author alonwang
 * @date 2020/6/9 11:28 下午
 * @detail
 */
public class UndirectedGraph {
    /**
     * 节点数量
     */
    private final int nodeCount;
    private final LinkedList<Integer>[] adjTable;

    public UndirectedGraph(int nodeCount) {
        this.nodeCount = nodeCount;
        this.adjTable = new LinkedList[nodeCount];
        for (int i = 0; i < adjTable.length; i++) {
            this.adjTable[i] = new LinkedList<>();
        }
    }

    public int size() {
        return nodeCount;
    }

    /**
     * 添加边
     *
     * @param i 节点
     * @param j 另一个节点
     */
    public void addEdge(int i, int j) {
        adjTable[i].add(j);
        adjTable[j].add(i);
    }

    public List<Integer> bfs(int start, int target) {
        //TODO
        return null;
    }

    public List<Integer> dfs(UndirectedGraph graph, int start, int target) {
        //TODO
        return null;
    }
}
