package com.github.alonwang.dynamicprograming;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/7/18 2:39 下午
 * @detail f(i)表示以下标为i的数结尾的最大和
 * f(i)=max(f(i-1)+nums[i],nums[i])
 * 时间复杂度 O(n)，空间复杂度O(n)
 */
public class Q53 {
    public int maxSubArray(int[] nums) {
        int[] state = new int[nums.length];
        state[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (state[i - 1] > 0) {
                state[i] = state[i - 1] + nums[i];
            } else {
                state[i] = nums[i];
            }
            max = Math.max(max, state[i]);
        }
        return max;
    }
}
