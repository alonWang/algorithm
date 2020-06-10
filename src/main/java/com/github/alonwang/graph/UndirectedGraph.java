package com.github.alonwang.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        int[] prevTable = new int[nodeCount];
        Arrays.fill(prevTable, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[nodeCount];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int prevNode = queue.poll();
            if (adjTable[prevNode].isEmpty()) {
                continue;
            }
            for (Integer node : adjTable[prevNode]) {
                if (visited[node]) {
                    continue;
                }
                prevTable[node] = prevNode;
                if (node == target) {
                    return resolvePath(prevTable, start, target);
                }
                visited[node] = true;
                queue.add(node);
            }

        }
        return null;
    }

    private List<Integer> resolvePath(int[] prevTable, int start, int target) {
        List<Integer> path = new ArrayList<>();
        recursiveResolve(prevTable, start, target, path);
        return path;
    }

    private void recursiveResolve(int[] prevTable, int start, int node, List<Integer> path) {
        if (prevTable[node] >= 0 && node != start) {
            recursiveResolve(prevTable, start, prevTable[node], path);
        }
        path.add(node);
    }

    public List<Integer> dfs(UndirectedGraph graph, int start, int target) {
        //TODO
        return null;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        List<Integer> result = graph.bfs(0, 6);
        System.out.println(result);
    }
}
