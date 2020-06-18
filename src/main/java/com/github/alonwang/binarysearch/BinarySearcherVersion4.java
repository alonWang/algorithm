package com.github.alonwang.binarysearch;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 查找最后一个小于等于给定值的元素
 *
 * @author alonwang
 * @date 2020/4/21 11:54 下午
 * @detail 以下两种情况说明mid就是最后一个小于等于给定值的元素
 * 情况1  [x,x,x,x,mid]  mid是最后一个数,mid<=target   即target大于数组中的最大值
 * 情况2  最常规的情况 mid<=target,y>target [x,x,x,x,mid,y>target,x,x,x]
 * 所以如果target>=arr[mid] 先看下mid是不是最后一个元素,
 * 再看mid后面的元素是不是大于target,满足任意一个就说明arr[mid]是最后一个小于等于给定值的元素
 */
public class BinarySearcherVersion4 extends AbstractBinarySearcher {
    @Override
    public int search(Comparable[] arr, Comparable target) {
        if (arr.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target.compareTo(arr[mid]) >= 0) {
                if (mid == arr.length - 1 || arr[mid + 1].compareTo(target) > 0) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
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
                if (arr[j] <= randomVal) {
                    index = j;

                } else {
                    break;
                }
            }
            int searchIndex = search(arr, randomVal);
            assert searchIndex == index;
        });
    }
}
