package com.github.alonwang.binarysearch;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author alonwang
 * @date 2020/4/15 19:02
 * @description 查找第一个大于等于给定值的元素
 * @detail 以下两种情况
 * 情况1 [mid,x,x,x,x,x] mid>=target 即target小于等于数组中的任意一个数
 * 情况2 [x,y,mid,x,x,x] y<target,mid>=target 最正常的情况
 * 所以在target<=arr[mid]的时候,先看下mid是不是第一个,再看下mid前面的是不是小于target
 * 满足任意一个就说明是 第一个大于等于给定值得元素
 */
public class BinarySearcherVersion3 extends AbstractBinarySearcher {
    public int search(Comparable[] arr, Comparable target) {
        if (arr.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target.compareTo(arr[mid]) <= 0) {
                if (mid == 0 || arr[mid - 1].compareTo(target) < 0) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }

    @Override
    protected void doValidate(List<Integer[]> arrs) {
        arrs.forEach(arr -> {
            int randomVal = ThreadLocalRandom.current().nextInt(1500);
            int index = -1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] >= randomVal) {
                    index = j;
                    break;
                }
            }
            int searchIndex = search(arr, randomVal);
            assert searchIndex == index;
        });
    }

}
