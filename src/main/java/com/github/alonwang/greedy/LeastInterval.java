package com.github.alonwang.greedy;

import java.util.Arrays;

/**
 * @author alonwang
 * @date 2020/6/30 18:40
 * @detail 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *  
 * <p>
 * 提示：
 * <p>
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeastInterval {
    //朴素的方案。按照冷却间隔一遍一遍的跑
//    public int leastInterval(char[] tasks, int n) {
//        int[] counts = new int[26];
//        for (char task : tasks) {
//            counts[task - 'A']++;
//        }
//        int sortStartIndex = 0;
//        Arrays.sort(counts);
//        for (int i = 0; i < counts.length; i++) {
//            if (counts[i] != 0) {
//                sortStartIndex = i;
//                break;
//            }
//        }
//        int total = 0;
//        while (counts[25] > 0) {
//            int i = 0;
//            while (i <= n) {
//                //任务跑完了
//                if (counts[25] == 0) {
//                    break;
//                }
//                //每一轮从数量最多的任务开始跑
//                if (i < 26 && counts[25 - i] > 0) {
//                    counts[25 - i]--;
//                }
//                total++;
//                i++;
//            }
//            Arrays.sort(counts, sortStartIndex, counts.length);
//            for (int i1 = sortStartIndex; i1 < counts.length; i1++) {
//                if (counts[i1] != 0) {
//                    sortStartIndex = i1;
//                    break;
//                }
//            }
//        }
//        return total;
//    }
    //根据数量最多任务确定空闲时间，在空闲时间插入其他任务
    //最后一趟要特殊处理，不需要计入空闲时间
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
