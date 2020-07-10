package com.github.alonwang.dynamicprograming;

import java.util.Arrays;

/**
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * <p>
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * <p>
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 示例 2：
 * <p>
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [0,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 * <p>
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * 示例 4：
 * <p>
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= clips.length <= 100
 * 0 <= clips[i][0] <= clips[i][1] <= 100
 * 0 <= T <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/video-stitching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1024 {
    public int videoStitching(int[][] clips, int T) {
        if (T == 0) {
            return -1;
        }
        //先按开始位置顺序排，相同的按结尾倒序排，目的是从前向后以范围优先去处理
        Arrays.sort(clips, (o1, o2) -> {
            int cmp = Integer.compare(o1[0], o2[0]);
            if (cmp != 0) {
                return cmp;
            } else {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        int firstBegin = clips[0][0];
        int firstEnd = clips[0][1];
        //排序后的第一个起始如果不是0,【0~x]这块肯定就没了，缺帧，不可能涵盖整场比赛
        if (firstBegin != 0) {
            return -1;
        }
        //一个片段就包含了T
        if (firstEnd >= T) {
            return 1;
        }
        //state[i] 表示长度i所需片段的最少数量 下标0无意义
        int[] state = new int[T + 1];
        //记录目前到达的最大位置
        int maxPos = firstEnd;
        //对[firstBegin,firstEnd]这一块，T只需要一个片段
        Arrays.fill(state, firstBegin, firstEnd + 1, 1);

        for (int i = 1; i < clips.length; i++) {
            int begin = clips[i][0];
            int end = clips[i][1];//include
            //有空缺，无法完成
            if (begin > maxPos) {
                return -1;
            }
            //begin<=maxPos<end => 能接上之前的，且能往右再走新增一点，
            if (end > maxPos) {
                //能够满足T了，
                if (end >= T) {
                    //在前一个片段上再接上一个正好满足
                    return state[begin] + 1;
                } else {
                    //对于[begin,maxPos]这一块，之前的就是最小片段数，无需处理，对 [maxPos+1,end]这块，等于比state[begin]多接一个
                    Arrays.fill(state, maxPos + 1, end + 1, state[begin] + 1);
                }
                maxPos = end;
            }

        }
        return -1;
    }
}
