package com.github.alonwang.greedy;

import java.util.ArrayList;
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
    List<Integer> ans;

    public List<Integer> splitIntoFibonacci(String S) {

        ans = new ArrayList<>();
        return dfs2(0, S, 0, 0, 0) ? ans : new ArrayList<>();
    }

    /**
     * @param i
     * @param s
     * @param i1    f1
     * @param i2    f2
     * @param count 现有的数量
     * @return
     */
    private boolean dfs2(int i, String s, int i1, int i2, int count) {
        //如果字符串用尽,并且构成了斐波那锲数列(长度>=3),说明满足
        if (i == s.length()) return count >= 3;
        //前两个数值之和超过了int范围不符合题目约束
        if ((((long) i1) + i2) > Integer.MAX_VALUE) return false;
        //基于加法原理 下一个元素的长度一定是 前两个元素位数长度的最大值 或  前两个元素位数长度的最大值+1
        int min = Math.max(digitsCount(i1), digitsCount(i2));
        // 并且这个长度不能超过int位数长度的范围
        int max = Math.min(INT_MAX_DIGIT, min + 1);
        //并且不能超过字符串长度
        max = Math.min(max, s.length() - i);
        for (int j = min; j <= max; j++) {
            //非0值不能以0开头
            if (s.charAt(i) == '0' && j > 1) {
                return false;
            }
            int i3 = Integer.parseInt(s.substring(i, i + j + 1));
            //满足斐波那锲条件/当前还未构成斐波那锲数列(长度>=3)
            if (i3 == (i1 + i2) || count < 3) {
                ans.add(i);

            }

        }
        return false;

    }

    private int digitsCount(int num) {
        int digit = 1;
        while ((num = num / 10) != 0) {
            digit++;
        }
        return digit;

    }

    /**
     * @p : 当前指针指向数组的索引
     * @s : 字符串
     * @pre1 : 前面隔一个的数
     * @pre2 : 前一个数
     * @deep : 当前是第几个数
     **/
    public boolean dfs(int p, String s, int pre1, int pre2, int deep) {
        int length = s.length();
        if (p == length) return deep >= 3;

        for (int i = 1; i <= 11; i++) {
            //超出长度或者以0开头直接break;
            if (p + i > length || (s.charAt(p) == '0' && i > 1)) break;
            //截取字符串
            String sub = s.substring(p, p + i);

            long numL = Long.parseLong(sub);
            //判断是否超出范围,或者deep不是0,1却大于他的前两个数之和
            if (numL > Integer.MAX_VALUE ||
                    (deep != 0 && deep != 1 && numL > (pre1 + pre2))) break;
            //转成int
            Integer num = (int) numL;
            //满足条件的数,递归加回溯
            if (deep == 0 || deep == 1 || num.equals(pre1 + pre2)) {
                ans.add(num);
                if (dfs(p + i, s, pre2, num, deep + 1)) return true;
                ans.remove(num);
            }
        }
        return false;
    }
}
