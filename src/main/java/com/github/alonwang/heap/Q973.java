package com.github.alonwang.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * <p>
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * <p>
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * <p>
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/7/25 9:32 上午
 * @detail
 */
public class Q973 {
    public int[][] kClosest(int[][] points, int K) {
        //大顶堆
        Queue<int[]> quque = new PriorityQueue<>(K, (o1, o2) -> ojld(o2) - ojld(o1));
        for (int[] point : points) {
            if (quque.size() < K) {
                quque.add(point);
            } else if (ojld(quque.peek()) > ojld(point)) {
                quque.poll();
                quque.offer(point);
            }
        }
        int[][] result = new int[quque.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = quque.poll();
        }
        return result;
    }

    private int ojld(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    /**
     * 排序方式
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> ojld(o1) - ojld(o2));
        return Arrays.copyOfRange(points, 0, K);
    }
}
