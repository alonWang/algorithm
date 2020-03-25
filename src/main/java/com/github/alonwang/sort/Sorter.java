package com.github.alonwang.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public interface Sorter {
    void sort(Comparable[] arr);

    default void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    default String show(Comparable[] arr) {
        return Arrays.stream(arr).map(Object::toString)
                .collect(Collectors.joining(" -> ", " [ ", " ] "));

    }

    default boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0)
                return false;
        }
        return true;
    }

    default void test() {
        long startMill = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int len = ThreadLocalRandom.current().nextInt(10000);
            Comparable[] arr = new Integer[len];
            for (int j = 0; j < len; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt(10000);
            }
            String origin = show(arr);
            sort(arr);
            boolean isSorted = true;
            for (int k = 1; k < arr.length; k++) {
                if (arr[k].compareTo(arr[k - 1]) < 0) {
                    isSorted = false;
                    break;
                }
            }
            if (!isSorted) {
                System.err.println("sort failed,original arr: \n" + origin
                        + "\n sorted arr: \n" + show(arr));
                throw new IllegalStateException("Sort failed!");
            }
        }
        long gapMill = System.currentTimeMillis() - startMill;

        System.out.println("sort all success, avgSec: " + TimeUnit.MILLISECONDS.toSeconds(gapMill) / 1000.0);
    }
}
