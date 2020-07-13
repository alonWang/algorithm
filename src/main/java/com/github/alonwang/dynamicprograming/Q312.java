package com.github.alonwang.dynamicprograming;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 * <p>
 * 说明:
 * <p>
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * <p>
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/7/13 11:22
 * @detail
 */
public class Q312 {

    //想办法转换为分治,子问题不相互依赖. 主要在于摆脱移除的思维,以不移除的方式处理
    public int maxCoins(int[] nums) {
        //首先  左右加上哨兵
        int[] balloons = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            balloons[i + 1] = nums[i];
        }
        int len = balloons.length;
        balloons[0] = balloons[len - 1] = 1;
        //范围(i,j)的最大值  1<=i<j<=len-2 (0和len-1都是哨兵)
        int[][] state = new int[len][len];

        //从右侧的小区间一点点扩大,计算state
        for (int left = len - 2; left > -1; left--)
            for (int right = left + 2; right < len; right++) {
                for (int i = left + 1; i < right; ++i) {
                    // 状态方程 f(i,j)=max(state[i][j],left*i*right+state[left][i]+state[i][right])

                    state[left][right] = Math.max(state[left][right],
                            balloons[left] * balloons[i] * balloons[right] + state[left][i] + state[i][right]);
                }
            }

        return state[0][len - 1];


    }
//   分治 ,思路上更为直观

    // 我懂了，应该是dp[i][k]和dp[k][j]分别代表的是不戳破i和k以及不戳破k和j时的最大值，所以当最后戳破k时，整个区间其实只剩下i,k,j三个气球而已，它们此时是相邻的，所以是nums[i][k][j]
//    /**
//     *   @Author Nyr
//     *   @Date 2019/11/30 0:23
//     *   @Param  nums:气球数组；length:数组长度，避免每层都计算一次；begin:开始下标；end:结束下标；cache:缓存，避免重复计算
//     *   @Return
//     *   @Exception
//     *   @Description 状态转移方程 def( i, j ) = max { def( i , k ) + def( k , j )+nums[ i ][ j ][ k ] } | i<k<j 的实现
//     */
//    public static int maxCoins4(int[] nums, int length, int begin, int end,int[][] cache) {
//        //回归条件，问题分解到最小子问题
//        if (begin == end - 1) {
//            return 0;
//        }
//        //缓存，避免重复计算
//        if(cache[begin][end]!=0){
//            return cache[begin][end];
//        }
//        //维护一个最大值
//        int max = 0;
//        //状态转移方程 def( i, j ) = max { def( i , k ) + def( k , j )+nums[ i ][ j ][ k ] } | i<k<j
//        for (int i = begin + 1; i < end; i++) {
//            int temp = maxCoins4(nums, length, begin, i,cache) +
//                    maxCoins4(nums, length, i, end,cache) + nums[begin] * nums[i] * nums[end];
//            if (temp > max) {
//                max = temp;
//            }
//        }
//        //缓存，避免重复计算
//        cache[begin][end]=max;
//        return max;
//    }
//
//    我们再封装一层方法，对空数组进行处理。因为 def( i , j ) 并不戳破两个边界的气球，我们为气球数组加上虚拟的边界：
//
//    public static final int maxCoins4MS(int[] nums) {
//        //空数组处理
//        if (nums == null) {
//            return maxCoin;
//        }
//        //加虚拟边界
//        int length = nums.length;
//        int[] nums2=new int[length+2];
//        System.arraycopy(nums,0,nums2,1,length);
//        nums2[0]=1;
//        nums2[length+1]=1;
//        length=nums2.length;
//        //创建缓存数组
//        int[][] cache=new int[length][length];
//        //调用分治函数
//        return maxCoins4M(nums2, length,cache);
//    }
//
//    public static int maxCoins4M(int[] nums, int length,int[][] cache) {
//        int max = maxCoins4(nums, length, 0, length - 1,cache);
//        return max;
//    }
//
//    实现很简单，一个带缓存的递归调用，我们来看一下效果，测试代码如下：
//
//    public static void main(String[] args) {
//        int[] nums = {3,4,5,6,7,5,7,8,5,3,2,5};
//        long start = System.currentTimeMillis();
//        start = System.currentTimeMillis();
//        System.out.println(maxCoins(nums));
//        System.out.println("原始回溯用时   ：   " +
//                        String.valueOf(System.currentTimeMillis() - start)+"  运算次
//                数："+sum3);
//                start = System.currentTimeMillis();
//        System.out.println(maxCoins4MS(nums));
//        System.out.println("分治用时   ：   " +
//                        String.valueOf(System.currentTimeMillis() - start)+"  运算次
//                数："+sum1+"  实际运算次数："+sum2);
//    }
//
//    作者：niu-you-rou
//    链接：https://leetcode-cn.com/problems/burst-balloons/solution/chao-xiang-xi-hui-su-dao-fen-zhi-dao-dp-by-niu-you/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
