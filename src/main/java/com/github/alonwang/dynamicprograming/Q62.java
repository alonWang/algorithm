package com.github.alonwang.dynamicprograming;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/7/15 7:59 上午
 * @detail
 */
public class Q62 {
    //记录所有
    private static final Map<Integer, Integer> paths = new ConcurrentHashMap<>();

    static {
        //从(0,0)到(0，0)路径数为0
        paths.put(encode(0, 0), 0);
    }

    private static int encode(int l1, int l2) {
        return (l1 << 16) + l2;
    }

    /**
     * 1. 找逻辑
     * 只能向下或向右
     * 开始固定为左上角，结束固定为右下角
     * 由此某一个状态来自它的上方和左方之和
     * 2. 找状态变化方程
     * state[i][j]=state[i-1][j]+state[i][j-1]
     * 3. 确定初始状态，结束条件
     * 初始 state[0][0]=1
     * 结束 state[n-1][m-1]
     * 到这里可以转换为数学题了
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

    }
}
