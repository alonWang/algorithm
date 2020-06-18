package com.github.alonwang.binarysearch;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (target > nums[n - 1]) {
            return n;
        } else if (target < nums[0])
            return 0;
        int pos = binarySearch(0, n, target, nums);
        return nums[pos] == target ? pos : pos + 1;


    }

    //最后一个小于等于定值的位置
    public int binarySearch(int L, int R, int target, int[] nums) {
        int ans = 0;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return ans;
    }
}