package com.github.alonwang.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 去重的思路
 * 1. 重复元素必须在一起 ==> 排序
 * 2. 跳过重复元素
 */
class CombinationSum2 {
    private List<List<Integer>> res;
    private ArrayList<Integer> tempList;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        tempList = new ArrayList<>(candidates.length);
        Arrays.sort(candidates);
        combo(candidates, target, 0);
        return res;
    }

    private void combo(int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = index; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                combo(candidates, target - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
                //去重
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
            }
        }
    }
}