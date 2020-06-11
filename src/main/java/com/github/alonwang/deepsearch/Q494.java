package com.github.alonwang.deepsearch;

/**
 * @author alonwang
 * @date 2020/6/11 20:44
 * @detail
 */
public class Q494 {
    private int count;

    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        dp(0, nums, 0, S);
        return count;
    }

    private void dp(int i, int[] nums, int sum, int s) {
        if (i == nums.length) {
            if (sum == s) {
                count++;
            }
        } else {
            dp(i + 1, nums, sum + nums[i], s);
            dp(i + 1, nums, sum - nums[i], s);
        }

    }
}
