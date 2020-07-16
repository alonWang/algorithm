package com.github.alonwang.divideandconquer;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 * <p>
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 * <p>
 * 那么数组 A 是漂亮数组。
 * <p>
 *  
 * <p>
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：4
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：5
 * 输出：[3,1,2,5,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/beautiful-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/7/16 8:05 上午
 * @detail
 */
public class Q932 {
    Map<Integer, int[]> memo;

    /**
     * 2*a[k]必然是偶数,那么只要保证 a[i],a[j]是一奇一偶就可以了,那么递归定义左边都放奇数,右边都放偶数
     * TODO 未完全理解
     *
     * @param N
     * @return
     */
    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x : f((N + 1) / 2))  // odds
                ans[t++] = 2 * x - 1;
            for (int x : f(N / 2))  // evens
                ans[t++] = 2 * x;
        }
        memo.put(N, ans);
        return ans;
    }

}
