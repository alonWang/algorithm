package com.github.alonwang.breadthfirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author alonwang
 * @date 2020/6/12 18:04
 * @detail
 */
public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final int L = beginWord.length();
        wordList.add(beginWord);
        //构建映射 O(n*L)
        Map<String, List<String>> transformers = new HashMap<>(L * wordList.size());
        for (String s : wordList) {
            for (int i = 0; i < L; i++) {
                String transformer = s.substring(0, i) + "*" + s.substring(i + 1, L);
                transformers.compute(transformer, (key, val) -> {
                    if (val == null) {
                        val = new ArrayList<>(4);
                    }
                    val.add(s);
                    return val;
                });
            }
        }
        Set<String> visited = new HashSet<>(wordList.size());
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.add(beginWord);
        visited.add(beginWord);
        count++;
        //O(n*L*L)
        while (queue.size() > 0) {
            count++;
            int loopCount = queue.size();
            for (int i = 0; i < loopCount; i++) {
                String key = queue.poll();
                for (int j = 0; j < L; j++) {
                    String transformer = key.substring(0, j) + "*" + key.substring(j + 1, L);
                    for (String s : transformers.get(transformer)) {
                        if (visited.contains(s)) {
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

        }
        return 0;
    }

}
