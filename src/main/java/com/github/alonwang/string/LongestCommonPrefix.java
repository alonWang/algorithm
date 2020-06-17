package com.github.alonwang.string;

/**
 * 以最短的字符串为前缀,不断缩短长度,与剩余字符串比较.
 */
class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1)
            return "";
        int shortestIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < strs[shortestIndex].length()) {
                shortestIndex = i;
            }
        }
        String prefix = strs[shortestIndex];

        while (prefix.length() > 0) {
            boolean flag = true;
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return prefix;
            prefix = prefix.substring(0, prefix.length() - 1);

        }
        return "";
    }

}