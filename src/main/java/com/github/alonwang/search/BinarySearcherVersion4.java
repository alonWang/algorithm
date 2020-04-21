package com.github.alonwang.search;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 查找最后一个小于等于给定值的元素
 *
 * @author alonwang
 * @date 2020/4/21 11:54 下午
 * @detail
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
            if (arr[mid].compareTo(target) <= 0) {
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
