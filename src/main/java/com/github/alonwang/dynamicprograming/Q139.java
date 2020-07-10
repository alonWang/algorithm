package com.github.alonwang.dynamicprograming;

import java.util.*;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        Queue<Integer> queue = new LinkedList<>();
        //记录哪些坐标已经处理过了
        Set<Integer> visited = new HashSet<>();
        //初始化
        queue.add(0);
        while (true) {
            int size = queue.size();
            if (size == 0) {
                break;
            }
            for (int k = 0; k < size; k++) {
                int i = queue.poll();
                if (!visited.add(i)) {
                    continue;
                }
                for (String word : wordDict) {
                    int nextPos = i + word.length();
                    if (equalsFrom(chars, word, i)) {
                        if (nextPos == chars.length) {
                            return true;
                        }

                        queue.add(nextPos);

                    }
                }
            }
        }
        return false;

    }

    /**
     * 模式串与源串是否在i位置开始匹配
     *
     * @param chars 源串
     * @param word  模式串
     * @param i     开始匹配位置
     * @return 是否匹配
     */
    private boolean equalsFrom(char[] chars, String word, int i) {
        if (i + word.length() > chars.length) {
            return false;
        }
        for (int j = 0; j < word.length(); j++) {
            if (chars[j + i] != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}
