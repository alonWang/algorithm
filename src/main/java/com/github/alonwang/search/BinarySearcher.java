package com.github.alonwang.search;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author alonwang
 * @date 2020/4/13 11:48 下午
 * @description
 * @detail
 */
public class BinarySearcher {

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
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            int len = ThreadLocalRandom.current().nextInt(2000);
            Integer[] arr = new Integer[len];
            for (int j = 0; j < len; j++) {
                arr[j] = j;
            }
            int randomVal = ThreadLocalRandom.current().nextInt(1500);
            int index = Arrays.stream(arr).filter(v -> v == randomVal).findAny().orElse(-1);
            int searchIndex = new BinarySearcher().search(arr, randomVal);
            assert searchIndex == index;
        }
    }
}
