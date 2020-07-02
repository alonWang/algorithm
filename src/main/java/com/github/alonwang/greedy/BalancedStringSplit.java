package com.github.alonwang.greedy;

/**
 * @author alonwang
 * @date 2020/7/2 16:37
 * @detail 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的最大数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 * <p>
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 * <p>
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * 分割得到的每个字符串都必须是平衡字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int total = 0;
        // 'L','R'都是英文字母,只占一个字节.直接操纵字节数组
        byte[] chars = s.getBytes();
        int len = chars.length;
        int balance = 0;
        for (int j = 0; j < len; j++) {
            if (chars[j] == (byte) 'L') {
                balance++;
            } else {
                balance--;
            }
            //其实还可以判断下是否计算了双数个,如果计算了双数个再判断是否为0.但是这样反而运算更多,干脆每次都去判断是否平衡好了
            if (balance == 0) {
                total++;
            }
        }

        return total;
    }
}
