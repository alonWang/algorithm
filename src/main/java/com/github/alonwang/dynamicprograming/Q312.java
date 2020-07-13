package com.github.alonwang.dynamicprograming;

import java.util.LinkedList;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * <p>
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * <p>
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/7/13 11:22
 * @detail
 */
public class Q312 {
    LinkedList<Integer> list;

    //TODO 逆向思维， 从列表中慢慢删除  ==》 向列表中慢慢添加  尚未搞懂
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            balloons[i + 1] = nums[i];
        }
        int len = balloons.length;
        balloons[0] = balloons[len - 1] = 1;
        int[][] state = new int[len][len];


        for (int left = len - 2; left > -1; left--)
            for (int right = left + 2; right < len; right++) {
                for (int i = left + 1; i < right; ++i)
                    // same formula to get the best score from (left, right) as before
                    state[left][right] = Math.max(state[left][right],
                            balloons[left] * balloons[i] * balloons[right] + state[left][i] + state[i][right]);
            }

        return state[0][len - 1];


    }
}
