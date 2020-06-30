package com.github.alonwang.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author alonwang
 * @date 2020/6/30 18:40
 * @detail
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int count : counts) {
            list.add(count);
        }
        list.sort(Comparator.naturalOrder());
        int total = 0;
        while (!list.isEmpty()) {
            int appearCount = list.get(0);
            //空闲不能小于0
            int spareCount = Math.max(0, n + 1 - list.size());
            int curCount = appearCount * (list.size() + spareCount);

            list.replaceAll((v) -> v - appearCount);
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == 0) {
                    it.remove();
                } else {
                    break;
                }
            }
            //如果本次就清空任务了,那么有一些时间是不需要计算在内的
            if (list.isEmpty()) {
                curCount -= spareCount;
            }
            total += curCount;
        }
        return total;

    }
}
