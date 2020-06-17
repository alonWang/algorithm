package com.github.alonwang.string;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q6 {
    /* 正序时人人有份,倒序时首尾没有*/
    public String convert(String s, int numRows) {
        if (numRows < 1)
            return "";

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++)
                sb[i].append(s.charAt(index++));
            for (int i = numRows - 2; i > 0 && index < s.length(); i--)
                sb[i].append(s.charAt(index++));


        }
        for (int i = 1; i < numRows; i++)
            sb[0].append(sb[i]);
        return sb[0].toString();
    }
}