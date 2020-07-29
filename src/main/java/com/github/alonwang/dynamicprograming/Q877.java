package com.github.alonwang.dynamicprograming;

/**
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * <p>
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * <p>
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * <p>
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[5,3,4,5]
 * 输出：true
 * 解释：
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= piles.length <= 500
 * piles.length 是偶数。
 * 1 <= piles[i] <= 500
 * sum(piles) 是奇数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stone-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/7/29 9:09
 * @detail 非贪心
 * 现在，我们已知的是dp[i][i]，假设我们现在有两堆石头，那么我们已知piles[0]、piles[1]、dp[0][0]、dp[1][1]，如何得到dp[0][1]？我们现在可以知道，dp[0][0]是Alex在单一石头堆情况下选取的最优策略，那么在两个石头堆的情况下，Alex的最优选取策略就变成了Lee的最优选取策略！因为在题目的描述中他们都是聪明的人并且会选择最优策略！也因此我们可以通过piles[0]-dp[1][1]表示Alex先手取走第一堆石头，而Lee后手选取第二堆石头，piles[1]-dp[0][0]亦是同理。通过比较piles[1]-dp[0][0]和piles[0]-dp[1][1]，我们就能够得到在2个相邻石头堆的胜负情况。
 * <p>
 * 在3个相邻石头堆的情况下亦是如此。假设石头堆为{3,4,5}，在2个相邻石头堆的情况下，即{3,4}和{4,5}这两种情况，Alex在{3,4}中必然会选择4，在{4,5}中必然会选择5。那么在完整的3个相邻石头堆的情况下，Alex在2个相邻石头堆情况下的选择，就变成了Lee的选择。因此，dp[0][3] = max{pile[0] - dp[1][2] , pile[2] - dp[0][1] }，pile[0]-dp[1][2]代表着，Alex拿取了[0]个石头堆后，减去Lee在[1]~[2]相邻石头堆情况下赢得的分数，即Alex在[0]-[2]情况下拿取[0](左侧)所能够赢取的分数；同理，pile[2] - dp[0][1] 表示Alex在[0]-[2]情况下拿取[2](右侧)所能够赢取的分数
 * <p>
 * 作者：leant
 * 链接：https://leetcode-cn.com/problems/stone-game/solution/dong-tai-gui-hua-fang-shi-xiang-jie-java-by-yan-ta/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Q877 {
    int state[];

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        //初始化dp[i][i]
        for (int i = 0; i < n; i++)
            dp[i][i] = piles[i];
        //copy https://leetcode-cn.com/problems/stone-game/solution/dong-tai-gui-hua-fang-shi-xiang-jie-java-by-yan-ta/
        //注意这里的两个循环
        //第一个循环dis代表间隔距离，比如说dis=1时，配合接下来i的循环，
        //会不断得到相邻2个石头堆的最优选择策略，比如说{1,2,3,4时}，会
        //得到{1,2}、{2、3}、{3、4}的最优选择策略；当dis=2时，会得到相
        //邻3个石头堆的最优选择策略，得到{1,2,3}、{2、3、4}。
        for (int dis = 1; dis < n; dis++)
            for (int i = 0; i < n - dis; i++)//i仍然表示起始位置
                dp[i][i + dis] = Math.max(piles[i] - dp[i + 1][i + dis], piles[i + dis] - dp[i][i + dis - 1]);
        return dp[0][n - 1] > 0;
    }

//    /**
//     * O(2^n) 超时
//     * @param piles
//     * @param left
//     * @param right
//     * @param aCount
//     * @param lCount
//     * @return
//     */
//    private boolean pick(int[] piles, int left, int right, int aCount, int lCount) {
//        if (left > right) {
//            return aCount > lCount;
//        }
//
//        if ((right - left) % 2 == 1) {
//            boolean pick = pick(piles, left + 1, right, aCount + piles[left], lCount);
//            if (pick) {
//                return true;
//            }
//            return pick(piles, left, right - 1, aCount + piles[right], lCount);
//        } else {
//            boolean pick = pick(piles, left + 1, right, aCount, lCount + piles[left]);
//            if (pick) {
//                return true;
//            }
//            return pick(piles, left, right - 1, aCount, lCount + piles[right]);
//        }
//    }
}
