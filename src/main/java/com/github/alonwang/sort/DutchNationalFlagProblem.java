package com.github.alonwang.sort;

import com.github.alonwang.util.RandomUtil;
import com.github.alonwang.util.SortUtil;

import java.util.Arrays;

/**
 * @author alonwang
 * @description 现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球，使得从左至右，依次是一些红球、一些白球、一些蓝球。
 * @date 2020/4/13 19:32
 * @detail 分别用0, 1, 2代表红, 白, 蓝.
 * 思路1 Dijkstra：上面的问题就可以抽象为: 将数组arr从前向后划分为三部分.依次为0,1,2。那么我们只要把0全部排列在左侧，2全部放在右侧，中间自然都是1了。
 * 我们需要三个指针
 * * l 指向最左侧 标识0的边界(最大下标,不包含)
 * * r 指向最右侧 标识2的边界(最小下标,不包含)
 * * p 指向最左侧 从左到右遍历的指针,用它将数组划分成三部分
 * 我们的目标是将0都放到左侧,2都放到右侧,由此自然实现1在中间的排列,要实现的目标就是arr[~l-1]都是0,arr[l,p-1]都是1,arr[r~]都是2(结束时p应该等于r)因此在遍历过程中
 * * 如果遇到0,就与l标识的元素交换,p向右移动一位,l向右移动一位 确保左侧都是0
 * * 如果遇到1,p向右移动一位  1不动
 * * 如果遇到2,就与r标识的元素交换,r向左移动一位,注意 这里p不移动,因为交换过的元素是未知的.确保右侧都是2
 * 如果p>r,结束. 注意p==r时是需要处理的,因为r是不包含的, 举个例子,上一次是遇到了2,那么交换之后,p位置的元素大小还是未知的.肯定要处理的
 * <p>
 * 思路2 桶排序: 将数组分成三个桶 0,1,2, 最后再按序放入数组即可,简单,缺点是空间复杂度O(n)
 */
public class DutchNationalFlagProblem {


    public void dijkstraSolve(Integer[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int l = 0, p = 0, r = arr.length - 1;
        while (p <= r) {
            if (arr[p] == 0) {
                SortUtil.swap(arr, l++, p++);
            } else if (arr[p] == 1) {
                p++;
                continue;
            } else {
                SortUtil.swap(arr, p, r--);
            }
        }
    }

    public void bucketSolve(Integer[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int[] buckets = new int[]{0, 0, 0};
        for (Integer num : arr) {
            buckets[num]++;
        }
        int bucket = 0;
        int i = 0;
        while (i < arr.length) {
            if (buckets[bucket]-- > 0) {
                arr[i++] = bucket;
            } else {
                bucket++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = RandomUtil.generateRandomIntArray(1000, 3);
        new DutchNationalFlagProblem().dijkstraSolve(arr);
        if (!SortUtil.isOrdered(arr, true)) {
            Arrays.stream(arr).forEach(System.out::println);
            throw new RuntimeException("error");
        }
        arr = RandomUtil.generateRandomIntArray(1000, 3);
        new DutchNationalFlagProblem().bucketSolve(arr);
        if (!SortUtil.isOrdered(arr, true)) {
            Arrays.stream(arr).forEach(System.out::println);
            throw new RuntimeException("error");
        }
    }
}
