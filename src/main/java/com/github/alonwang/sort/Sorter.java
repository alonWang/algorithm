package com.github.alonwang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public interface Sorter {
    void sort(Comparable[] arr);

    String name();

    default void swap(Comparable[] a, int i, int j) {
        if (i == j) {
            return;
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    default String show(Comparable[] arr) {
        return Arrays.stream(arr).map(Object::toString)
                .collect(Collectors.joining(" -> ", " [ ", " ] "));

    }

    default void performanceTest(Comparable[]... customs) {
        long startMill = System.currentTimeMillis();
        List<Comparable[]> arrays = new ArrayList<>();
        if (customs != null) {
            arrays.addAll(Arrays.asList(customs));
        }

        for (int i = 0; i < 1000; i++) {
            int len = ThreadLocalRandom.current().nextInt(10000);
            Comparable[] arr = new Integer[len];
            for (int j = 0; j < len; j++) {
                arr[j] = ThreadLocalRandom.current().nextInt(10000);
            }
            arrays.add(arr);

        }
        arrays.forEach(arr -> {
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
        });
        long gapMill = System.currentTimeMillis() - startMill;
        System.out.println(name() + " sort all success, avgSec: " + TimeUnit.MILLISECONDS.toSeconds(gapMill) / 1000.0);
    }

    public static void main(String[] args) {
        new BubbleSorter().performanceTest();
        new InsertSorter().performanceTest();
        new SelectSorter().performanceTest();
        new MergeSorter().performanceTest();
    }
}
