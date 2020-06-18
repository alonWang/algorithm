package com.github.alonwang.binarysearch;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author alonwang
 * @date 2020/4/14 11:12 下午
 * @description 查找第一个值等于给定值的元素
 * @detail 相比二分排序的原始形式, 相等时, 需要在判断 当前元素是否为数组的第一个元素 or 当前元素的前一个元素是否小于当先元素
 * 满足任意一个条件查找结束,否则缩小上界.
 */
public class BinarySearcherVersion1 extends AbstractBinarySearcher {
    public int search(Comparable[] arr, Comparable target) {
        if (arr.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmpVal = target.compareTo(arr[mid]);
            if (cmpVal < 0) {
                high = mid - 1;
            } else if (cmpVal == 0) {
                if (mid == 0 || target.compareTo(arr[mid - 1]) > 0) {
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
                if (arr[j] == randomVal) {
                    index = j;
                    break;
                }
            }
            int searchIndex = search(arr, randomVal);
            assert searchIndex == index;
        });
    }
}
