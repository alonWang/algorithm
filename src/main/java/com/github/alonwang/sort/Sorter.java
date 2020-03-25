package com.github.alonwang.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public interface Sorter {
    void sort(Comparable[] arr);

    default boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

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
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    default void test() {
        for (int i = 0; i < 1000; i++) {
            int len = ThreadLocalRandom.current().nextInt(10000);
            Comparable[] arr = new Integer[len];
            for (int j = 0; j < len; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt(10000);
            }
            String origin = show(arr);
            sort(arr);
            if (!isSorted(arr)) {
                System.err.println("sort failed,original arr: \n" + origin
                        + "\n sorted arr: \n" + show(arr));
                throw new IllegalStateException("Sort failed!");
            }
        }
        System.out.println("sort all success");
    }
}
