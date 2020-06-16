package com.github.alonwang.breadthfirst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * <p>
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * <p>
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/6/16 18:28
 * @detail
 */
public class ShortestPathBinaryMatrix {
    int N;

    class Pos {
        int x;
        int y;

        Pos up() {
            if (y - 1 < 0) {
                return null;
            }
            return new Pos(x, y - 1);
        }

        Pos down() {
            if (y + 1 >= N) {
                return null;
            }
            return new Pos(x, y + 1);
        }

        Pos left() {
            if (x - 1 < 0) {
                return null;
            }
            return new Pos(x - 1, y);
        }

        Pos right() {
            if (x + 1 >= N) {
                return null;
            }
            return new Pos(x + 1, y);
        }

        Pos leftup() {
            if (x - 1 < 0 || y - 1 < 0) {
                return null;
            }
            return new Pos(x - 1, y - 1);
        }

        Pos leftdown() {
            if (x - 1 < 0 || y + 1 >= N) {
                return null;
            }
            return new Pos(x - 1, y + 1);
        }

        Pos rightup() {
            if (x + 1 >= N || y - 1 < 0) {
                return null;
            }
            return new Pos(x + 1, y - 1);
        }

        Pos rightdown() {
            if (x + 1 >= N || y + 1 >= N) {
                return null;
            }
            return new Pos(x + 1, y + 1);
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        N = grid.length;
        boolean[][] visited = new boolean[N][N];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos index = queue.poll();
                if (index == null) {
                    continue;
                }
                if (visited[index.x][index.y]) {
                    continue;
                }
                visited[index.x][index.y] = true;
                if (grid[index.x][index.y] == 1) {
                    continue;
                }
                if (index.x == N - 1 && index.y == N - 1) {
                    return count;
                }
                queue.add(index.left());
                queue.add(index.right());
                queue.add(index.up());
                queue.add(index.down());
                queue.add(index.leftup());
                queue.add(index.leftdown());
                queue.add(index.rightup());
                queue.add(index.rightdown());


            }
        }
        return -1;
    }
}
