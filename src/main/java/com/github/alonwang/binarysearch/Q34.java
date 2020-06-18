package com.github.alonwang.binarysearch;

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