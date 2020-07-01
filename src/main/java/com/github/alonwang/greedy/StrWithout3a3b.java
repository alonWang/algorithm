package com.github.alonwang.greedy;

/**
 * @author alonwang
 * @date 2020/7/1 12:50
 * @detail 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 * <p>
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = 1, B = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 * 示例 2：
 * <p>
 * 输入：A = 4, B = 1
 * 输出："aabaa"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-without-aaa-or-bbb
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrWithout3a3b {
    //思路   先假设多数方放在一起, 然后将少数方插入多数方. 在前方尽可能多的插入少数方,只要确保这次插入后后面能够满足就行.
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder(A + B);
        char majority, minority;
        int remainMajority;
        int remainMinority;
        if (A >= B) {
            majority = 'a';
            minority = 'b';
            remainMajority = A;
            remainMinority = B;
        } else {
            majority = 'b';
            minority = 'a';
            remainMajority = B;
            remainMinority = A;
        }
        if (remainMajority <= 2) {
            append(sb, majority, remainMajority);
            append(sb, minority, remainMinority);
            return sb.toString();
        }

        while (remainMajority > 0 && remainMinority > 0) {
            int consumeMajority = Math.min(remainMajority, 2);
            int reserveMinority = reserveMinority(remainMajority - consumeMajority);
            //这次能够插入的数量
            int consumeMinority = Math.min(2, remainMinority - reserveMinority);
            append(sb, majority, consumeMajority);
            append(sb, minority, consumeMinority);
            remainMajority -= consumeMajority;
            remainMinority -= consumeMinority;
        }

        if (remainMajority > 0) {
            append(sb, majority, remainMajority);
        }
        return sb.toString();

    }

    private int reserveMinority(int count) {
        return (count - 1) / 2;
    }

    private void append(StringBuilder sb, char c, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
    }
}
