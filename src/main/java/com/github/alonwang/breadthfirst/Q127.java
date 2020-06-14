package com.github.alonwang.breadthfirst;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author alonwang
 * @date 2020/6/12 18:04
 * @detail
 */
public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>(wordList.size());
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.add(beginWord);
        visited.add(beginWord);
        count++;
        while (queue.size() > 0) {
            count++;
            int loopCount = queue.size();
            for (int i = 0; i < loopCount; i++) {
                String key = queue.poll();
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (!canConvert(key, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count;
                    }
                    queue.add(s);
                    visited.add(s);
                }
            }

        }
        return 0;
    }

    private boolean canConvert(String key, String source) {
        int diffCount = 0;
        for (int i = 0; i < source.length(); i++) {
            if (key.charAt(i) != source.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }

        }
        return diffCount == 1;
    }
}
