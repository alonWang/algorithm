package com.github.alonwang.backtracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutation {
    private List<String> result;
    private char[] chars;

    /**
     * 从前到后依次固定字符，到某一位时，如果某个字符在本次已经出现过，那么他肯定是重复的，不用再处理
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        result = new ArrayList<>();
        chars = s.toCharArray();


        dfs(0);
        return result.toArray(new String[chars.length]);
    }

    private void dfs(int i) {
        //前面已经是无重复了，走到最后一个字符就是满足要求的
        if (i == chars.length - 1) {
            result.add(String.valueOf(chars));
            return;
        }

        Set<Character> appears = new HashSet<>();
        for (int j = i; j < chars.length; j++) {
            if (appears.contains(chars[j])) continue;
            appears.add(chars[j]);
            swap(i, j);
            dfs(i + 1);
            swap(i, j);
        }

    }

    private void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
