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
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cpmVal = target.compareTo(arr[mid]);
            if (cpmVal < 0) {
                index = high;
                high = mid - 1;
            } else if (cpmVal == 0) {
                if (mid == 0 || target.compareTo(arr[mid - 1]) > 0) {
                    index = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return index;

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
