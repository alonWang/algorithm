package com.github.alonwang.depthfirst;

/**
 * @author alonwang
 * @date 2020/6/15 20:23
 * @detail 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q130 {

    public static final char O_CHAR = 'O';
    public static final char X_CHAR = 'X';
    public static final char SHARP_CHAR = '#';
    private int height;
    private int width;

    /**
     * 边界上的o都是不可能转换的,与边界上o相连的也都是不能转换的.剩余的o就是可转换的
     *
     * @param board
     */
    public void solve(char[][] board) {
        /**
         * 行和列只要有三个才有意义
         */
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }
        height = board.length;
        width = board[0].length;
        for (int i = 0; i < width; i++) {
            dfs(board, 0, i);
            dfs(board, height - 1, i);

        }
        for (int j = 0; j < height; j++) {
            dfs(board, j, 0);
            dfs(board, j, width - 1);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == O_CHAR) {
                    board[i][j] = X_CHAR;
                } else if (board[i][j] == SHARP_CHAR) {
                    board[i][j] = O_CHAR;
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= height || j >= width || board[i][j] == X_CHAR || board[i][j] == SHARP_CHAR) {
            return;
        }
        board[i][j] = SHARP_CHAR;
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
}
