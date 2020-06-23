package com.github.alonwang.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q39 {
    //单个排列
    int[] path = new int[100];
    //path的有效长度
    int len;
    //结果
    List<List<Integer>> ans;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        len = 0;
        ans = new ArrayList<>();
        deepSearch(0, candidates, target);
        return ans;
    }

    public void deepSearch(int idx, int[] c, int t) {
        //终止条件
        if (t < 0) {
            return;
        }
        if (t == 0) {
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                ls.add(path[i]);
            }
            ans.add(ls);
            return;
        }

        //回溯主体
        if (idx < c.length) {
            //不使用candidates[idx]
            deepSearch(idx + 1, c, t);

            //使用,这意味着可以重复使用同一个数字
            path[len] = c[idx];
            len++;
            deepSearch(idx, c, t - c[idx]);
            len--;
        }
    }


}
