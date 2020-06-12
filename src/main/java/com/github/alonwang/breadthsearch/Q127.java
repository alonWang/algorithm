package com.github.alonwang.breadthsearch;

import java.util.*;

/**
 * @author alonwang
 * @date 2020/6/12 18:04
 * @detail
 */
public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>(wordList.size());
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            count++;
            for (String s : wordList) {

            }
        }
        return 0;
    }
}
