package com.github.alonwang.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author alonwang
 * @date 2020/6/29 15:37
 * @detail 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 * <p>
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RobotSim {
    /**
     * 重点 方向转换的处理,阻碍点的转换
     * |
     * |
     * | _ _ _
     * 上右下左分别对应 0,1,2,3
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        //对应方向上移动一个单位  x,y的变化值
        int[] moveX = new int[]{0, 1, 0, -1};
        int[] moveY = new int[]{1, 0, -1, 0};
        //初始在(0,0),方向向上
        int x = 0, y = 0, direction = 0;
        Set<Integer> obstaclesSet = new HashSet<>(obstacles.length);
        for (int[] obstacle : obstacles) {
            //确保x,y各占16位 保证可以通过移位在int范围存储两个值
            obstaclesSet.add(transform(obstacle[0], obstacle[1]));
        }
        int ans = 0;
        for (int command : commands) {
            //左转
            if (command == -2) {
                direction = (direction + 3) % 4;
                //右转
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                //移动
                for (int i = 0; i < command; i++) {
                    int newX = x + moveX[direction];
                    int newY = y + moveY[direction];
                    if (obstaclesSet.contains(transform(newX, newY))) {
                        break;
                    }
                    x = newX;
                    y = newY;
                    //记录最大欧式距离
                    ans = Math.max(x * x + y * y, ans);
                }
            }
        }
        return ans;
    }

    private int transform(int x, int y) {
        //记得加括号,加减法优先级高于位运算符
        int result = ((x + 30000) << 16) + (y + 30000);
        System.out.println(result);
        return result;
    }
}
