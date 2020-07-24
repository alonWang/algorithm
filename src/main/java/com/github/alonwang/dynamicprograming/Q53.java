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
        int state = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (state > 0) {
                state += nums[i];
            } else {
                state = nums[i];
            }
            max = Math.max(max, state);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return divide(nums, 0, nums.length - 1);
    }

    /**
     * 考虑将数组划分成两半,那么最大子序列只能出现在 左侧子数组[left,mid],右侧子数组[mid+1,right],和中间[x,y] (left<=x<y<=right)
     * 基于这个特性进行分治
     *
     * @param nums
     * @param left  include
     * @param right include
     * @return
     */
    private int divide(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        //左边的最大值
        int leftMax = divide(nums, left, mid);
        //右边的最大值
        int rightMax = divide(nums, mid + 1, right);
        //中间的最大值,需要从中间位置向左,向右辐射得出
        int sum = 0;
        int leftPartMax = Integer.MIN_VALUE, rightPartMax = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftPartMax = Math.max(leftPartMax, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightPartMax = Math.max(rightPartMax, sum);
        }
        int middleMax = leftPartMax + rightPartMax;
        return Math.max(Math.max(leftMax, rightMax), middleMax);
    }
}
