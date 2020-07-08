package com.github.alonwang.greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alonwang
 * @date 2020/7/3 8:15 上午
 * @detail 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * <p>
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * <p>
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * <p>
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："123456579"
 * 输出：[123,456,579]
 * 示例 2：
 * <p>
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * 示例 3：
 * <p>
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * 示例 4：
 * <p>
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * 示例 5：
 * <p>
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SplitIntoFibonacci {
    private static final int INT_MAX_DIGIT = 10;
    LinkedList<Integer> ans;

    /**
     * 斐波那锲数列的就是只需要关注最近的三个数字.利用这个特点做回溯
     * 修改自 https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/java-dfs-jia-jian-zhi-ji-bai-liao-9306-by-capta1n/
     * 相比而言 增加了一些剪枝
     *
     * @param S
     * @return
     */
    public List<Integer> splitIntoFibonacci(String S) {

        ans = new LinkedList<>();
        return dfs2(0, S, 0, 0, 0) ? ans : new ArrayList<>();
    }

    /**
     * @param i
     * @param s
     * @param i1        f1
     * @param i2        f2
     * @param seekIndex 要搜寻斐波那锲元素的下标
     * @return
     */
    private boolean dfs2(int i, String s, int i1, int i2, int seekIndex) {

        //如果字符串用尽,并且之前已经构成了斐波那锲数列(长度>=3),说明满足
        if (i == s.length()) return seekIndex >= 3;
        //本次还未构成斐波那锲数列
        boolean init = seekIndex < 2;
        //前两个数值之和超过了int范围不符合题目约束
        if (!init && (((long) i1) + i2) > Integer.MAX_VALUE) return false;
        //基于加法原理 下一个元素的长度一定是 前两个元素位数长度的最大值 或  前两个元素位数长度的最大值+1
        int min = init ? 1 : Math.max(digitsCount(i1), digitsCount(i2));
        // 并且这个长度不能超过int位数长度的范围
        int max = init ? INT_MAX_DIGIT : Math.min(INT_MAX_DIGIT, min + 1);
        //并且不能超过字符串长度
        max = Math.min(max, s.length() - i);
        for (int j = min; j <= max; j++) {
            //非0值不能以0开头
            if (s.charAt(i) == '0' && j != 1) {
                return false;
            }
            long temp = Long.parseLong(s.substring(i, i + j));
            if (temp > Integer.MAX_VALUE) {
                return false;
            }

            int i3 = (int) temp;
            //满足斐波那锲条件/当前还未构成斐波那锲数列(长度>=3)
            if (i3 == (i1 + i2) || init) {
                ans.addLast(i3);
                if (dfs2(i + j, s, i2, i3, seekIndex + 1)) {
                    return true;
                }
                ans.removeLast();
            }

        }
        return false;

    }
    private int digitsCount(int num) {
        if (num == 0) return 1;
        return ((int) Math.log10(num)) + 1;
    }
}
