package com.github.alonwang.problem;

import com.github.alonwang.util.RandomUtil;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import cn.hutool.core.util.ArrayUtil;

/**
 * 时间复杂度
 * T(n) = n+ T(n/2)
 * T(1) = C
 * ==>
 * T(n) = n + n/2 + n/4 + ... + n/2^k +T(n/2^(k+1))
 * <p>
 * T(n) ~= 2n = O(n)
 */
public class FindKthMinElementInUnorderedArray {
    public int findKth(Integer[] arr, int kth) {
        if (kth > arr.length) {
            return -1;
        }
        final int targetPos = kth - 1;
        int pos = -1;
        int low = 0;
        int high = arr.length;
        while (true) {
            pos = partition(arr, low, high);
            if (pos < targetPos) {
                low = pos + 1;
            } else if (pos > targetPos) {
                high = pos;
            } else {
                return arr[pos];
            }
        }

    }

    public int partition(Integer[] arr, int low, int high) {
        int guard = arr[high - 1];
        int i = low;
        for (int j = low; j < high - 1; j++) {
            if (arr[j] <= guard) {
                ArrayUtil.swap(arr, i++, j);
            }
        }
        ArrayUtil.swap(arr, i, high - 1);
        return i;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Integer[] arr = RandomUtil.generateRandomIntArray();
            int kth = ThreadLocalRandom.current().nextInt(arr.length) + 1;
            Integer[] copy = Arrays.copyOf(arr, arr.length);
            int calculateKthValue = new FindKthMinElementInUnorderedArray().findKth(arr, kth);
            System.out.println(String.format("calculate %s the %s smallest value %s", Arrays.stream(copy).map(String::valueOf).collect(Collectors.joining(",", "[", "]")), kth, calculateKthValue));
            Arrays.sort(copy);
            int kthValue = copy[kth - 1];
            if (kthValue != calculateKthValue) {
                throw new IllegalStateException("calculate the kth smallest value error");
            }
        }

    }
}
