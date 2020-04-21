package com.github.alonwang.search;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author alonwang
 * @date 2020/4/15 19:02
 * @description 查找第一个大于等于给定值的元素
 * @detail
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
            if (arr[mid].compareTo(target) >= 0) {
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
