package com.github.alonwang.binarysearch;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q34 {
    private static final int[] NOT_FOUND = new int[]{-1, -1};

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lastPos = findLast(0, nums.length, target, nums);
        if (lastPos == -1 || nums[lastPos] != target) {
            return NOT_FOUND;
        }
        int firstPos = findFirst(0, lastPos + 1, target, nums);
        return new int[]{firstPos, lastPos};
    }

    //最后一个小于等于给定值元素的位置
    public int findLast(int L, int R, int target, int[] nums) {
        int ans = -1;
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

    //第一个大于等于给定值的位置
    public int findFirst(int L, int R, int target, int[] nums) {
        int ans = -1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }
}