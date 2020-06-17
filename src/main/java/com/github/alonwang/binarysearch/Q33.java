package com.github.alonwang.binarysearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Q33 {
    /**
     * 二分搜索的多种形式
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n < 1)
            return -1;
        //转折点,第一个小于的下标
        int pivot = findSmallest(nums);
        //如果正好是目标值,ok,不用再查了
        if (nums[pivot] == target) {
            return pivot;
        }
        //如果在左边的区间内, 去左边找,如果不在去右边找
        if (nums[0] <= target && target <= nums[Math.max(0, pivot - 1)]) {
            return binarySearch(0, pivot, target, nums);
        } else {
            return binarySearch(pivot, n, target, nums);
        }
    }

    //二分搜索
    public int binarySearch(int L, int R, int target, int[] nums) {
        int ans = -1;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] < target) {
                L = mid + 1;
            } else if (nums[mid] > target) {
                R = mid;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }

    /**
     * 二分查找的变形: 查找第一个小于目标值的元素
     *
     * @param nums
     * @return
     */
    public int findSmallest(int[] nums) {
        int n = nums.length;

        int L = 0, R = n;
        int target = nums[0];
        int ans = 0;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (nums[mid] < target) {
                ans = mid;
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }
}