package com.github.alonwang.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubSets {
    List<List<Integer>> result;
    LinkedList<Integer> tracing;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        tracing = new LinkedList<>();
        result.add(new ArrayList<>());
        if (nums.length <= 0) {
            return result;
        }
        Arrays.sort(nums);
        backtracing(nums, 0);
        return result;
    }

    private void backtracing(int[] nums, int i) {
        if (i >= nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            tracing.addLast(nums[j]);
            result.add((List<Integer>) tracing.clone());
            backtracing(nums, j + 1);
            //恢复
            tracing.removeLast();
        }

    }
}
