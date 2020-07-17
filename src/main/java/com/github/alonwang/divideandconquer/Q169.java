package com.github.alonwang.divideandconquer;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author alonwang
 * @date 2020/7/17 9:46 下午
 * @detail
 */
public class Q169 {
    /**
     * 多数元素是一个数，数组中必须有多于一半的元素是这个数
     * 如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数
     * 如果左右数组的众数分别为 a1,a2,那么出现次数最多的就是选择出来的众数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = low + (high - low) / 2;
        //左侧数组可能比右侧数组多一个
        int left = majorityElement(nums, low, mid);
        int right = majorityElement(nums, mid + 1, high);
        if (left == right) {
            return left;
        }
        int leftCount = count(nums, left, low, mid);
        int rightCount = count(nums, right, mid + 1, high);

        return leftCount > rightCount ? left : right;
    }

    private int count(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
