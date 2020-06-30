package com.github.alonwang.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author alonwang
 * @date 2020/6/30 17:47
 * @detail 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * <p>
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 * <p>
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoCitySchedCost {
    // A-B 从小到大排列
    static Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[0] - o1[1]) - (o2[0] - o2[1]);
        }
    };

    /**
     * 先假定安排所有人都去B城.然后中途将其中一半安排去A城.
     * 那么每改变一个人的行程,费用变化就是 A-B. 可正可负.  那么选出使用A-B最小的一半去A,另外一半去B.就是最佳选择
     * 不要被设定困住,转换思考.    ==> 我是没想到
     *
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, comparator);
        int n = costs.length / 2;
        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < n) {
                total += costs[i][0];
            } else {
                total += costs[i][1];
            }
        }
        return total;
    }
}
